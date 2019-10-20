/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author HASSAN
 */
public class MainApp extends javax.swing.JFrame {

    /**showPopupMenu
 Creates new form MainApp
     */
    
   private final int fontSize; 
   private DefaultListModel  listModel;
   private TreeMap<String, String> listMap;
   private  CalculatorModel calculator;
   private   ArrayDeque<String> LIST;
   private final ArrayDeque<String> matchPairList;
   
   
    public MainApp() {
        LIST =  new ArrayDeque<>();
         matchPairList =  new ArrayDeque<>();
        laodFont();
        listModel =  new DefaultListModel();
       listMap =  new TreeMap<>();
       bracketMatchObserver=  new ArrayList<>();
        initComponents();
      
    fontSize =  answertTF.getFont().getSize();       
      answertTF.setFont(digitalClock);
       answertTF.setAlignmentY(JTextField.TOP);
       initCompSize();
      createCalculatorModel();
      showPopupMenu();
      setIconImage(new ImageIcon(getClass().getResource("img/cal.png")).getImage());
        
    calculator.insertButtonValue(btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9); 
    
  hilightAllButtons();
//this.pack();
 //[313, 144]
     
 dotBtn.addActionListener((e) -> {
         String  text  =  answertTF.getText()+ dotBtn.getText();answertTF.setText(text);
         answertTF.setText(text);
     });



    }



    
private void createCalculatorModel(){
calculator =  new CalculatorModel(isAnswer, answertTF,matchPairList);
calculator.setAnserString(anserString);
calculator.setListMap(listMap);
calculator.setListModel(listModel);
calculator.setLIST(LIST);
}    
    
    
  Font  digitalClock  =null;
 private void laodFont(){
  
     GraphicsEnvironment   ge  =  GraphicsEnvironment.getLocalGraphicsEnvironment();
 
        try {       
           digitalClock  = Font.createFont(Font.TRUETYPE_FONT,getClass()
                   .getResourceAsStream("/cal/fonts/digitalx-7.ttf"))
                   .deriveFont(((float)28)); 
           ge.registerFont(digitalClock);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (FontFormatException ex) {
            ex.printStackTrace();
        }
 

 
  
 }   
    private void showPopupMenu(){
    
    //create  copy action 
    
    Action  copy  = new StyledEditorKit.CopyAction();
    copy.putValue(Action.NAME, "Copy");
    copyPopup.add(copy);
    
    Action  paste  = new StyledEditorKit.PasteAction();
    paste.putValue(Action.NAME, "Paste");
    copyPopup.add(paste);
   
    
    answertTF.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            checkTrigerdEvent(e);
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
              checkTrigerdEvent(e);
          
        }
        
        private void checkTrigerdEvent(MouseEvent e){
        
            if(e.isPopupTrigger()){
            
                copyPopup.show(e.getComponent(), e.getX(), e.getY());
               
            
            }
            
            
        
        }
        
        
});
    
    
    }

private void hilightAllButtons(){

   highlightButtons(new Color(0,79,158), new Color(0,73,147),btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,dotBtn);
      highlightButtons(new Color(0,79,158), new Color(0,51,102),minus,addBtn,dividBtn,times);
       highlightButtons(new Color(0,79,158), new Color(0,51,102),leftBracket, rightBracket, squareRoot,expBtn, prevAns,negative);
        highlightButtons(new Color(0,79,158), new Color(0,51,102),logBas10,logBtn2,x2Btn,x3Btn,xyBtn,InBtn,PIBtn);
        highlightButtons(new Color(0,79,158), new Color(0,51,102),tanBtn,cosBtn,sinBtn,sinhBtn,coshBtn,tanhBtn,roundBtn,modBtn);
        highlightButtons(new Color(255,91,91), new Color(255,51,51), clear, backSpace);
        highlightButtons(new Color(0,147,147), new Color(0,102,102), equalsBtn );
    highlightButtons(new Color(0,79,158), new Color(0,51,102),
            clear1,clear2,clear3,clear4,clear5,x3Btn1,x3Btn2,InBtn2,factorial );
   

}    
    
