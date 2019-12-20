package com.allaber.dota2db.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.allaber.dota2db.R;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterItems extends RecyclerView.Adapter<AdapterHolder> {

    private  ArrayList<HashMap<String, String>> mList;

    public AdapterItems( ArrayList<HashMap<String, String>> list) {
        mList = list;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new AdapterHolder(layoutInflater, viewGroup, R.layout.item_hero);
    }

    @Override
    public void onBindViewHolder(AdapterHolder imageAdaHolder, int i) {
        imageAdaHolder.bind(mList, i);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}