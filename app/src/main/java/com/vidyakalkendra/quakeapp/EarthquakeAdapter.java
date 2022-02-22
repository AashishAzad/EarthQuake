package com.vidyakalkendra.quakeapp;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.ViewHolder> {

    Context context;
    ArrayList<Earthquake> earthquakes;

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        this.context = context;
        this.earthquakes = earthquakes;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quake_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Earthquake earthquake = earthquakes.get(position);

        holder.magnitude.setText(String.valueOf(earthquake.getMagnitude()));
        String color = getBackgroundColor(earthquake.getMagnitude());

        holder.magnitudeCard.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color)));

//        GradientDrawable magnitudeCircle = (GradientDrawable) holder.magnitude.getBackground();
//        int magnitudeColor = getBackgroundColor(earthquake.getMagnitude());
//        magnitudeCircle.setColor(magnitudeColor);



        holder.location.setText(earthquake.getLocation());


        Date date = new Date(earthquake.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String formatedDate = dateFormat.format(date);
        holder.date.setText(formatedDate);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri earthquakeURL = Uri.parse(earthquake.getUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW,earthquakeURL);
                context.startActivity(webIntent);
            }
        });
    }

    private String getBackgroundColor(double magnitude) {
        String magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = "#4A7BA7";
                break;
            case 2:
                magnitudeColorResourceId = "#04B4B3";
                break;
            case 3:
                magnitudeColorResourceId = "#10CAC9";
                break;
            case 4:
                magnitudeColorResourceId = "#F5A623";
                break;
            case 5:
                magnitudeColorResourceId = "#FF7D50";
                break;
            case 6:
                magnitudeColorResourceId = "#FC6644";
                break;
            case 7:
                magnitudeColorResourceId = "#E75F40";
                break;
            case 8:
                magnitudeColorResourceId = "#E13A20";
                break;
            case 9:
                magnitudeColorResourceId = "#D93218";
                break;
            default:
                magnitudeColorResourceId = "#C03823";
                break;
        }

        return magnitudeColorResourceId;
    }

    @Override
    public int getItemCount() {
        return earthquakes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView magnitude, location_offset, location, date, time;
        MaterialCardView magnitudeCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            magnitude = itemView.findViewById(R.id.magnitude);
            location = itemView.findViewById(R.id.location);
            date = itemView.findViewById(R.id.date);
            magnitudeCard =itemView.findViewById(R.id.magnitude_card);

        }

    }

}