private void highlightButtons(Color  c1, Color c2,JButton...b){
    
    
     for(JButton btn : b){
     
         btn.addMouseListener( new MouseAdapter() {
             @Override
             public void mouseEntered(MouseEvent e) {
                 
                btn.setBackground(c1);
             }

             @Override
             public void mouseExited(MouseEvent e) {
             
                 btn.setBackground(c2);
             }
             
          
             
             
        });}
         
        
        
    
    }//end method 



    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        copyPopup = new javax.swing.JPopupMenu();
        history = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        mainPane = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        leftBracket = new javax.swing.JButton();
        rightBracket = new javax.swing.JButton();
        InBtn = new javax.swing.JButton();
        roundBtn = new javax.swing.JButton();
        roundBtn2 = new javax.swing.JButton();
        x2Btn = new javax.swing.JButton();
        x3Btn1 = new javax.swing.JButton();
        sinBtn = new javax.swing.JButton();
        sinhBtn = new javax.swing.JButton();
        roundBtn3 = new javax.swing.JButton();
        xyBtn = new javax.swing.JButton();
        x3Btn2 = new javax.swing.JButton();
        cosBtn = new javax.swing.JButton();
        coshBtn = new javax.swing.JButton();
        factorial = new javax.swing.JButton();
        x3Btn = new javax.swing.JButton();
        PIBtn = new javax.swing.JButton();
        tanBtn = new javax.swing.JButton();
        tanhBtn = new javax.swing.JButton();
        modBtn = new javax.swing.JButton();
        logBtn2 = new javax.swing.JButton();
        logBas10 = new javax.swing.JButton();
        expBtn = new javax.swing.JButton();
        roundBtn4 = new javax.swing.JButton();
        logBas11 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        clear5 = new javax.swing.JButton();
        clear4 = new javax.swing.JButton();
        clear3 = new javax.swing.JButton();
        clear2 = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();
        backSpace = new javax.swing.JButton();
        clear6 = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        negative = new javax.swing.JButton();
        squareRoot = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        dividBtn = new javax.swing.JButton();
        dividBtn1 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        times = new javax.swing.JButton();
        InBtn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        equalsBtn = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        dotBtn = new javax.swing.JButton();
        prevAns = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        addBtn1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ansPane = new javax.swing.JPanel();
        answertTF = new javax.swing.JTextField();
        menubar = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        history.setTitle("Expressions History");
        history.setLocation(getLocation());
        history.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        history.setResizable(false);
        history.setSize(new java.awt.Dimension(303, 228));
        history.setType(java.awt.Window.Type.UTILITY);

        jList1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jList1.setModel(listModel);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remove");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1)
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout historyLayout = new javax.swing.GroupLayout(history.getContentPane());
        history.getContentPane().setLayout(historyLayout);
        historyLayout.setHorizontalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        historyLayout.setVerticalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        history.getAccessibleContext().setAccessibleParent(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scientific Calculator 1.0");
        setBackground(new java.awt.Color(153, 204, 255));
        setResizable(false);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        mainPane.setBackground(new java.awt.Color(153, 204, 255));
        mainPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

        jPanel1.setOpaque(false);

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setOpaque(false);

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new java.awt.Insets(10, 10, 10, 10));

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Degrees");
        jRadioButton1.setFocusable(false);
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButton1.setMargin(new java.awt.Insets(2, 7, 2, 2));
        jRadioButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jRadioButton1);

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Radians");
        jRadioButton2.setFocusable(false);
        jRadioButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButton2.setMargin(new java.awt.Insets(2, 60, 2, 2));
        jRadioButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jRadioButton2);

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Grads");
        jRadioButton3.setFocusable(false);
        jRadioButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButton3.setMargin(new java.awt.Insets(2, 55, 2, 2));
        jRadioButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jRadioButton3);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(5, 5, 2, 2));

        leftBracket.setBackground(new java.awt.Color(0, 51, 102));
        leftBracket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        leftBracket.setForeground(new java.awt.Color(255, 255, 0));
        leftBracket.setText("(");
        leftBracket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftBracketActionPerformed(evt);
            }
        });
        jPanel5.add(leftBracket);

        rightBracket.setBackground(new java.awt.Color(0, 51, 102));
        rightBracket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rightBracket.setForeground(new java.awt.Color(255, 255, 0));
        rightBracket.setText(")");
        rightBracket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBracketActionPerformed(evt);
            }
        });
        jPanel5.add(rightBracket);

        InBtn.setBackground(new java.awt.Color(0, 51, 102));
        InBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        InBtn.setForeground(new java.awt.Color(255, 255, 0));
        InBtn.setText("In");
        InBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InBtnActionPerformed(evt);
            }
        });
        jPanel5.add(InBtn);

        roundBtn.setBackground(new java.awt.Color(0, 51, 102));
        roundBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roundBtn.setForeground(new java.awt.Color(255, 255, 0));
        roundBtn.setText("Round");
        roundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundBtnActionPerformed(evt);
            }
        });
        jPanel5.add(roundBtn);

        roundBtn2.setBackground(new java.awt.Color(0, 51, 102));
        roundBtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roundBtn2.setForeground(new java.awt.Color(255, 255, 0));
        roundBtn2.setText("Int");
        roundBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundBtn2ActionPerformed(evt);
            }
        });
        jPanel5.add(roundBtn2);

        x2Btn.setBackground(new java.awt.Color(0, 51, 102));
        x2Btn.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        x2Btn.setForeground(new java.awt.Color(255, 255, 0));
        x2Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cal/img/x2.png"))); // NOI18N
        x2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x2BtnActionPerformed(evt);
            }
        });
        jPanel5.add(x2Btn);

        x3Btn1.setBackground(new java.awt.Color(0, 51, 102));
        x3Btn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        x3Btn1.setForeground(new java.awt.Color(255, 255, 0));
        x3Btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cal/img/yx.png"))); // NOI18N
        x3Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x3Btn1ActionPerformed(evt);
            }
        });
        jPanel5.add(x3Btn1);

        sinBtn.setBackground(new java.awt.Color(0, 51, 102));
        sinBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sinBtn.setForeground(new java.awt.Color(255, 255, 0));
        sinBtn.setText("Sin");
        sinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinBtnActionPerformed(evt);
            }
        });
        jPanel5.add(sinBtn);

        sinhBtn.setBackground(new java.awt.Color(0, 51, 102));
        sinhBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sinhBtn.setForeground(new java.awt.Color(255, 255, 0));
        sinhBtn.setText("Sinh");
        sinhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinhBtnActionPerformed(evt);
            }
        });
        jPanel5.add(sinhBtn);

        roundBtn3.setBackground(new java.awt.Color(0, 51, 102));
        roundBtn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roundBtn3.setForeground(new java.awt.Color(255, 255, 0));
        roundBtn3.setText("Int");
        roundBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundBtn3ActionPerformed(evt);
            }
        });
        jPanel5.add(roundBtn3);

        xyBtn.setBackground(new java.awt.Color(0, 51, 102));
        xyBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        xyBtn.setForeground(new java.awt.Color(255, 255, 0));
        xyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cal/img/xy.png"))); // NOI18N
        xyBtn.setActionCommand("^");
        xyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xyBtnActionPerformed(evt);
            }
        });
        jPanel5.add(xyBtn);

        x3Btn2.setBackground(new java.awt.Color(0, 51, 102));
        x3Btn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        x3Btn2.setForeground(new java.awt.Color(255, 255, 0));
        x3Btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cal/img/threex.png"))); // NOI18N
        x3Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x3Btn2ActionPerformed(evt);
            }
        });
        jPanel5.add(x3Btn2);

        cosBtn.setBackground(new java.awt.Color(0, 51, 102));
        cosBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cosBtn.setForeground(new java.awt.Color(255, 255, 0));
        cosBtn.setText("Cos");
        cosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cosBtnActionPerformed(evt);
            }
        });
        jPanel5.add(cosBtn);

        coshBtn.setBackground(new java.awt.Color(0, 51, 102));
        coshBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        coshBtn.setForeground(new java.awt.Color(255, 255, 0));
        coshBtn.setText("Cosh");
        coshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coshBtnActionPerformed(evt);
            }
        });
        jPanel5.add(coshBtn);

        factorial.setBackground(new java.awt.Color(0, 51, 102));
        factorial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        factorial.setForeground(new java.awt.Color(255, 255, 0));
        factorial.setText("n!");
        factorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factorialActionPerformed(evt);
            }
        });
        jPanel5.add(factorial);

        x3Btn.setBackground(new java.awt.Color(0, 51, 102));
        x3Btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        x3Btn.setForeground(new java.awt.Color(255, 255, 0));
        x3Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cal/img/x3.png"))); // NOI18N
        x3Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x3BtnActionPerformed(evt);
            }
        });
        jPanel5.add(x3Btn);

        PIBtn.setBackground(new java.awt.Color(0, 51, 102));
        PIBtn.setFont(new java.awt.Font("Adobe Caslon Pro", 1, 18)); // NOI18N
        PIBtn.setForeground(new java.awt.Color(255, 255, 0));
        PIBtn.setText("π");
        PIBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIBtnActionPerformed(evt);
            }
        });
        jPanel5.add(PIBtn);

        tanBtn.setBackground(new java.awt.Color(0, 51, 102));
        tanBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tanBtn.setForeground(new java.awt.Color(255, 255, 0));
        tanBtn.setText("Tan");
        tanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanBtnActionPerformed(evt);
            }
        });
        jPanel5.add(tanBtn);

        tanhBtn.setBackground(new java.awt.Color(0, 51, 102));
        tanhBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tanhBtn.setForeground(new java.awt.Color(255, 255, 0));
        tanhBtn.setText("Tanh");
        jPanel5.add(tanhBtn);

        modBtn.setBackground(new java.awt.Color(0, 51, 102));
        modBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        modBtn.setForeground(new java.awt.Color(255, 255, 0));
        modBtn.setText("Mod");
        modBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modBtnActionPerformed(evt);
            }
        });
        jPanel5.add(modBtn);

        logBtn2.setBackground(new java.awt.Color(0, 51, 102));
        logBtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logBtn2.setForeground(new java.awt.Color(255, 255, 0));
        logBtn2.setText("Log");
        logBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logBtnActionPerformed2(evt);
            }
        });
        jPanel5.add(logBtn2);

        logBas10.setBackground(new java.awt.Color(0, 51, 102));
        logBas10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logBas10.setForeground(new java.awt.Color(255, 255, 0));
        logBas10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cal/img/b10.png"))); // NOI18N
        logBas10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logBas10ActionPerformed(evt);
            }
        });
        jPanel5.add(logBas10);

        expBtn.setBackground(new java.awt.Color(0, 51, 102));
        expBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        expBtn.setForeground(new java.awt.Color(255, 255, 0));
        expBtn.setText("EXP");
        expBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expBtnActionPerformed(evt);
            }
        });
        jPanel5.add(expBtn);

        roundBtn4.setBackground(new java.awt.Color(0, 51, 102));
        roundBtn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roundBtn4.setForeground(new java.awt.Color(255, 255, 0));
        roundBtn4.setText("Int");
        roundBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundBtn4ActionPerformed(evt);
            }
        });
        jPanel5.add(roundBtn4);

        logBas11.setBackground(new java.awt.Color(0, 51, 102));
        logBas11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logBas11.setForeground(new java.awt.Color(255, 255, 0));
        logBas11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cal/img/b10.png"))); // NOI18N
        logBas11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logBas11ActionPerformed(evt);
            }
        });
        jPanel5.add(logBas11);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(6, 5, 5, 5));

        clear5.setBackground(new java.awt.Color(0, 51, 102));
        clear5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear5.setForeground(new java.awt.Color(255, 255, 0));
        clear5.setText("MC");
        clear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear5ActionPerformed(evt);
            }
        });
        jPanel7.add(clear5);

        clear4.setBackground(new java.awt.Color(0, 51, 102));
        clear4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear4.setForeground(new java.awt.Color(255, 255, 0));
        clear4.setText("MR");
        clear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear4ActionPerformed(evt);
            }
        });
        jPanel7.add(clear4);

        clear3.setBackground(new java.awt.Color(0, 51, 102));
        clear3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear3.setForeground(new java.awt.Color(255, 255, 0));
        clear3.setText("MS");
        clear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear3ActionPerformed(evt);
            }
        });
        jPanel7.add(clear3);

        clear2.setBackground(new java.awt.Color(0, 51, 102));
        clear2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear2.setForeground(new java.awt.Color(255, 255, 0));
        clear2.setText("M+");
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });
        jPanel7.add(clear2);

        clear1.setBackground(new java.awt.Color(0, 51, 102));
        clear1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear1.setForeground(new java.awt.Color(255, 255, 0));
        clear1.setText("M-");
        clear1.setOpaque(false);
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });
        jPanel7.add(clear1);

        backSpace.setBackground(new java.awt.Color(255, 51, 51));
        backSpace.setFont(new java.awt.Font("Wingdings", 1, 12)); // NOI18N
        backSpace.setForeground(new java.awt.Color(255, 255, 0));
        backSpace.setText("");
        backSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSpaceActionPerformed(evt);
            }
        });
        jPanel7.add(backSpace);

        clear6.setBackground(new java.awt.Color(255, 51, 51));
        clear6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear6.setForeground(new java.awt.Color(255, 255, 0));
        clear6.setText("CE");
        clear6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear6ActionPerformed(evt);
            }
        });
        jPanel7.add(clear6);

        clear.setBackground(new java.awt.Color(255, 51, 51));
        clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 0));
        clear.setText("C");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel7.add(clear);

        negative.setBackground(new java.awt.Color(0, 51, 102));
        negative.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        negative.setForeground(new java.awt.Color(255, 255, 0));
        negative.setText("±");
        negative.setActionCommand("-");
        negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativeActionPerformed(evt);
            }
        });
        jPanel7.add(negative);

        squareRoot.setBackground(new java.awt.Color(0, 51, 102));
        squareRoot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        squareRoot.setForeground(new java.awt.Color(255, 255, 0));
        squareRoot.setText("√");
        squareRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareRootActionPerformed(evt);
            }
        });
        jPanel7.add(squareRoot);

        btn7.setBackground(new java.awt.Color(0, 73, 147));
        btn7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 0));
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel7.add(btn7);

        btn9.setBackground(new java.awt.Color(0, 73, 147));
        btn9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 0));
        btn9.setText("9");
        jPanel7.add(btn9);

        btn8.setBackground(new java.awt.Color(0, 73, 147));
        btn8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 0));
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel7.add(btn8);

        dividBtn.setBackground(new java.awt.Color(0, 51, 102));
        dividBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dividBtn.setForeground(new java.awt.Color(255, 255, 0));
        dividBtn.setText("/");
        dividBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dividBtnActionPerformed(evt);
            }
        });
        jPanel7.add(dividBtn);

        dividBtn1.setBackground(new java.awt.Color(0, 51, 102));
        dividBtn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dividBtn1.setForeground(new java.awt.Color(255, 255, 0));
        dividBtn1.setText("%");
        dividBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dividBtn1ActionPerformed(evt);
            }
        });
        jPanel7.add(dividBtn1);

        btn4.setBackground(new java.awt.Color(0, 73, 147));
        btn4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 0));
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel7.add(btn4);

        btn5.setBackground(new java.awt.Color(0, 73, 147));
        btn5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 0));
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel7.add(btn5);

        btn6.setBackground(new java.awt.Color(0, 73, 147));
        btn6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 0));
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel7.add(btn6);

        times.setBackground(new java.awt.Color(0, 51, 102));
        times.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        times.setForeground(new java.awt.Color(255, 255, 0));
        times.setText("*");
        times.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timesActionPerformed(evt);
            }
        });
        jPanel7.add(times);

        InBtn2.setBackground(new java.awt.Color(0, 51, 102));
        InBtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        InBtn2.setForeground(new java.awt.Color(255, 255, 0));
        InBtn2.setText("1/X");
        InBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InBtn2ActionPerformed(evt);
            }
        });
        jPanel7.add(InBtn2);

        btn1.setBackground(new java.awt.Color(0, 73, 147));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 0));
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel7.add(btn1);

        btn2.setBackground(new java.awt.Color(0, 73, 147));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 0));
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel7.add(btn2);

        btn3.setBackground(new java.awt.Color(0, 73, 147));
        btn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 0));
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel7.add(btn3);

        minus.setBackground(new java.awt.Color(0, 51, 102));
        minus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minus.setForeground(new java.awt.Color(255, 255, 0));
        minus.setText("-");
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });
        jPanel7.add(minus);

        equalsBtn.setBackground(new java.awt.Color(0, 102, 102));
        equalsBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        equalsBtn.setForeground(new java.awt.Color(255, 255, 0));
        equalsBtn.setText("=");
        equalsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsBtnActionPerformed(evt);
            }
        });
        jPanel7.add(equalsBtn);

        btn0.setBackground(new java.awt.Color(0, 73, 147));
        btn0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn0.setForeground(new java.awt.Color(255, 255, 0));
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel7.add(btn0);

        dotBtn.setBackground(new java.awt.Color(0, 73, 147));
        dotBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dotBtn.setForeground(new java.awt.Color(255, 255, 0));
        dotBtn.setText(".");
        dotBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dotBtnActionPerformed(evt);
            }
        });
        jPanel7.add(dotBtn);

        prevAns.setBackground(new java.awt.Color(0, 51, 102));
        prevAns.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        prevAns.setForeground(new java.awt.Color(255, 255, 0));
        prevAns.setText("Ans");
        prevAns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevAnsActionPerformed(evt);
            }
        });
        jPanel7.add(prevAns);

        addBtn.setBackground(new java.awt.Color(0, 51, 102));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 0));
        addBtn.setText("+");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel7.add(addBtn);

        addBtn1.setBackground(new java.awt.Color(0, 51, 102));
        addBtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn1.setForeground(new java.awt.Color(255, 255, 0));
        addBtn1.setFocusPainted(false);
        addBtn1.setFocusable(false);
        addBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn1ActionPerformed(evt);
            }
        });
        jPanel7.add(addBtn1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ansPane.setBackground(new java.awt.Color(153, 204, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 5);
        flowLayout1.setAlignOnBaseline(true);
        ansPane.setLayout(flowLayout1);

        answertTF.setEditable(false);
        answertTF.setBackground(new java.awt.Color(229, 245, 249));
        answertTF.setColumns(50);
        answertTF.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        answertTF.setForeground(new java.awt.Color(0, 68, 137));
        answertTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        answertTF.setText("0");
        answertTF.setToolTipText("");
        answertTF.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 68, 137), 2, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        answertTF.setMargin(new java.awt.Insets(5, 15, 5, 5));
        answertTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answertTFActionPerformed(evt);
            }
        });
        ansPane.add(answertTF);

        menubar.setBackground(new java.awt.Color(153, 204, 255));
        menubar.setOpaque(false);

        jMenu5.setText("View");

        jMenuItem6.setText("Standard");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setText("Scientific");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("Programmer");
        jMenu5.add(jMenuItem8);

        jMenu4.setText("History");

        jMenuItem1.setText("Expressions History");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenu5.add(jMenu4);

        menubar.add(jMenu5);

        jMenu1.setText("Options");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonMenuItem1);
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Degrees");
        jMenu1.add(jRadioButtonMenuItem1);

        buttonGroup1.add(jRadioButtonMenuItem2);
        jRadioButtonMenuItem2.setText("Radians");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem2);

        buttonGroup1.add(jRadioButtonMenuItem3);
        jRadioButtonMenuItem3.setText("Grads");
        jMenu1.add(jRadioButtonMenuItem3);

        menubar.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Copy");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Past");
        jMenu2.add(jMenuItem3);

        menubar.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem5.setText("View Help ");
        jMenu3.add(jMenuItem5);

        jMenuItem4.setText("About Scientific Calculator");
        jMenu3.add(jMenuItem4);

        menubar.add(jMenu3);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(ansPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ansPane, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void answertTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answertTFActionPerformed
    
    }//GEN-LAST:event_answertTFActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


