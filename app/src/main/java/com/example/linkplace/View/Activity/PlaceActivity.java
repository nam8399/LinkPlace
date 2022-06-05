package com.example.linkplace.View.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linkplace.R;
import com.example.linkplace.View.Model.FriendViewAdapter;
import com.example.linkplace.View.Model.friendItem;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.util.FusedLocationSource;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PlaceActivity extends AppCompatActivity implements OnMapReadyCallback {
    ImageView editbtn, mylocbtn;
    private NaverMap naverMap;
    private FusedLocationSource locationSource;
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

        mylocbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PlaceAcitivity", "click my loc");
                naverMap.setLocationSource(locationSource);
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        });

        List<friendItem> itemList = new ArrayList<>();

        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "24세", "여성", "저녁에 맥주한잔 콜??"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "25세", "여성", "저녁에 맥주한잔 하쉴??"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "26세", "여성", "저녁에 소주한잔 콜??"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "27세", "여성", "저녁에 소주한잔 하쉴??"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "28세", "여성", "저녁에 막걸리한잔 콜??"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "29세", "여성", "저녁에 막걸리한잔 하쉴??"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "30세", "여성", "저녁에 양주한잔 콜??"));
        itemList.add(new friendItem(R.drawable.imagenotshow, "송대롱", "30세", "여성", "저녁에 양주한잔 하쉴??"));
        itemList.add(new friendItem(R.drawable.white, "", "", "", ""));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Adapter 추가
        FriendViewAdapter adapter = new FriendViewAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onMapReady(@NonNull @NotNull NaverMap naverMap) {
        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_REQUEST_CODE);
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
}