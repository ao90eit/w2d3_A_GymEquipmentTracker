package com.aoinc.w2d3_a_gymequipmenttracker.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoinc.w2d3_a_gymequipmenttracker.R;
import com.aoinc.w2d3_a_gymequipmenttracker.model.GymEquipment;

import java.util.List;

public class GymEquipmentItemAdapter extends BaseAdapter {
    private List<GymEquipment> purchasedGymEquipment;
    private GymEquipmentDelegate gymEquipmentDelegate;

    public interface GymEquipmentDelegate {
        void SelectGymEquipment(GymEquipment selectedEquipment);
    }

    public GymEquipmentItemAdapter(List<GymEquipment> purchasedGymEquipment, GymEquipmentDelegate gymEquipmentDelegate) {
        this.purchasedGymEquipment = purchasedGymEquipment;
        this.gymEquipmentDelegate = gymEquipmentDelegate;
    }

    @Override
    public int getCount() {
        return purchasedGymEquipment.size();
    }

    @Override
    public Object getItem(int position) {
        return purchasedGymEquipment.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GymEquipment item = purchasedGymEquipment.get(position);

        // why doesn't this work?
//        GymEquipment item = getItem(position);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gym_equipment_layout_item, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gymEquipmentDelegate.SelectGymEquipment(item);
            }
        });

        ImageView equipmentType = itemView.findViewById(R.id.equipment_list_icon_imageView);
        equipmentType.setImageResource(R.drawable.ic_tennis_shoes);

        TextView price = itemView.findViewById(R.id.equipment_list_price_textView);
        price.setText(String.format("%.2f", item.getPrice()));

        return itemView;
    }
}
