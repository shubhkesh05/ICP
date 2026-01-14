class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set=new HashSet<>();
        int target=candyType.length/2;
        for(int nums:candyType){
            if(!set.contains(nums)){
                set.add(nums);
            }
        }
        int n=set.size();
        
        int count=0;
        for(int i=0;i<n;i++){
            if(target>i){
                count++;
            }

        }
        return count;
        
    }
}