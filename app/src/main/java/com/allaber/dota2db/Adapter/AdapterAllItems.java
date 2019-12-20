package com.allaber.dota2db.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import com.allaber.dota2db.Activity.ActivityItem;
import com.allaber.dota2db.R;

public class AdapterAllItems extends RecyclerView.Adapter<AdapterAllItems.SimpleViewHolder> {


    private final Context mContext;
    private List<String> mData;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;

        public SimpleViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
        }
    }

    public AdapterAllItems(Context context, ArrayList<String> data) {
        mContext = context;
        if (data != null)
            mData = data;
        else mData = new ArrayList<>();
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        Picasso.get().load( mContext.getResources().getIdentifier(mData.get(position), "drawable", mContext.getPackageName())).placeholder(R.drawable.system_image_placeholder_item).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ActivityItem.class);
                intent.putExtra("item name", String.valueOf(mContext.getResources().getIdentifier(mData.get(position), "drawable", mContext.getPackageName())));
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}