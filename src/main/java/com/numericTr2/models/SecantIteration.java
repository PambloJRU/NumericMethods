package com.numericTr2.models;

public class SecantIteration {

	private int iteration;
	private double xi_1;
	private double xi;
	private double xr;
	private double fxi_1;
	private double fxi;
	private double fxr;
	
	public SecantIteration(int iteration, double xi_1, double xi, double xr, double fxi_1, double fxi, double fxr) {
		this.iteration = iteration;
		this.xi_1 = xi_1;
		this.xi = xi;
		this.xr = xr;
		this.fxi_1 = fxi_1;
		this.fxi = fxi;
		this.fxr = fxr;
	}
	
	// Getters
	public int getIteration() { return iteration; }
	public double getXi_1() { return xi_1; }
	public double getXi() { return xi; }
	public double getXr() { return xr; }
	public double getFxi_1() { return fxi_1; }
	public double getFxi() { return fxi; }
	public double getFxr() { return fxr; }
	
	
}
