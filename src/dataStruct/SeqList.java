package dataStruct;

public class SeqList implements List{
    private final int defaultSize = 10;
    //����������������Ԫ�ظ���
    private int maxSize;
    //�����е�ǰ��ȡ������Ԫ�صĸ���
    private int size;
    //�洢����Ԫ�ص�����
    private Object[] listArray;
    public SeqList() {
        init(this.defaultSize);
    }
    public SeqList( int size ) {
        init(size);
    }
    private void init( int size ) {
        this.maxSize = size;
        this.size = 0;
        this.listArray = new Object[size];
    }
    //������obj���뵽�����±�Ϊi��λ��
    @Override
    public void insert(int i, Object obj) throws Exception {
        if( size == maxSize )
            throw new Exception("˳����������޷���������!");
        if( i < 0 || i > size)
            throw new Exception("��������!");
        for( int j = size ; j > i ; j-- ) 
            listArray[j] = listArray[j-1];
        this.listArray[i]=obj;
        this.size++;
    }
    //������obj׷�ӵ�����β��
    public void add( Object obj ) throws Exception{
        if( size == maxSize )
            throw new Exception("˳����������޷���������!");
        this.listArray[size]=obj;
        size++;
    }
    @Override
    public Object delete(int i) throws Exception {
        if( size == 0 )
            throw new Exception("˳���Ϊ�գ��޷�ɾ��!");
        if( i < 0 || i >= size)
            throw new Exception("��������!");
        Object tmp = listArray[i];
        for( int j = i ; j < size-1 ; j++ )
            listArray[j] = listArray[j+1];
        size--;
        return tmp;
    }

    @Override
    public Object getData(int i) throws Exception {
        if( i<0 || i>=size)
            throw new Exception("��������!");
        return this.listArray[i];
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.size == 0;
    }
    public boolean isFull() {
        // TODO Auto-generated method stub
        return this.size == this.maxSize;
    }

}
