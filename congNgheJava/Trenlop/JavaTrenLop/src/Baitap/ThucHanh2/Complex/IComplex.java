package Baitap.ThucHanh2.Complex;

public interface IComplex {
    public void display();
    public double getReal();
    public void setReal(double real);
    public double getImaginary();
    public void setImaginary(double imaginary);
    public String toString();
    public Complex sum(Complex complex);
    public double module();
}
