package com.example.ageofempires2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Civilizations> allCivilizations;
    private Context context;

    public Adapter(Context ctx, List<Civilizations> civilizationsData){
        this.allCivilizations = civilizationsData;
        this.context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.civilization_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleName.setText(allCivilizations.get(position).getName());

        holder.vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context, DetailedCivilization.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return allCivilizations.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView titleName;
        View vv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleName = itemView.findViewById(R.id.civilizationUniqueUnits);
            vv = itemView;



        }
    }
}
