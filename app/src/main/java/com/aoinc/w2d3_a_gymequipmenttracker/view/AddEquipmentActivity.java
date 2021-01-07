package com.aoinc.w2d3_a_gymequipmenttracker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.aoinc.w2d3_a_gymequipmenttracker.R;
import com.aoinc.w2d3_a_gymequipmenttracker.model.GymEquipment;
import com.aoinc.w2d3_a_gymequipmenttracker.model.db.EquipmentDatabaseHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddEquipmentActivity extends AppCompatActivity {

    @BindView(R.id.equipment_type_editText)
    public EditText equipmentType;

    @BindView(R.id.body_part_editText)
    public EditText bodyPart;

    @BindView(R.id.equipment_price_editText)
    public EditText price;

    EquipmentDatabaseHelper equipmentDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_equipment);

        ButterKnife.bind(this);
        equipmentDatabaseHelper = new EquipmentDatabaseHelper(this);
    }

    @OnClick(R.id.add_equipment_to_db_imageButton)
    public void onAddEquipmentItem (View view) {
        GymEquipment item = new GymEquipment(equipmentType.getText().toString(),
                bodyPart.getText().toString(), Double.parseDouble(price.getText().toString()));

        equipmentDatabaseHelper.insertIntoDatabase(item);
        Toast.makeText(this, R.string.item_added_toast, Toast.LENGTH_SHORT).show();
        finish();
    }
}