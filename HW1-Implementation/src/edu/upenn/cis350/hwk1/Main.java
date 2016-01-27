package edu.upenn.cis350.hwk1;

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
	}
}
