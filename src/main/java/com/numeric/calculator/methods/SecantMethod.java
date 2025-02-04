package com.numeric.calculator.methods;

import java.util.ArrayList;
import java.util.List;

import org.matheclipse.core.eval.EvalUtilities;

import com.numeric.models.SecantIteration;

public class SecantMethod {
	
	private double root=0;

	public List<SecantIteration> secantMethod(String function,double A, double B) {
		
		List<SecantIteration> iterations = new ArrayList<>();
		
	    double tolerance = 1e-11;
	    int maxIterations = 100;
		
        EvalUtilities util = new EvalUtilities(false, true);
        
        double xr=0;
        double xi_1=A;
        double xi=B;
        
        double fxi_1= evaluateFunction(function, xi_1, util);
        double fxi= evaluateFunction(function, xi, util);
        
        //Prubea de logica en java, si me da pereza, toca hacerlo en javascript :V
        if (fxi_1 * fxi >= 0) {
            throw new IllegalArgumentException("No cumple el teorema de biseccion");
        }
        
        double fxr;
        
        for(int i=0;i<maxIterations;i++){
        	
        xr = xi - (fxi * (xi_1 - xi) / (fxi_1 - fxi));
            
        fxr = evaluateFunction(function, xr, util); 
        
        iterations.add(new SecantIteration(i, xi_1, xi, xr, fxi_1, fxi, fxr));
        	
        	System.out.println(i);
        if (Math.abs(fxr) < tolerance || Math.abs(xi - xi_1) < tolerance) {
            System.out.println("Convergencia alcanzada en iteración: " + i);
            break;
        }
        
        xi_1 = xi;
        xi = xr;
        fxi_1 = fxi;
        fxi = fxr;
        
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
