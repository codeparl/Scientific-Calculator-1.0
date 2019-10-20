/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cal;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.property.adapter.JavaBeanDoublePropertyBuilder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author HASSAN
 */
public class CalculatorModel  extends  LinkedList<String>{
private final JTextField  answertTF;
private boolean isAnswer;
private  DefaultListModel<String> listModel;
TreeMap<String, String> listMap;
private String anserString;
private  BracketExpHandler bracketExpHandler;
private     ArrayDeque<String> stackList;
private final ArrayDeque<String> matchPairList;
public CalculatorModel(boolean isAnswer,JTextField   ansField,ArrayDeque<String> mpl) {
    this.answertTF =  ansField;
     this.isAnswer = isAnswer;
    matchPairList =  mpl;
    }//end constructor

 public void setListMap(TreeMap<String, String> listMap) {
        this.listMap = listMap;
    }

public static String mathFunction(){
  
  String word = "([a-zA-Z])+";
String leftBracket  = "\\(";
String rightBracket  = "\\)";
String leftOperand  = "(\\d+(\\.\\d+)?)";
String or  = "|";
String space ="\\s";


String functionExp =word+leftBracket+
                    leftOperand+
                    rightBracket+or+
                    leftOperand+space+"mod"+space+leftOperand;  
  return functionExp;
  }  
  public static  String sciNotation(){
  String sciNotation  = "-?\\d+\\.(\\d*)E(\\+|-)\\d+";


  return sciNotation;
  }
  
  public static boolean containsBracket(String text){
  
  return  BracketExpHandler.bracketsFound(text, MathPatterns.makeMathPattern());
  
  }
    public void setListModel(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }

    public void setAnserString(String anserString) {
        this.anserString = anserString;
    }
    
    
    public BigDecimal  computeFactorialOf(double n){
    
    if(n <= 1.0) return BigDecimal.valueOf(n);
    else return BigDecimal.valueOf(n).multiply(computeFactorialOf(n-1)) ;
    
    }

    public void setLIST(ArrayDeque<String> LIST) {
        this.stackList = LIST;
        this.bracketExpHandler = new BracketExpHandler(answertTF,stackList);
    }
       
    
   public  void addOperator(JButton b, boolean hasBracket){
        if(!hasBracket){
   
   isAnswer =  false;
       String text  =  answertTF.getText();
       Pattern  p  =  Pattern.compile(MathPatterns.rightMostExpn());
            Matcher  m =  p.matcher(text);
            char  c  = 0;
            
            //check if expression 
             if(m.find())c = m.group().charAt(0);
                   
             
          //add to list   
               if(c != 0) { 
                      
              add(text.substring(text.lastIndexOf(c)));
              System.err.println("addaed:-> "+text.substring(text.lastIndexOf(c)));
             }
               
               
     //update answer textbox          
        if(b.getText() == null || b.getText().equals("")) {
           
            answertTF.setText(text + b.getActionCommand());
        }else if(b.getText().equals("±")){
                  answertTF.setText(text + "-");
        }else if( !b.getText().equals("±")) answertTF.setText(text + b.getText());
        }else {
        addExpnWithBracket(b, answertTF.getText());
        
        } 
   }     
   boolean match  =  false;
public  void addExpnWithBracket(JButton b,String text){
  isAnswer =  false;
  String originalText  = text;
    if(text.matches("^(\\^|/|\\*|\\+|-)"))  
        text =  text.substring(text.lastIndexOf("(")-1, text.length());
    else text =  text.substring(text.lastIndexOf("("), text.length());
  System.out.println("text: "+text);
        if(text.matches(MathPatterns.formatchedPair())) {
             matchPairList.push(text);
             System.out.println("text: "+text);
        }
         
          
         
        
         
        //add to list   
//               if(c != 0) { 
//                      
//              add(text.substring(text.lastIndexOf(c)));
//              System.err.println("addaed:-> "+text.substring(text.lastIndexOf(c)));
//             }
//               
               
     //update answer textbox          
        if(b.getText() == null || b.getText().equals("")) {
          answertTF.setText(originalText + b.getActionCommand());
        }else if(b.getText().equals("±")){
                  answertTF.setText(text + "-");
        }else if( !b.getText().equals("±")) answertTF.setText(originalText + b.getText());
        

}   
   
   
   public void addBracketToList(String text){
   
    String lastX  =  Character.toString(text.charAt(text.length()-1));
    if(bracketsFound(text, makeMathPattern()) && text.endsWith(")") ) {  
     int  x  =  text.lastIndexOf("(");
     int y =  text.lastIndexOf(")");
     text  =  text.substring(x, y);
     
     stackList.push(text);
    }
    
    
       
   
   }
  
