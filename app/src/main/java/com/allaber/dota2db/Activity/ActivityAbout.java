package com.allaber.dota2db.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.allaber.dota2db.R;

public class ActivityAbout extends AppCompatActivity implements View.OnClickListener {

    ImageView imageViewVK;
    ImageView imageViewStar;
    ImageView imageViewEmail;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        imageViewVK = findViewById(R.id.imageViewVK);
        imageViewVK.setOnClickListener(this);

        imageViewStar = findViewById(R.id.imageViewStar);
        imageViewStar.setOnClickListener(this);

        imageViewEmail = findViewById(R.id.imageViewEmail);
        imageViewEmail.setOnClickListener(this);

        back = findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent openLinkIntent;
        Uri address;
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.imageViewVK:
                address = Uri.parse("https://vk.com/dota2dbinfo");
                openLinkIntent = new Intent(Intent.ACTION_VIEW, address);

                if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(openLinkIntent);
                } else {
                    Log.d("Intent", "Не получается обработать намерение!");
                }
                break;
            case R.id.imageViewStar:
                address = Uri.parse("https://play.google.com/store/apps/details?id=allaber.com.myapplication");
                openLinkIntent = new Intent(Intent.ACTION_VIEW, address);

                if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(openLinkIntent);
                } else {
                    Log.d("Intent", "Не получается обработать намерение!");
                }
                break;
            case R.id.imageViewEmail:
                address = Uri.parse("https://vk.com/topic-183195772_39809807");
                openLinkIntent = new Intent(Intent.ACTION_VIEW, address);

                if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(openLinkIntent);
                } else {
                    Log.d("Intent", "Не получается обработать намерение!");
                }
                break;
        }
    }
}
