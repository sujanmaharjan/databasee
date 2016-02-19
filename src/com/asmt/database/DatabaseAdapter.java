package com.asmt.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter {
	
	public DatabaseHelper helper;
	public SQLiteDatabase db;
	
	public DatabaseAdapter(Context context) {
		// TODO Auto-generated constructor stub
		helper = new DatabaseHelper(context);
		db = helper.getWritableDatabase();
	}
	public long insertData(ContentValues contentValues){
		long id = db.insert(DbConstants.TB_NAME, null, contentValues);
		return id;
	}
	public Cursor getAllData(){
		String[] columns = new String[]{ DbConstants._ID, DbConstants.ST_NAME, DbConstants.ST_ROLL};
		Cursor cursor = db.query(DbConstants.TB_NAME,columns,null,null,null,null,null);		
		return cursor;
	}
	
	public Cursor getDataByColumn(String key,String value){
		String[] columns = new String[]{ DbConstants._ID, DbConstants.ST_NAME, DbConstants.ST_ROLL};
		Cursor cursor = db.query(DbConstants.TB_NAME,columns, key+" = '"+value+"'" ,null,null,null,null);		
		return cursor;
	}	
	
	public Cursor getDataById(int Id){
		String[] columns = new String[]{ DbConstants._ID, DbConstants.ST_NAME, DbConstants.ST_ROLL};
		Cursor cursor = db.query(DbConstants.TB_NAME,columns, DbConstants._ID+" = "+Id ,null,null,null,null);		
		return cursor;
	}
	
	public int updateRowById(String Id,ContentValues contentValues){
		int ret = db.update(DbConstants.TB_NAME, contentValues, DbConstants._ID+ " = ?", new String[]{Id});
		return ret;
	}
	
	public int deleteRowById(String Id){
		int ret = db.delete(DbConstants.TB_NAME, DbConstants._ID+"=?", new String[]{Id});
		return ret;
	}

}
