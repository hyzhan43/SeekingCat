package zqx.rj.com.seekingcat.mine.ui.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.constants.Constants;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.mine.contract.MineContract;
import zqx.rj.com.seekingcat.mine.model.bean.UserInfoRsp;
import zqx.rj.com.seekingcat.mine.presenter.MinePresenter;
import zqx.rj.com.seekingcat.mine.ui.activity.AboutActivity;
import zqx.rj.com.seekingcat.mine.ui.activity.FollowActivity;
import zqx.rj.com.seekingcat.mine.ui.activity.MyPublishActivity;
import zqx.rj.com.utils.GlideUtil;
import zqx.rj.com.utils.Preferences;

/**
 * author：  HyZhan
 * create：  2018/11/28 18:22
 * desc：    TODO
 */

public class MineFragment extends MvpFragment<MineContract.Presenter>
        implements MineContract.View {

    @BindView(R.id.civ_portrait)
    CircleImageView mCivPortrait;

    @BindView(R.id.tv_name)
    TextView mTvName;

    @BindView(R.id.tv_publish_count)
    TextView mTvPublishCount;

    @BindView(R.id.tv_follow_count)
    TextView mTvFollowCount;

    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mRefreshLayout;

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MineContract.Presenter bindPresenter() {
        return new MinePresenter(this);
    }

    @Override
    public void initView(View view) {
        super.initView(view);

        // 设置 刷新进度条颜色。
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getUserInfo();
            }
        });
    }

    @Override
    public void initData() {
        super.initData();

        mPresenter.getUserInfo();
    }

    @Override
    public void getUserInfoSuccess(UserInfoRsp userInfoRsp) {

        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }

        if (userInfoRsp == null)
            return;

        String nickName = userInfoRsp.getNickName();
        if (nickName == null) {
            nickName = "未设置";
        }

        // 存储个人信息
        Preferences.putString(Constants.NICK_NAME, nickName);
        Preferences.putString(Constants.AVATAR_URL, userInfoRsp.getAvatarUrl());

        mTvName.setText(nickName);
        // 显示头像
        GlideUtil.loadImage(getContext(), userInfoRsp.getAvatarUrl(), mCivPortrait);
        mTvPublishCount.setText(String.valueOf(userInfoRsp.getPublishCount()));
        mTvFollowCount.setText(String.valueOf(userInfoRsp.getFollowCount()));
    }

    @OnClick(R.id.ll_publish)
    void onClickPublish() {
        Intent intent = new Intent(getActivity(), MyPublishActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_follow)
    void onClickFollow() {
        Intent intent = new Intent(getActivity(), FollowActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_about)
    void onClickAbout() {
        Intent intent = new Intent(getActivity(), AboutActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_setting)
    void onClickSetting() {
        toast("设置");
    }
}
