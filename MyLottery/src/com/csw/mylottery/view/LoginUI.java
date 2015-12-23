package com.csw.mylottery.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.csw.mylottery.R;
import com.csw.mylottery.common.ConstantValue;
import com.csw.mylottery.view.base.BaseUI;

public class LoginUI extends BaseUI {

	public LoginUI(Context context) {
		super(context);
	}

	@Override
	public void init() {
		contentHolder = (ViewGroup) View.inflate(context, R.layout.login, null);
	}

	@Override
	public void setListener() {
	}

	@Override
	public int getId() {
		return ConstantValue.ID_LOGINUI;
	}

}
