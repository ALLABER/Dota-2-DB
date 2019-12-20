package com.allaber.dota2db.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.allaber.dota2db.Item.Ability;
import com.allaber.dota2db.Item.Hero;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Singleton.SingletonHero;

import java.util.ArrayList;
import java.util.List;

public class FragmentHeroAbility extends Fragment {

    RecyclerView recyclerView;
    private CrimeAdapter mAdapter;

    TextView textViewAbilityName;
    TextView textViewAbilityType;
    TextView textViewAbilityLoreTop;
    TextView textViewAbilityRange;
    TextView textViewCooldown;
    TextView textViewMana;
    TextView textViewAbilityLoreBottom;
    TextView textViewAbilityAlt;

    String textAbilityName;
    String textAbilityType;
    String textAbilityLoreTop;
    String textAbilityRange;
    String textCooldown;
    String textMana;
    String textAbilityLoreBottom;
    String textAbilityAlt;

    ImageView imageViewCooldown;
    ImageView imageViewMana;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_ability, container, false);

        textViewAbilityName = rootView.findViewById(R.id.textViewAbilityName);
        textViewAbilityType = rootView.findViewById(R.id.textViewAbilityType);
        textViewAbilityLoreTop = rootView.findViewById(R.id.textViewAbilityLoreTop);
        textViewAbilityRange = rootView.findViewById(R.id.textViewAbilityRange);
        textViewCooldown = rootView.findViewById(R.id.textViewCooldown);
        textViewMana = rootView.findViewById(R.id.textViewMana);
        textViewAbilityLoreBottom = rootView.findViewById(R.id.textViewAbilityLoreBottom);
        textViewAbilityAlt = rootView.findViewById(R.id.textViewAbilityAlt);

        imageViewCooldown = rootView.findViewById(R.id.imageViewCooldown);
        imageViewMana = rootView.findViewById(R.id.imageViewMana);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        updateUI();
        return rootView;
    }


    private void updateUI() {
        SingletonHero.get(getContext());
        Hero hero = SingletonHero.getHero();
        List<Ability> abilitys = hero.getAbilities();
        mAdapter = new CrimeAdapter(abilitys);
        recyclerView.setAdapter(mAdapter);
    }


    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Ability ability;
        List<Ability> mAbilitys;
        ImageView imageView;

        List<ImageView> imageViewList = new ArrayList<>();
        //ImageView imageView1;

        //int j = 0;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent, List<Ability> abilitys) {
            super(inflater.inflate(R.layout.item_ability, parent, false));
            mAbilitys = abilitys;
            imageView = itemView.findViewById(R.id.imageView);

            imageViewList.add(imageView);
            //imageView.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorBlack), android.graphics.PorterDuff.Mode.MULTIPLY);
        }

        public void bind(Ability abilityss, int i) {
            imageView.setImageResource(abilityss.getImageID());
            itemView.setOnClickListener(this);

            if (i == 0) {
                itemView.callOnClick();
            }

            //imageViewList.add(imageView);
            //Toast.makeText(getContext(), "size = " + imageViewList.size(), Toast.LENGTH_LONG).show();

        }

        @Override
        public void onClick(View v) {

//            Toast.makeText(getContext(), "i = " + imageViewList.size(), Toast.LENGTH_SHORT).show();

//            Toast.makeText(getContext(), "size = " + imageViewList.size(), Toast.LENGTH_LONG).show();

//            while (imageViews.size() != j){
//                Toast.makeText(getContext(), "i = " + j, Toast.LENGTH_SHORT).show();
//                j++;
//            }
//            if(imageView1 != null) {
//                imageView1.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorBlack), android.graphics.PorterDuff.Mode.MULTIPLY);
//            }
            //imageView.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorWhite), android.graphics.PorterDuff.Mode.MULTIPLY);
            //imageView.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorBlack), android.graphics.PorterDuff.Mode.MULTIPLY);


            ability = mAbilitys.get(getAdapterPosition());

            textAbilityName = ability.getTextAbilityName();
            textAbilityType = ability.getTextAbilityType();
            textAbilityLoreTop = ability.getTextAbilityLoreTop();

            textAbilityLoreTop = ability.getTextAbilityLoreTop();

            textAbilityRange = ability.getTextAbilityRange();
            textCooldown = ability.getTextCooldown();
            textMana = ability.getTextMana();
            textAbilityLoreBottom = ability.getTextAbilityLoreBottom();
            textAbilityAlt = ability.getTextAbilityAlt();


            if (textAbilityAlt.equals("no")) {
                textViewAbilityAlt.setVisibility(View.GONE);
            } else {
                textViewAbilityAlt.setVisibility(View.VISIBLE);
            }

            if (textAbilityLoreTop.equals("no")) {
                textViewAbilityLoreTop.setVisibility(View.GONE);
            } else {
                textViewAbilityLoreTop.setVisibility(View.VISIBLE);
            }

            if (textAbilityRange.equals("no")) {
                textViewAbilityRange.setVisibility(View.GONE);
            } else {
                textViewAbilityRange.setVisibility(View.VISIBLE);
            }

            if (textCooldown.equals("0")) {
                textViewCooldown.setVisibility(View.GONE);
                imageViewCooldown.setVisibility(View.GONE);
            } else {
                textViewCooldown.setVisibility(View.VISIBLE);
                imageViewCooldown.setVisibility(View.VISIBLE);
            }

            if (textMana.equals("0")) {
                textViewMana.setVisibility(View.GONE);
                imageViewMana.setVisibility(View.GONE);
            } else {
                textViewMana.setVisibility(View.VISIBLE);
                imageViewMana.setVisibility(View.VISIBLE);
            }

            if (textAbilityLoreBottom.equals("no")) {
                textViewAbilityLoreBottom.setVisibility(View.GONE);
            } else {
                textViewAbilityLoreBottom.setVisibility(View.VISIBLE);
            }

            textViewAbilityName.setText(Html.fromHtml(textAbilityName));
            textViewAbilityType.setText(Html.fromHtml(textAbilityType));
            textViewAbilityLoreTop.setText(Html.fromHtml(textAbilityLoreTop));
            textViewAbilityAlt.setText(Html.fromHtml(textAbilityAlt));
            textViewAbilityRange.setText(Html.fromHtml(textAbilityRange));
            textViewCooldown.setText(Html.fromHtml(textCooldown));
            textViewMana.setText(Html.fromHtml(textMana));
            textViewAbilityLoreBottom.setText(Html.fromHtml(textAbilityLoreBottom));
        }
    }


    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Ability> mAbilitys;

        public CrimeAdapter(List<Ability> abilitys) {
            mAbilitys = abilitys;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity().getApplicationContext());
            return new CrimeHolder(layoutInflater, viewGroup, mAbilitys);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder creimeHolder, int i) {
            Ability crime = mAbilitys.get(i);
            creimeHolder.bind(crime, i);
        }

        @Override
        public int getItemCount() {
            return mAbilitys.size();
        }
    }
}




















