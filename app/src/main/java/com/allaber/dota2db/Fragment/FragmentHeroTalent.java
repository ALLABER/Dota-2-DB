package com.allaber.dota2db.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.allaber.dota2db.Item.Hero;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Singleton.SingletonHero;

public class FragmentHeroTalent extends Fragment {

    String stringLeftLvl25;
    String stringRightLvl25;

    String stringLeftLvl20;
    String stringRightLvl20;

    String stringLeftLvl15;
    String stringRightLvl15;

    String stringLeftLvl10;
    String stringRightLvl10;


    TextView textViewLeftLvl25;
    TextView textViewRightLvl25;

    TextView textViewLeftLvl20;
    TextView textViewRightLvl20;

    TextView textViewLeftLvl15;
    TextView textViewRightLvl15;

    TextView textViewLeftLvl10;
    TextView textViewRightLvl10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_talent, container, false);

        SingletonHero.get(getContext());
        Hero hero = SingletonHero.getHero();

        stringLeftLvl25 = hero.getStringLeftLvl25();
        stringRightLvl25 = hero.getStringRightLvl25();

        stringLeftLvl20 = hero.getStringLeftLvl20();
        stringRightLvl20 = hero.getStringRightLvl20();

        stringLeftLvl15 = hero.getStringLeftLvl15();
        stringRightLvl15 = hero.getStringRightLvl15();

        stringLeftLvl10 = hero.getStringLeftLvl10();
        stringRightLvl10 = hero.getStringRightLvl10();


        textViewLeftLvl25 = rootView.findViewById(R.id.textViewLeftLvl25);
        textViewRightLvl25 = rootView.findViewById(R.id.textViewRightLvl25);

        textViewLeftLvl20 = rootView.findViewById(R.id.textViewLeftLvl20);
        textViewRightLvl20 = rootView.findViewById(R.id.textViewRightLvl20);

        textViewLeftLvl15 = rootView.findViewById(R.id.textViewLeftLvl15);
        textViewRightLvl15 = rootView.findViewById(R.id.textViewRightLvl15);

        textViewLeftLvl10 = rootView.findViewById(R.id.textViewLeftLvl10);
        textViewRightLvl10 = rootView.findViewById(R.id.textViewRightLvl10);


        textViewLeftLvl25.setText(stringLeftLvl25);
        textViewRightLvl25.setText(stringRightLvl25);

        textViewLeftLvl20.setText(stringLeftLvl20);
        textViewRightLvl20.setText(stringRightLvl20);

        textViewLeftLvl15.setText(stringLeftLvl15);
        textViewRightLvl15.setText(stringRightLvl15);

        textViewLeftLvl10.setText(stringLeftLvl10);
        textViewRightLvl10.setText(stringRightLvl10);

        return rootView;
    }
}






















