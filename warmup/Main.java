package warmup;

public class Main {

    public static void main(String[] args) {
        // Your code here.
        long number = 600851475143L;
        long largestPrimeFactor = 0;

        // Remove factors of 2
        while (number % 2 == 0) {
            largestPrimeFactor = 2;
            number /= 2;
        }

        // Check odd factors
        for (long i = 3; i * i <= number; i += 2) {
            while (number % i == 0) {
                largestPrimeFactor = i;
                number /= i;
            }
        }

        // If remaining number is greater than 1, it is prime
        if (number > 1) {
            largestPrimeFactor = number;
        }

        System.out.println("Largest prime factor: " + largestPrimeFactor);

    }
}

//I am going to start the warm-up project
//I have chosen to do problem 3
