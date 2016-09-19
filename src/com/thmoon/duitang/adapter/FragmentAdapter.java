package com.thmoon.duitang.adapter;

import com.thmoon.duitang.ui.DiscoverFragment;
import com.thmoon.duitang.ui.MoveFragment;
import com.thmoon.duitang.ui.MsgFragment;
import com.thmoon.duitang.ui.PopularFragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {

	public FragmentAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}
	
	private String[] pageTitle ={"热门","发现","动态","消息"};

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new PopularFragment();
		case 1:
			return new DiscoverFragment();
		case 2:
			return new MoveFragment();
		case 3:
			return new MsgFragment();
		default:
			//return PagerFragment.newInstance();
			return null;
		}
	//	return null;
	}

	@Override
	public int getCount() {
		return pageTitle.length;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return pageTitle[position];
	}

}
