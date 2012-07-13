package com.kjk.test;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

public class ScrollSelecterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scroll_selecter);
		

		ArrayList<String> dataList = new ArrayList<String>();
		for (int i = 1; i < 24; i++) {
			dataList.add("data no " + i);
		}
		
		
		final ScrollSelector scrollSelector = (ScrollSelector) findViewById(R.id.scrollSelector);
		scrollSelector.initialize(dataList, 50);
//		scrollSelector.setOnTouchListener(new View.OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				switch (event.getAction()) {
//				case MotionEvent.ACTION_DOWN:
//					TextView text = (TextView) findViewById(R.id.txtScrollResult);
//					text.setText(scrollSelector.getCurrentValue());
//					return true;
//				default:
//					return false;
//				}
//			}
//		});
		
//		final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
//		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayoutInScroll);
//
//		final int lineHeight = 50;
//		int scrollHeight = scrollView.getHeight();
//		int lineCount = 24;
//		for (int i = 1; i < 24; i++) {
//			TextView textView = new TextView(this);
//			textView.setText("text no " + i);
//			textView.setTextColor(Color.BLACK);
//			textView.setHeight(lineHeight);
//			textView.setGravity(Gravity.CENTER);
//			
//			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//					LinearLayout.LayoutParams.FILL_PARENT,
//					LinearLayout.LayoutParams.WRAP_CONTENT
//			);
//			
//			linearLayout.addView(textView, lp);
//		}
		
		
		
		
		
		
		
	}

}
