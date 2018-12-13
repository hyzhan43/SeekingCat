package zqx.rj.com.seekingcat.common.goods.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.common.goods.contract.GoodsContract;
import zqx.rj.com.seekingcat.common.goods.model.helper.GoodsHelper;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:14
 * desc:    TODO
 */
public class GoodsPresenter extends BasePresenter<GoodsContract.View>
        implements GoodsContract.Presenter {

    public GoodsPresenter(GoodsContract.View view) {
        super(view);
    }

    @Override
    public void getMyPublish(int page) {
        GoodsHelper.getMyPublish(page, new Callback<PageRsp<GoodsRsp>>() {
            @Override
            public void onSuccess(PageRsp<GoodsRsp> pageRsp) {
                if (isViewAttach()) {
                    getView().getMyPublishSuc(pageRsp);
                }
            }

            @Override
            public void onFail(String msg) {
                if (isViewAttach()) {
                    getView().showError(msg);
                }
            }
        });
    }

    @Override
    public void getFollow(int page) {
        GoodsHelper.getFollow(page, new Callback<PageRsp<GoodsRsp>>() {
            @Override
            public void onSuccess(PageRsp<GoodsRsp> pageRsp) {
                if (isViewAttach()) {
                    getView().getFollowSuc(pageRsp);
                }
            }

            @Override
            public void onFail(String msg) {
                if (isViewAttach()) {
                    getView().showError(msg);
                }
            }
        });
    }
}
