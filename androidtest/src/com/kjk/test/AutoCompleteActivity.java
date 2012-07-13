package com.kjk.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteActivity extends Activity {
	
	String[] words = new String[] {
			"신사동-은평구",
			"신사동-강남구", "압구정동", "논현동", "청담동",
			"삼성동", "대치동", "역삼동", "도곡동",
			"개포동", "일원본동", "일원동", "수서동",
			"세곡동",		"above", "about", "absolute", "access", "activity", "adjust"
		,"abc","abc1","abc2","abc3","abc4","abc5","abc6","abc7","abc8","abc9"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auto_complete);
		
		ArrayAdapter<String> wordArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, words);
		
		final AutoCompleteTextView autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);
		autoComplete.setAdapter(wordArrayAdapter);
		autoComplete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				autoComplete.showDropDown();
			}
		});
		
		String wordList = "자동완성 단어 리스트 : ";
		for (String word : words) {
			wordList += word + ", ";
		}
		
		TextView txtAutoCompleteList = (TextView) findViewById(R.id.txtAutoCompleteList);
		txtAutoCompleteList.setText(wordList);
	}
}
