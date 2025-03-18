package Baitap.ThucHanh2.Fraction;

public interface IFraction {
    void Display();

    int greatestCommonDivisor(int a, int b);

    void reduceFraction();

    Fraction sum(Fraction fraction);

    Fraction minus(Fraction fraction);

    Fraction multiply(Fraction fraction);

    Fraction divide(Fraction fraction);

    void commonDenominator(Fraction fraction);

    int compareTo(Fraction fraction);

    boolean isInteger();

}
