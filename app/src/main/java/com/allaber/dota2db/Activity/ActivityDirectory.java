package com.allaber.dota2db.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.allaber.dota2db.R;

public class ActivityDirectory extends AppCompatActivity implements View.OnClickListener{
    ImageView back;


    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        String[] itemsDirectory = getResources().getStringArray(R.array.items_directory);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        ListView listView = findViewById(R.id.list);
        mAdapter = new ArrayAdapter<>(this, R.layout.item_directory, itemsDirectory);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Обновление");
                        intent.putExtra("webViewDirectory", "update");
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Режим игры");
                        intent.putExtra("webViewDirectory", "game_mode");
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Роли героев");
                        intent.putExtra("webViewDirectory", "hero_roles");
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Словарь");
                        intent.putExtra("webViewDirectory", "dictionary");
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Вардинг");
                        intent.putExtra("webViewDirectory", "warding");
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Консольные команды");
                        intent.putExtra("webViewDirectory", "console_commands");
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Советы");
                        intent.putExtra("webViewDirectory", "tips");
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Крипы");
                        intent.putExtra("webViewDirectory", "creeps");
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Нейтральные крипы");
                        intent.putExtra("webViewDirectory", "neutral_creeps");
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Рошан");
                        intent.putExtra("webViewDirectory", "roshan");
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Руны");
                        intent.putExtra("webViewDirectory", "runes");
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(ActivityDirectory.this, ActivityDirectoryItem.class);
                        intent.putExtra("textViewDirectory", "Механика");
                        intent.putExtra("webViewDirectory", "mechanics");
                        startActivity(intent);
                        break;
                }
            }
        });
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
