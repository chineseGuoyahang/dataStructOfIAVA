package dataStruct;

public interface List {
    /**
            * 插入
     * @param i
     * @param obj
     * @throws Exception
     */
    public void insert ( int i , Object obj ) throws Exception;
    /**
            * 删除
     * @param i
     * @return
     * @throws Exception
     */
    public Object delete( int i ) throws Exception;
    /**
            * 取数据元素
     * @param i
     * @return
     * @throws Exception
     */
    public Object getData( int i ) throws Exception;
    /**
            * 求元素个数
     * @return
     */
    public int size();
    /**
            * 判空
     * @return
     */
    public boolean isEmpty();

}
