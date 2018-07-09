package mod4;

public class Hexagon extends GeometricObject implements Cloneable, Comparable<Hexagon> {
	//private double for side
	private double side;
	//constructor
	public Hexagon(double side) {
		this.side=side;
	}
	@Override
	public double getArea() {
		return 3*(( (Math.sqrt(3))/2 )*side);
	}
	@Override
	public double getPerimeter() {
		return (side*6);
	}
	@Override
	public int compareTo(Hexagon obj) {
		if(obj.getSide()>this.side) {
			return 1;
		}else if(obj.getSide()<this.side) {
			return -1;
		}else {
			return 0;
		}

	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	//getter
	public double getSide() {
		return side;
	}

}
