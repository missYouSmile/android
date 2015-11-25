package com.csw.radiobuttonandviewpager.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BasePage {
	
	protected LayoutInflater inflater;
	protected Context context;
	protected View view;
	
	public BasePage(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
		initData();
	}
	
	public abstract void initData();
	
	public abstract View getContentView();
}
