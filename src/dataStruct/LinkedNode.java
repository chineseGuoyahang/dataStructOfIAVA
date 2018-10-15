package dataStruct;

public class LinkedNode {
    Object element;
    LinkedNode next;
    LinkedNode(){
        this.element = null;
        this.next = null;
    }
    LinkedNode( Object obj ){
        this.element = obj;
        this.next = null;
    }
    LinkedNode( LinkedNode next ){
        this.element = null;
        this.next = next;
    }
    LinkedNode( Object obj , LinkedNode next ){
        this.element = obj;
        this.next = next;
    }
    public Object getElement() {
        return element;
    }
    public void setElement(Object obj) {
        this.element = obj;
    }
    public LinkedNode getNext() {
        return next;
    }
    public void setNext(LinkedNode next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return this.element.toString();
    }
    
}
