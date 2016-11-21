package dfst.com.tracingdog.activity;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import dfst.com.core.util.DensityUtil;
import dfst.com.tracingdog.manager.DBManager;
import dfst.com.tracingdog.manager.HttpManager;
import dfst.com.tracingdog.R;

/**
 * Created by Ecci-07 on 2016/10/28.
 */
public class BaseFragmentActivity extends FragmentActivity {
    protected DBManager dbManager;
    protected HttpManager httpManager;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int statusBarHeight = getStatusBarHeight();
            View title = findViewById(R.id.common_activity_title_relativelayout);
            ViewGroup.LayoutParams params = title.getLayoutParams();
            params.height = DensityUtil.dip2px(this, 50) + statusBarHeight;
        }

        dbManager = DBManager.getInstance();
        httpManager = HttpManager.getInstance();
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public DBManager getDbManager() {
        return dbManager;
    }

    public HttpManager getHttpManager() {
        return  httpManager;
    }
}
