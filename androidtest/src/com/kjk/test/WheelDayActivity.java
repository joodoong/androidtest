package com.kjk.test;

import java.util.Calendar;
import java.util.Locale;

import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.NumericWheelAdapter;
import android.app.Activity;
import android.os.Bundle;

public class WheelDayActivity extends Activity {
	
	WheelView wheelYearOfDay;
	WheelView wheelMonthOfDay;
	WheelView wheelDayOfDay;
	int currentYear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wheel_day);
		
		Calendar calendar = Calendar.getInstance(Locale.KOREA);
		
		currentYear = calendar.get(Calendar.YEAR);
		
		wheelYearOfDay = (WheelView) findViewById(R.id.wheelYearOfDay);
		NumericWheelAdapter yearAdapter = new NumericWheelAdapter(this, currentYear, currentYear + 1, "%04d");
		yearAdapter.setItemResource(R.layout.wheel_text_item);
		yearAdapter.setItemTextResource(R.id.txtWheelTextItem);
		wheelYearOfDay.setViewAdapter(yearAdapter);
		wheelYearOfDay.setCurrentItem(0);
		wheelYearOfDay.addScrollingListener(wheelScrollListener);
		
		wheelMonthOfDay = (WheelView) findViewById(R.id.wheelMonthOfDay);
		NumericWheelAdapter monthAdapter = new NumericWheelAdapter(this, 1, 12, "%02d");
		monthAdapter.setItemResource(R.layout.wheel_text_item);
		monthAdapter.setItemTextResource(R.id.txtWheelTextItem);
		wheelMonthOfDay.setViewAdapter(monthAdapter);
		wheelMonthOfDay.setCurrentItem(calendar.get(Calendar.MONTH));
		wheelMonthOfDay.setCyclic(true);
		wheelMonthOfDay.addScrollingListener(wheelScrollListener);
		
		wheelDayOfDay = (WheelView) findViewById(R.id.wheelDayOfDay);
		wheelDayOfDay.setViewAdapter(this.generateDayAdapter(calendar));
		wheelDayOfDay.setCurrentItem(calendar.get(Calendar.DATE) - 1);
		wheelDayOfDay.setCyclic(true);
	}
	
	public NumericWheelAdapter generateDayAdapter(Calendar calendar) {
		NumericWheelAdapter dayAdapter = new NumericWheelAdapter(WheelDayActivity.this, 1, calendar.getActualMaximum(Calendar.DATE), "%02d");
		dayAdapter.setItemResource(R.layout.wheel_text_item);
		dayAdapter.setItemTextResource(R.id.txtWheelTextItem);
		return dayAdapter;
	}
	
	public OnWheelScrollListener wheelScrollListener = new OnWheelScrollListener() {
		@Override
		public void onScrollingStarted(WheelView wheel) {
			
		}
		@Override
		public void onScrollingFinished(WheelView wheel) {
			Calendar newCalendar = Calendar.getInstance();
			
			if (wheelYearOfDay.getCurrentItem() == 0) {
				newCalendar.set(currentYear, wheelMonthOfDay.getCurrentItem(), 1);
			} else {
				newCalendar.set(currentYear + 1, wheelMonthOfDay.getCurrentItem(), 1);
			}
			
			wheelDayOfDay.setViewAdapter(generateDayAdapter(newCalendar));
			
			int dayOfActualMaximum = newCalendar.getActualMaximum(Calendar.DATE);
			if (wheelDayOfDay.getCurrentItem() + 1 > dayOfActualMaximum) {
				wheelDayOfDay.setCurrentItem(dayOfActualMaximum - 1);
			}
		}
	};
}