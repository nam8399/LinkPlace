package com.linkple.linkplace.View.Model;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Activity.FriendActivity;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.util.List;

import static com.linkple.linkplace.View.Activity.MyProfileActivity.binaryStringToByteArray;

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

        holder.friendname.setText(item.getName());
        holder.friendage.setText(item.getAge());
        holder.friendgender.setText(item.getGender());
        if (item.getGender().equals("남성")) {
            holder.friendgender.setTextColor(ColorStateList.valueOf(Color.parseColor("#0062D7")));
        }
        holder.friendcontent.setText(item.getContent());
        // name, age, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, introduce, career;
        holder.friendlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), FriendActivity.class);
                intent.putExtra("number", position);
                intent.putExtra("name",mItemList.get(position).getName());
                intent.putExtra("age", mItemList.get(position).getAge());
                intent.putExtra("gender", mItemList.get(position).getGender());
                intent.putExtra("content", mItemList.get(position).getContent());
                intent.putExtra("job", mItemList.get(position).getStrJob());
                intent.putExtra("charactor", mItemList.get(position).getStrCharactor());
                intent.putExtra("hobby", mItemList.get(position).getStrHobby());
                intent.putExtra("wantfriend", mItemList.get(position).getStrWantfriend());
//                intent.putExtra("ImageUrl", mItemList.get(position).getStrImageUrl());
                intent.putExtra("education", mItemList.get(position).getStrEducation());
                intent.putExtra("religion", mItemList.get(position).getStrReligion());
                intent.putExtra("drink", mItemList.get(position).getStrDrink());
                intent.putExtra("smoke", mItemList.get(position).getStrSmoke());
                intent.putExtra("pet", mItemList.get(position).getStrPet());
                intent.putExtra("career", mItemList.get(position).getStrCareer());
                intent.putExtra("key", mItemList.get(position).getStrKey());

                v.getContext().startActivity(intent);
            }
        });

        Log.d("FriendViewAdapter", "FriendViewAdapter ImageURL : " + mItemList.get(position).getStrImageUrl());
        String imageUrlList[] = mItemList.get(position).getStrImageUrl().split(",");
        for (int i = 0; i < imageUrlList.length; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            switch (i) {
                case 0:
                    byte[] b = binaryStringToByteArray(imageUrlList[i]);
                    ByteArrayInputStream is = new ByteArrayInputStream(b);
                    Drawable reviewImage = Drawable.createFromStream(is, "reviewImage");
                    holder.ivIcon.setImageDrawable(reviewImage);
                    holder.ivIcon.setOutlineProvider(new ViewOutlineProvider() {
                        @Override
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                        }
                    });
                    holder.ivIcon.setClipToOutline(true);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

}
