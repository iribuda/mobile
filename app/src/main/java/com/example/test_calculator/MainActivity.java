package com.example.test_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button add ,mul ,div, sub, equal;
    TextView result;
    double answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        clickListener();
    }

    public void init(){
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        add = findViewById(R.id.sum);
        mul = findViewById(R.id.multiply);
        div = findViewById(R.id.divide);
        sub = findViewById(R.id.minus);
        equal = findViewById(R.id.equal);
        result = findViewById(R.id.result);
    }

    public void clickListener(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = number1.getText().toString();
                String num2 = number2.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter Numbers",Toast.LENGTH_SHORT).show();
                }
                else {
                    double a = Double.parseDouble(num1);
                    double b = Double.parseDouble(num2);
                    answer = a + b;
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = number1.getText().toString();
                String num2 = number2.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter Numbers",Toast.LENGTH_SHORT).show();
                }
                else {
                    double a = Double.parseDouble(num1);
                    double b = Double.parseDouble(num2);
                    answer = a * b;
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = number1.getText().toString();
                String num2 = number2.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter Numbers",Toast.LENGTH_SHORT).show();
                }
                else {
                    double a = Double.parseDouble(num1);
                    double b = Double.parseDouble(num2);
                    answer = a - b;
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = number1.getText().toString();
                String num2 = number2.getText().toString();
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter Numbers",Toast.LENGTH_SHORT).show();
                }
                else {
                    double a = Double.parseDouble(num1);
                    double b = Double.parseDouble(num2);
                    if (b != 0)
                        answer = a / b;
                    else
                        Toast.makeText(getApplicationContext(), "Enter Valid Numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(String.valueOf(answer));
                answer = 0;
            }
        });
    }



}