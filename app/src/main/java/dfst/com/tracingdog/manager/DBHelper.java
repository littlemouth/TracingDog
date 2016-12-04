package dfst.com.tracingdog.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yanfei on 2016-11-21.
 */
public class DBHelper extends SQLiteOpenHelper {
    private final static String DB_NAME ="tracingdog.db";//数据库名
    private final static int VERSION = 1;//版本号

    private SQLiteDatabase database;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion)
            createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
    }

    SQLiteDatabase openDatabase() {
        if (database == null) {
            database = getWritableDatabase();
        }

        return database;
    }

    void closeDatabase() {
        if (database != null && database.isOpen()) {
            database.close();
        }
    }
}
