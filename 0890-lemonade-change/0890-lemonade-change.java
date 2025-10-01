class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fivedollar=0;
        int tendollar=0;
        for(int x:bills){
            if(x==5){
                fivedollar++;
            }
            else if(x==10) {
                if (fivedollar>0){
                    fivedollar--;
                    tendollar++;
                }
                else{
                    return false;
                }
            }
            else{
                if(fivedollar>0 && tendollar>0){
                    fivedollar--;
                    tendollar--;
                }
                else if(fivedollar>=3){
                    fivedollar-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
        
    }
}