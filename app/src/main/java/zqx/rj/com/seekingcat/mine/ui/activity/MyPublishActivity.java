package zqx.rj.com.seekingcat.mine.ui.activity;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import zqx.rj.com.constants.Constants;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.common.goods.ui.activity.GoodsActivity;
import zqx.rj.com.seekingcat.mine.contract.MyPublishContract;
import zqx.rj.com.seekingcat.mine.presenter.MyPublishPresenter;
import zqx.rj.com.utils.Preferences;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:22
 * desc:    TODO
 */
public class MyPublishActivity extends GoodsActivity<MyPublishContract.Presenter>
        implements MyPublishContract.View {

    private int page = 0;

    @Override
    protected void initView() {
        super.initView();

        setEmptyViewTips(getString(R.string.publish_empty_tips));
    }

    @Override
    protected void initData() {
        super.initData();

        // 获取 我发布的 数据
        mPresenter.getMyPublish(0);
    }

    @Override
    protected String getGoodsTitle() {
        return getString(R.string.my_publish);
    }

    @Override
    public void getMyPublishSuc(PageRsp<GoodsRsp> pageRsp) {

        // 设置 用户信息
        List<GoodsRsp> goodsRspList = pageRsp.getDatas();
        for (GoodsRsp goodsRsp : goodsRspList) {
            // 点击详情需要 goodsId
            goodsRsp.setId(goodsRsp.getGoodsId());
            goodsRsp.setOriginator(Preferences.getString(Constants.NICK_NAME, ""));
            goodsRsp.setOriginatorUrl(Preferences.getString(Constants.AVATAR_URL, ""));
        }

        pageRsp.setDatas(goodsRspList);
        addData(pageRsp);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getMyPublish(++page);
    }

    @Override
    public void onRefresh() {
        mPresenter.getMyPublish(0);
    }

    @Override
    protected MyPublishContract.Presenter bindPresenter() {
        return new MyPublishPresenter(this);
    }


    /**
     * toolbar  右侧 添加 编辑 按钮
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                showOrHideEdit(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     *  显示 或者 隐藏 radioButton
     */
    private void showOrHideEdit(MenuItem item) {
        if (isEdit) {
            isEdit = false;
            item.setTitle(getString(R.string.finish));
            List<GoodsRsp> goodsRspList = mGoodsAdapter.getData();
            for (GoodsRsp goodsRsp : goodsRspList) {
                // 显示 radioButton
                goodsRsp.setEdit(true);
            }
            mGoodsAdapter.notifyDataSetChanged();
        } else {
            isEdit = true;
            item.setTitle(getString(R.string.edit));
            List<GoodsRsp> goodsRspList = mGoodsAdapter.getData();
            for (GoodsRsp goodsRsp : goodsRspList) {
                // 隐藏 radioButton
                goodsRsp.setEdit(false);
            }
            mGoodsAdapter.notifyDataSetChanged();
        }
    }
}

