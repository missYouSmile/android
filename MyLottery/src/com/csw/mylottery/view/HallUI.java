package com.csw.mylottery.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.csw.mylottery.R;
import com.csw.mylottery.common.ConstantValue;
import com.csw.mylottery.view.base.BaseUI;

public class HallUI extends BaseUI {

	private TextView hallContent;
	
	public HallUI(Context context) {
		super(context);
	}

	@Override
	public void init() {
		contentHolder = (ViewGroup) View.inflate(context, R.layout.hall, null);
		hallContent = (TextView) findViewById(R.id.hall_content);
	}

	@Override
	public void setListener() {
		hallContent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "hello you", Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public int getId() {
		return ConstantValue.ID_HALLUI;
	}

}
