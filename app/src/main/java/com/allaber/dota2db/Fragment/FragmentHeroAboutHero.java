package com.allaber.dota2db.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.allaber.dota2db.Item.Hero;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Singleton.SingletonHero;

public class FragmentHeroAboutHero extends Fragment {

    int textQuickDamage;
    int textRolesSupport;
    int textRolesForest;
    int textRolesFarm;
    int textRolesEscape;
    int textRolesSiege;
    int textRolesControl;
    int textRolesPersistence;
    int textRolesInitiation;
    String textBiographyText;

    ImageView imageViewQuickDamage1;
    ImageView imageViewQuickDamage2;
    ImageView imageViewQuickDamage3;

    ImageView imageViewRolesSupport1;
    ImageView imageViewRolesSupport2;
    ImageView imageViewRolesSupport3;

    ImageView imageViewRolesForest1;
    ImageView imageViewRolesForest2;
    ImageView imageViewRolesForest3;

    ImageView imageViewRolesFarm1;
    ImageView imageViewRolesFarm2;
    ImageView imageViewRolesFarm3;

    ImageView imageViewRolesEscape1;
    ImageView imageViewRolesEscape2;
    ImageView imageViewRolesEscape3;

    ImageView imageViewRolesSiege1;
    ImageView imageViewRolesSiege2;
    ImageView imageViewRolesSiege3;

    ImageView imageViewRolesControl1;
    ImageView imageViewRolesControl2;
    ImageView imageViewRolesControl3;

    ImageView imageViewRolesPersistence1;
    ImageView imageViewRolesPersistence2;
    ImageView imageViewRolesPersistence3;

    ImageView imageViewRolesInitiation1;
    ImageView imageViewRolesInitiation2;
    ImageView imageViewRolesInitiation3;

