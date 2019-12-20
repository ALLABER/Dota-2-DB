package com.allaber.dota2db.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.allaber.dota2db.Item.Hero;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Singleton.SingletonHero;

public class FragmentHeroAttribute extends Fragment implements SeekBar.OnSeekBarChangeListener {

    double StandardStrange;
    double StandardAgility;
    double StandardIntelect;

    double StrangeGainsPerLevel;
    double AgilityGainsPerLevel;
    double IntelectGainsPerLevel;

    double StandardHealthRegen;
    double StandardManaRegen;

    double StandardSpeed;

    double StandardAttackSpeed;
    double StandardArmor;
    double StandardDamage;
    double StandardMagicResist;

    String TurnRate;
    String VisionRange;
    String AttactRange;
    String ProjectileSpeed;


    private TextView textViewHealth;
    private TextView textViewHealthRegeneration;
    private TextView textViewMana;
    private TextView textViewManaRegeneration;
    private TextView textViewLevel;
    private TextView textViewAttributeStrange;
    private TextView textViewAttributeIntelect;
    private TextView textViewAttributeAgility;
    private TextView textViewMobilitySpeed;
    private TextView textViewProtectionArmor;
    private TextView textViewAttackDamage;
    private TextView textViewAttackAttack;
    private TextView textViewProtectionResistancePhysic;
    private TextView textViewProtectionResistanceMagic;
    private TextView textViewMagicAttack;
    private TextView textViewTurnRate;
    private TextView textViewVisionRange;
    private TextView textViewAttactRange;
    private TextView textViewProjectileSpeed;

    double Strange;
    double Agility;
    double Intelect;

    double HealthRegen;
    double ManaRegen;

    double Health;
    double Mana;

    double Speed;

    double AttackSpeed;
    double AttackSpeedOneSecond;

    double Armor;

    double Damage;

    double PhysicalResist;

    double MagicResist;

    double SpellAmp;

