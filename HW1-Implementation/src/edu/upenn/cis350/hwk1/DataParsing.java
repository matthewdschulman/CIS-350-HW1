package edu.upenn.cis350.hwk1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DataParsing {

	public static HashMap<String, HashSet<String>> getProfToCourses(
			File courseEvalFile) throws IOException {
		// Set up the return data structure
		HashMap<String, HashSet<String>> profToCourses = 
				new HashMap<String, HashSet<String>>();
		
		// Read through the file and create mappings for each prof
		// to the courses that he teaches
		try {
			BufferedReader br = new BufferedReader(new FileReader(courseEvalFile));
			String line;
		    while ((line = br.readLine()) != null) {
		        String[] curLine = line.split(",");
		        String curProf = curLine[1];
		        // check if the current prof already has been assigned courses
		        HashSet<String> curSetOfClasses = null;
		        if (profToCourses.get(curProf) == null) {
		        	curSetOfClasses = new HashSet<String>();
		        } else {
		        	curSetOfClasses = profToCourses.get(curProf);
		        }
		        curSetOfClasses.add(curLine[0]);
	        	profToCourses.put(curProf, curSetOfClasses);
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// return the professor to course mapping
		return profToCourses;
	}

}
