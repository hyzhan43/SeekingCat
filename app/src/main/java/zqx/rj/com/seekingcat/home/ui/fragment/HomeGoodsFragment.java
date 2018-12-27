package zqx.rj.com.seekingcat.home.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.common.goods.ui.fragment.GoodsFragment;
import zqx.rj.com.seekingcat.home.contract.HomeContract;
import zqx.rj.com.seekingcat.home.presenter.HomePresenter;

/**
 * author：  HyZhan
 * create：  2018/11/28 18:22
 * desc：    首页 物品 fragment
 */
public class HomeGoodsFragment extends GoodsFragment<HomeContract.Presenter>
        implements HomeContract.View {

    private int page = 0;
    private int type;

    public static Fragment getInstance(int type) {

        HomeGoodsFragment fragment = new HomeGoodsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("type", type);

        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void initData() {
        super.initData();

        Bundle bundle = getArguments();
        if (bundle != null) {
            page = 0;
            type = bundle.getInt("type");
            mPresenter.getGoods(type, page);
        }
    }

    @Override
    public void getGoodsSucceed(PageRsp<GoodsRsp> pageRsp) {
        addData(pageRsp);
    }

    @Override
    protected HomeContract.Presenter bindPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void onRefresh() {
        page = 0;
        mPresenter.getGoods(type, page);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getGoods(type, ++page);
    }
}
