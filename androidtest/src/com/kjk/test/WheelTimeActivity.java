package com.kjk.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import kankan.wheel.widget.adapters.NumericWheelAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WheelTimeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wheel_time);
		
		Calendar calendar = Calendar.getInstance(Locale.KOREA);
		
		final WheelView wheelDay = (WheelView) findViewById(R.id.wheelDay);
		wheelDay.setViewAdapter(new DayArrayAdapter(this, calendar));
		
		final WheelView wheelHour = (WheelView) findViewById(R.id.wheelHour);
		NumericWheelAdapter hourAdapter = new NumericWheelAdapter(this, 0, 23, "%02d");
		hourAdapter.setItemResource(R.layout.wheel_text_item);
		hourAdapter.setItemTextResource(R.id.txtWheelTextItem);
		wheelHour.setViewAdapter(hourAdapter);
		wheelHour.setCurrentItem(calendar.get(Calendar.HOUR));
		
		final WheelView wheelMins = (WheelView) findViewById(R.id.wheelMins);
		NumericWheelAdapter minsAdapter = new NumericWheelAdapter(this, 0, 59, "%02d");
		minsAdapter.setItemResource(R.layout.wheel_text_item);
		minsAdapter.setItemTextResource(R.id.txtWheelTextItem);
		wheelMins.setViewAdapter(minsAdapter);
		wheelMins.setCyclic(true);
		wheelMins.setCurrentItem(calendar.get(Calendar.MINUTE));
		
		final WheelView wheelAmpm = (WheelView) findViewById(R.id.wheelAmpm);
		ArrayWheelAdapter<String> ampmAdapter = new ArrayWheelAdapter<String> (this, new String[] {"AM", "PM"});
		ampmAdapter.setItemResource(R.layout.wheel_text_item);
		ampmAdapter.setItemTextResource(R.id.txtWheelTextItem);
		wheelAmpm.setViewAdapter(ampmAdapter);
		wheelAmpm.setCurrentItem(calendar.get(Calendar.AM_PM));
		
		Button btnWheelTime = (Button) findViewById(R.id.btnWheelTime);
		btnWheelTime.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String now = wheelHour.getCurrentItem() + " ½Ã " + wheelMins.getCurrentItem() + " ºÐ ";
				if (wheelAmpm.getCurrentItem() == 0) {
					now += "am";
				} else {
					now += "pm";
				}
				Toast.makeText(WheelTimeActivity.this, now, Toast.LENGTH_LONG).show();
			}
		});
	}
	
	private class DayArrayAdapter extends AbstractWheelTextAdapter {
		
		private final int daysCount = 20;
		
		Calendar calendar;
		
		protected DayArrayAdapter(Context context, Calendar calendar) {
			super(context, R.layout.wheel_day_item, NO_RESOURCE);
			
			this.calendar = calendar;
			
			setItemTextResource(R.id.txtMonthDay);
		}
		
		@Override
		public View getItem(int index, View convertView, ViewGroup parent) {
			int day = index - (daysCount / 2);
			Calendar newCalendar = (Calendar) calendar.clone();
			newCalendar.roll(Calendar.DAY_OF_YEAR, day);
			
			View view = super.getItem(index, convertView, parent);
			
			TextView txtWeekDay = (TextView) view.findViewById(R.id.txtWeekDay);
			TextView txtMonthDay = (TextView) view.findViewById(R.id.txtMonthDay);
			
			if (day == 0) {
				txtWeekDay.setText("");
				txtMonthDay.setText("Today");
				txtMonthDay.setTextColor(0xFF0000F0);
			} else {
				txtWeekDay.setText(new SimpleDateFormat("EEE").format(newCalendar.getTime()));
				txtMonthDay.setText(new SimpleDateFormat("MMM d").format(newCalendar.getTime()));
				txtMonthDay.setTextColor(0xFF111111);
			}
			
			return view;
		}
		
		@Override
		public int getItemsCount() {
			return this.daysCount + 1;
		}
		
		@Override
		protected CharSequence getItemText(int index) {
			return "test";
		}
	}
}
