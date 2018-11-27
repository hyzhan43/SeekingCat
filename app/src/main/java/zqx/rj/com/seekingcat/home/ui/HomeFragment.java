package zqx.rj.com.seekingcat.home.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.helper.AccountHelper;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.base.fragment.BaseFragment;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.home.view
 * 文件名：  HomeFragment
 * 创建者：  ZQX
 * 创建时间：2018/7/10 14:15
 * 描述：    TODO
 */

public class HomeFragment extends BaseFragment  {

    @BindView(R.id.btn_test)
    Button mTest;

    @BindView(R.id.tv_show)
    TextView mShow;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public void initView(View view) {

    }

    @OnClick(R.id.btn_test)
    void testClick(){

    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}
