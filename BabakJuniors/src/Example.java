import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Example {
	private DefaultListModel<TrainingExample> trainingExamples;
	private ArrayList<TrainingExample> trainingExamplesModel;
	private DefaultListModel<TestingExample> testingExamples;
	private ArrayList<String> type;
	//ArrayList<ArrayList<String>>rank;
	private ArrayList<Rank> rank;
	//ArrayList<String>rank;//Rank for subjective features

	public Example() {
		trainingExamples = new DefaultListModel<TrainingExample>();
		trainingExamplesModel = new ArrayList<TrainingExample>();
		testingExamples = new DefaultListModel<TestingExample>();
		type = new ArrayList<String>();
		rank = new ArrayList<Rank>();
	}

	public void addTrainingExample(TrainingExample example) {
		trainingExamples.addElement(example);
		trainingExamplesModel.add(example);
		//?abstractkey(example);
	}

	public DefaultListModel<TrainingExample> getTrainingExamples() {
		return trainingExamples;
	}
	
	public DefaultListModel<TrainingExample> getTrainingExample(){
		return trainingExamples;
	}
	
	public ArrayList<TrainingExample> getTrainingExamplesModel(){
		return trainingExamplesModel;
	}
	public void addTestingExample(TestingExample example) {
		testingExamples.addElement(example);
	}

	public DefaultListModel<TestingExample> getTestingExample() {
		return testingExamples;
	}
//createFeatureType
//checkFeatureType
	public void abstractkey(TrainingExample example) {
		for (int i = 0; i < example.getNameSet().size(); i++) {
			if (!type.contains(example.getNameSet().get(i))) {
				if (checkSubjective(example.getFeature(example.getNameSet().get(i)))) {
					type.add(example.getNameSet().get(i));
				} else
					type.add(example.getNameSet().get(i));
			} // else print error message that there is exist name;

			/*
			 * if(type.isEmpty()){
			 * if(checkSubjective(example.getFeature(example.getNameSet().get(i)
			 * ))){ //rank.add(example.getNameSet().get(i));
			 * type.add(example.getNameSet().get(i)); }else
			 * type.add(example.getNameSet().get(i)); }else
			 * if(!type.contains(example.getNameSet().get(i))){
			 * if(checkSubjective(example.getFeature(example.getNameSet().get(i)
			 * ))){ type.add(example.getNameSet().get(i)); }else
			 * type.add(example.getNameSet().get(i)); }
			 */// else print error message that there is exist name;
		}
	}

	public void createFeatureType(String featureName, Feature feature) {
		boolean flag = true;
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i).checkName(featureName)) {
				flag = false;
			}
		}
		if (flag) {
			rank.add(new Rank(featureName, feature));
		} else {
			System.out.println("There is existing feature Name");
		}
	}
	
	

	public void appendRank(String featureName, Feature feature) {
		// boolean go to ranking featureName.add(feature.getStringValue)
		for(int i = 0; i< rank.size() ;i++){
			if(rank.get(i).checkName(featureName)){
				if(!rank.get(i).getlist().contains(feature)){
					rank.get(i).getlist().add(feature);
				}
			}
		}
	}
	public Rank getRankingList(String fName){
		for(Rank r: rank) {
			if(fName == r.getName())
				return r;
		}
		return null;
	}
	
	public boolean checkSubjective(Feature feature) {
		if (feature.getStringValue() != null)
			return true;
		else
			return false;
	}
	
	public boolean checkAbsolute(Feature feature) {
		if (feature.getNumValue()!=null)
			return true;
		else
			return false;
	}
	
	public boolean checkEuclidean(Feature feature) {
		if (feature.getCorX()!=null && feature.getCorY()!=null)
			return true;
		else
			return false;
	}
	
	public String toString(){
		String toString = "";
		
		for(int i =0;i<trainingExamples.size();i++){
			toString += trainingExamples.get(i).getExampleName()+": " +trainingExamples.get(i).toString();
					//toString();
		}
		for(int i =0;i<testingExamples.size();i++){
			toString += testingExamples.get(i).getExampleName()+": " +testingExamples.get(i).toString();
		}
		return toString;
	}
	
	public TrainingExample getTrainingExampleIndex(int i) {
		
		return trainingExamples.getElementAt(i);
		/*
		if (i >= 0 && i < trainingExamples.size()) {
			return trainingExamples.getElementAt(i);
		}else return null;*/
	}
	
	/**
	 * Create a copy of a training example
	 * delete that training example from training examples
	 * create a testing example from training example
	 * (create new constructor for testing example which accepts a training example as parameter and copies its feature map)
	 * create a copy of a feature
	 * then delete that feature
	 * then predict that feature
	 * then calculate error on the difference
	 */
	public void calculateError() {
		
		
	}
	
	
	
	
	
}
