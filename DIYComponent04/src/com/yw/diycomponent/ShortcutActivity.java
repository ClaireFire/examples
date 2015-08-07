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
//		// ���õ����ݷ�ʽʱ������Activity,��Ϊ�Ǵ�Lanucher�����������԰�������Ҫдȫ��
//		shortcutIntent
//				.setComponent(new ComponentName(getPackageName(),
//						getPackageName() + "."
//								+ ShortcutActivity.class.getSimpleName()));
//		// ����������ģʽ
//		shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
//				| Intent.FLAG_ACTIVITY_NEW_TASK);
//
//		Intent resultIntent = new Intent();
//		// ���ÿ�ݷ�ʽͼ��
//		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
//				Intent.ShortcutIconResource.fromContext(this,
//						R.drawable.shortcut_proc_clean));
//		// ������Intent
//		resultIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
//		// ���ÿ�ݷ�ʽ������
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
