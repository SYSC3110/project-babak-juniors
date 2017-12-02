import java.util.ArrayList;
import java.util.HashMap;


/**
 * 
 * @author Babak Juniorss
 * @Purpose: inherits all the features from the training example and utilizes
 *           the the distance class to predict a certain feature compared to
 *           Training Example
 *
 * @field variables - distance Distance: an instance of distance class to update
 *        the distances - feature Feature: an instance of feature class to use
 *        it to add it to the testing example - knn KNN: an instance of KNN
 *        class to use it to add it to the testing example - k int : put the k
 *        value into the testing example withing the KNN class - exampleManager
 *        Example: instance of Example to get the list of the training example
 *        methods and used for ranking
 *        
 * @methods +getDistances: returns the distances +getExample: returns the
 *          exampleManager getK: returns the k value setK: changes the k value
 *          predictFeature: Feature :predicts the feature depending on the type
 *          of the feature and changes the feature in the list of testing
 *          example
 */

public class TestingExample extends TrainingExample {
	private Distance distances;
	private KNN knn;
	private ArrayList<Feature> linearizedFeaturestest;
	//private ArrayList<Feature> linearizedFeatures;
	public TestingExample(String name, Example eM) {
		super(name, eM);
		//linearizedFeatures =new ArrayList<Feature>();
		distances = new Distance(this);
		linearizedFeaturestest =new ArrayList<Feature>();
		knn=new KNN(0, this);
	}
	
	/**
	 * Constructor to create copy of training example
	 * @param testEx
	 */
	public CompositeFeature addStringFeature(String fName,String value,CompositeFeature  currentFeature) {
		StringFeature sFeature = new StringFeature(fName,value);
		linearizedFeaturestest.add(sFeature);
		currentFeature.addFeature(sFeature);
		return currentFeature;
	}
	//2
	public CompositeFeature addFloatFeature(String fName,Float value,CompositeFeature currentFeature) {
		FloatFeature fFeature = new FloatFeature(fName,value);
		linearizedFeaturestest.add(fFeature);

		currentFeature.addFeature(fFeature);
		return currentFeature;
	}
	//
	//3
	public CompositeFeature addCompositeFeature(String compositeName,CompositeFeature currentFeature) {
		CompositeFeature comp = new CompositeFeature(compositeName);
		linearizedFeaturestest.add(comp);

		currentFeature.addFeature(comp);
		return currentFeature;
	}
	public Example getManager() {
		return super.getManager();
	}
	
	/**
	 * Constructor to create copy of training example
	 * @param testEx
	 */
	public Distance getDistances() {
		return distances;
	}
	public void setLini(ArrayList<Feature> t) {
		linearizedFeaturestest = t;
	}
	/**
	 * Constructor to create copy of training example
	 * @param testEx
	 */
	public KNN getKNN() {
		return knn;
	}
	
	public ArrayList<Feature> linearizeFeatures(){
		return linearizedFeaturestest;
	}
	/**
	 * 
	 * PredictFeature
	 * 
	 * @param f
	 * 
	 *            Returns a feature and predicted value based on parameters
	 */
	
	public Feature predictFeature(Feature f, int k, HashMap<String, String> metrics) {
		distances.updateDistances(metrics);
		
		knn = new KNN(k, this);
		knn.determineNearestNeighbors(k, getManager().getTrainingExamplesModel());
		Feature testies = f.predictFeature(knn.getNN());
		return testies;
	}
	/**
	 * Calculate error
	 * 
	 * @return a float representing the error percentage
	 * 
	 *Calculate error will call predict feature on a feature that has a known value
	 *it will then
	 */
	public Float calculateError(Feature f, int k, HashMap<String, String> metrics) {
		String sreal ="";
		Float freal=(float)0;
		Float creal= (float)0;
		if (f instanceof FloatFeature) {
			freal=((FloatFeature)f).getValue();
			return (freal-((FloatFeature)predictFeature( f,  k,  metrics)).getValue())/freal;
		}
		else if(f instanceof StringFeature) {
			sreal=((StringFeature)f).getFValue();
			if(((StringFeature)predictFeature( f,  k,  metrics)).getFValue().equals(sreal))
				return (float)0;
			return (float)100;
		}
		//for each float feature in composite feature add 
		else if(f instanceof CompositeFeature) {
			for(Feature feat: ((CompositeFeature)f).getSubFeatures()){
				if(feat instanceof FloatFeature) {
					creal=((FloatFeature)feat).getValue();
					for(Feature featy:((CompositeFeature)predictFeature( f,  k,  metrics)).getSubFeatures()) {
						if( featy instanceof FloatFeature) {
							return (creal-((FloatFeature)featy).getValue())/creal;

						 }
					}
				}
			}
		}
		return (float)1.01;//if returning this then an error occured
	}

}