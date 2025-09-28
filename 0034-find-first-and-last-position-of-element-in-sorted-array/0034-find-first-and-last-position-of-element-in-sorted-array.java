class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int st=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                st=mid;
                high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        low=0;
        high=nums.length-1;
        int ed=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                ed=mid;
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        int ans[]=new int[2];
        ans[0]=st;
        ans[1]=ed;
        return ans;
    }
}