package com.example.student.baitap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnC, btnF, btnCl;
    EditText edtnhapa, edtnhapb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnhapa= findViewById(R.id.nhapa);
        edtnhapb= findViewById(R.id.nhapb);
        btnC= findViewById(R.id.btn1);
        btnF= findViewById(R.id.btn2);


        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    float nhapa = Integer.parseInt(edtnhapa.getText().toString());

                    float kq = (nhapa-32)*(9/5);
                    edtnhapb.setText("" + kq);
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int nhapb = Integer.parseInt(edtnhapb.getText().toString());
                float kq= nhapb*(9/5)+32;
                edtnhapa.setText(""+kq);

            }
        });
    }
}
