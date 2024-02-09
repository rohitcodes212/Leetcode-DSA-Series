class Solution {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }

        // Divide and conquer
        double half = myPow(x, n / 2);

        if (n % 2 == 0) {
            // If n is even
            return half * half;
        } else {
            // If n is odd
            if (n > 0) {
                return x * half * half;
            } else {
                return (1 / x) * half * half;
            }
        }
    }
}
