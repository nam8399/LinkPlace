package com.linkple.linkplace.View.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Model.ProfileData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.linkple.linkplace.databinding.ActivityImageSetBinding;

import java.io.ByteArrayOutputStream;

public class ImageSetAcitivty extends AppCompatActivity {
    private ActivityImageSetBinding binding;

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
        binding = ActivityImageSetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String imgName = "osz.png";

        OnCheckPermission();

        firstSetting(); // 초기 화면 보여짐 셋팅

        Listener(); // 버튼 동작들 셋팅
    }

    private void firstSetting() {
        binding.mainimage.setVisibility(View.INVISIBLE);

        binding.deletebtn1.setVisibility(View.INVISIBLE);
        binding.deletebtn2.setVisibility(View.INVISIBLE);
        binding.deletebtn3.setVisibility(View.INVISIBLE);
        binding.deletebtn4.setVisibility(View.INVISIBLE);
        binding.deletebtn5.setVisibility(View.INVISIBLE);
        binding.deletebtn6.setVisibility(View.INVISIBLE);
        binding.deletebtn7.setVisibility(View.INVISIBLE);
        binding.deletebtn8.setVisibility(View.INVISIBLE);
        binding.deletebtn9.setVisibility(View.INVISIBLE);

        binding.imagenextbtn.setEnabled(false);
    }

    private void Listener() {
        binding.inputimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);

                startActivityForResult(intent, GALLEY_CODE);
            }
        });

        binding.image1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                imagecount = 0;
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, GALLEY_CODE);
                return true;
            }
        });

        binding.deletebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.mainimage.setVisibility(View.INVISIBLE);
                binding.deletebtn1.setVisibility(View.INVISIBLE);
                binding.image1.setImageResource(0);
                imagecount = 0;
                binding.imagenextbtn.setEnabled(false);
                binding.imagenextbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C4DFFF")));
            }
        });

        binding.deletebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!binding.image3.getDrawable().equals(null)) {
                        Glide.with(getApplicationContext())
                                .load(binding.image3.getDrawable())
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image2);
                        binding.image3.setImageResource(0);
                        binding.deletebtn3.setVisibility(View.INVISIBLE);
                    } else {
                        binding.deletebtn2.setVisibility(View.INVISIBLE);
                        binding.image2.setImageResource(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    binding.deletebtn2.setVisibility(View.INVISIBLE);
                    binding.image2.setImageResource(0);
                }


                imagecount--;
            }
        });

        binding.imagenextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PlaceActivity.class);
                imageUrl = updateImage();
                if (!updateImage2().equals("")) {
                    imageUrl += "," + updateImage2();
                }
                if (!updateImage3().equals("")) {
                    imageUrl += "," + updateImage3();
                }
                if (!updateImage4().equals("")) {
                    imageUrl += "," + updateImage4();
                }
                if (!updateImage5().equals("")) {
                    imageUrl += "," + updateImage5();
                }
                if (!updateImage6().equals("")) {
                    imageUrl += "," + updateImage6();
                }
                if (!updateImage7().equals("")) {
                    imageUrl += "," + updateImage7();
                }
                if (!updateImage8().equals("")) {
                    imageUrl += "," + updateImage8();
                }
                if (!updateImage9().equals("")) {
                    imageUrl += "," + updateImage9();
                }
                addProfileData(name, age, gender, job, charactor, hobby, wantfriend, imageUrl, "", "", "", "", "", "", "");
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
                                .into(binding.image1);
                        imagecount++;
                        binding.mainimage.setVisibility(View.VISIBLE);
                        binding.deletebtn1.setVisibility(View.VISIBLE);
                        binding.imagenextbtn.setEnabled(true);
                        binding.imagenextbtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2B87F4")));
                        break;
                    case 1:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image2);
                        binding.deletebtn2.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 2:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image3);
                        binding.deletebtn3.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 3:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image4);
                        binding.deletebtn4.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 4:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image5);
                        binding.deletebtn5.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 5:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image6);
                        binding.deletebtn6.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 6:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image7);
                        binding.deletebtn7.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 7:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image8);
                        binding.deletebtn8.setVisibility(View.VISIBLE);
                        imagecount++;
                        break;
                    case 8:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(binding.image9);
                        binding.deletebtn9.setVisibility(View.VISIBLE);
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
        Drawable image = binding.image1.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
    }

    public String updateImage2() {
        if (binding.image2.getDrawable() == null) {
            Log.d("updateImage2", "updateImage2" + binding.image2.getDrawable());
            return "";
        }
        Drawable image = binding.image2.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
    }

    public String updateImage3() {
        if (binding.image3.getDrawable() == null) {
            return "";
        }
        Drawable image = binding.image3.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
    }

    public String updateImage4() {
        if (binding.image4.getDrawable() == null) {
            return "";
        }
        Drawable image = binding.image4.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
    }

    public String updateImage5() {
        if (binding.image5.getDrawable() == null) {
            return "";
        }
        Drawable image = binding.image5.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
    }

    public String updateImage6() {
        if (binding.image6.getDrawable() == null) {
            return "";
        }
        Drawable image = binding.image6.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
    }

    public String updateImage7() {
        if (binding.image7.getDrawable() == null) {
            return "";
        }
        Drawable image = binding.image7.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
    }

    public String updateImage8() {
        if (binding.image8.getDrawable() == null) {
            return "";
        }
        Drawable image = binding.image8.getDrawable();
        String simage = "";
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] reviewImage = stream.toByteArray();
        simage = byteArrayToBinaryString(reviewImage);
        return simage;
    }

    public String updateImage9() {
        if (binding.image9.getDrawable() == null) {
            return "";
        }
        Drawable image = binding.image9.getDrawable();
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
                               String religion, String drink, String smoke, String pet, String introduce, String career) {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        ProfileData profileData1 = new ProfileData(name, birth, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, introduce, career);
        databaseReference.child(uid).child("ProfileData").setValue(profileData1);

    }


}