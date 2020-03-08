package com.example.pahlawann;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private ArrayList<Heroes> listHero = new ArrayList<>();
    private Context context;

    public HeroesAdapter(Context context){
        this.context = context;
    }

    public ArrayList<Heroes> getListHero(){ return listHero; }

    public void setListHero(ArrayList<Heroes> listHero) {
        this.listHero = listHero;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_listpahlawan, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(getListHero().get(i).getHeroImage()).into(viewHolder.ivThumbnail);
        viewHolder.tvTitle.setText(getListHero().get(i).getHeroName());
        viewHolder.btnShow.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPahlawan.class);
                intent.putExtra("img_url", getListHero().get(i).getHeroImage());
                intent.putExtra("title", getListHero().get(i).getHeroName());
                intent.putExtra("detail", getListHero().get(i).getHeroDetail());
                context.startActivity(intent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick (View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String heroName = "INI PAHLAWAN" + getListHero().get(i).getHeroName();
                intent.putExtra(Intent.EXTRA_TEXT, heroName);
                context.startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() { return getListHero().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbnail;
        TextView tvTitle;
        Button btnShow,btnShare;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.image1);
            tvTitle = itemView.findViewById(R.id.tvNama);
            btnShow = itemView.findViewById(R.id.btn_lihat);
            btnShare = itemView.findViewById(R.id.btn_share);

        }
    }
}