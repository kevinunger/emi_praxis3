package com.example.paxis3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnQ = findViewById(R.id.buttonQuersumme);
        Button btnF = findViewById(R.id.buttonFib);

        btnQ.setOnClickListener(this);
        btnF.setOnClickListener(this);



    }
    @Override
    public void onClick(View v){

        switch(v.getId()) {

            case R.id.buttonQuersumme:

                EditText inputQ = findViewById(R.id.inputQuersumme);

                if ((inputQ.getText().toString()).equals("") ){
                    Toast.makeText(getApplicationContext(), "Bitte Zahl eingeben!", Toast.LENGTH_SHORT).show();
                }
                else {
                    long zahl = Long.parseLong(inputQ.getText().toString());
                    calculateDigitSum(zahl);
                }



            case R.id.buttonFib:
                calculateFibonacciRow();


        }



    }

    void calculateFibonacciRow(){


        int a,b,c;
        TextView tfFib = findViewById(R.id.ergebnisFib);
        String output = "";

        a = 0;
        b = 1;
        c = 0;

        output += "0" + "\n" + "1";

        for (int i = 0; i < 28; i++){

            c = a + b;
            a = b;
            b = c;

            output += '\n' + String.valueOf(c);

        }

        tfFib.setText(output);

        //0 1 1 2 3 5 8




    }

    void calculateDigitSum(long z ) {

        //Toast.makeText(this, "calc", Toast.LENGTH_LONG).show();
        TextView tvQ = findViewById(R.id.ErgebnisQuersumme);
        long quersumme = 0;

        while (z > 0) {
            quersumme = quersumme + z % 10;
            z = z / 10;
        }

        String output = String.valueOf(quersumme);
        tvQ.setText(output);


    }

}
