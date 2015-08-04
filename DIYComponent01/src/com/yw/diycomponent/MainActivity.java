package com.yw.diycomponent;
import com.yw.diycomponent.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements View.OnClickListener,View.OnTouchListener{

	public static String TAG = "DIYC1";
	private LinearLayout mLayout;
	private Button mButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mLayout = (LinearLayout)this.findViewById(R.id.mylayout);
		mButton = (Button)this.findViewById(R.id.my_btn);
		
		mLayout.setOnTouchListener(this);
		mButton.setOnTouchListener(this);
		
		mLayout.setOnClickListener(this);
		mButton.setOnClickListener(this);
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		Log.i(TAG, "OnTouchListener--onTouch-- action="+event.getAction()+" --"+v);
        return true;
	}
	@Override
	public void onClick(View v) {
		Log.i(TAG, "OnClickListener--onClick--"+v);
		
	}

}
