package com.teamproject.froze.teamproject01;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{

    private ViewPager mPager;
    int NUMBER_OF_PAGER = 3;
    Fragment_p1 fragment_p1;
    Fragment_p2 fragment_p2;
    Fragment_p3 fragment_p3;

    DrawerLayout drawer;
    Toolbar toolbar;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fragment_p1 = new Fragment_p1();
        fragment_p2 = new Fragment_p2();
        fragment_p3 = new Fragment_p3();

        mDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close) {

        public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);
            invalidateOptionsMenu();
        }

        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);

            mPager = (ViewPager) findViewById(R.id.pager);
            mPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    try {
                        if(event.getAction() == MotionEvent.ACTION_DOWN) {
                            //Request parent to do not intercept touch event.
                            mPager.requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                        if(event.getAction() == MotionEvent.ACTION_UP
                                || event.getAction() == MotionEvent.ACTION_CANCEL
                                || event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                            //Request parent to treat touch event.
                            mPager.requestDisallowInterceptTouchEvent(false);
                            return false;
                        }
                    }
                    catch(Throwable e) {
                        Log.e("Main", "onTouchPager:" + e.toString());
                    }
                    return false;
                }
            });

                PagerAdapter adapter = new PagerCustomAdapter(getSupportFragmentManager());
                mPager.setAdapter(adapter);
            }
        };

        drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    public class PagerCustomAdapter extends FragmentStatePagerAdapter{

        public PagerCustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch(position){
                case 0: fragment = fragment_p1; break;
                case 1: fragment = fragment_p2; break;
                case 2: fragment = fragment_p3; break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGER;
        }
    }

}
