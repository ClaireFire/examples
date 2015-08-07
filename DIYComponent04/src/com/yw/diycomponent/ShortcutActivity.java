package com.yw.diycomponent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class ShortcutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shortcut);

//		Intent shortcutIntent = new Intent();
//		// 设置点击快捷方式时启动的Activity,因为是从Lanucher中启动，所以包名类名要写全。
//		shortcutIntent
//				.setComponent(new ComponentName(getPackageName(),
//						getPackageName() + "."
//								+ ShortcutActivity.class.getSimpleName()));
//		// 设置启动的模式
//		shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
//				| Intent.FLAG_ACTIVITY_NEW_TASK);
//
//		Intent resultIntent = new Intent();
//		// 设置快捷方式图标
//		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
//				Intent.ShortcutIconResource.fromContext(this,
//						R.drawable.shortcut_proc_clean));
//		// 启动的Intent
//		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
//		// 设置快捷方式的名称
//		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME,
//				getString(R.string.app_name));
//		setResult(RESULT_OK, resultIntent);
//		finish();
		
		Intent shortcutIntent = new Intent();
		shortcutIntent.setComponent(new ComponentName(getPackageName(), getPackageName()+"."+ShortcutActivity.class.getSimpleName()));
		shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS | Intent.FLAG_ACTIVITY_NEW_TASK);
		Intent resultIntent = new Intent();
		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this, R.drawable.shortcut_proc_clean));
		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
		setResult(RESULT_OK, resultIntent);
		finish();
		
		
	}
}
