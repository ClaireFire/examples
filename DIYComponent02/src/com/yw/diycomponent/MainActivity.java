package com.yw.diycomponent;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity{

	private static final String TAG = "MY_LISTVIEW_ADAPTER";
	private MyCustomAdapter mAdapter;
	private ListView list;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
		list = (ListView)this.findViewById(R.id.list);
		mAdapter = new MyCustomAdapter();
		for (int i = 0; i < 50; i++) {
			mAdapter.addItem("item " + i);
		}
		list.setAdapter(mAdapter);
	}

	private class MyCustomAdapter extends BaseAdapter {

		private ArrayList mData = new ArrayList();
		private LayoutInflater mInflater;

		public MyCustomAdapter() {
			mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public void addItem(final String item) {
			mData.add(item);
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return mData.size();
		}

		@Override
		public String getItem(int position) {
			return (String) mData.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			System.out.println("getView " + position + " " + convertView);
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.item, null);
				holder = new ViewHolder();
				holder.textView = (TextView) convertView
						.findViewById(R.id.text);
				Log.v(TAG, "convertView == null in "+position);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
				Log.v(TAG, "convertView != null in "+position);
			}
			holder.textView.setText((String) mData.get(position));
			return convertView;
		}

	}

	public static class ViewHolder {
		public TextView textView;
	}
}
