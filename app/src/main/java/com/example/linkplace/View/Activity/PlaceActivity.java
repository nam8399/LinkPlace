package com.example.linkplace.View.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linkplace.R;
import com.example.linkplace.View.Fragment.MyProfileJobFragement;
import com.example.linkplace.View.Fragment.SettingFragment;
import com.example.linkplace.View.Model.FriendViewAdapter;
import com.example.linkplace.View.Model.LinkData;
import com.example.linkplace.View.Model.ProfileData;
import com.example.linkplace.View.Model.friendItem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PlaceActivity extends AppCompatActivity implements OnMapReadyCallback {
    private NaverMap naverMap;
    private FusedLocationSource locationSource;

    ImageView editbtn, mylocbtn, linkbtn, myprofilebtn;
    TextView linkbtntext, linkcounttext;
    ImageView whitebackbtn;
    FrameLayout frameLayout;
    ArrayList<Marker> markers = new ArrayList<>();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String name, age, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet;

    private long backKeyPressedTime = 0;

    TimerTask timerTask;
    Timer timer = new Timer();

    private MapView mapView;
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        bindList();

        // 지도 객체 생성
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

    public void bindList() {
        editbtn = findViewById(R.id.editbtn);
        mylocbtn = findViewById(R.id.mylocbtn);
        mapView = findViewById(R.id.map_fragment);
        linkbtn = findViewById(R.id.linkbtn);
        whitebackbtn = findViewById(R.id.whitebackbtn);
        linkbtntext = findViewById(R.id.linkbtntext);
        myprofilebtn = findViewById(R.id.myprofilebtn);
        linkcounttext = findViewById(R.id.linkcounttext);
        frameLayout = findViewById(R.id.frameLayout);

        frameLayout.setVisibility(View.INVISIBLE);


        mylocbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PlaceAcitivity", "click my loc");
                naverMap.setLocationSource(locationSource);
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        });

        linkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naverMap.setLocationSource(locationSource);
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
//                setMarker(marker, locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), R.drawable.mylocmarker, 0);
                addMapData(locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), name, age, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet);
                linkbtn.setBackgroundResource(R.drawable.myprofilesample);
                linkbtn.requestLayout();
                linkbtntext.setText("");
                linkbtn.setEnabled(false);
                try {
                    startTimerTask();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        myprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        List<friendItem> itemList = new ArrayList<>();

        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "24세", "여성", "저녁에 맥주한잔 콜??", "5"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "김대롱", "25세", "남성", "저녁에 맥주한잔 콜??", "5"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "박대롱", "26세", "여성", "저녁에 소주한잔 콜??", "5"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "최대롱", "27세", "남성", "저녁에 소주한잔 콜??", "5"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "이대롱", "28세", "여성", "저녁에 막걸리한잔 콜??", "5"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "한대롱", "29세", "남성", "저녁에 막걸리한잔 콜??", "5"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "조대롱", "30세", "여성", "저녁에 양주한잔 콜??", "5"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "오대롱", "30세", "남성", "저녁에 양주한잔 콜??", "5"));
        itemList.add(new friendItem(R.drawable.white, "", "", "", "", ""));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Adapter 추가
        FriendViewAdapter adapter = new FriendViewAdapter(itemList);
        recyclerView.setAdapter(adapter);
        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

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

        if (markers.size() != 0) {
            for (int i=0; i < markers.size(); i++) {
                markers.get(i).setMap(null);
            }
        }

        ValueEventListener mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String key = postSnapshot.getKey();
                    LinkData linkData = postSnapshot.getValue(LinkData.class);

                   Marker marker = new Marker();
                   marker.setMap(null);

                   markers.add(marker);
                   setMarker(marker, linkData.getLat(), linkData.getLon(), R.drawable.mylocmarker, 0);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.child("Link").addValueEventListener(mValueEventListener);

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

                linkcounttext.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count == 0 && minute == 0) {
                            linkbtn.setBackgroundResource(R.drawable.linkbtn);
                            linkbtntext.setText("Link");
                            linkbtn.setEnabled(true);
//                            removeMarker(marker, locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), R.drawable.mylocmarker, 0);
                        } else if (count < 10) {
                            linkcounttext.setText(minute + ":"+ "0" + count);
                        }
                        else {
                            linkcounttext.setText(minute + ":"+ count);
                        }
                    }
                });

//                if (count == max) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            // call the invalidate()
//                            Timer timer = new Timer();
//                            timer.cancel();
//                            linkbtn.setBackgroundResource(R.drawable.linkbtn);
//                            linkbtntext.setText("Link");
//                            linkbtn.setEnabled(true);
//                            removeMarker(marker, locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), R.drawable.mylocmarker, 0);
//                        }
//                    });
//
//                }
            }
        };
        timer.schedule(timerTask,0 ,1000);
    }

    private void stopTimerTask()
    {
        if(timerTask != null)
        {
            linkcounttext.setText("30:00");
            timerTask.cancel();
            timerTask = null;
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

        ValueEventListener mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String key = postSnapshot.getKey();
                    LinkData linkData = postSnapshot.getValue(LinkData.class);

                    Marker marker = new Marker();
                    marker.setMap(null);

                    markers.add(marker);
                    setMarker(marker, linkData.getLat(), linkData.getLon(), R.drawable.mylocmarker, 0);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.child("Link").addValueEventListener(mValueEventListener);
    }

    public void addMapData(double lat, double lon, String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                               String religion, String drink, String smoke, String pet) {

        //여기에서 직접 변수를 만들어서 값을 직접 넣는것도 가능합니다.
        // ex) 갓 태어난 동물만 입력해서 int age=1; 등을 넣는 경우

        //animal.java에서 선언했던 함수.

        LinkData linkData = new LinkData(lat, lon, name, birth, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet);
        databaseReference.child("Link").push().setValue(linkData);

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