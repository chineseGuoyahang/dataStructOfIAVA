package dataStruct.graph.shortestPath;

import dataStruct.graph.AdjMatGraph;

public class Dijkstra {
    private final static double maxWeight = Double.POSITIVE_INFINITY;
    public static void dijkstra( AdjMatGraph graph , int from , double[] distance , int[] path ) throws Exception{
        //��Ȩͼgraph���±�Ϊv0�Ľڵ㵽�����ڵ����̾���distance
        //����Ӧ��Ŀ��ڵ��ǰһ�ڵ���±�path
        int n = graph.getNumOfVertices();
        boolean[] visited = new boolean[n];//visited�������n���ڵ�ı��
        double minDistance;
        int tmp = 0;
        
        //1.��ʼ��
        for( int i=0 ; i < n ; i++ ) {
            distance[i] = graph.getWeight(from, i);
            visited[i] = false ; //��ʼ�����Ϊ0
            if( i != from && distance[i] < maxWeight )
                path[i] = from;//��ʼ��Ŀ��ڵ��ǰһ�ڵ��Ϊfrom
            else
                path[i] = -1;
        }
        visited[from] = true;
        
        
        //2.�ڵ�ǰ��δ�ҵ����·���Ľ�㼯��ѡȡ�������·���Ľ��u
        for( int i = 1 ; i < n ; i++ ) {
            minDistance = maxWeight;
            for( int j = 0 ; j < n ; j++ ) {
                if( visited[j] == false && distance[j] < minDistance ) {
                    tmp = j;
                    minDistance = distance[j];
                }
            }
            //���Ѳ�����·��ʱ���㷨�����������Է���ͨͼ�Ǳ����
            if( minDistance == maxWeight)
                return;
            visited[tmp] = true;//��ǽڵ�u�Ѿ��Ӽ���T���뵽����S��
            
            //3.�޸Ĵ�from�������ڵ�����·������̾���
            for( int j = 0 ; j < n ; j++ ) {
                if( visited[j] == false && graph.getWeight(tmp, j) < maxWeight && distance[tmp] + graph.getWeight(tmp, j) < distance[j] ) {
                    distance[j] = distance[tmp] + graph.getWeight(tmp, j);
                    path[i] = tmp;
                } 
            }
            
        }
    }

}
