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

public class LoginUI extends BaseUI {

	private TextView loginContent;
	
	public LoginUI(Context context) {
		super(context);
	}

	@Override
	public void init() {
		contentHolder = (ViewGroup) View.inflate(context, R.layout.login, null);
		loginContent = (TextView) findViewById(R.id.login_content);
	}

	@Override
	public void setListener() {
		loginContent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "login", Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public int getId() {
		return ConstantValue.ID_LOGINUI;
	}

}
