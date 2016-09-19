package com.thmoon.duitang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ScrollNotifyView extends ScrollView {

	private OnScrollViewListener mOnScrollViewListener;
	
	public ScrollNotifyView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ScrollNotifyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ScrollNotifyView(Context context) {
		super(context);
	}

	public interface OnScrollViewListener{
		void setOnScrollChanged(int l, int t,int oldl, int oldt);
	}
	
	public void setOnScrollViewListener(OnScrollViewListener listener){
		mOnScrollViewListener = listener;
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		mOnScrollViewListener.setOnScrollChanged(l, t, oldl, oldt);
	}
	
}
