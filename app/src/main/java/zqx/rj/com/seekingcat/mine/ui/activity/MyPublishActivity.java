package zqx.rj.com.seekingcat.mine.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zqx.rj.com.base.activity.BaseActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.mine.model.adapter.PublishAdapter;
import zqx.rj.com.seekingcat.mine.ui.fragment.PublishStateFragment;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:22
 * desc:    TODO
 */
public class MyPublishActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tb_title)
    TabLayout mTbTitle;

    @BindView(R.id.vp_content)
    ViewPager mVpContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_publish;
    }

    @Override
    protected void initView() {
        super.initView();

        setToolBarTitle(toolbar, getString(R.string.my_publish));

        mTbTitle.setupWithViewPager(mVpContent);
        // 预加载 2个页面
        mVpContent.setOffscreenPageLimit(2);
    }

    @Override
    protected void initData() {
        super.initData();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(PublishStateFragment.getInstance(GoodsRsp.GOODS_ALL));
        fragments.add(PublishStateFragment.getInstance(GoodsRsp.GOODS_FOUND));
        fragments.add(PublishStateFragment.getInstance(GoodsRsp.GOODS_NOT_FOUND));
        List<String> titles = getTitles();
        PublishAdapter adapter = new PublishAdapter(getSupportFragmentManager(), fragments, titles);

        mVpContent.setAdapter(adapter);
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();

        titles.add(getString(R.string.whole));
        titles.add(getString(R.string.already_found));
        titles.add(getString(R.string.not_found));

        return titles;
    }
}

