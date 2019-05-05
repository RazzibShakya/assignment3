package com.softwarica.assignment3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Additems extends AppCompatActivity implements View.OnClickListener {
    private EditText item_name,item_price,item_des,item_img;
    private Button btnsave,btnclear,btnBack;
    ActionBar action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additems);
        init();
        getSupportActionBar().hide();

    }

    public void init(){
        item_name=findViewById(R.id.itemname);
        item_price=findViewById(R.id.itemprice);
        item_des=findViewById(R.id.itemdescription);
        item_img=findViewById(R.id.nameimage);
        btnclear=findViewById(R.id.btnclear);
        btnsave=findViewById(R.id.btnsave);
        btnBack=findViewById(R.id.btnback);

        btnBack.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        btnclear.setOnClickListener(this);
    }

    public boolean writetext(EditText item_name, EditText item_price, EditText item_des, EditText item_img ){
        boolean write=false;
        String data = item_name.getText().toString() + "->" + item_price.getText().toString() + "->" + item_des.getText().toString() + "->" + item_img.getText().toString();
        try {
            PrintStream printstream=new PrintStream(openFileOutput("item1.txt",MODE_PRIVATE|MODE_APPEND));
            printstream.println(data);
            write=true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return write;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnclear:
                item_name.setText("");
                item_price.setText("");
                item_des.setText("");
                item_img.setText("");

                break;
            case R.id.btnsave:
                if(!TextUtils.isEmpty(item_name.getText().toString())|| !TextUtils.isEmpty(item_price.getText().toString())
                        || !TextUtils.isEmpty(item_des.getText().toString())|| !TextUtils.isEmpty(item_img.getText().toString())) {
                    if (writetext(item_name,item_price,item_des,item_img)==true ) {
                        Toast.makeText(this, "Saved to:" +getFilesDir()+ "/" + "item.txt", Toast.LENGTH_SHORT).show();
                        item_name.setText("");
                        item_price.setText("");
                        item_des.setText("");
                        item_img.setText("");

                    } else {
                        Toast.makeText(this, "Cannot Save", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this, "You have to fill all the forum first to save", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btnback:
                Intent intent=new Intent(Additems.this,Dashboard_activity.class);
                startActivity(intent);
                break;
        }
    }
}
