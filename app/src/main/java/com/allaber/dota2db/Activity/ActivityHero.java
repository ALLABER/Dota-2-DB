package com.allaber.dota2db.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allaber.dota2db.Fragment.FragmentHeroAbility;
import com.allaber.dota2db.Fragment.FragmentHeroAboutHero;
import com.allaber.dota2db.Fragment.FragmentHeroAttribute;
import com.allaber.dota2db.Fragment.FragmentHeroBuy;
import com.allaber.dota2db.Fragment.FragmentHeroTalent;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Singleton.SingletonHero;
import com.allaber.dota2db.Singleton.SinglletonHeroFragment;
import com.allaber.dota2db.Static.GlobalStatic;


public class ActivityHero extends SinglletonHeroFragment implements View.OnClickListener {

    protected Fragment creatFragment() {
        return new FragmentHeroAttribute();
    }

    ImageView back;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentHeroAttribute fragment1 = new FragmentHeroAttribute();
                    ft.add(R.id.container, fragment1, "fragment1");
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    FragmentHeroAbility fragment2 = new FragmentHeroAbility();
                    ft.add(R.id.container, fragment2, "fragment2");
                    ft.commit();
                    return true;
                case R.id.navigation_notifications:
                    FragmentHeroTalent fragment3 = new FragmentHeroTalent();
                    ft.add(R.id.container, fragment3, "fragment3");
                    ft.commit();
                    return true;
                case R.id.navigation_home1:
                    FragmentHeroBuy fragment4 = new FragmentHeroBuy();
                    ft.add(R.id.container, fragment4, "fragment4");
                    ft.commit();
                    return true;
                case R.id.navigation_home2:
                    FragmentHeroAboutHero fragment5 = new FragmentHeroAboutHero();
                    ft.add(R.id.container, fragment5, "fragment5");
                    ft.commit();
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();
        String itemID = getResources().getResourceEntryName(Integer.valueOf(intent.getStringExtra("hero name")));

        GlobalStatic.setId(itemID);

        SingletonHero.get(this);
        com.allaber.dota2db.Item.Hero hero = SingletonHero.getHero();

        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        ImageView imageViewHero = findViewById(R.id.imageViewHero);
        ImageView imageViewAttributes = findViewById(R.id.imageViewAttributes);

        ImageView imageViewHeroComplexity1 = findViewById(R.id.imageView__hero_complexity_1);
        ImageView imageViewHeroComplexity2 = findViewById(R.id.imageView__hero_complexity_2);
        ImageView imageViewHeroComplexity3 = findViewById(R.id.imageView__hero_complexity_3);

        TextView textViewAttackType = findViewById(R.id.textViewAttackType);
        TextView textViewIHeroName = findViewById(R.id.textViewIHeroName);

        imageViewHero.setImageResource(getResources().getIdentifier(hero.getImage(), "drawable", getPackageName()));

        textViewAttackType.setText(hero.getAttackType());
        textViewIHeroName.setText(hero.getName());

        switch (hero.getAttribute()){
            case "strength":
                imageViewAttributes.setImageResource(R.drawable.system_image_strength);
                break;
            case "intellect":
                imageViewAttributes.setImageResource(R.drawable.system_image_intellect);
                break;
            case "agility":
                imageViewAttributes.setImageResource(R.drawable.system_image_agility);
                break;
        }


        switch (hero.getAttribute()){
            case "strength":
                imageViewAttributes.setImageResource(R.drawable.system_image_strength);
                break;
            case "intellect":
                imageViewAttributes.setImageResource(R.drawable.system_image_intellect);
                break;
            case "agility":
                imageViewAttributes.setImageResource(R.drawable.system_image_agility);
                break;
        }

        switch (hero.getComplexity()){
            case "1":
                imageViewHeroComplexity1.setImageResource(R.drawable.system_image_hero_complexity_true);
                imageViewHeroComplexity2.setImageResource(R.drawable.system_image_hero_complexity_false);
                imageViewHeroComplexity3.setImageResource(R.drawable.system_image_hero_complexity_false);
                break;
            case "2":
                imageViewHeroComplexity1.setImageResource(R.drawable.system_image_hero_complexity_true);
                imageViewHeroComplexity2.setImageResource(R.drawable.system_image_hero_complexity_true);
                imageViewHeroComplexity3.setImageResource(R.drawable.system_image_hero_complexity_false);
                break;
            case "3":
                imageViewHeroComplexity1.setImageResource(R.drawable.system_image_hero_complexity_true);
                imageViewHeroComplexity2.setImageResource(R.drawable.system_image_hero_complexity_true);
                imageViewHeroComplexity3.setImageResource(R.drawable.system_image_hero_complexity_true);
                break;
        }

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































