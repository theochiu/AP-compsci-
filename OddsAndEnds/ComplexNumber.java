

public class ComplexNumber{

	private double real, imaginary;

	public ComplexNumber(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}

	public ComplexNumber add(ComplexNumber a){
		double realResult = this.real + a.real;
		double imaginaryres = this.imaginary + a.imaginary;
		return new ComplexNumber(realResult,imaginary);
	}


}
