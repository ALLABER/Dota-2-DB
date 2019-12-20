package com.allaber.dota2db.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allaber.dota2db.AsyncTask.AsyncTaskReadItemsDB;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Static.GlobalStatic;

public class FragmentHeroAgility extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_all_items, container, false);
        SetText();
        return rootView;
    }

    public void SetText() {
        GlobalStatic.setContext(getActivity());
        GlobalStatic.setFromBD("Heros");
        GlobalStatic.setWhereBD("Attribute");
        GlobalStatic.setLikeBD("agility");
        GlobalStatic.setNumColumns(3);
        GlobalStatic.setRootView(rootView);
        AsyncTaskReadItemsDB aTaskReadItemsDB = new AsyncTaskReadItemsDB();
        aTaskReadItemsDB.execute();
    }
}





























