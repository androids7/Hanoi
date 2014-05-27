package CORE;
/*
 * Tower.java
 *
 * Created on 2007��5��5��, ����9:33
 *
 * ����������Щ����,��ŷֱ�Ϊ����.���Ե�ǰ�����ϵ����ӽ������ɾ��
 */

/**
 *
 * @author js
 */
public class Tower {
    private int number;//��ǰ�������м�������
    public int[] towerDisk=new int[9];//ͬһ������������9������,�ֱ��Ǽ�������
    
    public Tower(int n) {//���췽�����������Ӷ�����N������
        this.number=n;
    }
    
    //���ص�ǰ�����ϵ�������Ŀ
    public int getNumber() {
        return number;
    }
    
    //���������ϵ�����,diskNumberΪ�������ӵı��,���뵱ǰ�����һԪ��,����Ԫ�����κ���,number�Լ�1
    public void addDisk(int diskNumber) {
        for(int i=number;i>=1;i--){
            towerDisk[i]=towerDisk[i-1];
        }
        towerDisk[0]=diskNumber;
        number++;
    }
    
    //���ص�ǰ�����ϵ�����,Ȼ������Ԫ������ǰ��,number�Լ�1
    public void delDisk() {
        number--;
        for(int i=0;i<=number-1;i++){
            towerDisk[i]=towerDisk[i+1];
        }
    }
    //���ص�ǰ�����ϵ�һ�����ӵı��
    public int getDisk(){
        return towerDisk[0];
    }
    
    //���ص�ǰ�����ϵ�x+1�����ӵı��
    public int getDisk(int x){
        return towerDisk[x-1];
    }
}