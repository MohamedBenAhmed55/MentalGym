package com.example.mentalgym;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CryptogrammeLevelsAdapter extends RecyclerView.Adapter<CryptogrammeLevelsAdapter.MyViewHolder> {
    Context context;
    ArrayList<CryptogrammeLevel> cryptogrammeLevels;

    public CryptogrammeLevelsAdapter(Context context, ArrayList<CryptogrammeLevel> cryptogrammeLevels) {
        this.context = context;
        this.cryptogrammeLevels = cryptogrammeLevels;
    }

    @NonNull
    @Override
    public CryptogrammeLevelsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.cryptogrammeonelevel , parent , false);
        return new CryptogrammeLevelsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptogrammeLevelsAdapter.MyViewHolder holder, int position) {
        holder.nameView.setText(cryptogrammeLevels.get(position).getName());
        holder.imageView.setImageResource(cryptogrammeLevels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return cryptogrammeLevels.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nameView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.levelimage);
            nameView =itemView.findViewById(R.id.levelText);
        }
    }
}
