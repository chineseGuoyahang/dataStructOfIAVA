package main;

import dataStruct.SeqList;
import dataStruct.graph.AdjMatGraph;
import dataStruct.graph.Connection;
import dataStruct.graph.Visit;
import dataStruct.graph.minCostSpanTree.MinSpanTree;
import dataStruct.graph.minCostSpanTree.Prim;

public class Main {
    public static void main( String[] args){
//        SeqList vert = new SeqList(7);
//        SeqList edges = new SeqList(20);
//        AdjMatGraph graph = new AdjMatGraph(7);
//        try {
//            vert.add(new Character('A'));
//            vert.add(new Character('B'));
//            vert.add(new Character('c'));
//            vert.add(new Character('D'));
//            vert.add(new Character('E'));
//            vert.add(new Character('F'));
//            vert.add(new Character('G'));
//            edges.add(new Connection(0,1,50.0));edges.add(new Connection(1,0,50.0));
//            edges.add(new Connection(0,2,60.0)); edges.add(new Connection(2,0,60.0));
//            edges.add(new Connection(1,3,65.0));edges.add(new Connection(3,1,65.0));
//            edges.add(new Connection(1,4,40.0));edges.add(new Connection(4,1,40.0));
//            edges.add(new Connection(2,3,52.0));edges.add(new Connection(3,2,52.0));
//            edges.add(new Connection(2,6,45.0));edges.add(new Connection(6,2,45.0));
//            edges.add(new Connection(3,4,50.0));edges.add(new Connection(4,3,50.0));
//            edges.add(new Connection(3,5,30.0));edges.add(new Connection(5,3,30.0));
//            edges.add(new Connection(3,6,42.0));edges.add(new Connection(6,3,42.0));
//            edges.add(new Connection(4,5,70.0));edges.add(new Connection(5,4,70.0));
//            AdjMatGraph.createAdjMatGraph(graph, vert, edges);
//            System.out.println("�ڵ����Ϊ�� " + graph.getNumOfVertices());
//            System.out.println("�ߵĸ���Ϊ�� " + graph.getNumOfEdges());
//            Visit vs = new Visit();
//            System.out.println("����������������Ľ����");
//            graph.depthFirstSearch(vs);
//            System.out.println("����������������Ľ����");
//            graph.broadFirstSearch(vs);
//            MinSpanTree[] minSpanTree = new MinSpanTree[7];
//            Prim.prim(graph, minSpanTree);
//            System.out.println("��ʼ���� = " + minSpanTree[0].getVertex());
//            for( int i = 1 ; i < graph.getNumOfVertices() ; i++ ) {
//                System.out.println("��βΪ" + minSpanTree[i].getVertex() + "��ȨֵΪ" + minSpanTree[i].getWeight());
//            }
//            
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        System.out.println(Double.MIN_VALUE);
        
    }

}
