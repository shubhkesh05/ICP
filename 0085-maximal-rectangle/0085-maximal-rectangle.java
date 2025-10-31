class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans=0;
        int[] arr=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    arr[j]=0;
                }
                else{
                    arr[j]++;
                }
            }
            ans=Math.max(ans,largestRectangleArea(arr));
        }
        return ans;
    }
     public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int prevsm[]=new int [n];
        int nextsm[]=new int [n];
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<n;i++){
        while( !st.isEmpty() && heights[st.peek()]>=heights[i]){
            st.pop();
        }
        if(st.isEmpty()){
            prevsm[i]=-1;
        }
        else{
            prevsm[i]=st.peek();
        }
        st.push(i);

        }
        st.clear();
          for(int i=n-1;i>=0;i--){
        while( !st.isEmpty() && heights[st.peek()]>=heights[i]){
            st.pop();
        }
        if(st.isEmpty()){
            nextsm[i]=n;
        }
        else{
            nextsm[i]=st.peek();
        }
        st.push(i);

        }
        int maxhisto=0;
        for(int i=0;i<heights.length;i++){
            int width=nextsm[i]-prevsm[i]-1;
            int maxarea=width*heights[i];
            maxhisto=Math.max(maxhisto,maxarea);
        }
        return maxhisto;
}
}