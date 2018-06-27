package zqx.rj.com.seekingcat.launcher;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.R2;
import zqx.rj.com.seekingcat.base.activity.BaseActivityAdatper;

/**
 *  闪屏页
 */
public class SplashActivity extends BaseActivityAdatper {

    @BindView(R2.id.tv_time)
    public TextView mTvTimer = null;


    @OnClick(R2.id.tv_time)
    void onClickTimerView(){
        toast("click this");
    }

    private void checkIsShowGuide() {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }
}
