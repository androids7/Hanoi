package CORE;
/*
 * Tower.java
 *
 * Created on 2007年5月5日, 下午9:33
 *
 * 柱子上有哪些盘子,编号分别为多少.并对当前柱子上的盘子进行添加删除
 */

/**
 *
 * @author js
 */
public class Tower {
    private int number;//当前柱子上有几个盘子
    public int[] towerDisk=new int[9];//同一柱子上最多会有9个盘子,分别是几号盘子
    
    public Tower(int n) {//构造方法，生成柱子对象，有N个盘子
        this.number=n;
    }
    
    //返回当前柱子上的盘子数目
    public int getNumber() {
        return number;
    }
    
    //设置柱子上的盘子,diskNumber为放入盘子的编号,插入当前数组第一元素,其他元素依次后移,number自加1
    public void addDisk(int diskNumber) {
        for(int i=number;i>=1;i--){
            towerDisk[i]=towerDisk[i-1];
        }
        towerDisk[0]=diskNumber;
        number++;
    }
    
    //返回当前柱子上的盘子,然后将数组元素依次前移,number自减1
    public void delDisk() {
        number--;
        for(int i=0;i<=number-1;i++){
            towerDisk[i]=towerDisk[i+1];
        }
    }
    //返回当前柱子上第一个盘子的编号
    public int getDisk(){
        return towerDisk[0];
    }
    
    //返回当前柱子上第x+1个盘子的编号
    public int getDisk(int x){
        return towerDisk[x-1];
    }
}