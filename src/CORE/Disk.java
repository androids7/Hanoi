package CORE;
/*
 * Disk.java
 *
 * Created on 2007��5��7��, ����10:31
 *
 * ������,ÿ�������ж�Ӧ������:���,��,��
 */

/**
 *
 * @author js
 */
public class Disk {
    int number;//���ӵı�ţ�ÿ�����ӵı��ΪΨһ��
    int width;//���ӵĿ��
    int height;//���ӵĸ߶�
    public Disk(int number,int sum,int cwidth,int cheight) {
        this.number=number;
        width=cwidth*25*(number+1)/(100*sum)+5;
        this.height=(int)(cheight*3/100);
    }
    //�õ����ӱ��
    public int getNumber() {
        return this.number;
    }
    //�������ӵĿ��
    public int getWidth(){
        return this.width;
    }
    //�������ӵĸ߶�
    public int getHeight(){
        return this.height;
    }
}
