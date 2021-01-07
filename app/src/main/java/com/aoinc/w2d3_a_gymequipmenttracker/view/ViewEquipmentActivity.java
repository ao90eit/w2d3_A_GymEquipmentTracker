package com.aoinc.w2d3_a_gymequipmenttracker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aoinc.w2d3_a_gymequipmenttracker.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewEquipmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_equipment);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.list_done_imageButton)
    public void onDoneViewing (View view) {
        finish();
    }
}