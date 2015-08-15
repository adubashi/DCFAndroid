package com.dubashi.aduba_000.dcf;
import java.util.*;

public class revenueProjections {
	public int years;
	private double growthRate;
	private double initialRevenue;
	private double operatingCostsMargin;
	private double taxRate;
	private double netInvestmentPercent;
	private double initialWorkingCapital;
	private double initalChangeInWorkingCapital ;
	
	public  List<Double> revenueTable;
    public  List<Double> operatingCosts;
    public  List<Double> operatingProfit;
    public  List<Double> taxes;
    public  List<Double> afterTaxProfit;
    public  List<Double> netInvestment;
    public  List<Double> workingCapital;
    public  List<Double> changeInWorkingCapital;
    public  List<Double> freeCashFlow;
	
	
	public revenueProjections(int years, double growthRate, double initialRevenue, double operatingCostsMargin,
							  double taxRate, double netInvestmentPercent, double initialWorkingCapital,
							  double initialChangeInWorkingCapital){
		this.years = years;
		this.growthRate = growthRate;
		this.initialRevenue = initialRevenue;
		this.operatingCostsMargin = operatingCostsMargin;
		this.taxRate = taxRate;
		this.netInvestmentPercent = netInvestmentPercent;
		this.initialWorkingCapital= initialWorkingCapital;
		this.initalChangeInWorkingCapital = initialChangeInWorkingCapital;
		
		this.revenueTable = new ArrayList();
		this.operatingCosts = new ArrayList();
		this.operatingProfit = new ArrayList();
		this.taxes = new ArrayList();
		this.afterTaxProfit = new ArrayList();
		this.netInvestment = new ArrayList();
		this.workingCapital = new ArrayList();
		this.changeInWorkingCapital = new ArrayList();
		this.freeCashFlow = new ArrayList();
	}
	
	
	
	public void calculateRevenueTable(){
		revenueTable.add(initialRevenue);
		for(int i = 1; i <= years + 1; i++){
			double rev = revenueTable.get(i - 1);
			revenueTable.add(rev * ( 1 + growthRate));
		}
		for(int i = 1; i <= years + 1; i++){
			double rev = revenueTable.get(i - 1) * operatingCostsMargin;
			operatingCosts.add(rev);
		}
		for(int i = 1; i <= years + 1; i++){
			double rev = revenueTable.get(i - 1) - operatingCosts.get(i - 1);
			operatingProfit.add(rev);
		}
		
		for(int i = 1; i <= years + 1; i++){
			double rev = operatingProfit.get(i - 1) * this.taxRate;
			taxes.add(rev);
		}
		
		for(int i = 1; i <= years + 1; i++){
			double rev = operatingProfit.get(i - 1) - taxes.get(i - 1);
			afterTaxProfit.add(rev);
		}
		
		for(int i = 1; i <= years + 1; i++){
			double rev = revenueTable.get(i - 1) * this.netInvestmentPercent;
			netInvestment.add(rev);
		}
		
		workingCapital.add(initialWorkingCapital);
		for(int i = 1; i <= years + 1; i++){
			double rev = workingCapital.get(i - 1) * ( 1 + this.growthRate);
			workingCapital.add(rev);
		}
		
		changeInWorkingCapital.add(this.initalChangeInWorkingCapital);
		for(int i = 1; i <= years + 1; i++){
			double rev = workingCapital.get(i) - workingCapital.get(i  - 1);
			changeInWorkingCapital.add(rev);
		}
		
		
		for(int i = 1; i <= years + 1; i++){
			double rev = afterTaxProfit.get(i - 1) - netInvestment.get(i - 1) - changeInWorkingCapital.get(i - 1);
			this.freeCashFlow.add(rev);
		}
		
	}


    public String  getYears(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += "" + i + " ";
        }
        return test;
    }

    public String getRevenue(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += revenueTable.get(i);
        }
        return test;

    }

    public String getOperatingCosts(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += operatingCosts.get(i);
        }
        return test;

    }

    public String getOperatingProfit(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += operatingProfit.get(i);
        }
        return test;
    }

    public String getTaxes(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += taxes.get(i);
        }
        return test;
    }

    public String getAfterTaxProfit(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += afterTaxProfit.get(i);
        }
        return test;
    }

    public String getNetInvestment(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += netInvestment.get(i);
        }
        return test;
    }

    public String getWorkingCapital(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += workingCapital.get(i);
        }
        return test;
    }

    public String getChangeInWorkingCapital(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += changeInWorkingCapital.get(i);
        }
        return test;
    }

    public String getFreeCashFlow(){
        String test = "";
        for(int i = 0; i < years + 1; i++){
            test += " ";
            test += freeCashFlow.get(i);
        }
        return test;
    }






	public String toString(){
		String test = "";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += revenueTable.get(i);
		}
		test = test + "\n";
		test = test + "Operating Costs:" + "\n";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += operatingCosts.get(i);
		}
		
		test = test + "\n";
		test = test + "Operating Profit:" + "\n";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += operatingProfit.get(i);
		}
		
		test = test + "\n";
		test = test + "Taxes:" + "\n";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += taxes.get(i);
		}
		test = test + "\n";
		test = test + "After Tax Profit:" + "\n";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += afterTaxProfit.get(i);
		}
		
		test = test + "\n";
		test = test + "Net Investment:" + "\n";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += netInvestment.get(i);
		}
		test = test + "\n";
		test = test + "Working Capital:" + "\n";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += workingCapital.get(i);
		}
		
		test = test + "\n";
		test = test + "Change in Working Capital:" + "\n";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += changeInWorkingCapital.get(i);
		}
		
		test = test + "\n";
		test = test + "Free Cash Flow:" + "\n";
		for(int i = 0; i < years + 1; i++){
			test += " Year " + i + ": ";
			test += freeCashFlow.get(i);
		}
		return test;
	}
	
	public List<Double> getCashFlowList(){
		return this.freeCashFlow;
	}

}
