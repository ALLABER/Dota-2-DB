package com.allaber.dota2db.AsyncTask;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allaber.dota2db.Database.DatabaseHelper;
import com.allaber.dota2db.Item.Item;
import com.allaber.dota2db.R;
import com.allaber.dota2db.Static.GlobalStatic;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class AsyncTaskItem extends AsyncTask<Void, Void, Void> {

    private Item item;
    private String id;
    private SQLiteDatabase mDb;
    private Context myContext;

    ImageView imageViewItem;
    TextView textItemName;
    TextView textItemPrice;
    ImageView imageViewPrice;

    LinearLayout Attribute;
    TextView textViewAttribute;

    LinearLayout Using;
    LinearLayout UsingMana;
    LinearLayout UsingCooldown;
    TextView textViewUsingHead;
    TextView textViewUsingMana;
    TextView textViewUsingCooldown;
    TextView textViewUsingBody;

    LinearLayout Active;
    LinearLayout ActiveMana;
    LinearLayout ActiveCooldown;
    TextView textViewActiveHead;
    TextView textViewActiveMana;
    TextView textViewActiveCooldown;
    TextView textViewActiveBody;

    LinearLayout Passive;
    LinearLayout PassiveMana;
    LinearLayout PassiveCooldown;
    TextView textViewPassiveHead;
    TextView textViewPassiveMana;
    TextView textViewPassiveCooldown;
    TextView textViewPassiveBody;

    LinearLayout Update;
    TextView textViewUpdate;
    LinearLayout Lore;
    TextView textViewLore;

    @Override
    protected void onPreExecute() {
        View rootView = GlobalStatic.getRootView();
        myContext = GlobalStatic.getContext();
        id = GlobalStatic.getId();
        item = new Item();
        imageViewItem = rootView.findViewById(R.id.imageViewItem);
        textItemName = rootView.findViewById(R.id.textItemName);
        textItemPrice = rootView.findViewById(R.id.textItemPrice);
        imageViewPrice = rootView.findViewById(R.id.imageViewPrice);

        Attribute = rootView.findViewById(R.id.Attribute);
        textViewAttribute = rootView.findViewById(R.id.textViewAttribute);

        Using = rootView.findViewById(R.id.Using);
        UsingMana = rootView.findViewById(R.id.UsingMana);
        UsingCooldown = rootView.findViewById(R.id.UsingCooldown);
        textViewUsingHead = rootView.findViewById(R.id.textViewUsingHead);
        textViewUsingMana = rootView.findViewById(R.id.textViewUsingMana);
        textViewUsingCooldown = rootView.findViewById(R.id.textViewUsingCooldown);
        textViewUsingBody = rootView.findViewById(R.id.textViewUsingBody);

        Active = rootView.findViewById(R.id.Active);
        ActiveMana = rootView.findViewById(R.id.ActiveMana);
        ActiveCooldown = rootView.findViewById(R.id.ActiveCooldown);
        textViewActiveHead = rootView.findViewById(R.id.textViewActiveHead);
        textViewActiveMana = rootView.findViewById(R.id.textViewActiveMana);
        textViewActiveCooldown = rootView.findViewById(R.id.textViewActiveCooldown);
        textViewActiveBody = rootView.findViewById(R.id.textViewActiveBody);

        Passive = rootView.findViewById(R.id.Passive);
        PassiveMana = rootView.findViewById(R.id.PassiveMana);
        PassiveCooldown = rootView.findViewById(R.id.PassiveCooldown);
        textViewPassiveHead = rootView.findViewById(R.id.textViewPassiveHead);
        textViewPassiveMana = rootView.findViewById(R.id.textViewPassiveMana);
        textViewPassiveCooldown = rootView.findViewById(R.id.textViewPassiveCooldown);
        textViewPassiveBody = rootView.findViewById(R.id.textViewPassiveBody);

        Update = rootView.findViewById(R.id.Update);
        textViewUpdate = rootView.findViewById(R.id.textViewUpdate);

        Lore = rootView.findViewById(R.id.Lore);
        textViewLore = rootView.findViewById(R.id.textViewLore);


        DatabaseHelper mDBHelper = new DatabaseHelper(myContext);
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

        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {

        Cursor cursor = mDb.rawQuery("SELECT * FROM Items WHERE Image Like '" + id + "'" + "", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            item.setImage(cursor.getString(0));
            item.setTextItemName(cursor.getString(1));
            item.setTextItemPrice(cursor.getString(4));

            if (Boolean.valueOf(cursor.getString(5))) {
                item.setAttribute(true);
                item.setTextViewAttribute(cursor.getString(17));
            } else {
                item.setAttribute(false);
            }


            if (Boolean.valueOf(cursor.getString(6))) {
                item.setUsing(true);
                item.setTextViewUsingHead("Использование: " + cursor.getString(18));
                item.setTextViewUsingMana(cursor.getString(19));
                item.setTextViewUsingCooldown(cursor.getString(20));
                item.setTextViewUsingBody(cursor.getString(21));
            } else {
                item.setUsing(false);
            }


            if (Boolean.valueOf(cursor.getString(7))) {
                item.setActive(true);
                item.setTextViewActiveHead("Активируемая: " + cursor.getString(22));
                item.setTextViewActiveMana(cursor.getString(23));
                item.setTextViewActiveCooldown(cursor.getString(24));
                item.setTextViewActiveBody(cursor.getString(25));
            } else {
                item.setActive(false);
            }


            if (Boolean.valueOf(cursor.getString(8))) {
                item.setPassive(true);
                item.setTextViewPassiveHead("Пассивная: " + cursor.getString(26));
                item.setTextViewPassiveMana(cursor.getString(27));
                item.setTextViewPassiveCooldown(cursor.getString(28));
                item.setTextViewPassiveBody(cursor.getString(29));
            } else {
                item.setPassive(false);
            }


            if (Boolean.valueOf(cursor.getString(9))) {
                item.setUpdate(true);
                item.setTextViewUpdate(cursor.getString(30));
            } else {
                item.setUpdate(false);
            }

            if (Boolean.valueOf(cursor.getString(10))) {
                item.setLore(true);
                item.setTextViewLore(cursor.getString(31));
            } else {
                item.setLore(false);
            }


            if (Boolean.valueOf(cursor.getString(11))) {
                item.setImageViewUsingMana(true);
                item.setTextViewUsingMana(cursor.getString(19));
            } else {
                item.setImageViewUsingMana(false);
            }
            if (Boolean.valueOf(cursor.getString(12))) {
                item.setImageViewUsingCooldown(true);
                item.setTextViewUsingCooldown(cursor.getString(20));
            } else {
                item.setImageViewUsingCooldown(false);
            }


            if (Boolean.valueOf(cursor.getString(13))) {
                item.setImageViewActiveMana(true);
                item.setTextViewActiveMana(cursor.getString(23));
            } else {
                item.setImageViewActiveMana(false);
            }
            if (Boolean.valueOf(cursor.getString(14))) {
                item.setImageViewActiveCooldown(true);
                item.setTextViewActiveCooldown(cursor.getString(24));
            } else {
                item.setImageViewActiveCooldown(false);
            }


            if (Boolean.valueOf(cursor.getString(15))) {
                item.setImageViewPassiveMana(true);
                item.setTextViewPassiveMana(cursor.getString(27));
            } else {
                item.setImageViewPassiveMana(false);
            }
            if (Boolean.valueOf(cursor.getString(16))) {
                item.setImageViewPassiveCooldown(true);
                item.setTextViewPassiveCooldown(cursor.getString(28));
            } else {
                item.setImageViewPassiveCooldown(false);
            }


            cursor.moveToNext();
        }
        cursor.close();
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        textItemName.setText(Html.fromHtml(item.getTextItemName()));


        Picasso.get().load(myContext.getResources().getIdentifier(id,"drawable", myContext.getPackageName())).placeholder(R.drawable.system_image_placeholder_item).into(imageViewItem);


        textItemPrice.setText(Html.fromHtml(item.getTextItemPrice()));
        if (Integer.valueOf(item.getTextItemPrice()) == 0) {
            imageViewPrice.setVisibility(View.GONE);
            textItemPrice.setVisibility(View.GONE);
        } else {
            imageViewPrice.setVisibility(View.VISIBLE);
            textItemPrice.setVisibility(View.VISIBLE);
        }
        if (item.isAttribute()) {
            Attribute.setVisibility(View.VISIBLE);
            textViewAttribute.setText(Html.fromHtml(item.getTextViewAttribute()));
        } else {
            Attribute.setVisibility(View.GONE);
        }

        if (item.isUsing()) {
            Using.setVisibility(View.VISIBLE);
            if (item.isImageViewUsingMana()) {
                UsingMana.setVisibility(View.VISIBLE);
                textViewUsingMana.setText(Html.fromHtml(item.getTextViewUsingMana()));
            } else {
                UsingMana.setVisibility(View.GONE);
            }
            if (item.isImageViewUsingCooldown()) {
                UsingCooldown.setVisibility(View.VISIBLE);
                textViewUsingCooldown.setText(Html.fromHtml(item.getTextViewUsingCooldown()));
            } else {
                UsingCooldown.setVisibility(View.GONE);
            }
            textViewUsingHead.setText(Html.fromHtml(item.getTextViewUsingHead()));
            textViewUsingBody.setText(Html.fromHtml(item.getTextViewUsingBody()));
        } else {
            Using.setVisibility(View.GONE);
        }


        if (item.isActive()) {
            if (item.isImageViewActiveMana()) {
                ActiveMana.setVisibility(View.VISIBLE);
                textViewActiveMana.setText(Html.fromHtml(item.getTextViewActiveMana()));
            } else {
                ActiveMana.setVisibility(View.GONE);
            }
            if (item.isImageViewActiveCooldown()) {
                ActiveCooldown.setVisibility(View.VISIBLE);
                textViewActiveCooldown.setText(Html.fromHtml(item.getTextViewActiveCooldown()));
            } else {
                ActiveCooldown.setVisibility(View.GONE);
            }
            Active.setVisibility(View.VISIBLE);
            textViewActiveHead.setText(Html.fromHtml(item.getTextViewActiveHead()));
            textViewActiveBody.setText(Html.fromHtml(item.getTextViewActiveBody()));
        } else {
            Active.setVisibility(View.GONE);
        }


        if (item.isPassive()) {
            Passive.setVisibility(View.VISIBLE);
            if (item.isImageViewPassiveMana()) {
                PassiveMana.setVisibility(View.VISIBLE);
                textViewPassiveMana.setText(Html.fromHtml(item.getTextViewPassiveMana()));
            } else {
                PassiveMana.setVisibility(View.GONE);
            }
            if (item.isImageViewPassiveCooldown()) {
                PassiveCooldown.setVisibility(View.VISIBLE);
                textViewPassiveCooldown.setText(Html.fromHtml(item.getTextViewPassiveCooldown()));
            } else {
                PassiveCooldown.setVisibility(View.GONE);
            }

            textViewPassiveHead.setText(Html.fromHtml(item.getTextViewPassiveHead()));
            textViewPassiveBody.setText(Html.fromHtml(item.getTextViewPassiveBody()));
        } else {
            Passive.setVisibility(View.GONE);
        }


        if (item.isUpdate()) {
            Update.setVisibility(View.VISIBLE);
            textViewUpdate.setText(Html.fromHtml(item.getTextViewUpdate()));
        } else {
            Update.setVisibility(View.GONE);
        }


        if (item.isLore()) {
            Lore.setVisibility(View.VISIBLE);
            textViewLore.setText(Html.fromHtml(item.getTextViewLore()));
        } else {
            Lore.setVisibility(View.GONE);
        }
    }

}




























