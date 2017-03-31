package dfst.com.tracingdog.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.manager.DBManager;
import dfst.com.tracingdog.manager.HttpManager;

/**
 * Created by Ecci-07 on 2016/10/28.
 */
public class BaseActivity extends Activity {
    protected DBManager dbManager;
    protected HttpManager httpManager;

    protected void init() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int statusBarHeight = getStatusBarHeight();
            View statusBar = findViewById(R.id.status_bar_view);
            statusBar.setVisibility(View.VISIBLE);
            ViewGroup.LayoutParams params = statusBar.getLayoutParams();
            params.height = statusBarHeight;
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

    /**
     * 判断软键盘是否弹出
     */
    protected boolean isSHowKeyboard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
        if (imm.hideSoftInputFromWindow(v.getWindowToken(), 0)) {
            imm.showSoftInput(v, 0);
            return true;
            //软键盘已弹出
        } else {
            return false;
            //软键盘未弹出
        }
    }
}
