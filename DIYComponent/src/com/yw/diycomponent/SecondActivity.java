package com.yw.diycomponent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yw.util.Util;

public class SecondActivity extends Activity {
	public static final String TAG = "young";
	Button toMain;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
		setContentView(R.layout.second);
		intent = this.getIntent();
		Toast.makeText(this, intent.getStringExtra("MAIN"), 3000).show();
		toMain = (Button)this.findViewById(R.id.toMain);
		toMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				intent.putExtra("SECOND", "I am from seconde!");
				setResult(123, intent);
				finish();
			}
		});
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "SecondActivity -->"+Util.printCurrentMethod());
	}
}
