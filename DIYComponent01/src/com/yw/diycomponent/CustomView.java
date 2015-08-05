package com.yw.diycomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;

public class CustomView extends View {
	
	public static final String TAG = "CustomView";
	private Bitmap imageBitmap;
	private float imageAspectRatio;
	private float imageAlpha;
	private float imageScaleType;
	private int imagePaddingLeft;
	private int imagePaddingRight;
	private int imagePaddingTop;
	private int imagePaddingBottom;
	private static final int SCALE_TYPE_FILLXY = 1;
	private static final int SCALE_TYPE_CENTER = 0;
	
	private String titleText;
	private int titleTextSize;
	private int titleTextColor;
	private int titleTextPaddingLeft;
	private int titleTextPaddingRight;
	private int titleTextPaddingTop;
	private int titleTextPaddingBottom;
	
	private String subTitleText;
	private int subTitleTextSize;
	private int subTitleTextColor;
	private int subTitleTextPaddingLeft;
	private int subTitleTextPaddingRight;
	private int subTitleTextPaddingTop;
	private int subTitleTextPaddingBottom;
	
	private Paint paint;
	private TextPaint textPaint;
	private static final int MIN_SIZE = 12;
	private Rect rect;
	private int mViewWidth;
	private int mViewHeight;
	
	
	public CustomView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}
	public CustomView(Context context) {
		this(context,null);
		// TODO Auto-generated constructor stub
	}
	public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
		
		int n = a.getIndexCount();
		for(int i=0;i<n;i++) {
			int attr = a.getIndex(i);
			switch (attr) {
			case R.styleable.CustomView_imageSrc:
				imageBitmap = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
				break;
			case R.styleable.CustomView_imageAlpha:
				imageAlpha = a.getFloat(attr, 1.0f);
				break;
			case R.styleable.CustomView_imageAspectRatio:
				imageAspectRatio = a.getFloat(attr, 1.0f);
				break;
			case R.styleable.CustomView_imageScaleType:
				imageScaleType = a.getFloat(attr, 1.0f);
				break;
			case R.styleable.CustomView_imagePaddingLeft:
				imagePaddingLeft = a.getDimensionPixelSize(attr,0);
				break;
			case R.styleable.CustomView_imagePaddingTop:
				imagePaddingTop = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_imagePaddingRight:
				imagePaddingRight = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_imagePaddingBottom:
				imagePaddingBottom = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_titleText:
				titleText = a.getString(attr);
				break;
			case R.styleable.CustomView_titleTextSize:
				titleTextSize = a.getDimensionPixelSize(attr, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, getResources().getDisplayMetrics()));
				break;
			case R.styleable.CustomView_titleTextColor:
				titleTextColor = a.getColor(attr, 0x00000000);
				break;
			case R.styleable.CustomView_titleTextPaddingLeft:
				titleTextPaddingLeft = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_titleTextPaddingTop:
				titleTextPaddingTop = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_titleTextPaddingRight:
				titleTextPaddingRight = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_titleTextPaddingBottom:
				titleTextPaddingBottom = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_subTitleText:
				subTitleText = a.getString(attr);
				break;
			case R.styleable.CustomView_subTitleTextSize:
				subTitleTextSize = a.getDimensionPixelSize(attr, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
				break;
			case R.styleable.CustomView_subTitleTextColor:
				subTitleTextColor = a.getColor(attr, 0x00000000);
				break;
			case R.styleable.CustomView_subTitleTextPaddingLeft:
				subTitleTextPaddingLeft = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_subTitleTextPaddingTop:
				subTitleTextPaddingTop = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_subTitleTextPaddingRight:
				subTitleTextPaddingRight = a.getDimensionPixelSize(attr, 0);
				break;
			case R.styleable.CustomView_subTitleTextPaddingBottom:
				subTitleTextPaddingBottom = a.getDimensionPixelSize(attr, 0);
				break;
			default:
				break;
			}
		}
		a.recycle();
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		textPaint = new TextPaint();
		rect = new Rect();
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		
		int width;
		int height;
		
		if (widthMode == MeasureSpec.EXACTLY) {
			width = widthSize;
		} else {
			int desired = getPaddingLeft() + getPaddingRight() + 
					imagePaddingLeft + imagePaddingRight;
			desired += (imageBitmap != null) ? imageBitmap.getWidth() : 0;
			width = Math.max(MIN_SIZE, desired);
			if (widthMode == MeasureSpec.AT_MOST) {
				width = Math.min(desired, widthSize);
			}
		}
		
		if (heightMode == MeasureSpec.EXACTLY) {
			height = heightSize;
		} else {
			int rawWidth = width - getPaddingLeft() - getPaddingRight();
			int desired = (int) (getPaddingTop() + getPaddingBottom() + imageAspectRatio * rawWidth);
			
			if (titleText != null) {
				paint.setTextSize(titleTextSize);
				FontMetrics fm = paint.getFontMetrics();
				int textHeight = (int) Math.ceil(fm.descent - fm.ascent);
				desired += (textHeight + titleTextPaddingTop + titleTextPaddingBottom);
			}
			
			if (subTitleText != null) {
				paint.setTextSize(subTitleTextSize);
				FontMetrics fm = paint.getFontMetrics();
				int textHeight = (int) Math.ceil(fm.descent - fm.ascent);
				desired += (textHeight + subTitleTextPaddingTop + subTitleTextPaddingBottom);
			}
			
			height = Math.max(MIN_SIZE, desired);
			if (heightMode == MeasureSpec.AT_MOST) {
				height = Math.min(desired, heightSize);
			}
		}
		
		setMeasuredDimension(width, height);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {	
		mViewWidth = w;
		mViewHeight = h;
		System.out.println("mViewWidth:" + mViewWidth + ",mViewHeight:" + mViewHeight);
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		rect.left = getPaddingLeft();
		rect.top = getPaddingTop();
		rect.right = mViewWidth - getPaddingRight();
		rect.bottom = mViewHeight - getPaddingBottom();
				
		paint.setAlpha(255);
		
		if(subTitleText != null) {
			paint.setTextSize(subTitleTextSize);
			paint.setColor(subTitleTextColor);
			paint.setTextAlign(Paint.Align.LEFT);
			
			FontMetrics fm = paint.getFontMetrics();
			
			int textHeight = (int)Math.ceil(fm.descent - fm.ascent);
			
			int left = getPaddingLeft()+subTitleTextPaddingLeft;
			int right = mViewWidth - getPaddingRight() - subTitleTextPaddingRight;
			int bottom = mViewHeight - getPaddingBottom() - subTitleTextPaddingBottom;
			
			String msg = TextUtils.ellipsize(subTitleText, textPaint, right - left, TextUtils.TruncateAt.END).toString();
			float textWidth = paint.measureText(msg);
			float x = textWidth < (right - left)? (left+(right-left -textWidth)/2)  :left;
			
			canvas.drawText(msg, x, bottom-fm.descent, paint);
			
			rect.bottom -= (subTitleTextPaddingTop + subTitleTextPaddingBottom + textHeight);
		}
		
		if(titleText != null) {
			paint.setTextSize(titleTextSize);
			paint.setColor(titleTextColor);
			paint.setTextAlign(Paint.Align.LEFT);
			
			FontMetrics fm = paint.getFontMetrics();
			int textHeight = (int)Math.ceil(fm.descent-fm.ascent);
			int left = getPaddingLeft()+titleTextPaddingLeft;
			int right = mViewWidth - getPaddingRight() - titleTextPaddingRight;
			int bottom = rect.bottom - titleTextPaddingBottom;
			
			String msg = TextUtils.ellipsize(titleText, textPaint, right - left, TextUtils.TruncateAt.END).toString();
			
			float textWidth = paint.measureText(msg);
			float x = textWidth < (right - left)?(left + (right-left -textWidth)/2):left;
			
			canvas.drawText(msg, x, bottom-fm.descent, paint);
			rect.bottom -= (textHeight + titleTextPaddingTop+titleTextPaddingBottom);
		}
		
		if(imageBitmap !=null) {
			paint.setAlpha((int)(imageAlpha*255));
			
			rect.left += imagePaddingLeft;
			rect.right -= imagePaddingRight;
			rect.top += imagePaddingTop;
			rect.bottom -= imagePaddingBottom;
			
			if (imageScaleType == SCALE_TYPE_FILLXY) {
				canvas.drawBitmap(imageBitmap, null, rect, paint);
			} else if(imageScaleType == SCALE_TYPE_CENTER) {
				int bw = imageBitmap.getWidth();
				int bh = imageBitmap.getHeight();
				if(bw < (rect.right-rect.left)) {
					int delta = (rect.right - rect.left -bw)/2;
					rect.left +=delta;
					rect.right -=delta;
				}
				
				if (bh < rect.bottom - rect.top) {
		 			int delta = (rect.bottom - rect.top - bh) / 2;
					rect.top += delta;
					rect.bottom -= delta;
				}
				canvas.drawBitmap(imageBitmap, null, rect, paint);
			}
		}
		
	}
	public void setImageBitmap(Bitmap bitmap) {
		imageBitmap = bitmap;
		requestLayout();
		invalidate();
		
	}
	public void setTitleText(String text) {
		titleText = text;
		requestLayout();
		invalidate();
	}
	public void setSubTitleText(String text) {
		subTitleText = text;
		requestLayout();
		invalidate();
	}
	
	
}
