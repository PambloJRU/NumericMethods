package com.numeric.calculator.methods;

import java.util.ArrayList;
import java.util.List;
import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.interfaces.IExpr;

import com.numeric.models.NewtonRaphsonIteration;

public class NewtonRaphsonMethod {
	
	private double root=0;

    public NewtonRaphsonMethod() {}

    public List<NewtonRaphsonIteration> newthonRpMethod(String function, double startPoint) {
    	
        EvalUtilities util = new EvalUtilities(false, true);
        double tolerance = 1e-11;
        List<NewtonRaphsonIteration> iterations = new ArrayList<>();

        String derivative = "D(" + function + ", x)";
        IExpr derivativeExpr = util.evaluate(derivative);

        double xi = startPoint;
        double f_xi, fder_xi;

        for (int i = 0; i < 100; i++) {
            // Evaluar f(xi)
            String evalFunction = function.replace("x", "" + xi);
            IExpr f_xiResult = util.evaluate(evalFunction);
            f_xi = Double.parseDouble(f_xiResult.toString().replace("*10^", "E"));

            // Evaluar f'(xi)
            String evalDerivative = derivativeExpr.toString().replace("x", "(" + xi + ")");
            IExpr resultDerivative = util.evaluate(evalDerivative);
            fder_xi = Double.parseDouble(resultDerivative.toString().replace("*10^", "E"));

            // Agregar datos de la iteración actual
            iterations.add(new NewtonRaphsonIteration(i, xi, f_xi, fder_xi));

            // Verificar convergencia
            if (Math.abs(f_xi) < tolerance) {
                System.out.println("Convergencia alcanzada en iteración: " + i);
                break;
            }

            // Calcular siguiente aproximación
            double xiPlusOne = xi - f_xi / fder_xi;
            xi = xiPlusOne;
        }
        
        root = xi;

        return iterations;
    }
    
	public double getRoot() {
		return root;
	}
}
