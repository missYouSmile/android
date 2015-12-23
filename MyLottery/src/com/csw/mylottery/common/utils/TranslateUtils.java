package com.csw.mylottery.common.utils;

import android.view.View;
import android.view.animation.TranslateAnimation;

public class TranslateUtils {
	
	public static void rollIn(View view){
		TranslateAnimation animation = new TranslateAnimation(view.getWidth(), 0, 0, 0);
		animation.setDuration(1000);
		view.startAnimation(animation);
	}
}
