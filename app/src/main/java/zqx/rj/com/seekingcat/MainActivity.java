package zqx.rj.com.seekingcat;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zqx.rj.com.base.activity.BaseActivity;
import zqx.rj.com.base.fragment.BaseFragment;
import zqx.rj.com.seekingcat.home.presenter.adapter.ViewPagerAdapter;
import zqx.rj.com.seekingcat.home.view.HomeFragment;
import zqx.rj.com.seekingcat.mine.view.MineFragmentImpl;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.main_bottom_navigation)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.vp_main)
    ViewPager mViewPager;

    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void initView() {

        // 设置 toolbar
        setSupportActionBar(toolbar);
        initBottomNavigationBar();
        initViewPager();
        initFragments();
    }

    private void initFragments() {

        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.getInstance());
        fragments.add(MineFragmentImpl.getInstance());

        mViewPagerAdapter.addFragments(fragments);
    }

    private void initViewPager() {

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });
    }

    private void initBottomNavigationBar() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        mViewPager.setCurrentItem(0);
                        toolbar.setTitle(getString(R.string.home));
                        return true;
                    case R.id.navigation_message:
                        mViewPager.setCurrentItem(1);
                        toolbar.setTitle(getString(R.string.mine));
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
