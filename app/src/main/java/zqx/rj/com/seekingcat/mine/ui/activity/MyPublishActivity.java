package zqx.rj.com.seekingcat.mine.ui.activity;

import java.util.List;

import zqx.rj.com.constants.Constants;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.ui.activity.GoodsActivity;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.utils.Preferences;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:22
 * desc:    TODO
 */
public class MyPublishActivity extends GoodsActivity {

    private int page = 0;

    @Override
    protected void loadData() {
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

        hideLoading();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getMyPublish(++page);
    }

    @Override
    public void onRefresh() {
        mPresenter.getMyPublish(0);
    }
}

