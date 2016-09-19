package com.thmoon.duitang.activity;

import com.astuetz.PagerSlidingTabStrip;
import com.thmoon.duitang.R;
import com.thmoon.duitang.adapter.FragmentAdapter;
import com.thmoon.duitang.ui.CircleImageDrawble;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private PagerSlidingTabStrip mIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setActionBar();
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                Intent i = new Intent(this, PersonActivity.class);
                startActivity(i);
                break;
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
	}
	
	private void initView(){
		mIndicator = (PagerSlidingTabStrip) findViewById(R.id.indicator);
		ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		FragmentAdapter mAdapter = new FragmentAdapter(getFragmentManager());
		mViewPager.setAdapter(mAdapter);
		mIndicator.setViewPager(mViewPager);
	}
	
	private void setActionBar(){
		ActionBar actionBar = getActionBar();
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user_default_face);
		actionBar.setIcon(new CircleImageDrawble(bitmap));
		actionBar.setTitle("用户");
		actionBar.setHomeButtonEnabled(true);
		
	}
}
