package com.example.student.baitap3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText duonglich;
    TextView amlich;
    Button chuyendoi;
    int can , chi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        duonglich = findViewById(R.id.edtdl);
        amlich = findViewById(R.id.tval);
        chuyendoi = findViewById(R.id.btncd);

        chuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String can[]={"Canh", "Tân","Nhâm", "Quý", "Giáp", "Ất", "Bính","Đinh","Mậu", "Kỉ"};
                String chi[]={"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn","Tỵ","Ngọ", "Mùi"};

                String dl = duonglich.getText().toString();
                int n = Integer.parseInt(dl);
                String kq= can[n%10] + " " + chi[n%12];
                amlich.setText(kq);

            }
        });



    }
}
