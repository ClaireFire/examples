package com.devdiv.test.drawable_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Drawable_TestActivity extends Activity {
	
	private ListView mListView;
	private ArrayAdapter<String> mArrayAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //注意array文件的定义，以及获取array文件中字符串数组的方法。
        mListView = (ListView) findViewById(R.id.mlistview);
        String[] mStrings = this.getResources().getStringArray(R.array.listview_items);
        mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);
        mListView.setAdapter(mArrayAdapter);
        
        mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(Drawable_TestActivity.this, DrawableDisplayActivity.class);
				mIntent.putExtra("INTENT_FLAG", position);
				startActivity(mIntent);
				
			}
		});
 
    }
}