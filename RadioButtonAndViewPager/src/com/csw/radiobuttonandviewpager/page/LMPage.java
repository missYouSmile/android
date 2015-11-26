package com.csw.radiobuttonandviewpager.page;

import android.content.Context;
import android.view.View;

import com.csw.radiobuttonandviewpager.R;
import com.csw.radiobuttonandviewpager.base.BasePage;

public class LMPage extends BasePage {

	public LMPage(Context context) {
		super(context);
	}

	@Override
	public void initData() {
		view = inflater.inflate(R.layout.lm_content, null);
	}

	@Override
	public View getContentView() {
		return view;
	}

}
