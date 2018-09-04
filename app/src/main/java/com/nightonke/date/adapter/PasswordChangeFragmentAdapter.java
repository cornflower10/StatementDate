package com.nightonke.date.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nightonke.date.fragment.PasswordChangeFragment;



public class PasswordChangeFragmentAdapter extends FragmentPagerAdapter {

    public PasswordChangeFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PasswordChangeFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
