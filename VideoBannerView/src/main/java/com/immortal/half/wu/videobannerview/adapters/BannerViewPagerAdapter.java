package com.immortal.half.wu.videobannerview.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Do : viewPager adpter ,  没啥可说的
 * Created : immortalHalfWu
 * Time : 2017/10/20  16:30
 */

public class BannerViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments;

    public BannerViewPagerAdapter(FragmentManager fm, @NonNull List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
