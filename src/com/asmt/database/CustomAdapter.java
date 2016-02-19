package com.asmt.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	
	private Context c;
	private int RES;
	private int[] IDS;
	private String[] ROLLS;
	private String[] NAMES;
	LayoutInflater lf;
	DatabaseAdapter dbAdapter;
		
	public CustomAdapter(Context context,int res,int[] ids,String[] rolls,String[] names){
		c=context;
		RES = res;
		IDS = ids;
		ROLLS = rolls;
		NAMES = names;
		lf = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		dbAdapter = new DatabaseAdapter(c);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return IDS.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	public class ViewHolder{
		TextView id;
		TextView roll;
		TextView name;
		Button	edit;
		Button delete;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		View vi = convertView;
		if(vi==null){
			vi = lf.inflate(RES,null);
			holder = new ViewHolder();
			holder.id = (TextView)vi.findViewById(R.id.rowId);
			holder.roll = (TextView)vi.findViewById(R.id.rowRoll);
			holder.name = (TextView)vi.findViewById(R.id.rowName);
			holder.edit = (Button)vi.findViewById(R.id.btnEdit);
			holder.delete = (Button)vi.findViewById(R.id.btnDelete);
			vi.setTag(holder);
		}else{
			holder=(ViewHolder)vi.getTag();
		}
		holder.id.setText(IDS[position]+"");
		holder.roll.setText(ROLLS[position]);
		holder.name.setText(NAMES[position]);
		holder.edit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				MainActivity.obj.st_name.setText(NAMES[position]);
				MainActivity.obj.st_roll.setText(ROLLS[position]);
				MainActivity.obj.st_id.setText(IDS[position]+"");
			}
		});
		holder.delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dbAdapter.deleteRowById(IDS[position]+"");
				MainActivity.obj.refreshAll();
			}
		});
		
		return vi;
	}

}
