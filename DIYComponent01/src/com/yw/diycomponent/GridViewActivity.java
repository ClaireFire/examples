package com.yw.diycomponent;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class GridViewActivity extends Activity {
	private GridView gridView;
	private GridViewAdapter adapter;
	private LayoutInflater inflater;
	private int[] srcs = {
			R.drawable.apple_itunes, R.drawable.bitlord, R.drawable.chat, R.drawable.clef, 
			R.drawable.clock, R.drawable.contacts, R.drawable.corel, R.drawable.documents1, 
			R.drawable.extra, R.drawable.fallout, R.drawable.goo, R.drawable.i_explorer, 
			R.drawable.network_places, R.drawable.paint, R.drawable.rtm, R.drawable.stellarium, 
			R.drawable.ventrilo, R.drawable.where, R.drawable.win_media, R.drawable.winrar
		};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);
		
		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		gridView = (GridView) findViewById(R.id.gridview);
		adapter = new GridViewAdapter();
		gridView.setAdapter(adapter);
	}
	private class GridViewAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return srcs.length;
		}

		@Override
		public Object getItem(int position) {
			return srcs[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = inflater.inflate(R.layout.item, null);
				holder.customView = (CustomView) convertView.findViewById(R.id.customviewcell);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.customView.setImageBitmap(BitmapFactory.decodeResource(getResources(), srcs[position]));
			holder.customView.setTitleText("�� " + position +" ��һ������");
			holder.customView.setSubTitleText("�� " + position +" ����������");
			return convertView;
		}
		
	}
	static class ViewHolder {
		CustomView customView;
	}
}