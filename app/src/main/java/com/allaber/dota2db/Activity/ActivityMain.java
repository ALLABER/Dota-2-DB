package com.allaber.dota2db.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import com.allaber.dota2db.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.flaviofaria.kenburnsview.Transition;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Button heros;
    Button items;
    Button about;
    Button directory;
    Intent intent;
    KenBurnsView kbv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heros = findViewById(R.id.btnHeros);
        items = findViewById(R.id.btnItems);
        about = findViewById(R.id.btnAbout);
        directory = findViewById(R.id.btnDirectory);
        heros.setOnClickListener(this);
        items.setOnClickListener(this);
        about.setOnClickListener(this);
        directory.setOnClickListener(this);
        kbv = findViewById(R.id.image);
        AccelerateDecelerateInterpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();
        RandomTransitionGenerator generator = new RandomTransitionGenerator(30000, ACCELERATE_DECELERATE);
        kbv.setTransitionGenerator(generator); //set new transition on kenburns view
        kbv.setTransitionListener(onTransittionListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHeros:
                intent = new Intent(this, ActivityAllHeros.class);
                startActivity(intent);
                break;
            case R.id.btnItems:
                intent = new Intent(this, ActivityAllItems.class);
                startActivity(intent);
                break;
            case R.id.btnAbout:
                intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.btnDirectory:
                intent = new Intent(this, ActivityDirectory.class);
                startActivity(intent);
                break;
        }
    }

    private KenBurnsView.TransitionListener onTransittionListener() {
        return new KenBurnsView.TransitionListener() {

            @Override
            public void onTransitionStart(Transition transition) {
                //Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                //Toast.makeText(MainActivity.this, "end", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        kbv.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        kbv.resume();
    }
}























