package com.aoinc.w2d3_a_gymequipmenttracker.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.aoinc.w2d3_a_gymequipmenttracker.R;
import com.aoinc.w2d3_a_gymequipmenttracker.model.GymEquipment;

import java.util.ArrayList;
import java.util.List;

public class EquipmentDatabaseHelper extends SQLiteOpenHelper {

    public static int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "gym_equimpent.db";

    public static final String TABLE_NAME = "purchased_equipment";
    public static final String COLUMN_ID= "id";
    public static final String COLUMN_ITEM_NAME = "item_name";
    public static final String COLUMN_BODY_PART = "body_part";
    public static final String COLUMN_PRICE = "price";

    private Resources resources;

    public EquipmentDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        resources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = resources.getString(R.string.database_create_table,
                TABLE_NAME, COLUMN_ID, COLUMN_ITEM_NAME, "TEXT", COLUMN_BODY_PART, "TEXT", COLUMN_PRICE, "TEXT");
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = resources.getString(R.string.database_drop_table, TABLE_NAME);
        db.execSQL(dropTable);
        onCreate(db);
        DATABASE_VERSION = newVersion;
    }

    public void insertIntoDatabase(GymEquipment equipment) {
        ContentValues equipValue = new ContentValues();

        equipValue.put(COLUMN_ITEM_NAME, equipment.getItemName());
        equipValue.put(COLUMN_BODY_PART, String.valueOf(equipment.getBodyPart()));
        equipValue.put(COLUMN_PRICE, equipment.getPrice());

        getWritableDatabase().insertOrThrow(TABLE_NAME, null, equipValue);
    }

    public void deleteFromDatabase(GymEquipment equipment) {
        String deleteCommand = resources.getString(R.string.database_delete_item,
                TABLE_NAME, COLUMN_ID, equipment.getEquipmentID());
        getWritableDatabase().execSQL(deleteCommand);
    }

    public List<GymEquipment> getAllItems() {
        List<GymEquipment> equip = new ArrayList<>();

        String selectAll = resources.getString(R.string.database_select_all, TABLE_NAME);
        Cursor equipCursor = getReadableDatabase().rawQuery(selectAll, null, null);
        equipCursor.move(-1);

        while (equipCursor.moveToNext()) {
            int id = equipCursor.getInt(equipCursor.getColumnIndex(COLUMN_ID));
            String itemName = equipCursor.getString(equipCursor.getColumnIndex(COLUMN_ITEM_NAME));
            String bodyPart = equipCursor.getString(equipCursor.getColumnIndex(COLUMN_BODY_PART));
            double price = Double.parseDouble(equipCursor.getString(equipCursor.getColumnIndex(COLUMN_PRICE)));

            equip.add(new GymEquipment(id,itemName, bodyPart, price));
        }

        return equip;
    }
}
