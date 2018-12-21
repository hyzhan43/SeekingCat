package zqx.rj.com.seekingcat.common.goods.ui.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.BindView;
import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.base.mvp.MvpActivity;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.model.adapter.GoodsAdapter;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.utils.Log;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:11
 * desc:    通用 物品列表 抽象类
 */
public abstract class GoodsActivity<T extends BaseContract.Presenter> extends MvpActivity<T>
        implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.rv_goods)
    public RecyclerView mRvGoods;

    protected GoodsAdapter mGoodsAdapter;

    private TextView mTvTips;

    // 是否编辑状态
    protected boolean isEdit = true;

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
                    intent.putExtra("id", goodsRsp.getId());
                    startActivity(intent);
                }
            }
        });

        mGoodsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                // 选中 radioButton
                RadioButton radioButton = (RadioButton) view;

                GoodsRsp goodsRsp = mGoodsAdapter.getItem(position);
                if (goodsRsp != null){
                    Boolean isChoose = goodsRsp.getChoose();
                    radioButton.setChecked(!isChoose);
                    goodsRsp.setChoose(!isChoose);
                }
            }
        });

        mGoodsAdapter.setEmptyView(getEmptyView());
    }

    // 获取 title
    protected abstract String getGoodsTitle();

    /**
     * 设置数据
     */
    protected void addData(PageRsp<GoodsRsp> pageRsp) {

        // 如果是 下拉刷新的 直接 设置新的数据
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
            mGoodsAdapter.setNewData(pageRsp.getDatas());
            mGoodsAdapter.loadMoreComplete();
            return;
        }

        // 如果下拉加载更多为空的话，就直接 显示加载完毕
        if (pageRsp.getDatas().isEmpty()) {
            mGoodsAdapter.loadMoreEnd();
            return;
        }

        // 如果是编辑状态   就设置 isEdit 为 true 显示出  radioButton
        if (!isEdit) {
            for (GoodsRsp goodsRsp : pageRsp.getDatas()) {
                goodsRsp.setEdit(true);
            }
        }

        // 否则 就是添加数据
        mGoodsAdapter.addData(pageRsp.getDatas());
        mGoodsAdapter.loadMoreComplete();
    }

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

    private View getEmptyView() {
        View EmptyView = LayoutInflater.from(this).inflate(R.layout.emtpy_view, null);
        mTvTips = EmptyView.findViewById(R.id.tv_tips);
        return EmptyView;
    }

    public void setEmptyViewTips(String msg) {
        mTvTips.setText(msg);
    }
}
