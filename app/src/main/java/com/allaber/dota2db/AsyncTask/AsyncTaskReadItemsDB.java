package com.allaber.dota2db.AsyncTask;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.allaber.dota2db.Adapter.AdapterItems;
import com.allaber.dota2db.Database.DatabaseHelper;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Static.GlobalStatic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AsyncTaskReadItemsDB extends AsyncTask<Void, Void,  ArrayList<HashMap<String, String>>> {
    private SQLiteDatabase mDb;
    private Context context;
    private View rootView;
    private String FromBD;
    private String WhereBD;
    private String LikeBD;
    private Integer NumColumns;
    private RecyclerView recyclerView;
    private AdapterItems adapterItems;

    @Override
    protected void onPreExecute() {
        context = GlobalStatic.getContext();
        LikeBD = GlobalStatic.getLikeBD();
        FromBD = GlobalStatic.getFromBD();
        WhereBD = GlobalStatic.getWhereBD();
        NumColumns = GlobalStatic.getNumColumns();
        rootView = GlobalStatic.getRootView();
        DatabaseHelper mDBHelper = new DatabaseHelper(context);
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

        super.onPreExecute();
    }

    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(Void... params) {
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        HashMap<String, String> hero;
        Cursor cursor = mDb.rawQuery("SELECT * FROM " + FromBD + " WHERE " + WhereBD + " Like" + "'" + LikeBD + "'" + "", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            hero = new HashMap<>();
            hero.put("image", String.valueOf(context.getResources().getIdentifier(cursor.getString(0), "drawable", context.getPackageName())));
            hero.put("name", cursor.getString(1));
            data.add(hero);
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    @Override
    protected void onPostExecute( ArrayList<HashMap<String, String>> result) {
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), NumColumns));
        recyclerView.setHasFixedSize(true);
        //recyclerView.setItemViewCacheSize(40);
        //recyclerView.setDrawingCacheEnabled(true);
        //recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        adapterItems = new AdapterItems(result);
        recyclerView.setAdapter(adapterItems);
        super.onPostExecute(result);
    }
}

























