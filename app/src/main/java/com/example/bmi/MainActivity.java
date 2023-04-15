package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
//lets try this out.
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
public class MainActivity extends AppCompatActivity {
//     creating reference variables.

    EditText txtAge, txtWeight , txtHeight , result;
    Spinner spinner;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        lets fill up the variables with objects.

        txtAge = findViewById(R.id.txtAge);
        txtWeight = findViewById(R.id.txtWeight);
        txtHeight = findViewById(R.id.txtHeight);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);


//       setting the action listener

        button.setOnClickListener(new ShowResult());
    }
    //    making class.
    class ShowResult implements View.OnClickListener{

        @Override
        public void onClick(View view) {
//        converting values.
            int age = Integer.parseInt(txtAge.getText().toString());
            double weight = Double.parseDouble(txtWeight.getText().toString());
            double height = Double.parseDouble(txtHeight.getText().toString());
            String choice = spinner.getSelectedItem().toString();

            if(choice.equals("cm")){
                result.setText(Double.toString(calculateBmi(weight,cmToM(height))));
            }
            else if(choice.equals("feet")){
                result.setText(Double.toString(calculateBmi(weight,feetToM(height))));
            }
            else{
                result.setText(Double.toString(calculateBmi(weight,height)));
            }



            txtAge.setText("");
            txtWeight.setText("");
            txtHeight.setText("");
        }

        //        static methods for converting cm, feet to m;
        public double cmToM(double num){
            return num/100;
        }


        public double feetToM(double num){
            return num*0.3048;
        }

        public double calculateBmi(double weight , double height){
            return (weight/(height*height));
        }

    }
}