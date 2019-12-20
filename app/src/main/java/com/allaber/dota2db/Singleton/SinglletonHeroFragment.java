package com.allaber.dota2db.Singleton;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.allaber.dota2db.R;

public abstract class SinglletonHeroFragment extends AppCompatActivity {

    protected abstract Fragment creatFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);
        if(fragment == null){
            fragment = creatFragment();
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }
}
