package zqx.rj.com.seekingcat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;

import butterknife.BindView;
import zqx.rj.com.base.activity.BaseActivity;
import zqx.rj.com.seekingcat.account.ui.LoginActivity;

/**
 * 闪屏页
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.rl_splash)
    RelativeLayout mSplashView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        super.initView();

        // 透明度改变
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mSplashView,
                "alpha", 0.0f, 1.0f);
        objectAnimator.setDuration(4000);
        objectAnimator.start();

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(LoginActivity.class);
                finish();
            }
        });
    }
}
