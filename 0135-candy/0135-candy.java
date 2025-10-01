class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int arr1[]=new int[n];
        int arr2[]=new int[n];
        int count=0;
        Arrays.fill(arr1,1);
        Arrays.fill(arr2,1);
        for(int i=0;i<n-1;i++){
            if(ratings[i]<ratings[i+1]){
                arr1[i+1]=arr1[i]+1;
            }
        }
       for(int i=n-1;i>0;i--){
            if(ratings[i]<ratings[i-1]){
                arr2[i-1]=arr2[i]+1;
            }
        }
        for(int i=0;i<n;i++){
            if(arr1[i]>arr2[i]){
                count += arr1[i];
            }
             else
              count += arr2[i];
        }
        return count;

    }
}