package com.numericTr2.calculator.methods;

import org.matheclipse.core.eval.EvalUtilities;

public class SecantMethod {


	public double secantMethod(String function,double A, double B) {
		
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