 private boolean isZeroLeading(String data){
 
    if(data.matches("0\\d*"))
              return  true;
          else if(data.matches("0\\.\\d*"))
              return false;
           
    return false;
    
    }//end method 
       
 public   void insertButtonValue(JButton...b){
     for(   JButton x : b){
   
       x.addActionListener( (ActionEvent  event)->{
        if(isAnswer)
          answertTF.setText(null);
        
         String  data = answertTF.getText();    
         if(isZeroLeading(data)){
             
           answertTF.setText(answertTF.getText().substring(1, data.length()) + x.getText() );
           if(data.matches("(\\d+(\\.(\\d+)*))E\\+0"))
               answertTF.setText(data.substring(0, data.length()-1)+x.getText());
           isAnswer =  false;
           }else{
          answertTF.setText(answertTF.getText() + x.getText() ); 
          if(data.matches("(\\d+(\\.(\\d+)*))E\\+0"))
               answertTF.setText(data.substring(0, data.length()-1)+x.getText());
          isAnswer =  false;
                   }
           
 Pattern  p  =   Pattern.compile("(\\d+\\.?\\d+)(\\+|-|\\*|/)(0\\.?\\d*)");
    Matcher   m  =  p.matcher(data);
     
       if(m.find()){
         if(isZeroLeading(m.group(3))){
            answertTF.setText(m.group(1)+m.group(2)+m.group(3).substring(1,m.group(3).length())+ x.getText());
             isAnswer =  false;
         }
         
       
         
        //else answertTF.setText(answertTF.getText() + x.getText() ); 
     
       }

   }); //end anonymous class 
   
  } //end for loop     
   
   
   }//end method 

