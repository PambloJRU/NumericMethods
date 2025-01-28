package com.numericTr2.models;



public class NewtonRaphsonIteration {
    private int iteration;
    private double xr;
    private double fxr;
    private double fprimeXr;



    public NewtonRaphsonIteration(int iteration, double xr, double fxr, double fprimeXr) {
        this.iteration = iteration;
        this.xr = xr;
        this.fxr = fxr;
        this.fprimeXr = fprimeXr;
    }

    // Getters
    public int getIteration() { return iteration; }
    public double getXr() { return xr; }
    public double getFxr() { return fxr; }
    public double getFprimeXr() { return fprimeXr; }

}
