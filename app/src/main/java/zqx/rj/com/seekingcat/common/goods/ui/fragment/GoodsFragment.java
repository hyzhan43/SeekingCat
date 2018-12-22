package zqx.rj.com.seekingcat.common.goods.ui.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.model.adapter.GoodsAdapter;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.common.goods.ui.activity.GoodsDetailActivity;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:34
 * desc:    通用 物品列表 基类
 */
public abstract class GoodsFragment<T extends BaseContract.Presenter> extends MvpFragment<T>
        implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_goods)
    RecyclerView mRvGoods;

    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mRefreshLayout;

    private GoodsAdapter mGoodsAdapter;

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
        mGoodsAdapter = new GoodsAdapter(R.layout.goods_item, new ArrayList<GoodsRsp>());
        mRvGoods.setAdapter(mGoodsAdapter);

        // 设置 加载更多
        mGoodsAdapter.setEnableLoadMore(true);
        mGoodsAdapter.setOnLoadMoreListener(this, mRvGoods);
        mGoodsAdapter.disableLoadMoreIfNotFullPage();
        mGoodsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
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

    /**
     *  设置数据
     */
    protected void addData(PageRsp<GoodsRsp> pageRsp) {
        // 如果是 下拉刷新的 直接 设置新的数据
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
            mGoodsAdapter.setNewData(pageRsp.getDatas());
            mGoodsAdapter.loadMoreComplete();
            return;
        }

        // 如果为空的话，就直接 显示加载完毕
        if (pageRsp.getDatas().isEmpty()) {
            mGoodsAdapter.loadMoreEnd();
            return;
        }

        // 否则 就是添加数据
        mGoodsAdapter.addData(pageRsp.getDatas());
        mGoodsAdapter.loadMoreComplete();
    }

    /**
     * 下拉刷新
     */
    public abstract void onRefresh();

    /**
     * 上拉加载更多
     */
    public abstract void onLoadMoreRequested();

    @Override
    public void showError(String str) {
        super.showError(str);
        if (mRefreshLayout.isRefreshing())
            mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(int str) {
        super.showError(str);
        if (mRefreshLayout.isRefreshing())
            mRefreshLayout.setRefreshing(false);
    }
}
