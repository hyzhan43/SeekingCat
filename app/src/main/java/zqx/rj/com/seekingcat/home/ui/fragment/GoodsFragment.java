package zqx.rj.com.seekingcat.home.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.home.contract.GoodsContract;
import zqx.rj.com.seekingcat.home.model.adapter.GoodsAdapter;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.presenter.GoodsPresenter;

/**
 * author：  HyZhan
 * create：  2018/11/28 18:22
 * desc：    TODO
 */
public class GoodsFragment extends MvpFragment<PageRsp<List<GoodsRsp>>,
        GoodsContract.Presenter> implements GoodsContract.View<PageRsp<List<GoodsRsp>>> {

    @BindView(R.id.rv_goods)
    RecyclerView mRvGoods;

    public static Fragment getInstance() {
        return new GoodsFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
    }

    @Override
    public void initData() {
        super.initData();

        initRecyclerView();

        mPresenter.requestAllGoods(0);
    }

    private void initRecyclerView() {
    }

    @Override
    protected GoodsContract.Presenter bindPresenter() {
        return new GoodsPresenter();
    }

    @Override
    public void success(PageRsp<List<GoodsRsp>> data) {
        mRvGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
        GoodsAdapter adapter = new GoodsAdapter(R.layout.goods_item, data.getDatas());
        mRvGoods.setAdapter(adapter);
    }
}
