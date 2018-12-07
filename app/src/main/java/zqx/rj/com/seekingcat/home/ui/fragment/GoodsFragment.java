package zqx.rj.com.seekingcat.home.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

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
public class GoodsFragment extends MvpFragment<GoodsContract.Presenter>
        implements GoodsContract.View, SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_goods)
    RecyclerView mRvGoods;

    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mRefreshLayout;

    private GoodsAdapter adapter;

    private int page = 0;
    private int type;

    public static Fragment getInstance(int type) {

        GoodsFragment fragment = new GoodsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("type", type);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods;
    }

    @Override
    public void initView(View view) {
        super.initView(view);

        // 设置 刷新进度条颜色。
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mRvGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new GoodsAdapter(R.layout.goods_item, new ArrayList<GoodsRsp>());
        mRvGoods.setAdapter(adapter);

        // 设置 加载更多
        adapter.setEnableLoadMore(true);
        adapter.setOnLoadMoreListener(this, mRvGoods);
    }

    @Override
    public void initData() {
        super.initData();

        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type");

            mPresenter.requestGoods(type, 0);
        }
    }


    @Override
    protected GoodsContract.Presenter bindPresenter() {
        return new GoodsPresenter(this);
    }

    @Override
    public void onGetGoodsSucceed(PageRsp<List<GoodsRsp>> pageRsp) {

        // 如果是 下拉刷新的 直接 设置新的数据
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
            adapter.setNewData(pageRsp.getDatas());
            adapter.loadMoreComplete();
            return;
        }

        if (pageRsp.getDatas().isEmpty()) {
            adapter.loadMoreEnd();
            return;
        }

        // 否则 就是添加数据
        adapter.addData(pageRsp.getDatas());
        adapter.loadMoreComplete();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        mPresenter.requestGoods(type, 0);
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMoreRequested() {
        mPresenter.requestGoods(type, ++page);
    }

    @Override
    public void showError(String str) {
        super.showError(str);
        if (mRefreshLayout.isRefreshing())
            mRefreshLayout.setRefreshing(false);
    }
}
