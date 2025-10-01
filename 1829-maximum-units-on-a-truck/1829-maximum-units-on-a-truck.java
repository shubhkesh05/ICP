class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int sum=0;
        int m=boxTypes.length;
        for(int i=0;i<m;i++){
            if(truckSize>=boxTypes[i][0]){
               sum+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }
            else{
                sum+=truckSize*boxTypes[i][1];
                truckSize=0;
            }
        }
        return sum;
        
    }
}