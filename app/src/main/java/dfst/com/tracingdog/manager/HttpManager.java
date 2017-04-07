package dfst.com.tracingdog.manager;

import android.content.Context;

import com.dfst.network.NetworkUtils;

import dfst.com.tracingdog.global.DataCenter;

/**
 * Created by yanfei on 2016-11-21.
 */
public class HttpManager {
    private static HttpManager manager;
    private Context mContext;

    private HttpManager(Context context) {
        mContext = context;
    }

    public static HttpManager init(Context context) {
        if (manager == null) {
            manager = new HttpManager(context);
        }
        return manager;
    }

    public static HttpManager getInstance() {
        return init(null);
    }

    public void login(String account, String password) {
        NetworkUtils.http()
                .post()
                .url(DataCenter.URL.LOGIN)
                .addParam("account", account)
                .addParam("password", password)
                .build();
    }
}
