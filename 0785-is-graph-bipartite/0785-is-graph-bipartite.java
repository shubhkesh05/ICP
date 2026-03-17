class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q=new LinkedList<>();
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]!=-1){
                continue;
            }
            q.add(i);
            color[i]=0;
            while(!q.isEmpty()){
                int node=q.poll();
                for(int neigh:graph[node]){
                if(color[neigh]==-1){
                if(color[node]==0){
                    color[neigh]=1;

                }
                else{
                    color[neigh]=0;
                }
                 q.add(neigh);
            }
            else{
                if(color[node]==color[neigh]){
                    return false;
                }
            }

            }
           
            }
        }
        return true;
    }
}