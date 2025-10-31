class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && k>0 && num.charAt(i)<st.peek()){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder str =new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();
        while(str.length()>1 && str.charAt(0)=='0'){
            str.deleteCharAt(0);
        }
        return str.length()==0 ? "0" :str.toString();

        
    }
}