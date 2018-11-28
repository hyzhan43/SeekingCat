package zqx.rj.com.seekingcat.home.presenter;

import java.util.List;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.seekingcat.home.model.helper.GoodsHelper;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.home.contract.GoodsContract;

/**
 * author：  HyZhan
 * create：  2018/11/28 20:03
 * desc：    TODO
 */
public class GoodsPresenter extends BasePresenter implements GoodsContract.Presenter {

    @Override
    public void requestAllGoods(int page) {
        GoodsHelper.allGoods(page)
                .subscribe(new BaseObserver<PageRsp<List<GoodsRsp>>>(getView()));
    }
}
