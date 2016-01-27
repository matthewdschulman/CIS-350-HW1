package edu.upenn.cis350.hwk1;

import java.util.LinkedList;

public class Main {	
	// Two user args are 1) the course evaluation file name and 
	// 2) the log file name for debugging purposes
	// The user should not have to enter any information
	// 
	// An error message will be displayed if 
	// 1) there are an incorrect number of args
	// 2) the specified data file doesn't exist
	// 3) the log file can't be opened for writing (because it is in a 
	// read only directory)
	//
	// Assumptions: 
	// 1) the input file is well-formed (assuming it exists
	// and can be opened)
	// 2) the log file is by default written to the working directory
	public static void main(String[] args) {
    	System.out.println("Welcome to the Schulman Searcher!"); 	

		// Check that the input args are all valid
	    boolean inputArgsAreValid = 
	    	CheckInputArgs.checkInputArgs(args);
	    
	    String courseEvalFileName = "";
	    String logFileName = "";
	    if (inputArgsAreValid) {
	    	courseEvalFileName = args[0];
	    	logFileName = args[1];
	    }

		// While the User hasn't asked to quit, ask User to either 
		// 1) Find all courses taught by a specified instructor 
		// 2) Find the top five courses with the lowest difficulty-to-quality ratio across all
		// offerings 
		// 3) Find all courses at or above a specified quality rating across all offerings 
		// 4) Quit the program
		while (true) {
			String userResponse = GetUserCommand.getUserCommand();
			
			if (userResponse.equals("I")) {
				// Handle finding all courses taught by a specified professor
				LinkedList<String> profSpecificCourses = InstructorQuery.instructorQuery();
				
			} else if (userResponse.equals("R")) {
				// Handle finding the top five courses with the lowest difficulty-to-quality 
				// ratio across all offerings
				LinkedList<String> bestRatioCourses = BestRatioQuery.bestRatioQuery();

			} else if (userResponse.equals("Q")) {
				// Handle finding all courses at or above a specified rating across 
				// all offerings
				LinkedList<String> highQualityCourses = HighQualityQuery.highQualityQuery();

			} else if (userResponse.equals("E")) {
				System.out.println("Thank you for using the Schulman Searcher! Goodbye!");
			}
			
		}

		
	}
}
