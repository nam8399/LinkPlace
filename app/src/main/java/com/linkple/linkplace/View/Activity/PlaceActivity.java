package com.linkple.linkplace.View.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkple.linkplace.R;
import com.linkple.linkplace.View.Model.FriendViewAdapter;
import com.linkple.linkplace.View.Model.LinkData;
import com.linkple.linkplace.View.Model.ProfileData;
import com.linkple.linkplace.View.Model.friendItem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.linkple.linkplace.databinding.ActivityPlaceBinding;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.linkple.linkplace.View.Activity.MyProfileActivity.binaryStringToByteArray;

public class PlaceActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityPlaceBinding binding;

    private NaverMap naverMap;
    private FusedLocationSource locationSource;

    ArrayList<Marker> markers = new ArrayList<>();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    String name, age, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, introduce, career;

    private long backKeyPressedTime = 0;
    private int friendcount = 0;
    private String mykey;

    TimerTask timerTask;
    Timer timer = new Timer();

    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        visibleSetting(); // 초기 데이터 visible 설정

        listener(); // 버튼 동작 설정

        firebaseDataSetting(); // 파이어베이스 데이터 셋팅

        initMapfragment(); // 지도 객체 생성
    }

    private void initMapfragment() {
        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map_fragment);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map_fragment, mapFragment).commit();
        }

        // getMapAsync를 호출하여 비동기로 onMapReady 콜백 메서드 호출
        // onMapReady에서 NaverMap 객체를 받음
        mapFragment.getMapAsync(this);

        // 위치를 반환하는 구현체인 FusedLocationSource 생성
        locationSource =
                new FusedLocationSource(this, PERMISSION_REQUEST_CODE);
    }

    private void firebaseDataSetting() {
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
                ImageUrl = profileData1.getImageUrl();
                education = profileData1.getEducation();
                religion = profileData1.getReligion();
                drink = profileData1.getDrink();
                smoke = profileData1.getSmoke();
                pet = profileData1.getPet();
                introduce = profileData1.getIntroduce();
                career = profileData1.getCareer();

                String imageUrlList[] = ImageUrl.split(",");
                for (int i = 0; i < imageUrlList.length; i++) {
                    // 각 List의 값들을 data 객체에 set 해줍니다.
                    switch (i) {
                        case 0:
                            byte[] b = binaryStringToByteArray(imageUrlList[i]);
                            ByteArrayInputStream is = new ByteArrayInputStream(b);
                            Drawable reviewImage2 = Drawable.createFromStream(is, "reviewImage");
                            binding.linkbtnimage.setImageDrawable(reviewImage2);
                            binding.linkbtnimage.setOutlineProvider(new ViewOutlineProvider() {
                                @Override
                                public void getOutline(View view, Outline outline) {
                                    outline.setRoundRect(0,0,view.getWidth(), view.getHeight(), 40);
                                }
                            });
                            binding.linkbtnimage.setClipToOutline(true);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        if (markers.size() != 0) {
            for (int i=0; i < markers.size(); i++) {
                markers.get(i).setMap(null);
            }
        }

        ValueEventListener mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                friendcount = 0;
                List<friendItem> itemList = new ArrayList<>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String key = postSnapshot.getKey();
                    LinkData linkData = postSnapshot.getValue(LinkData.class);
                    if (uid.equals(linkData.getUid())) {
                        mykey = key;
                    }
                    Log.d("PlaceActivity", "Key값 : " + key);
                    if (!linkData.getUid().equals(uid)) {
                        Marker marker = new Marker();
                        marker.setMap(null);
                        friendcount++;
                        markers.add(marker);
                        setMarker(marker, linkData.getLat(), linkData.getLon(), R.drawable.mylocmarker, 0);

                        // strName, strAge, strGender, strContent, strJob, strCharactor, strHobby, strWantfriend, strImageUrl, strEducation, strReligion,
                        //    strDrink, strSmoke, strPet, strCareer;
                        Log.d("PlaceActivity", "PlaceActivity ImageUrl : " + linkData.getImageUrl());
                        itemList.add(new friendItem(R.drawable.imagenotshow, linkData.getName(), linkData.getBirth() + "세", linkData.getGender(), linkData.getIntroduce(), linkData.getJob(), linkData.getCharactor(), linkData.getHobby(), linkData.getWantfriend(), linkData.getImageUrl(), linkData.getEducation(), linkData.getReligion(), linkData.getDrink(), linkData.getSmoke(), linkData.getPet(), linkData.getCareer(), key));
                    }
                }
                RecyclerView recyclerView = findViewById(R.id.recycler_view);

                // Adapter 추가
                FriendViewAdapter adapter = new FriendViewAdapter(itemList);
                recyclerView.setAdapter(adapter);
                // Layout manager 추가
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                binding.recommendfriend.setText(friendcount + "명의 친구를 만나보세요!");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.child("Link").addValueEventListener(mValueEventListener);
    }

    private void visibleSetting() {
        binding.frameLayout.setVisibility(View.INVISIBLE);
        binding.linkcount.setVisibility(View.INVISIBLE);
    }


    public void listener() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        binding.mylocbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PlaceAcitivity", "click my loc");
                naverMap.setLocationSource(locationSource);
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        });

        binding.linkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naverMap.setLocationSource(locationSource);
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
                binding.linkcount.setVisibility(View.VISIBLE);
                if (mykey != null) {
                    removeMapData();
                }
