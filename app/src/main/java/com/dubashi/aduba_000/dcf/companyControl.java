package com.dubashi.aduba_000.dcf;

/**
 * Created by aduba_000 on 8/13/2015.
 */
public class companyControl {

    public static WACC wacc;
    public static revenueProjections revenueProj;

    public static void initializeWacc(double riskFreeRate, double beta, double riskPremium, double corporateTaxRate, double marketRateOfDebt, double equityToTotal,
                                      double debtToTotal){
        wacc = new WACC(riskFreeRate,beta,riskPremium,corporateTaxRate,marketRateOfDebt,equityToTotal,
         debtToTotal);
        wacc.calculateWACC();
    }

    public static void initializeRevenueProj(int years, double growthRate, double initialRevenue, double operatingCostsMargin,
                                             double taxRate, double netInvestmentPercent, double initialWorkingCapital,
                                             double initialChangeInWorkingCapital){
        revenueProj = new revenueProjections(years,growthRate,initialRevenue,operatingCostsMargin,taxRate,netInvestmentPercent,initialWorkingCapital,initialChangeInWorkingCapital);
        revenueProj.calculateRevenueTable();


    }
}
