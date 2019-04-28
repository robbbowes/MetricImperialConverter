package com.example.eliseconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void imperialToMetric(View view) {
        imperialToMetricWeight();
    }

    public void metricToImperial(View view) {
        metricToImperialWeight();
    }


    private void imperialToMetricWeight() {
        TextView stonesInput = findViewById(R.id.stoneInput);
        TextView poundsInput = findViewById(R.id.poundsInput);
        TextView ouncesInput = findViewById(R.id.ouncesInput);

        double stones = Double.parseDouble(stonesInput.getText().toString());
        double pounds = Double.parseDouble(poundsInput.getText().toString());
        double ounces = Double.parseDouble(ouncesInput.getText().toString());

        double stonesGrams = stones * 6350.29318;
        double poundsGrams = pounds * 453.59237;
        double ouncesGrams = ounces * 28.349;

        double totalGrams = stonesGrams + poundsGrams + ouncesGrams;
        int kilos = (int) totalGrams / 1000;
        System.out.println("Kilos: " + kilos);
        int grams = (int) totalGrams % 1000;
        System.out.println("Grams: " + grams);

        TextView kilosInput = findViewById(R.id.kiloInput);
        TextView gramsInput = findViewById(R.id.gramsInput);
        kilosInput.setText(String.valueOf(kilos));
        gramsInput.setText(String.valueOf(grams));
    }

    public void metricToImperialWeight() {
        TextView kilosInput = findViewById(R.id.kiloInput);
        TextView gramsInput = findViewById(R.id.gramsInput);
        TextView stonesInput = findViewById(R.id.stoneInput);
        TextView poundsInput = findViewById(R.id.poundsInput);
        TextView ouncesInput = findViewById(R.id.ouncesInput);

        int kilos = Integer.parseInt(kilosInput.getText().toString());
        int grams = Integer.parseInt(gramsInput.getText().toString());

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
