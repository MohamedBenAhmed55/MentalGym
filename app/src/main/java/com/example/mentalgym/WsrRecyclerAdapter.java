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

public class WsrRecyclerAdapter extends RecyclerView.Adapter<WsrRecyclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<WsrModel> WsrModels;
    private  WsrRecyclerInterface recyclerInterface;

    public WsrRecyclerAdapter(WsrRecyclerInterface recyclerInterface, Context context, ArrayList<WsrModel> wsrModels ) {
        this.context = context;
        WsrModels = wsrModels;
        this.recyclerInterface = recyclerInterface;
    }

    @NonNull
    @Override
    public WsrRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.wsr_recycle_row,parent,false);
        return new WsrRecyclerAdapter.MyViewHolder(view,recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull WsrRecyclerAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(WsrModels.get(position).getLevel());
    }

    @Override
    public int getItemCount() {
        return WsrModels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;

        public MyViewHolder(@NonNull View itemView, WsrRecyclerInterface RecyclerInterface) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(RecyclerInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            RecyclerInterface.onItemClick((pos));
                        }}
                }
            });

        }
    }
}
