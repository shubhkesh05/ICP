class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> l1=new ArrayList<>();
        permute(nums,list,l1 );
        return l1;
        
    }
    private void permute(int nums[],List<Integer> list,List<List<Integer>> l1){
        if(list.size()==nums.length){
            l1.add(new ArrayList<>(list));
            return;

        }
        for(int i=0;i<nums.length;i++){
        if(!list.contains(nums[i])){
            list.add(nums[i]);
            permute(nums,list,l1);
            list.remove(list.size()-1);

        }
        
        }
    }
}