package zqx.rj.com.seekingcat.mine.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.common.goods.model.helper.GoodsHelper;
import zqx.rj.com.seekingcat.mine.contract.MyPublishContract;

/**
 * author:  HyZhan
 * create:  2018/12/18 14:15
 * desc:    TODO
 */
public class MyPublishPresenter extends BasePresenter<MyPublishContract.View>
        implements MyPublishContract.Presenter {

    public MyPublishPresenter(MyPublishContract.View view) {
        super(view);
    }

    @Override
    public void getMyPublish(int page, Integer state) {

        GoodsHelper.getMyPublish(page, state, new Callback<PageRsp<GoodsRsp>>() {
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
    public void foundGoods(int goodsId) {
        GoodsHelper.foundGoods(goodsId, new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                if (isViewAttach()) {
                    getView().foundSuc();
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
    public void deleteMyPublishGoods(int goodsId) {
        GoodsHelper.deleteMyPublishGoods(goodsId, new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                if (isViewAttach()) {
                    getView().deletePublishSuc();
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
