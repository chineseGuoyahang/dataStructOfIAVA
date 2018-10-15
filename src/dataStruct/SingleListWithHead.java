package dataStruct;

public class SingleListWithHead{
    //头结点
    LinkedNode head;
    //数据元素个数
    int size;
    //无参构造函数
    SingleListWithHead(){
        head = new LinkedNode();
        this.size = 0;
    }
    void makeEmpty() {
        
    }
    int getLength() {
        return 0;
    }
    LinkedNode getHead() {
        return head;
    }
    LinkedNode search( Object obj ) {
        LinkedNode workPoint = head.next;
        while( workPoint != null ) {
            if( workPoint.element.equals(obj) )
                return workPoint;
            else
                workPoint=workPoint.next;
        }
        return null;
    }
    LinkedNode Locate( int i )throws Exception {
        if( i < 0 || i > size-1)
            throw new Exception("下标越界!");
        LinkedNode workPoint = head.next;
        int j = 0;
        while( j < i ) {
            workPoint = workPoint.next;
            j++;
        }
        return workPoint;
    }
    Object getData( int i )throws Exception {
        LinkedNode tmp = Locate(i);
        return tmp.element;
    }
    void setData( int i , Object obj ) throws Exception {
        LinkedNode tmp = Locate(i);
        tmp.element = obj;
    }
    boolean insert( int i , Object obj ) throws Exception {
        LinkedNode pre = Locate(i-1);
        pre.next = new LinkedNode( obj , pre.next );
        size++;
        return true;
    }
    Object remove( int i ) throws Exception {
        LinkedNode pre = Locate(i-1);
        Object obj = pre.next.element;
        pre.next = pre.next.next;
        return obj; 
    }
    boolean isEmpty() {
        return size == 0 ;
    }
    boolean isFull() {
        return false;
    }
    void Sort() {};
    void input() {};
    void output() {};
}
