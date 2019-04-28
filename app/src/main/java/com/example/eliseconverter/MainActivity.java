package com.example.eliseconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView stonesInput;
    private TextView poundsInput;
    private TextView ouncesInput;
    private TextView kilosInput;
    private TextView gramsInput;
    private TextView feetInput;
    private TextView inchesInput;
    private TextView metresInput;
    private TextView centimetresInput;

    public void imperialToMetric(View view) {
        imperialToMetricWeight();
        imperialToMetricHeight();
    }

    public void metricToImperial(View view) {
        metricToImperialWeight();
    }

    private void imperialToMetricWeight() {
        int stones = parserHelper(stonesInput);
        int pounds = parserHelper(poundsInput);
        int ounces = parserHelper(ouncesInput);
        double stonesGrams = stones * 6350.29318;
        double poundsGrams = pounds * 453.59237;
        double ouncesGrams = ounces * 28.349;

        double totalMetricWeightInGrams = stonesGrams + poundsGrams + ouncesGrams;

        int grams = (int) totalMetricWeightInGrams % 1000;
        int kilos = (int) (totalMetricWeightInGrams - grams) / 1000;
        System.out.println("Kilos: " + kilos);
        System.out.println("Grams: " + grams);

        kilosInput.setText(String.valueOf(kilos));
        gramsInput.setText(String.valueOf(grams));
    }

    private void imperialToMetricHeight() {
        int feet = parserHelper(feetInput);
        int inches = parserHelper(inchesInput);
        int totalInInches = (feet * 12) + inches;
        double totalInCentimetres = totalInInches * 2.54;
        int remainingCentimetres = (int) totalInCentimetres % 100;
        int metres = (int) (totalInCentimetres - remainingCentimetres) / 100;

        centimetresInput.setText(String.valueOf(remainingCentimetres));
        metresInput.setText(String.valueOf(metres));
    }

    private void metricToImperialWeight() {
        int kilos = parserHelper(kilosInput);
        int grams = parserHelper(gramsInput);

        double totalMetricWeightInGrams = ((kilos * 1000) + grams);
        double totalOunces = totalMetricWeightInGrams * 0.03527396195;
        int remainingOunces = (int) totalOunces % 16;
        ouncesInput.setText(String.valueOf(remainingOunces));

        double totalPounds = (totalOunces - remainingOunces) / 16;
        int remainingPounds = (int) totalPounds % 14;
        poundsInput.setText(String.valueOf(remainingPounds));

        int totalStones = (int) (totalPounds - remainingPounds) / 14;
        stonesInput.setText(String.valueOf(totalStones));
    }

    private int parserHelper(TextView textView) {
        String input = textView.getText().toString();
        return input.equals("") ? 0 : Integer.parseInt(textView.getText().toString());
    }

    public void clearAll(View view) {
        stonesInput.setText(null);
        poundsInput.setText(null);
        ouncesInput.setText(null);
        kilosInput.setText(null);
        gramsInput.setText(null);
        feetInput.setText(null);
        inchesInput.setText(null);
        metresInput.setText(null);
        centimetresInput.setText(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stonesInput = findViewById(R.id.stoneInput);
        poundsInput = findViewById(R.id.poundsInput);
        ouncesInput = findViewById(R.id.ouncesInput);
        kilosInput = findViewById(R.id.kiloInput);
        gramsInput = findViewById(R.id.gramsInput);
        feetInput = findViewById(R.id.feetInput);
        inchesInput = findViewById(R.id.inchesInput);
        metresInput = findViewById(R.id.metresInput);
        centimetresInput = findViewById(R.id.centimetresInput);
    }


}
