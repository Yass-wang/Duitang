package com.thmoon.duitang.ui;

import java.util.ArrayList;
import java.util.List;

import com.thmoon.duitang.R;
import com.thmoon.duitang.entity.TrendItem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HorizontalTrendView extends LinearLayout {

	 private int[] imageSource = {R.drawable.gallery0, R.drawable.gallery1, R.drawable.gallery2, R.drawable.gallery3,
	            R.drawable.gallery4, R.drawable.gallery5};

	 private String[] imgDescription = {"权利的游戏", "风吹的风景", "插画背景", "美食君", "吃", "你好四月"};
	 
	 private List<TrendItem> trendList;
	
	public HorizontalTrendView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initData();
		addTrendView();
	}

	private void addTrendView() {
		for (int i = 0; i < trendList.size(); i++) {
			View view = LayoutInflater.from(getContext()).inflate(R.layout.trend_item, this, false);
			ImageView imageView = (ImageView) view.findViewById(R.id.trend_img);
			TextView textView = (TextView) view.findViewById(R.id.trend_tv);
			imageView.setImageResource(trendList.get(i).getImageSource());
			textView.setText(trendList.get(i).getDescription());
			addView(view);
		}
	}

	private void initData() {
		trendList = new ArrayList<>();
		for (int i = 0; i < imageSource.length; i++) {
			TrendItem item = new TrendItem();
			item.setImageSource(imageSource[i]);
			item.setDescription(imgDescription[i]);
			trendList.add(item);
		}
	}
	

}
