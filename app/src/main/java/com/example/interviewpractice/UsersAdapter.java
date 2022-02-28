package com.example.interviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewpractice.databinding.RowUserdataBinding;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ItemViewHolder> {

    ArrayList<Users.Data2> userList;
    Context context;
    RowUserdataBinding binding;

    public UsersAdapter(ArrayList<Users.Data2> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.row_userdata, parent, false);
        return new ItemViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.binding.tvName.setText(userList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        RowUserdataBinding binding;
        public ItemViewHolder(@NonNull View itemView, RowUserdataBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }
}
