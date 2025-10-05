class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum=0;
        for(int ans:nums){
            sum+=ans;
        }
        int result=solver(nums,0,nums.length-1);
        if(result>=(sum-result)){
            return true;
        }
        return false;

        

        
    }
    private int solver(int nums[],int i,int j){
        if(i>j){
            return 0;
        }
        int ls=nums[i]+Math.min(solver(nums,i+2,j),solver(nums,i+1,j-1));
        int fs=nums[j]+Math.min(solver(nums,i+1,j-1),solver(nums,i,j-2));
        return Math.max(ls,fs);
    }
}