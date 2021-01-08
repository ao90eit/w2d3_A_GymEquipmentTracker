package com.aoinc.w2d3_a_gymequipmenttracker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aoinc.w2d3_a_gymequipmenttracker.R;
import com.aoinc.w2d3_a_gymequipmenttracker.model.GymEquipment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EquipmentDetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_id_textView)
    public TextView id;

    @BindView(R.id.detail_name_textView)
    public TextView name;

    @BindView(R.id.detail_body_part_textView)
    public TextView bodyPart;

    @BindView(R.id.detail_price_textView)
    public TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_detail);

        ButterKnife.bind(this);

        GymEquipment item = getIntent()
                .getParcelableExtra(ViewEquipmentActivity.TAG_DETAIL_ITEM);

        id.setText(String.valueOf(item.getEquipmentID()));
        name.setText(item.getItemName());
        bodyPart.setText(item.getBodyPart());
        price.setText(String.format("%.2f", item.getPrice()));
    }

    @OnClick(R.id.detail_done_imageButton)
    public void onDoneViewing (View view) {
        finish();
    }
}