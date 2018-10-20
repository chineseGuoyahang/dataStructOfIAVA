
package dataStruct.graph.minCostSpanTree;
/**
 * �������ݵķ�ʽ<v1,v2> ��vertex=v2 weight=weight<v1,v2>
 * @author Administrator
 *
 */
public class MinSpanTree {
    private Object vertex;
    private double weight;
    public MinSpanTree(){}
    public MinSpanTree( Object obj , double w ){
        this.vertex = obj;
        this.weight = w;
    }
    public Object getVertex() {
        return vertex;
    }
    public void setVertex(Object vertex) {
        this.vertex = vertex;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return this.vertex.toString();
    }
    
}
