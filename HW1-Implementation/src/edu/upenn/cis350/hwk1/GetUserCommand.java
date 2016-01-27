package edu.upenn.cis350.hwk1;

import java.util.Scanner;

public class GetUserCommand {
	public static String getUserCommand() {
		Scanner input = new Scanner(System.in);
		String prompt = "\nMain Menu!\nInput One of the following commands:\n"
	    		+ "'I' to find all courses taught by a specified instructor\n"
	    		+ "'R' to find the top five courses with the lowest "
	    		+ "difficulty-to-quality ratio across all offerings\n"
	    		+ "'Q' to find all courses at or above a specified quality rating across all offerings\n"
	    		+ "'E' to exit the program\n";
	    System.out.println(prompt); 
	 
	    String userInput = "";
	    while ((userInput = input.next()) != "") {
	      if (!userInput.equals("I") && 
	    		  !userInput.equals("R") && 
	    		  !userInput.equals("Q") &&
	    		  !userInput.equals("E")) {
	    	  System.out.println("Your input was " + userInput + " which does not match 'I', 'R', 'Q', "
	    	  		+ "or 'E'. Please try again\n" + prompt);	    	  
	      } else {
	    	  return userInput;
	      }
	    }
		// Should never reach here
	    throw new IllegalStateException();
	}
}