//this.setResizable(true);
////this.setSize(322, 319);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated
 
    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {                                     

    }                                    

  private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {                                     

    }      
	
private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {                                     

    }                                    
	
private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {                                     

    }                                    
	
private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {                                     

    }                                    
	
private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
}                                    
private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {                                     

    }                                    
	
private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {                                     


    }                                    
	
	
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

answertTF.setText("0");
     // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    
    private void dotBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dotBtnActionPerformed
 }//GEN-LAST:event_dotBtnActionPerformed

  	private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {                                     


        // TODO add your handling code here:
    }                                    
 

private void minusActionPerformed(java.awt.event.ActionEvent evt) { 
    
            calculator.addOperator(minus,hasBracke);
       
           
           
    }           
        

   
            
 private void timesActionPerformed(java.awt.event.ActionEvent evt) { 
     calculator.addOperator(times,hasBracke);
        
        // TODO add your handling code here:
    }                                    

private void dividBtnActionPerformed(java.awt.event.ActionEvent evt) {  
            calculator.addOperator(dividBtn,hasBracke);
    }                                    
	
	
private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
          
    calculator.addOperator(addBtn,hasBracke);
             
    }                                    

private void PIBtnActionPerformed(java.awt.event.ActionEvent evt) {                                     

                            
    answertTF.setText(null);
    answertTF.setText(String.valueOf(Math.PI));

        // TODO add your handling code here:
    }                                    
	
 private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {                                     


        // TODO add your handling code here:
    }                                    
 
  	private void logBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
 
      
    }//GEN-LAST:event_btn8ActionPerformed
 
  
 
    private void backSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backSpaceActionPerformed
  calculator.addDefaultValue();
    }//GEN-LAST:event_backSpaceActionPerformed

    private final String expressionPattern  = "(\\d+\\.*)(-|\\+|/|\\*\\^)(\\d+\\.*\\d+)";
    
    private void negativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativeActionPerformed


    
        String text  = answertTF.getText();
    Number  v  = 0;
    if( !text.matches(expressionPattern)){
        System.out.println("matches");
        if(text.matches("\\d*\\.\\d*")){
        v = new Double( Double.parseDouble(text));
        answertTF.setText((v.doubleValue() * (-1))+"");
    }else if(text.matches("\\d*")){
       v = new Integer( Integer.parseInt(text));
      answertTF.setText((v.intValue() * (-1))+"");
    }  
        double   x  = Math.IEEEremainder(4.2, 2.2);
        x =  Math.abs(x);
        
        
    }//end if 

  
        // TODO add your handling code here:
    }//GEN-LAST:event_negativeActionPerformed

  
    
    boolean isAnswer  =  false;
    private String anserString = "0";
    private boolean hasBracke =false;
    private List<Boolean> bracketMatchObserver;
    private void equalsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalsBtnActionPerformed

     int macthSize  =bracketMatchObserver.size();
    String x = answertTF.getText();
