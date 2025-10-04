class Solution {
    public int rob(int[] arr) {
         // code here
        int n=arr.length;
         if (n == 0) return 0;
        if (n == 1) return arr[0];
        int m[]=new int[n];
        
        m[0]=arr[0];
        if(n!=1)
        m[1]=Math.max(arr[0],arr[1]);
       
        for(int i=2;i<n;i++){
            m[i]=Math.max(m[i-1],arr[i]+m[i-2]);
        }
        return m[n-1];
    }
}