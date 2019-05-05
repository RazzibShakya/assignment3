package com.softwarica.assignment3;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewpager;
    private TabLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
        settingadapter();


    }

    public void init(){
        tab=findViewById(R.id.tabid);
        viewpager=findViewById(R.id.view_pager);
    }

    public void settingadapter(){
        TabViewadapter adapter=new TabViewadapter(getSupportFragmentManager());
        adapter.addFragment(new Login(),"Login");
        adapter.addFragment(new Register(),"Register");
        viewpager.setAdapter(adapter);
        tab.setupWithViewPager(viewpager);
    }
}
