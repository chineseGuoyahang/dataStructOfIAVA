package dataStruct.graph.minCostSpanTree;

import dataStruct.graph.AdjMatGraph;
/**
 * ȱ�㣺
 *      �����յõ�����С������MinSpanTree[] closeVertex����õ�< v1 , cost , v2 >��Ҫ����ԭͼ�Ľṹ���Ƚ��鷳
 * �Ľ�     
 *      MinSpanTree�Ľṹ��Ϊ< v1 , cost , v2 >��д��prim�㷨
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
        //��lowCost����ֵ
        for( int i=1 ;i< n ; i++ ) 
            lowCost[i]=graph.getWeight(0, i);
        MinSpanTree minSpanTree = new MinSpanTree();
        minSpanTree.setVertex(graph.getValue(0));
        //����ڵ�0
        closeVertex[0] = minSpanTree;
        //��ǽڵ�0:
        lowCost[0] = -1;
        for( int i=1 ; i< n ; i++ ) {
            minCost = infinity;
            for( int j=1 ; j < n ; j++ ) {
                //��һ��Ȩֵ��С�ıߣ��Ҹñ߿�������һ���µĶ���,��Ϊ�ɶ����lowCost[j]=-1
                if( lowCost[j] < minCost && lowCost[j] > 0 ) {
                    minCost = lowCost[j];
                    k=j;
                }
            }
            MinSpanTree cur = new MinSpanTree();
            cur.setVertex(graph.getValue(k));
            cur.setWeight(minCost);
            closeVertex[i] = cur;
            //��ǽڵ�k
            lowCost[k] = -1;
            //���ݼ���Ľڵ�k������lowCost[]��ֵ
            for( int j = 1 ; j < n ; j++ ) {
                if( graph.getWeight(k, j)<lowCost[j] )
                    lowCost[j] = graph.getWeight(k, j);
            }
        }
    }
}
