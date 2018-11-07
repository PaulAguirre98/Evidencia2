package db;

import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class DataBaseManager {
    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context ctx){
        helper = new DbHelper(ctx);
        db = helper.getWritableDatabase();
    }
    public void cerrar(){
        db.close();
    }
abstract void insertar(String AP, String AM, String name, String SX, String date, String estado);
    abstract void actualizar (String AP, String AM, String name, String SX, String date, String estado);

abstract public void eliminartodo();
abstract public Cursor cargar();
abstract Boolean comprobar(String Apellido);

    public SQLiteDatabase getDb() {
        return db;
    }
}

