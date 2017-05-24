package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class GovernorateAdapter extends ArrayAdapter<GovernorateItem> {

    int ColorResourseID;

    public GovernorateAdapter(@NonNull Context context, @NonNull ArrayList<GovernorateItem> objects, int colorResource) {
        super(context, 0, objects);
        this.ColorResourseID = colorResource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.governorate_item_list, parent, false);
        }

        GovernorateItem governorateItem = getItem(position);

        TextView textView = (TextView) listItemView.findViewById(R.id.governorateId);
        textView.setText(governorateItem.getName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(governorateItem.getImage());

        RelativeLayout relativeLayout = (RelativeLayout) listItemView.findViewById(R.id.list_item_color);
        int color = ContextCompat.getColor(getContext(), ColorResourseID);

        relativeLayout.setBackgroundColor(color);

        ImageView icon = (ImageView) listItemView.findViewById(R.id.icon);
        icon.setImageResource(android.R.drawable.ic_media_play);
        return listItemView;
    }
}
