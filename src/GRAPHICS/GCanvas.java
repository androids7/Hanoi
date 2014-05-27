package GRAPHICS;
/*
 * GCanvas.java
 *
 * Created on 2007年5月7日, 上午9:35
 *
 * 游戏图形处理，按键响应,以及部分游戏逻辑
 */

/**
 *
 * @author js
 */
import java.lang.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.Graphics;
import CORE.Disk;
import CORE.Tower;
import CORE.TowerPoint;

public class GCanvas extends Canvas implements Runnable{
    int diskNum ;//定义盘子数
    //定义a,b,c三个柱子上是否有盘子，有哪些盘子
    private CORE.Tower[] tower=new Tower[3];//3根柱子
    private CORE.Disk[] disk=new Disk[9];//最多有9个盘子
    private CORE.TowerPoint tp;//指针
    private int stepN=0;//总步数
    public Thread aa;
    //初始化,生成游戏的初始数据
    public GCanvas(int dn) {
        this.diskNum=dn;
        //3个柱子,分别编号为0,1,2
        this.tower[0]=new Tower(diskNum);
        this.tower[1]=new Tower(0);
        this.tower[2]=new Tower(0);
        tp=new TowerPoint();
        int cwidth=this.getWidth();
        int cheight=this.getHeight();
        
        CORE.Disk[] disk=new Disk[diskNum];
        for(int i=0;i<=diskNum-1;i++){
            this.disk[i]=new Disk(i,diskNum,cwidth,cheight);
            this.tower[0].towerDisk[i]=i;
        }
    }
    
    public void run() {
        /*    将游戏重新初始化     */
        tower[0]=tower[1]=tower[2]=null;
        tp=null;
        stepN=0;
        this.tower[0]=new Tower(diskNum);
        this.tower[1]=new Tower(0);
        this.tower[2]=new Tower(0);
        tp=new TowerPoint();
        for(int i=0;i<=diskNum-1;i++){
            this.tower[0].towerDisk[i]=i;
        }
        repaint();
        pause(500);
        /*    将游戏重新初始化     */
        AutoPlay(diskNum,0,1,2);//自动演示功能
    }
    
