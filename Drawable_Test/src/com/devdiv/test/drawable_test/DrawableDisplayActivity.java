package com.devdiv.test.drawable_test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class DrawableDisplayActivity extends Activity {
	
	//定义常量，区分调用该Activity的Intent
	// final定义类表示类不可以被继承；
    //定义方法不可以被重载； 定义变量表示变量值不可以被改变。
	/**
	 * 表示列表中的第一项被选中
	 */
    private static final int COLOR_DRAWABLE = 0;
    private static final int GRADIENT_DRAWABLE_JAVA = 1;
    private static final int GRADIENT_DRAWABLE_XML = 2;
    private static final int BITMAP_DRAWABLE_JAVA = 3;
    private static final int BITMAP_DRAWABLE_XML = 4;
    private static final int NINE_PATCH_DRAWABLE = 5;
    private static final int INSET_DRAWABLE = 6;
    private static final int CLIP_DRAWABLE = 7;
    private static final int SCALE_DRAWABLE = 8;
    private static final int ROTATE_DRAWABLE = 9;
    private static final int ANIMATION_LIST_DRAWABLE = 10;
    private static final int LAYER_DRAWABLE = 11;
    private static final int TRANSTION_DRAWABLE = 12;
    private static final int LEVEL_LIST_DRAWABLE = 13;
    private static final int STATE_LIST_DRAWABLE = 14;    
    private static final int DEFAULT= COLOR_DRAWABLE;

    private final Handler mHandler = new Handler();
    private Drawable mDrawable;
	

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.drawabledisplaylayout);
		
		final Intent mIntent = getIntent();
		
		if(mIntent != null) {
			//public int getIntExtra (String name, int defaultValue)
			int mflag = mIntent.getIntExtra("INTENT_FLAG", COLOR_DRAWABLE);
			switch(mflag) {
			case COLOR_DRAWABLE:			
				//通过JAVA代码创建ColorDrawable
				//前两个F，代表透明度，必须要有，不然无法显示Drawable
				//xml文件中可以省略透明度：android:color="#FF0000"		
				mDrawable = new ColorDrawable(0xff0000ff);
				
				//通过XML创建ColorDrawable
				//mDrawable = getResources().getDrawable(R.drawable.color_red);
				//mDrawable = getResources().getDrawable(R.drawable.color_green);
				//mDrawable = getResources().getDrawable(R.drawable.color_blue);
				//mDrawable = getResources().getDrawable(R.drawable.color_other);

				break;
				
			case GRADIENT_DRAWABLE_JAVA:
				//通过JAVA代码创建GradientDrawable
				mDrawable = new GradientDrawable(Orientation.BR_TL, new int[] {Color.RED, Color.GREEN, Color.BLUE});
				//mDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[] {Color.RED, Color.GREEN, Color.BLUE});
				
				//Set to true to have the drawable dither its colors 
				//when drawn to a device with fewer than 8-bits per color component. 
				//This can improve the look on those devices, 
				//but can also slow down the drawing a little.
				mDrawable.setDither(true);
				
				break;
				
			case GRADIENT_DRAWABLE_XML:
				//通过XML创建GradientDrawable
				//mDrawable = getResources().getDrawable(R.drawable.gradient_circle);
				//mDrawable = getResources().getDrawable(R.drawable.gradient_oval);
				mDrawable = getResources().getDrawable(R.drawable.gradient_ring);
				
				break;
				
			case BITMAP_DRAWABLE_JAVA:
				//通过JAVA代码创建Bitmap
//				BitmapDrawable mBitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.droid_logo);
//				mBitmapDrawable.setGravity(Gravity.CENTER);
//				mBitmapDrawable.setAntiAlias(true);
//				mBitmapDrawable.setDither(true);
//				mDrawable = mBitmapDrawable;
				
				Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.png_icon_416);
				BitmapDrawable mBitmapDrawable = new BitmapDrawable(mBitmap);
				mBitmapDrawable.setTileModeXY(TileMode.MIRROR, TileMode.MIRROR);
				mBitmapDrawable.setAntiAlias(true);
				mBitmapDrawable.setDither(true);
				mDrawable = mBitmapDrawable;
				
				break;
				
			case BITMAP_DRAWABLE_XML:
				//通过XML创建Bitmap
				//mDrawable = getResources().getDrawable(R.drawable.bitmap_grid);
				mDrawable = getResources().getDrawable(R.drawable.bitmap_bell);
				
				break;
				
			case NINE_PATCH_DRAWABLE:
				//直接使用点九图片
				mDrawable = getResources().getDrawable(R.drawable.nine_patch);
				
				break;
				
			case INSET_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.inset_1);
				
				break;
				
			case CLIP_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.clip);
				mDrawable = getResources().getDrawable(R.drawable.clip_2);
				mDrawable = getResources().getDrawable(R.drawable.clip_3);
				break;
				
			case SCALE_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.scale);
				
				break;
				
			case ROTATE_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.rotate);
				
				break;
				
			case ANIMATION_LIST_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.animation);
				
				mHandler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						((AnimationDrawable)mDrawable).start();
					}
				}, 1000);
				
				break;
				
			case LAYER_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.layer);
				
				break;
				
			case TRANSTION_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.transition);
				mHandler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						((TransitionDrawable)mDrawable).startTransition(2000);
					}
				}, 1000);
				
				break;
				
			case LEVEL_LIST_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.levellist);
				
				break;
				
			case STATE_LIST_DRAWABLE:
				mDrawable = getResources().getDrawable(R.drawable.statelist);
				
				break;
				
			default:
				break;
			}
			
			if(mDrawable != null) {
				setContentView(R.layout.drawabledisplaylayout);
				findViewById(R.id.mdrawableview).setBackgroundDrawable(mDrawable);
				
				SeekBar mSeekBar = (SeekBar) findViewById(R.id.mseekbar);

				//Set the range of the progress bar to 0...max.
				//Parameters: max  the upper range of this progress bar 
				mSeekBar.setMax(10000);
				mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					
					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						
						//Specify the level for the drawable. 
						//This allows a drawable to vary its imagery based on a continuous controller, 
						//for example to show progress or volume level. 
						mDrawable.setLevel(progress);
					}
				});
			}
		}
		
		
		
//		TextView mTextView = (TextView) findViewById(R.id.mtextview);		
//		int flag = getIntent().getIntExtra("INTENT_FLAG", 1000);
//		Log.d("test", "getIntent()---Succeed");
//		
//		String[] mStrings = getResources().getStringArray(R.array.listview_items);
//		mTextView.setText(mStrings[flag]);		
//		mTextView.setText("position"+this.getIntent().getIntExtra("INTENT_FLAG", 1000));
	}
	

//	@Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//		super.onResume();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		((AnimationDrawable)mDrawable).start();
//	}
	

}
