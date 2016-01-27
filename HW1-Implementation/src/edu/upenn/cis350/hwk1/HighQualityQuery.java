package edu.upenn.cis350.hwk1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class HighQualityQuery {

	public static void highQualityQuery(HashMap<String, Double> courseQualityMappings) {
		Scanner input = new Scanner(System.in);
		String prompt = "Enter a course quality threshold value. All courses with quality"
				+ "scores above this value will be displayed.\n";
	    System.out.println(prompt);
	    
	    String userInput = "";
	    Double userThreshold = 4.0;
	  
	    while ((userInput = input.next()) != "") {
	    	try {  
	    	    userThreshold = Double.parseDouble(userInput);  
	    	    break;
	    	} catch(NumberFormatException nfe) {  
	    	    System.out.println(userInput + " is not a valid number. Please try again.");  
	    	}
	    }
		
		// iterate through the course ratios mapping from lowest to highest
		// to return the five most attractive course ratios above the user's threshold
	    int numOfCoursesShown = 0;
		for (String course: courseQualityMappings.keySet()) {	
			Double curQualityScore = courseQualityMappings.get(course);
			if (curQualityScore < userThreshold) {
				if (numOfCoursesShown == 0) {
					System.out.println("There were no courses with a quality score "
							+ "above " + userInput);
				}
				return;
			} else {
				numOfCoursesShown++;
				System.out.println(course + ": " + courseQualityMappings.get(course));
			}
		}
	}

}
