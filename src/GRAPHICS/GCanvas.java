package GRAPHICS;
/*
 * GCanvas.java
 *
 * Created on 2007��5��7��, ����9:35
 *
 * ��Ϸͼ�δ���������Ӧ,�Լ�������Ϸ�߼�
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
    int diskNum ;//����������
    //����a,b,c�����������Ƿ������ӣ�����Щ����
    private CORE.Tower[] tower=new Tower[3];//3������
    private CORE.Disk[] disk=new Disk[9];//�����9������
    private CORE.TowerPoint tp;//ָ��
    private int stepN=0;//�ܲ���
    public Thread aa;
    //��ʼ��,������Ϸ�ĳ�ʼ����
    public GCanvas(int dn) {
        this.diskNum=dn;
        //3������,�ֱ���Ϊ0,1,2
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
        /*    ����Ϸ���³�ʼ��     */
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
        /*    ����Ϸ���³�ʼ��     */
        AutoPlay(diskNum,0,1,2);//�Զ���ʾ����
    }
    
    protected void paint(Graphics g) {
        g.setColor(255,255,220);//���ñ�����ɫ
        g.fillRect(0,0,this.getWidth(),this.getHeight());//������
        paintTowerPoint(g);
        paintTower(g);
        paintDisk(g);
        
        g.setColor(0,0,0);
        g.drawString("��"+stepN+"��",15,10,0);
        
        if(tower[2].getNumber()==this.diskNum){
            g.setColor(255,255,255);
            g.fillRect(0,0,this.getWidth(),this.getHeight()*20/100);
            g.setColor(0,0,0);
            g.setFont(Font.getDefaultFont());
            g.drawString("��ϲ������!!������"+stepN+"��^_^",15,10,0);
        }
    }
//��TowerPoint,��������������,ͬʱ������
    private void paintTowerPoint(Graphics g){
        char a='��';
        int height=this.getHeight();
        int width=this.getWidth();
        int x=0,y=0,x0=0,x1=0,y0=0,y1=0;//x,yΪ��ͷ������,x0,x1Ϊ���ӵĺ����������յ�
        y=(int)(height*2/10);
        int tmp=(int)(height*28/100);
        
        //����ָ�������
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
        g.setColor(0x000000);//������ɫ
        g.drawChar(a,x-4,y,0);//����ָ��
        
        ///////////////////
        if(tp.getHaveDisk()==true){//�ж�ָ�����Ƿ�������,������������겢����
            int w=disk[tp.getDisk()].getWidth();//���ӵĿ��
            int h=disk[tp.getDisk()].getHeight();//���ӵĸ߶�
            y0=(int)(tmp+h);//���ӵ����������
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
            g.setColor(209,165,29);//�������ӵ���ɫ
            //���������������
            g.fillRect(x0,y0,w,h);
            
        }
    }
    
//������
    private void paintTower(Graphics g){
        //��ȡCanvas�Ŀ��
        int height=this.getHeight();
        int width=this.getWidth();
        //y0ΪY�������,y1ΪY�����յ�
        int y0=height*35/100;
        int y1=height*95/100;
        
        g.setColor(0x000000);//�������ӵ���ɫ
        //�˴�Ϊ�˽�ʡ�ڴ�,���¸�tmp��ֵ,��Ϊֱ�ߵĺ�����
        int tmp=(int)(width*2/10);
        g.drawLine(tmp,y0,tmp,y1);//��һ������
        tmp=(int)(width*5/10);
        g.drawLine(tmp,y0,tmp,y1);//�ڶ�������
        tmp=(int)(width*8/10);
        g.drawLine(tmp,y0,tmp,y1);//����������
        /////////
        g.fillRect(0,y1,width,5);//���µĺ���
    }
    
//��ÿ�������ϵ�����
    private void paintDisk(Graphics g){
        //��ȡCanvas�Ŀ��
        int height=this.getHeight();
        int width=this.getWidth();
        int y0;
        g.setColor(106,130,219);//�������ӵ���ɫRGB=0x0000ff,Ϊ��ɫ
        int tmp[]=new int[3];
        tmp[0]=width*2/10;//��һ�����ӵĺ�����
        tmp[1]=width*5/10;//�ڶ������ӵĺ�����
        tmp[2]=width*8/10;//���������ӵĺ�����
        
        for(int j=0;j<=2;j++){
            y0=height*90/100;
            for(int i=tower[j].getNumber();i>0;i--){
                int n=tower[j].getDisk(i);
                //����1/2�����ӿ��
                int w=this.disk[tower[j].getDisk(i)].getWidth();
                int h=this.disk[tower[j].getDisk(i)].getHeight();
                int x0=tmp[j]-w/2;
                g.fillRect(x0,y0,w,h);
                //�����¸����ӵ�����
                y0=y0-height*5/100;
            }
        }
        
        
    }
    
//������Ӧ
    protected void keyPressed(int keyCode){
        if(tower[2].getNumber()!=this.diskNum){
            int ga=this.getGameAction(keyCode);
            if(ga==LEFT || keyCode==this.KEY_NUM4){//����Ϊ�����4
                int i=tp.getPosition();
                if(i==0) tp.setPosition(2);
                else if(i==1) tp.setPosition(0);
                else if(i==2) tp.setPosition(1);
            }else if(ga==RIGHT || keyCode==this.KEY_NUM6){//����Ϊ�һ���6
                int i=tp.getPosition();
                if(i==0) tp.setPosition(1);
                else if(i==1) tp.setPosition(2);
                else if(i==2) tp.setPosition(0);
            }else if(ga==this.FIRE || keyCode==this.KEY_NUM5){//����Ϊȷ�ϻ���5
                if(tp.getHaveDisk()==false && tower[tp.getPosition()].getNumber()!=0){
                    pickUp();
                }else if(tp.getHaveDisk()==true){
                    if(tp.getDisk()<tower[tp.getPosition()].getDisk() || tower[tp.getPosition()].getNumber()==0 ){//���ָ���ϵ����ӱ��С�ڵ�ǰ���Ӷ���
                        putDown();
                    }else if(tp.getDisk()>tower[tp.getPosition()].getDisk()){//���ڵ������,��Ϊ�����ܵ���
                        System.out.print("����Ĳ���!");
                    }
                }
            }else if(keyCode==this.KEY_POUND){//����Ϊ#�ż�
                if(aa==null || aa.isAlive()==false){
                    aa=new Thread(this);
                    aa.start();
                }
            }
        }
        repaint();
    }
    
//�Զ���ʾAutoPlay
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
        int n=tp.getPosition();//nΪ��ǰָ������
        tp.setDisk(tower[n].getDisk());//��������
        tower[n].delDisk();//ɾ�����Ӷ�������
        tp.setHaveDisk(true);//����ָ����������
        stepN++;
    }
    public void putDown(){
        tower[tp.getPosition()].addDisk(tp.getDisk());//��������
        tp.setHaveDisk(false);//����ָ��Ϊ��
    }
}