package com.yw.diycomponent;
import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yw.util.Util;

public class MainActivity extends Activity implements View.OnClickListener{

	public static final String TAG = "young";
	public static final int MAIN_REQUEST_CODE = 101;
	public static final String MY_FILE = "young";
	private EditText et;
	private Button toSecond;
	private Button remenber;
	private Button clean;
	private Button intentAction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
		setContentView(R.layout.main);
		et = (EditText)this.findViewById(R.id.et);
		toSecond = (Button)this.findViewById(R.id.toSecond);
		remenber = (Button)this.findViewById(R.id.remenber);
		clean = (Button)this.findViewById(R.id.clean);
		intentAction = (Button)this.findViewById(R.id.intentAction);
		SharedPreferences sp = getSharedPreferences(MY_FILE, 0);
		et.setText(sp.getString("name", ""));
		remenber.setOnClickListener(this);
		clean.setOnClickListener(this);
		toSecond.setOnClickListener(this);
		intentAction.setOnClickListener(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // If the request went well (OK) and the request was PICK_CONTACT_REQUEST
	    if (resultCode == 123) {
	       Toast.makeText(this, data.getStringExtra("SECOND"), 3000).show();
	    }
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "MainActivity -->"+Util.printCurrentMethod());
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int tag =  v.getId();
		switch (tag) {
		case R.id.toSecond:
			Intent intent = new Intent(MainActivity.this,SecondActivity.class);
			intent.putExtra("MAIN", "I am from mainactivity!");
			startActivityForResult(intent, MAIN_REQUEST_CODE);
			break;
		case R.id.remenber:
			SharedPreferences sp = getSharedPreferences(MY_FILE, 0);
			SharedPreferences.Editor editor = sp.edit();
			editor.putString("name", et.getText().toString());
			editor.commit();
			break;
		case R.id.clean:
			SharedPreferences sp2 = getSharedPreferences(MY_FILE, 0);
			SharedPreferences.Editor editor2 = sp2.edit();
			editor2.putString("name", "");
			editor2.commit();
			break;
		case R.id.intentAction:
			Intent sendIntent = new Intent();
			
			sendIntent.setAction(Intent.ACTION_SEND);
			sendIntent.putExtra(Intent.EXTRA_TEXT, "x速度快了房价开始的飞机上两地分居围殴个个个个个个个个个个个个个个个个irupqiewrklsjdfklsdjf");
			sendIntent.setType(HTTP.PLAIN_TEXT_TYPE); // "text/plain" MIME type
			String title = getResources().getString(R.string.chooser_title);
			// Create intent to show the chooser dialog
			Intent chooser = Intent.createChooser(sendIntent, title);
			
			// Verify that the intent will resolve to an activity
			if (sendIntent.resolveActivity(getPackageManager()) != null) {
			    startActivity(sendIntent);
			}
		default:
			break;
		}
	}
}