if(!CalculatorModel.containsBracket(x)) hasBracke = false;
  
if(!hasBracke)
   calculator.addLast(calculator.getFirstLastExp(answertTF.getText(),"l")); 
   
 if(answertTF.getText().matches(CalculatorModel.mathFunction())){ 
      calculator.equals(); 
      listMap.put(x, answertTF.getText());
      anserString += answertTF.getText();  
      listModel.addElement(x);
   }else if(answertTF.getText().matches(CalculatorModel.sciNotation())){
        calculator.exponent(answertTF.getText());
      listMap.put(x, answertTF.getText());
      anserString = answertTF.getText();  
      listModel.addElement(x);
      isAnswer =  true;
   }else if(macthSize > 0){
       answertTF.setText("0");
       System.out.println("contans brackets");
       hasBracke = false;
       System.out.print("matchPairList:-->");
       calculator.printExp(matchPairList);
      anserString = answertTF.getText();  
        bracketMatchObserver.clear();
   }else {
      
      addFirstLAst();
      calculator.calculateCompoundExpression();
      anserString = answertTF.getText();  
      
   }
   
  CalculatorModel.formatNumber(answertTF);

  


    }//GEN-LAST:event_equalsBtnActionPerformed

    
    
 private void setAnswer(){
  String x  = answertTF.getText();     
 answertTF.setText(x+anserString);
 }   
    
    
    private void addFirstLAst(){
 if(!answertTF.getText().matches("0")){   
    if( !calculator.containsOperator(calculator.getFirstLastExp(answertTF.getText(),"f")) )
      calculator.addFirst(calculator.getFirstLastExp(answertTF.getText(),"f"));
 }
    
        
        
   
    
    }
    
    
    
    private void squareRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareRootActionPerformed

   calculator.squareRoo();
 
    }//GEN-LAST:event_squareRootActionPerformed

    private void leftBracketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftBracketActionPerformed
 
     bracketMatchObserver.add(false);
        insertBrackets(leftBracket);
 
    }//GEN-LAST:event_leftBracketActionPerformed

    private void insertBrackets(JButton b){
    
      String text  =  answertTF.getText();
        
       if(text.matches("0")){
       answertTF.setText("");
       answertTF.setText( b.getText() );
       } else 
        answertTF.setText(text+ b.getText() );
    hasBracke = true;
    }
    
    private void rightBracketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBracketActionPerformed
    bracketMatchObserver.set(bracketMatchObserver.size()-1, true);
       insertBrackets(rightBracket);
  

    }//GEN-LAST:event_rightBracketActionPerformed

    private void prevAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevAnsActionPerformed

