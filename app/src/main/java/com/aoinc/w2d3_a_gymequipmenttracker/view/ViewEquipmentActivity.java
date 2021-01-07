package com.aoinc.w2d3_a_gymequipmenttracker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aoinc.w2d3_a_gymequipmenttracker.R;
import com.aoinc.w2d3_a_gymequipmenttracker.model.GymEquipment;
import com.aoinc.w2d3_a_gymequipmenttracker.model.db.EquipmentDatabaseHelper;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewEquipmentActivity extends AppCompatActivity {

    private EquipmentDatabaseHelper equipmentDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_equipment);

        ButterKnife.bind(this);

        equipmentDatabaseHelper = new EquipmentDatabaseHelper(this);
        List<GymEquipment> purchasedEquipment = equipmentDatabaseHelper.getAllItems();
        Log.d("get_equip", String.valueOf(purchasedEquipment.size()));
    }

    @OnClick(R.id.list_done_imageButton)
    public void onDoneViewing (View view) {
        finish();
    }
}