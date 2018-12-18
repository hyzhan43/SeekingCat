package zqx.rj.com.seekingcat.home.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.common.goods.model.helper.GoodsHelper;
import zqx.rj.com.seekingcat.home.contract.HomeContract;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;

/**
 * author：  HyZhan
 * create：  2018/11/28 20:03
 * desc：    TODO
 */
public class HomePresenter extends BasePresenter<HomeContract.View>
        implements HomeContract.Presenter, Callback<PageRsp<GoodsRsp>> {

    public static final int ALL = 0;
    public static final int SEEK = 1;
    public static final int LOSE = 2;

    public HomePresenter(HomeContract.View view) {
        super(view);
    }

    public void getGoods(int type, int page) {
        GoodsHelper.getGoods(type, page, this);
    }


    @Override
    public void onSuccess(PageRsp<GoodsRsp> pageRsp) {
        if (isViewAttach()) {
            getView().getGoodsSucceed(pageRsp);
        }
    }

    @Override
    public void onFail(String msg) {
        getView().showError(msg);
    }
}
