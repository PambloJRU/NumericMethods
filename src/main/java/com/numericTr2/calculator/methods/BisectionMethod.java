package com.numericTr2.calculator.methods;

import java.util.ArrayList;
import java.util.List;

import org.matheclipse.core.eval.EvalUtilities;

import com.numericTr2.models.BisectionIteration;
import com.numericTr2.models.FalseRuleIteration;


public class BisectionMethod {
	
	private double root=0;
	
	
	public BisectionMethod() {
		
	}
	
	public List<BisectionIteration> BisectionMethods(String function,double A, double B){
		
	    double tolerance = 1e-11;
	    int maxIterations = 100;
	    List<BisectionIteration> iterations = new ArrayList<>();
	
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
        
        iterations.add(new BisectionIteration(i, xi, xu, xr));
        	
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
