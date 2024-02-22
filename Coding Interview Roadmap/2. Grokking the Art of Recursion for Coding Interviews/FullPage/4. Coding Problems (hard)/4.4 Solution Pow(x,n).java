public class Solution {
    public static double calculatePower(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / calculatePower(x, -n);
        }
        double temp = calculatePower(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    public static void main(String[] args) {
        // Example inputs
        double x1 = 2;
        int n1 = 5;
        double x2 = 3;
        int n2 = 4;
        double x3 = 5;
        int n3 = 0;

        // Calculate power and print results
        System.out.println("Power of " + x1 + " to the power of " + n1 + " = " + calculatePower(x1, n1));
        System.out.println("Power of " + x2 + " to the power of " + n2 + " = " + calculatePower(x2, n2));
        System.out.println("Power of " + x3 + " to the power of " + n3 + " = " + calculatePower(x3, n3));
    }
}
