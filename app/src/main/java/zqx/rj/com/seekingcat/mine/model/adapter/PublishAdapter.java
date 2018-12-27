package zqx.rj.com.seekingcat.mine.model.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author:  HyZhan
 * create:  2018/12/22 17:56
 * desc:    TODO
 */
public class PublishAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    private List<String> titles;

    public PublishAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
