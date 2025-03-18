package Baitap.ThucHanh2.Complex;

public class Complex implements IComplex{
    private double real;
    private double imaginary;

    public Complex() {
        this.real = 1;
        this.imaginary = -1;
    }

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void display(){
        System.out.println(this.real + " " + this.imaginary + "i");
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return "Complex{" + "real=" + real + ", imaginary=" + imaginary + '}';
    }

    public Complex sum(Complex complex){
        return new Complex(this.getReal() + complex.getReal(), this.getImaginary() + complex.getImaginary());
    }

    public double module(){
        return Math.sqrt(this.getReal() * this.getReal() + this.getImaginary() * this.getImaginary());
    }


}
