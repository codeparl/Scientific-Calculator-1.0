/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cal;

import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;




public class BracketExpHandler {
    
private final  JTextField answertTF;
private final  ArrayDeque<String> LIST;
public BracketExpHandler(JTextField answertTF, ArrayDeque<String> LIST) {
        this.answertTF = answertTF;
        this.LIST = LIST;
        left =  Pattern.compile("\\("); 
        right =  Pattern.compile("\\)");
       
    }

public static int countUnmatched(String text){

return 0;
}

 public static  boolean bracketsFound(String text, String pattern){
 return text.matches(pattern);
    }//end method
 
 public static String  b_getLastExp(String text){
 
     String data  =  text;
       
       String c =  "";
       Pattern p  =  Pattern.compile(MathPatterns.b_rightMostExpn());
      Matcher       m   =  p.matcher(data);  
     while(m.find()){
         System.out.println(m.group());
     } 
      
//             if(m.find())c = m.group();
//               data =  text.substring(text.lastIndexOf(c));
//       
        
 return data;
 }
 
 
 public String getBracketExp(String text, String pattern){
 StringBuilder  sb  =  new StringBuilder(256);
   Pattern  p = Pattern.compile(pattern);
  Matcher   m  =  p.matcher(text);
  System.out.println("Original text: "+text);
  
  if(m.find())
      sb.append(m.group());
     
 return sb.toString();
 }   
    
 Pattern  left;
 Pattern  right;
  Matcher m;
  Matcher m2;
  public void extractBrackets(String text,int x, int y){
      System.out.println("x==: "+x+"  y== "+y );
  if(y == 0) return;
    
   m =  left.matcher(text);
   m2 =  right.matcher(text);
  for(int i = 1; i <=x; i++){
  if(m.find() && m2.find()){
      System.out.println(m.group()+"    start"+m.start());
       System.out.println(m2.group()+"   start"+m2.start());
   String  data   =text.substring(m.start(),  m2.start()+1);

  
      System.out.println(data );
  
  }
  }     
      extractBrackets(text, x, y-1);
  
//  for(i = 1; i <= x; i++){
//   
//      
//   LIST.push(text.substring(i, y));
//    text = text.substring(i, y); 
//    System.out.println(text);
//   
//
//  }//end for loop 

  }  
    
}