if(anserString != null)
  answertTF.setText(answertTF.getText()+anserString);

    }//GEN-LAST:event_prevAnsActionPerformed

    private void expBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expBtnActionPerformed

calculator.addExp();
     

        // TODO add your handling code here:
    }//GEN-LAST:event_expBtnActionPerformed

    private void xyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xyBtnActionPerformed
  calculator.addOperator(xyBtn,hasBracke);
        

        // TODO add your handling code here:
    }//GEN-LAST:event_xyBtnActionPerformed

    private void x2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x2BtnActionPerformed

 String text  =  answertTF.getText();
    

    double   root  =  Double.parseDouble(text) * Double.parseDouble(text);
   
    if( !String.valueOf(root).matches("(\\d+)(\\.+?0)"))
        answertTF.setText(root+"");
   else
          answertTF.setText((int)root+"");


    
    

        // TODO add your handling code here:
    }//GEN-LAST:event_x2BtnActionPerformed

    private void x3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x3BtnActionPerformed
calculator.findCube();
    }//GEN-LAST:event_x3BtnActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

    }//GEN-LAST:event_formPropertyChange

    private void sinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinBtnActionPerformed
 answertTF.setText("Sin("+answertTF.getText()+")");
       
    }//GEN-LAST:event_sinBtnActionPerformed

    private void sinhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinhBtnActionPerformed
   
    answertTF.setText("Sinh("+answertTF.getText()+")");
    }//GEN-LAST:event_sinhBtnActionPerformed

    private void cosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosBtnActionPerformed
     answertTF.setText("Cos("+answertTF.getText()+")");

        // TODO add your handling code here:
    }//GEN-LAST:event_cosBtnActionPerformed

    private void coshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coshBtnActionPerformed

  answertTF.setText("Cosh("+answertTF.getText()+")");

        // TODO add your handling code here:
    }//GEN-LAST:event_coshBtnActionPerformed

    private void tanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanBtnActionPerformed

 answertTF.setText("tan("+answertTF.getText()+")");


        // TODO add your handling code here:
    }//GEN-LAST:event_tanBtnActionPerformed

    private void logBas10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBas10ActionPerformed

