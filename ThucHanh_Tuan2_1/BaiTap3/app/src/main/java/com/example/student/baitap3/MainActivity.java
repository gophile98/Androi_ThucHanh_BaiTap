package com.example.student.baitap3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    TextView tv1;
    Button btn1;
    int can , chi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        tv1 = findViewById(R.id.tv2);
        btn1 = findViewById(R.id.btncd);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int edt= Integer.parseInt(edt1.getText()+"");
                if (edt>=1990){
                    can =edt%10;
                  switch (can){
                      case 0:
                          System.out.println("Canh");
                          break;
                      case 3:
                          System.out.println("Quy");
                  };
                  chi = edt%12;
                  switch (chi){
                      case 0:
                          System.out.println("Than");
                          break;

                      case 9:
                          System.out.println("Ty");

                  }
                    System.out.println(can+chi);
                }



                else {
                    
                }
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(btn1);

            }
        });

    }
}
