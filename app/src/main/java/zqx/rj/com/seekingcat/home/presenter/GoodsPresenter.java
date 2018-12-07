package zqx.rj.com.seekingcat.home.presenter;

import java.util.List;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.home.contract.GoodsContract;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.model.helper.GoodsHelper;

/**
 * author：  HyZhan
 * create：  2018/11/28 20:03
 * desc：    TODO
 */
public class GoodsPresenter extends BasePresenter<GoodsContract.View>
        implements GoodsContract.Presenter, Callback<PageRsp<List<GoodsRsp>>> {

    public static final int ALL = 0;
    public static final int SEEK = 1;
    public static final int LOSE = 2;

    public GoodsPresenter(GoodsContract.View view) {
        super(view);
    }

    public void requestGoods(int type, int page) {
        GoodsHelper.getGoods(type, page, this);
    }


    @Override
    public void onSuccess(PageRsp<List<GoodsRsp>> listPageRsp) {
        if (isViewAttach()) {
            getView().onGetGoodsSucceed(listPageRsp);
        }
    }

    @Override
    public void onFail(String msg) {
        getView().showError(msg);
    }
}
