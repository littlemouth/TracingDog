package dfst.com.tracingdog.activity;

import android.app.Activity;
import android.os.Bundle;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;

import dfst.com.tracingdog.R;

/**
 * Created by yanfei on 2016-10-25.
 */
public class TracingMapActivity extends Activity {
    private MapView mapView;
    private AMap aMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapView = (MapView) findViewById(R.id.mapView);
        //mapView.onCreate(savedInstanceState);

        init();
    }

    /**
     * 初始化AMap对象
     */
    private void init() {
        /*if (aMap == null) {
            aMap = mapView.getMap();
        }*/

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
}
