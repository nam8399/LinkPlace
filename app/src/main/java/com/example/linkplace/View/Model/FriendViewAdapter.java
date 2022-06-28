package com.example.linkplace.View.Model;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linkplace.R;
import com.example.linkplace.View.Activity.FriendActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FriendViewAdapter extends RecyclerView.Adapter<FriendViewHolder> {

    private List<friendItem> mItemList;
    private Intent intent;

    public FriendViewAdapter(List<friendItem> a_list) {
        mItemList = a_list;
    }

    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_viewType) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.recommendfriend, a_viewGroup, false);
        return new FriendViewHolder(view);
    }

    interface OnItemClickListener{
        void onItemClick(View v, int position); //뷰와 포지션값
    }
    //리스너 객체 참조 변수
    private OnItemClickListener mListener = null;
    //리스너 객체 참조를 어댑터에 전달 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FriendViewHolder holder, int position) {
        final friendItem item = mItemList.get(position);

        holder.ivIcon.setImageResource(item.getImageResId());
        holder.friendname.setText(item.getName());
        holder.friendage.setText(item.getAge());
        holder.friendgender.setText(item.getGender());
        if (item.getGender().equals("남성")) {
            holder.friendgender.setTextColor(ColorStateList.valueOf(Color.parseColor("#0062D7")));
        }
        holder.friendcontent.setText(item.getContent());
        holder.friendlockcount.setText(item.getLockcount());

        holder.friendlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), FriendActivity.class);
                intent.putExtra("number", position);
                intent.putExtra("name",mItemList.get(position).getName());
                intent.putExtra("age", mItemList.get(position).getAge());
                intent.putExtra("gender", mItemList.get(position).getGender());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

}
