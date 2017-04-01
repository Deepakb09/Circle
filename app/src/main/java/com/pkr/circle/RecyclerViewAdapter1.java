package com.pkr.circle;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Prashant on 3/22/2017.
 */

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context1;
    private String[] topTile1;
    private View view1;
    private RecyclerViewAdapter.ViewHolder viewHolder1;

    public RecyclerViewAdapter1(Context context1, String[] topTile1) {
        this.context1 = context1;
        this.topTile1 = topTile1;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view1 = LayoutInflater.from(context1).inflate(R.layout.single_item1, parent, false);
        viewHolder1 = new RecyclerViewAdapter.ViewHolder(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView.setText(topTile1[position]);
    }

    @Override
    public int getItemCount() {
        return topTile1.length;
    }
    public static class ViewHolder1 extends RecyclerView.ViewHolder{

        TextView textView1;
        CardView card1;
        ImageView topTile_cover1;

        public ViewHolder1(View itemView) {
            super(itemView);
            card1 = (CardView) itemView.findViewById(R.id.single_item_card1);
            textView1 = (TextView) itemView.findViewById(R.id.top_tile_text1);
            topTile_cover1 = (ImageView) itemView.findViewById(R.id.topTile_cover1);
        }
    }
}
