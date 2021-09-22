package com.geekym.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    ImageView bt_1,bt_2,bt_3,bt_4,bt_5,bt_6,bt_7,bt_8,bt_9,bt_0;
    ImageView bt_dot, bt_equal, bt_ac, bt_module, bt_plus, bt_minus, bt_multiply, bt_cancel,bt_divide;

    TextView inputTxt,outputTxt;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        inputTxt = findViewById(R.id.inputTxt);
        outputTxt = findViewById(R.id.outputTxt);

        bt_0 = findViewById(R.id.but_0);
        bt_1 = findViewById(R.id.but_1);
        bt_2 = findViewById(R.id.but_2);
        bt_3 = findViewById(R.id.but_3);
        bt_4 = findViewById(R.id.but_4);
        bt_5 = findViewById(R.id.but_5);
        bt_6 = findViewById(R.id.but_6);
        bt_7 = findViewById(R.id.but_7);
        bt_8 = findViewById(R.id.but_8);
        bt_9 = findViewById(R.id.but_9);

        bt_dot = findViewById(R.id.but_dot);
        bt_equal = findViewById(R.id.but_equal);
        bt_ac = findViewById(R.id.all_clear);
        bt_module = findViewById(R.id.but_mod);
        bt_plus = findViewById(R.id.but_plus);
        bt_minus = findViewById(R.id.but_minus);
        bt_multiply = findViewById(R.id.but_multiply);
        bt_cancel = findViewById(R.id.but_cancel);
        bt_divide = findViewById(R.id.but_div);

        bt_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "0");
            }
        });
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "1");
            }
        });
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "2");
            }
        });
        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "3");
            }
        });
        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "4");
            }
        });
        bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "5");
            }
        });
        bt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "6");
            }
        });
        bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "7");
            }
        });
        bt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "8");
            }
        });
        bt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "9");
            }
        });
        bt_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTxt.setText("");
                outputTxt.setText("");
            }
        });
        bt_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "+");
            }
        });
        bt_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + ".");
            }
        });
        bt_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "-");
            }
        });
        bt_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "%");
            }
        });
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                data = data.substring(0,data.length()-1);
                inputTxt.setText(data);
            }
        });
        bt_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "÷");
            }
        });
        bt_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "×");
            }
        });

        bt_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                String d = data;
                int last = data.length();

                data = data.replaceAll("×", "*");
                data = data.replaceAll("%", "/100");
                data = data.replaceAll("÷", "/");
                //for null value

                if (data.equals("") || data.equals(null)) {
                        return;
                    }
                if (!data.equals("") || !data.equals(null)) {
                    char[] charArray = d.toCharArray();
                    char last_data = charArray[last - 1];
                    if (last_data == '+' || last_data == '-' || last_data == '×' || last_data == '÷') {
                        return;
                    }
                    Context rihno = Context.enter();
                    rihno.setOptimizationLevel(-1);
                    String finalRes = "";
                    Scriptable scriptable = rihno.initStandardObjects();
                    finalRes = rihno.evaluateString(scriptable, data, "Javascript", 1, null).toString();
                    outputTxt.setText(finalRes); //final answer
                }
            }
        });
    }
}