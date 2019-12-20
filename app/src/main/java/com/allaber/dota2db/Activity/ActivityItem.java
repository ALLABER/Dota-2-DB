package com.allaber.dota2db.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.allaber.dota2db.AsyncTask.AsyncTaskItem;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Static.GlobalStatic;

public class ActivityItem extends AppCompatActivity implements View.OnClickListener {
    ImageView back;
    String itemID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Intent intent = getIntent();
        itemID = getResources().getResourceEntryName(Integer.valueOf(intent.getStringExtra("item name")));
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
        View rootView = getWindow().getDecorView().getRootView();
        GlobalStatic.setRootView(rootView);
        GlobalStatic.setContext(this);
        GlobalStatic.setId(itemID);
        AsyncTaskItem aTaskItem = new AsyncTaskItem();
        aTaskItem.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
