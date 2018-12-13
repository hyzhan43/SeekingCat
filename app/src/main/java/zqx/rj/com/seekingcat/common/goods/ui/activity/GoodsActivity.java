package zqx.rj.com.seekingcat.common.goods.ui.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.BindView;
import zqx.rj.com.base.mvp.MvpActivity;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.contract.GoodsContract;
import zqx.rj.com.seekingcat.common.goods.model.adapter.GoodsAdapter;
import zqx.rj.com.seekingcat.common.goods.presenter.GoodsPresenter;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.ui.activity.GoodsDetailActivity;
import zqx.rj.com.utils.Log;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:11
 * desc:    通用 物品列表 基类
 */
public abstract class GoodsActivity extends MvpActivity<GoodsContract.Presenter>
        implements GoodsContract.View, BaseQuickAdapter.RequestLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.rv_goods)
    RecyclerView mRvGoods;

    protected GoodsAdapter mGoodsAdapter;

    @Override
    protected GoodsContract.Presenter bindPresenter() {
        return new GoodsPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods;
    }

    @Override
    protected void initView() {
        super.initView();

        setToolBarTitle(toolbar, getGoodsTitle());

        // 设置 刷新进度条颜色。
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mGoodsAdapter = new GoodsAdapter(R.layout.goods_item, null);

        mRvGoods.setLayoutManager(new LinearLayoutManager(this));
        mRvGoods.setAdapter(mGoodsAdapter);

        // 设置 加载更多
        mGoodsAdapter.setEnableLoadMore(true);
        mGoodsAdapter.setOnLoadMoreListener(this, mRvGoods);

        mGoodsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent = new Intent(GoodsActivity.this, GoodsDetailActivity.class);
                GoodsRsp goodsRsp = (GoodsRsp) adapter.getItem(position);
                if (goodsRsp != null) {

                    Log.d("id = " + goodsRsp.getId());
                    intent.putExtra("id", goodsRsp.getId());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        loadData();
    }

    protected abstract void loadData();

    // 获取 title
    protected abstract String getGoodsTitle();

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
     * 获取 我的发布 成功
     */
    @Override
    public void getMyPublishSuc(PageRsp<GoodsRsp> pageRsp) {

    }

    /**
     *  获取 我的关注 成功
     */
    @Override
    public void getFollowSuc(PageRsp<GoodsRsp> pageRsp) {

    }
}
