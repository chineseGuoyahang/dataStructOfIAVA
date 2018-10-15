package main;

import dataStruct.SeqList;
import dataStruct.graph.AdjMatGraph;
import dataStruct.graph.Connection;

public class Main {
    public static void main( String[] args){
        SeqList vert = new SeqList(5);
        SeqList edges = new SeqList(5);
        AdjMatGraph graph = new AdjMatGraph(5);
        try {
            vert.add(new Character('A'));
            vert.add(new Character('B'));
            vert.add(new Character('c'));
            vert.add(new Character('D'));
            vert.add(new Character('E'));
            edges.add(new Connection(0,1,10.0));
            edges.add(new Connection(0,4,20.0));
            edges.add(new Connection(1,3,30.0));
            edges.add(new Connection(2,1,40.0));
            edges.add(new Connection(3,2,50.0));
            graph.createAdjMatGraph(graph, vert, edges);
            System.out.println("节点个数为： " + graph.getNumOfVertices());
            System.out.println("边的个数为： " + graph.getNumOfEdges());
            graph.deleteEdge(0, 4);
            System.out.println("节点个数为： " + graph.getNumOfVertices());
            System.out.println("边的个数为： " + graph.getNumOfEdges());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
