package SkillBuilder;

import java.io.Serializable;

public class StudentFile implements Serializable{
	private String fName, lName;
	
	//Constructor
	public StudentFile (String firstN, String lastN) {
		fName = firstN;
		lName = lastN;
	}
	
	//Creates String representing students' name
	public String toString() {
		String stuName;
		
		stuName = fName + " " + lName;
		return stuName;
	}
	
}
