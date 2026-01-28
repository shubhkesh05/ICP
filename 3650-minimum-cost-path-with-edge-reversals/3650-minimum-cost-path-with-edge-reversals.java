class Solution {
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int minCost(int n, int[][] edges) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]*2));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.y-b.y));
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        pq.offer(new Pair(0,0));
        cost[0]=0;
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int curr=temp.y,node=temp.x,len=adj.get(node).size();
            if(node==n-1) return curr;
            for(int i=0;i<len;i++){
                Pair p=adj.get(node).get(i);
                if(cost[p.x]>curr+p.y){
                    pq.offer(new Pair(p.x,curr+p.y));
                    cost[p.x]=curr+p.y;
                }
            }
        }
        return -1;
    }
}