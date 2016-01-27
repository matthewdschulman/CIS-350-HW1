package edu.upenn.cis350.hwk1;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class InstructorQuery {
	public static void instructorQuery(HashMap<String, TreeSet<String>> profToCourses, PrintWriter logWriter) {
		Scanner input = new Scanner(System.in);
		String prompt = "Please enter an instructor name. Partial matches are okay, and the "
				+ "search is case-insensitive.\nE.g. �osera�, �OSERA�, �Peter�, "
				+ "and even �ael S.� should all result in a match for PETER-MICHAEL S. OSERA.";
	    System.out.println(prompt);
	    
	    String userInput = input.next();
	    
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
			.format(Calendar.getInstance().getTime());
		logWriter.print("Time: " + timeStamp + " | ");
		logWriter.println("User's instructor search term is " + userInput);
	    
	    // Make the query case insensitive
	    userInput = userInput.toUpperCase();
	    
	    // Save the matches for the printing
	    TreeMap<String, TreeSet<String>> instructorMatches = 
	    	new TreeMap<String, TreeSet<String>>();
	    
	    // Iterate through the prof to courses mappings to find the matches
	    for (String prof : profToCourses.keySet()) {
	    	// check if the current prof contains the query search
	    	if (prof.toUpperCase().contains(userInput)) {
	    		// A match!
	    		instructorMatches.put(prof, profToCourses.get(prof));
	    	}
	    }
	    
	    // Print the findings
    	// for each professor that matched, print the prof's name and his courses
    	boolean firstCourse = true;
    	for (String prof : instructorMatches.keySet()) {
    		System.out.print(prof + ": ");
    		for (String course : instructorMatches.get(prof)) {
    			if (firstCourse) {
    				firstCourse = false;
    				System.out.print(course);
    			} else {
    				System.out.print(", " + course);
    			}	    			
    		}
    		// Print a new line before the next professor
    		System.out.println("");
    		firstCourse = true;
    	}    		  
	}
}
