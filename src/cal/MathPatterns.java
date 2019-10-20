/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cal;

/**
 *
 * @author HASSAN
 */
public class MathPatterns {
    

public  static String makeMathPattern(){
    String leftOperand= "(\\-?\\d+(\\.{1}\\d+)?)";
		String rightOperand= "(\\-?\\d+(\\.{1}\\d+)?)";
		String operator= "\\s*(-|\\+|/|\\*|\\^)\\s*";
		String leftOperandX= "\\-?\\(\\s*";
		String rightOperandX= "\\s*\\)";
                String leftExp  =  "("+leftOperand+operator+")";
                String rightExp = "("+operator + rightOperand+")"; 
               
		
  String exp  = leftOperand+operator+rightOperand;
  String expB = leftExp+"*"+leftOperandX+"("+exp+"+|"+leftOperand+")"+rightOperandX+rightExp+"*"; 
  String leftExpB =expB+operator;
  String rightExpB = operator+expB;
  
   
  
  String innerExp  ="(("+leftExp+"|("+expB+operator+"))*"+expB+"("+rightExp+"|("+operator+expB+"))*"+")";  
  String expOrExpBOrExpOrLeft = "("+leftExpB+"|"+innerExp+"|"+leftExp+")";
  String expOrExpBOrExpOrRightExp  = "("+rightExpB+"|"+innerExp+"|"+rightExp+")"; 
    
    
    
  String outer  = "("+expOrExpBOrExpOrLeft+"*"+leftOperandX+"("+innerExp+"|"+expB+"|"+exp+")"+rightOperandX+expOrExpBOrExpOrRightExp+"*)+";
          
   String pattern = "("+outer+"|"+expB+")+";
   
   return pattern;
    }//end method 
 public static String formatchedPair(){
     
  String operand  = "(-?\\d+(\\.\\d+)?)";  
  String operator  ="(\\^|/|\\*|\\+|-)"; 
  String l_b ="(\\(";
  String r_b = "\\))";
return "("+operator+"?"+l_b+operand+"("+operator+operand+")*"+r_b+")$";
 
 }  
 
 public static String b_rightMostExpn(){
 
  return "((\\^|/|\\*|\\+|-)(\\d+(\\.\\d+\\))?)$)";   
 } 
 
 
  
  public static String b_leftExpn(){
  
  String left= "\\(";
  String operand  = "(\\d+(\\.\\d+)?)";
   return "("+left+operand+")$";   
  }
  
 
  public static String rightMostExpn(){
  
  return  "((\\^|/|\\*|\\+|-)(\\d+(\\.\\d+)?)$)";
  }  
    
}
