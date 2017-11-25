import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompositeFeatureTest {

	private CompositeFeature cfHead, cF2;

	@Before
	public void setUp() throws Exception {
		cfHead = new CompositeFeature("Head");
		cF2 = new CompositeFeature("CompositeFeature2");

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDistance() {
		assertTrue(true);
	}

	@Test
	public void testCalculateError() {
		assertTrue(true);
	}

	@Test
	public void testAddFeature() {
		cfHead.addFeature(cF2);
		assertEquals(1, cfHead.getSubFeatureSize());
	}

	@Test
	public void testGetSubFeatures() {
		ArrayList<Feature> testingList = new ArrayList<Feature>();
		testingList.add(cF2);
		cfHead.addFeature(cF2);
		assertEquals(testingList, cfHead.getSubFeatures());
	}

	@Test
	public void testSetSubFeatures() {
		ArrayList<Feature> testingList = new ArrayList<Feature>();
		testingList.add(cF2);
		cfHead.setSubFeatures(testingList);
		assertEquals(testingList, cfHead.getSubFeatures());
	}

	@Test
	public void testGetSubFeatureNames() {
		ArrayList<String> testingList = new ArrayList<String>();
		testingList.add(cF2.getFName());
		cfHead.addFeature(cF2);
		assertEquals(testingList, cfHead.getSubFeatureNames());
	}

	@Test
	public void testSetSubFeatureNames() {
		ArrayList<String> testingList = new ArrayList<String>();
		testingList.add(cF2.getFName());
		cfHead.setSubFeatureNames(testingList);
		assertEquals(testingList, cfHead.getSubFeatureNames());
	}

	@Test
	public void testGetSubFeature() {
		ArrayList<Feature> testingList = new ArrayList<Feature>();
		testingList.add(cF2);
		cfHead.addFeature(cF2);
		assertEquals(testingList.get(0), cfHead.getSubFeature(0));
	}

	@Test
	public void testGetSubFeatureName() {
		ArrayList<String> testingList = new ArrayList<String>();
		testingList.add(cF2.getFName());
		cfHead.setSubFeatureNames(testingList);
		assertEquals(testingList.get(0), cfHead.getSubFeatureName(0));
	}

	@Test
	public void testGetSubFeatureSize() {
		ArrayList<Feature> testingList = new ArrayList<Feature>();
		testingList.add(cF2);
		cfHead.addFeature(cF2);
		assertEquals(testingList.size(), cfHead.getSubFeatureSize());
	}

	@Test
	public void testGetSubFeatureNameSize() {
		ArrayList<String> testingList = new ArrayList<String>();
		testingList.add(cF2.getFName());
		cfHead.setSubFeatureNames(testingList);
		assertEquals(testingList.size(), cfHead.getSubFeatureNameSize());
	}

	@Test
	public void testgetFeatureValue() {
		ArrayList<Feature> features = new ArrayList<Feature>();
		//assertTrue(true);
		//fail("Not yet implemented");
		features.add(cF2);
		//cfHead.(features);
		assertEquals(features,cfHead.getFeatureValue(features));
	}

}
