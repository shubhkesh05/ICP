class Solution {
    public int minSubarray(int[] nums, int p) {
        long total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        long target=total%p;
        if(target==0) return 0;
        long prefix=0;
        int len=nums.length;
        Map<Integer,Integer> nmap=new HashMap<>();
        nmap.put(0,-1);
        for(int i=0;i<nums.length;i++){
            prefix=(prefix+nums[i])%p;
            int need=(int)((prefix-target+p)%p);
            if(nmap.containsKey(need)){
                len=Math.min(len,i-nmap.get(need));
            }
            nmap.put((int)prefix,i);
        }
            return len==nums.length ? -1:len;

        }

        
    
}