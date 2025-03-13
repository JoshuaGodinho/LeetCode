class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0; // No operations needed for 1 'A'

        int steps = 0;
        for (int factor = 2; factor <= n; factor++) {
            while (n % factor == 0) { // If factor is valid
                steps += factor;
                n /= factor;
            }
        }
        return steps;
    }
}
