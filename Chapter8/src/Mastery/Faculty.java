package Mastery;

public class Faculty extends UEmployee {
	private String department;
	

	//Overloading method
	public Faculty(String f, String l, double s, String dep) {
		super(f, l , s);
		department = dep;
	}
	
	//Modifier method
	public void setDep(String dep) {
		department = dep;
	}
	
	//Access method
	public String getDep() {
		return(department);
	}
	
	//Return employee department
	public String toString() {
		return (super.toString() + "\n" 
				+ "Department: " + department + "\n");
	}
	
}
