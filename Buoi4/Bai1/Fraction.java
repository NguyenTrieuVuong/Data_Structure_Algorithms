import java.util.Scanner;

public class Fraction {
    private float numerator; // Tử số
    private float denominator; // Mẫu số

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        float newNumerator = numerator * c.denominator + c.numerator * denominator;
        float newDenominator = denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    public Fraction minus(Fraction c) {
        float newNumerator = numerator * c.denominator - c.numerator * denominator;
        float newDenominator = denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    public Fraction multi(Fraction c) {
        float newNumerator = numerator * c.numerator;
        float newDenominator = denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    public Fraction divi(Fraction c) {
        float newNumerator = numerator * c.denominator;
        float newDenominator = denominator * c.numerator;
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    public Fraction normalize() {
        float gcd = getGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return this;
    }

    private float getGCD(float a, float b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong phan so: ");
        int n = scanner.nextInt();
        Fraction[] fractions = new Fraction[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan so thu " + (i + 1) + ": ");
            float numerator = scanner.nextFloat();
            float denominator = scanner.nextFloat();
            fractions[i] = new Fraction(numerator, denominator);
        }
        int v = 2;
        System.out.println("Phan so o vi tri thu " + v + " la: " + fractions[v - 1]);
        Fraction sum = new Fraction(0, 1);
        for (int i = 0; i < n; i++) {
            sum = sum.add(fractions[i]);
        }
        sum.normalize();
        System.out.println("Tong cac phan so la: " + sum);

    }
}
