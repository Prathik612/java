package asg;

public class q4 {
	public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 3;  
        System.out.println("Factorial of " + num + " is: " + factorial(num));  
    }
}
