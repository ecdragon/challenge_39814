package com.ecdragon.challenge_39814.features.road_work_project;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A construction company is paving a road and the township wants to know when the work
 * will be done. The road has ​X​ segments to be paved.<br><br>
 * 
 * The project will be completed when all the segments (array "A" values) up to and including ​X ​are complete.<br><br>
 * 
 * The goal is to find the earliest month that the project can be completed.<br><br>
 * 
 * Example:<br>
 * For example, you are given integer ​X = 5​ and array ​A​ such that:<br>
 *   A[0] = 5 // in month 0 the contractor can pave segment 5 <br>
 *   A[1] = 3 // in month 1 the contractor can pave segment 3 <br>
 *   A[2] = 4 // in month 2 the contractor can pave segment 4 <br>
 *   A[3] = 4 // in month 3 the contractor can pave segment 4 <br>
 *   A[4] = 2 // in month 4 the contractor can pave segment 2 <br>
 *   A[5] = 3 // in month 5 the contractor can pave segment 3 <br>
 *   A[6] = 1 // in month 6 the contractor can pave segment 1 <br>
 *   A[7] = 4 // in month 7 the contractor can pave segment 4<br>
 * In this example, the correct answer to the earliest month that the contractor can finish 
 *   paving all 5​ segments of the road is month 6<br>
 * 
 * Given a non-empty zero-indexed array ​A​ consisting of ​N​ integers and integer ​X​, 
 *   write a function in your preferred language that returns the earliest time the contractor can finish paving the road.<br><br>
 *   
 * If the contractor will never be able to completely pave the road, the function should return −1.<br><br>
 * 
 * For example, given ​X​ = 5 and array ​A​ such that: <br>
 *   A[0] = 5<br>
 *   A[1] = 3<br>
 *   A[2] = 4<br>
 *   A[3] = 4<br>
 *   A[4] = 2<br>
 *   A[5] = 3<br>
 *   A[6] = 1<br>
 *   A[7] = 4<br>
 * the function should return 6, as explained above.<br><br>
 * 
 * Assume that:<br>
 *   N​ and ​X​ are integers within the range [1..100,000];<br>
 *   each element of array ​A​ is an integer within the range [1..​X​].<br><br>
 *   
 * Complexity:<br>
 *   expected worst-case time complexity is: O(N) <br>
 *   expected worst-case space complexity is:<br>
 *     (storage required for reading in arguments) + O(X) <br><br>
 *     
 * Elements of the input array can be modified.
 */
public class RoadWorkProject {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * A​ is a zero-indexed integer array of length ​N ​that provides work estimates for the project.
	 * 
	 * The index of ​A​ represents the months since the project began.
	 * The values of ​A​ represent the segment of the road that can be completed that month. 
	 */
	private List<Integer> a;
	
	/**
	 * X is the number of segments to be paved
	 */
	private Integer x;
	
	/**
	 * This has an entry for each segment that needs to be completed. 
	 * Each segment is to be removed from this set until it's empty, which represents when the project is done
	 */
	private TreeSet<Integer> segmentCheckSet;
	
	/**
	 * What if we made a set that represented the segments left to do,
	 * and removed them one at a time, iterating through A.
	 * After each iteration, check the set to see if any are left. 
	 * If not, we're done
	 */
	public Integer findFinishMonth() {
		
		String methodLabel = "In findFinishMonth(): ";
		
		if (x == null) {
			logger.error(methodLabel + "Null X. Returning null.");
			return null;
		}
		if (a == null) {
			logger.error(methodLabel + "Null A. Returning null.");
			return null;
		}
		
		// Initialize Segment check set with one entry for each segment from 1 to X
		logger.debug(methodLabel + "Initializing segment check set");
		initializeSegmentCheckSet();
		
		// Store a completion month, to be populated only if we complete the project
		Integer completionMonth = -1;
		
		// Iterate over a array. 
//		for (Integer aEntry : a) {
		logger.debug(methodLabel + "Iterating over a list");
		for (int i = 0; i < a.size(); i++) {
			
			Integer aEntry = a.get(i);
			
			// Remove this month's segment from the segment check set
			segmentCheckSet.remove(aEntry);
			
			// If the check set is empty, we are done
			if (segmentCheckSet.size() == 0) {
				completionMonth = i;
				break;
			}
		}
		
		logger.debug(methodLabel + "Finished. completion month: " + completionMonth);
		
		return completionMonth;
	}
	
	public void initializeSegmentCheckSet() {
		for (int i = 1; i <= x; i++) {
			addSegmentToSegmentCheckSet(i);
		}
	}

	public void appendToA(Integer segmentToAdd) {
		if (this.a == null) {
			a = new ArrayList<>();
		}
		a.add(segmentToAdd);
	}
	public List<Integer> getA() {
		return a;
	}
	public void setA(List<Integer> a) {
		this.a = a;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public void addSegmentToSegmentCheckSet(Integer segmentToAdd) {
		if (segmentToAdd == null) {
			return;
		}
		if (segmentCheckSet == null) {
			segmentCheckSet = new TreeSet<>();
		}
		segmentCheckSet.add(segmentToAdd);
	}
	public TreeSet<Integer> getSegmentCheckSet() {
		return segmentCheckSet;
	}
	public void setSegmentCheckSet(TreeSet<Integer> segmentCheckSet) {
		this.segmentCheckSet = segmentCheckSet;
	}
}
