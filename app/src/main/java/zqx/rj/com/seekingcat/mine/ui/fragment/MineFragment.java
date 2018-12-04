package zqx.rj.com.seekingcat.mine.ui.fragment;

import android.content.Intent;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.mine.contract.MineContract;
import zqx.rj.com.seekingcat.mine.model.bean.UserInfoRsp;
import zqx.rj.com.seekingcat.mine.presenter.MinePresenter;
import zqx.rj.com.seekingcat.mine.ui.activity.AboutActivity;
import zqx.rj.com.utils.GlideUtil;

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
    public void initData() {
        super.initData();

        mPresenter.getUserInfo();
    }

    @Override
    public void getUserInfoSuccess(UserInfoRsp userInfoRsp) {

        mTvName.setText(userInfoRsp.getNickName());
        // 显示头像
        GlideUtil.loadImage(getContext(), userInfoRsp.getAvatarUrl(), mCivPortrait);
        mTvPublishCount.setText(String.valueOf(userInfoRsp.getPublishCount()));
        mTvFollowCount.setText(String.valueOf(userInfoRsp.getFollowCount()));
    }

    @OnClick(R.id.ll_publish)
    void onClickPublish(){

    }

    @OnClick(R.id.ll_follow)
    void onClickFollow(){

    }

    @OnClick(R.id.ll_about)
    void onClickAbout(){
        Intent intent = new Intent(getActivity(), AboutActivity.class);
        startActivity(intent);
    }
}
