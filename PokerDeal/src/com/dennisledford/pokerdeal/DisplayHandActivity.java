package com.dennisledford.pokerdeal;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayHandActivity extends FragmentActivity {
	
	private ViewPager mPager;
	
	private static final int NUM_CARDS=5;
	
	private PagerAdapter mPagerAdapter;
	
	protected Player player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_hand);
		// Show the Up button in the action bar.
		Intent intent = getIntent();
		player = (Player) intent.getSerializableExtra(PokerConstants.EXTRA_PLAYER);
		
		// Show the Up button in the action bar.
		//setupActionBar();
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new HandSlidePagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_hand, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class HandSlidePagerAdapter extends FragmentStatePagerAdapter {
         
	 	public HandSlidePagerAdapter(FragmentManager fm) {
            super(fm);           
        }

        @Override
        public Fragment getItem(int position) {
        	Card card = player.getHand().get(position);
            return HandSlideFragment.create(position, card);
        }

        @Override
        public int getCount() {
            return NUM_CARDS;
        }
    }

}
