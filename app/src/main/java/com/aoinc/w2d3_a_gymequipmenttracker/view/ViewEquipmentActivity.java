package com.aoinc.w2d3_a_gymequipmenttracker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aoinc.w2d3_a_gymequipmenttracker.R;
import com.aoinc.w2d3_a_gymequipmenttracker.model.GymEquipment;
import com.aoinc.w2d3_a_gymequipmenttracker.model.db.EquipmentDatabaseHelper;
import com.aoinc.w2d3_a_gymequipmenttracker.view.adapter.GymEquipmentItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewEquipmentActivity extends AppCompatActivity implements GymEquipmentItemAdapter.GymEquipmentDelegate {

    private EquipmentDatabaseHelper equipmentDatabaseHelper;

    @BindView(R.id.equipment_listView)
    public ListView equipmentListView;

    private List<GymEquipment> purchasedEquipment = new ArrayList<>();
    private GymEquipmentItemAdapter equipmentArrayAdapter;

    @BindView(R.id.total_cost_textView)
    public TextView totalCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_equipment);

        ButterKnife.bind(this);

        equipmentDatabaseHelper = new EquipmentDatabaseHelper(this);
        purchasedEquipment = equipmentDatabaseHelper.getAllItems();
        Log.d("get_equip", String.valueOf(purchasedEquipment.size()));
        Log.d("get_equip", String.valueOf(purchasedEquipment.get(0).getPrice()));
        equipmentArrayAdapter = new GymEquipmentItemAdapter(purchasedEquipment, this);
        equipmentListView.setAdapter(equipmentArrayAdapter);

        double totalCost = 0;
        for (GymEquipment ge : purchasedEquipment) {
            totalCost += ge.getPrice();
        }

        totalCostTextView.setText(getResources().getString(R.string.total_cost, totalCost));
    }

    @OnClick(R.id.list_done_imageButton)
    public void onDoneViewing (View view) {
        finish();
    }

    public static final String TAG_DETAIL_ITEM = "detail item";

    @Override
    public void SelectGymEquipment(GymEquipment selectedEquipment) {
        Intent intent = new Intent(this, EquipmentDetailActivity.class);
        intent.putExtra(TAG_DETAIL_ITEM, selectedEquipment);
        startActivity(intent);
    }
}