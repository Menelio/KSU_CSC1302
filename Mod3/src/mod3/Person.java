/**
 * Mod2 Lab_2 
 * CSC 1302 M-W 11:00-3:50
 * Menelio Alvarez 
 * 6/16/2018
 * */
package mod3;

public class Person {
	//instance variables
	String name;
	String Email;
	
	
	//constructor
	public Person(String name, String email) {
		super();
		this.name = name;
		Email = email;
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Person;" + name;
	}
	
	
	
}
