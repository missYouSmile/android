package com.csw.mylottery.view.manager;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

import com.csw.mylottery.R;
import com.csw.mylottery.common.ConstantValue;

public class BottomManager implements Observer {
	private LinearLayout bottomNav;
	private LinearLayout bottomBuy;

	private BottomManager() {
	}

	private static BottomManager instance = new BottomManager();

	public static BottomManager getInstance() {
		return instance;
	}

	public void init(Activity activity) {
		bottomNav = (LinearLayout) activity.findViewById(R.id.bottom_nav);
		bottomBuy = (LinearLayout) activity.findViewById(R.id.bottom_buy);
	}

	public void hideAll() {
		bottomNav.setVisibility(View.GONE);
		bottomBuy.setVisibility(View.GONE);
	}

	public void showBottomNav() {
		hideAll();
		bottomNav.setVisibility(View.VISIBLE);
	}

	public void showBottomBuy() {
		hideAll();
		bottomBuy.setVisibility(View.VISIBLE);
	}

	@Override
	public void update(Observable observable, Object data) {
		int id =  (Integer) data;
		switch (id) {
		case ConstantValue.ID_LOGINUI:
		case ConstantValue.ID_HALLUI:
		default:
			showBottomNav();
			break;
		}
	}

}
