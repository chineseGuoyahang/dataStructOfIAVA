package dataStruct.graph.minCostSpanTree;

import dataStruct.graph.AdjMatGraph;
/**
 * 缺点：
 *      由最终得到的最小生成树MinSpanTree[] closeVertex，想得到< v1 , cost , v2 >需要参照原图的结构，比较麻烦
 * 改进     
 *      MinSpanTree的结构改为< v1 , cost , v2 >重写该prim算法
 * @author Administrator
 *
 */
public class Prim {
    private static final double infinity = Double.POSITIVE_INFINITY;
    public static void prim( AdjMatGraph graph , MinSpanTree[] closeVertex)throws Exception{
        int n = graph.getNumOfVertices();
        double minCost;
        double[] lowCost = new double[n];
        int k=0;
        //给lowCost赋初值
        for( int i=1 ;i< n ; i++ ) 
            lowCost[i]=graph.getWeight(0, i);
        MinSpanTree minSpanTree = new MinSpanTree();
        minSpanTree.setVertex(graph.getValue(0));
        //保存节点0
        closeVertex[0] = minSpanTree;
        //标记节点0:
        lowCost[0] = -1;
        for( int i=1 ; i< n ; i++ ) {
            minCost = infinity;
            for( int j=1 ; j < n ; j++ ) {
                //找一条权值最小的边，且该边可以增加一个新的顶点,因为旧顶点的lowCost[j]=-1
                if( lowCost[j] < minCost && lowCost[j] > 0 ) {
                    minCost = lowCost[j];
                    k=j;
                }
            }
            MinSpanTree cur = new MinSpanTree();
            cur.setVertex(graph.getValue(k));
            cur.setWeight(minCost);
            closeVertex[i] = cur;
            //标记节点k
            lowCost[k] = -1;
            //根据加入的节点k，更新lowCost[]的值
            for( int j = 1 ; j < n ; j++ ) {
                if( graph.getWeight(k, j)<lowCost[j] )
                    lowCost[j] = graph.getWeight(k, j);
            }
        }
    }
}
