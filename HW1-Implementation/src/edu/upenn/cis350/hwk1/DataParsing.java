package edu.upenn.cis350.hwk1;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.RowFilter.Entry;
import javax.swing.text.html.HTMLDocument.Iterator;

public class DataParsing {

	public static HashMap<String, TreeSet<String>> getProfToCourses(
			File courseEvalFile) throws IOException {
		// Set up the return data structure
		HashMap<String, TreeSet<String>> profToCourses = 
				new HashMap<String, TreeSet<String>>();
		
		// Read through the file and create mappings for each prof
		// to the courses that he teaches
		try {
			BufferedReader br = new BufferedReader(new FileReader(courseEvalFile));
			String line;
		    while ((line = br.readLine()) != null) {
		        String[] curLine = line.split(",");
		        String curProf = curLine[1];
		        // check if the current prof already has been assigned courses
		        TreeSet<String> curSetOfClasses = null;
		        if (profToCourses.get(curProf) == null) {
		        	curSetOfClasses = new TreeSet<String>();
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

	public static LinkedHashMap<String, Double> getRatios(HashMap<java.lang.String, CollegeClass> classTracker) throws IOException {
		// Create a sorted mapping of the course ratios
		HashMap<String, Double> courseRatios = new HashMap<String, Double>();
		for (String course : classTracker.keySet()) {
			CollegeClass curClassObj = classTracker.get(course);
			courseRatios.put(
				course,
				curClassObj.getDifficultyScore()/curClassObj.getQualityScore()				
			);
		}
		// Return the sorted mapping from difficulty-to-quality ratio -> course code
		return sortByValue(courseRatios, false);
	}
	
	public static HashMap<String, Double> getQualityScores(
			HashMap<String, CollegeClass> classTracker) {
		HashMap<String, Double> courseQualityScores = new HashMap<String, Double>();
		for (String course : classTracker.keySet()) {
			CollegeClass curClassObj = classTracker.get(course);
			courseQualityScores.put(
				course,
				curClassObj.getQualityScore()				
			);
		}
		// Return the sorted mapping from difficulty-to-quality ratio -> course code
		return sortByValue(courseQualityScores, true);
	}
	
	public static HashMap<String, CollegeClass> getCollegeClassObjects(
			File courseEvalFile) throws NumberFormatException, IOException {
		// Get the ratios for each course, keeping track of each section's number
		// of students and the quality and difficulty ratings
		HashMap<String, CollegeClass> classTracker = new HashMap<String, CollegeClass>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(courseEvalFile));
			String line;
		    while ((line = br.readLine()) != null) {
		        String[] curLine = line.split(",");
		        String curClass = curLine[0];
		        int numOfStudents = Integer.parseInt(curLine[2].trim());
		        Double courseQualityScore = Double.parseDouble(curLine[3]);
		        Double courseDifficultyScore = Double.parseDouble(curLine[4]);
		        // check if the current class already has been encountered
		        if (classTracker.get(curClass) == null) {
		        	CollegeClass curClassObj = new CollegeClass(curClass, numOfStudents, 
		        		courseQualityScore, courseDifficultyScore);
		        	classTracker.put(curClass, curClassObj);
		        } else {
		        	CollegeClass curClassObj = classTracker.get(curClass);
		        	curClassObj.addNewClassSection(numOfStudents, courseQualityScore, 
		        		courseDifficultyScore);
		        }
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return classTracker;
	}
	
	public static <String, Double extends Comparable<? super Double>> 
			LinkedHashMap<String, Double> sortByValue(HashMap<String, Double> courseRatiosMap, final boolean ascending) {
	    LinkedList<Map.Entry<String, Double>> list =
	        new LinkedList<Map.Entry<String, Double>>(courseRatiosMap.entrySet() );
	    Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
	        public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
	        	if (ascending == true) {
	        		return (o2.getValue()).compareTo(o1.getValue());
	        	} else {
	        		return (o1.getValue()).compareTo(o2.getValue());
	        	}
	        }
	    });	
	    LinkedHashMap<String, Double> result = new LinkedHashMap<String, Double>();
	    for (Map.Entry<String, Double> entry : list) {
	        result.put( entry.getKey(), entry.getValue() );
	    }	    
	    return result;
	}
}
