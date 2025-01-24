package com.numericTr2.calculator.methods;

import java.util.ArrayList;

import org.matheclipse.core.eval.EvalUtilities;


public class BisectionMethod {
	
	


	public BisectionMethod() {
		
	}
	
	public double bisectionMethods(String function,double A, double B) {
		
	    double tolerance = 1e-11;
	    int maxIterations = 100;
		
        EvalUtilities util = new EvalUtilities(false, true);
        
        double xr=0;
        double xi=A;
        double xu=B;
        
        double fxi= evaluateFunction(function, xi, util);
        double fxu= evaluateFunction(function, xu, util);
        
        //Prubea de logica en java, si me da pereza, toca hacerlo en javascript :V
        if (fxi * fxu >= 0) {
            throw new IllegalArgumentException("No cumple el teorema de biseccion");
        }
        
        double fxr;
        
        for(int i=0;i<maxIterations;i++){
        	
        xr = (xi+xu)/2;
            
        fxr = evaluateFunction(function, xr, util); 
        	
        	System.out.println(i);
        if (Math.abs(fxr) < tolerance || Math.abs(xu - xi) < tolerance) {
            System.out.println("Convergencia alcanzada en iteración: " + i);
            break;
        }
            
        if (fxr * fxi < 0) {
            xu = xr;
            fxu = fxr;
        } else {
            xi = xr;
            fxi = fxr;
        }
      }  
        return xr;
	}
	
	private double evaluateFunction(String function, double x, EvalUtilities util) {
	    String evalFunction = function.replace("x", String.valueOf(x));
	    try {
	        return Double.parseDouble(util.evaluate(evalFunction).toString().replace("*10^", "E"));
	    } catch (Exception e) {
	        throw new RuntimeException("Error al evaluar la función en x = " + x, e);
	    }
	}
	
}
