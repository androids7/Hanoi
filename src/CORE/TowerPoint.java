package CORE;
/*
 * TowerPoint.java
 *
 * Created on 2007年5月5日, 下午11:40
 *
 * 柱子的指针,即当前是否有盘子拿起,若有,拿起的盘子编号,位于第几根柱子上
 */

/**
 *
 * @author js
 */
public class TowerPoint {
    private boolean haveDisk;//当前柱子上是否有盘子
    private int diskNumber;//指针上的盘子编号
    private int position;//初始时位于第一根柱子上
    //柱子指针构造方法
    public TowerPoint() {
        this.haveDisk=false;
        this.diskNumber=0;
        this.position=0;//取值为0-2分别代表1,2,3号柱子
    }
    
    //获得指针状态
    public boolean getHaveDisk() {
        return haveDisk;
    }
    
    //设置指针状态
    public void setHaveDisk(boolean boo) {
        this.haveDisk=boo;
    }
    
    //设置盘子标号
    public void setDisk(int num) {
        this.diskNumber=num;
        haveDisk=true;
    }
    
    //获得盘子编号
    public int  getDisk() {
        return diskNumber;
    }
    
    //获得指针位置
    public int getPosition(){
        return position;
    }
    //设置指针为止
    public void setPosition(int i){
        this.position=i;
    }
}

