package com.csw.mylottery.view.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public abstract class BaseUI {
	protected Context context;
	protected ViewGroup contentHolder;
	public BaseUI(Context context) {
		this.context = context;
		init();
		setListener();
	}
	public View getView(){
		
		if (contentHolder.getLayoutParams() == null) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.MATCH_PARENT,
					RelativeLayout.LayoutParams.MATCH_PARENT);
			contentHolder.setLayoutParams(params);
		}
		
		return contentHolder;
	}
	
	public abstract void init();

	public abstract void setListener();

	public abstract int getId();
	
	protected View findViewById(int id){
		return contentHolder.findViewById(id);
	}
}
