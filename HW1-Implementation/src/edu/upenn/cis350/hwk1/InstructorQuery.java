package edu.upenn.cis350.hwk1;

import java.util.LinkedList;
import java.util.Scanner;

public class InstructorQuery {
	public static LinkedList<String> instructorQuery() {
		Scanner input = new Scanner(System.in);
		String prompt = "Please enter an instructor name. Partial matches are okay, and the "
				+ "search is case-insensitive. E.g. �osera�, �OSERA�, �Peter�, "
				+ "and even �ael S.� should all result in a match for PETER-MICHAEL S. OSERA.";
	    System.out.println(prompt); 
	 
	    String userInput = input.next();
	    
	    return null;
	}
}
