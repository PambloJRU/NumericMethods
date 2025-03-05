package com.numeric.calculator.methods;

import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.interfaces.IExpr;

public class GaussianQuadrature {
    
    EvalUtilities util = new EvalUtilities(false, true);
    
    public GaussianQuadrature(){}
    
    //a: limite inferior, b: limite superior
 @SuppressWarnings("deprecation")
public void threePounds(String function, double a, double b){
           
     double w2 = 0.8888888;
     double w1 = 0.5555555;
     double w3 = w1;
     
     double z2=0;
     double z1= -0.7745966;
     double z3= 0.7745966;
     
     double f1=(((b-a)/2)*z1)+((a+b)/2);
     double f2=(((b-a)/2)*z2)+((a+b)/2);
     double f3=(((b-a)/2)*z3)+((a+b)/2);
     
     String evalF1 = function.replace("x", "(" + f1 + ")");
     String evalF2 = function.replace("x", "(" + f2 + ")");
     String evalF3 = function.replace("x", "(" + f3 + ")");
     
     IExpr f_1 = util.evaluate(evalF1);
     IExpr f_2 = util.evaluate(evalF2);
     IExpr f_3 = util.evaluate(evalF3);

     double valueF1 = f_1.isReal() ? f_1.evalDouble() : 0;
     double valueF2 = f_2.isReal() ? f_2.evalDouble() : 0;
     double valueF3 = f_3.isReal() ? f_3.evalDouble() : 0;

     
     double finalResult = (b - a) / 2 * (w1 * valueF1 + w2 * valueF2 + w3 * valueF3);
    
     System.out.println("El resultado de la integral aprox con 3 pesos es: " + finalResult );
     
    }
 
 
 @SuppressWarnings("deprecation")
public double fourthPounds(String function, double a, double b){
     
     double w1=0.347854845137;
     double w2=0.652145154862;
     double w3=w2;
     double w4=0.347854845137;
     
     double z1= -0.861136311594;
     double z2= -0.339981043585;
     double z3= 0.339981043585;
     double z4= 0.861136311594;
     
     double f1=(((b-a)/2)*z1)+((a+b)/2);
     double f2=(((b-a)/2)*z2)+((a+b)/2);
     double f3=(((b-a)/2)*z3)+((a+b)/2);
     double f4=(((b-a)/2)*z4)+((a+b)/2);
     
     String evalF1 = function.replace("x", "(" + f1 + ")");
     String evalF2 = function.replace("x", "(" + f2 + ")");
     String evalF3 = function.replace("x", "(" + f3 + ")");
     String evalF4 = function.replace("x", "(" + f4 + ")");
     
     IExpr f_1 = util.evaluate(evalF1);
     IExpr f_2 = util.evaluate(evalF2);
     IExpr f_3 = util.evaluate(evalF3);
     IExpr f_4 = util.evaluate(evalF4);
     
     System.out.println(f_1.toString());
     System.out.println(f_2.toString());
     System.out.println(f_3.toString());

     double valueF1 = f_1.isReal() ? f_1.evalDouble() : 0;
     double valueF2 = f_2.isReal() ? f_2.evalDouble() : 0;
     double valueF3 = f_3.isReal() ? f_3.evalDouble() : 0;
     double valueF4 = f_4.isReal() ? f_4.evalDouble() : 0;
             
    return (b - a) / 2 * (w1 * valueF1 + w2 * valueF2 + w3 * valueF3+ w4 * valueF4);
    
    
 }
 
}
