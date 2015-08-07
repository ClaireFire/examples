package com.yw.diycomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class MyGrid extends ViewGroup {

	private int numColumns = 2;
	private int itemMargin = 1;
	
	private int mWidth;
	private int mHeight;

	private int count;
	
	public GridAdapter adapter;
	public MyGrid(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyGrid, defStyle, 0);
		itemMargin = a.getInt(R.styleable.MyGrid_itemMargin, 2);
		numColumns = a.getInt(R.styleable.MyGrid_numColumns, 2);
	}

	public MyGrid(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public MyGrid(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int mMaxChildWidth = 0;
		int mMaxChildHeight = 0;
		
		int modeW = 0;
		int modeH = 0;
		
		if(MeasureSpec.UNSPECIFIED != MeasureSpec.getMode(widthMeasureSpec)) {
			modeW = MeasureSpec.UNSPECIFIED;
		}
		
		if(MeasureSpec.UNSPECIFIED != MeasureSpec.getMode(heightMeasureSpec)){
			modeH = MeasureSpec.UNSPECIFIED;
		}
		int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(widthMeasureSpec, modeW);
		int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightMeasureSpec, modeH);
		
		count = getChildCount();
		if (count == 0) {
			setMeasuredDimension(childWidthMeasureSpec, childHeightMeasureSpec);
			return;
		}
		for(int i = 0 ;i<count;i++) {
			View child = getChildAt(i);
			
			child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
			mMaxChildWidth = Math.max(mMaxChildWidth, child.getMeasuredWidth());
			mMaxChildHeight = Math.max(mMaxChildHeight, child.getMeasuredHeight());
		}
		setMeasuredDimension(resolveSize(mMaxChildWidth,widthMeasureSpec),resolveSize(mMaxChildHeight, heightMeasureSpec));
	}
	
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		int width = r - l;
		int height = b - t;
		int rows = (count % numColumns == 0) ? (count / numColumns) : ((count / numColumns) +1);
		
		int gridW = (width - itemMargin*(numColumns -1))/numColumns;
		int gridH = (height - itemMargin*(rows-1))/rows;
		int left = 0;
		int top = itemMargin;
		for(int i = 0; i<rows ; i++) {
			for(int j = 0 ;j<numColumns;j++) {
				View child = getChildAt(i*numColumns + j);
				if(child == null) {
					return;
				} else {
					left = j*gridW + itemMargin*j;
				}
				child.layout(left, top, left+gridW, top+gridH);
			}
			top += gridH +itemMargin;
		}
	}
	
	public interface GridAdapter{
		public View getView(int index);
		public int getCount();
	}
	
	public void setAdapter(GridAdapter gridAdapter) {
		this.adapter = gridAdapter;
		int count = gridAdapter.getCount();
		for(int i = 0;i<count;i++) {
			addView(gridAdapter.getView(i));
		}
	}
	
	public interface onItemClickListener{
		public void onItemClick(View v,int index) ;
	}
	
	public void setOnItemClickListener(final onItemClickListener click) {
		if(this.adapter == null) {
			return;
		}
		
		for(int i = 0;i<adapter.getCount();i++) {
			final int index = i;
			View v = getChildAt(i);
			v.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					click.onItemClick(v, index);
				}
			});
		}
	}
}
