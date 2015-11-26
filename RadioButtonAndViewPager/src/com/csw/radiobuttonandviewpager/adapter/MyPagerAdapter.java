package com.csw.radiobuttonandviewpager.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.csw.radiobuttonandviewpager.base.BasePage;

public class MyPagerAdapter extends PagerAdapter {
	
	private List<BasePage> list;

	public MyPagerAdapter(List<BasePage> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View)object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = list.get(position).getContentView();
		container.addView(view);
		return view;
	}
	
	

}
