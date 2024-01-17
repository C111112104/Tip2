package com.example.tip2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText amount_editText;
    EditText custom_editText;
    Button tip_button;
    Button total_button;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount_editText = (EditText) findViewById(R.id.amount_editText);
        custom_editText  = (EditText) findViewById(R.id.custom_editText);
        tip_button= (Button) findViewById(R.id.tip_button);
        total_button= (Button) findViewById(R.id.total_button);

        ButtonHandler handler = new ButtonHandler();
        tip_button.setOnClickListener(handler);
        total_button.setOnClickListener(handler);

        builder = new AlertDialog.Builder(MainActivity.this);
    }
    public class ButtonHandler implements View.OnClickListener{
        public void onClick(View view){

            try{
                double amount = Double.parseDouble(amount_editText.getText().toString());
                double  custom = Double.parseDouble(custom_editText.getText().toString());1
                if(custom>30 || custom<0){
                    Toast toast = Toast.makeText(MainActivity.this ,    "custom的範圍 : 0~30", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(view == tip_button){
                    double tip = amount*custom /100;
                    builder.setTitle("Tip");
                    builder.setMessage(String.format("%.2f",tip));
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(view == total_button){
                    double total = amount*(custom /100 + 1.0);
                    builder.setTitle("Total");
                    builder.setMessage(String.format("%.2f",total));
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


            }catch (NumberFormatException e){
                Toast toast = Toast.makeText(MainActivity.this ,  "Tip 和 Custom不能為空白", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }







}