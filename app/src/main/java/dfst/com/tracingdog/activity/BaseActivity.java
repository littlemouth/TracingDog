package dfst.com.tracingdog.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import dfst.com.tracingdog.manager.DBManager;
import dfst.com.tracingdog.manager.HttpManager;

/**
 * Created by Ecci-07 on 2016/10/28.
 */
public class BaseActivity extends Activity {
    protected DBManager dbManager;
    protected HttpManager httpManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        dbManager = DBManager.getInstance();
        httpManager = HttpManager.getInstance();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
