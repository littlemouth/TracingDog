package dfst.com.tracingdog.global;

import com.dfst.core.app.CoreApplication;

import dfst.com.tracingdog.manager.DBManager;
import dfst.com.tracingdog.manager.HttpManager;

/**
 * Created by yanfei on 2016-11-21.
 */
public class TdApp extends CoreApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        DBManager.init(this);
        HttpManager.init(this);
    }
}
