package UI;
/*
 * Hanoi.java
 *
 * Created on 2007年5月4日, 下午2:13
 * 游戏的主界面部分
 */

/**
 * @author js
 */
import GRAPHICS.GCanvas;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Hanoi extends MIDlet implements CommandListener {
    
    /** Creates a new instance of Hanoi */
    public Hanoi() {
        initialize();
    }
    
    private List mainList;//GEN-BEGIN:MVDFields
    private Command exitCommand;
    private Command okCommand;
    private Form aboutForm;
    private Form helpForm;
    private Command backCommand;
    private StringItem stringItem1;
    private GRAPHICS.GCanvas gCanvas;
    private StringItem stringItem2;
    private StringItem stringItem4;
    private StringItem stringItem3;
    private Image imageHelp;
    private Image imageExit;
    private Image imageInfo;
    private Image imageStart;
    private List optionList;
    private Command autoCommand;//GEN-END:MVDFields
    
//GEN-LINE:MVDMethods
    
    /** Called by the system to indicate that a command has been invoked on a particular displayable.//GEN-BEGIN:MVDCABegin
     * @param command the Command that ws invoked
     * @param displayable the Displayable on which the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:MVDCABegin
        // 主界面选单中的事件响应
        if (displayable == mainList) {//GEN-BEGIN:MVDCABody
            if (command == mainList.SELECT_COMMAND) {
                switch (get_mainList().getSelectedIndex()) {
                    case 0://GEN-END:MVDCABody
                        //第一项被选定时按选择键
                        getDisplay().setCurrent(get_optionList());//GEN-LINE:MVDCAAction7
                        
                        break;//GEN-BEGIN:MVDCACase7
                    case 1://GEN-END:MVDCACase7
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_helpForm());//GEN-LINE:MVDCAAction11
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase11
                    case 2://GEN-END:MVDCACase11
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_aboutForm());//GEN-LINE:MVDCAAction13
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase13
                    case 3://GEN-END:MVDCACase13
                        // Insert pre-action code here
                        exitMIDlet();//GEN-LINE:MVDCAAction15
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase15
                }
            } else if (command == okCommand) {//GEN-END:MVDCACase15
                switch (get_mainList().getSelectedIndex()) {
                    case 0:
                        getDisplay().setCurrent(get_optionList());
                        break;
                    case 1:
                        getDisplay().setCurrent(get_helpForm());
                        break;
                    case 2:
                        getDisplay().setCurrent(get_aboutForm());
                        break;
                    case 3:
                        exitMIDlet();
                        break;
                }
                // Do nothing//GEN-LINE:MVDCAAction19
                // Insert post-action code here
            } else if (command == exitCommand) {//GEN-LINE:MVDCACase19
                // Insert pre-action code here
                exitMIDlet();//GEN-LINE:MVDCAAction20
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase20
        } else if (displayable == aboutForm) {
            if (command == backCommand) {//GEN-END:MVDCACase20

                getDisplay().setCurrent(get_mainList());//GEN-LINE:MVDCAAction23
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase23
        } else if (displayable == helpForm) {
            if (command == backCommand) {//GEN-END:MVDCACase23

                getDisplay().setCurrent(get_mainList());//GEN-LINE:MVDCAAction38
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase38
        } else if (displayable == gCanvas) {
            if (command == backCommand) {//GEN-END:MVDCACase38
                gCanvas=null;
                getDisplay().setCurrent(get_mainList());//GEN-LINE:MVDCAAction56
                // Insert post-action code here
            } else if (command == exitCommand) {//GEN-LINE:MVDCACase56
                // Insert pre-action code here
                exitMIDlet();//GEN-LINE:MVDCAAction57
                // Insert post-action code here
            } else if (command == autoCommand) {//GEN-LINE:MVDCACase57
                if(gCanvas.aa==null || gCanvas.aa.isAlive()==false){
                    gCanvas.aa=new Thread(gCanvas);
                    gCanvas.aa.start();
                }// Insert pre-action code here
                // Do nothing//GEN-LINE:MVDCAAction124
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase124
        } else if (displayable == optionList) {
            if (command == backCommand) {//GEN-END:MVDCACase124
                // Insert pre-action code here
                getDisplay().setCurrent(get_mainList());//GEN-LINE:MVDCAAction108
                // Insert post-action code here
            } else if (command == okCommand) {//GEN-LINE:MVDCACase108
                // Insert pre-action code here
                getDisplay().setCurrent(get_gCanvas());//GEN-LINE:MVDCAAction107
                // Insert post-action code here
            } else if (command == optionList.SELECT_COMMAND) {//GEN-BEGIN:MVDCACase107
                switch (get_optionList().getSelectedIndex()) {
                    case 0://GEN-END:MVDCACase107
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_gCanvas());//GEN-LINE:MVDCAAction92
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase92
                    case 1://GEN-END:MVDCACase92
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_gCanvas());//GEN-LINE:MVDCAAction94
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase94
                    case 2://GEN-END:MVDCACase94
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_gCanvas());//GEN-LINE:MVDCAAction96
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase96
                    case 3://GEN-END:MVDCACase96
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_gCanvas());//GEN-LINE:MVDCAAction98
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase98
                    case 4://GEN-END:MVDCACase98
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_gCanvas());//GEN-LINE:MVDCAAction100
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase100
                    case 5://GEN-END:MVDCACase100
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_gCanvas());//GEN-LINE:MVDCAAction102
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase102
                    case 6://GEN-END:MVDCACase102
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_gCanvas());//GEN-LINE:MVDCAAction104
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase104
                }
            }
        }//GEN-END:MVDCACase104
        // Insert global post-action code here
}//GEN-LINE:MVDCAEnd
    
    /** This method initializes UI of the application.//GEN-BEGIN:MVDInitBegin
     */
    private void initialize() {//GEN-END:MVDInitBegin
        
        getDisplay().setCurrent(get_mainList());//GEN-LINE:MVDInitInit
        
    }//GEN-LINE:MVDInitEnd
    
    /**
     * This method should return an instance of the display.
     */
    public Display getDisplay() {//GEN-FIRST:MVDGetDisplay
        return Display.getDisplay(this);
    }//GEN-LAST:MVDGetDisplay
    
    /**
     * 退出程序
     */
    public void exitMIDlet() {//GEN-FIRST:MVDExitMidlet
        getDisplay().setCurrent(null);
        destroyApp(true);
        notifyDestroyed();
    }//GEN-LAST:MVDExitMidlet
    
    /** This method returns instance for mainList component and should be called instead of accessing mainList field directly.//GEN-BEGIN:MVDGetBegin2
     * @return Instance for mainList component
     */
    public List get_mainList() {
        if (mainList == null) {//GEN-END:MVDGetBegin2
            // Insert pre-init code here
            mainList = new List("\u6C49\u8BFA\u5854(hanoi Tower)", Choice.IMPLICIT, new String[] {//GEN-BEGIN:MVDGetInit2
                "\u5F00\u59CB\u6E38\u620F(Start)",
                "\u5E2E\u52A9(Help)",
                "\u5173\u4E8E(About)",
                "\u9000\u51FA(Exit)"
            }, new Image[] {
                get_imageStart(),
                get_imageHelp(),
                get_imageInfo(),
                get_imageExit()
            });
            mainList.addCommand(get_okCommand());
            mainList.addCommand(get_exitCommand());
            mainList.setCommandListener(this);
            mainList.setSelectedFlags(new boolean[] {
                false,
                false,
                false,
                false
            });//GEN-END:MVDGetInit2
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd2
        return mainList;
    }//GEN-END:MVDGetEnd2
    
    /** This method returns instance for exitCommand component and should be called instead of accessing exitCommand field directly.//GEN-BEGIN:MVDGetBegin4
     * @return Instance for exitCommand component
     */
    public Command get_exitCommand() {
        if (exitCommand == null) {//GEN-END:MVDGetBegin4
            // Insert pre-init code here
            exitCommand = new Command("\u9000\u51FA", Command.EXIT, 1);//GEN-LINE:MVDGetInit4
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd4
        return exitCommand;
    }//GEN-END:MVDGetEnd4
    
    /** This method returns instance for okCommand component and should be called instead of accessing okCommand field directly.//GEN-BEGIN:MVDGetBegin5
     * @return Instance for okCommand component
     */
    public Command get_okCommand() {
        if (okCommand == null) {//GEN-END:MVDGetBegin5
            // Insert pre-init code here
            okCommand = new Command("\u786E\u5B9A", Command.OK, 1);//GEN-LINE:MVDGetInit5
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd5
        return okCommand;
    }//GEN-END:MVDGetEnd5
    
    /** This method returns instance for aboutForm component and should be called instead of accessing aboutForm field directly.//GEN-BEGIN:MVDGetBegin17
     * @return Instance for aboutForm component
     */
    public Form get_aboutForm() {
        if (aboutForm == null) {//GEN-END:MVDGetBegin17
            // Insert pre-init code here
            aboutForm = new Form("\u5173\u4E8E(About)", new Item[] {//GEN-BEGIN:MVDGetInit17
                get_stringItem3(),
                get_stringItem1()
            });
            aboutForm.addCommand(get_backCommand());
            aboutForm.setCommandListener(this);//GEN-END:MVDGetInit17
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd17
        return aboutForm;
    }//GEN-END:MVDGetEnd17
    
    /** This method returns instance for helpForm component and should be called instead of accessing helpForm field directly.//GEN-BEGIN:MVDGetBegin18
     * @return Instance for helpForm component
     */
    public Form get_helpForm() {
        if (helpForm == null) {//GEN-END:MVDGetBegin18
            // Insert pre-init code here
            helpForm = new Form("\u5E2E\u52A9(Help)", new Item[] {//GEN-BEGIN:MVDGetInit18
                get_stringItem4(),
                get_stringItem2()
            });
            helpForm.addCommand(get_backCommand());
            helpForm.setCommandListener(this);//GEN-END:MVDGetInit18
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd18
        return helpForm;
    }//GEN-END:MVDGetEnd18
    
    /** This method returns instance for backCommand component and should be called instead of accessing backCommand field directly.//GEN-BEGIN:MVDGetBegin22
     * @return Instance for backCommand component
     */
    public Command get_backCommand() {
        if (backCommand == null) {//GEN-END:MVDGetBegin22
            // Insert pre-init code here
            backCommand = new Command("\u540E\u9000", Command.BACK, 1);//GEN-LINE:MVDGetInit22
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd22
        return backCommand;
    }//GEN-END:MVDGetEnd22
    
    
    /** This method returns instance for stringItem1 component and should be called instead of accessing stringItem1 field directly.//GEN-BEGIN:MVDGetBegin34
     * @return Instance for stringItem1 component
     */
    public StringItem get_stringItem1() {
        if (stringItem1 == null) {//GEN-END:MVDGetBegin34
            // Insert pre-init code here
            stringItem1 = new StringItem("\uFF0D\uFF0D\uFF0D\uFF0D\uFF0D\uFF0D\n\u6C49\u8BFA\u5854\u7684\u4F20\u8BF4", "\u3000\u3000\u5728\u5370\u5EA6\uFF0C\u6709\u8FD9\u4E48\u4E00\u4E2A\u53E4\u8001\u7684\u4F20\u8BF4\uFF1A\u5728\u4E16\u754C\u4E2D\u5FC3\u8D1D\u62FF\u52D2\u65AF\uFF08\u5728\u5370\u5EA6\u5317\u90E8\uFF09\u7684\u5723\u5E99\u91CC\uFF0C\u4E00\u5757\u9EC4\u94DC\u677F\u4E0A\u63D2\u7740\u4E09\u6839\u5B9D\u77F3\u9488\u3002\u5370\u5EA6\u6559\u7684\u4E3B\u795E\u68B5\u5929\u5728\u521B\u9020\u4E16\u754C\u7684\u65F6\u5019\uFF0C\u5728\u5176\u4E2D\u4E00\u6839\u9488\u4E0A\u4ECE\u4E0B\u5230\u4E0A\u5730\u7A7F\u597D\u4E86\u7531\u5927\u5230\u5C0F\u768464\u7247\u91D1\u7247\uFF0C\u8FD9\u5C31\u662F\u6240\u8C13\u7684\u6C49\u8BFA\u5854\u3002\u4E0D\u8BBA\u767D\u5929\u9ED1\u591C\uFF0C\u603B\u6709\u4E00\u4E2A\u50E7\u4FA3\u5728\u6309\u7167\u4E0B\u9762\u7684\u6CD5\u5219\u79FB\u52A8\u8FD9\u4E9B\u91D1\u7247\uFF0C\u4E00\u6B21\u53EA\u79FB\u52A8\u4E00\u7247\uFF0C\u4E0D\u7BA1\u5728\u54EA\u6839\u9488\u4E0A\uFF0C\u5C0F\u7247\u5FC5\u5728\u5927\u7247\u4E0A\u9762\u3002\u5F53\u6240\u6709\u7684\u91D1\u7247\u90FD\u4ECE\u68B5\u5929\u7A7F\u597D\u7684\u90A3\u6839\u9488\u4E0A\u79FB\u5230\u53E6\u5916\u4E00\u6982\u9488\u4E0A\u65F6\uFF0C\u4E16\u754C\u5C31\u5C06\u5728\u4E00\u58F0\u9739\u96F3\u4E2D\u6D88\u706D\uFF0C\u68B5\u5854\u3001\u5E99\u5B87\u548C\u4F17\u751F\u90FD\u5C06\u540C\u5F52\u4E8E\u5C3D\u3002 \n\u3000\u3000\u4E0D\u7BA1\u8FD9\u4E2A\u4F20\u8BF4\u7684\u53EF\u4FE1\u5EA6\u6709\u591A\u5927\uFF0C\u5982\u679C\u8003\u8651\u4E00\u4E0B\u628A64\u7247\u91D1\u7247\uFF0C\u7531\u4E00\u6839\u9488\u4E0A\u79FB\u5230\u53E6\u4E00\u6839\u9488\u4E0A\uFF0C\u5E76\u4E14\u59CB\u7EC8\u4FDD\u6301\u4E0A\u5C0F\u4E0B\u5927\u7684\u987A\u5E8F\uFF0C\u4E00\u5171\u9700\u8981\u79FB\u5230\u591A\u5C11\u6B21\uFF0C\u90A3\u4E48\uFF0C\u4E0D\u96BE\u53D1\u73B0\uFF1A\u4E0D\u7BA1\u628A\u54EA\u4E00\u7247\u79FB\u5230\u53E6\u4E00\u6839\u9488\u4E0A\uFF0C\u79FB\u52A8\u7684\u6B21\u6570\u90FD\u8981\u6BD4\u79FB\u52A8\u4E0A\u9762\u4E00\u7247\u589E\u52A0\u4E00\u500D\u3002\u8FD9\u6837\uFF0C\u79FB\u52A8\u7B2C1\u7247\u53EA\u97001\u6B21\uFF0C\u7B2C2\u7247\u97002\u6B21\uFF0C\u7B2C3\u7247\u97004\u2026\u2026\u7B2C64\u7247\u97002^64\u6B21\u3002\u5168\u90E8\u6B21\u6570\u4E3A1+2+4+\u2026+26^3=26^4-1=18446744073709551615\n\u3000\u3000\u5047\u5982\u6BCF\u79D2\u949F\u4E00\u6B21\uFF0C\u5171\u9700\u591A\u957F\u65F6\u95F4\u5462\uFF1F\u4E00\u5E74\u5927\u7EA6\u670931536926\u79D2\uFF0C\u8BA1\u7B97\u8868\u660E\u79FB\u5B8C\u8FD9\u4E9B\u91D1\u7247\u9700\u89815800\u591A\u4EBF\u5E74\uFF0C\u6BD4\u5730\u7403\u5BFF\u547D\u8FD8\u8981\u957F\uFF0C\u4E8B\u5B9E\u4E0A\uFF0C\u4E16\u754C\u3001\u68B5\u5854\u3001\u5E99\u5B87\u548C\u4F17\u751F\u90FD\u5DF2\u7ECF\u7070\u98DE\u70DF\u706D\u3002");//GEN-LINE:MVDGetInit34
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd34
        return stringItem1;
    }//GEN-END:MVDGetEnd34
    
    
    
    /** This method returns instance for gCanvas component and should be called instead of accessing gCanvas field directly.//GEN-BEGIN:MVDGetBegin55
     * @return Instance for gCanvas component
     */
    public GRAPHICS.GCanvas get_gCanvas() {
        if (gCanvas == null) {//GEN-END:MVDGetBegin55
/*
gCanvas = new GRAPHICS.GCanvas (0);//GEN-BEGIN:MVDGetInit55
gCanvas.addCommand (get_backCommand());
gCanvas.addCommand (get_autoCommand());
gCanvas.addCommand (get_exitCommand());
gCanvas.setCommandListener (this);
gCanvas.setTitle ("");//GEN-END:MVDGetInit55
 */
            gCanvas=new GRAPHICS.GCanvas(optionList.getSelectedIndex()+3);
            gCanvas.addCommand(get_backCommand());
            gCanvas.addCommand (get_autoCommand());
            gCanvas.addCommand(get_exitCommand());
            gCanvas.setCommandListener(this);
        }//GEN-BEGIN:MVDGetEnd55
        return gCanvas;
    }//GEN-END:MVDGetEnd55
    
    /** This method returns instance for stringItem2 component and should be called instead of accessing stringItem2 field directly.//GEN-BEGIN:MVDGetBegin61
     * @return Instance for stringItem2 component
     */
    public StringItem get_stringItem2() {
        if (stringItem2 == null) {//GEN-END:MVDGetBegin61
            // Insert pre-init code here
            stringItem2 = new StringItem("\uFF0D\uFF0D\uFF0D\uFF0D\uFF0D\uFF0D\n\u6309\u952E\u8BF4\u660E\n", "\u5DE6 \u6216\u8005\u2463\u5411\u5DE6\u79FB\u52A8\u5149\u6807\u7BAD\u5934\n\u53F3 \u6216\u8005\u2465\u5411\u53F3\u79FB\u52A8\u5149\u6807\u7BAD\u5934\n\u786E\u8BA4\u952E \u6216\u8005\u2464\u62FF\u8D77/\u653E\u4E0B\u76D8\u5B50\uFF08\u5F53\u6307\u9488\u4E3A\u4E0A\u6CA1\u6709\u76D8\u5B50\u65F6\u6309\u952E\u4E3A\u62FF\u8D77\u76D8\u5B50\uFF0C\u53CD\u4E4B\u5219\u4E3A\u653E\u4E0B\uFF09\n\u6309#\u53F7\u952E\u6216\u8005\u9009\u53D6\u83DC\u5355\u4E2D\u7684\u81EA\u52A8\u6F14\u793A\uFF0C\u6E38\u620F\u5C06\u590D\u4F4D\u8FDB\u5165\u81EA\u52A8\u6F14\u793A\u6A21\u5F0F\u3002");//GEN-LINE:MVDGetInit61
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd61
        return stringItem2;
    }//GEN-END:MVDGetEnd61
    /** This method returns instance for stringItem4 component and should be called instead of accessing stringItem4 field directly.//GEN-BEGIN:MVDGetBegin63
     * @return Instance for stringItem4 component
     */
    public StringItem get_stringItem4() {
        if (stringItem4 == null) {//GEN-END:MVDGetBegin63
            // Insert pre-init code here
            stringItem4 = new StringItem("\u6E38\u620F\u89C4\u5219\u8BF4\u660E", "\u5C06\u7B2C\u4E00\u6839\u67F1\u5B50\u4E0A\u7684\u76D8\u5B50\u79FB\u52A8\u5230\u7B2C\u4E09\u6839\u67F1\u5B50\u4E0A\uFF0C\u6309\u7167\u4ECE\u5C0F\u5230\u5927\u7684\u987A\u5E8F\u6392\u5217\uFF0C\u79FB\u52A8\u8FC7\u7A0B\u4E2D\u53EF\u4EE5\u7528\u7B2C\u4E8C\u6839\u67F1\u5B50\u4F5C\u4E3A\u4E2D\u8F6C\uFF0C\u4E14\u5927\u76D8\u5B50\u4E0D\u80FD\u538B\u5728\u5C0F\u7684\u4E4B\u4E0A\u3002\n\u5F53\u5168\u90E8\u724C\u5B50\u90FD\u79FB\u52A8\u5230\u7B2C\u4E09\u6839\u67F1\u5B50\u4E0A\u65F6\uFF0C\u6E38\u620F\u6210\u529F\uFF01");//GEN-LINE:MVDGetInit63
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd63
        return stringItem4;
    }//GEN-END:MVDGetEnd63
    
    /** This method returns instance for stringItem3 component and should be called instead of accessing stringItem3 field directly.//GEN-BEGIN:MVDGetBegin64
     * @return Instance for stringItem3 component
     */
    public StringItem get_stringItem3() {
        if (stringItem3 == null) {//GEN-END:MVDGetBegin64
            // Insert pre-init code here
            stringItem3 = new StringItem("\u5173\u4E8E\u4F5C\u8005(About author)", "\u5B66\u6821\uFF1A\u897F\u5B89\u5DE5\u7A0B\u5927\u5B66\n\u5B66\u9662\uFF1A\u8BA1\u7B97\u673A\u79D1\u5B66\u5B66\u9662\n\u4E13\u4E1A\uFF1A\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u6280\u672F\n\u73ED\u7EA7\uFF1A03\u7EA74\u73ED\n\u59D3\u540D\uFF1A\u8D3E\u7762\n\u5B66\u53F7\uFF1A03E10413\n\u5BFC\u5E08\uFF1A\u4ED8\u84C9\n\u65F6\u95F4\uFF1A2007\u5E746\u6708");//GEN-LINE:MVDGetInit64
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd64
        return stringItem3;
    }//GEN-END:MVDGetEnd64
    /** This method returns instance for imageHelp component and should be called instead of accessing imageHelp field directly.//GEN-BEGIN:MVDGetBegin68
     * @return Instance for imageHelp component
     */
    public Image get_imageHelp() {
        if (imageHelp == null) {//GEN-END:MVDGetBegin68
            // Insert pre-init code here
            try {//GEN-BEGIN:MVDGetInit68
                imageHelp = Image.createImage("/image/help.PNG");
            } catch (java.io.IOException exception) {
                exception.printStackTrace();
            }//GEN-END:MVDGetInit68
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd68
        return imageHelp;
    }//GEN-END:MVDGetEnd68
    
    /** This method returns instance for imageExit component and should be called instead of accessing imageExit field directly.//GEN-BEGIN:MVDGetBegin69
     * @return Instance for imageExit component
     */
    public Image get_imageExit() {
        if (imageExit == null) {//GEN-END:MVDGetBegin69
            // Insert pre-init code here
            try {//GEN-BEGIN:MVDGetInit69
                imageExit = Image.createImage("/image/exit.PNG");
            } catch (java.io.IOException exception) {
                exception.printStackTrace();
            }//GEN-END:MVDGetInit69
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd69
        return imageExit;
    }//GEN-END:MVDGetEnd69
    
    /** This method returns instance for imageInfo component and should be called instead of accessing imageInfo field directly.//GEN-BEGIN:MVDGetBegin70
     * @return Instance for imageInfo component
     */
    public Image get_imageInfo() {
        if (imageInfo == null) {//GEN-END:MVDGetBegin70
            // Insert pre-init code here
            try {//GEN-BEGIN:MVDGetInit70
                imageInfo = Image.createImage("/image/info.PNG");
            } catch (java.io.IOException exception) {
                exception.printStackTrace();
            }//GEN-END:MVDGetInit70
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd70
        return imageInfo;
    }//GEN-END:MVDGetEnd70
    
    /** This method returns instance for imageStart component and should be called instead of accessing imageStart field directly.//GEN-BEGIN:MVDGetBegin71
     * @return Instance for imageStart component
     */
    public Image get_imageStart() {
        if (imageStart == null) {//GEN-END:MVDGetBegin71
            // Insert pre-init code here
            try {//GEN-BEGIN:MVDGetInit71
                imageStart = Image.createImage("/image/start.PNG");
            } catch (java.io.IOException exception) {
                exception.printStackTrace();
            }//GEN-END:MVDGetInit71
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd71
        return imageStart;
    }//GEN-END:MVDGetEnd71
    
    /** This method returns instance for optionList component and should be called instead of accessing optionList field directly.//GEN-BEGIN:MVDGetBegin89
     * @return Instance for optionList component
     */
    public List get_optionList() {
        if (optionList == null) {//GEN-END:MVDGetBegin89
            // Insert pre-init code here
            optionList = new List("\u6E38\u620F\u96BE\u5EA6\uFF08Game Level\uFF09", Choice.IMPLICIT, new String[] {//GEN-BEGIN:MVDGetInit89
                "1\u7EA7\uFF083\u4E2A\u76D8\u5B50\uFF09",
                "2\u7EA7\uFF084\u4E2A\u76D8\u5B50\uFF09",
                "3\u7EA7\uFF085\u4E2A\u76D8\u5B50\uFF09",
                "4\u7EA7\uFF086\u4E2A\u76D8\u5B50\uFF09",
                "5\u7EA7\uFF087\u4E2A\u76D8\u5B50\uFF09",
                "6\u7EA7\uFF088\u4E2A\u76D8\u5B50\uFF09",
                "7\u7EA7\uFF089\u4E2A\u76D8\u5B50\uFF09"
            }, new Image[] {
                null,
                null,
                null,
                null,
                null,
                null,
                null
            });
            optionList.addCommand(get_okCommand());
            optionList.addCommand(get_backCommand());
            optionList.setCommandListener(this);
            optionList.setSelectedFlags(new boolean[] {
                false,
                false,
                false,
                false,
                false,
                false,
                false
            });//GEN-END:MVDGetInit89
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd89
        return optionList;
    }//GEN-END:MVDGetEnd89
    
    /** This method returns instance for autoCommand component and should be called instead of accessing autoCommand field directly.//GEN-BEGIN:MVDGetBegin122
     * @return Instance for autoCommand component
     */
    public Command get_autoCommand() {
        if (autoCommand == null) {//GEN-END:MVDGetBegin122
            // Insert pre-init code here
            autoCommand = new Command("\u81EA\u52A8\u6F14\u793A", Command.OK, 1);//GEN-LINE:MVDGetInit122
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd122
        return autoCommand;
    }//GEN-END:MVDGetEnd122
    
    
    public void startApp() {
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
}
