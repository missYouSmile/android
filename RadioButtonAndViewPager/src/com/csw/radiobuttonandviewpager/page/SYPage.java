package com.csw.radiobuttonandviewpager.page;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.csw.radiobuttonandviewpager.R;
import com.csw.radiobuttonandviewpager.base.BasePage;

public class SYPage extends BasePage {

	private static final String TAG = "SYPage";
	private ViewPager vp_image;
	
	public SYPage(Context context) {
		super(context);
	}

	@Override
	public void initData() {
		view = inflater.inflate(R.layout.sy_content, null);
		vp_image = (ViewPager) view.findViewById(R.id.vp_image);
	}

	@Override
	public View getContentView() {
		return view;
	}

}
