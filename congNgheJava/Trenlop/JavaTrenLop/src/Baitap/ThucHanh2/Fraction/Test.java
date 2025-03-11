package Baitap.ThucHanh2.Fraction;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String []args){
        ArrayList <Fraction> fractions = new ArrayList<>();

        fractions.add(new Fraction(3, 5));
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(4, 7));
        fractions.add(new Fraction(5, 6));

        Fraction maxFraction = fractions.get(0);

        for (Fraction fraction : fractions) {
            if (fraction.compareTo(maxFraction) > 0) {
                maxFraction = fraction;
            }
        }

        System.out.print("Phân số lớn nhất: ");
        maxFraction.Display();

        Fraction sum;
        System.out.print("Tổng 2 phân số: ");
        sum = fractions.get(1).sum(fractions.get(2));
        sum.Display();

        int count = 0;
        for (Fraction fraction : fractions) {
            if (!fraction.isInteger()) {
                count++;
            }
        }

        System.out.println("Số phân số không phải số nguyên: " + count);
    }
}
