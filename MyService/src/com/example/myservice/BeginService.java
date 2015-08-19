package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BeginService extends Service {

	public IBinder mBinder;
	
	class MyBinder extends Binder {
		
		public BeginService getService() {
			return BeginService.this;
		}
		
		public String helloService(String name) {
			return "hello Service I'm "+ name;
		}
	}
	private static final String TAG = "young";
	public void helloYoung(){
		for(int i=0;i<100;i++)
		{
			try {
				Thread.sleep(1000) ;
				
				Log.i(TAG, "Starting BeginService :"+i) ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "BeginService onBind()") ;
		return new MyBinder();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				helloYoung();
			}
		}).start();
//		for(int i=0;i<100;i++)
//		{
//			try {
//				Thread.sleep(1000) ;
//				Log.i(TAG, "Starting BeginService :"+i) ;
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i(TAG, "BeginService onCreate()") ;
		super.onCreate();
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(TAG, "BeginService onDestroy()") ;
		super.onDestroy();
	}
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "BeginService onUnbind()") ;
		return super.onUnbind(intent);
	}
	
	
}
