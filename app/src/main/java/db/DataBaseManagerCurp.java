package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.curp;

public class DataBaseManagerCurp  extends DataBaseManager{
  private static final String NOMBRE_TABLA = "Curp";
  private static final String CN_AP = "_AP";
    private static final String CN_AM = "_AM";
    private static final String CN_NOMBRE= "_name";
    private static final String CN_SEXO = "_sex";
    private static final String CN_FECHA = "_date";
    private static final String CN_ESTADO = "_estado";

    public static final String CREATE_TABLE = "create table " + NOMBRE_TABLA + "("
            +CN_AP + "text NOT NULL, "
            +CN_AM + "text NOT NULL, "
            +CN_NOMBRE + "text NOT NULL, "
            +CN_SEXO + "text NOT NULL, "
            +CN_FECHA + "text NOT NULL, "
            +CN_ESTADO + "text NOT NULL"
            +");";


    public DataBaseManagerCurp(Context ctx) {
        super(ctx);
    }
    @Override
    public void cerrar(){
        super.getDb().close();
    }

    private ContentValues generarContentValues(String AP, String AM, String name, String SX, String date, String estado) {
        ContentValues valores = new ContentValues();
        valores.put(CN_AP, AP);
        valores.put(CN_AM, AM);
        valores.put(CN_NOMBRE, name);
        valores.put(CN_SEXO, SX);
        valores.put(CN_FECHA, date);
        valores.put(CN_ESTADO, estado);
        return valores;
    }

    @Override
    public void insertar(String anzures, String AP, String AM, String name, String SX, String date) {
        Log.d("curp_insertar", super.getDb().insert(NOMBRE_TABLA, null, generarContentValues(AP, AM, name, SX, date,estado))+"");

    }

    @Override
    void actualizar(String AP, String AM, String name, String SX, String date, String estado) {

    }

    @Override
    public void eliminartodo() {

    }

    @Override
    public Cursor cargar() {
        String[] columnas = new String[]{CN_AP, CN_AM, CN_NOMBRE, CN_SEXO, CN_FECHA, CN_ESTADO};

        return super.getDb().query(NOMBRE_TABLA,columnas, null, null, null, null, null);
    }

    @Override
    Boolean comprobar(String Apellido) {
        boolean esta = true;
        Cursor resultSet = super.getDb().rawQuery("Select * from" + NOMBRE_TABLA + "WHERE" + CN_AP +"="+Apellido,null);
        if (resultSet.getCount()<=0){
            esta=false;
        }
        else
            esta=true;
        return esta;
    }
    public List<curp>getcurpList(){
        List<curp> list=new ArrayList<>();
        Cursor c =cargar();
        while (c.moveToNext()){
            curp Curp = new curp();
            Curp.setAp(c.getString(0));
            Curp.setAm(c.getString(1));
            Curp.setName(c.getString(2));
            Curp.setSx(c.getString(3));
            Curp.setDate(c.getString(4));
            Curp.setEstado(c.getString(5));
            list.add(Curp);
        }
        return list;
    }




}
