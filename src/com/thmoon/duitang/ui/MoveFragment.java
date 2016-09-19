package com.thmoon.duitang.ui;

import com.etsy.android.grid.StaggeredGridView;
import com.thmoon.duitang.R;
import com.thmoon.duitang.adapter.StaggerItemAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MoveFragment extends Fragment implements OnRefreshListener{

	private Handler handler;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	private StaggeredGridView mStaggeredGridView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_move, container, false);
		mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.move_refresh_layout);
		mStaggeredGridView = (StaggeredGridView) view.findViewById(R.id.move_stagger_view);
		handler = new Handler();
		initView();
		return view;
	}
	
	private void initView(){
		mStaggeredGridView.setAdapter(new StaggerItemAdapter(getActivity(), true));
		mSwipeRefreshLayout.setOnRefreshListener(this);
		mSwipeRefreshLayout.setColorSchemeResources(R.color.blue);
	}

	@Override
	public void onRefresh() {
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				mSwipeRefreshLayout.setRefreshing(false);
				Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
			}
		}, 3000);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		handler.removeCallbacksAndMessages(null);
	}
	
}
