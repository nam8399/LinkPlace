package com.example.linkplace.View.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.linkplace.R;
import com.example.linkplace.View.Fragment.FriendCharacterFragment;
import com.example.linkplace.View.Fragment.ProfileBirthSetFragment;
import com.example.linkplace.View.Model.ProfileData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;

public class ImageSetAcitivty extends AppCompatActivity {
    Button back_button, inputimagebtn, imagenextbtn;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    ImageView deletebtn1, deletebtn2, deletebtn3, deletebtn4, deletebtn5, deletebtn6, deletebtn7, deletebtn8, deletebtn9;
    TextView mainimage;

    private int GALLEY_CODE = 10;
    static final int PERMISSIONS_REQUEST = 0x00000001;
    private String imageUrl="";
    int imagecount = 0;

    String name, age, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_image_set);

        back_button = findViewById(R.id.back_button);
        inputimagebtn = findViewById(R.id.inputimagebtn);
        imagenextbtn = findViewById(R.id.imagenextbtn);
        String imgName = "osz.png";

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        mainimage = findViewById(R.id.mainimage);

        deletebtn1 = findViewById(R.id.deletebtn1);
        deletebtn2 = findViewById(R.id.deletebtn2);
        deletebtn3 = findViewById(R.id.deletebtn3);
        deletebtn4 = findViewById(R.id.deletebtn4);
        deletebtn5 = findViewById(R.id.deletebtn5);
        deletebtn6 = findViewById(R.id.deletebtn6);
        deletebtn7 = findViewById(R.id.deletebtn7);
        deletebtn8 = findViewById(R.id.deletebtn8);
        deletebtn9 = findViewById(R.id.deletebtn9);

        OnCheckPermission();

        mainimage.setVisibility(View.INVISIBLE);

        deletebtn1.setVisibility(View.INVISIBLE);
        deletebtn2.setVisibility(View.INVISIBLE);
        deletebtn3.setVisibility(View.INVISIBLE);
        deletebtn4.setVisibility(View.INVISIBLE);
        deletebtn5.setVisibility(View.INVISIBLE);
        deletebtn6.setVisibility(View.INVISIBLE);
        deletebtn7.setVisibility(View.INVISIBLE);
        deletebtn8.setVisibility(View.INVISIBLE);
        deletebtn9.setVisibility(View.INVISIBLE);

        imagenextbtn.setEnabled(false);

        Listener();

//        back_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((MainActivity)getActivity()).replaceFragment(FriendCharacterFragment.newInstance());
//            }
//        });



    }

    private void Listener() {
        inputimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);

                startActivityForResult(intent, GALLEY_CODE);
            }
        });

        image1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                imagecount = 0;
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, GALLEY_CODE);
                return true;
            }
        });

        deletebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainimage.setVisibility(View.INVISIBLE);
                deletebtn1.setVisibility(View.INVISIBLE);
                image1.setImageResource(0);
                imagecount = 0;
                imagenextbtn.setEnabled(false);
                imagenextbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
            }
        });

        deletebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!image3.getDrawable().equals(null)) {
                        Glide.with(getApplicationContext())
                                .load(image3.getDrawable())
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image2);
                        image3.setImageResource(0);
                        deletebtn3.setVisibility(View.INVISIBLE);
                    } else {
                        deletebtn2.setVisibility(View.INVISIBLE);
                        image2.setImageResource(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    deletebtn2.setVisibility(View.INVISIBLE);
                    image2.setImageResource(0);
                }


                imagecount--;
            }
        });

        imagenextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PlaceActivity.class);
                imageUrl = updateImage();
                addProfileData(name, age, gender, job, charactor, hobby, wantfriend, imageUrl, "", "", "", "", "");
                startActivity(intent);
                finish();
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
                charactor = profileData1.getCharactor();
                hobby = profileData1.getHobby();
                wantfriend = profileData1.getWantfriend();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }




    @RequiresApi(api = Build.VERSION_CODES.M)
    private void OnCheckPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "앱 실행을 위해서는 권한을 설정해야 합니다.", Toast.LENGTH_SHORT).show();

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST);
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST);
            }
        }
    }


    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "앱 실행을 위한 권한이 설정 되었습니다.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, "앱 실행을 위한 권한이 취소 되었습니다.", Toast.LENGTH_LONG).show();
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == GALLEY_CODE)
        {
            try {
                imageUrl = getRealPathFromUri(data.getData());
                switch (imagecount) {
                    case 0:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image1);
                        imagecount++;
                        mainimage.setVisibility(View.VISIBLE);
                        deletebtn1.setVisibility(View.VISIBLE);
                        imagenextbtn.setEnabled(true);
                        imagenextbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                        break;
                    case 1:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image2);
                        deletebtn2.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 2:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image3);
                        deletebtn3.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 3:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image4);
                        deletebtn4.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 4:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image5);
                        deletebtn5.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 5:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image6);
                        deletebtn6.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 6:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image7);
                        deletebtn7.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 7:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image8);
                        deletebtn8.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 8:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image9);
                        deletebtn9.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                }

            } catch (NullPointerException e)
            {
                Toast.makeText(this, "이미지 선택 안함", Toast.LENGTH_SHORT).show();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private String getRealPathFromUri(Uri uri)
    {
        String[] proj=  {MediaStore.Images.Media.DATA};
        CursorLoader cursorLoader = new CursorLoader(this,uri,proj,null,null,null);
        Cursor cursor = cursorLoader.loadInBackground();

        int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String url = cursor.getString(columnIndex);
        cursor.close();
        return  url;
    }

    public String updateImage() {
        Drawable image = image1.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
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

    public void addProfileData(String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                               String religion, String drink, String smoke, String pet) {

        //여기에서 직접 변수를 만들어서 값을 직접 넣는것도 가능합니다.
        // ex) 갓 태어난 동물만 입력해서 int age=1; 등을 넣는 경우

        //animal.java에서 선언했던 함수.
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        ProfileData profileData1 = new ProfileData(name, birth, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet);
        databaseReference.child(uid).child("ProfileData").setValue(profileData1);

    }


}