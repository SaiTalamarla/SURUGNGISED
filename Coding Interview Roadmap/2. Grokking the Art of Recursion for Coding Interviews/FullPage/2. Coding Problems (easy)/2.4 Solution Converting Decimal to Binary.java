public class Solution {
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return ""; // Base case
        }
        return decimalToBinary(decimal / 2) + decimal % 2; // Recursive call
    }
    public static void main(String[] args) {
        // Example inputs
        int[] examples = {10, 27, 5};

        for (int example : examples) {
            String binary = decimalToBinary(example);
            System.out.println("Binary representation of " + example + " is: " + binary);
        }
    }
}