    protected void paint(Graphics g) {
        g.setColor(255,255,220);//设置背景颜色
        g.fillRect(0,0,this.getWidth(),this.getHeight());//画背景
        paintTowerPoint(g);
        paintTower(g);
        paintDisk(g);
        
        g.setColor(0,0,0);
        g.drawString("第"+stepN+"步",15,10,0);
        
        if(tower[2].getNumber()==this.diskNum){
            g.setColor(255,255,255);
            g.fillRect(0,0,this.getWidth(),this.getHeight()*20/100);
            g.setColor(0,0,0);
            g.setFont(Font.getDefaultFont());
            g.drawString("恭喜您过关!!共走了"+stepN+"步^_^",15,10,0);
        }
    }
//画TowerPoint,若有盘子在其上,同时画盘子
    private void paintTowerPoint(Graphics g){
        char a='↓';
        int height=this.getHeight();
        int width=this.getWidth();
        int x=0,y=0,x0=0,x1=0,y0=0,y1=0;//x,y为箭头的坐标,x0,x1为盘子的横坐标起点和终点
        y=(int)(height*2/10);
        int tmp=(int)(height*28/100);
        
        //计算指针的坐标
        switch(tp.getPosition()){
            case 0:
                x=(int)(width*2/10);
                break;
            case 1:
                x=(int)(width*5/10);
                break;
            case 2:
                x=(int)(width*8/10);
                break;
        }
        g.setColor(0x000000);//设置颜色
        g.drawChar(a,x-4,y,0);//绘制指针
        
        ///////////////////
        if(tp.getHaveDisk()==true){//判断指针上是否有盘子,若有则计算坐标并画出
            int w=disk[tp.getDisk()].getWidth();//盘子的宽度
            int h=disk[tp.getDisk()].getHeight();//盘子的高度
            y0=(int)(tmp+h);//盘子的纵坐标起点
            switch(tp.getPosition()){
                case 0:
                    x0=x-w/2;
                    break;
                case 1:
                    x0=x-w/2;
                    break;
                case 2:
                    x0=x-w/2;
                    break;
            }
            g.setColor(209,165,29);//设置盘子的颜色
            //绘制已拿起的盘子
            g.fillRect(x0,y0,w,h);
            
        }
    }
    
//画柱子
    private void paintTower(Graphics g){
        //获取Canvas的宽高
        int height=this.getHeight();
        int width=this.getWidth();
        //y0为Y坐标起点,y1为Y坐标终点
        int y0=height*35/100;
        int y1=height*95/100;
        
        g.setColor(0x000000);//设置柱子的颜色
        //此处为了节省内存,重新给tmp赋值,作为直线的横坐标
        int tmp=(int)(width*2/10);
        g.drawLine(tmp,y0,tmp,y1);//第一根柱子
        tmp=(int)(width*5/10);
        g.drawLine(tmp,y0,tmp,y1);//第二根柱子
        tmp=(int)(width*8/10);
        g.drawLine(tmp,y0,tmp,y1);//第三根柱子
        /////////
        g.fillRect(0,y1,width,5);//底下的横线
    }
    
//画每个柱子上的盘子
    private void paintDisk(Graphics g){
        //获取Canvas的宽高
        int height=this.getHeight();
        int width=this.getWidth();
        int y0;
        g.setColor(106,130,219);//设置盘子的颜色RGB=0x0000ff,为蓝色
        int tmp[]=new int[3];
        tmp[0]=width*2/10;//第一根柱子的横坐标
        tmp[1]=width*5/10;//第二根柱子的横坐标
        tmp[2]=width*8/10;//第三根柱子的横坐标
        
        for(int j=0;j<=2;j++){
            y0=height*90/100;
            for(int i=tower[j].getNumber();i>0;i--){
                int n=tower[j].getDisk(i);
                //返回1/2的盘子宽度
                int w=this.disk[tower[j].getDisk(i)].getWidth();
                int h=this.disk[tower[j].getDisk(i)].getHeight();
                int x0=tmp[j]-w/2;
                g.fillRect(x0,y0,w,h);
                //给出下个盘子的坐标
                y0=y0-height*5/100;
            }
        }
        
        
    }
    
//按键响应
    protected void keyPressed(int keyCode){
        if(tower[2].getNumber()!=this.diskNum){
            int ga=this.getGameAction(keyCode);
            if(ga==LEFT || keyCode==this.KEY_NUM4){//按键为左或者4
                int i=tp.getPosition();
                if(i==0) tp.setPosition(2);
                else if(i==1) tp.setPosition(0);
                else if(i==2) tp.setPosition(1);
            }else if(ga==RIGHT || keyCode==this.KEY_NUM6){//按键为右或者6
                int i=tp.getPosition();
                if(i==0) tp.setPosition(1);
                else if(i==1) tp.setPosition(2);
                else if(i==2) tp.setPosition(0);
            }else if(ga==this.FIRE || keyCode==this.KEY_NUM5){//按键为确认或者5
                if(tp.getHaveDisk()==false && tower[tp.getPosition()].getNumber()!=0){
                    pickUp();
                }else if(tp.getHaveDisk()==true){
                    if(tp.getDisk()<tower[tp.getPosition()].getDisk() || tower[tp.getPosition()].getNumber()==0 ){//如果指针上的盘子编号小于当前柱子顶的
                        putDown();
                    }else if(tp.getDisk()>tower[tp.getPosition()].getDisk()){//大于的情况下,因为不可能等于
                        System.out.print("错误的操作!");
                    }
                }
            }else if(keyCode==this.KEY_POUND){//按键为#号键
                if(aa==null || aa.isAlive()==false){
                    aa=new Thread(this);
                    aa.start();
                }
            }
        }
        repaint();
    }
    
//自动演示AutoPlay
    public void AutoPlay(int n,int A,int B,int C){
        if ( n == 1 ){
            tp.setPosition(A);
            pickUp();
            repaint();
            pause(500);
            tp.setPosition(C);
            putDown();
            repaint();
            pause(500);
        } else if(n > 1) {
            AutoPlay(n-1, A, C, B);
            tp.setPosition(A);
            pickUp();
            repaint();
            pause(500);
            tp.setPosition(C);
            putDown();
            repaint();
            pause(500);
            AutoPlay(n-1, B, A, C);
        }
    }
    public void pause(long time){
        try {
            aa.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public void pickUp(){
        int n=tp.getPosition();//n为当前指针坐标
        tp.setDisk(tower[n].getDisk());//拿起盘子
        tower[n].delDisk();//删除柱子顶的盘子
        tp.setHaveDisk(true);//设置指针上有盘子
        stepN++;
    }
    public void putDown(){
        tower[tp.getPosition()].addDisk(tp.getDisk());//放下盘子
        tp.setHaveDisk(false);//设置指针为空
    }
}