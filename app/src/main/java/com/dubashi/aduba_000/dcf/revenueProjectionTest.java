package com.dubashi.aduba_000.dcf;
public class revenueProjectionTest {
	public static void main(String Args[]){
		revenueProjections company = new revenueProjections(5 ,.2 ,100000,.65,.3 ,.07, 9000, 1500);
		gordonGrowth DCF = new gordonGrowth(5 ,.2 ,100000,.65,.3 ,.07, 9000, 1500, .05, 1.3, .08, .05, .6, .4, .04);
		
		System.out.print(DCF.companyCashFlow.toString());
		System.out.println();
		System.out.println("WACC:");
		System.out.println(DCF.discountRate.getWACC());
		
		System.out.println("Gordon Growth:");
		DCF.calculateGordonValue();
		System.out.println(DCF.getTerminalValue());
	}

}
