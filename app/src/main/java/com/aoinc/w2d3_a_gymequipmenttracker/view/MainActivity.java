package com.aoinc.w2d3_a_gymequipmenttracker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.aoinc.w2d3_a_gymequipmenttracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_equipment_imageButton)
    public void onAddEquipment (View view) {
        startActivity(new Intent(this, AddEquipmentActivity.class));
    }

    @OnClick(R.id.view_equipment_imageButton)
    public void onViewEquipment (View view) {
        startActivity(new Intent(this, ViewEquipmentActivity.class));
    }
}