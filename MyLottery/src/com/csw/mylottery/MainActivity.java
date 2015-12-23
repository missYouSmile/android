package com.csw.mylottery;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;

import com.csw.mylottery.view.HallUI;
import com.csw.mylottery.view.manager.BottomManager;
import com.csw.mylottery.view.manager.ContentManager;
import com.csw.mylottery.view.manager.TitleManager;

public class MainActivity extends Activity {
	private RelativeLayout content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		init();
	}

	private void init() {
		TitleManager titleManager = TitleManager.getInstance();
		titleManager.init(this);
		
		BottomManager bottomManager = BottomManager.getInstance();
		bottomManager.init(this);
		
		ContentManager contentManager = ContentManager.getInstance();
		
		content = (RelativeLayout) findViewById(R.id.content);
		contentManager.setContent(content);

		contentManager.addObserver(bottomManager);
		contentManager.addObserver(titleManager);
		
		contentManager.changeUI(HallUI.class);
		
	}
	
}
