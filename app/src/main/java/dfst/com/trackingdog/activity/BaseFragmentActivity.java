package dfst.com.trackingdog.activity;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import dfst.com.core.util.DensityUtil;
import dfst.com.trackingdog.R;

/**
 * Created by Ecci-07 on 2016/10/28.
 */
public class BaseFragmentActivity extends FragmentActivity {

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
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}