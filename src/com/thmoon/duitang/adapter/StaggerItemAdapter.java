package com.thmoon.duitang.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.thmoon.duitang.R;
import com.thmoon.duitang.entity.StaggerItem;
import com.thmoon.duitang.utils.BitmapUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StaggerItemAdapter extends BaseAdapter {

	private List<StaggerItem> itemList;
	private Context mContext;
	private boolean isReverse = false;
	
	public StaggerItemAdapter(Context context) {
		mContext = context;
		initData();
	}
	
	public StaggerItemAdapter(Context context,boolean isReverse) {
		mContext = context;
		this.isReverse = isReverse;
		initData();
	}
	
	private void initData() {
		int[] imageSource = {R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7,
                R.drawable.pic8, R.drawable.pic9};
        String[] descriptionArray = {"萤火之森", "龙族--我们都是小怪兽，终有一天会被正义的奥特曼杀死", "废物利用", "不一样的剪纸", "微型休憩空间",
                "#壁纸#", "简笔画分享", "创意生活", "英伦风", "机智的立夏在学习蹭WiFi"};

        int[] thumbImageArray = {R.drawable.thumb0, R.drawable.thumb1, R.drawable.thumb2, R.drawable.thumb3, R.drawable.thumb4};
        String[] userNameArray = {"默念那曾时", "来自原始森林的帝企鹅", "年华逝水", "荒年信徒", "红秀",
                "水若印心", "千离", "乖兽", "我不是Candy", "千年老妖"};
        String[] collectPlace = {"超轻粘土", "龙族", "大白", "文字控", "虫不知",
                "布纸喜欢你", "百味美食堂", "备忘录的秘密", "吃吃吃", "插画那些事"};
        
        itemList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
			StaggerItem item = new StaggerItem();
			item.setImageSource(imageSource[i]);
			item.setDescription(descriptionArray[i]);
			item.setCollectNum(random.nextInt(500));
			item.setThumImage(thumbImageArray[i%5]);
			item.setUserName(userNameArray[i]);
			item.setCollectPlace(collectPlace[i]);
			itemList.add(item);
		}
        if (isReverse) {
			Collections.reverse(itemList);
		}
	}

	@Override
	public int getCount() {
		return itemList.size();
	}

	@Override
	public Object getItem(int position) {
		return itemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.stagger_item, parent,false);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		StaggerItem item = itemList.get(position);
		viewHolder.imageView.setHeightRatio(BitmapUtils.getBitmapRadio(mContext, item.getImageSource()));
		viewHolder.imageView.setImageResource(item.getImageSource());
		viewHolder.description.setText(item.getDescription());
		viewHolder.collectNum.setText(item.getCollectNum()+"");
		viewHolder.thumbImage.setImageResource(item.getThumImage());
		viewHolder.userName.setText(item.getUserName());
		viewHolder.collectPlace.setText("收集到   "+item.getCollectPlace());
		return convertView;
	}
	
	static class ViewHolder{
		DynamicHeightImageView imageView;
		TextView description;
		Button collectNum;
		ImageView thumbImage;
		TextView userName;
		TextView collectPlace;
		public ViewHolder(View convertView) {
			imageView = (DynamicHeightImageView) convertView.findViewById(R.id.stagger_image);
			description = (TextView) convertView.findViewById(R.id.description);
			collectNum = (Button) convertView.findViewById(R.id.collect_num);
			thumbImage = (ImageView) convertView.findViewById(R.id.thumb);
			userName = (TextView) convertView.findViewById(R.id.user_name);
			collectPlace = (TextView) convertView.findViewById(R.id.collect_place);
		}
	}
}
