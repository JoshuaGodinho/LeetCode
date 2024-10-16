
class Solution {

    private int getNext(int n){
        int totalSum=0;
        while(n>0){
            int digit=n%10;
            totalSum+=digit*digit;
            n=n/10;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
            int slow=n;
            int fast=getNext(n);

            while(fast!=1 && slow !=fast){
                slow=getNext(slow);
                fast=getNext(getNext(fast));
            }
            if(fast==1)
                return true;
            return false;
        }        
    }