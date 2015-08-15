package com.dubashi.aduba_000.dcf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dubashi.aduba_000.dcf.R;

public class rev extends Activity {

    EditText years;
    EditText growthRate;
    EditText initialRevenue;
    EditText operatingCostsMargin;
    EditText taxRate;
    EditText netInvestmentPercent;
    EditText initialWorkingCapital;
    EditText initialChangeInWorkingCapital;

    TextView yearList;
    TextView revenueList;
    TextView operatingCostList;
    TextView taxList;
    TextView afterTaxProfitList;
    TextView netInvestmentList;
    TextView workingCapitalList;
    TextView changeInWorkingCapitalList;
    TextView freeCashFlowList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rev);

        Button submit = (Button) findViewById(R.id.submitChanges);

        //EditTexts
        years = (EditText) findViewById(R.id.yearsValue);
        growthRate = (EditText) findViewById(R.id.growthValue);
        initialRevenue  = (EditText) findViewById(R.id.initialRevenueValue);
        operatingCostsMargin = (EditText) findViewById(R.id.operatingCostsMarginValue);
        netInvestmentPercent = (EditText) findViewById(R.id.netInvestmentPercentValue);
        taxRate = (EditText)findViewById(R.id.taxRateValue);
        initialWorkingCapital  = (EditText) findViewById(R.id.initialWorkingCapitalValue);
        initialChangeInWorkingCapital  = (EditText) findViewById(R.id.initialChangeInWorkingCapitalValue);

        //TextViews
        yearList = (TextView)findViewById(R.id.yearList);
        revenueList = (TextView) findViewById(R.id.revenueList);
        operatingCostList = (TextView) findViewById(R.id.operatingCostsList);
        taxList = (TextView) findViewById(R.id.taxesList);
        afterTaxProfitList = (TextView) findViewById(R.id.afterTaxProfitList);
        netInvestmentList = (TextView) findViewById(R.id.netInvestmentList);
        workingCapitalList = (TextView) findViewById(R.id.workingCapitalList);
        changeInWorkingCapitalList = (TextView) findViewById(R.id.changeInWorkingCapitalList);
        freeCashFlowList = (TextView) findViewById(R.id.freeCashFlowList);


        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Revenue Projections", "Submit Button Pressed");

                companyControl.initializeRevenueProj(getYears(), getGrowthRate(), getInitialRevenue(),getOperatingCostsMargin(),getNetInvestmentPercent(),
                        getTaxRate(), getInitialWorkingCapital(), getInitialChangeInWorkingCapital());
                //Years
                yearList.setText(companyControl.revenueProj.getYears());
                revenueList.setText(companyControl.revenueProj.getRevenue());
                operatingCostList.setText(companyControl.revenueProj.getOperatingCosts());
                taxList.setText(companyControl.revenueProj.getTaxes());
                afterTaxProfitList.setText(companyControl.revenueProj.getAfterTaxProfit());
                netInvestmentList.setText(companyControl.revenueProj.getNetInvestment());
                workingCapitalList.setText(companyControl.revenueProj.getWorkingCapital());
                changeInWorkingCapitalList.setText(companyControl.revenueProj.getChangeInWorkingCapital());
                freeCashFlowList.setText(companyControl.revenueProj.getFreeCashFlow());




            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rev, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.wacc) {
            Intent i = new Intent(this, WACCstatement.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private int getYears() {

        int yearsVal = 0;
        try {
            yearsVal = Integer.parseInt(years.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return yearsVal;
    }

    private double getGrowthRate() {

        double growthRateVal = 0;
        try {
            growthRateVal = Double.parseDouble(growthRate.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return growthRateVal;
    }

    private double getInitialRevenue() {

        double initialRevenueVal = 0;
        try {
            initialRevenueVal = Double.parseDouble(initialRevenue.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return initialRevenueVal;
    }
    private double getOperatingCostsMargin() {

        double operatingCostsMarginVal = 0;
        try {
            operatingCostsMarginVal = Double.parseDouble(operatingCostsMargin.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return operatingCostsMarginVal;
    }

    private double getTaxRate() {

        double taxRateVal = 0;
        try {
            taxRateVal = Double.parseDouble(taxRate.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return taxRateVal;
    }

    private double getNetInvestmentPercent() {

        double netInvestmentPercentVal = 0;
        try {
            netInvestmentPercentVal= Double.parseDouble(netInvestmentPercent.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return netInvestmentPercentVal ;
    }

    private double getInitialWorkingCapital() {

        double initialWorkingCapitalVal = 0;
        try {
            initialWorkingCapitalVal= Double.parseDouble(initialWorkingCapital.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return initialWorkingCapitalVal;
    }

    private double getInitialChangeInWorkingCapital() {

        double initialChangeInWorkingCapitalVal = 0;
        try {
            initialChangeInWorkingCapitalVal= Double.parseDouble(initialChangeInWorkingCapital.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return initialChangeInWorkingCapitalVal;
    }





}
