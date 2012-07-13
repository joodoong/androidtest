package com.kjk.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteActivity extends Activity {
	
	String[] words = new String[] {
			"�Ż絿-����",
			"�Ż絿-������", "�б�����", "������", "û�㵿",
			"�Ｚ��", "��ġ��", "���ﵿ", "���",
			"������", "�Ͽ�����", "�Ͽ���", "������",
			"���",		"above", "about", "absolute", "access", "activity", "adjust"
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
		
		String wordList = "�ڵ��ϼ� �ܾ� ����Ʈ : ";
		for (String word : words) {
			wordList += word + ", ";
		}
		
		TextView txtAutoCompleteList = (TextView) findViewById(R.id.txtAutoCompleteList);
		txtAutoCompleteList.setText(wordList);
	}
}
