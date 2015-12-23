package com.csw.mylottery.view.manager;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.csw.mylottery.R;
import com.csw.mylottery.common.ConstantValue;
import com.csw.mylottery.common.GlobalParams;
import com.csw.mylottery.view.LoginUI;

public class TitleManager implements Observer {
	private RelativeLayout commonTitle;// 通用标题
	private RelativeLayout unLoginTitle;// 未登录标题
	private RelativeLayout loginTitle;// 已登录标题

	private ImageView btnLogin;// 登录按钮

	private TextView commonTV;

	private TitleManager() {
	}

	private static TitleManager instance = new TitleManager();

	public static TitleManager getInstance() {
		return instance;
	}

	public void init(Activity activity) {
		commonTitle = (RelativeLayout) activity.findViewById(R.id.title_common);
		unLoginTitle = (RelativeLayout) activity.findViewById(R.id.title_unlogin);
		loginTitle = (RelativeLayout) activity.findViewById(R.id.title_login);

		btnLogin = (ImageView) unLoginTitle.findViewById(R.id.btn_login);
		commonTV = (TextView) commonTitle.findViewById(R.id.tv_common_title);

		setListener();
	}

	private void setListener() {
		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ContentManager.getInstance().changeUI(LoginUI.class);
			}
		});
	}

	/**
	 * 隐藏所有标题
	 */
	private void hideAll() {
		commonTitle.setVisibility(View.GONE);
		unLoginTitle.setVisibility(View.GONE);
		loginTitle.setVisibility(View.GONE);
	}

	/**
	 * 显示通用标题
	 */
	public void showCommonTitle() {
		hideAll();
		commonTitle.setVisibility(View.VISIBLE);
	}

	/**
	 * 显示已登录标题
	 */
	public void showLoginTitle() {
		hideAll();
		loginTitle.setVisibility(View.VISIBLE);
	}

	/**
	 * 显示未登录标题
	 */
	public void showUnLoginTitle() {
		hideAll();
		unLoginTitle.setVisibility(View.VISIBLE);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(Observable observable, Object data) {
		int id = (Integer) data;
		switch (id) {
		case ConstantValue.ID_HALLUI:
			if (GlobalParams.isLogin) {
				showLoginTitle();
			} else {
				showUnLoginTitle();
			}
			break;
		case ConstantValue.ID_LOGINUI:
			commonTV.setText("登 陆");
		default:
			showCommonTitle();
			break;
		}
	}

}
