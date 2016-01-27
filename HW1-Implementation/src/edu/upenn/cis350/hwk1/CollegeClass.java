package edu.upenn.cis350.hwk1;

// keeps track of the weighted scores for quality and difficulty
// for each class. handles multiple sections with varying
// numbers of students
public class CollegeClass {
	private String className;
	private int numOfStudents;
	private double totalQualityPoints;
	private double totalDifficultyPoints;
	
	public CollegeClass(String className, int numOfStudents, 
			double qualityScore, double difficultyScore) {
		this.className = className;
		this.numOfStudents = numOfStudents;
		this.totalQualityPoints = (double)numOfStudents * qualityScore;
		this.totalDifficultyPoints = (double)numOfStudents * difficultyScore;		
	}
	
	public void addNewClassSection(int numOfStudents, 
			Double qualityScore, Double difficultyScore) {
		this.numOfStudents += numOfStudents;
		this.totalQualityPoints += (double)numOfStudents * qualityScore;
		this.totalDifficultyPoints += (double)numOfStudents * difficultyScore;
	}
	
	public double getQualityScore() {
		return this.totalQualityPoints / (double)this.numOfStudents;
	}
	
	public double getDifficultyScore() {
		return this.totalDifficultyPoints / (double)this.numOfStudents;
	}
}
