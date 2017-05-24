package com.example.android.tourguide;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class HisPlaceAdapter extends RecyclerView.Adapter<HisPlaceAdapter.mViewHolder> {
    ArrayList<HisPlace> list;

    public HisPlaceAdapter(ArrayList<HisPlace> list) {
        this.list = list;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        mViewHolder viewHolder = new mViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        holder.mItem = list.get(position);
        holder.name.setText(list.get(position).getName() + "");
        holder.imageView.setImageResource(list.get(position).getImageResId());
        holder.address.setText(list.get(position).getAddress() + "");
        if (list.get(position).getYear() == "") {
            holder.year.setVisibility(View.GONE);
        }
        holder.year.setText(list.get(position).getYear() + "");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        final Context context;

        ImageView imageView;
        TextView address;
        TextView name;
        TextView year;
        CardView cardView;
        public HisPlace mItem;

        public mViewHolder(View v) {

            super(v);
            context = itemView.getContext();
            cardView = (CardView) v.findViewById(R.id.card_view);

            imageView = (ImageView) v.findViewById(R.id.cover);

            address = (TextView) v.findViewById(R.id.address);

            name = (TextView) v.findViewById(R.id.place_name);

            year = (TextView) v.findViewById(R.id.year);

        }
    }

}
