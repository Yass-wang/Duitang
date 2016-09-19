package com.thmoon.duitang.adapter;

import java.util.ArrayList;
import java.util.List;

import com.thmoon.duitang.R;
import com.thmoon.duitang.entity.TopItem;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TopItemAdapter extends PagerAdapter {

	private Context mContext;
	
	private List<TopItem> imageSource;
	
	public static int size;
	
	public final float[] matrix = new float[]{
			1, 0, 0, 0, -30,
			0, 1, 0, 0, -30,
			0, 0, 1, 0, -30,
			0, 0, 0, 1, 0
	};
	
	public TopItemAdapter(Context context) {
		mContext = context;
		initData();
		size = imageSource.size();
	}
	
	
	private void initData(){
		imageSource = new ArrayList<>();
		imageSource.add(new TopItem(R.drawable.top1,"我所经历的生活","4月18日 周六"));
		imageSource.add(new TopItem(R.drawable.top2, "橡皮擦初心", "4月18日 周六"));
		imageSource.add(new TopItem(R.drawable.top3, "一只喵的幸福生活", "4月17日 周五"));
		imageSource.add(new TopItem(R.drawable.top4, "手绘电影场景", "4月16日 周四"));
	}
	
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
		//return imageSource.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		
		return arg0 == arg1;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.top_image_item, container, false);
		container.addView(view);
		ImageView imageView = (ImageView) view.findViewById(R.id.top_image);
		imageView.setColorFilter(new ColorMatrixColorFilter(matrix));
		TextView title = (TextView) view.findViewById(R.id.title);
		TextView time = (TextView) view.findViewById(R.id.time);
		TopItem mTopItem = imageSource.get(position % size);
		imageView.setImageResource(mTopItem.getImageSource());
		title.setText(mTopItem.getTitle());
		time.setText(mTopItem.getTime());
		return view;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View)object);
	}
}
