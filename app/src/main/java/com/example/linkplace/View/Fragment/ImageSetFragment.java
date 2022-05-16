package com.example.linkplace.View.Fragment;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.linkplace.R;
import com.example.linkplace.View.Activity.MainActivity;

import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileBirthSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageSetFragment extends Fragment {
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    Button back_button, inputimagebtn;
    LinearLayout inputauthbirthtext, inputauthbirthtext2, inputauthbirthtext3;

    private int GALLEY_CODE = 10;
    static final int PERMISSIONS_REQUEST = 0x00000001;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public ImageSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileBirthSetFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static ImageSetFragment newInstance() {
        return new ImageSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_set, container, false);
//        profile_year = view.findViewById(R.id.profile_year);
//        profile_month = view.findViewById(R.id.profile_month);
//        profile_day = view.findViewById(R.id.profile_day);
        back_button = view.findViewById(R.id.back_button);
        inputimagebtn = view.findViewById(R.id.inputimagebtn);
        String imgName = "osz.png";

        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);
        image3 = view.findViewById(R.id.image3);
        image4 = view.findViewById(R.id.image4);
        image5 = view.findViewById(R.id.image5);
        image6 = view.findViewById(R.id.image6);
        image7 = view.findViewById(R.id.image7);
        image8 = view.findViewById(R.id.image8);
        image9 = view.findViewById(R.id.image9);



        try {
            String imgpath = getActivity().getCacheDir() + "/" + imgName;   // 내부 저장소에 저장되어 있는 이미지 경로
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            image1.setImageBitmap(bm);   // 내부 저장소에 저장된 이미지를 이미지뷰에 셋
            Toast.makeText(getContext(), "파일 로드 성공", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getContext(), "파일 로드 실패", Toast.LENGTH_SHORT).show();
        }

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(FriendCharacterFragment.newInstance());
            }
        });



        inputimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);

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






}