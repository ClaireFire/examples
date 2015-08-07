package com.yw.diycomponent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yw.diycomponent.MyGrid.GridAdapter;
import com.yw.diycomponent.MyGrid.onItemClickListener;

public class MainActivity extends Activity {
	
	int[] srcs = { R.drawable.actions_booktag, R.drawable.actions_comment,
			R.drawable.actions_order, R.drawable.actions_account,
			R.drawable.actions_cent, R.drawable.actions_weibo,
			R.drawable.actions_feedback, R.drawable.actions_about };
	String titles[] = { "书签", "推荐", "订阅", "账户", "积分", "微博", "反馈", "关于我们" };

	MyGrid myGrid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		myGrid = (MyGrid)this.findViewById(R.id.myGrid);
		myGrid.setAdapter(new GridAdapter() {
			
			@Override
			public View getView(int index) {
				// TODO Auto-generated method stub
				View view = getLayoutInflater().inflate(R.layout.actions_item, null);
				ImageView image = (ImageView)view.findViewById(R.id.iv);
				TextView tv = (TextView)view.findViewById(R.id.tv);
				image.setImageResource(srcs[index]);
				tv.setText(titles[index]);
				return view;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return srcs.length;
			}
		});
		
		myGrid.setOnItemClickListener(new onItemClickListener() {
			
			@Override
			public void onItemClick(View v, int index) {
				// TODO Auto-generated method stub
				TextView tv = (TextView)v.findViewById(R.id.tv);
				Toast.makeText(getApplicationContext(), "点击了"+tv.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
	}

}
