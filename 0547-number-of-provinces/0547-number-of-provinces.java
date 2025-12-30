class Solution {
    // DFS to mark all cities connected to 'src'
    public static void dfs(int[][] isConnected, boolean[] vis, int src) {
        vis[src] = true; // mark current city visited
        for (int i = 0; i < isConnected.length; i++) {
            // visit unvisited neighbors
            if (isConnected[src][i] == 1 && !vis[i]) {
                dfs(isConnected, vis, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // total number of cities
        int ans = 0;                // count of provinces
        boolean[] vis = new boolean[n]; // track visited cities

        // check each city
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {   // new province found
                ans++;
                dfs(isConnected, vis, i); // explore it fully
            }
        }
        return ans;
    }
}