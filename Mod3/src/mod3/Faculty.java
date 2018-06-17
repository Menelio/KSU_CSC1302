package mod3;

public class Faculty extends Employee {
	//instance variables
	String officeHours;

	//constructor
	public Faculty(String name, String email, double salary, String officeHours) {
		super(name, email, salary);
		this.officeHours = officeHours;
	}
	//Getters and setters
	public String getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	
	
}
