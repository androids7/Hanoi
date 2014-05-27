package CORE;
/*
 * Disk.java
 *
 * Created on 2007年5月7日, 上午10:31
 *
 * 盘子类,每个盘子有对应的属性:编号,宽,高
 */

/**
 *
 * @author js
 */
public class Disk {
    int number;//盘子的编号，每个盘子的编号为唯一的
    int width;//盘子的宽度
    int height;//盘子的高度
    public Disk(int number,int sum,int cwidth,int cheight) {
        this.number=number;
        width=cwidth*25*(number+1)/(100*sum)+5;
        this.height=(int)(cheight*3/100);
    }
    //得到盘子编号
    public int getNumber() {
        return this.number;
    }
    //返回盘子的宽度
    public int getWidth(){
        return this.width;
    }
    //返回盘子的高度
    public int getHeight(){
        return this.height;
    }
}
