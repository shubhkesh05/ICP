class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length()==0){
         
            return 0;
        }
        int n=s.length();
        int i=0;
        final int min=Integer.MIN_VALUE;
        final int max=Integer.MAX_VALUE;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i==n){
            return 0;
        }
        int sign=1;
        if(i<n && s.charAt(i)=='-' || s.charAt(i)=='+'){
            if(s.charAt(i)=='+'){
                i++;
            }
            else{
                 sign=-1;
                 i++;
            }
           
        }
        long res=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            res=res*10+digit;
            if(res*sign>max){
                return max;
            }
            if(res*sign<min){
                return min;
            }

            i++;
        }
        return (int)res*sign;
    }
}