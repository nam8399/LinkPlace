package com.example.linkplace.View.Fragment;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.example.linkplace.View.Model.ProfileData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
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
    String name, age, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet;

    private int GALLEY_CODE = 10;
    static final int PERMISSIONS_REQUEST = 0x00000001;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        databaseReference.child(uid).child("ProfileData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ProfileData profileData1 = dataSnapshot.getValue(ProfileData.class);

                //각각의 값 받아오기 get어쩌구 함수들은 intakegroup.class에서 지정한것
                name = profileData1.getName();
                age = profileData1.getBirth();
                gender = profileData1.getGender();
                job = profileData1.getJob();
                charactor = profileData1.getHobby();
                hobby = profileData1.getHobby();
                wantfriend = profileData1.getWantfriend();
                ImageUrl = profileData1.getImageUrl();
                education = profileData1.getEducation();
                religion = profileData1.getReligion();
                drink = profileData1.getDrink();
                smoke = profileData1.getSmoke();
                pet = profileData1.getPet();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
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


    public void updateFirebase(int index) {
        Drawable image = image1.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        databaseReference.child("image").setValue(simage);
    }

    public static String byteArrayToBinaryString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; ++i) {
            sb.append(byteToBinaryString(b[i]));
        }
        return sb.toString();
    }

    // 바이너리 바이트를 스트링으로
    public static String byteToBinaryString(byte n) {
        StringBuilder sb = new StringBuilder("00000000");
        for (int bit = 0; bit < 8; bit++) {
            if (((n >> bit) & 1) > 0) {
                sb.setCharAt(7 - bit, '1');
            }
        }
        return sb.toString();
    }



}