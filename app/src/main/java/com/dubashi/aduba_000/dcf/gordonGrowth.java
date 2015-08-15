package com.dubashi.aduba_000.dcf;
import java.util.*;

public class gordonGrowth {
	public revenueProjections companyCashFlow;
	public WACC discountRate;
	public List<Double> cashFlowTable;
	public double cashFlowGrowthRate;
	public double finalYearCashFlow;
	public double terminalValue;
	public double enterpriseValue;
	
	public gordonGrowth(int years, double growthRate, double initialRevenue, double operatingCostsMargin,
			  			double taxRate, double netInvestmentPercent, double initialWorkingCapital,
			  			double initialChangeInWorkingCapital,double riskFreeRate, double beta, double riskPremium, double marketRateOfDebt,
			  			double equityToTotal, double debtToTotal, double cashFlowGrowthRate ){
		this.companyCashFlow = new revenueProjections(years,growthRate,initialRevenue,operatingCostsMargin,
							  taxRate,netInvestmentPercent,initialWorkingCapital,
							  initialChangeInWorkingCapital);

		this.discountRate = new WACC(riskFreeRate, beta,riskPremium,taxRate, marketRateOfDebt,equityToTotal, debtToTotal);
		discountRate.calculateWACC();
		companyCashFlow.calculateRevenueTable();
		this.cashFlowTable = companyCashFlow.getCashFlowList();
		this.cashFlowGrowthRate = cashFlowGrowthRate;

	}
	
	
	
	public String getCashFlow(){
		String listString = companyCashFlow.getCashFlowList().toString();
		return listString;
	}
	
	public void calculateGordonValue() {
		/*
		Terminal Value = Final Projected Year Cash Flow X (1+Long-Term Cash Flow Growth Rate) 
				(Discount Rate � Long-Term Cash Flow Growth Rate)
		*/
		this.finalYearCashFlow = this.cashFlowTable.get(this.cashFlowTable.size()-1);
		System.out.println("Final Year Cash Flow");
		System.out.println(this.finalYearCashFlow);
		
		this.terminalValue = this.finalYearCashFlow * (1 + this.finalYearCashFlow);
		
		double growth = (this.discountRate.getWACC() - this.cashFlowGrowthRate) * 100;
		
		this.terminalValue = this.terminalValue / growth;
		
		 //this.terminalValue = this.terminalValue  /1000000;
		
	}
	public void calculateMultipleValue(int multiple){
		System.out.println("Final Year Cash Flow");
		System.out.println(this.finalYearCashFlow);
		
		this.terminalValue = this.terminalValue * multiple;
		
	}
	
	public void calculateEnterpriseValue() {
		/*
		EV = ($18.5M/1.11) + ($21.3M/(1.11)2) + ($24.1M/(1.11)3) + 
		($19.9M/(1.11)4) + ($21.3M/(1.11)5) + ($316.9M/(1.11)5) 
		*/
		for(int i = 0; i <=  companyCashFlow.years; i++){
			this.enterpriseValue += (this.cashFlowTable.get(i)/ Math.pow((1 + this.discountRate.getWACC()), i));
		}
		
		this.enterpriseValue += this.terminalValue;
		
	}
	
	
	
	
	
	public double getTerminalValue(){
		return this.terminalValue;
	}
	
	

}
