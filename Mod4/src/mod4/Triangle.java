package mod4;

import java.util.Scanner;

//triangle class extends GeometricObject
public class Triangle extends GeometricObject {
	//private var for sides of triangle
	private double sideA=0.0;
	private double sideB=0.0;
	private double sideC=0.0;

	//constructor
	public Triangle(double sideA, double sideB, String color, boolean filled) {
		super(color, filled);
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = Math.sqrt(Math.pow(sideA, 2)+Math.pow(sideB, 2));
	}
	
	//getters and setters for sides
	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}


	//Overridden methods
	@Override
	public double getArea() {
		return ((sideA*sideB)/2);
	}

	@Override
	public double getPerimeter() {
		return (sideA+sideB+sideC);
	}
	public static void main(String[] args) {
		//var to hold user input 
		double sideA;
		double sideB;
		String color;
		boolean isFilled;
		//Scanner to get user input
		Scanner console = new Scanner(System.in);
		//get user input
		System.out.println("Enter length of SideA");
		sideA =console.nextDouble();
		
		System.out.println("Enter length of SideB");
		sideB =console.nextDouble();
		//to eat next line left by .nextDouble
		color = console.nextLine();
		System.out.println("Enter enter color");
		color = console.nextLine();
		
		System.out.println("Is filled: 1 = filled 0 = not filled");
		if(console.nextInt()==1) {
			isFilled=true;
		}else {
			isFilled= false;
		}
		//create triangle object
		Triangle triangle = new Triangle(sideA, sideB, color, isFilled);
		System.out.println("Triangle area = "+triangle.getArea()+"\n"
						 + "Triangle perimeter = "+triangle.getPerimeter()+"\n"
						 + "Triangle color = "+triangle.getColor()+"\n"
						 + "Triangle is filled = "+triangle.isFilled());
		
	}
}
