package com.allaber.dota2db.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.allaber.dota2db.Activity.ActivityHero;
import com.allaber.dota2db.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.HashMap;

public class AdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ImageView img;
    private TextView name;
    ArrayList<HashMap<String, String>> mList;
    private int mPos;
    HashMap<String, String> hero;

    public AdapterHolder(LayoutInflater myInflater, ViewGroup parent, int layout){
        super(myInflater.inflate(layout, parent, false));
        img = itemView.findViewById(R.id.imageHero);
        name = itemView.findViewById(R.id.textHero);
        itemView.setOnClickListener(this);

    }

    public void bind( ArrayList<HashMap<String, String>> list, int pos){
        mPos = pos;
        mList = list;
        hero = mList.get(pos);
        Picasso.get().load(Integer.valueOf(hero.get("image"))).placeholder(R.drawable.system_image_placeholder_hero).into(img);
        name.setText(hero.get("name"));
    }

    @Override
    public void onClick(View v) {
            Intent intent = new Intent(itemView.getContext(), ActivityHero.class);
            intent.putExtra("hero name", String.valueOf(Integer.valueOf(hero.get("image"))));
            itemView.getContext().startActivity(intent);
    }
}




















