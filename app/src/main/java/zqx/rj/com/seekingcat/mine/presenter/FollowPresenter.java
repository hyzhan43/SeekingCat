package zqx.rj.com.seekingcat.mine.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.common.goods.model.helper.GoodsHelper;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.mine.contract.FollowContract;

/**
 * author:  HyZhan
 * create:  2018/12/18 14:15
 * desc:    TODO
 */
public class FollowPresenter extends BasePresenter<FollowContract.View>
        implements FollowContract.Presenter {

    public FollowPresenter(FollowContract.View view) {
        super(view);
    }


    @Override
    public void getFollow(int page) {
        if (isViewAttach()) {
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
