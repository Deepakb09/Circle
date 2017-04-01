package com.pkr.circle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Prashant on 3/21/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private String[] topTile;
    private int[] topTile_cover;
    private View view;
    private ViewHolder viewHolder;
//    ItemClickListener itemClickListener;

    public RecyclerViewAdapter(Context context, String[] topTile, int[] topTile_cover) {
        this.context = context;
        this.topTile = topTile;
        this.topTile_cover = topTile_cover;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("card", position + " ");
                Intent test = new Intent(v.getContext(), Place_view.class);
                Bundle bundle1 = new Bundle();
                Bundle bundle2 = new Bundle();
                bundle1.putString("location", topTile[position]);
                bundle2.putInt("location_pics", topTile_cover[position]);
                test.putExtra("data1", bundle1);
                test.putExtra("data2", bundle2);
                v.getContext().startActivity(test);
            }
        });
        holder.textView.setText(topTile[position]);
        holder.topTile_cover.setImageResource(topTile_cover[position]);
    }

    @Override
    public int getItemCount() {
        return topTile.length;
    }

//    @Override
//    public void onClick(View v) {
////        this.itemClickListener.onItemClick();
//    }
//
//    public void setItemClickListener(ItemClickListener ic){
//        this.itemClickListener=ic;
//    }
//
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        CardView card;
        ImageView topTile_cover;

        public ViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.single_item_card);
            textView = (TextView) itemView.findViewById(R.id.top_tile_text);
            topTile_cover = (ImageView) itemView.findViewById(R.id.topTile_cover);
        }
    }
}
