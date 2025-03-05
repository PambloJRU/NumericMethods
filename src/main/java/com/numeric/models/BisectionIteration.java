package com.numeric.models;

public class BisectionIteration {

	private int iteration;
	private double xi;
	private double xr;
	private double xu;
	
	public BisectionIteration(int iteration, double xi, double xr, double xu) {
		this.iteration = iteration;
		this.xi = xi;
		this.xr = xr;
		this.xu = xu;
	}
	
	// Getters
	public int getIteration() { return iteration; }
	public double getXi() { return xi; }
	public double getXr() { return xr; }
	public double getXu() { return xu; }
	
}
