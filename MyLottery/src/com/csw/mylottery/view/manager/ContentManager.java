package com.csw.mylottery.view.manager;

import java.lang.reflect.Constructor;
import java.util.Observable;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.csw.mylottery.R;
import com.csw.mylottery.view.base.BaseUI;

public class ContentManager extends Observable {
	private RelativeLayout content;

	public void setContent(RelativeLayout content) {
		this.content = content;
	}

	private ContentManager() {
	}

	private static ContentManager instance = new ContentManager();

	public static ContentManager getInstance() {
		return instance;
	}

	

	private BaseUI currentUI;

	public void changeUI(Class<? extends BaseUI> targetClass) {
		// �л���ҳ��Ϊ��ǰ����չʾ��ҳ��
		if (currentUI != null && (currentUI.getClass() == targetClass)) {
			return;
		}
		BaseUI targetUI = null;
		try {
			Constructor<? extends BaseUI> constructor = targetClass.getConstructor(Context.class);
			targetUI = constructor.newInstance(getContext());
		} catch (Exception e) {
			throw new RuntimeException("no constructor for arg Context.class");
		}

		// �л�����ĺ��Ĵ���
		content.removeAllViews();
		
		View view = targetUI.getView();
		content.addView(view);
		view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ia_view_change));
		
		currentUI = targetUI;

		changeTitleAndBottom();
	}

	private void changeTitleAndBottom() {
		setChanged();
		notifyObservers(currentUI.getId());
	}

	public Context getContext() {
		return content.getContext();
	}

}
