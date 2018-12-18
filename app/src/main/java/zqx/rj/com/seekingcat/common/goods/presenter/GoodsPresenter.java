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
        if (isViewAttach()) {
            getView().showLoading();
            GoodsHelper.getMyPublish(page, new Callback<PageRsp<GoodsRsp>>() {
                @Override
                public void onSuccess(PageRsp<GoodsRsp> pageRsp) {
                    getView().getMyPublishSuc(pageRsp);
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }

    @Override
    public void getFollow(int page) {
        if (isViewAttach()) {
            getView().showLoading();
            GoodsHelper.getFollow(page, new Callback<PageRsp<GoodsRsp>>() {
                @Override
                public void onSuccess(PageRsp<GoodsRsp> pageRsp) {
                    getView().getFollowSuc(pageRsp);
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }
}
