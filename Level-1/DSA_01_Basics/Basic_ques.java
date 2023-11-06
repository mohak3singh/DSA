package DSA_01_Basics;

public class Basic_ques {
    public static boolean isNumberPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void printAllPrimeInRange(int low, int height) {
        for (int i = low; i <= height; i++) {
            if (isNumberPrime(i))
                System.out.println(i);
        }
    }

    public static int countDigitsInNumber(int n) {
        int len = 0;
        while (n != 0) {
            n /= 10;
            len++;
        }
        return len;
    }

    //R -> L
    public static void printDigitsInReverseOrder(int n) {
        while (n != 0) {
            int rem = n % 10;
            n /= 10;
            System.out.println(rem);
        }
    }

    public static int powerEqualDigit(int n) {
        int pow = 1;
        n /= 10;
        while (n != 0) {
            pow *= 10;
            n /= 10;
        }
        return pow;
    }
    // L -> R
    public static void digitOfANumberInOrder(int n) {
        int pow = powerEqualDigit(n);

        while (pow != 0) {
            int quo = n / pow;
            n %= pow;
            pow /= 10;
            System.out.println(quo);
        }
    }

    public static int rotateANumber(int n, int r) {
        int digit = countDigitsInNumber(n);
        r %= digit;
        if (r < 0)
            r += digit;

        int mul = 1;
        int div = 1;

        for (int i = 1; i <= digit; i++) {
            if (i <= r)
                div *= 10;
            else
                mul *= 10;
        }

        int a = n % div;
        int b = n / div;

        return (a * mul + b);
    }

    public static boolean pythagoreanTriplet_01(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        if (max == a && (b * b + c * c == a * a))
            return true;
        else if (max == b && (a * a + c * c == b * b))
            return true;
        else if (max == c && (a * a + b * b == c * c))
            return true;
        else
            return false;
    }

    public static boolean pythagoreanTriplet_02(int a, int b, int c) {
        return (b * b + c * c == a * a) || (a * a + c * c == b * b) || (a * a + b * b == c * c);
    }

    public static void benjaminBulbs(int n) {
        for (int i = 1; i * i <= n; i++) {
            System.out.println(i * i);
        }
    }

    public static void invertOfNumber(int n){
        int inv = 0;
        int op = 1;
        while(n != 0){
            int od = n % 10;
            int ip = od;
            int id = op;
            inv += id * (int)Math.pow(10, ip -1);
            n /= 10;
            op++;
        }
        System.out.println(inv);
    }
	
	public static void main(String[] args) {
		// System.out.println(isNumberPrime(11));
		// printAllPrimeInRange(5,50);
		// System.out.println(countDigitsInNumber(34784));
		// printDigitsInReverseOrder(123456);
		// digitOfANumberInOrder(123456);
		// System.out.println(rotateANumber(1234567, 4));
		// System.out.println(pythagoreanTriplet_01(3,4,5));
        // System.out.println(pythagoreanTriplet_02(3,4,5));
        // invertOfNumber(21453);
	}
}
