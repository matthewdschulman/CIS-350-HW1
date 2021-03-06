package edu.upenn.cis350.hwk1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class BestRatioQuery {

	public static void bestRatioQuery(HashMap<String, Double> courseRatios, 
			int numOfCoursesToReturn) {
		// iterate through the course ratios mapping from lowest to highest
		// to return the five most attractive course ratios
		for (String course: courseRatios.keySet()) {
			numOfCoursesToReturn--;
			System.out.println(course + ": " + courseRatios.get(course));
			if (numOfCoursesToReturn == 0) {
				return;
			}
		}
	}

}
