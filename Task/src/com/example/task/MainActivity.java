package com.example.task;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseActivity implements OnClickListener{
	 Button lookTaskInfo;
	 public static final String TAG = "young MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lookTaskInfo = (Button)this.findViewById(R.id.lookTaskInfo);
		lookTaskInfo.setOnClickListener(this);
		lookTaskInfo.setText(TAG);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int tag = v.getId();
		switch (tag) {
		case  R.id.lookTaskInfo:
			Intent intent = new Intent(this, Activity_1.class);
			startActivity(intent);
			showRunningTasks(TAG);
			break;
		default:
			break;
		}
	}  

}
