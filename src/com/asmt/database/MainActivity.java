package com.asmt.database;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	DatabaseAdapter dbAdapter;
	public EditText st_name;
	public EditText st_roll;
	public EditText st_id;
	ListView rowList;
	Button btnSave;	
	public static MainActivity obj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		obj = this;
		st_id = (EditText)findViewById(R.id.editId);
		st_name = (EditText)findViewById(R.id.editName);
		st_roll = (EditText)findViewById(R.id.editRoll);
		rowList = (ListView)findViewById(R.id.listView);
		
		dbAdapter = new DatabaseAdapter(this);
		displayListView();
	}
	public void displayListView(){
		Cursor c = dbAdapter.getAllData();
		int[] ids = new int[c.getCount()];
		String[] names = new String[c.getCount()];
		String[] rolls = new String[c.getCount()];
		int i = 0;
		while(c.moveToNext()){
			ids[i] = c.getInt(c.getColumnIndex(DbConstants._ID));
			names[i] = c.getString(c.getColumnIndex(DbConstants.ST_NAME));
			rolls[i] = c.getString(c.getColumnIndex(DbConstants.ST_ROLL));
			i++;
		}
		i = 0;
		CustomAdapter custmAdapter = new CustomAdapter(this, R.layout.row_list, ids, rolls, names);
		rowList.setAdapter(custmAdapter);
	}
	public void reloadListView(View v){
		refreshAll();
	}
	public void refreshAll(){
		rowList.setAdapter(null);
		st_name.setText("");
		st_roll.setText("");
		st_id.setText("0");
		displayListView();
	}
	public void saveToDatabase(View v){
		ContentValues cv = new ContentValues();
		long id = 0;
		if(st_id.getText().toString().equals("0")){
			cv.put(DbConstants.ST_NAME, st_name.getText().toString());
			cv.put(DbConstants.ST_ROLL, st_roll.getText().toString());
			id = dbAdapter.insertData(cv);
			showToast("row with id : "+id+" is inserted");
		}else{
			cv.put(DbConstants.ST_NAME, st_name.getText().toString());
			cv.put(DbConstants.ST_ROLL, st_roll.getText().toString());			
			id = dbAdapter.updateRowById(st_id.getText().toString(), cv);
			showToast(id+" row updated");
		}	
		
		if(id!=-1){
			st_name.setText("");
			st_roll.setText("");
			st_id.setText("0");
			
			displayListView();
		}
	}
	public void showToast(String msg){
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}
}
