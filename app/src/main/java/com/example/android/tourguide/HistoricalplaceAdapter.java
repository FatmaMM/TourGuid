package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.tourguide.R.id.king;


public class HistoricalplaceAdapter extends ArrayAdapter<HisPlace> {

    public HistoricalplaceAdapter(@NonNull Context context, @NonNull ArrayList<HisPlace> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {
        View listItemView = v;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card, parent, false);
        }
        final HisPlace hisPlace = getItem(position);
        ImageView imageView;
        TextView address;
        TextView name;
        TextView year;

        imageView = (ImageView) listItemView.findViewById(R.id.cover);

        address = (TextView) listItemView.findViewById(R.id.address);

        name = (TextView) listItemView.findViewById(R.id.place_name);

        year = (TextView) listItemView.findViewById(R.id.year);

        name.setText(hisPlace.getName() + "");
        imageView.setImageResource(hisPlace.getImageResId());
        address.setText(hisPlace.getAddress() + "");

        year.setText(hisPlace.getYear() + "");
        CardView card = (CardView) listItemView.findViewById(R.id.card_view);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), InformationAboutPlace.class);
                intent.putExtra("placename", hisPlace.getName());
                intent.putExtra("Address", hisPlace.getAddress());
                intent.putExtra("id", hisPlace.getId());
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
