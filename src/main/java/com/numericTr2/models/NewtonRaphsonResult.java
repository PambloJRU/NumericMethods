package com.numericTr2.models;

import java.util.List;

public class NewtonRaphsonResult {
    private double root;
    private List<NewtonRaphsonIteration> iterations;

    public NewtonRaphsonResult(double root, List<NewtonRaphsonIteration> iterations) {
        this.root = root;
        this.iterations = iterations;
    }

    // Getters
    public double getRoot() { return root; }
    public List<NewtonRaphsonIteration> getIterations() { return iterations; }
}
