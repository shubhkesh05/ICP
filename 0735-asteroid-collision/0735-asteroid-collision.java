class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      Stack<Integer> st = new Stack<>();
      for(int aster : asteroids){
        boolean explod=false;
        while(!st.isEmpty() && aster<0 &&  st.peek()>0){
            if(Math.abs(aster)>Math.abs(st.peek())){
                st.pop();
                continue;
            }
            else if(Math.abs(aster)==Math.abs(st.peek())){
                st.pop();
            
            }
            explod=true;
            break;
        }
        if(!explod){
            st.push(aster);
        }
      }
      int ans[]=new int[st.size()];
      for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
      }


        return ans;
        
    }
}