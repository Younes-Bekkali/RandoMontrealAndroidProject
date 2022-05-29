package qc.bdeb.randomontreal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "RandoMontrealDatabase";

    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

//    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE BucketListTable( id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT)";
        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlQuery = "DROP TABLE IF EXISTS BucketListTable";
        sqLiteDatabase.execSQL(sqlQuery);
        onCreate(sqLiteDatabase);
    }
}
