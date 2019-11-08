package com.ecdragon.challenge_39814.features.crossing_paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CrossingPathsTests {

	@Test
	public void test0() {
		int solution = CrossingPaths.solution(new int[] {0});
		assertEquals(0, solution, "Solution should be 0. Only one hiker.");
	}
	
	@Test
	public void test1() {
		int solution = CrossingPaths.solution(new int[] {1});
		assertEquals(0, solution, "Solution should be 0. Only one hiker.");
	}
	
	@Test
	public void test01() {
		int solution = CrossingPaths.solution(new int[] {0, 1});
		assertEquals(1, solution, "Solution should be 1. Two hikers should cross.");
	}
	
	@Test
	public void testExample() {
		int solution = CrossingPaths.solution(new int[] {0, 1, 0, 1, 1});
		assertEquals(5, solution, "Solution should be 5. Example from the instructions.");
	}
	
	@Test
	public void test11110000() {
		int solution = CrossingPaths.solution(new int[] {1, 1, 1, 1, 0, 0, 0, 0});
		assertEquals(0, solution, "Solution should be 0. Lots of hikers, no crosses.");
	}
	
	@Test
	public void test00001111() {
		int solution = CrossingPaths.solution(new int[] {0, 0, 0, 0, 1, 1, 1, 1});
		assertEquals(16, solution, "Solution should be 16. 8 hikers, all crosses.");
	}
	
	@Test
	public void test50000_1() {
		int[] input = new int[50001];
		input[50000] = 1;
		int solution = CrossingPaths.solution(input);
		assertEquals(50000, solution, "Solution should be 50000. 50001 hikers, 1 down at end.");
	}
	
	@Test
	public void testABillion() {
		int[] input = new int[70000];
		for (int i = 50000; i < 70000; i++) {
			input[i] = 1;
		}
		input[50000] = 1;
		int solution = CrossingPaths.solution(input);
		assertEquals(1000000000, solution, "Solution should be 1000000000. 1-50000 0, 50001-70000 1");
	}
	
	@Test
	public void testBlowItUp() {
		int[] input = new int[70001];
		for (int i = 50000; i < 70001; i++) {
			input[i] = 1;
		}
		int solution = CrossingPaths.solution(input);
		assertEquals(-1, solution, "Solution should be -1. Should have blown up.");
	}
	
	@Test
	public void testBlowItUpJustOver() {
		int[] input = new int[70001];
		for (int i = 50001; i < 70001; i++) {
			input[i] = 1;
		}
		input[1] = 1;
		int solution = CrossingPaths.solution(input);
		assertEquals(-1, solution, "Solution should be -1. Should have blown up.");
	}
	
	@Test
	public void testMaxInput() {
		int[] input = new int[100000];
		for (int i = 50000; i < 100000; i++) {
			input[i] = 1;
		}
		int solution = CrossingPaths.solution(input);
		assertEquals(-1, solution, "Solution should be -1. Should have blown up.");
	}
}
