package zqx.rj.com.seekingcat.home.ui.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.MvpActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.home.contract.GoodsDetailContract;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.presenter.GoodsDetailPresenter;
import zqx.rj.com.utils.GlideUtil;

/**
 * author：  HyZhan
 * create：  2018/12/7 18:54
 * desc：    TODO
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

    private int id = 0;

    private boolean isFollow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView() {
        super.initView();

        showLoading();
        setToolBarTitle(toolbar, getString(R.string.goods_detail));

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("id", 0);
        }
    }

    @Override
    protected void initData() {
        super.initData();

        mPresenter.requestGoodsDetail(id);
    }

    @Override
    public void loadGoodsDetailSuccess(GoodsRsp goodsRsp) {

        if (goodsRsp == null)
            return;

        GlideUtil.loadImage(this, goodsRsp.getGoodsUrl(), mIvGoods);

        if (goodsRsp.getType() == GoodsRsp.LOSE_GOODS) {
            mBtnType.setText(getString(R.string.lost_and_found));
        } else {
            mBtnType.setText(getString(R.string.search_for_notices));
        }

        if (goodsRsp.getFollow()){
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

    @OnClick(R.id.iv_follow)
    void onFollowClick(){
        if (isFollow){
            mPresenter.unFollow(id);
        }else {
            mPresenter.follow(id);
        }
    }

    @Override
    public void followSuccess() {
        mIvFollow.setImageResource(R.drawable.ic_followed);
        toast(getString(R.string.follow_suc));
    }

    @Override
    public void unFollowSuccess() {
        mIvFollow.setImageResource(R.drawable.ic_follow);
        toast(getString(R.string.unfollow_suc));
    }
}
