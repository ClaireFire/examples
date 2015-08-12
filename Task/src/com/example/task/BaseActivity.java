package com.example.task;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class BaseActivity extends Activity {
	ActivityManager mAm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mAm = (ActivityManager) this.getSystemService(this.ACTIVITY_SERVICE);  
	}
	// 运行中的任务  
    public void showRunningTasks(String TAG) {  
        List<ActivityManager.RunningTaskInfo> taskList = mAm.getRunningTasks(100);  
        for (ActivityManager.RunningTaskInfo rti : taskList) {  
            if(rti.topActivity.getPackageName().equals(this.getPackageName())) {  
            	Log.i(TAG, "Task:"+"id=" + rti.id);
            	Log.i(TAG, "description=" + rti.description);
            	Log.i(TAG, "numActivities=" + rti.numActivities);
            	Log.i(TAG, "baseActivity=" + rti.baseActivity.getClassName());
            	Log.i(TAG, "topActivity=" + rti.topActivity.getClassName());
               
            }  
        }  
    }
}
