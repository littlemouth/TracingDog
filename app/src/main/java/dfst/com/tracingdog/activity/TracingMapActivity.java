package dfst.com.tracingdog.activity;

import android.app.Activity;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.util.ViewUtil;
import dfst.com.tracingdog.widget.LocationView;

/**
 * Created by yanfei on 2016-10-25.
 */
public class TracingMapActivity extends Activity implements AMap.OnMyLocationChangeListener {
    private MapView mapView;
    private AMap aMap;
    private MyLocationStyle myLocationStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 不显示程序的标题栏
        setContentView(R.layout.activity_tracing_map);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        init();
    }

    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
            setUpMap();
        }
        aMap.setOnMyLocationChangeListener(this);

        LatLng latLng = new LatLng(30.192356, 120.201686);
        LatLng latLng1 = new LatLng(30.202356, 120.181686);
        LatLng latLng2 = new LatLng(30.212356, 120.221686);
        LatLng latLng3 = new LatLng(30.2122356, 120.171686);
        LatLng latLng4 = new LatLng(30.2422356, 120.16686);
        LatLng latLng5 = new LatLng(30.1822356, 120.18686);
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(latLng));
        drawMarker(latLng);
        drawMarker(latLng1);
        drawMarker(latLng2);
        drawMarker(latLng3);
        drawMarker(latLng4);
        //drawMarker(latLng5);
    }

    /**
     * 设置一些amap的属性
     */
    private void setUpMap() {
        aMap.moveCamera(CameraUpdateFactory.zoomTo(12));
        // 如果要设置定位的默认状态，可以在此处进行设置
        myLocationStyle = new MyLocationStyle();
        aMap.setMyLocationStyle(myLocationStyle);

        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        //aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false

    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onMyLocationChange(Location location) {
    // 定位回调监听
        if(location != null) {
            Log.e("amap", "onMyLocationChange 定位成功， lat: " + location.getLatitude() + " lon: " + location.getLongitude());
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            Bundle bundle = location.getExtras();
            if(bundle != null) {
                int errorCode = bundle.getInt(MyLocationStyle.ERROR_CODE);
                String errorInfo = bundle.getString(MyLocationStyle.ERROR_INFO);
                // 定位类型，可能为GPS WIFI等，具体可以参考官网的定位SDK介绍
                int locationType = bundle.getInt(MyLocationStyle.LOCATION_TYPE);

                /*
                errorCode
                errorInfo
                locationType
                */
                Log.e("amap", "定位信息， code: " + errorCode + " errorInfo: " + errorInfo + " locationType: " + locationType );
            } else {
                Log.e("amap", "定位信息， bundle is null ");

            }

        } else {
            Log.e("amap", "定位失败");
        }
    }

    /**
     * 绘制系统默认的1种marker背景图片
     */
    public void drawMarker(LatLng latlng) {
        Uri defaultHeadUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.mipmap.default_head);
        View view = ViewUtil.getLocationView(this, defaultHeadUri, Color.BLUE);
        //创建Marker对象
         Marker marker = aMap.addMarker(new MarkerOptions().position(latlng)
                .icon(BitmapDescriptorFactory.fromView(view)).draggable(true));
    }


}
