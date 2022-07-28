package com.example.linkplace.View.Fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MainActivity;
import com.example.linkplace.View.Activity.MyProfileActivity;

import java.io.ByteArrayOutputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfileImageSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfileImageSetFragment extends Fragment {
        ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
        Button myprofileinputimagebtn, imagecompletebtn;
        LinearLayout inputauthbirthtext, inputauthbirthtext2, inputauthbirthtext3;
        TextView mainimage;

        private int GALLEY_CODE = 10;
        static final int PERMISSIONS_REQUEST = 0x00000001;
        private String imageUrl="";
        int imagecount = 0;

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

        // TODO: Rename and change types of parameters

        public MyProfileImageSetFragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ProfileBirthSetFragment.
         */
        // TODO: Rename and change types and number of parameters

        public static MyProfileImageSetFragment newInstance() {
            return new MyProfileImageSetFragment();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_my_profile_image_set, container, false);
//        profile_year = view.findViewById(R.id.profile_year);
//        profile_month = view.findViewById(R.id.profile_month);
//        profile_day = view.findViewById(R.id.profile_day);
            myprofileinputimagebtn = view.findViewById(R.id.myprofileinputimagebtn);
            imagecompletebtn = view.findViewById(R.id.imagecompletebtn);
            String imgName = "osz.png";

            image1 = view.findViewById(R.id.myprofileimage1);
            image2 = view.findViewById(R.id.myprofileimage2);
            mainimage = view.findViewById(R.id.mainimage);



            try {
                String imgpath = getActivity().getCacheDir() + "/" + imgName;   // 내부 저장소에 저장되어 있는 이미지 경로
                Bitmap bm = BitmapFactory.decodeFile(imgpath);
                image1.setImageBitmap(bm);   // 내부 저장소에 저장된 이미지를 이미지뷰에 셋
                Toast.makeText(getContext(), "파일 로드 성공", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(getContext(), "파일 로드 실패", Toast.LENGTH_SHORT).show();
            }



            myprofileinputimagebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                    startActivityForResult(intent, GALLEY_CODE);
                }
            });

            imagecompletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    Bitmap bitmap = ((BitmapDrawable)image1.getDrawable()).getBitmap();
                    float scale = (float) (1024/(float)bitmap.getWidth());
                    int image_w = (int) (bitmap.getWidth() * scale);
                    int image_h = (int) (bitmap.getHeight() * scale);
                    Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                    resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();

                    Intent intent = new Intent(getContext(), MyProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.putExtra("image1", byteArray);
                    startActivity(intent);
                }
            });

            return view;
        }





        public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            switch (requestCode) {
                case PERMISSIONS_REQUEST:
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getContext(), "앱 실행을 위한 권한이 설정 되었습니다.", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getContext(), "앱 실행을 위한 권한이 취소 되었습니다.", Toast.LENGTH_LONG).show();
                    }

                    break;
            }
        }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == GALLEY_CODE)
        {
            try {
                imageUrl = getRealPathFromUri(data.getData());
                switch (imagecount) {
                    case 0:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image1);
                        imagecount++;
                        mainimage.setVisibility(View.VISIBLE);
                        imagecompletebtn.setEnabled(true);
                        imagecompletebtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                        break;
                    case 1:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image2);
//                        deletebtn2.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 2:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image3);
//                        deletebtn3.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 3:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image4);
//                        deletebtn4.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 4:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image5);
//                        deletebtn5.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 5:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image6);
//                        deletebtn6.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 6:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image7);
//                        deletebtn7.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 7:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image8);
//                        deletebtn8.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 8:
                        Glide.with(getContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image9);
//                        deletebtn9.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                }

            } catch (NullPointerException e)
            {
                Toast.makeText(getContext(), "이미지 선택 안함", Toast.LENGTH_SHORT).show();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private String getRealPathFromUri(Uri uri)
    {
        String[] proj=  {MediaStore.Images.Media.DATA};
        CursorLoader cursorLoader = new CursorLoader(getContext(),uri,proj,null,null,null);
        Cursor cursor = cursorLoader.loadInBackground();

        int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String url = cursor.getString(columnIndex);
        cursor.close();
        return  url;
    }



}