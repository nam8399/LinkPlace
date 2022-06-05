package com.example.linkplace.View.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linkplace.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FriendViewAdapter extends RecyclerView.Adapter<FriendViewHolder> {

    private List<friendItem> mItemList;

    public FriendViewAdapter(List<friendItem> a_list) {
        mItemList = a_list;
    }

    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_viewType) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.recommendfriend, a_viewGroup, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FriendViewHolder holder, int position) {
        final friendItem item = mItemList.get(position);

        holder.ivIcon.setImageResource(item.getImageResId());
        holder.friendname.setText(item.getName());
        holder.friendage.setText(item.getAge());
        holder.friendgender.setText(item.getGender());
        holder.friendcontent.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
