package com.example.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity_1 extends BaseActivity implements OnClickListener{
	 Button lookTaskInfo;
	 public static final String TAG = "young Activity_1";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lookTaskInfo = (Button)this.findViewById(R.id.lookTaskInfo);
		lookTaskInfo.setOnClickListener(this);
		lookTaskInfo.setText(TAG);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int tag = v.getId();
		switch (tag) {
		case  R.id.lookTaskInfo:
			Intent intent = new Intent(this, Activity_2.class);
			startActivity(intent);
			showRunningTasks(TAG);
			break;
			
		default:
			break;
		}
	}  
}
