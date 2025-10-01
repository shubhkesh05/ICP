class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparing(o -> o[1]));
        int chainlen=1;
        int chainend=intervals[0][1];
        int len=intervals.length;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>=chainend){
                chainlen++;
                chainend=intervals[i][1];
            }
        }
        return len-chainlen;
    }
}