package dfst.com.tracingdog.manager;

import android.content.Context;

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

}
