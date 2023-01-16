package com.example.unitconverter;

import java.io.*;
import java.lang.*;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    String selected1;
    String selected2;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button convbtn = (Button) findViewById(R.id.button);
        final Spinner fromUnit = (Spinner) findViewById(R.id.spinner);
        Spinner toUnit = (Spinner) findViewById(R.id.spinner2);
        EditText unitNum = (EditText) findViewById(R.id.numtoConv);
        TextView convertedNum = (TextView) findViewById(R.id.convNum);
        /*history.setImageDrawable(Drawable.createFromPath("/home/abdallah/Downloads/history.png"));*/


        fromUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ( !fromUnit.getSelectedItem().toString().equals(""))
                    selected1 = fromUnit.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        }
        );

        toUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ( !toUnit.getSelectedItem().toString().equals(""))
                    selected2 = toUnit.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        convbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( unitNum.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter Valid Number" , Toast.LENGTH_LONG).show();
                }
                if ( !unitNum.getText().toString().equals("")){
                    if ( selected1.equals("Kilometer")){
                        //3ayz asheel el kilometre men el spinner el tanya
                        switch(selected2){
                            case "Meter":
                                double x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                double result = x*1000;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Centimeter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*100000;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Millimetre":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*1000000;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Mile":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/1.609;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Yard":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*1094;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Foot":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*3281;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Inch":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*39370;
                                convertedNum.setText(String.valueOf(result));
                                break;
                        }
                    }
                    else if (selected1.equals("Meter")){
                        switch(selected2){
                            case "Kilometer":
                                double x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                double result = x/1000;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Centimeter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*100;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Millimetre":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*1000;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Mile":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/1609;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Yard":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*1.094;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Foot":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*3.281;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Inch":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*39.37;
                                convertedNum.setText(String.valueOf(result));
                                break;
                        }
                    }
                    else if (selected1.equals("Centimeter")){
                        switch(selected2){
                            case "Kilometer":
                                double x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                double result = x/100000;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Meter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/100;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Millimetre":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/10;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Mile":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/160900;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Yard":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/91.44;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Foot":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/30.48;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Inch":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/2.54;
                                convertedNum.setText(String.valueOf(result));
                                break;
                        }
                    }
                    else if (selected1.equals("Millimetre")){
                        switch(selected2){
                            case "Kilometer":
                                double x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                double result = x/0.000001;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Meter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/1000;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Centimeter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/10;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Mile":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/1.609;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Yard":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/914.4;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Foot":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/304.8;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Inch":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/25.4;
                                convertedNum.setText(String.valueOf(result));
                                break;
                        }
                    }
                    else if (selected1.equals("Mile")){
                        switch(selected2){
                            case "Kilometer":
                                double x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                double result = x*1.609;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Meter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*1609;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Centimeter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*160900;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Millimetre":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*1.609;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Yard":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*1760;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Foot":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*5280;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Inch":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*63360;
                                convertedNum.setText(String.valueOf(result));
                                break;
                        }
                    }
                    else if (selected1.equals("Yard")){
                        switch(selected2){
                            case "Kilometer":
                                double x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                double result = x/1094;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Meter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/1.094;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Centimeter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*91.44;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Millimetre":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*914.4;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Mile":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/1760;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Foot":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*3;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Inch":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*36;
                                convertedNum.setText(String.valueOf(result));
                                break;
                        }
                    }
                    else if (selected1.equals("Foot")){
                        switch(selected2){
                            case "Kilometer":
                                double x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                double result = x/3281;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Meter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/3.281;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Centimeter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*30.48;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Millimetre":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*304.8;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Mile":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/5280;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Yard":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/3;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Inch":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*12;
                                convertedNum.setText(String.valueOf(result));
                                break;
                        }
                    }
                    else if (selected1.equals("Inch")){
                        switch(selected2){
                            case "Kilometer":
                                double x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                double result = x/39370;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Meter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/39.37;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Centimeter":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*2.54;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Millimetre":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x*25.4;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Mile":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/63360;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Yard":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/36;
                                convertedNum.setText(String.valueOf(result));
                                break;
                            case "Foot":
                                x = Double.parseDouble(String.valueOf(unitNum.getText()));
                                result = x/12;
                                convertedNum.setText(String.valueOf(result));
                                break;
                        }
                    }
                }
            }
        });
    }

}




