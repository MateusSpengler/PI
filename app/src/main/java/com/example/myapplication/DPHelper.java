package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DPHelper extends SQLiteOpenHelper {

    private static int versao=1;
    private static String nome = "Login_Registro_BaseDados.dp";


    public DPHelper(Context context) {
        super(context, nome, null, versao);

    }

    @Override
    public void onCreate(SQLiteDatabase dp) {

        String str = "CREATE TABLE Utilizador (email TEXT PRIMARY KEY, password TEXT)";
        dp.execSQL(str);

    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int oldVersion, int newVersion) {

        dp.execSQL("DROP TABLE IF EXISTS Utilizador");
        onCreate(dp);
    }

    public long CriarUtilizador ( String email,String password){

        SQLiteDatabase dp = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("email",email);
        cv.put("password",password);
        long result = dp.insert("Utilizador",null,cv);



        return result;
    }
    public String ValidarLogin (String email, String password){

            SQLiteDatabase dp = getReadableDatabase();

            Cursor c = (Cursor) dp.rawQuery ("Select * from Utilizador WHERE email=? AND password=?", new String [] {email,password});
            if (c.getCount() >0){
                return "ok";
            }else {
                return "ERRO";
            }
    }

}
