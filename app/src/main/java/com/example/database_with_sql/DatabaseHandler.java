package com.example.database_with_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="SQLiteDatabase.db";
    public static final String TABLE_NAME="PEOPLE";
    public static final String COLUMN_ID="ID";
    public static final String COLUMN_FIRST_NAME="FIRST_NAME";
    public static final String COLUMN_LAST_NAME="LAST_NAME";
    private SQLiteDatabase database;

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FIRST_NAME + " VARCHAR, "
                + COLUMN_LAST_NAME + " VARCHAR);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void updateRecord(ContactModel contactModel)
    {
        database=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME,contactModel.getFirstName());
        contentValues.put(COLUMN_LAST_NAME,contactModel.getLastName());
        database.update(TABLE_NAME,contentValues,COLUMN_ID+" = ?",new String[]{contactModel.getID()});
        database.close();

    }

    public UserBean verifyLoginAndGetUserData(UserBean bean)
    {
        database=this.getReadableDatabase();

        String[] Columns={"ID","Name","Username","Password"};
        String selection="USERNAME=? and PASSWORD=?";

        String [] selectionArgs={bean.getUsername(),bean.getPassword()};


        Cursor cursor=database.query(TABLE_NAME,columns,selection)
    }

    public void insertRecord(ContactModel contact) {
        database=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME,contact.getFirstName());
        contentValues.put(COLUMN_LAST_NAME,contact.getLastName());
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    }
    public void deleteRecord(ContactModel contactModel){
            database=this.getReadableDatabase();
            database.delete(TABLE_NAME,COLUMN_ID+" = ?",new String[]{contactModel.getID()});
            database.close();
    }

    public ArrayList<ContactModel> getAllRecords(){

        database=this.getReadableDatabase();
        Cursor cursor=database.query(TABLE_NAME,null,null,null,null,null,null);

        ArrayList<ContactModel> contacts=new ArrayList<ContactModel>();
        ContactModel contactModel;

        if(cursor.getCount()>0)
        {
            for(int i=0;i<cursor.getCount();i++)
            {
                cursor.moveToNext();
                contactModel=new ContactModel();
                contactModel.setID(cursor.getString(0));
                contactModel.setFirstName(cursor.getString(1));
                contactModel.setLastName(cursor.getString(2));
                contacts.add(contactModel);
            }
        }
        cursor.close();
        database.close();
        return  contacts;
    }
}
