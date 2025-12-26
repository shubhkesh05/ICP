class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1, r = (long)1e14; // upper bound
        while (l < r) {
            long mid = (l + r) / 2, trips = 0;
            for (int t : time) trips += mid / t;
            if (trips >= totalTrips) r = mid;   
            else l = mid + 1;
        }
        return l;
    }
}
