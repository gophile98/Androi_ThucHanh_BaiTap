package com.example.student.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActiviti extends AppCompatActivity {
    private EditText EdtName, EdtID, EdtAddress, EdtEmail;
    private Button BtnThoat, BtnSave, BtnSelect, BtnDelete, BtnUpdate;
    private GridView Gridview;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        dbHelper = new DBHelper(this);
        AnhXa();
        Them();
        Thoat();
        Xoa();
    }
    public void AnhXa(){
        EdtID = findViewById(R.id.edtid);
        EdtAddress = findViewById(R.id.edtaddress);
        EdtName = findViewById(R.id.edtname);
        EdtEmail = findViewById(R.id.edtemail);

        BtnSave =findViewById(R.id.btnsave);
        BtnSelect = findViewById(R.id.btnselect);
        BtnThoat = findViewById(R.id.btnthoat);
        BtnDelete = findViewById(R.id.btndelete);
        BtnUpdate = findViewById(R.id.btnupdate);



        Gridview = findViewById(R.id.griview);
    }
    public void Thoat(){
        BtnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void Them(){
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setId(Integer.parseInt(EdtID.getText().toString()));
                author.setAddress(EdtAddress.getText().toString());
                author.setEmail(EdtEmail.getText().toString());
                author.setName(EdtName.getText().toString());

                if (dbHelper.insertAuthor(author)>0){
                    Toast.makeText(AuthorActiviti.this, "Luu thanh cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AuthorActiviti.this, "Luu khong thanh cong", Toast.LENGTH_SHORT).show();
                    EdtID.setText("");
                    EdtName.setText("");
                    EdtAddress.setText("");
                    EdtEmail.setText("");
                }
            }
        });
    }
    public void Chon(){
        BtnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> listAuthor = new ArrayList<>();
                ArrayList<String> listString = new ArrayList<>();
                if (EdtID.getText().toString().equals("")){
                    listAuthor = dbHelper.getAllAuthor();
                }else{
                    listAuthor = dbHelper.getIdAuthor(Integer.parseInt(EdtID.getText().toString()));
                }
                if (listAuthor.size() > 0){
                    for (Author author : listAuthor){
                        listString.add(author.getId()+"");
                        listString.add(author.getName());
                        listString.add(author.getAddress());
                        listString.add(author.getEmail());


                    }
                    ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(AuthorActiviti.this, android.R.layout.simple_list_item_1, listString);
                    Gridview.setAdapter(arrayAdapter);

                }else{
                    Toast.makeText(AuthorActiviti.this, "Co so du lieu rong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void Xoa(){
        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(EdtID.getText().toString());
                if (dbHelper.deleteAuthor(id)){
                    Toast.makeText(AuthorActiviti.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(AuthorActiviti.this, "Xoa khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
