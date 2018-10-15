package dataStruct.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import dataStruct.SeqList;

/**
   * ͼ���ڽӾ����ʾ������ͼ�нڵ���Ŀ��С�ұ߽϶�ʱЧ�ʽϸ�
   *ͼ�ڵ������Ԫ�ش洢��һ��������
   *ͼ�ıߵ�Ȩֵ��Ϣ�����һ����ά������
 * @author Administrator
 *
 */
public class AdjMatGraph {
    //��ʾ���ڵ�֮ǰû�����ߣ�ȨֵΪ�������
    private static final double infinity = Double.NEGATIVE_INFINITY;
    //��ʾ����Խ����ϵĽڵ㣬ȨֵΪ0
    private static final double zero = 0.0;
    private SeqList vertices;//�洢�ڵ��˳���
    private double[][] edge;//�洢�ߵĶ�ά����
    private int numOfEdges;//�ߵĸ���
    //ͨ����һ���޲ι���
    public AdjMatGraph() {
    }
    //���캯��
    public AdjMatGraph( int countOfVertices ) {
        //����ռ�
        vertices = new SeqList(countOfVertices);
        edge = new double[countOfVertices][countOfVertices];
        //��ʼ����λ���飬edge[i][j]
        //���i=j��cost��Ϊ0��i!=j cost = infinity
        for( int i=0 ; i<countOfVertices ; i++ ) {
            for( int j=0 ; j<countOfVertices ; j++ ) {
                if( i==j )
                    edge[i][j]=zero;
                else
                    edge[i][j]=infinity;
            }
        }
        //��ʼ���ߵĸ���
        this.numOfEdges = 0;
    }
    //���ؽڵ����
    public int getNumOfVertices() {
        return vertices.size();
    }
    //���رߵĸ���
    public int getNumOfEdges() {
        return this.numOfEdges;
    }
    //���ؽڵ�v������Ԫ��
    public Object getValue( int v ) throws  Exception{
        return vertices.getData(v);
    }
    //���ر�< v1 , v2 >��Ȩֵ
    public double getWeight( int v1 , int v2 ) throws Exception{
        if( v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size() )
            throw new Exception("����v1����v2Խ��!");
        return edge[v1][v2];
    }
    //����ڵ�
    public void insertVertex( Object vertex )throws Exception{
        vertices.insert(vertices.size(), vertex);
    }
    //�����<v1,v2>ȨֵΪweight
    public void insertEdge( int v1 , int v2 , double weight )throws Exception{
        if( v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size() )
            throw new Exception("����v1����v2Խ��!");
        edge[v1][v2] = weight;
        numOfEdges++;
    }
    //ɾ����<v1,v2>
    public void deleteEdge( int v1 , int v2 ) throws Exception{
        if( v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size() )
            throw new Exception("����v1����v2Խ��!");
        if( edge[v1][v2] == infinity || v1 == v2 )
            throw new Exception("�ñ߲�����!");
        edge[v1][v2] = infinity;
        numOfEdges--; 
    }
    //��ȡ�ڵ�v�ĵ�һ���ڽӵ㣬�������򷵻ظ��ڽӵ���±꣬���򷵻�-1
    public int getFirstNeighbor( int v ) throws Exception{
        if( v < 0 || v >= vertices.size() )
            throw new Exception("����vԽ��!"); 
        for( int col = 0;col < vertices.size() ; col++ ) {
            if( edge[v][col] > 0 && edge[v][col] < infinity )
                return col;
        }
        return -1;
    }
    //��֪v1�ǽڵ�v��һ���ڽӵ㣬��ȡv1�����һ��v���ڽӵ�
    public int getNextNeighbor( int v , int v1 ) throws Exception{
        if( v < 0 || v >= vertices.size() || v1 < 0 || v1 >= vertices.size() )
            throw new Exception("����v����v1Խ��!");
        for( int col = v1+1 ; col < vertices.size() ; col++ ) {
            if( edge[v][col] > 0 && edge[v][col] < infinity )
                return col;
        }
        return -1;
    }
   //����ͼ
    public static void createAdjMatGraph( AdjMatGraph graph , SeqList vert , SeqList edges ) throws Exception {
        Connection con = null;
        Object obj = null;
        for( int i = 0 ; i < vert.size() ; i++) {
            graph.insertVertex(vert.getData(i));
        }
        for( int j = 0 ; j < edges.size() ; j++ ) {
            obj = edges.getData(j);
            if( obj instanceof Connection )
                con = (Connection)(edges.getData(j)); 
            else
                throw new Exception("����ת���쳣!");
            graph.insertEdge(con.getRow(), con.getCol(), con.getWeight());
        } 
    }
    //��ͨͼ(������һ��������������ܷ���ͼ�����нڵ�)�����������������
    //1 ���ʽڵ�v������ǽڵ�v�ѷ���
    //2 ���ҽڵ�v�ĵ�һ���ڽӽڵ�w
    //3 ��w���ڣ������ִ�У������㷨����
    //4 ���ڵ�w��δ���������w���������������
    //5 ���ҽڵ�v��w�ڽӽڵ����һ���ڽӽڵ�w��ת3
    private void depthFirstSearch( int v , boolean visited[] , Visit vs )throws Exception{
        vs.visit(this.getValue(v));
        visited[v]=true;
        int w = this.getFirstNeighbor(v);
        while( w != -1 ) {
            if( !visited[w] )
                depthFirstSearch(w,visited,vs);
            w=this.getNextNeighbor(v, w);
        }
    }
    //��ͨͼ(������һ��������������ܷ���ͼ�����нڵ�)�Ĺ��������������
    private void broadFirstSearch( int v , boolean visited[] , Visit vs )throws Exception{
        int u , w ;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        vs.visit(getValue(v));
        visited[v]=true;
        queue.offer(v);
        while(!queue.isEmpty()) {
            u = queue.poll();
            w = getFirstNeighbor(u);
            while( w != -1 ) {
                if( !visited[w] ) {
                    vs.visit(getValue(w));
                    visited[w]=true;
                    queue.offer(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
        
    }
}
