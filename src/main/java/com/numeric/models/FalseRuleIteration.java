package com.numeric.models;

public class FalseRuleIteration {

	private int iteration;
	private double xi;
	private double xu;
	private double xr;
	private double fxr;
	private double fxi;
	private double fxu;
	
	public FalseRuleIteration(int iteration, double xi, double xu, double xr, double fxr, double fxi, double fxu) {
		this.iteration = iteration;
		this.xi = xi;
		this.xu = xu;
		this.xr = xr;
		this.fxr = fxr;
		this.fxi = fxi;
		this.fxu = fxu;
	}
	
	// Getters
	public int getIteration() { return iteration; }
	public double getXi() { return xi; }
	public double getXu() { return xu; }
	public double getXr() { return xr; }
	public double getFxr() { return fxr; }
	public double getFxi() { return fxi; }
	public double getFxu() { return fxu; }
	
	
	
}
