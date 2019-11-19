package com.example.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmi.Layout_BMI.BMI_Normal;
import com.example.bmi.Layout_BMI.BMI_Obese1;
import com.example.bmi.Layout_BMI.BMI_Obese2;
import com.example.bmi.Layout_BMI.BMI_Overweight;
import com.example.bmi.Layout_BMI.BMI_Underweight;
import com.example.bmi.model.Body;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Button calculateButton = findViewById(R.id.calculator_button);
        calculateButton.setOnClickListener(new View.OnClickListener() { //
            @Override
            public void onClick(View view) {
                EditText heightEditText = findViewById(R.id.height_edit_text);
                EditText weightEditText = findViewById(R.id.weight_edit_text);

                int h = Integer.parseInt(heightEditText.getText().toString());
                int w = Integer.parseInt(weightEditText.getText().toString());
                Body body = new Body(h,w);

                float bmi = body.calculateBmi();

                /*String show_bmi = "ค่า BMI ของคุณ = "+bmi;
                String msg = "เกณฑ์น้ำหนักของคุณ: "+body.getResultText();

                Toast t =Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
                t.show();
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Result");
                dialog.setTitle(show_bmi);
                dialog.setMessage(msg);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.setNegativeButton("No",null);
                dialog.setCancelable(false);
                dialog.show();
                */
                if(bmi < 18.5){
                    Intent i = new Intent(MainActivity.this, BMI_Underweight.class);
                    startActivity(i);
                }else if(bmi >= 18.5 && bmi <= 22.9){
                    Intent i = new Intent(MainActivity.this, BMI_Normal.class);
                    startActivity(i);
                }else if(bmi >= 23 && bmi <= 24.9){
                    Intent i = new Intent(MainActivity.this, BMI_Overweight.class);
                    startActivity(i);
                }else if(bmi >= 25 && bmi <= 29.9){
                    Intent i = new Intent(MainActivity.this, BMI_Obese1.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(MainActivity.this, BMI_Obese2.class);
                    startActivity(i);
                }

            }
        });
    }
}