//                setMarker(marker, locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), R.drawable.mylocmarker, 0);
                addMapData(locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), name, age, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, uid, introduce, career);
                binding.linkbtn.requestLayout();
                binding.linkbtntext.setText("");
                binding.linkbtn.setEnabled(false);
                try {
                    startTimerTask();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                binding.linkbtnimage.setVisibility(View.VISIBLE);
            }
        });

        binding.myprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        binding.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        binding.linkcountxbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeMapData();
                stopTimerTask();
                binding.linkbtnimage.setVisibility(View.INVISIBLE);
                binding.linkcountxbtn.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void setMarker(Marker marker, double lat, double lng, int resourceID, int zIndex)
    {
        //원근감 표시
        marker.setIconPerspectiveEnabled(true);
        //아이콘 지정
        marker.setIcon(OverlayImage.fromResource(resourceID));
        //마커의 투명도
        marker.setAlpha(0.8f);
        //마커 위치
        marker.setPosition(new LatLng(lat, lng));
        //마커 우선순위
        marker.setZIndex(zIndex);
        //마커 표시
        marker.setMap(naverMap);

        marker.setHeight(50);
        marker.setWidth(50);
    }

    private void removeMarker(Marker marker, double lat, double lng, int resourceID, int zIndex)
    {
        marker.setMap(null);
    }

    @Override
    public void onMapReady(@NonNull @NotNull NaverMap naverMap) {
        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_REQUEST_CODE);

        LocationOverlay locationOverlay = naverMap.getLocationOverlay();
        locationOverlay.setVisible(true);
        locationOverlay.setIcon(null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // request code와 권한획득 여부 확인
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        }
    }

    private void startTimerTask() throws RemoteException
    {
        stopTimerTask();
        timerTask = new TimerTask()
        {
            int count = 60;
            int minute = 29;

            @Override
            public void run()
            {
                count--;
                if (count == -1) {
                    minute--;
                    count = 59;
                }
                if (count == 0 && minute == 0) {
                    timerTask.cancel();
                }

                binding.linkcounttext.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count == 0 && minute == 0) {
                            binding.linkbtn.setBackgroundResource(R.drawable.linkbtn);
                            binding.linkbtntext.setText("Link");
                            binding.linkbtn.setEnabled(true);
//                            removeMarker(marker, locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), R.drawable.mylocmarker, 0);
                        } else if (count < 10) {
                            binding.linkcounttext.setText(minute + ":"+ "0" + count);
                        }
                        else {
                            binding.linkcounttext.setText(minute + ":"+ count);
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,0 ,1000);
    }

    private void stopTimerTask()
    {
        if(timerTask != null)
        {
            removeMapData();
            binding.linkcounttext.setText("30:00");
            timerTask.cancel();
            timerTask = null;
            binding.linkbtnimage.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            moveTaskToBack(true); // 태스크를 백그라운드로 이동
            finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
            android.os.Process.killProcess(android.os.Process.myPid()); // 앱 프로세스 종료
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (markers.size() != 0) {
            for (int i=0; i < markers.size(); i++) {
                markers.get(i).setMap(null);
            }
        }
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        ValueEventListener mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                friendcount = 0;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String key = postSnapshot.getKey();
                    LinkData linkData = postSnapshot.getValue(LinkData.class);

                    if (!linkData.getUid().equals(uid)) {
                        Marker marker = new Marker();
                        marker.setMap(null);
                        friendcount++;
                        markers.add(marker);
                        setMarker(marker, linkData.getLat(), linkData.getLon(), R.drawable.mylocmarker, 0);
                    }
                }

                binding.recommendfriend.setText(friendcount + "명의 친구를 만나보세요!");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.child("Link").addValueEventListener(mValueEventListener);
    }

    public void addMapData(double lat, double lon, String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                               String religion, String drink, String smoke, String pet, String uid, String introduce, String career) {



        LinkData linkData = new LinkData(lat, lon, name, birth, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, uid, introduce, career);
        databaseReference.child("Link").push().setValue(linkData);

    }

    public void removeMapData() {
        Log.d("PlaceActivity", "mykey" + mykey);
        if (mykey != null) {
            databaseReference.child("Link").child(mykey).setValue(null);
        }


    }

    public void addProfileData(String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                               String religion, String drink, String smoke, String pet, String introduce, String career) {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        ProfileData profileData1 = new ProfileData(name, birth, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, introduce, career);
        databaseReference.child(uid).child("ProfileData").setValue(profileData1);

    }
}