    public  String getFirstLastExp(String text, String op){
        
       String  c1 = "";
       String data =  text;
if( !bracketsFound(data, makeMathPattern())){
       if(op.equals("f")){
       
       Pattern p  =  Pattern.compile("^(-?(\\d,*)+(\\.\\d+|d)*(-|\\+|/|\\*|\\^))");
      Matcher       m   =  p.matcher(data);  
             if(m.find())c1 = m.group();
             System.out.println("Character::  "+c1);
               data =  data.substring(0,c1.length()-1);
          
        
       }
       
       
       if(op.equals("l")){
       String c2 =  "";
       Pattern p2  =  Pattern.compile("((-|\\+|/|\\*|\\^|D)(\\d,*)+(\\.\\d+)*)$");
      Matcher       m2   =  p2.matcher(data);  
             if(m2.find())c2 = m2.group();
               data =  text.substring(text.lastIndexOf(c2));
        
        
       }
       
}  
        return data;
        }
        
                  
 public   boolean textHasOperators(){
    String text  =  answertTF.getText();
    
    for(char x : text.toCharArray())
        switch(x){
            case '^': return true;
            case '/': return true;
            case '*': return true;
            case '+': return true;
            case '-': return true;
            case 'D': return true;
      }
    return false;
    }
  
 
 private boolean containsDecimal(String data){
return data.matches("((-?\\d+(\\.0{1})))");

}
  public  void calculateCompoundExpression( ){
  if(answertTF.getText().matches("0")) return;
 String lastEXP =  getExpression(this);
 exp = "";
 String  text  =answertTF.getText();  
      System.out.println("<String "+lastEXP+" >");
     
   int offset  = 0;
   if(containsOperator(getFirstLastExp(text, "f")))
      offset =1;
    boolean bracketsFound  =  bracketsFound(text, makeMathPattern());
     int count2 =  countOcurrenceOf(answertTF.getText(),'*',offset); 
      int count  =  countOcurrenceOf(text,'^',offset);
     
 if(!bracketsFound){       
      
       forPower(count);
        
        count  =  countOcurrenceOf(answertTF.getText(),'/',offset);
         
         forDivisionAndMultiplication(count,count2);
         
        count  =  countOcurrenceOf(answertTF.getText(),'+',offset);
        count2 =  countOcurrenceOf(answertTF.getText(),'-',offset);
        forAdditionAndSubstraction(count,count2);
 }{
  //call for bracket handler
    //  System.out.println("Expression: "+bracketExpHandler.getBracketExp(text, makeMathPattern()));
    count  =  countOcurrenceOf(answertTF.getText(),'(',0);
        count2 =  countOcurrenceOf(answertTF.getText(),')',0);
    bracketExpHandler.extractBrackets(text, count, count2);
      System.out.println("----Stack List is:\n");  
       printExp(stackList);
  }//end method 
    
 
    
        String x  = get(0); 
        if(containsDecimal(x))
          x =  x.substring(0, x.length() -2);
         else  x  = get(0); 
        
     answertTF.setText(x);
      anserString = x;
      clear();
   
  
       listModel.addElement(lastEXP);
       listMap.put(lastEXP, answertTF.getText());
       isAnswer =  true;


}   
   
  String exp = "";
   private String getExpression(List<String>  list){
  list.forEach((t) -> {
     exp += t;
    });

return  exp;
}     
    
public   boolean containsOperator(String exp){
 
     return exp.matches("^((\\^|/|\\*|\\+|-)(\\d+(\\.\\d+)?))");
 
 }   
    
