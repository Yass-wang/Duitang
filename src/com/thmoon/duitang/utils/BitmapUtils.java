package com.thmoon.duitang.utils;

import android.content.Context;
import android.graphics.BitmapFactory;

public class BitmapUtils {

	public static float getBitmapRadio(Context context,int resourceId){
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(context.getResources(), resourceId, options);
		return options.outHeight/(float)options.outWidth;
	}
}
