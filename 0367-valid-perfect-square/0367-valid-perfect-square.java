class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<1){
            return false;
        }
        long left=1;
        long right=num;
        while(left<=right){
            long mid =left +(right-left)/2;
            long perf =mid*mid;
            if(perf==num){
                return true;
            }
            else if(perf<num){
                left=mid+1;
            }
            else{
                right=mid-1;
            }

        }
        return false;        
    }
}