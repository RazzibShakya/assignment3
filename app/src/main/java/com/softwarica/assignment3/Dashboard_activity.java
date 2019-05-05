package com.softwarica.assignment3;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dashboard_activity extends AppCompatActivity implements View.OnClickListener {
    ActionBar action;
    RecyclerView rv;
    Button btnAdd;
    List<Items> Clothelist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activity);
        rv = findViewById(R.id.recyler);
        getSupportActionBar().hide();
        prepareClothes();
        rv.setLayoutManager(new GridLayoutManager(this,3));
        rv.setAdapter(new ItemRecyclerAdapter(Clothelist, this));
        btnAdd=findViewById(R.id.btnadditem);
        btnAdd.setOnClickListener(this);

    }

    public void prepareClothes() {
        try {
            String data;
            FileInputStream fis = openFileInput("item1.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while ((data = br.readLine()) != null) {
                String[] data1 = data.split("->");
                int id=getResources().getIdentifier(data1[3], "drawable", getPackageName());
                Clothelist.add(new Items(data1[0], data1[1], data1[2],id) );
                Log.e("result:",data1[1]);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnadditem:
                Intent intent=new Intent(this,Additems.class);
                startActivity(intent);

                break;
        }
    }
}
