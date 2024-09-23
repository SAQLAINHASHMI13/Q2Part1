package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultDisplay;
    private String currentOperator = "";
    private double operand1 = 0, operand2 = 0;
    private boolean isNewOp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultDisplay = findViewById(R.id.resultDisplay);

        // Number Buttons
        setNumberButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String buttonText = button.getText().toString();
                if (isNewOp) {
                    resultDisplay.setText(buttonText);
                    isNewOp = false;
                } else {
                    resultDisplay.append(buttonText);
                }
            }
        };

        findViewById(R.id.btn0).setOnClickListener(numberClickListener);
        findViewById(R.id.btn1).setOnClickListener(numberClickListener);
        findViewById(R.id.btn2).setOnClickListener(numberClickListener);
        findViewById(R.id.btn3).setOnClickListener(numberClickListener);
        findViewById(R.id.btn4).setOnClickListener(numberClickListener);
        findViewById(R.id.btn5).setOnClickListener(numberClickListener);
        findViewById(R.id.btn6).setOnClickListener(numberClickListener);
        findViewById(R.id.btn7).setOnClickListener(numberClickListener);
        findViewById(R.id.btn8).setOnClickListener(numberClickListener);
        findViewById(R.id.btn9).setOnClickListener(numberClickListener);
    }

    private void setOperatorButtonListeners() {
        findViewById(R.id.btnAdd).setOnClickListener(opClickListener);
        findViewById(R.id.btnSubtract).setOnClickListener(opClickListener);
        findViewById(R.id.btnMultiply).setOnClickListener(opClickListener);
        findViewById(R.id.btnDivide).setOnClickListener(opClickListener);
        findViewById(R.id.btnEquals).setOnClickListener(equalsClickListener);
        findViewById(R.id.btnClear).setOnClickListener(clearClickListener);
    }

    private final View.OnClickListener opClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            currentOperator = button.getText().toString();
            operand1 = Double.parseDouble(resultDisplay.getText().toString());
            isNewOp = true;
        }
    };

    private final View.OnClickListener equalsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            operand2 = Double.parseDouble(resultDisplay.getText().toString());
            double result = 0;
            switch (currentOperator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
            }
            resultDisplay.setText(String.valueOf(result));
            isNewOp = true;
        }
    };

    private final View.OnClickListener clearClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resultDisplay.setText("0");
            operand1 = operand2 = 0;
            currentOperator = "";
        }
    };
}
