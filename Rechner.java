package rechner;

public class Rechner {

	private double a;

	public Rechner(double a) {
		this.a = a;
	}

	public Rechner() {
		a = Double.MIN_VALUE;
	}

	public void add(double b) {
		if (a == Double.MIN_VALUE)
			throw new IllegalStateException("a not set");
		a += b;
	}

	public void subtract(double b) {
		if (a == Double.MIN_VALUE)
			throw new IllegalStateException("a not set");
		a -= b;
	}

	public void multiply(double b) {
		if (a == Double.MIN_VALUE)
			throw new IllegalStateException("a not set");
		a *= b;
	}

	public void divide(double b) {
		if (a == Double.MIN_VALUE)
			throw new IllegalStateException("a not set");
		if (b == 0)
			throw new IllegalArgumentException("Division durch 0");
		a /= (double) b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public void clear() {
		a = Double.MIN_VALUE;
	}

	public static void main(String[] args) {
		Rechner r = new Rechner(1.25);
		
		r.add(2.5);
		System.out.println("Adding " + r.getA());
		r.subtract(2.5);
		System.out.println("Subtracting " + r.getA());
		r.multiply(2.5);
		System.out.println("Multiplying " + r.getA());
		r.divide(2.5);
		System.out.println("Dividing " + r.getA());
	}

}
