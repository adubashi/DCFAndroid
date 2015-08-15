package com.dubashi.aduba_000.dcf;
public class WACC {
	//CAPM
	//Cost of Equity(Re) = Rf + Beta(Rm - Rf)(Risk Premium)
	private double riskFreeRate;
	private double beta;
	private double riskPremium;
	private double costOfEquity;
	private double costOfDebt;
	private double corporateTaxRate;
	private double marketRateOfDebt;
	private double equityToTotal;
	private double debtToTotal;
	private double wacc;
	
	public WACC(double riskFreeRate, double beta, double riskPremium, double corporateTaxRate, double marketRateOfDebt, double equityToTotal,
			    double debtToTotal){
		System.out.println("Risk Free Rate:");
		System.out.println(riskFreeRate);
		System.out.println("Beta:");
		System.out.println(beta);
		System.out.println("Risk Premium:");
		System.out.println(riskPremium);
		System.out.println("Corporate Tax Rate:");
		System.out.println(corporateTaxRate);
		System.out.println("Market Rate of Debt:");
		System.out.println(marketRateOfDebt);
		System.out.println("Equity to Total:");
		System.out.println(equityToTotal);
		System.out.println("Debt to Total:");
		System.out.println(debtToTotal);
		
		//Cost of debt
		this.debtToTotal = debtToTotal;
		this.marketRateOfDebt = marketRateOfDebt;
		this.corporateTaxRate = corporateTaxRate;
		
		//Cost of Equity
		this.equityToTotal = equityToTotal;
		this.riskFreeRate = riskFreeRate;
		this.beta = beta;
		this.riskPremium = riskPremium;



	}
	
	public double calculateWACC(){
		//WACC = Re x E/V + Rd x (1 - corporate tax rate) x D/V.
		this.costOfDebt = this.debtToTotal * ( (this.marketRateOfDebt) * (1.0 - this.corporateTaxRate) );
		this.costOfEquity = this.equityToTotal * ((this.riskFreeRate) + (this.beta*(this.riskPremium)));
		System.out.println(this.costOfDebt);
		this.wacc = this.costOfDebt + this.costOfEquity;
		return this.wacc;
	}
	
	public double getWACC(){
		return this.wacc;
	}
	

}
