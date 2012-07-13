package com.kjk.test;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScrollSelector extends ScrollView {
	
	public ScrollSelector(Context context) {
		super(context);
	}
	public ScrollSelector(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	
	LinearLayout linearLayout = null;
	
//	private int topPoint;
	private int topIndex;
	private int currentIndex;
	private int bottomIndex;
	
	ArrayList<String> dataList = null;
	
	static int lineHeight;
	
	LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
			LinearLayout.LayoutParams.FILL_PARENT,
			LinearLayout.LayoutParams.WRAP_CONTENT
	);

	
	public void initialize(ArrayList<String> dataList, int lineHeight) {
//		this.topPoint = 1;
		this.topIndex = dataList.size() - 3;
		this.currentIndex = 0;
		this.bottomIndex = dataList.size() - 4;
		this.dataList = dataList;
		this.lineHeight = lineHeight;
		
		
		linearLayout = new LinearLayout(this.getContext());
//		linearLayout.setBackgroundColor(Color.GRAY);
		linearLayout.setLayoutParams(layoutParams);
		linearLayout.setOrientation(1); // horizontal : 0, vertical : 1
//		linearLayout = (LinearLayout) getChildAt(0);
		
		linearLayout.addView(generateTextView(topIndex), layoutParams);
		linearLayout.addView(generateTextView(topIndex + 1), layoutParams);
		linearLayout.addView(generateTextView(topIndex + 2), layoutParams);
		for (int i = 0; i < dataList.size() - 3; i++) {
			linearLayout.addView(generateTextView(i), layoutParams);
		}
		
		addView(linearLayout);
		
		post(new Runnable() {
			@Override
			public void run() {
				scrollTo(0, ScrollSelector.lineHeight + (ScrollSelector.lineHeight / 2));
			}
		});
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		
		int tempIndex = currentIndex;
		
		View view = linearLayout.getChildAt(1);
		
		if (view == null) {
//			topViewPoint = 0;
		} else if (t < view.getTop()) {
			topIndex--;
			if (topIndex == -1)
				topIndex = dataList.size() - 1;
			
			currentIndex--;
			if (currentIndex == -1)
				currentIndex = dataList.size() - 1;
			
			bottomIndex--;
			if (bottomIndex == -1)
				bottomIndex = dataList.size() - 1;
			
			linearLayout.addView(generateTextView(topIndex), 0, layoutParams);
			linearLayout.removeViewAt(dataList.size());
		} else if (t > view.getBottom()) {
			topIndex++;
			if (topIndex == dataList.size())
				topIndex = 0;
			
			currentIndex++;
			if (currentIndex == dataList.size())
				currentIndex = 0;
			
			bottomIndex++;
			if (bottomIndex == dataList.size())
				bottomIndex = 0;
			
			linearLayout.addView(generateTextView(bottomIndex), dataList.size(), layoutParams);
			linearLayout.removeViewAt(0);
		}
		
//		if (tempIndex != currentIndex) {
//			Log.d("KIMKIMKIM", "change");
//			linearLayout.removeAllViews();
//			this.setLinearLayoutItem();
//		}
		
		Log.d("KIMKIMKIM", "topIndex" + topIndex);
		
//		while (currentIndex < 11) {
//			if (topIndex == 0) {
//				topIndex = 22;
//			} else {
//				topIndex--;
//			}
////			linearLayout.addView(generateTextView(topIndex), 0, layoutParams);
//			
//			if (bottomIndex == 0) {
//				bottomIndex = 22;
//			} else {
//				bottomIndex--;
//			}
////			linearLayout.removeViewAt(22);
//			
//			currentIndex++;
//		}
//		while (currentIndex > 11) {
//			if (topIndex == 22) {
//				topIndex = 0;
//			} else {
//				topIndex++;
//			}
////			linearLayout.removeViewAt(0);
//			
//			if (bottomIndex == 22) {
//				bottomIndex = 0;
//			} else {
//				bottomIndex++;
//			}
////			linearLayout.addView(generateTextView(bottomIndex), 22, layoutParams);
//			
//			currentIndex--;
//		}
//		
//		int j = topIndex;
//		linearLayout.removeAllViews();
//		for (int i = 0; i < 23; i++) {
//			linearLayout.addView(generateTextView(j), layoutParams);
//			j++;
//			if (j == 23)
//				j = 0;
//		}
//		
//		
//		int in = 11;
//		int y = ((in - 2) * lineHeight) + (lineHeight / 2);
//		scrollTo(0, y);		
//		if (currentIndex > 1 && currentIndex < (linearLayout.getChildCount() - 2)) {
//			scrollTo(0, currentIndex*50+25);
//		}
		
//		Toast.makeText(getContext(), dataList.get(currentIndex), Toast.LENGTH_SHORT);

	}

	
	private void setLinearLayoutItem() {
		int tempIndex = this.topIndex;
		for (int i = 0; i < 7; i++) {
			linearLayout.addView(generateTextView(tempIndex), layoutParams);
			tempIndex++;
			if (tempIndex == dataList.size())
				tempIndex = 0;
		}
	}
	
	private TextView generateTextView(int i) {
		TextView textView = new TextView(this.getContext());
		textView.setText(dataList.get(i));
		textView.setTextColor(Color.BLACK);
		textView.setHeight(lineHeight);
		textView.setGravity(Gravity.CENTER);
		textView.setBackgroundResource(R.drawable.scroll_selector_item);
//		textView.setPadding(0, 2, 0, 2);
//		textView.setBackgroundColor(Color.WHITE);
		return textView;
	}
	
	public String getCurrentValue() {
		return dataList.get(currentIndex);
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	

	
}
