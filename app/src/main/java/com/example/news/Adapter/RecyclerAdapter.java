package com.example.news.Adapter;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news.Models.BannerDetails;
import com.example.news.R;
import com.example.news.ui.Article;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final Fragment context;
    private ArrayList<BannerDetails> listdata;
    //Context context;


    // RecyclerView recyclerView;
    public RecyclerAdapter(Fragment context, ArrayList<BannerDetails> listdata) {

        this.context=context;
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.banner, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final BannerDetails myListData = listdata.get(position);
        holder.textView.setText(myListData.getHeadline());
        Log.e("context",context+"");
        Glide
                .with(context)
                .load(myListData.getImgLink())
                .centerCrop()
                .into(holder.imageView);



        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int productId= listdata.get(position).getId();
                String url=listdata.get(position).getUrl();
                Article Frag=new Article();
                Bundle args=new Bundle();
                args.putString("id",url);
                Frag.setArguments(args);
                context.getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,Frag)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();

            }
        });
    }

    //holder.imageView.setImageResource(listdata[position].getImgId());


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public LinearLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.img);
            this.textView = (TextView) itemView.findViewById(R.id.headline);

            //this.price=(TextView)itemView.findViewById(R.id.textView3);
            this.layout=(LinearLayout)itemView.findViewById(R.id.layoutBanner);
        }

    }
}
