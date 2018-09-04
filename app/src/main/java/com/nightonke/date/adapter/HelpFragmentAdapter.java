package com.nightonke.date.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nightonke.saver.R;
import com.nightonke.date.fragment.HelpAboutFragment;
import com.nightonke.date.fragment.HelpCoCoinFragment;
import com.nightonke.date.fragment.HelpFeedbackFragment;



public class HelpFragmentAdapter extends FragmentStatePagerAdapter {

    private int position = 0;
    private Context mContext;

    public HelpFragmentAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    public HelpFragmentAdapter(android.support.v4.app.FragmentManager fm, int position, Context mContext) {
        super(fm);
        this.position = position;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (this.position) {
            case 0: return HelpCoCoinFragment.newInstance();
            case 1: return HelpFeedbackFragment.newInstance();
            case 2: return HelpAboutFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (this.position) {
            case 0: return mContext.getResources().getString(R.string.app_name);
            case 1: return mContext.getResources().getString(R.string.feedback);
            case 2: return mContext.getResources().getString(R.string.about);
        }
        return "";
    }
}
