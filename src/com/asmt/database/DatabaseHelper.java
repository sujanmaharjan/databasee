package com.asmt.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	

	public DatabaseHelper(Context context) {
		super(context, DbConstants.DB_NAME, null, DbConstants.DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try {
			db.execSQL(DbConstants.CREATE_QUERY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// TODO Auto-generated method stub
		db.execSQL(DbConstants.DELETE_QUERY);
		onCreate(db);
	}

}
