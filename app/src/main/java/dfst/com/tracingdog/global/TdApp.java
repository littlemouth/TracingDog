package dfst.com.tracingdog.global;

import android.app.Application;

import dfst.com.tracingdog.manager.DBManager;
import dfst.com.tracingdog.manager.HttpManager;

/**
 * Created by yanfei on 2016-11-21.
 */
public class TdApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DBManager.init(this);
        HttpManager.init(this);
    }
}
