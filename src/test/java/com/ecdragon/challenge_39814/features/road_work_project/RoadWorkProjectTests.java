package com.ecdragon.challenge_39814.features.road_work_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoadWorkProjectTests {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test
	public void testNoInput() {
//		logger.info("Testing!");
		RoadWorkProject roadWorkProject = new RoadWorkProject();
		Integer completionMonth = roadWorkProject.findFinishMonth();
		assertNull(completionMonth, "Completion month should be null, since nothing input");
	}
	
	@Test
	public void testMissingAInput() {
		RoadWorkProject roadWorkProject = new RoadWorkProject();
		roadWorkProject.setX(5);
		Integer completionMonth = roadWorkProject.findFinishMonth();
		assertNull(completionMonth, "Completion month should be null, since no A input");
	}
	
	@Test
	public void testMissingXInput() {
		RoadWorkProject roadWorkProject = new RoadWorkProject();
		roadWorkProject.appendToA(5);
		Integer completionMonth = roadWorkProject.findFinishMonth();
		assertNull(completionMonth, "Completion month should be null, since no X input");
	}
	
	@Test
	public void test_A1Entry_X5() {
		RoadWorkProject roadWorkProject = new RoadWorkProject();
		roadWorkProject.appendToA(4);
		roadWorkProject.setX(5);
		Integer completionMonth = roadWorkProject.findFinishMonth();
		assertEquals(-1, completionMonth, "Completion month should be -1, valid inputs but no way for this project to complete");
	}
	
	@Test
	public void test_A1Entry_X1() {
		RoadWorkProject roadWorkProject = new RoadWorkProject();
		roadWorkProject.appendToA(1);
		roadWorkProject.setX(1);
		Integer completionMonth = roadWorkProject.findFinishMonth();
		assertEquals(0, completionMonth, "Completion month should be 0");
	}
	
	@Test
	public void test_A4Entry_X1() {
		RoadWorkProject roadWorkProject = new RoadWorkProject();
		roadWorkProject.appendToA(4);
		roadWorkProject.setX(1);
		Integer completionMonth = roadWorkProject.findFinishMonth();
		assertEquals(-1, completionMonth, "Completion month should be -1, A 4, X 1");
	}
	
	@Test
	public void test_A53442314Entry_X5() {
		RoadWorkProject roadWorkProject = new RoadWorkProject();
		roadWorkProject.setA(Arrays.asList(5, 3, 4, 4, 2, 3, 1, 4));
		roadWorkProject.setX(5);
		Integer completionMonth = roadWorkProject.findFinishMonth();
		assertEquals(6, completionMonth, "Completion month should be 6");
	}
}
