package com.allaber.dota2db.Activity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.allaber.dota2db.Adapter.AdapterAllItems;
import com.allaber.dota2db.Adapter.AdapterSectionedAllItems;
import com.allaber.dota2db.Database.DatabaseHelper;
import com.allaber.dota2db.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivityAllItems extends AppCompatActivity implements View.OnClickListener {

    RecyclerView mRecyclerView;
    AdapterAllItems mAdapter;
    private SQLiteDatabase mDb;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        ArrayList<String> data = new ArrayList<>();
        Cursor cursor = mDb.rawQuery("SELECT * FROM Items", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();

        //Your RecyclerView
        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        //mRecyclerView.setItemViewCacheSize(40);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 6));

        //Your RecyclerView.Adapter
        mAdapter = new AdapterAllItems(this, data);

        //This is the code to provide a sectioned grid
        List<AdapterSectionedAllItems.Section> sections = new ArrayList<AdapterSectionedAllItems.Section>();

        //Sections
        sections.add(new AdapterSectionedAllItems.Section(0, "Расходуемые", R.drawable.system_image_item_consumables));
        sections.add(new AdapterSectionedAllItems.Section(13, "Атрибуты", R.drawable.system_image_item_attributes));
        sections.add(new AdapterSectionedAllItems.Section(25, "Вооружение", R.drawable.system_image_item_armaments));
        sections.add(new AdapterSectionedAllItems.Section(39, "Мистика", R.drawable.system_image_item_arcane));
        sections.add(new AdapterSectionedAllItems.Section(54, "Общее", R.drawable.system_image_item_common));
        sections.add(new AdapterSectionedAllItems.Section(68, "Поддержка", R.drawable.system_image_item_support));
        sections.add(new AdapterSectionedAllItems.Section(82, "Магия", R.drawable.system_image_item_caster));
        sections.add(new AdapterSectionedAllItems.Section(97, "Броня", R.drawable.system_image_item_armor));
        sections.add(new AdapterSectionedAllItems.Section(112, "Оружие", R.drawable.system_image_item_weapons));
        sections.add(new AdapterSectionedAllItems.Section(127, "Артефакты", R.drawable.system_image_item_artifacts));
        sections.add(new AdapterSectionedAllItems.Section(142, "Потайные", R.drawable.system_image_item_secret));
        sections.add(new AdapterSectionedAllItems.Section(154, "Выпадают", R.drawable.system_image_item_roshan));

        //Add your adapter to the sectionAdapter
        AdapterSectionedAllItems.Section[] dummy = new AdapterSectionedAllItems.Section[sections.size()];
        AdapterSectionedAllItems mSectionedAdapter = new AdapterSectionedAllItems(this, R.layout.item_section, R.id.section_text, R.id.imageView, mRecyclerView, mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        mRecyclerView.setAdapter(mSectionedAdapter);
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