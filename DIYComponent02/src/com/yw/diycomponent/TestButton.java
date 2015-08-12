package com.yw.diycomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

	public class TestButton extends Button {

	    public TestButton(Context context, AttributeSet attrs) {
	        super(context, attrs);
	    }

	    @Override
	    public boolean dispatchTouchEvent(MotionEvent event) {
	        Log.i(null, "TestButton dispatchTouchEvent-- action=" + event.getAction());
	        return super.dispatchTouchEvent(event);
	    }

	    @Override
	    public boolean onTouchEvent(MotionEvent event) {
	        Log.i(null, "TestButton onTouchEvent-- action=" + event.getAction());
	        return super.onTouchEvent(event);
	    }
	}
