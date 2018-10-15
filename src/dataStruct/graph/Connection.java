package dataStruct.graph;
/**
   * 表示图中两个节点的连线
 * @author Administrator
 *
 */
public class Connection {
    private int row;
    private int col;
    private double weight;
    public Connection() {
    }
    public Connection( int row , int col , double weight ) {
        this.row = row;
        this.col = col;
        this.weight = weight;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Connection [row=" + row + ", col=" + col + ", weight=" + weight + "]";
    }
    
}
