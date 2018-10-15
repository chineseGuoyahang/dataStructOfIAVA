package dataStruct.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import dataStruct.SeqList;

/**
   * 图的邻接矩阵表示法：当图中节点数目较小且边较多时效率较高
   *图节点的数据元素存储在一个数组中
   *图的边的权值信息存放在一个二维数组中
 * @author Administrator
 *
 */
public class AdjMatGraph {
    //表示两节点之前没有连线，权值为无穷大量
    private static final double infinity = Double.NEGATIVE_INFINITY;
    //表示矩阵对角线上的节点，权值为0
    private static final double zero = 0.0;
    private SeqList vertices;//存储节点的顺序表
    private double[][] edge;//存储边的二维数组
    private int numOfEdges;//边的个数
    //通常留一个无参构造
    public AdjMatGraph() {
    }
    //构造函数
    public AdjMatGraph( int countOfVertices ) {
        //分配空间
        vertices = new SeqList(countOfVertices);
        edge = new double[countOfVertices][countOfVertices];
        //初始化二位数组，edge[i][j]
        //如果i=j，cost就为0，i!=j cost = infinity
        for( int i=0 ; i<countOfVertices ; i++ ) {
            for( int j=0 ; j<countOfVertices ; j++ ) {
                if( i==j )
                    edge[i][j]=zero;
                else
                    edge[i][j]=infinity;
            }
        }
        //初始化边的个数
        this.numOfEdges = 0;
    }
    //返回节点个数
    public int getNumOfVertices() {
        return vertices.size();
    }
    //返回边的个数
    public int getNumOfEdges() {
        return this.numOfEdges;
    }
    //返回节点v的数据元素
    public Object getValue( int v ) throws  Exception{
        return vertices.getData(v);
    }
    //返回边< v1 , v2 >的权值
    public double getWeight( int v1 , int v2 ) throws Exception{
        if( v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size() )
            throw new Exception("参数v1或者v2越界!");
        return edge[v1][v2];
    }
    //插入节点
    public void insertVertex( Object vertex )throws Exception{
        vertices.insert(vertices.size(), vertex);
    }
    //插入边<v1,v2>权值为weight
    public void insertEdge( int v1 , int v2 , double weight )throws Exception{
        if( v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size() )
            throw new Exception("参数v1或者v2越界!");
        edge[v1][v2] = weight;
        numOfEdges++;
    }
    //删除边<v1,v2>
    public void deleteEdge( int v1 , int v2 ) throws Exception{
        if( v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size() )
            throw new Exception("参数v1或者v2越界!");
        if( edge[v1][v2] == infinity || v1 == v2 )
            throw new Exception("该边不存在!");
        edge[v1][v2] = infinity;
        numOfEdges--; 
    }
    //获取节点v的第一个邻接点，若存在则返回该邻接点的下标，否则返回-1
    public int getFirstNeighbor( int v ) throws Exception{
        if( v < 0 || v >= vertices.size() )
            throw new Exception("参数v越界!"); 
        for( int col = 0;col < vertices.size() ; col++ ) {
            if( edge[v][col] > 0 && edge[v][col] < infinity )
                return col;
        }
        return -1;
    }
    //已知v1是节点v的一个邻接点，获取v1后的下一个v的邻接点
    public int getNextNeighbor( int v , int v1 ) throws Exception{
        if( v < 0 || v >= vertices.size() || v1 < 0 || v1 >= vertices.size() )
            throw new Exception("参数v或者v1越界!");
        for( int col = v1+1 ; col < vertices.size() ; col++ ) {
            if( edge[v][col] > 0 && edge[v][col] < infinity )
                return col;
        }
        return -1;
    }
   //创建图
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
                throw new Exception("类型转换异常!");
            graph.insertEdge(con.getRow(), con.getCol(), con.getWeight());
        } 
    }
    //连通图(从任意一个顶点出发，总能访问图的所有节点)的深度优先搜索遍历
    //1 访问节点v，并标记节点v已访问
    //2 查找节点v的第一个邻接节点w
    //3 若w存在，则继续执行，否则算法结束
    //4 若节点w尚未被访问则对w进行深度优先搜索
    //5 查找节点v的w邻接节点的下一个邻接节点w，转3
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
    //连通图(从任意一个顶点出发，总能访问图的所有节点)的广度优先搜索遍历
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
