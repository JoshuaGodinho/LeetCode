class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int numMaxFreq = 0;
        for (int f : freq) {
            if (f == maxFreq) numMaxFreq++;
        }

        // (maxFreq - 1) groups, each of (n + 1) length, and add numMaxFreq for the last group
        int intervals = (maxFreq - 1) * (n + 1) + numMaxFreq;

        // The answer is either intervals (if idle is needed), or tasks.length (if no idle needed)
        return Math.max(intervals, tasks.length);
    }
}