   private String extractOperand(String expre, char op){
    
    String operand  =  expre;
    Pattern  p  =   Pattern.compile("(-?\\d+\\.?\\d*)\\s?(\\+|-|\\*|/|\\^|mod)\\s?(-?\\d*\\.?\\d*)");
    Matcher   m  =  p.matcher(expre);
    switch(op){
    
        case 'l':
         if(m.find())
           operand = expre.substring(0,m.start(2));
         //   System.out.println("Left: "+operand);
           break;
        
         
       case 'r':
      
        if(m.find())
           operand = expre.substring(m.start(2)+1,expre.length()); 
        //  System.out.println("Right: "+operand);
            break;
    
    }//end switch 
    
    
    
    
    return  operand;
    }   
       
public void addDefaultValue(){
      String data  =  answertTF.getText();
          
          if(data.length() > 0){
          String v  =data.substring(0,data.length() - 1);  
          answertTF.setText(v);
          }
   if(data.length() == 1)
       answertTF.setText("0"); 

}

public void squareRoo(){
String text  =  answertTF.getText();

double root  =  0;
double  r =0;
if( text.matches("(\\d+)((\\.?)(\\d+))?")){

    root  =  Double.parseDouble(text);
    r = Math.sqrt(root);
    if( !String.valueOf(r).matches("(\\d+)(\\.+?0)"))
        answertTF.setText(r+"");
   else
          answertTF.setText((int)r+"");

anserString = answertTF.getText();
isAnswer =  true;

}
}

public  void printExp(Collection<String> list ){
     System.out.println("\nList data is:[");
            for (String ex : list) 
               System.out.print(ex);
        System.out.print("]\n"); 
        
    }

       
public  String exponent(String data){

String x  =  data.substring(0,data.indexOf("E"));
String y =  data.substring(data.indexOf("+")+1, data.length());

long v  = (long)((Double.valueOf(x)) * (Math.pow(10, Double.valueOf(y))));
answertTF.setText(v+"");
anserString= v+"";

return data;
}       
    
private void forPower(int count){

 if(count == 0)   
     return;
  
       double ans  = 0;
       String x, y;
       String firstExp  = "";
       String nextExp ="";
       
 for(int i  = 1; i < size(); i++){
        firstExp =  get(i - 1);
        nextExp = get(i);
        String op  = getOperator(nextExp, 'l');
        String firstOperator= "";
        double j, k;
 
     if(op != null){
     
         switch(op){
         
             case "^":
                 
             firstOperator= getOperator(firstExp, 'l');    
             if((i-1) < 1){
             x  =  firstExp;
             x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
            
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = Math.pow(j, k);
            
            remove(i);
            set(i-1,(String.valueOf(ans))) ;
           System.out.println("Answer is: "+ans);
             }else{
             
              x  =  firstExp;
              x=  x.substring(1, x.length());
              x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
             
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = Math.pow(j, k);
            
            remove(i);
            set(i-1,(firstOperator+ans)) ;
             System.out.println("Answer is: "+ans);
            
           } //end if  
       break;
         }//end switch 
     } //end if 
      
   
 }//end for loop 

    forPower(count-1);
    printExp(this);
}//end method 

private int countOcurrenceOf(String exp, char operator, int offset){

int x =0;
for(int i = offset; i < exp.length(); i++)
    if(exp.charAt(i) ==  operator)
        ++x;

return x;
}



public  void equals(){
 String data  =  answertTF.getText();
    
     
    String left  =  extractOperand(data, 'l');
    String right  =  extractOperand(data, 'r');   
    
    char c  =  '\u0000';
      if(data.matches("Log\\(\\d+(.\\d+)?\\)")){
    left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  'l';
    }else if(data.matches("Sin\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  's';
    
    }else if(data.matches("Sinh\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  'n';
    
    }else if(data.matches("Cos\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  'c';
    
    }else if(data.matches("Cosh\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  'o';
    
    }else if(data.matches("tan\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  't';
    
    }else if(data.matches("powten\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  'w';
    
    }else if(data.matches("round\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  'w';
    
    }else if(data.matches("In\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
    c=  'i';
    
    }else if(data.matches("fact\\(\\d+(.\\d+)?\\)")){
     left  =  data.substring(data.indexOf("(")+1, data.indexOf(")"));
          System.out.println("left: "+left);
    c=  'f';
    }
   
     if(data.contains("mod")){
        left =  extractOperand(data, 'l');
        right =   extractOperand(data, 'r');
        right = right.substring(2, right.length());
  
          c =  'm';
    
    }//end if 

   

    Pattern   p  =  Pattern.compile("(\\+|-|\\*|/|\\^)");
    Matcher  m  =  p.matcher(data);
    if(m.find())c =  m.group().charAt(0);
    
  switch(c){
  
       case 'l':
      calculate(left,null,"log");    
      break;
      
      case 's':
      calculate(left,null,"Sin");    
      break;
      
       case 'n':
      calculate(left,null,"Sinh");    
      break;
      
      case 'c':
      calculate(left,null,"Cos");    
      break;
      
     case 'o':
      calculate(left,null,"Cosh");    
      break;
      case 't':
      calculate(left,null,"tan");    
      break;
      case 'w':
      calculate(left,null,"powten");    
      break;
          
            
      case 'm':
      calculate(left,right,"mod");    
      break;
      case 'r':
      calculate(left,null,"round");    
      break;
      case 'i':
      calculate(left,null,"in");    
      break;
      case 'f':
      calculate(left,null,"fact");    
      break;
  }
    
   

}    

private void calculate(String left, String right, String op){

 double    val = 0;
  double    val2 = 0;
 if(left != null && right != null){
  val= Double.parseDouble(left);
  val2= Double.parseDouble(right); 
 }
 String lastEXP =  "";    
 

 double  ans  = 0;
 switch(op){
    case  "pow":
    ans  =  Math.pow(val, val2);
    lastEXP =val+"^"+val2;
     break;
     
     case  "log":
         
     double  log  =  Double.parseDouble(left);
     
    ans  =  Math.log10(log);    
          if(!String.valueOf(ans).matches("(\\d+\\.+?0)")) 
           answertTF.setText(ans+"");
         else
               answertTF.setText((int)ans+"");
     
     return;
     
     case "Sin":
    double  sn  =  Double.parseDouble(left);
     
    ans  =  Math.sin(sn); 
     answertTF.setText(String.valueOf(ans));
       
     return; 
     
    case "Sinh":
    double  sinh  =  Double.parseDouble(left);
     
    ans  =  Math.sin(sinh); 
     answertTF.setText(String.valueOf(ans));
       
     return; 
        
    case "Cos":
    double  cos  =  Double.parseDouble(left);
     
    ans  =  Math.cos(cos); 
     answertTF.setText(String.valueOf(ans));       
     return; 
    case "Cosh":
    double  cosh  =  Double.parseDouble(left);
     
    ans  =  Math.cosh(cosh); 
     answertTF.setText(String.valueOf(ans));
      
     return; 
   case "in":
    double  in  =  Double.parseDouble(left);
     
    ans  =  Math.log(in); 
     answertTF.setText(String.valueOf(ans));
      
     return; 
     case "tan":
    double  tan  =  Double.parseDouble(left);
     
    ans  =  Math.tan(tan); 
     answertTF.setText(String.valueOf(ans));
         
     return;
     case "round":
    double  rd  =  Double.parseDouble(left);
    ans  =  Math.round(rd); 
     answertTF.setText(String.valueOf(ans));
    
     return;
     
    case "powten":
    double  powten  =  Double.parseDouble(left);
     
    ans  =  Math.pow(10,powten); 
    
     if(!String.valueOf(ans).matches("(\\d+\\.+?0)")) 
           answertTF.setText(ans+"");
     else
       answertTF.setText((int)ans+"");
     
     return;
     
      case "fact":
    BigDecimal  fact  =  computeFactorialOf(Double.valueOf(left));
    String s = fact.toString();
    
    
    if(!s.matches("(\\d+\\.0+)")) 
           answertTF.setText(s+"");
     else
        s=  s.substring(0, s.indexOf("."));
       answertTF.setText(s);
    return; 
     
        case "mod":
       ans  =   Double.parseDouble(left.trim()) % Double.parseDouble(right.trim());
   
       if(!String.valueOf(ans).matches("(\\d+\\.+?0)")) 
           answertTF.setText(ans+"");
     else
       answertTF.setText((int)ans+"");
     
     return;
     
 }
 
 
  if(left.matches("(\\d+)(\\.?\\d+)?") ||right.matches("(\\d+)(\\.?\\d+)?") ){
     
     if(!String.valueOf(ans).matches("(\\d+\\.+?0)")) 
           answertTF.setText(ans+"");
     else
       answertTF.setText((int)ans+"");
  }else{
  
   answertTF.setText((int)ans+"");
  
 }
  
  
       listModel.addElement(lastEXP);
       listMap.put(lastEXP, answertTF.getText());
 anserString =  String.valueOf(ans);
isAnswer =  true;
}
  
 public void findCube(){
 String text  =  answertTF.getText();
    double   root  =  Double.parseDouble(text) * Double.parseDouble(text) * Double.parseDouble(text);
   
    if( !String.valueOf(root).matches("(\\d+)(\\.+?0)"))
        answertTF.setText(root+"");
   else
          answertTF.setText((int)root+"");
 
 }   
public void addExp(){
  String data =answertTF.getText();  

 if( !data.contains("."))    
      data = data+".E+0";
 else data = data+"E+0";
answertTF.setText(data);
isAnswer =  false; 
}



public static void formatNumber(JTextField  doc ){

   //create number formatter
   NumberFormat   nf  =  NumberFormat.getInstance();
   nf.setMaximumFractionDigits(23);
   double  x  = Double.valueOf(doc.getText());
  String formatted  =  nf.format(x);

  doc.setText(formatted);

  
}//end method 

private void  forDivisionAndMultiplication(int count1, int count2){

 if(count1 == 0 && count2 == 0)   
     return;
    

      double ans  = 0;
       String x, y;
       String firstExp  =  get(0);
       String nextExp ="";

    for(int i  = 1; i < size(); i++){
        firstExp =  get(i - 1);
        nextExp = get(i);
        String op  = getOperator(nextExp, 'l');
        String firstOperator= "";
        double j, k;
 
     if(op != null){
     
         switch(op){
         
             case "/":
                 
             firstOperator= getOperator(firstExp, 'l');    
             if((i-1) < 1){
             x  =  firstExp;
             x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
            
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = j/k;
            
           remove(i);
            set(i-1,(String.valueOf(ans))) ;
            System.out.println("Answer is: "+ans);
             }else{
             
              x  =  firstExp;
              x=  x.substring(1, x.length());
              x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
             
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = j/k;
            
            remove(i);
            set(i-1,(firstOperator+ans)) ;
             System.out.println("Answer is: "+ans);
            
           } //end if  
          count1 = count1-1;
       break;
       
       
    case "*":   
      firstOperator= getOperator(firstExp, 'l');    
             if((i-1) < 1){
             x  =  firstExp;
             x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
            
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = j * k;
            
            remove(i);
           set(i-1,(String.valueOf(ans))) ;
           System.out.println("Answer is: "+ans);
             }else{
             
              x  =  firstExp;
              x=  x.substring(1, x.length());
              x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
             
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = j *k;
            
           remove(i);
            set(i-1,(firstOperator+ans)) ;
             System.out.println("Answer is: "+ans);
            
           } //end if    
        
        count2 = count2-1;
    break;
       
         }//end switch 
     } //end if 
      
   
 }//end for loop 
    
       
    forDivisionAndMultiplication(count1, count2);
    printExp(this);
}//end method 


private void  forAdditionAndSubstraction(int count1, int count2){
if(count1 == 0 && count2 == 0)   
     return;
    

      double ans  = 0;
       String x, y;
       String firstExp  =  get(0);
       String nextExp ="";

    for(int i  = 1; i < size(); i++){
        firstExp =  get(i - 1);
        nextExp = get(i);
        String op  = getOperator(nextExp, 'l');
        String firstOperator= "";
        double j, k;
 
     if(op != null){
     
         switch(op){
         
             case "+":
                 
             firstOperator= getOperator(firstExp, 'l');    
             if((i-1) < 1){
             x  =  firstExp;
             x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
             
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = j+k;
            
            remove(i);
            set(i-1,(String.valueOf(ans))) ;
            System.out.println("Answer is: "+ans);
             }else{
             
              x  =  firstExp;
              x=  x.substring(1, x.length());
              x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
             
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = j+k;
            
            remove(i);
            set(i-1,(firstOperator+ans)) ;
             System.out.println("Answer is: "+ans);
            
           } //end if  
          count1 = count1-1;
       break;
       
       
    case "-":   
      firstOperator= getOperator(firstExp, 'l');    
             if((i-1) < 1){
             x  =  firstExp;
             x  =  stripFormats(x);
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
             
                 System.out.println("x:: "+x);
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = j - k;
            
            remove(i);
            set(i-1,(String.valueOf(ans))) ;
           System.out.println("Answer is: "+ans);
             }else{
             
              x  =  firstExp;
              x  =  stripFormats(x);
               System.err.println("x.substring(1, x.length(): "+x.substring(1, x.length()));
              x=  x.substring(1, x.length());
              
             y =  nextExp;
             y =  y.substring(1, y.length());
             y  =  stripFormats(y);
             
            j = Double.valueOf(x);
            k =  Double.valueOf(y);
            ans = j - k;
            
            remove(i);
            set(i-1,(firstOperator+ans)) ;
             System.out.println("Answer is: "+ans);
            
           } //end if    
        
        count2 = count2-1;
    break;
       
         }//end switch 
     } //end if 
      
   
 }//end for loop 
    
       
    forAdditionAndSubstraction(count1, count2);
    printExp(this);
    
    
}//end method 


  private  static String stripFormats(String text){

 List<String>  list  = new ArrayList<>();
 for(int k   = 0; k < text.length(); ++k)
   list.add(String.valueOf(text.toCharArray()[k]));
 
for(int k   = 0; k < list.size(); ++k)
     if(list.get(k).equals(","))
         list.remove(k);
StringBuilder  sb  = new StringBuilder();
list.forEach((t) -> {
    sb.append(t);
});

return sb.toString();
}

  private String getOperator(String exp, char opt){
  if(opt == 'l' ){  
  if(exp.contains("/")) return exp.substring(exp.indexOf("/"), exp.indexOf("/")+1);
  else  if(exp.contains("*")) return exp.substring(exp.indexOf("*"), exp.indexOf("*")+1);
   else  if(exp.contains("+")) return exp.substring(exp.indexOf("+"), exp.indexOf("+")+1);
   else  if(exp.contains("-")) return exp.substring(exp.indexOf("-"), exp.indexOf("-")+1);
   else  if(exp.contains("^")) return exp.substring(exp.indexOf("^"), exp.indexOf("^")+1);
  }  else {
   if(exp.contains("/")) return exp.substring(0, exp.indexOf("/")+1);
    else if(exp.contains("*")) return exp.substring(0, exp.indexOf("*")+1);
   else  if(exp.contains("+")) return exp.substring(0, exp.indexOf("+")+1);
   else  if(exp.contains("-")) return exp.substring(0, exp.indexOf("-")+1);
   else  if(exp.contains("^")) return exp.substring(0, exp.indexOf("^")+1);
  }
 return null;
 //&& exp.matches("((\\^|/|\\*|\\+|-)(\\d+(\\.\\d+)?))")
 }     
   
  
    public Object[] extractOperand(String expression){
    
       List<String> list  =  new ArrayList<String>();
     StringBuilder  sb  =  new StringBuilder();
   
    
    Pattern  p  = Pattern.compile("(\\(\\d+\\.?\\d*\\))+");
    //((\\+|-|\\*|/)(\\((\\d+.?\\d+)\\)))?
    //(\\(\\d+.?\\d+\\))(\\+|-|\\*|/)?(\\(\\d+.?\\d+\\))?
    Matcher  m  =  p.matcher(expression);
  
    while(m.find()){
     String g  = m.group();  
    sb.append(g).append(" ");
    System.out.println("Start: "+m.start()+"    End: "+m.end());
    }
    
        for (String string : sb.toString().split("\\s")) {
           list.add(string); 
        }
 
   
   System.out.println("operand[0]: "+list.get(0));
   
   
    
        System.out.println("group: "+m.groupCount());
        
     return list.toArray();   
    }//end method 
    
  public String[] readNumbers(String  text){
    
   Object   data[]  = extractOperand(text);
     
   String[]  x  =  new String[data.length];
   
        for (int i  = 0; i < data.length;  i++) {
            x[i] =  ((String)data[i]).substring(data[i].toString().indexOf("(")+1,data[i].toString().indexOf(")") );
        }
        
    return  x;
    }
public   String makeMathPattern(){
  
   
   return MathPatterns.makeMathPattern();
    }//end method 
    
 public  boolean bracketsFound(String text, String pattern){

	
    return bracketExpHandler.bracketsFound(text, pattern);
    }//end method
       
       
  
  
}//end class 