answertTF.setText("powten("+answertTF.getText()+")");


        // TODO add your handling code here:
    }//GEN-LAST:event_logBas10ActionPerformed

    private void modBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modBtnActionPerformed

    answertTF.setText(answertTF.getText()+" mod ");


        // TODO add your handling code here:
    }//GEN-LAST:event_modBtnActionPerformed

    private void roundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundBtnActionPerformed

 answertTF.setText("round("+answertTF.getText()+")");


        // TODO add your handling code here:
    }//GEN-LAST:event_roundBtnActionPerformed

    private void InBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InBtnActionPerformed

 answertTF.setText("In("+answertTF.getText()+")");

        // TODO add your handling code here:
    }//GEN-LAST:event_InBtnActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       history.setLocationRelativeTo(this);
        history.setVisible(true);
      
       calculator.printExp(calculator);
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
     String key  =  jList1.getSelectedValue();
     
    if(listMap.containsKey(key)){
     answertTF.setText(listMap.get(key));
     CalculatorModel.formatNumber(answertTF);
    isAnswer =  true;
    }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
       

        
    }//GEN-LAST:event_jList1ValueChanged

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        
        if(evt.getClickCount() ==  2){
            String key  =  jList1.getSelectedValue();
     
            if(listMap.containsKey(key)){
             answertTF.setText(listMap.get(key));
             history.setVisible(false);
           isAnswer =  true;
    }   
        
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void x3Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x3Btn1ActionPerformed


    }//GEN-LAST:event_x3Btn1ActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear1ActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear2ActionPerformed

    private void clear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear3ActionPerformed

    private void clear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear4ActionPerformed

    private void clear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear5ActionPerformed

    private void x3Btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x3Btn2ActionPerformed
    double x  =  Double.valueOf(answertTF.getText());
    
       double    v  = Math.cbrt(x);
       
         if( !String.valueOf(v).matches("(\\d+)(\\.+?0)"))
        answertTF.setText(v+"");
   else
          answertTF.setText((int)v+""); 
     
       
     listMap.put("cbrt("+x+")", answertTF.getText());
      listModel.addElement("cbrt("+x+")");
      isAnswer =  true;    }//GEN-LAST:event_x3Btn2ActionPerformed

    private void InBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InBtn2ActionPerformed

       int x  =  Integer.valueOf(answertTF.getText());
       double    v  =  1/ (double)x;
       answertTF.setText(""+v);
       
     listMap.put("reciproc("+x+")", answertTF.getText());
      listModel.addElement("reciproc("+x+")");
      isAnswer =  true;

    }//GEN-LAST:event_InBtn2ActionPerformed

    private void logBtnActionPerformed2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBtnActionPerformed2
