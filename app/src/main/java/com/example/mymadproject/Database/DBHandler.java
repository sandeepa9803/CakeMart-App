package com.example.mymadproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Database.db";

    public DBHandler (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    //Create a database
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + OrderCake.Orders.TABLE_NAME + " (" +
                    OrderCake.Orders._ID + " INTEGER PRIMARY KEY," +
                    OrderCake.Orders.COLUMN_1 + " TEXT," +
                    OrderCake.Orders.COLUMN_2 + " TEXT," +
                    OrderCake.Orders.COLUMN_3 + " TEXT," +
                    OrderCake.Orders.COLUMN_4 + " TEXT," +
                    OrderCake.Orders.COLUMN_5 + " TEXT," +
                    OrderCake.Orders.COLUMN_6 + " TEXT," +
                    OrderCake.Orders.COLUMN_7 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + OrderCake.Orders.TABLE_NAME;




    //Insert data into the database
    public long addinfo (String ordertype, String ordername, String weight,String quantity, String ordereddate, String price, String paymentmethod ){

        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(OrderCake.Orders.COLUMN_1, ordertype);
        values.put(OrderCake.Orders.COLUMN_2, ordername);
        values.put(OrderCake.Orders.COLUMN_3, weight);
        values.put(OrderCake.Orders.COLUMN_4, quantity);
        values.put(OrderCake.Orders.COLUMN_5, ordereddate);
        values.put(OrderCake.Orders.COLUMN_6, price);
        values.put(OrderCake.Orders.COLUMN_7, paymentmethod);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(OrderCake.Orders.TABLE_NAME, null, values);

        return newRowId;
    }



    //update data in database
    public boolean updateInfo( String ordertype, String ordername, String weight,String quantity,String paymentmethod ){
        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(OrderCake.Orders.COLUMN_1, ordertype);
        values.put(OrderCake.Orders.COLUMN_2, ordername);
        values.put(OrderCake.Orders.COLUMN_3, weight);
        values.put(OrderCake.Orders.COLUMN_4, quantity);
        values.put(OrderCake.Orders.COLUMN_7, paymentmethod);

        // Which row to update, based on the title
        String selection = OrderCake.Orders.COLUMN_2 + " LIKE ?";
        String[] selectionArgs = { ordername };

        int count = db.update(
                OrderCake.Orders.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if(count >=1 ) {
            return true;
        }
        else{
            return false;
        }
    }




    //delete data from database
    public void deleteInfo(String ordername){

        //get object from database
        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = OrderCake.Orders.COLUMN_2 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { ordername };
        // Issue SQL statement.
        int deletedRows = db.delete(OrderCake.Orders.TABLE_NAME, selection, selectionArgs);
    }


    //read Information from  database
    public List readAllInfo (){

        String ordername  = "mihiran";
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                OrderCake.Orders.COLUMN_1,
                OrderCake.Orders.COLUMN_2,
                OrderCake.Orders.COLUMN_3,
                OrderCake.Orders.COLUMN_4,
                OrderCake.Orders.COLUMN_5,
                OrderCake.Orders.COLUMN_6,
                OrderCake.Orders.COLUMN_7

        };

// Filter results WHERE "title" = 'My Title'
        String selection = OrderCake.Orders.COLUMN_2 + " = ?";
        String[] selectionArgs = { ordername };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                OrderCake.Orders.COLUMN_2 + " ASC";

        Cursor cursor = db.query(
                OrderCake.Orders.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List ordernames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String order = cursor.getString(cursor.getColumnIndexOrThrow(OrderCake.Orders.COLUMN_2));
            ordernames.add(order);
        }
        cursor.close();
        return ordernames;

    }

    //read Information from  database
    public List readAllInfo (String ordername){

        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                OrderCake.Orders.COLUMN_1,
                OrderCake.Orders.COLUMN_2,
                OrderCake.Orders.COLUMN_3,
                OrderCake.Orders.COLUMN_4,
                OrderCake.Orders.COLUMN_5,
                OrderCake.Orders.COLUMN_6,
                OrderCake.Orders.COLUMN_7

        };

// Filter results WHERE "title" = 'My Title'
        String selection = OrderCake.Orders.COLUMN_2 + " Like ?";
        String[] selectionArgs = { ordername };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                OrderCake.Orders.COLUMN_2 + " ASC";

        Cursor cursor = db.query(
                OrderCake.Orders.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List orderInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String odtype = cursor.getString(cursor.getColumnIndexOrThrow(OrderCake.Orders.COLUMN_1));
            String odname = cursor.getString(cursor.getColumnIndexOrThrow(OrderCake.Orders.COLUMN_2));
            String weights = cursor.getString(cursor.getColumnIndexOrThrow(OrderCake.Orders.COLUMN_3));
            String quanty = cursor.getString(cursor.getColumnIndexOrThrow(OrderCake.Orders.COLUMN_4));
            String oddate = cursor.getString(cursor.getColumnIndexOrThrow(OrderCake.Orders.COLUMN_5));
            String prices = cursor.getString(cursor.getColumnIndexOrThrow(OrderCake.Orders.COLUMN_6));
            String pmethod = cursor.getString(cursor.getColumnIndexOrThrow(OrderCake.Orders.COLUMN_7));
            orderInfo.add(odtype);//0
            orderInfo.add(odname);//1
            orderInfo.add(weights);//2
            orderInfo.add(quanty);//3
            orderInfo.add(oddate);//4
            orderInfo.add(prices);//5
            orderInfo.add(pmethod);//6


        }
        cursor.close();
        return orderInfo;

    }

}