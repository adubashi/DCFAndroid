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


public class WACCstatement extends Activity {

    EditText riskFreeRate;
    EditText beta;
    EditText riskPremium;
    EditText corporateTaxRate;
    EditText marketRateOfDebt;
    EditText equityToTotal;
    EditText debtToTotal;

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wacc);

        Button submit = (Button) findViewById(R.id.submitChanges);

        result = (TextView) findViewById(R.id.waccVal);

        riskFreeRate = (EditText) findViewById(R.id.riskFreeRateValue);
        beta = (EditText) findViewById(R.id.betaValue);
        riskPremium  = (EditText) findViewById(R.id.riskPremiumValue);
        corporateTaxRate = (EditText) findViewById(R.id.corpTaxRateValue);
        marketRateOfDebt = (EditText)findViewById(R.id.marketRateOfDebtValue);
        equityToTotal  = (EditText) findViewById(R.id.equityToTotalValue);
        debtToTotal  = (EditText) findViewById(R.id.debtToTotalValue);



        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("WACC", "Submit Button Pressed");
                // Log.v("Revenue Change", revenueChange.getText().toString());

                companyControl.initializeWacc(getRiskFreeRate(),getBeta(),getRiskPremium(), getCorpTaxRate(), getMarketRateOfDebt()
                ,getEquityToTotal(), getDebtToTotal());

                double waccValue = companyControl.wacc.getWACC();

                result.setText(waccValue + "");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wacc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.revenue_projections) {
            Intent i = new Intent(this, rev.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private double getRiskFreeRate() {

        double riskFreeRateVal = 0;
        try {
            riskFreeRateVal = Integer.parseInt(riskFreeRate.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return riskFreeRateVal;
    }

    private double getBeta() {

        double betaVal = 0;
        try {
            betaVal = Integer.parseInt(beta.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return betaVal;
    }

    private double getRiskPremium() {

        double riskPremiumVal = 0;
        try {
            riskPremiumVal = Integer.parseInt(riskPremium.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return riskPremiumVal;
    }

    private double getCorpTaxRate() {

        double corpTaxRateVal = 0;
        try {
            corpTaxRateVal = Integer.parseInt(corporateTaxRate.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return corpTaxRateVal;
    }

    private double getMarketRateOfDebt() {

        double marketOfDebtVal = 0;
        try {
            marketOfDebtVal  = Integer.parseInt(marketRateOfDebt.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return marketOfDebtVal ;
    }

    private double getEquityToTotal() {

        double equityToTotalVal = 0;
        try {
            equityToTotalVal   = Integer.parseInt(equityToTotal.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return equityToTotalVal  ;
    }

    private double getDebtToTotal() {

        double debtToTotalVal = 0;
        try {
            debtToTotalVal  = Integer.parseInt(debtToTotal.getText().toString());
        } catch (NumberFormatException e) {
            // this is not a number. tell the user something here or do something
            Log.e("Cash Flow Statement", Log.getStackTraceString(e));
            return 0;
        }
        return debtToTotalVal;
    }







}
