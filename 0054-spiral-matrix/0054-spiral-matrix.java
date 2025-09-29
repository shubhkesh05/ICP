class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         ArrayList<Integer>al=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        
        int top=0,bottom=n-1;
        int left=0,right=m-1;
        
        
        while(left<=right && top<=bottom){
            //move left to right
            for(int i=left;i<=right;i++){
                al.add(matrix[top][i]);
            }
            top++;
            
            //move top to bottom
            for(int i=top;i<=bottom;i++){
                al.add(matrix[i][right]);
            }
            right--;
            
            if(top<=bottom){
                //move from right to left
                for(int i=right;i>=left;i--){
                    al.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if(left<=right){
                //move bottom to top
                for(int i=bottom;i>=top;i--){
                    al.add(matrix[i][left]);
                }
                left++;
            }
        }
        return al;
    }
}