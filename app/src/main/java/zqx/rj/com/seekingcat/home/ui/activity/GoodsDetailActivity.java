package zqx.rj.com.seekingcat.home.ui.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingja.loadsir.callback.SuccessCallback;

import butterknife.BindView;
import zqx.rj.com.base.mvp.MvpActivity;
import zqx.rj.com.callback.LoadingCallback;
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

    private int id = 0;

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
}
