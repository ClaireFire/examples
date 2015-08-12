package com.example.task;

import com.example.task.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity_1 extends BaseActivity implements OnClickListener{
	 Button lookTaskInfo;
	 Button itself;
	 public static final String TAG = "young Activity_1";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lookTaskInfo = (Button)this.findViewById(R.id.lookTaskInfo);
		lookTaskInfo.setOnClickListener(this);
		lookTaskInfo.setText(TAG);
		itself = (Button)this.findViewById(R.id.itself);
		itself.setOnClickListener(this);
		itself.setText(TAG+"itself");
		
		showRunningTasks(TAG);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int tag = v.getId();
		switch (tag) {
		case  R.id.lookTaskInfo:
			Intent intent = new Intent(this, Activity_2.class);
			startActivity(intent);
			
			break;
		case  R.id.itself:
			Intent intent2 = new Intent(this, Activity_1.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}  
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "Activity_1 onDestroy");
	}
}
