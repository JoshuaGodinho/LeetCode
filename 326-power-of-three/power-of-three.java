class Solution {
    public boolean isPowerOfThree(int n) {
        double logResult=Math.log10(n)/Math.log10(3);
        if(logResult==(int) logResult)
            return true;
        else 
            return false;
    }
}