package com.allaber.dota2db.Singleton;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.allaber.dota2db.Database.DatabaseHelper;
import com.allaber.dota2db.Item.Ability;
import com.allaber.dota2db.Item.Hero;
import com.allaber.dota2db.Static.GlobalStatic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingletonHero {

    private static SingletonHero singletonHero;
    private SQLiteDatabase mDb;
    private static Hero hero = new Hero();

    public static SingletonHero get(Context ctx) {
        //if (singletonHero== null)
        singletonHero = new SingletonHero(ctx);
        return singletonHero;
    }

    private SingletonHero(Context ctx) {

        DatabaseHelper mDBHelper = new DatabaseHelper(ctx);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        List<Ability> abilities = new ArrayList<>();
        int pos = 48;

        Cursor cursor = mDb.rawQuery("SELECT * FROM Heros WHERE Image Like " + "'" + GlobalStatic.getId() + "'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            hero.setImage(cursor.getString(0));
            hero.setName(cursor.getString(1));
            hero.setAttribute(cursor.getString(2));
            hero.setAttackType(cursor.getString(3));
            hero.setComplexity(cursor.getString(4));

            hero.setStandardStrange(cursor.getDouble(5));
            hero.setStandardAgility(cursor.getDouble(6));
            hero.setStandardIntelect(cursor.getDouble(7));

            hero.setStrangeGainsPerLevel(cursor.getDouble(8));
            hero.setAgilityGainsPerLevel(cursor.getDouble(9));
            hero.setIntelectGainsPerLevel(cursor.getDouble(10));

            hero.setStandardHealthRegen(cursor.getDouble(11));
            hero.setStandardManaRegen(cursor.getDouble(12));


            hero.setStandardSpeed(cursor.getDouble(13));

            hero.setStandardAttackSpeed(cursor.getDouble(14));
            hero.setStandardDamage(cursor.getDouble(15));
            hero.setStandardArmor(cursor.getDouble(16));
            hero.setStandardMagicResist(cursor.getDouble(17));

            hero.setTurnRate(cursor.getString(18));
            hero.setVisionRange(cursor.getString(19));
            hero.setAttactRange(cursor.getString(20));
            hero.setProjectileSpeed(cursor.getString(21));


            hero.setStringLeftLvl25(cursor.getString(22));
            hero.setStringRightLvl25(cursor.getString(23));

            hero.setStringLeftLvl20(cursor.getString(24));
            hero.setStringRightLvl20(cursor.getString(25));

            hero.setStringLeftLvl15(cursor.getString(26));
            hero.setStringRightLvl15(cursor.getString(27));

            hero.setStringLeftLvl10(cursor.getString(28));
            hero.setStringRightLvl10(cursor.getString(29));

            hero.setTextQuickDamag(cursor.getInt(30));
            hero.setTextRolesSupport(cursor.getInt(31));
            hero.setTextRolesForest(cursor.getInt(32));
            hero.setTextRolesFarm(cursor.getInt(33));
            hero.setTextRolesEscape(cursor.getInt(34));
            hero.setTextRolesSiege(cursor.getInt(35));
            hero.setTextRolesControl(cursor.getInt(36));
            hero.setTextRolesPersistence(cursor.getInt(37));
            hero.setTextRolesInitiation(cursor.getInt(38));
            hero.setTextBiographyText(cursor.getString(39));

            hero.setTextBuyItemsText(cursor.getString(40));
            hero.setColEarlyGame(cursor.getInt(41));
            hero.setColMidGame(cursor.getInt(42));
            hero.setColLateGame(cursor.getInt(43));
            hero.setColDependsOnSituation(cursor.getInt(45));
            hero.setColPopularItems(cursor.getInt(44));

            hero.setColAbilitys(cursor.getInt(47));

            for(int i = 0; i < cursor.getInt(47); i++){
                Ability ability = new Ability();
                ability.setImageID(ctx.getResources().getIdentifier(cursor.getString(pos), "drawable", ctx.getPackageName()));
                ++pos;
                ability.setTextAbilityName(cursor.getString(pos));
                ++pos;
                ability.setTextAbilityType(cursor.getString(pos));
                ++pos;
                ability.setTextAbilityLoreTop(cursor.getString(pos));
                ++pos;
                ability.setTextAbilityAlt(cursor.getString(pos));
                ++pos;
                ability.setTextAbilityRange(cursor.getString(pos));
                ++pos;
                ability.setTextCooldown(cursor.getString(pos));
                ++pos;
                ability.setTextMana(cursor.getString(pos));
                ++pos;
                ability.setTextAbilityLoreBottom(cursor.getString(pos));
                ++pos;
                abilities.add(ability);
                //Toast.makeText(ctx, "pos = " + pos, Toast.LENGTH_SHORT).show();
                //Ability ability1 = abilities.get(i);
                //Toast.makeText(ctx, "ability1 name = " + ability1 .getTextAbilityName(), Toast.LENGTH_SHORT).show();
            }

            hero.setAbilities(abilities);

            cursor.moveToNext();
        }


        cursor.close();
    }

    public static Hero getHero() {
        return hero;
    }
}























