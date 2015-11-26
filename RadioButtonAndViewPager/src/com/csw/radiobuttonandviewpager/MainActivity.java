package com.csw.radiobuttonandviewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioButton;

import com.csw.radiobuttonandviewpager.adapter.MyPagerAdapter;
import com.csw.radiobuttonandviewpager.base.BasePage;
import com.csw.radiobuttonandviewpager.page.LMPage;
import com.csw.radiobuttonandviewpager.page.SYPage;
import com.csw.radiobuttonandviewpager.page.WDPage;
import com.csw.radiobuttonandviewpager.page.ZBPage;

public class MainActivity extends Activity implements OnClickListener {

	private RadioButton sy_btn;
	private RadioButton lm_btn;
	private RadioButton zb_btn;
	private RadioButton wd_btn;

	private ViewPager vp_image;
	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		init();

		final List<BasePage> data = initData();
		vp_image.setAdapter(new MyPagerAdapter(data));

		sy_btn.setOnClickListener(this);
		lm_btn.setOnClickListener(this);
		zb_btn.setOnClickListener(this);
		wd_btn.setOnClickListener(this);
		vp_image.addOnPageChangeListener(new OnPageChangeListener() {

			/**
			 * ҳ����ת��ɺ���ô˷���
			 * 
			 * @param position
			 *            ��ǰ��ʾ��ҳ�루��ͼ��ţ�
			 */
			@Override
			public void onPageSelected(int postion) {
				Log.i(TAG, data.get(postion).toString() + "---->postion="
						+ postion);
				changeBackground(postion);
			}

			/**
			 * ��ҳ���ڻ�����ʱ����ô˷�����������ֹ֮ͣǰһֱ�ص���
			 */
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int postion) {

			}
		});
	}

	private List<BasePage> initData() {
		List<BasePage> list = new ArrayList<BasePage>();
		list.add(new SYPage(MainActivity.this));
		list.add(new LMPage(MainActivity.this));
		list.add(new ZBPage(MainActivity.this));
		list.add(new WDPage(MainActivity.this));
		return list;
	}

	private void init() {
		sy_btn = (RadioButton) findViewById(R.id.btn_sy);
		lm_btn = (RadioButton) findViewById(R.id.btn_lm);
		zb_btn = (RadioButton) findViewById(R.id.btn_zb);
		wd_btn = (RadioButton) findViewById(R.id.btn_wd);
		vp_image = (ViewPager) findViewById(R.id.vp_layout);
	}

	@Override
	public void onClick(View view) {
		int key = view.getId();
		switch (key) {
		case R.id.btn_sy:
			vp_image.setCurrentItem(0);// ����ViewPager��ʾ�ڼ���(���㿪ʼ)
			break;
		case R.id.btn_lm:
			vp_image.setCurrentItem(1);
			break;
		case R.id.btn_zb:
			vp_image.setCurrentItem(2);
			break;
		case R.id.btn_wd:
			vp_image.setCurrentItem(3);
			break;
		}
	}

	private void changeBackground(int id) {
		switch (id) {
		case 0: // ��ҳ
			sy_btn.setChecked(true);
			break;
		case 1: // ��Ŀ
			lm_btn.setChecked(true);
			break;
		case 2: // ֱ��
			zb_btn.setChecked(true);
			break;
		case 3: // �ҵ�
			wd_btn.setChecked(true);
			break;
		}
	}

}
