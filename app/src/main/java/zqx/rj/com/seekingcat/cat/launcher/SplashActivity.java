package zqx.rj.com.seekingcat.cat.launcher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.R2;
import zqx.rj.com.seekingcat.base.activity.BaseActivityAdatper;
import zqx.rj.com.seekingcat.cat.account.view.impl.LoginActivity;
import zqx.rj.com.seekingcat.cat.main.view.MainActivity;
import zqx.rj.com.seekingcat.common.utils.SharedUtils;

/**
 * 闪屏页
 */
public class SplashActivity extends BaseActivityAdatper {

    @BindView(R2.id.iv_logo)
    ImageView mIvSplashLogo = null;


    @OnClick(R2.id.tv_time)
    void onClickTimerView() {
        toast("click this");
    }

    private void checkIsShowGuide() {

        boolean isFirst = SharedUtils.getBoolean(mContext, "isFirst", false);
        if (!isFirst){
            SharedUtils.putBoolean(mContext, "isFirst", true);
            startActivity(GuideActivity.class);
        }else {
            startActivity(LoginActivity.class);
        }
    }


    @Override
    protected void initView() {

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvSplashLogo,
                "alpha", 0.0f, 1.0f);

        objectAnimator.setDuration(4000);
        objectAnimator.start();

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                checkIsShowGuide();
                finish();
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }
}
