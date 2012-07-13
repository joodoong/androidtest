package com.kjk.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndroidtestActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        int a;
        Button btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AndroidtestActivity.this, DateAndTimeActivity.class);
				startActivity(intent);
			}
		});
		
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AndroidtestActivity.this, AutoCompleteActivity.class);
				startActivity(intent);
			}
		});
		
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AndroidtestActivity.this, SpinnerActivity.class);
				startActivity(intent);
			}
		});
        
        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AndroidtestActivity.this, ScrollSelecterActivity.class);
				startActivity(intent);
			}
		});
        
        Button btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AndroidtestActivity.this, WheelTimeActivity.class);
				startActivity(intent);
			}
		});
        
        Button btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AndroidtestActivity.this, WheelDayActivity.class);
				startActivity(intent);
			}
		});
        
        Button btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AndroidtestActivity.this, AnimationActivity.class);
				startActivity(intent);
			}
		});
    }
}