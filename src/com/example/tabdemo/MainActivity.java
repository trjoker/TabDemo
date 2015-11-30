package com.example.tabdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {

	private ViewPager mViewPager;
	private PagerAdapter mAdapter;
	private List<View> mView = new ArrayList<View>();

	// Tab
	private LinearLayout mLayoutWeChat;
	private LinearLayout mLayoutFriend;
	private LinearLayout mLayoutContanct;
	private LinearLayout mLayoutSetting;

	// ImageButton
	private ImageButton mImgBtnWeChat;
	private ImageButton mImgBtnFriend;
	private ImageButton mImgBtnContanct;
	private ImageButton mImgBtnSetting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		initEvent();
	}

	private void initEvent() {
		mLayoutWeChat.setOnClickListener(this);
		mLayoutFriend.setOnClickListener(this);
		mLayoutContanct.setOnClickListener(this);
		mLayoutSetting.setOnClickListener(this);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				resetImg();
				switch (mViewPager.getCurrentItem()) {
				case 0:

					mImgBtnWeChat.setImageResource(R.drawable.tab_weixin_pressed);

					break;
				case 1:
					mImgBtnFriend.setImageResource(R.drawable.tab_find_frd_pressed);

					break;
				case 2:
					mImgBtnContanct.setImageResource(R.drawable.tab_address_pressed);

					break;
				case 3:
					mImgBtnSetting.setImageResource(R.drawable.tab_settings_pressed);
					break;

				default:
					break;
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.view_pager);

		mLayoutWeChat = (LinearLayout) findViewById(R.id.btn_wechat);
		mLayoutFriend = (LinearLayout) findViewById(R.id.btn_friend);
		mLayoutContanct = (LinearLayout) findViewById(R.id.btn_contanct);
		mLayoutSetting = (LinearLayout) findViewById(R.id.btn_setting);

		mImgBtnWeChat = (ImageButton) findViewById(R.id.iv_wechat);
		mImgBtnFriend = (ImageButton) findViewById(R.id.iv_friend);
		mImgBtnContanct = (ImageButton) findViewById(R.id.iv_contanct);
		mImgBtnSetting = (ImageButton) findViewById(R.id.iv_setting);

		LayoutInflater mInflater = LayoutInflater.from(this);
		View viewTab01 = mInflater.inflate(R.layout.tab01, null, false);
		View viewTab02 = mInflater.inflate(R.layout.tab02, null, false);
		View viewTab03 = mInflater.inflate(R.layout.tab03, null, false);
		View viewTab04 = mInflater.inflate(R.layout.tab04, null, false);

		mView.add(viewTab01);
		mView.add(viewTab02);
		mView.add(viewTab03);
		mView.add(viewTab04);

		mAdapter = new PagerAdapter() {
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return mView.size();
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView(mView.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = mView.get(position);
				container.addView(view);
				return view;
			}

		};

		mViewPager.setAdapter(mAdapter);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn_wechat:
			mViewPager.setCurrentItem(0);
			break;
		case R.id.btn_friend:
			mViewPager.setCurrentItem(1);
			break;
		case R.id.btn_contanct:
			mViewPager.setCurrentItem(2);
			break;
		case R.id.btn_setting:
			mViewPager.setCurrentItem(3);
			break;

		default:
			break;
		}

	}

	// ½«ËùÓÐÍ¼Æ¬ÇÐ»»ÖÁÎ´µã»÷×´Ì¬
	private void resetImg() {
		mImgBtnWeChat.setImageResource(R.drawable.tab_weixin_normal);
		mImgBtnFriend.setImageResource(R.drawable.tab_find_frd_normal);
		mImgBtnContanct.setImageResource(R.drawable.tab_address_normal);
		mImgBtnSetting.setImageResource(R.drawable.tab_settings_normal);
	}
}
