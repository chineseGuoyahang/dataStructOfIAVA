package dataStruct.graph.shortestPath;

import dataStruct.graph.AdjMatGraph;

public class Dijkstra {
    private final static double maxWeight = Double.POSITIVE_INFINITY;
    public static void dijkstra( AdjMatGraph graph , int from , double[] distance , int[] path ) throws Exception{
        //带权图graph从下标为v0的节点到其他节点的最短距离distance
        //和相应的目标节点的前一节点的下标path
        int n = graph.getNumOfVertices();
        boolean[] visited = new boolean[n];//visited用来存放n个节点的标记
        double minDistance;
        int tmp = 0;
        
        //1.初始化
        for( int i=0 ; i < n ; i++ ) {
            distance[i] = graph.getWeight(from, i);
            visited[i] = false ; //初始均标记为0
            if( i != from && distance[i] < maxWeight )
                path[i] = from;//初始的目标节点的前一节点均为from
            else
                path[i] = -1;
        }
        visited[from] = true;
        
        
        //2.在当前还未找到最短路径的结点集中选取具有最短路径的结点u
        for( int i = 1 ; i < n ; i++ ) {
            minDistance = maxWeight;
            for( int j = 0 ; j < n ; j++ ) {
                if( visited[j] == false && distance[j] < minDistance ) {
                    tmp = j;
                    minDistance = distance[j];
                }
            }
            //当已不存在路径时，算法结束，此语句对非联通图是必须的
            if( minDistance == maxWeight)
                return;
            visited[tmp] = true;//标记节点u已经从集合T加入到集合S中
            
            //3.修改从from到其他节点的最短路径和最短距离
            for( int j = 0 ; j < n ; j++ ) {
                if( visited[j] == false && graph.getWeight(tmp, j) < maxWeight && distance[tmp] + graph.getWeight(tmp, j) < distance[j] ) {
                    distance[j] = distance[tmp] + graph.getWeight(tmp, j);
                    path[i] = tmp;
                } 
            }
            
        }
    }

}
