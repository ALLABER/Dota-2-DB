package com.allaber.dota2db.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.allaber.dota2db.Adapter.AdapterAllItems;
import com.allaber.dota2db.Adapter.AdapterSectionedAllItems;
import com.allaber.dota2db.Item.Hero;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Singleton.SingletonHero;
import java.util.ArrayList;
import java.util.List;

public class FragmentHeroBuy extends Fragment {

    RecyclerView mRecyclerView;
    AdapterAllItems mAdapter;
    ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_buy, container, false);

        SingletonHero.get(getContext());
        Hero hero = SingletonHero.getHero();

        ArrayList<String> data = new ArrayList<>();
        String stringBuyItems = hero.getTextBuyItemsText();
        String[] stringBuyItem;
        stringBuyItem = stringBuyItems.split("-");
        for(int i = 0; i < stringBuyItem.length; i++) {
            data.add(stringBuyItem[i]);
        }



        //Your RecyclerView
        mRecyclerView = rootView.findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 6));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));

        //Your RecyclerView.Adapter
        mAdapter = new AdapterAllItems(getContext(), data);

        //This is the code to provide a sectioned grid
        List<AdapterSectionedAllItems.Section> sections = new ArrayList<AdapterSectionedAllItems.Section>();

        //Sections
        sections.add(new AdapterSectionedAllItems.Section(0, "НАЧАЛЬНЫЕ ПРЕДМЕТЫ", 0));
        sections.add(new AdapterSectionedAllItems.Section(hero.getColEarlyGame(), "РАННЯЯ ИГРА", 0));
        sections.add(new AdapterSectionedAllItems.Section(hero.getColMidGame(), "СЕРЕДИНА ИГРЫ", 0));
        sections.add(new AdapterSectionedAllItems.Section(hero.getColLateGame(), "ПОЗДНЯЯ ИГРА", 0));
        if(hero.getColDependsOnSituation() != 0) {
            sections.add(new AdapterSectionedAllItems.Section(hero.getColDependsOnSituation(), "ПО СИТУАЦИИ", 0));
        }
        if(hero.getColPopularItems() != 0) {
            sections.add(new AdapterSectionedAllItems.Section(hero.getColPopularItems(), "ПОПУЛЯРНЫЕ ПРЕДМЕТЫ", 0));
        }
        //Add your adapter to the sectionAdapter
        AdapterSectionedAllItems.Section[] dummy = new AdapterSectionedAllItems.Section[sections.size()];
        AdapterSectionedAllItems mSectionedAdapter = new AdapterSectionedAllItems(getContext(), R.layout.item_section, R.id.section_text, R.id.imageView, mRecyclerView, mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        mRecyclerView.setAdapter(mSectionedAdapter);
        return rootView;
    }


}
