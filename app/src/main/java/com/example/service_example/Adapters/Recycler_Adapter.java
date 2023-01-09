package com.example.service_example.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.service_example.Model.Recycle_model;
import com.example.service_example.R;

import java.util.ArrayList;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder>{

    Context context;
    ArrayList<Recycle_model> details;

    public Recycler_Adapter(Context context , ArrayList<Recycle_model> details) {
        this.details=details;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Adapter.ViewHolder holder, int position) {
        Recycle_model model = details.get(position);
        String name= model.getName();
        String email= model.getEmail();
        String mobile= model.getMobile();

        holder.txt_name.setText(name);
        holder.txt_email.setText(email);
        holder.txt_mobile.setText(mobile);

    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_name,txt_email,txt_mobile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.name_txt);
            txt_email = itemView.findViewById(R.id.email_txt);
            txt_mobile = itemView.findViewById(R.id.mobile_txt);

        }
    }
}
