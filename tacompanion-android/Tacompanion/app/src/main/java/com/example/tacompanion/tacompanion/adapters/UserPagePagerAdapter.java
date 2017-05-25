package com.example.tacompanion.tacompanion.adapters;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tacompanion.tacompanion.fragments.QRCodeFragment;
import com.example.tacompanion.tacompanion.fragments.UserProfileFragment;
/**
 * Created by Pedro Lanzagorta M on 11/25/2016.
 */
public class UserPagePagerAdapter extends FragmentPagerAdapter {
    int numberOfTabs;
    public UserPagePagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs=numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new QRCodeFragment();
            case 1:
                return new UserProfileFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return numberOfTabs;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Check-In";
            case 1:
                return "My Profile";
            default:
                return "Tab"+position;
        }

    }
    @Override
    public int getItemPosition(Object object) {
    // POSITION_NONE makes it possible to reload the PagerAdapter
        return POSITION_NONE;
    }
}
