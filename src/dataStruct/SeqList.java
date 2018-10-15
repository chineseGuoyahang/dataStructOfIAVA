package dataStruct;

public class SeqList implements List{
    private final int defaultSize = 10;
    //数组允许的最大数据元素个数
    private int maxSize;
    //数组中当前存取的数据元素的个数
    private int size;
    //存储数据元素的数组
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
    //将对象obj插入到数组下标为i的位置
    @Override
    public void insert(int i, Object obj) throws Exception {
        if( size == maxSize )
            throw new Exception("顺序表已满，无法插入数据!");
        if( i < 0 || i > size)
            throw new Exception("参数错误!");
        for( int j = size ; j > i ; j-- ) 
            listArray[j] = listArray[j-1];
        this.listArray[i]=obj;
        this.size++;
    }
    //将对象obj追加到数组尾端
    public void add( Object obj ) throws Exception{
        if( size == maxSize )
            throw new Exception("顺序表已满，无法插入数据!");
        this.listArray[size]=obj;
        size++;
    }
    @Override
    public Object delete(int i) throws Exception {
        if( size == 0 )
            throw new Exception("顺序表为空，无法删除!");
        if( i < 0 || i >= size)
            throw new Exception("参数错误!");
        Object tmp = listArray[i];
        for( int j = i ; j < size-1 ; j++ )
            listArray[j] = listArray[j+1];
        size--;
        return tmp;
    }

    @Override
    public Object getData(int i) throws Exception {
        if( i<0 || i>=size)
            throw new Exception("参数错误!");
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
