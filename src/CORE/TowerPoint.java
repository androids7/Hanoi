package CORE;
/*
 * TowerPoint.java
 *
 * Created on 2007��5��5��, ����11:40
 *
 * ���ӵ�ָ��,����ǰ�Ƿ�����������,����,��������ӱ��,λ�ڵڼ���������
 */

/**
 *
 * @author js
 */
public class TowerPoint {
    private boolean haveDisk;//��ǰ�������Ƿ�������
    private int diskNumber;//ָ���ϵ����ӱ��
    private int position;//��ʼʱλ�ڵ�һ��������
    //����ָ�빹�췽��
    public TowerPoint() {
        this.haveDisk=false;
        this.diskNumber=0;
        this.position=0;//ȡֵΪ0-2�ֱ����1,2,3������
    }
    
    //���ָ��״̬
    public boolean getHaveDisk() {
        return haveDisk;
    }
    
    //����ָ��״̬
    public void setHaveDisk(boolean boo) {
        this.haveDisk=boo;
    }
    
    //�������ӱ��
    public void setDisk(int num) {
        this.diskNumber=num;
        haveDisk=true;
    }
    
    //������ӱ��
    public int  getDisk() {
        return diskNumber;
    }
    
    //���ָ��λ��
    public int getPosition(){
        return position;
    }
    //����ָ��Ϊֹ
    public void setPosition(int i){
        this.position=i;
    }
}

