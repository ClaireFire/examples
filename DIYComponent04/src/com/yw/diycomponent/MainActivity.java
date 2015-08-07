package com.yw.diycomponent;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(v.getContext(), ShortcutActivity.class);
				startActivity(intent);
				sendBorcastReceiver();
			}
		});
	}
	
	public void sendBorcastReceiver(){
		Intent shortcutIntent = new Intent();
		shortcutIntent.setComponent(new ComponentName(getPackageName(), getPackageName()+"."+ShortcutActivity.class.getSimpleName()));
		shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS | Intent.FLAG_ACTIVITY_NEW_TASK);
		Intent resultIntent = new Intent();
		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this, R.drawable.shortcut_proc_clean));
		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
		resultIntent.setAction(ACTION_INSTALL_SHORTCUT);  
        sendBroadcast(resultIntent);  
	}

}
