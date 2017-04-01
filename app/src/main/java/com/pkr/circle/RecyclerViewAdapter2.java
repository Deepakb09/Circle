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
 * Created by Prashant on 3/28/2017.
 */

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {
	private Context context2;
    private String[] topTile2;
    private int[] topTile_cover2;
    private View view2;
    private ViewHolder viewHolder2;
//    ItemClickListener itemClickListener;


    public RecyclerViewAdapter2(Context context2, String[] topTile2, int[] topTile_cover2) {
        this.context2 = context2;
        this.topTile2 = topTile2;
        this.topTile_cover2 = topTile_cover2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view2 = LayoutInflater.from(context2).inflate(R.layout.single_item2, parent, false);
        viewHolder2 = new ViewHolder(view2);
        return viewHolder2;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView2.setText(topTile2[position]);
        holder.topTile_cover2.setImageResource(topTile_cover2[position]);
    }

    @Override
    public int getItemCount() {
        return topTile2.length;
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

        TextView textView2;
        CardView card2;
        ImageView topTile_cover2;

        public ViewHolder(View itemView) {
            super(itemView);
            card2 = (CardView) itemView.findViewById(R.id.single_item_card2);
            textView2 = (TextView) itemView.findViewById(R.id.top_tile_text2);
            topTile_cover2= (ImageView) itemView.findViewById(R.id.topTile_cover2);
        }
    }
}
