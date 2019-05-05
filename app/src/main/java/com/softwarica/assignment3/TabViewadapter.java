package com.softwarica.assignment3;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabViewadapter extends FragmentPagerAdapter {
    private List<Fragment> FragmentList=new ArrayList<>();
    private List<String>fragmenttitle=new ArrayList<>();

    public TabViewadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return FragmentList.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmenttitle.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        FragmentList.add(fragment);
        fragmenttitle.add(title);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }
}
