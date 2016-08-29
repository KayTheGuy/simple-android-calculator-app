package com.example.kayhan.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    double memory = 0;
    int lastOperation = -1;
    boolean operationWaiting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView btnNum0 = (TextView) findViewById(R.id.tv_0);
        TextView btnNum1 = (TextView) findViewById(R.id.tv_1);
        TextView btnNum2 = (TextView) findViewById(R.id.tv_2);
        TextView btnNum3 = (TextView) findViewById(R.id.tv_3);
        TextView btnNum4 = (TextView) findViewById(R.id.tv_4);
        TextView btnNum5 = (TextView) findViewById(R.id.tv_5);
        TextView btnNum6 = (TextView) findViewById(R.id.tv_6);
        TextView btnNum7 = (TextView) findViewById(R.id.tv_7);
        TextView btnNum8 = (TextView) findViewById(R.id.tv_8);
        TextView btnNum9 = (TextView) findViewById(R.id.tv_9);
        TextView btnDot = (TextView) findViewById(R.id.tv__);

        TextView btnOpAdd = (TextView) findViewById(R.id.tv_add);
        TextView btnOpSub = (TextView) findViewById(R.id.tv_sub);
        TextView btnOpMult = (TextView) findViewById(R.id.tv_mult);
        TextView btnOpDiv = (TextView) findViewById(R.id.tv_div);
        TextView btnOpPower = (TextView) findViewById(R.id.tv_pow);
        TextView btnOpEqual = (TextView) findViewById(R.id.tv_equal);
        TextView btnOpModul = (TextView) findViewById(R.id.tv_module);

        TextView btnCE = (TextView) findViewById(R.id.tv_CE);
        TextView btnDEL = (TextView) findViewById(R.id.tv_DEL);

        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnDot.setOnClickListener(this);

        btnOpAdd.setOnClickListener(this);
        btnOpSub.setOnClickListener(this);
        btnOpMult.setOnClickListener(this);
        btnOpDiv.setOnClickListener(this);
        btnOpPower.setOnClickListener(this);
        btnOpModul.setOnClickListener(this);
        btnOpEqual.setOnClickListener(this);

        btnCE.setOnClickListener(this);
        btnDEL.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, AboutActivity.class);
            String message = "just for test";
            intent.putExtra("intro", message);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String currentInput = "";
        double calResult;
        TextView result = (TextView) findViewById(R.id.result);
        currentInput = result.getText().toString();

        switch (v.getId()) {
            case R.id.tv_CE:
                result.setText("");
                memory = 0;
                operationWaiting = false;
                break;
            case R.id.tv_DEL:
                int len = currentInput.length();
                if (len > 0) {
                    result.setText(currentInput.substring(0, currentInput.length() - 1));
                }
                break;
            case R.id.tv_add:
                if (operationWaiting) {//nothing to add
                    Snackbar.make(v, "Error: After each calculation hit equal before proceeding!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
                try {
                    memory = Double.parseDouble(currentInput);
                    operationWaiting = true;
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                }
                result.setText("");
                lastOperation = R.id.tv_add;
                break;
            case R.id.tv_mult:
                if (operationWaiting) {//nothing to multiply
                    Snackbar.make(v, "Error: After each calculation hit equal before proceeding!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
                try {
                    memory = Double.parseDouble(currentInput);
                    operationWaiting = true;
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                }
                result.setText("");
                lastOperation = R.id.tv_mult;
                break;
            case R.id.tv_div:
                if (operationWaiting) {//nothing to divid
                    Snackbar.make(v, "Error: After each calculation hit equal before proceeding!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
                try {
                    memory = Double.parseDouble(currentInput);
                    operationWaiting = true;
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                }
                result.setText("");
                lastOperation = R.id.tv_div;
                break;
            case R.id.tv_pow:
                if (operationWaiting) {
                    Snackbar.make(v, "Error: After each calculation hit equal before proceeding!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
                try {
                    memory = Double.parseDouble(currentInput);
                    operationWaiting = true;
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                }
                result.setText("");
                lastOperation = R.id.tv_pow;
                break;
            case R.id.tv_module:
                if (operationWaiting) {
                    Snackbar.make(v, "Error: After each calculation hit equal before proceeding!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
                try {
                    memory = Double.parseDouble(currentInput);
                    operationWaiting = true;
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                }
                result.setText("");
                lastOperation = R.id.tv_module;
                break;
            case R.id.tv_equal:
                switch (lastOperation) {
                    case R.id.tv_add:
                        try {
                            double temp = Double.parseDouble(currentInput);
                            calResult = memory + temp;
                            result.setText(Double.toString(calResult));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                        }
                        lastOperation = R.id.tv_equal;
                        operationWaiting = false;
                        break;
                    case R.id.tv_sub:
                        try {
                            double temp = Double.parseDouble(currentInput);
                            calResult = memory - temp;
                            result.setText(Double.toString(calResult));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                        }
                        lastOperation = R.id.tv_equal;
                        operationWaiting = false;
                        break;
                    case R.id.tv_mult:
                        try {
                            double temp = Double.parseDouble(currentInput);
                            calResult = memory * temp;
                            result.setText(Double.toString(calResult));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                        }
                        lastOperation = R.id.tv_equal;
                        operationWaiting = false;
                        break;
                    case R.id.tv_div:
                        try {
                            double temp = Double.parseDouble(currentInput);
                            if (temp == 0) {
                                result.setText("");
                                memory = 0;
                                operationWaiting = false;
                                lastOperation = -1;
                                Toast.makeText(this, "Error: Division by 0 is invalid!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            calResult = memory / temp;
                            result.setText(Double.toString(calResult));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                        }
                        lastOperation = R.id.tv_equal;
                        operationWaiting = false;
                        break;
                    case R.id.tv_pow:
                        try {
                            double temp = Double.parseDouble(currentInput);
                            calResult = Math.pow(memory, temp);
                            result.setText(Double.toString(calResult));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                        }
                        lastOperation = R.id.tv_equal;
                        operationWaiting = false;
                        break;
                    case R.id.tv_module:
                        try {
                            double temp = Double.parseDouble(currentInput);
                            calResult = memory % temp;
                            result.setText(Double.toString(calResult));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                        }
                        lastOperation = R.id.tv_equal;
                        operationWaiting = false;
                        break;
                }
                break;
            case R.id.tv_sub:
                if (!currentInput.isEmpty()) {
                    if (operationWaiting) {//nothing to subtract
                        Snackbar.make(v, "Error: After each calculation hit equal before proceeding!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        return;
                    }
                    try {
                        memory = Double.parseDouble(currentInput);
                        operationWaiting = true;
                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Error: Invalid Operation!", Toast.LENGTH_SHORT).show();
                    }
                    result.setText("");
                    lastOperation = R.id.tv_sub;
                    break;
                }
            default:
                if (v.getId() == R.id.tv__ && currentInput.contains(".")) {
                    Toast.makeText(this, "Format Error: More than one decimal point in the input!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (lastOperation == R.id.tv_equal) {
                    currentInput = "";
                    lastOperation = -1;
                    operationWaiting = false;
                }

                //append numbers
                currentInput += ((TextView) v).getText().toString();

                if (currentInput.length() > 44) {
                    result.setText(currentInput.substring(1)); // too large for screen
                } else {
                    result.setText(currentInput);
                }
                break;
        }
    }
}
