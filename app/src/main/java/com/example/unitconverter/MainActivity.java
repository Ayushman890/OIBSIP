package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputKg;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputKg = findViewById(R.id.valuekg);
        convertButton = findViewById(R.id.btn);
        resultText = findViewById(R.id.result);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    convertKgToGrams();
                } catch (NumberFormatException e) {
                    resultText.setText("Invalid input. Please enter a valid number.");
                } catch (Exception e) {
                    resultText.setText("An unexpected error occurred. Please try again.");
                }
            }
        });
    }

    private void convertKgToGrams() {
        String input = inputKg.getText().toString();
        if (!input.isEmpty()) {
            try {
                double kg = Double.parseDouble(input);
                double grams = kg * 1000;
                resultText.setText(kg + " kg is " + grams + " grams");
            } catch (NumberFormatException e) {
                resultText.setText("Invalid input. Please enter a valid number.");
            }
        } else {
            resultText.setText("Please enter a value in kg.");
        }
    }
}
