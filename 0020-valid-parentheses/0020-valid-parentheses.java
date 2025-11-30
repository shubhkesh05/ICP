class Solution {
    public boolean isValid(String s) {
      Stack<Character> st=new Stack();
      for(int i=0;i<s.length();i++){
        char curr=s.charAt(i);
        if(!st.isEmpty()){
            char last=st.peek();
            if(ispair(curr,last)){
                st.pop();
                continue;
            }
        }
        st.push(curr);



        }

        if(st.isEmpty()){
            return true;
        }
        return false;

      
      
            
        
    }
    private boolean ispair(char curr,char last){
        if(last=='(' && curr==')' || last=='{' && curr=='}' || last=='[' && curr==']'){
            return true;
        }
        return false;
    }
}