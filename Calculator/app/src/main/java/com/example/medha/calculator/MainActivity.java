package com.example.medha.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Scr;
    private float NumberBf;
    private String Operation;
    private ButtonClickListener btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scr = (EditText) findViewById(R.id.editText);
        btnClick = new ButtonClickListener();
        int idList[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.buttondot, R.id.buttonadd, R.id.buttonsub, R.id.buttonmul, R.id.buttondiv, R.id.buttoneq, R.id.buttonc};
        for (int id : idList) {
            View v = (View) findViewById(id);
            v.setOnClickListener(btnClick);
        }
    }

    public void addOperator(String str) {
        NumberBf = Float.parseFloat(Scr.getText().toString());
        Operation = str;
        Scr.setText("");
    }

    public void getKeyBoard(String str) {
        String curr = Scr.getText().toString();
        curr = curr + str;
        Scr.setText(curr);
    }

    public void getResult() {
        float NumberAf = Float.parseFloat(Scr.getText().toString());
        float result = 0;
        if (Operation == "+") {
            result = NumberBf + NumberAf;

        }
        if (Operation == "-") {
            result = NumberBf - NumberAf;

        }
        if (Operation == "*") {
            result = NumberBf * NumberAf;

        }
        if (Operation == "/") {
            result = NumberBf / NumberAf;

        }
        Scr.setText(String.valueOf(result));
    }

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonc:
                    Scr.setText("");
                    NumberBf = 0;
                    Operation = "";
                    break;
                case R.id.buttonadd:
                    addOperator("+");
                    break;
                case R.id.buttonsub:
                    addOperator("-");
                    break;
                case R.id.buttonmul:
                    addOperator("*");
                    break;
                case R.id.buttondiv:
                    addOperator("/");
                    break;
                case R.id.buttoneq:
                    getResult();
                    break;
                default:
                    String numb = ((Button) v).getText().toString();
                    getKeyBoard(numb);
                    break;
            }
        }
    }
}
