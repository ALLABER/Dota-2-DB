package com.allaber.dota2db.Static;

import android.content.Context;
import android.view.View;

public class GlobalStatic {
    private static Context mContext;
    private static View rootView;
    private static String FromBD;
    private static String WhereBD;
    private static String LikeBD;
    private static Integer NumColumns;
    private static String Id;
    public static String getId() {
        return Id;
    }

    public static void setId(String id) {
        Id = id;
    }

    public static Integer getNumColumns() {
        return NumColumns;
    }

    public static void setNumColumns(Integer numColumns) {
        NumColumns = numColumns;
    }

    public static String getFromBD() {
        return FromBD;
    }

    public static void setFromBD(String fromBD) { FromBD = fromBD; }

    public static String getWhereBD() {
        return WhereBD;
    }

    public static void setWhereBD(String whereBD) {
        WhereBD = whereBD;
    }

    public static String getLikeBD() {
        return LikeBD;
    }

    public static void setLikeBD(String likeBD) {
        LikeBD = likeBD;
    }

    public static View getRootView() {
        return rootView;
    }

    public static void setRootView(View rootView) {
        GlobalStatic.rootView = rootView;
    }

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context c) {
        mContext = c;
    }
}
