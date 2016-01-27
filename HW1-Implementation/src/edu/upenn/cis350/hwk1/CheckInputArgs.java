package edu.upenn.cis350.hwk1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CheckInputArgs {
	//returns true if the input arguments are valid
	//raises the corresponding exception if the input arguments are invalid
	public static boolean checkInputArgs(String[] args) {
		// Check if incorrect number of args
		if (args.length != 2) {
			System.out.println("Incorrect number of args. You entered " + 
					args.length + " arguments. Please try again.");
			throw new IllegalArgumentException();
		}

		String courseEvalFile = args[0];
		String logFileName = args[1];
		
		// Check if the specified data file exists		
		File f = new File(courseEvalFile);
		if(!f.exists() || f.isDirectory()) { 
			System.out.println("Tried to open " + courseEvalFile + " for the course "
					+ "evaluation file and couldn't open the file properly. "
					+ "Please try again");
			throw new IllegalArgumentException();
		}
				
		// Check if the log file can be opened for writing 
		// (is it in a read-only directory?)
		File logF = new File(logFileName);
		try {
		    //create a new file if it doesn't exist already
            logF.createNewFile();
		} catch (IOException e) {
			System.out.println("Can't write to the log file because the directory is "
            		+ "likely read only. Try writing to a log file in a different "
            		+ "directory that is not read only.");
		    e.printStackTrace();
		}
        
		//no exceptions raised, the input arguments are valid
		return true;
	}
}
