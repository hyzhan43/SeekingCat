package zqx.rj.com.seekingcat.common.goods.ui.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.contract.GoodsContract;
import zqx.rj.com.seekingcat.common.goods.model.adapter.GoodsAdapter;
import zqx.rj.com.seekingcat.common.goods.presenter.GoodsPresenter;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.ui.activity.GoodsDetailActivity;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:34
 * desc:    通用 物品列表 基类
 */
public abstract class GoodsFragment extends MvpFragment<GoodsContract.Presenter>
        implements GoodsContract.View, SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_goods)
    RecyclerView mRvGoods;

    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mRefreshLayout;

    private GoodsAdapter adapter;

    // 页数
    private int page = 0;

    private int type;

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

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                GoodsRsp goodsRsp = (GoodsRsp) adapter.getItem(position);
                if (goodsRsp != null) {
                    intent.putExtra("id", goodsRsp.getId());
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    protected GoodsContract.Presenter bindPresenter() {
        return new GoodsPresenter(this);
    }


    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMoreRequested() {
    }

    @Override
    public void showError(String str) {
        super.showError(str);
        if (mRefreshLayout.isRefreshing())
            mRefreshLayout.setRefreshing(false);
    }
}
