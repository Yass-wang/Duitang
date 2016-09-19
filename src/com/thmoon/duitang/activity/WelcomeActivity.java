package com.thmoon.duitang.activity;

import com.thmoon.duitang.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.TextView;



public class WelcomeActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		initView();
	}
	
	private void initView(){
		final TextView countDown = (TextView) findViewById(R.id.tv_count_down);
		final Typeface font = Typeface.createFromAsset(getAssets(), "splash.ttf");
		countDown.setTypeface(font);
		CountDownTimer timer = new CountDownTimer(3200,1000) {
		int number = 2;
			@Override
			public void onTick(long millisUntilFinished) {
				countDown.setText(number+"");
				number--;
			}
			
			@Override
			public void onFinish() {
				startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
				finish();
			}
		};
		timer.start();
	}
}
