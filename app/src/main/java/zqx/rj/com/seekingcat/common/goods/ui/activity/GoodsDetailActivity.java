package zqx.rj.com.seekingcat.common.goods.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.MvpActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.contract.GoodsDetailContract;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.common.goods.presenter.GoodsDetailPresenter;
import zqx.rj.com.seekingcat.publish.model.entity.request.GoodsModel;
import zqx.rj.com.utils.DialogBuilder;
import zqx.rj.com.utils.GlideUtil;

/**
 * author：  HyZhan
 * create：  2018/12/7 18:54
 * desc：    物品详情页面
 */
public class GoodsDetailActivity extends MvpActivity<GoodsDetailContract.Presenter>
        implements GoodsDetailContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.iv_goods)
    ImageView mIvGoods;

    @BindView(R.id.btn_type)
    Button mBtnType;

    @BindView(R.id.tv_name)
    TextView mTvName;

    @BindView(R.id.tv_phone)
    TextView mTvPhone;

    @BindView(R.id.tv_place)
    TextView mTvPlace;

    @BindView(R.id.tv_originator)
    TextView mTvOriginator;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_description)
    TextView mTvDescription;

    @BindView(R.id.iv_follow)
    ImageView mIvFollow;

    @BindView(R.id.tv_reward)
    TextView mTvReward;
    @BindView(R.id.tv_reward_title)
    TextView mTvRewardTitle;

    private int id = 0;

    private boolean isFollow;

    private String goodsUrl;
    private Dialog imageDialog;
    private ImageView mIvBigGoods;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView() {
        super.initView();

        setToolBarTitle(toolbar, getString(R.string.goods_detail));

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("id", 0);
        }

        // 点击放大的 dialog
        imageDialog = new DialogBuilder(this)
                .setLayoutId(R.layout.dialog_image)
                .setCancelable(true)
                .build();

        mIvBigGoods = imageDialog.findViewById(R.id.iv_image);
    }

    @Override
    protected void initData() {
        super.initData();

        mPresenter.getGoodsDetail(id);
    }

    @Override
    public void loadGoodsDetailSuccess(GoodsRsp goodsRsp) {

        if (goodsRsp == null)
            return;

        goodsUrl = goodsRsp.getGoodsUrl();
        GlideUtil.loadImage(this, goodsUrl, mIvGoods);

        if (goodsRsp.getType() == GoodsModel.LOSE_GOODS) {
            mBtnType.setText(getString(R.string.lost_and_found));
            mBtnType.setBackgroundResource(R.drawable.red_round_bg);

            mTvRewardTitle.setVisibility(View.GONE);
            mTvReward.setVisibility(View.GONE);
        } else {
            mBtnType.setText(getString(R.string.search_for_notices));
            mBtnType.setBackgroundResource(R.drawable.green_round_bg);


            mTvRewardTitle.setVisibility(View.VISIBLE);
            mTvReward.setVisibility(View.VISIBLE);
            mTvReward.setText(goodsRsp.getReward());
        }

        if (goodsRsp.getFollow()) {
            isFollow = true;
            mIvFollow.setImageResource(R.drawable.ic_followed);
        } else {
            isFollow = false;
            mIvFollow.setImageResource(R.drawable.ic_follow);
        }

        mTvName.setText(goodsRsp.getName());
        mTvPhone.setText(goodsRsp.getPhone());
        mTvPlace.setText(goodsRsp.getPlace());
        mTvOriginator.setText(goodsRsp.getOriginator());
        mTvTime.setText(goodsRsp.getPublishTime());
        mTvDescription.setText(goodsRsp.getDescription());

        hideLoading();
    }

    @Override
    protected GoodsDetailContract.Presenter bindPresenter() {
        return new GoodsDetailPresenter(this);
    }

    @OnClick(R.id.iv_goods)
    void onClickImage() {
        GlideUtil.loadImage(this, goodsUrl, mIvBigGoods);
        imageDialog.show();
    }

    @OnClick(R.id.iv_follow)
    void onFollowClick() {
        if (isFollow) {
            mPresenter.unFollow(id);
        } else {
            mPresenter.follow(id);
        }
    }

    @Override
    public void followSuccess() {
        mIvFollow.setImageResource(R.drawable.ic_followed);
        toast(getString(R.string.follow_suc));

        hideLoading();
    }

    @Override
    public void unFollowSuccess() {
        mIvFollow.setImageResource(R.drawable.ic_follow);
        toast(getString(R.string.unfollow_suc));

        hideLoading();
    }
}
