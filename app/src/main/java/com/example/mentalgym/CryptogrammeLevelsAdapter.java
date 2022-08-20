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
    private final CryptogrammeLevelsInterface cryptogrammeLevelsInterface;
    Context context;
    ArrayList<CryptogrammeLevel> cryptogrammeLevels;

    public CryptogrammeLevelsAdapter(CryptogrammeLevelsInterface cryptogrammeLevelsInterface, Context context, ArrayList<CryptogrammeLevel> cryptogrammeLevels) {
        this.cryptogrammeLevelsInterface = cryptogrammeLevelsInterface;
        this.context = context;
        this.cryptogrammeLevels = cryptogrammeLevels;
    }

    @NonNull
    @Override
    public CryptogrammeLevelsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.cryptogrammeonelevel , parent , false);
        return new CryptogrammeLevelsAdapter.MyViewHolder(view, cryptogrammeLevelsInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptogrammeLevelsAdapter.MyViewHolder holder, int position) {
        holder.nameView.setText(cryptogrammeLevels.get(position).getName());
        holder.imageView.setImageResource(cryptogrammeLevels.get(position).getImage());
        if ( cryptogrammeLevels.get(position).getCanPlay()) holder.lockView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return cryptogrammeLevels.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        ImageView lockView;
        TextView nameView;

        public MyViewHolder(@NonNull View itemView ,CryptogrammeLevelsInterface cryptogrammeLevelsInterface ) {
            super(itemView);
            imageView = itemView.findViewById(R.id.levelimage);
            nameView =itemView.findViewById(R.id.levelText);
            lockView = itemView.findViewById(R.id.lock);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cryptogrammeLevelsInterface != null){
                        int pos =getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            cryptogrammeLevelsInterface.onItemClick((pos));
                        }

                    }
                }
            });
        }
    }
}