    TextView textViewBiographyText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_about_hero, container, false);

        SingletonHero.get(getContext());
        Hero hero = SingletonHero.getHero();

        textQuickDamage = hero.getTextQuickDamag();
        textRolesSupport = hero.getTextRolesSupport();
        textRolesForest = hero.getTextRolesForest();
        textRolesFarm = hero.getTextRolesFarm();
        textRolesEscape = hero.getTextRolesEscape();
        textRolesSiege = hero.getTextRolesSiege();
        textRolesControl = hero.getTextRolesControl();
        textRolesPersistence = hero.getTextRolesPersistence();
        textRolesInitiation = hero.getTextRolesInitiation();
        textBiographyText = hero.getTextBiographyText();



        imageViewQuickDamage1 = rootView.findViewById(R.id.imageViewQuickDamage1);
        imageViewQuickDamage2 = rootView.findViewById(R.id.imageViewQuickDamage2);
        imageViewQuickDamage3 = rootView.findViewById(R.id.imageViewQuickDamage3);

        imageViewRolesSupport1 = rootView.findViewById(R.id.imageViewRolesSupport1);
        imageViewRolesSupport2 = rootView.findViewById(R.id.imageViewRolesSupport2);
        imageViewRolesSupport3 = rootView.findViewById(R.id.imageViewRolesSupport3);

        imageViewRolesForest1 = rootView.findViewById(R.id.imageViewRolesForest1);
        imageViewRolesForest2 = rootView.findViewById(R.id.imageViewRolesForest2);
        imageViewRolesForest3 = rootView.findViewById(R.id.imageViewRolesForest3);

        imageViewRolesFarm1 = rootView.findViewById(R.id.imageViewRolesFarm1);
        imageViewRolesFarm2 = rootView.findViewById(R.id.imageViewRolesFarm2);
        imageViewRolesFarm3 = rootView.findViewById(R.id.imageViewRolesFarm3);

        imageViewRolesEscape1 = rootView.findViewById(R.id.imageViewRolesEscape1);
        imageViewRolesEscape2 = rootView.findViewById(R.id.imageViewRolesEscape2);
        imageViewRolesEscape3 = rootView.findViewById(R.id.imageViewRolesEscape3);

        imageViewRolesSiege1 = rootView.findViewById(R.id.imageViewRolesSiege1);
        imageViewRolesSiege2 = rootView.findViewById(R.id.imageViewRolesSiege2);
        imageViewRolesSiege3 = rootView.findViewById(R.id.imageViewRolesSiege3);

        imageViewRolesControl1 = rootView.findViewById(R.id.imageViewRolesControl1);
        imageViewRolesControl2 = rootView.findViewById(R.id.imageViewRolesControl2);
        imageViewRolesControl3 = rootView.findViewById(R.id.imageViewRolesControl3);

        imageViewRolesPersistence1 = rootView.findViewById(R.id.imageViewRolesPersistence1);
        imageViewRolesPersistence2 = rootView.findViewById(R.id.imageViewRolesPersistence2);
        imageViewRolesPersistence3 = rootView.findViewById(R.id.imageViewRolesPersistence3);

        imageViewRolesInitiation1 = rootView.findViewById(R.id.imageViewRolesInitiation1);
        imageViewRolesInitiation2 = rootView.findViewById(R.id.imageViewRolesInitiation2);
        imageViewRolesInitiation3 = rootView.findViewById(R.id.imageViewRolesInitiation3);

        textViewBiographyText = rootView.findViewById(R.id.textViewBiographyText);

        setViewQuickDamage(textQuickDamage);
        setViewRolesSupport(textRolesSupport);
        setViewRolesForest(textRolesForest);
        setViewRolesFarm(textRolesFarm);
        setViewRolesEscape(textRolesEscape);
        setViewRolesSiege(textRolesSiege);
        setViewRolesControl(textRolesControl);
        setViewRolesPersistence(textRolesPersistence);
        setViewRolesInitiation(textRolesInitiation);

        textViewBiographyText.setText(textBiographyText);
        return rootView;
    }

    public void setViewQuickDamage(int col) {
        switch (col) {
            case 1:
                imageViewQuickDamage1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewQuickDamage2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewQuickDamage3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewQuickDamage1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewQuickDamage2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewQuickDamage3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewQuickDamage1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewQuickDamage2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewQuickDamage3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }

    public void setViewRolesSupport(int col) {
        switch (col) {
            case 1:
                imageViewRolesSupport1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSupport2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewRolesSupport3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewRolesSupport1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSupport2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSupport3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewRolesSupport1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSupport2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSupport3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }

    public void setViewRolesForest(int col) {
        switch (col) {
            case 1:
                imageViewRolesForest1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesForest2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewRolesForest3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewRolesForest1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesForest2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesForest3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewRolesForest1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesForest2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesForest3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }

    public void setViewRolesFarm(int col) {
        switch (col) {
            case 1:
                imageViewRolesFarm1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesFarm2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewRolesFarm3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewRolesFarm1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesFarm2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesFarm3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewRolesFarm1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesFarm2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesFarm3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }

    public void setViewRolesEscape(int col) {
        switch (col) {
            case 1:
                imageViewRolesEscape1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesEscape2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewRolesEscape3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewRolesEscape1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesEscape2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesEscape3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewRolesEscape1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesEscape2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesEscape3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }

    public void setViewRolesSiege(int col) {
        switch (col) {
            case 1:
                imageViewRolesSiege1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSiege2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewRolesSiege3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewRolesSiege1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSiege2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSiege3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewRolesSiege1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSiege2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesSiege3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }

    public void setViewRolesControl(int col) {
        switch (col) {
            case 1:
                imageViewRolesControl1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesControl2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewRolesControl3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewRolesControl1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesControl2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesControl3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewRolesControl1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesControl2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesControl3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }

    public void setViewRolesPersistence(int col) {
        switch (col) {
            case 1:
                imageViewRolesPersistence1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesPersistence2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewRolesPersistence3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewRolesPersistence1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesPersistence2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesPersistence3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewRolesPersistence1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesPersistence2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesPersistence3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }

    public void setViewRolesInitiation(int col) {
        switch (col) {
            case 1:
                imageViewRolesInitiation1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesInitiation2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                imageViewRolesInitiation3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 2:
                imageViewRolesInitiation1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesInitiation2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesInitiation3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_false);
                break;
            case 3:
                imageViewRolesInitiation1.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesInitiation2.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                imageViewRolesInitiation3.setImageResource(R.drawable.system_image_fragment_hero_role_stats_true);
                break;
        }
    }


}





