    String heroAttribute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_attribute, container, false);
        final SeekBar seekBar = rootView.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        SingletonHero.get(getContext());
        Hero hero = SingletonHero.getHero();

        StandardStrange = hero.getStandardStrange();
        StandardAgility = hero.getStandardAgility();
        StandardIntelect = hero.getStandardIntelect();

        StrangeGainsPerLevel = hero.getStrangeGainsPerLevel();
        AgilityGainsPerLevel = hero.getAgilityGainsPerLevel();
        IntelectGainsPerLevel = hero.getIntelectGainsPerLevel();

        StandardHealthRegen = hero.getStandardHealthRegen();
        StandardManaRegen = hero.getStandardManaRegen();

        StandardSpeed = hero.getStandardSpeed();

        StandardAttackSpeed = hero.getStandardAttackSpeed();
        StandardDamage = hero.getStandardDamage();
        StandardArmor = hero.getStandardArmor();
        StandardMagicResist = hero.getStandardMagicResist();

        TurnRate = hero.getTurnRate();
        VisionRange = hero.getVisionRange();
        AttactRange = hero.getAttactRange();
        ProjectileSpeed = hero.getProjectileSpeed();

        heroAttribute = hero.getAttribute();

        textViewHealth = rootView.findViewById(R.id.textViewHP);
        textViewHealthRegeneration = rootView.findViewById(R.id.textViewHealthRegeneration);
        textViewMana = rootView.findViewById(R.id.textViewMana);
        textViewManaRegeneration = rootView.findViewById(R.id.textViewManaRegeneration);
        textViewLevel = rootView.findViewById(R.id.textViewLevel);
        textViewAttributeStrange = rootView.findViewById(R.id.textViewAttributeStrange);
        textViewAttributeIntelect = rootView.findViewById(R.id.textViewAttributeIntelect);
        textViewAttributeAgility = rootView.findViewById(R.id.textViewAttributeAgility);
        textViewMobilitySpeed = rootView.findViewById(R.id.textViewMobilitySpeed);
        textViewProtectionArmor = rootView.findViewById(R.id.textViewProtectionArmor);
        textViewAttackDamage = rootView.findViewById(R.id.textViewAttackDamage);
        textViewAttackAttack = rootView.findViewById(R.id.textViewAttackAttack);
        textViewProtectionResistancePhysic = rootView.findViewById(R.id.textViewProtectionResistancePhysic);
        textViewProtectionResistanceMagic = rootView.findViewById(R.id.textViewProtectionResistanceMagic);
        textViewMagicAttack = rootView.findViewById(R.id.textViewMagicAttack);
        textViewTurnRate = rootView.findViewById(R.id.textViewTurnRate);
        textViewVisionRange = rootView.findViewById(R.id.textViewVisionRange);
        textViewAttactRange = rootView.findViewById(R.id.textViewAttactRange);
        textViewProjectileSpeed = rootView.findViewById(R.id.textViewProjectileSpeed);

        AttributeCalculation(0);
        return rootView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int lvl = seekBar.getProgress();
        AttributeCalculation(lvl);
        textViewLevel.setText("Уровень: " + ++lvl);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }


    public void AttributeCalculation(int level) {
        Strange = StandardStrange + StrangeGainsPerLevel * level;
        Agility = StandardAgility + AgilityGainsPerLevel * level;
        Intelect = StandardIntelect + IntelectGainsPerLevel * level;

        HealthRegen = (StrangeGainsPerLevel * level) * 0.1 + StandardHealthRegen;
        ManaRegen = (IntelectGainsPerLevel * level) * 0.05 + StandardManaRegen;

        Health = (StandardStrange + Math.floor(StrangeGainsPerLevel * level)) * 20 + 200;
        Mana = (StandardIntelect + Math.floor(IntelectGainsPerLevel * level)) * 12 + 75;

        Speed = (Agility * 0.05 + 100) * (StandardSpeed / 100);

        Armor = (AgilityGainsPerLevel * level) * 0.16 + StandardArmor;


        switch (heroAttribute) {
            case "strength":
                Damage = StrangeGainsPerLevel * level + StandardDamage;
                break;
            case "agility":
                Damage = AgilityGainsPerLevel * level + StandardDamage;
                break;
            case "intellect":
                Damage = IntelectGainsPerLevel * level + StandardDamage;
                break;
        }


        AttackSpeed = 100 + Agility;
        AttackSpeedOneSecond = 1 / ((AttackSpeed * 0.01) / StandardAttackSpeed);

        PhysicalResist = (Armor * 0.052) / (0.9 + Armor * 0.048);

        MagicResist = 1 - (1 - (Strange / 100) * 0.08) * (1 - StandardMagicResist);

        SpellAmp = Intelect * 0.07;

        textViewAttributeStrange.setText(Math.round(Strange * 10.0) / 10.0 + " + " + StrangeGainsPerLevel + " за уровень");
        textViewAttributeAgility.setText(Math.round(Agility * 10.0) / 10.0 + " + " + AgilityGainsPerLevel + " за уровень");
        textViewAttributeIntelect.setText(Math.round(Intelect * 10.0) / 10.0 + " + " + IntelectGainsPerLevel + " за уровень");


        textViewHealthRegeneration.setText("+" + Math.round(HealthRegen * 10.0) / 10.0);
        textViewManaRegeneration.setText("+" + Math.round(ManaRegen * 10.0) / 10.0);

        textViewHealth.setText(String.valueOf(Math.round(Health)));
        textViewMana.setText(String.valueOf(Math.round(Mana)));

        textViewMobilitySpeed.setText("Скорость передвижения: " + Math.round(Speed * 100.0) / 100.0);
        textViewProtectionArmor.setText("Броня: " + Math.round(Armor * 100.0) / 100.0);

        textViewAttackDamage.setText("Урон: " + Math.round(Damage * 10.0) / 10.0);

        textViewAttackAttack.setText("Скорость атаки: " + Math.round(AttackSpeed * 10.0) / 10.0 + " (" + Math.round(AttackSpeedOneSecond * 100.0) / 100.0 + "s)");

        textViewProtectionResistancePhysic.setText("Физическая защита: " + Math.round(PhysicalResist * 1000.0) / 10.0 + " %");

        textViewProtectionResistanceMagic.setText("Сопротивление магии: " + Math.round(MagicResist * 1000.0) / 10.0 + " %");

        textViewMagicAttack.setText("Усиление способности: " + Math.round(SpellAmp * 10.0) / 10.0 + " %");

        textViewTurnRate.setText("Скорость поворота: " + TurnRate);

        textViewVisionRange.setText("Дальность обзора: " + VisionRange);

        textViewAttactRange.setText("Дальность атаки: " + AttactRange);


        if (ProjectileSpeed.equals("0")) {
            textViewProjectileSpeed.setVisibility(View.GONE);
        } else {
            textViewProjectileSpeed.setVisibility(View.VISIBLE);
            textViewProjectileSpeed.setText("Скорость полета снаряда: " + ProjectileSpeed);
        }

    }
}
























