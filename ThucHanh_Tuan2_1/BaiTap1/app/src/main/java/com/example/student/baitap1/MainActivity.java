package com.example.student.baitap1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText soa, sob;
    Button btntong, btnhieu, btntich, btnthuong, btnucln, btnthoat;

    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soa= findViewById(R.id.soa);
        sob = findViewById(R.id.sob);
        btntong = findViewById(R.id.tong);
        btnhieu = findViewById(R.id.hieu);
        btnthoat = findViewById(R.id.thoat);
        kq = findViewById(R.id.kq);


        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hsoa= Integer.parseInt(soa.getText().toString());
                int hsob= Integer.parseInt(sob.getText().toString());

                int tong = hsoa + hsob;
                kq.setText("Tong: " + tong);
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
