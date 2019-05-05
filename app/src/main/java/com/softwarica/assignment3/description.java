package com.softwarica.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class description extends AppCompatActivity {
TextView name,price,des;
ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        initiate();
    }

    public void initiate(){
        name=findViewById(R.id.txtitemName);
        price=findViewById(R.id.txtitemprice);
        des=findViewById(R.id.txtitemdesc);
        img1=findViewById(R.id.imgdisplay);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            img1.setImageResource(bundle.getInt("Item_Picture"));
            name.setText(bundle.getString("Item_Name"));
            price.setText(bundle.getString("Item_Price"));
            des.setText(bundle.getString("Item_Description"));

        }
    }
}
