package com.linkple.linkplace.View.Model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linkple.linkplace.R;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static com.linkple.linkplace.View.Activity.MyProfileActivity.binaryStringToByteArray;

public class FriendImageAdapter extends RecyclerView.Adapter<FriendImageAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView_item;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView_item = (ImageView) itemView.findViewById(R.id.friendimage);
        }
    }

    private ArrayList<FriendImageItem> mList = null;

    public FriendImageAdapter(ArrayList<FriendImageItem> mList) {
        this.mList = mList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.friendimage_item, parent, false);
        FriendImageAdapter.ViewHolder vh = new FriendImageAdapter.ViewHolder(view);
        return vh;
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull FriendImageAdapter.ViewHolder holder, int position) {
        FriendImageItem item = mList.get(position);

        byte[] b = binaryStringToByteArray(item.getImgName());
        ByteArrayInputStream is = new ByteArrayInputStream(b);
        Drawable reviewImage2 = Drawable.createFromStream(is, "reviewImage");
        holder.imgView_item.setImageDrawable(reviewImage2);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}