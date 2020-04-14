package com.example.appmusiconline.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.appmusiconline.Adapter.MainViewPagerAdapter;
import com.example.appmusiconline.Fragment.Fragment_Tim_Kiem;
import com.example.appmusiconline.Fragment.Fragment_Trang_Chu;
import com.example.appmusiconline.R;


public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        anhxa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter( getSupportFragmentManager() );
        mainViewPagerAdapter.addFrangment( new Fragment_Trang_Chu(),"Trang Chu" );
        mainViewPagerAdapter.addFrangment( new Fragment_Tim_Kiem(),"Tim Kiem" );
        viewPager.setAdapter( mainViewPagerAdapter );
        tabLayout.setupWithViewPager( viewPager );
        tabLayout.getTabAt( 0 ).setIcon( R.drawable.icontrangchu );
        tabLayout.getTabAt( 1 ).setIcon( R.drawable.iconsearch );
    }

    private void anhxa() {
        tabLayout = findViewById( R.id.myTabLayout );
        viewPager = findViewById( R.id.myViewPager );
    }
}
