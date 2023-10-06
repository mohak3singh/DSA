package DSA_02_BinaryForms;

import java.util.Scanner;

public class Conversions {

    public static void decimalToBinary(int n){
        int ans = 0;
        int pow = 1;
        while(n != 0){
            int rem = n % 2;
            n /= 2;
            ans += rem * pow;
            pow *= 10;
        }
        System.out.println(ans);
    }

    public static void binaryToDecimal(int n){
        int ans = 0;
        int pow = 1;
        while(n != 0){
            int rem = n % 10;
            n /= 10;
            ans += rem * pow;
            pow *= 2;
        }
        System.out.println(ans);
    }

    public static int decimalToAnyBase(int n, int b) {
        int pow = 1;
        int ans = 0;
        while (n != 0) {
            int rem = n % b;
            n /= b;

            ans += rem * pow;
            pow *= 10;
        }

        return ans;
    }

    public static int anyBaseToDecimal(int n,int b) {
        int pow = 1;
        int ans = 0;
        while (n != 0) {
            int rem = n % 10;
            n /= 10;

            ans += rem * pow;
            pow *= b;
        }

        return ans;
    }

    public static int anyBaseAddition(int n, int m, int b) {
        int pow = 1;
        int ans = 0, carry = 0;
        while (n != 0 || m != 0 || carry != 0) {
            int sum = carry + n % 10 + m % 10;
            n /= 10;
            m /= 10;

            int digit = sum % b;
            carry = sum / b;

            ans += digit * pow;
            pow *= 10;
        }

        return ans;
    }

    // m > n
    public static int anyBaseSubtraction(int n, int m, int b) {
        int pow = 1, res = 0, borrow = 0;
        while (m != 0) {
            int diff = borrow + m % 10 - n % 10;
            n /= 10;
            m /= 10;

            if (diff < 0) {
                diff += b;
                borrow = -1;
            } else
                borrow = 0;

            res += diff * pow;
            pow *= 10;
        }

        return res;
    }

    public static int multiplyNumberWithDigit(int n, int d, int b) {
        int ans = 0, pow = 1, carry = 0;
        while (n != 0 || carry != 0) {
            int prod = carry + (n % 10) * d;
            n /= 10;

            int digit = prod % b;
            carry = prod / b;

            ans += digit * pow;
            pow *= 10;
        }

        return ans;
    }

    public static int anyBaseMultiplication(int n, int m, int b) {
        int ans = 0, pow = 1;
        while (m != 0) {
            int d = m % 10;
            m /= 10;
            int prodRes = multiplyNumberWithDigit(n, d, b) * pow;
            ans = anyBaseAddition(ans, prodRes, b);
            pow *= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int m = scn.nextInt();
        // int b = scn.nextInt();

        // decimalToBinary(n);
        // binaryToDecimal(n);

        // System.out.println(anyBaseMultiplication(n, m, b));

        // int b1 = scn.nextInt();
        // int b2 = scn.nextInt();
        // int decimalNumber = anyBaseToDecimal(n,b1);
        // System.out.println(decimalToAnyBase(decimalNumber, b2));

        scn.close();
    }
}
