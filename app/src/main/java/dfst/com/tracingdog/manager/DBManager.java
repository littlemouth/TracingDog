package dfst.com.tracingdog.manager;

import android.content.Context;

/**
 * Created by yanfei on 2016-11-21.
 */
public class DBManager {
    private static DBManager manager;
    private DBHelper dbHelper;
    private static Context mContext;

    private DBManager(Context context) {
        mContext = context;
        dbHelper = new DBHelper(mContext);
    }

    public static DBManager init(Context context) {
        if (manager == null) {
            manager = new DBManager(context);
        }
        return manager;
    }

    public static DBManager getInstance() {
        return init(null);
    }

    public void closeDB() {
        if (dbHelper != null) {
            dbHelper.closeDatabase();
        }
    }
}
