package com.example.interviewpractice.NewsPractical;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ItemviewHolder> {

    ArrayList<NewsModel.Article> newsList;
    Context context;
    int totalResults;

    public NewsAdapter(ArrayList<NewsModel.Article> newsList, Context context, int totalResults) {
        this.newsList = newsList;
        this.context = context;
        this.totalResults = totalResults;
    }

    @NonNull
    @Override
    public ItemviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.row_news, parent, false);
        ItemviewHolder viewHolder = new ItemviewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemviewHolder holder, int position) {
        //holder.tvTotalResults.setText(String.valueOf(totalResults));
        holder.tvTitle.setText(newsList.get(position).title);
        holder.tvPublisher.setText(newsList.get(position).source.name);
        holder.tvDate.setText(newsList.get(position).publishedAt);
        Glide.with(context).load(newsList.get(position).urlToImage).centerCrop().placeholder(R.drawable.img_placeholder).into(holder.ivNews);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, NewsDetailActivity.class);
                i.putExtra("image", newsList.get(position).urlToImage);
                i.putExtra("author", newsList.get(position).author);
                i.putExtra("title", newsList.get(position).title);
                i.putExtra("description", newsList.get(position).description);
                i.putExtra("url", newsList.get(position).url);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ItemviewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvPublisher, tvDate;
        ImageView ivNews;
        public ItemviewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPublisher = itemView.findViewById(R.id.tvPublisher);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivNews = itemView.findViewById(R.id.ivNews);
        }
    }
}
