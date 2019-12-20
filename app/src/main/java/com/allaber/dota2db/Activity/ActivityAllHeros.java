package com.allaber.dota2db.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListPopupWindow;

import com.allaber.dota2db.Fragment.FragmentHeroAgility;
import com.allaber.dota2db.Fragment.FragmentHeroIntellect;
import com.allaber.dota2db.Fragment.FragmentHeroStrength;
import com.allaber.dota2db.R;

public class ActivityAllHeros extends AppCompatActivity implements View.OnClickListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    FragmentHeroStrength heroStrength;
    FragmentHeroAgility heroAgility;
    FragmentHeroIntellect heroIntellect;

    ImageView filter;
    ImageView back;

    //private ListPopupWindow mListPopupWindow;
    //String[] cats = {"Алфавиту", "Атрибутам", "Сложности", "Свой фильтр"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heros);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        //mViewPager.setOffscreenPageLimit(3);
        filter = findViewById(R.id.filter);
        filter.setOnClickListener(this);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);


//        mListPopupWindow = new ListPopupWindow(this);
//        mListPopupWindow.setAnchorView(filter);
//        mListPopupWindow.setWidth(500);
//        mListPopupWindow.setHeight(600);
//        mListPopupWindow.setAdapter(new ArrayAdapter(getBaseContext(), R.layout.item_pupwindow, cats));
//        mListPopupWindow.setModal(true);
//        mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mListPopupWindow.dismiss();
//            }
//        });

        heroStrength = new FragmentHeroStrength();
        heroAgility = new FragmentHeroAgility();
        heroIntellect = new FragmentHeroIntellect();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.filter:
                //mListPopupWindow.show();
                break;
            case R.id.back:
                finish();
                break;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return heroStrength;
                case 1:
                    return heroAgility;
                case 2:
                    return heroIntellect;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
