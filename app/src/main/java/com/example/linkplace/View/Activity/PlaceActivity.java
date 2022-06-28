package com.example.linkplace.View.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.linkplace.R;
import com.example.linkplace.View.Model.FriendViewAdapter;
import com.example.linkplace.View.Model.friendItem;
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

    ProgressBar progressbar;
    ImageView editbtn, mylocbtn, linkbtn, myprofilebtn;
    TextView linkbtntext;
    ImageView whitebackbtn;

    private MapView mapView;
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    private Marker marker = new Marker();
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
        progressbar = findViewById(R.id.progressbar);
        myprofilebtn = findViewById(R.id.myprofilebtn);
        progressbar.setVisibility(View.INVISIBLE);


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
                setMarker(marker, locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), R.drawable.myfaceimg, 0);
                linkbtn.setBackgroundResource(R.drawable.mylocmarker);
//                linkbtn.getLayoutParams().height = 220;
//                linkbtn.getLayoutParams().width = 220;
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
                Intent intent = new Intent(getApplicationContext(), PlaceActivity.class);
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

        Timer timer = new Timer();
        progressbar.setVisibility(View.VISIBLE);
        TimerTask timerTask = new TimerTask()
        {
            double count = 0;
            double max = 60;

            @Override
            public void run()
            {
                double percentage = count/max * 100;
                Log.d("count", String.valueOf(count) + "percentage : " + percentage);
                count++;

                if (count == max) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // call the invalidate()
                            Timer timer = new Timer();
                            timer.cancel();
                            linkbtn.setBackgroundResource(R.drawable.linkbtn);
                            linkbtntext.setText("Link");
                            progressbar.setVisibility(View.INVISIBLE);
                            linkbtn.setEnabled(true);
                            removeMarker(marker, locationSource.getLastLocation().getLatitude(), locationSource.getLastLocation().getLongitude(), R.drawable.mylocmarker, 0);
                        }
                    });

                }
                progressbar.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count == 0) {
                            progressbar.setProgress(0);
                        } else if (count > 0) {
                            progressbar.setProgress((int) percentage);
                        } else if (count == max) {
                            progressbar.setProgress(0);
                            linkbtn.setBackgroundResource(R.drawable.linkbtn);
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,0 ,1000);
    }

//    private void stopTimerTask()
//    {
//        if(timerTask != null)
//        {
//            timerTask.cancel();
//            timerTask = null;
//        }
//    }
}