package com.example.tacompanion.tacompanion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tacompanion.tacompanion.R;
import com.example.tacompanion.tacompanion.adapters.UserPagePagerAdapter;
import com.example.tacompanion.tacompanion.rest.BETest;

/**
 * Created by Pedro Lanzagorta M on 11/23/2016.
 */
public class UserPageActivity extends AppCompatActivity {
    public static ViewPager viewPager;
    public static boolean activeSession=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        activeSession = false;
        viewPager = (ViewPager) findViewById(R.id.userViewPager);
        PagerAdapter pagerAdapter = new UserPagePagerAdapter(getSupportFragmentManager(),2);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        TabLayout tabLayout = (TabLayout) findViewById(R.id.userViewPagerTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_edit_prof: {
                startActivity(new Intent(this, EditProfileActivity.class));
                return true;
            }
            case R.id.menu_go_pref:{
                startActivity(new Intent(this,UserPreferencesActivity.class));
                return true;
            }
            default:
                return false;
        }
    }

    public void testHTTP(View view){
        //new BETest(this).execute();

    }




}
