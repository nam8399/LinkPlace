package com.example.linkplace.View.Model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.linkplace.R;

public class FriendViewHolder extends RecyclerView.ViewHolder {

    TextView friendname, friendage, friendgender, friendcontent;

    ImageView ivIcon;

    public FriendViewHolder(View a_itemView) {
        super(a_itemView);

        ivIcon = a_itemView.findViewById(R.id.iv_icon);
        friendname = a_itemView.findViewById(R.id.friendname);
        friendage = a_itemView.findViewById(R.id.friendage);
        friendgender = a_itemView.findViewById(R.id.friendgender);
        friendcontent = a_itemView.findViewById(R.id.friendintroduce);
    }

}