package dataStruct;

public interface List {
    /**
            * ����
     * @param i
     * @param obj
     * @throws Exception
     */
    public void insert ( int i , Object obj ) throws Exception;
    /**
            * ɾ��
     * @param i
     * @return
     * @throws Exception
     */
    public Object delete( int i ) throws Exception;
    /**
            * ȡ����Ԫ��
     * @param i
     * @return
     * @throws Exception
     */
    public Object getData( int i ) throws Exception;
    /**
            * ��Ԫ�ظ���
     * @return
     */
    public int size();
    /**
            * �п�
     * @return
     */
    public boolean isEmpty();

}
