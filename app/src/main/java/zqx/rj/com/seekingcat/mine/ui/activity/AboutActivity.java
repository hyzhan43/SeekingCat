package zqx.rj.com.seekingcat.mine.ui.activity;


import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import zqx.rj.com.base.activity.BaseActivity;
import zqx.rj.com.seekingcat.R;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }


    @Override
    protected void initView() {
        super.initView();

        setToolBarTitle(toolbar, getString(R.string.about));
    }
}
