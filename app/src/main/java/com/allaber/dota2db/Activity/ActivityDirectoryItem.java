package com.allaber.dota2db.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.allaber.dota2db.R;

public class ActivityDirectoryItem extends AppCompatActivity implements View.OnClickListener{
    ImageView back;
    TextView text;
    WebView webViewDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory_item);
        webViewDirectory = findViewById(R.id.webViewDirectory);
        text = findViewById(R.id.textViewDirectory);
        String textDirTop = getIntent().getExtras().getString("textViewDirectory");
        String htmlDir = getIntent().getExtras().getString("webViewDirectory");
        text.setText(textDirTop);
        webViewDirectory.setBackgroundColor(Color.parseColor("#0e171e"));
        webViewDirectory.loadUrl("file:///android_asset/html/" + htmlDir + ".html");
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
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
