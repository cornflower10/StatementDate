package com.nightonke.date.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nightonke.date.fragment.TagViewFragment;
import com.nightonke.date.model.RecordManager;
import com.nightonke.date.util.StatementDateUtil;

public class TagViewFragmentAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    public TagViewFragmentAdapter(android.support.v4.app.FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int i) {
        return TagViewFragment.newInstance(i);
    }

    @Override
    public int getCount() {
        return RecordManager.getInstance(mContext).TAGS.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return StatementDateUtil.GetTagName(
                RecordManager.getInstance(mContext).TAGS.get(position % RecordManager.TAGS.size()).getId());
    }
}
