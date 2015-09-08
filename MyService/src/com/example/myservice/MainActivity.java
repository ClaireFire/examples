package com.example.myservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.myservice.BeginService.MyBinder;


public class MainActivity extends ActionBarActivity {

	Button btnBeginService;
	Button btnStopService;
	Button btnYoungIntentStartService;
	Button btnYoungIntentEndService;
	Intent mIntent;
	Intent mYoungIntent;
	ServiceConnection sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         	sc = new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				MyBinder myBinder = (MyBinder)service;
				myBinder.helloService("youngway");
				Toast.makeText(MainActivity.this, myBinder.helloService("youngway"), 3000).show();
				BeginService beginService = myBinder.getService();
				beginService.helloYoung();
			}
		};
        btnBeginService = (Button)this.findViewById(R.id.btnBeginService);
        btnBeginService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mIntent = new Intent(MainActivity.this, BeginService.class);
				bindService(mIntent, sc, Service.BIND_AUTO_CREATE);
//				startService(mIntent);
			}
		});
        
        btnStopService = (Button)this.findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(mIntent);
			}
		});
        
        
        btnYoungIntentStartService = (Button)this.findViewById(R.id.btnYoungIntentStartService);
        btnYoungIntentStartService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mYoungIntent = new Intent(MainActivity.this, YoungIntentService.class);
				startService(mYoungIntent);
			}
		});
        
        
        btnYoungIntentEndService = (Button)this.findViewById(R.id.btnYoungIntentEndService);
        btnYoungIntentEndService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(mYoungIntent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
