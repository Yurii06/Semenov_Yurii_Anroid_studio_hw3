package com.geektech.calculate;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first;
    private Integer second;
    private String onOperation = "";
    private Boolean isOperationClick;
    private Boolean isEqualDoubleClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_all_clear:
                allClear(view);
                break;
            case R.id.btn_zero:
                clickingOnNumbers(view);
                break;
            case R.id.btn_one:
                clickingOnNumbers(view);
                break;
            case R.id.btn_two:
                clickingOnNumbers(view);
                break;
            case R.id.btn_three:
                clickingOnNumbers(view);
                break;
            case R.id.btn_four:
                clickingOnNumbers(view);
                break;
            case R.id.btn_five:
                clickingOnNumbers(view);
                break;
            case R.id.btn_six:
                clickingOnNumbers(view);
                break;
            case R.id.btn_seven:
                clickingOnNumbers(view);
                break;
            case R.id.btn_eight:
                clickingOnNumbers(view);
                break;
            case R.id.btn_nine:
                clickingOnNumbers(view);
                break;

        }
        isOperationClick = false;
        isEqualDoubleClick = false;
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onOperationClick(View view) {
        Button button = findViewById(view.getId());
        switch (view.getId()){
            case R.id.btn_plus_minus:
                int checkNumbers = parseInt(textView.getText().toString());
                if(checkNumbers > 0){
                    textView.setText("-" + checkNumbers);
                }else {
                    textView.setText(Integer.toString(Math.abs(checkNumbers)));
                }
                break;
            case R.id.btn_division:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_multiplication:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_subtraction:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_addition:
                first = Integer.valueOf(textView.getText().toString());
                onOperation = button.getText().toString();
                isEqualDoubleClick = false;
                break;
            case R.id.btn_equal:
                calculate(onOperation);
                break;
        }
        isOperationClick = true;
    }

    @SuppressLint("SetTextI18n")
    private void calculate(String onOperation) {
        if (!isEqualDoubleClick){
            second = Integer.valueOf(textView.getText().toString());
        }else {
            first = Integer.valueOf(textView.getText().toString());
        }
        switch (onOperation){
            case "/":
                isEqualDoubleClick = true;
                int result = first / second;
                textView.setText(Integer.toString(result));
                break;
            case "x":
                isEqualDoubleClick = true;
                result = first * second;
                textView.setText(Integer.toString(result));
                break;
            case "-":
                isEqualDoubleClick = true;
                result = first - second;
                textView.setText(Integer.toString(result));
                break;
            case "+":
                isEqualDoubleClick = true;
                result = first + second;
                textView.setText(Integer.toString(result));
                break;
        }

    }
    public void allClear(View view){
        textView.setText("0");
        first = 0;
        second = 0;
    }

    public void clickingOnNumbers(View view){
        Button button = findViewById(view.getId());
        String buttonText = button.getText().toString();
        if (textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(buttonText);
        }else {
            textView.append(buttonText);
        }
    }

}