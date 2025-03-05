package com.numeric.calculator.methods;

import java.util.ArrayList;
import java.util.List;

import org.matheclipse.core.eval.EvalUtilities;

import com.numeric.models.FalseRuleIteration;


public class FalseRuleMethod {
	
	private double root;

	public List<FalseRuleIteration> falseRuleMethod(String function,double A, double B){
		
	    double tolerance = 1e-8;
	    int maxIterations = 100;
	    
	    List<FalseRuleIteration> iterations = new ArrayList<>();
		
        EvalUtilities util = new EvalUtilities(false, true);
        
        double xr=0;
        double xi=A;
        double xu=B;
        
        double fxi= evaluateFunction(function, xi, util);
        double fxu= evaluateFunction(function, xu, util);
        
        //System.out.println(fxi);
        //System.out.println(fxu);
        //System.out.println(function);
        //Prubea de logica en java
        if (fxi * fxu >= 0) {
            throw new IllegalArgumentException("No cumple el teorema de fxi*fxu>= 0");
        }
        
        double fxr;
        
        for(int i=0;i<maxIterations;i++){
        	
        xr = xu - (fxu * (xi - xu) / (fxi - fxu));
            
        fxr = evaluateFunction(function, xr, util); 
        
        iterations.add(new FalseRuleIteration(i, xi, xu, xr, fxr, fxi, fxu));
        	
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
        
        root = xr;
        return iterations;
	}
	
	private double evaluateFunction(String function, double x, EvalUtilities util) {
	    String evalFunction = function.replace("x", String.valueOf(x));
	    
	    try {
	        return Double.parseDouble(util.evaluate(evalFunction).toString().replace("*10^", "E"));
	    } catch (Exception e) {
	        throw new RuntimeException("Error al evaluar la función en x = " + x, e);
	    }
	}
	
	public double getRoot() {
		return root;
	}
	
	
	
}