answertTF.setText("Log("+answertTF.getText()+")");    }//GEN-LAST:event_logBtnActionPerformed2

    private void clear6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear6ActionPerformed

    private void dividBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dividBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dividBtn1ActionPerformed

    private void roundBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundBtn2ActionPerformed

    private void roundBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundBtn3ActionPerformed

    private void roundBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundBtn4ActionPerformed

    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtn1ActionPerformed

    private void logBas11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBas11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logBas11ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
      // [30, 45], [26, 33]
        setSize(new Dimension(292, 330));
        answertTF.setColumns(21);
        validate();
      
      
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void initCompSize(){
      setSize(new Dimension(292, 330));
      getContentPane().setBackground(new Color(153,204,255)); 
      ansPane .setPreferredSize(new Dimension(279, 49));
      answertTF.setPreferredSize(new Dimension(279-200, 49));
      answertTF.setColumns(21);
    
    }
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //[754, 296] [744, 275] [744, 296]
        
     setSize(new Dimension(650, 330));
     answertTF.setColumns(51);
     validate();  
        
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void factorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factorialActionPerformed
        answertTF.setText("fact("+answertTF.getText()+")");
     
    }//GEN-LAST:event_factorialActionPerformed
 
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InBtn;
    private javax.swing.JButton InBtn2;
    private javax.swing.JButton PIBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addBtn1;
    private javax.swing.JPanel ansPane;
    private javax.swing.JTextField answertTF;
    private javax.swing.JButton backSpace;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton clear2;
    private javax.swing.JButton clear3;
    private javax.swing.JButton clear4;
    private javax.swing.JButton clear5;
    private javax.swing.JButton clear6;
    private javax.swing.JPopupMenu copyPopup;
    private javax.swing.JButton cosBtn;
    private javax.swing.JButton coshBtn;
    private javax.swing.JButton dividBtn;
    private javax.swing.JButton dividBtn1;
    private javax.swing.JButton dotBtn;
    private javax.swing.JButton equalsBtn;
    private javax.swing.JButton expBtn;
    private javax.swing.JButton factorial;
    private javax.swing.JDialog history;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton leftBracket;
    private javax.swing.JButton logBas10;
    private javax.swing.JButton logBas11;
    private javax.swing.JButton logBtn2;
    private javax.swing.JPanel mainPane;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JButton minus;
    private javax.swing.JButton modBtn;
    private javax.swing.JButton negative;
    private javax.swing.JButton prevAns;
    private javax.swing.JButton rightBracket;
    private javax.swing.JButton roundBtn;
    private javax.swing.JButton roundBtn2;
    private javax.swing.JButton roundBtn3;
    private javax.swing.JButton roundBtn4;
    private javax.swing.JButton sinBtn;
    private javax.swing.JButton sinhBtn;
    private javax.swing.JButton squareRoot;
    private javax.swing.JButton tanBtn;
    private javax.swing.JButton tanhBtn;
    private javax.swing.JButton times;
    private javax.swing.JButton x2Btn;
    private javax.swing.JButton x3Btn;
    private javax.swing.JButton x3Btn1;
    private javax.swing.JButton x3Btn2;
    private javax.swing.JButton xyBtn;
    // End of variables declaration//GEN-END:variables


public   String getPropertyStore(String fileName, boolean  external){
 
     Path p = null;
     String appData = null;
 if(external) {  
     try {
       if(System.getenv("AppData") != null){     
            if(!Files.exists(Paths.get(System.getenv("AppData")+"\\sientific_calculator\\properties")))
             p =      Files.createDirectories(Paths.get(System.getenv("AppData")+"\\sientific_calculator\\properties"));
       }else if(System.getProperty("user.home") != null)
             if(!Files.exists(Paths.get(System.getProperty("user.home")+"\\sientific_calculator\\properties")))
                p =  Files.createDirectories(Paths.get(System.getProperty("user.home")+"\\sientific_calculator\\properties"));
       
     } catch (IOException ex) {}
     
     
      
       appData =  System.getenv("AppData")+"\\sientific_calculator\\\\properties\\"+fileName;
     if(appData== null)
      appData = System.getProperty("user.home")+"\\sientific_calculator\\\\properties\\"+fileName;     
 }//end if  for external 
 else {
 appData = "src\\cal\\"+fileName;
     System.out.println("enternal: "+appData);
 }
 
     
     
     
 
 return appData;
 }   
 

}
