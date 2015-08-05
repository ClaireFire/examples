package com.yw.diycomponent;

import java.util.zip.Inflater;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GridViewAdapterxxx extends BaseAdapter{
	//	private int[] srcs;
	private int[] srcs = {
			R.drawable.apple_itunes, R.drawable.bitlord, R.drawable.chat, R.drawable.clef, 
			R.drawable.clock, R.drawable.contacts, R.drawable.corel, R.drawable.documents1, 
			R.drawable.extra, R.drawable.fallout, R.drawable.goo, R.drawable.i_explorer, 
			R.drawable.network_places, R.drawable.paint, R.drawable.rtm, R.drawable.stellarium, 
			R.drawable.ventrilo, R.drawable.where, R.drawable.win_media, R.drawable.winrar
		};
	private Context con;
	private LayoutInflater inflater;
	
	public Context getCon() {
		return con;
	}

	public void setCon(Context con) {
		this.con = con;
	}

	public int[] getSrcs() {
		return srcs;
	}

	public LayoutInflater getInflater() {
		return inflater;
	}

	public void setInflater(LayoutInflater inflater) {
		this.inflater = inflater;
	}

	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return srcs.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return srcs[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
//			LayoutInflater inflater = LayoutInflater.from(con);
			convertView = inflater.inflate(R.layout.item, null);
			holder.customView = (CustomView) convertView.findViewById(R.id.customviewcell);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.customView.setImageBitmap(BitmapFactory.decodeResource(con.getResources(), srcs[position]));
		holder.customView.setTitleText("第 " + position +" 个一级标题");
		holder.customView.setSubTitleText("第 " + position +" 个二级标题");
		return convertView;
	}

	static class ViewHolder {
		CustomView customView;
	}
	
}
