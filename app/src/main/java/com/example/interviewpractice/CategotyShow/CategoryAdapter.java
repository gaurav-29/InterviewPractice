package com.example.interviewpractice.CategotyShow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.databinding.RowCategoryBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemViewHolder> {
    RowCategoryBinding mBinding;
    ArrayList<CategoryModel.Data> dataList;
    Context context;

    public CategoryAdapter(ArrayList<CategoryModel.Data> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_category,parent,false);
        return new ItemViewHolder(mBinding.getRoot(), mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.mBinding.tvCategory.setText(dataList.get(position).name);
        Glide.with(context).load("https://www.nihareeka.com/public/"+
                dataList.get(position).icon).placeholder(R.drawable.img_placeholder).into(holder.mBinding.ivCategory);
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        RowCategoryBinding mBinding;
        public ItemViewHolder(@NonNull View itemView, RowCategoryBinding mBinding) {
            super(itemView);
            this.mBinding = mBinding;
        }
    }
}
