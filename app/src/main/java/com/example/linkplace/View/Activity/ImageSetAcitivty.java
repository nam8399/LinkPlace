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
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.linkplace.R;
import com.example.linkplace.View.Fragment.FriendCharacterFragment;
import com.example.linkplace.View.Fragment.ProfileBirthSetFragment;

public class ImageSetAcitivty extends AppCompatActivity {
    Button back_button, inputimagebtn;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    TextView mainimage;

    private int GALLEY_CODE = 10;
    static final int PERMISSIONS_REQUEST = 0x00000001;
    private String imageUrl="";
    int imagecount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_image_set);

        back_button = findViewById(R.id.back_button);
        inputimagebtn = findViewById(R.id.inputimagebtn);
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

        OnCheckPermission();

        mainimage.setVisibility(View.INVISIBLE);



//        back_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((MainActivity)getActivity()).replaceFragment(FriendCharacterFragment.newInstance());
//            }
//        });


        inputimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);

                startActivityForResult(intent, GALLEY_CODE);
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
                        break;
                    case 1:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image2);
                        imagecount++;
                        break;
                    case 2:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image3);
                        imagecount++;
                        break;
                    case 3:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image4);
                        imagecount++;
                        break;
                    case 4:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image5);
                        imagecount++;
                        break;
                    case 5:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image6);
                        imagecount++;
                        break;
                    case 6:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image7);
                        imagecount++;
                        break;
                    case 7:
                        Glide.with(getApplicationContext())
                                .load(imageUrl)
                                .transform(new CenterCrop(), new RoundedCorners(30))
                                .into(image8);
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




}