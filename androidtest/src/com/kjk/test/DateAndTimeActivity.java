package com.kjk.test;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class DateAndTimeActivity extends Activity {

	Calendar dateAndTime = Calendar.getInstance();
	DateFormat dateFormat = DateFormat.getDateTimeInstance();
	
	TextView txtDateAndTime = null;
	
	DatePickerDialog.OnDateSetListener dateSetListener = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			dateAndTime.set(Calendar.YEAR, year);
			dateAndTime.set(Calendar.MONTH, monthOfYear);
			dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateDateAndTime();
		}
	};
	
	TimePickerDialog.OnTimeSetListener timeSetListener = new OnTimeSetListener() {
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
			dateAndTime.set(Calendar.MINUTE, minute);
			updateDateAndTime();
		}
	};
	
	private void updateDateAndTime() {
		txtDateAndTime.setText(dateFormat.format(dateAndTime.getTime()));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_and_time);
		
		txtDateAndTime = (TextView) findViewById(R.id.txtDateAndTime);
		
		Button btnDateDialog = (Button) findViewById(R.id.btnDateDialog);
		Button btnTimeDialog = (Button) findViewById(R.id.btnTimeDialog);
		
		txtDateAndTime.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new DatePickerDialog(DateAndTimeActivity.this,
						dateSetListener,
						dateAndTime.get(Calendar.YEAR),
						dateAndTime.get(Calendar.MONTH),
						dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		btnDateDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new DatePickerDialog(DateAndTimeActivity.this,
						dateSetListener,
						dateAndTime.get(Calendar.YEAR),
						dateAndTime.get(Calendar.MONTH),
						dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		btnTimeDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new TimePickerDialog(DateAndTimeActivity.this,
						timeSetListener,
						dateAndTime.get(Calendar.HOUR_OF_DAY),
						dateAndTime.get(Calendar.MINUTE),
						false).show();
			}
		});
		
		updateDateAndTime();
	}
}
