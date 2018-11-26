package zqx.rj.com.seekingcat.home.presenter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import zqx.rj.com.base.fragment.BaseFragment;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.cat.main.presenter.adapter
 * 文件名：  ViewPagerAdapter
 * 创建者：  ZQX
 * 创建时间：2018/7/10 13:52
 * 描述：    TODO
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    public List<BaseFragment> mFragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments(List<BaseFragment> fragments){
        this.mFragments.addAll(fragments);
        notifyDataSetChanged();
    }

    public void addFragment(BaseFragment fragment){
        this.mFragments.add(fragment);
        notifyDataSetChanged();
    }


    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
