package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NOMBRE ="curp.sqlite";
    private static int DB_SCHEME_VERSION = 1;
    public DbHelper(Context context) {
        super(context, DB_NOMBRE, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //crear tabla curso
        db.execSQL(DataBaseManagerCurp.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS "+ DB_NOMBRE);
    onCreate(db);
    }

}
