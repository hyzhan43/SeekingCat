package zqx.rj.com.seekingcat.mine.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.common.goods.model.helper.GoodsHelper;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
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
    public void getMyPublish(int page) {
        if (isViewAttach()) {
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
}
