package com.csw.radiobuttonandviewpager.page;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.csw.radiobuttonandviewpager.R;
import com.csw.radiobuttonandviewpager.base.BasePage;

public class ZBPage extends BasePage {

	public ZBPage(Context context) {
		super(context);
	}

	@Override
	public void initData() {
		Log.i("ZBPage", "initData");
		view = inflater.inflate(R.layout.zb_content, null);
	}

	@Override
	public View getContentView() {
		Log.i("ZBPage", "getContentView");
		return view;
	}

}
