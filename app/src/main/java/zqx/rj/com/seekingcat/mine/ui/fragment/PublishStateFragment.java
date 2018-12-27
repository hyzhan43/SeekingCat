package zqx.rj.com.seekingcat.mine.ui.fragment;

import android.os.Bundle;
import android.view.View;

import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.common.goods.ui.fragment.GoodsFragment;
import zqx.rj.com.seekingcat.mine.contract.MyPublishContract;
import zqx.rj.com.seekingcat.mine.presenter.MyPublishPresenter;

/**
 * author:  HyZhan
 * create:  2018/12/22 17:42
 * desc:    TODO
 */
public class PublishStateFragment extends GoodsFragment<MyPublishContract.Presenter>
        implements MyPublishContract.View {

    private Integer page = 0;

    private Integer state = 0;

    public static PublishStateFragment getInstance(Integer state) {
        Bundle bundle = new Bundle();
        bundle.putInt("state", state);
        PublishStateFragment fragment = new PublishStateFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initView(View view) {
        super.initView(view);

        mGoodsAdapter.isShowState(true);

        Bundle bundle = getArguments();
        if (bundle != null) {
            state = bundle.getInt("state");
        }
    }

    @Override
    public void initData() {
        super.initData();

        page = 0;
        if (state != null) {
            mPresenter.getMyPublish(page, state);
        }
    }

    @Override
    public void onRefresh() {
        page = 0;
        mPresenter.getMyPublish(page, state);
    }

    @Override
    protected void confirmFoundClick(int goodsId) {
        showLoading();
        mPresenter.foundGoods(goodsId);
    }

    @Override
    protected void confirmDeleteClick(int goodsId) {
        showLoading();
        mPresenter.deleteMyPublishGoods(goodsId);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getMyPublish(++page, state);
    }

    @Override
    protected MyPublishContract.Presenter bindPresenter() {
        return new MyPublishPresenter(this);
    }

    @Override
    public void getMyPublishSuc(PageRsp<GoodsRsp> pageRsp) {
        addData(pageRsp);
    }

    @Override
    public void foundSuc() {
        hideLoading();
        toast(getString(R.string.great));
    }

    @Override
    public void deletePublishSuc() {
        hideLoading();
        toast(getString(R.string.delete_suc));
    }
}
