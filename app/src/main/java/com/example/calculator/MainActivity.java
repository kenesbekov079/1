package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double oldNumber, newNumber;
    private String operator;
    private Boolean isOperationClick;
    private Boolean equal = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                if (textView.getText().toString().equals("0")) {
                    textView.setText("0");
                } else {
                    textView.append("0");
                }
                break;
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_point:
                if (!textView.getText().toString().contains(".")) {
                    textView.append(".");
                }
                break;
            case R.id.btn_clear:
                textView.setText("0");
                oldNumber = 0.0;
                newNumber = 0.0;
                break;
        }

    }

    private void setNumber(String number) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(number);
        } else if (isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
        isOperationClick = false;
    }


    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                operator = "+";
                oldNumber = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_minus:
                operator = "-";
                oldNumber = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_multiplication:
                operator = "*";
                oldNumber = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_division:
                operator = "/";
                oldNumber = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_percent:
                operator = "/";
                oldNumber = Double.parseDouble(textView.getText().toString());
                Double resullt = Double.valueOf(0);
                isOperationClick = true;
                switch (operator) {
                    case "/":
                        resullt = oldNumber / 100;
                        break;
                }
                textView.setText(new DecimalFormat("##.#######").format(resullt));
                break;
            case R.id.btn_plus_or_minus:
                operator = "+/-";
                oldNumber = Double.parseDouble(textView.getText().toString());
                Double resultS = Double.valueOf(0);
                isOperationClick = true;
                switch (operator) {
                    case "+/-":
                        resultS = oldNumber *= -1;
                        break;
                }
                textView.setText(new DecimalFormat("##.#######").format(resultS));
                break;
            case R.id.btn_equal:
                newNumber = Double.parseDouble(textView.getText().toString());
                Double result = Double.valueOf(0);
                switch (operator) {
                    case "+":
                        result = oldNumber + newNumber;
                        break;
                    case "-":
                        result = oldNumber - newNumber;
                        break;
                    case "x":
                        result = oldNumber * newNumber;
                        break;
                    case "/":
                        result = oldNumber / newNumber;
                        break;
                    case "//":
                        result = oldNumber / 100;
                        break;
                    /*case "+":
                        newNumber = Double.parseDouble(textView.getText().toString());
                        if (equal) {
                            result = oldNumber + newNumber;
                            textView.setText(result.toString());
                            equal = false;
                        } else if (isOperationClick == false) {
                            result = oldNumber + newNumber;
                            textView.setText(result.toString());
                        } else {
                            textView.getText();
                        }
                        isOperationClick = true;
                        break;
                    case "-":
                        newNumber = Double.parseDouble(textView.getText().toString());
                        if (equal) {
                            result = oldNumber - newNumber;
                            textView.setText(result.toString());
                            equal = false;
                        } else if (isOperationClick == false) {
                            result = oldNumber - newNumber;
                            textView.setText(result.toString());
                        } else {
                            textView.getText();
                        }
                        isOperationClick = true;
                        break;
                    case "*":
                        newNumber = Double.parseDouble(textView.getText().toString());
                        if (equal) {
                            result = oldNumber * newNumber;
                            textView.setText(result.toString());
                            equal = false;
                        } else if (isOperationClick == false) {
                            result = oldNumber * newNumber;
                            textView.setText(result.toString());
                        } else {
                            textView.getText();
                        }
                        isOperationClick = true;
                        break;
                    case "/":
                        newNumber = Double.parseDouble(textView.getText().toString());
                        if (equal) {
                            result = oldNumber / newNumber;
                            textView.setText(result.toString());
                            equal = false;
                        } else if (isOperationClick == false) {
                            result = oldNumber / newNumber;
                            textView.setText(result.toString());
                        } else {
                            textView.getText();
                        }

                        isOperationClick = true;
                        break;*/
                }
                textView.setText(new DecimalFormat("##.#######").format(result));
                isOperationClick = true;
                break;
        }
    }
}