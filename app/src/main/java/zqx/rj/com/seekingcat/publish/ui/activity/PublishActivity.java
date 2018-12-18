package zqx.rj.com.seekingcat.publish.ui.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.activity.BaseActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.publish.model.entity.request.GoodsModel;
import zqx.rj.com.seekingcat.publish.ui.fragment.SeekGoodsFragment;
import zqx.rj.com.seekingcat.publish.ui.fragment.LoseGoodsFragment;

public class PublishActivity extends BaseActivity {

    @BindView(R.id.btn_lose)
    Button mBtnLose;

    @BindView(R.id.btn_seek)
    Button mBtnSearch;

    @BindView(R.id.fl_content)
    FrameLayout mFlContent;

    private LoseGoodsFragment mLoseFragment;

    private SeekGoodsFragment mSeekFragment;

    private int type = GoodsModel.SEEK_GOODS;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish;
    }

    @Override
    protected void initView() {
        super.initView();

        mSeekFragment = new SeekGoodsFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_content, mSeekFragment)
                .commit();
    }

    @OnClick(R.id.btn_seek)
    void onSeekGoods() {

        type = GoodsModel.SEEK_GOODS;

        mBtnSearch.setTextColor(Color.WHITE);
        mBtnSearch.setBackgroundResource(R.drawable.left_round_bg_pressed);

        mBtnLose.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mBtnLose.setBackgroundResource(R.drawable.right_round_bg_normal);

        switchFragment(mLoseFragment, mSeekFragment);
    }

    @OnClick(R.id.btn_lose)
    void onLoseGoods() {

        type = GoodsModel.LOSE_GOODS;

        if (mLoseFragment == null)
            mLoseFragment = new LoseGoodsFragment();

        mBtnLose.setTextColor(Color.WHITE);
        mBtnLose.setBackgroundResource(R.drawable.right_round_bg_pressed);

        mBtnSearch.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mBtnSearch.setBackgroundResource(R.drawable.left_round_bg_normal);

        switchFragment(mSeekFragment, mLoseFragment);
    }

    private void switchFragment(Fragment from, Fragment to) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 判断是否添加过 到 content
        if (to.isAdded()) {
            transaction.hide(from).show(to);
        } else {
            transaction.hide(from).add(R.id.fl_content, to);
        }

        transaction.commit();
    }

    @OnClick(R.id.tv_publish)
    void onClickPublish() {
        if (type == GoodsModel.LOSE_GOODS) {
            mLoseFragment.onPublish();
        } else {
            mSeekFragment.onPublish();
        }
    }

    @OnClick(R.id.tv_cancel)
    void onCancel() {
        finish();
    }
}
