package com.ecdragon.challenge_39814.features.crossing_paths;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A non-empty zero-indexed array ​A​ consisting of N​ ​ integers is given. 
 * The elements of array ​A represent hikers traveling either up or down a trail.<br><br>
 * Array A contains only 0s and/or 1s:<br>
 * <li>0 represents a hiker going up the trail.</li>
 * <li>1 represents a hiker going down the trail.</li><br>
 * 
 * We want to know how many times a pair of hikers will cross paths on the trail.<br><br>
 * 
 * For example, consider array A such that:<br>
 * A[0] = 0 <br>
 * A[1] = 1 <br>
 * A[2] = 0 <br>
 * A[3] = 1 <br>
 * A[4] = 1 <br><br>
 * 
 * We have five pairs of hikers crossing paths:<br>
 *  (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).<br><br>
 *  
 * Write a function called ​solution​ in your preferred language that takes the 
 * integer array A as an argument and returns the total number of crossing pairs as an int.<br><br>
 * 
 * The function should return −1 if the number of pairs of crossing exceeds 1,000,000,000. Assume that:<br>
 * <li>N​ is an integer within the range [1..100,000];</li>
 * <li>Each element of array ​A​ is an integer that has the values 0 or 1.</li><br>
 * 
 * Complexity:<br>
 * <li>expected worst-case time complexity is O(N); </li>
 * <li>expected worst-case space complexity is:<br>
 * (storage required for reading in arguments) + O(1)</li> <br>
 * Elements of input arrays can be modified.
 */
public class CrossingPaths {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static int solution(int[] a) {
		
		int numUpHikers = 0;
		long crossingPairs = 0;
		
		for (int i : a) {
			if (i == 0) {
				numUpHikers++;
			}
			else if (i == 1) {
				crossingPairs += numUpHikers;
				if (crossingPairs > 1000000000) {
					logger.error("Too many crossing pairs. Num crossing pairs now: " + crossingPairs);
					return -1;
				}
			}
		}
		
		logger.debug("crossingPairs: " + crossingPairs);
		
		return (int)crossingPairs;
	}
}
