package Baitap.ThucHanh2.Fraction;

public class Fraction {
    private int numeRator;
    private int denoMinator;

    public Fraction(int numeRator, int DenoMinator) {
        this.numeRator = numeRator;
        this.denoMinator = DenoMinator;
    }

    public Fraction(){
        this.numeRator = 0;
        this.denoMinator = 1;
    }

    public void Display(){
        System.out.println(numeRator + "/" + denoMinator);
    }

    public int getNumeRator() {
        return numeRator;
    }

    public int getDenoMinator() {
        return denoMinator;
    }

    public void setNumeRator(int numeRator) {
        this.numeRator = numeRator;
    }

    public void setDenoMinator(int denoMinator) {
        this.denoMinator = denoMinator;
    }

    @Override
    public String toString() {
        return "Fraction{" + "numeRator=" + numeRator + ", DenoMinator=" + denoMinator + '}';
    }

    public int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public void reduceFraction(){
        int tmp = greatestCommonDivisor(this.getNumeRator(), this.denoMinator);
        this.setNumeRator(this.getNumeRator() / tmp);
        this.setDenoMinator(this.getDenoMinator() / tmp);
    }

    public Fraction sum(Fraction fraction){
        int a = this.getNumeRator() * fraction.getDenoMinator() + fraction.getDenoMinator() * this.getDenoMinator();
        int b = this.getDenoMinator() * fraction.getDenoMinator();

        Fraction fraction1 = new Fraction(a, b);
        fraction1.reduceFraction();

        return fraction1;
    }

    public Fraction minus(Fraction fraction){
        int a = this.getNumeRator() * fraction.getDenoMinator() - fraction.getDenoMinator() * this.getDenoMinator();
        int b = this.getDenoMinator() * fraction.getDenoMinator();

        Fraction fraction1 = new Fraction(a, b);
        fraction1.reduceFraction();

        return fraction1;
    }

    public Fraction multiply(Fraction fraction){
        int a = this.getNumeRator() * fraction.getNumeRator();
        int b = this.getDenoMinator() * fraction.getDenoMinator();

        Fraction fraction1 = new Fraction(a, b);
        fraction1.reduceFraction();

        return fraction1;
    }

    public Fraction divide(Fraction fraction){
        int a = this.getNumeRator() * fraction.getDenoMinator();
        int b = this.getDenoMinator() * fraction.getNumeRator();

        Fraction fraction1 = new Fraction(a, b);
        fraction1.reduceFraction();

        return fraction1;
    }

    public void commonDenominator(Fraction fraction){
        this.setNumeRator(fraction.getDenoMinator() * this.getNumeRator());
        this.setDenoMinator(fraction.getDenoMinator() * this.getDenoMinator());

        fraction.setNumeRator(this.getDenoMinator() * fraction.getNumeRator());
        fraction.setDenoMinator(fraction.getDenoMinator() * this.getDenoMinator());
    }

    public int compareTo(Fraction fraction) {
        this.commonDenominator(fraction);

        if (this.numeRator > fraction.numeRator){
            return 1;
        }
        else {
            return 0;
        }
    }

    public boolean isInteger() {
        return numeRator % denoMinator == 0;
    }
}
