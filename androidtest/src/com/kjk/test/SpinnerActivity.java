package com.kjk.test;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends Activity {
	
	String[] dongNameArr = new String[] {
		"신사동", "압구정동", "논현동", "청담동",
		"삼성동", "대치동", "역삼동", "도곡동",
		"개포동", "일원본동", "일원동", "수서동",
		"세곡동"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		
		final ArrayList<String> dongNameList = new ArrayList<String>();
		for (String dongName : dongNameArr) {
			dongNameList.add(dongName);
		}
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, 0, dongNameList);
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(arrayAdapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Toast.makeText(SpinnerActivity.this, dongNameList.get(arg2), Toast.LENGTH_LONG).show();
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				Toast.makeText(SpinnerActivity.this, "선택하지 않음", Toast.LENGTH_LONG).show();
			}
		});
		
		
		ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, 0, dongNameList);
		Spinner spinner2 = (Spinner) findViewById(R.id.spinner_2);
		spinner2.setAdapter(arrayAdapter2);
		spinner2.setPrompt("동주소를 선택하세요.");
	}
}
