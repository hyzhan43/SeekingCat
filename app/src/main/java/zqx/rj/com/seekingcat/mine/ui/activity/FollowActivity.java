package zqx.rj.com.seekingcat.mine.ui.activity;

import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.ui.activity.GoodsActivity;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:24
 * desc:    TODO
 */
public class FollowActivity extends GoodsActivity {

    private int page = 0;

    @Override
    protected void loadData() {
        mPresenter.getFollow(0);
    }

    @Override
    public void onRefresh() {
        mPresenter.getFollow(0);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getFollow(++page);
    }

    @Override
    protected String getGoodsTitle() {
        return getString(R.string.my_follow);
    }

    @Override
    public void getFollowSuc(PageRsp<GoodsRsp> pageRsp) {
        addData(pageRsp);
    }
}
