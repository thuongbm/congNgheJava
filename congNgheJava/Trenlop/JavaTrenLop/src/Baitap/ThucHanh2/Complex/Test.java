package Baitap.ThucHanh2.Complex;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List <Complex> complexes = new ArrayList<>();

        complexes.add(new Complex(1,2));
        complexes.add(new Complex(1,-3));

        Complex sum = complexes.get(0).sum(complexes.get(1));

        sum.display();
    }
}
