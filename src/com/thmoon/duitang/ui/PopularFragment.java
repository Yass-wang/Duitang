package com.thmoon.duitang.ui;

import com.etsy.android.grid.StaggeredGridView;
import com.thmoon.duitang.R;
import com.thmoon.duitang.adapter.StaggerItemAdapter;
import com.thmoon.duitang.adapter.TopItemAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class PopularFragment extends Fragment implements OnRefreshListener{
	
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private StaggeredGridView mStaggeredGridView;
	private ViewPager viewPager;
	private ClumsyIndicator mClumsyIndicator;

	private static Handler handler;
	private TopItemAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_popular, container, false);
		View topView = inflater.inflate(R.layout.top_view, (ViewGroup) view,false);
		mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
		mStaggeredGridView = (StaggeredGridView) view.findViewById(R.id.stagger_view);
		viewPager = (ViewPager) topView.findViewById(R.id.image_pager);
		mClumsyIndicator = (ClumsyIndicator) topView.findViewById(R.id.indicator);
		mStaggeredGridView.addHeaderView(topView);
		initView();
		handler = new Handler();
		return view;
	}
	
	@SuppressWarnings("deprecation")
	private void initView(){
		adapter = new TopItemAdapter(getActivity());
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(Integer.MAX_VALUE/2-Integer.MAX_VALUE/2 % adapter.size);
		mClumsyIndicator.setViewPager(viewPager);
		mStaggeredGridView.setAdapter(new StaggerItemAdapter(getActivity()));
		mSwipeRefreshLayout.setOnRefreshListener(this);
		mSwipeRefreshLayout.setColorSchemeColors(R.color.blue);
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			boolean isHandle = false;
			
			@Override
			public void onPageSelected(int position) {
				mClumsyIndicator.setSelectedItem(position % adapter.size);
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				if (!isHandle && positionOffsetPixels > 0) {
					mSwipeRefreshLayout.setEnabled(false);
					isHandle = true;
				}
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				switch (state) {
				case ViewPager.SCROLL_STATE_IDLE:
					mSwipeRefreshLayout.setEnabled(true);
					isHandle = false;
					break;
				}
			}
		});
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (savedInstanceState != null) {
			int currentItem = savedInstanceState.getInt("pager_current_item");
			viewPager.setCurrentItem(currentItem % adapter.size, false);
		}
	}

	@Override
	public void onRefresh() {
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				mSwipeRefreshLayout.setRefreshing(false);
				Toast.makeText(getActivity(), getString(R.string.refresh_success), Toast.LENGTH_SHORT).show();
			}
		}, 3000);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("pager_current_item", viewPager.getCurrentItem());
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		handler.removeCallbacksAndMessages(null);
	}
}
