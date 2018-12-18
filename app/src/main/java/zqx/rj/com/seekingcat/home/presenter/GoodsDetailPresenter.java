package zqx.rj.com.seekingcat.home.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.home.contract.GoodsDetailContract;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.model.helper.GoodsHelper;

/**
 * author：  HyZhan
 * create：  2018/12/7 19:09
 * desc：    TODO
 */
public class GoodsDetailPresenter extends BasePresenter<GoodsDetailContract.View>
        implements GoodsDetailContract.Presenter {

    public GoodsDetailPresenter(GoodsDetailContract.View view) {
        super(view);
    }

    public void getGoodsDetail(int id) {
        if (isViewAttach()) {
            getView().showLoading();
            GoodsHelper.getGoodsDetail(id, new Callback<GoodsRsp>() {
                @Override
                public void onSuccess(GoodsRsp goodsRsp) {
                    getView().loadGoodsDetailSuccess(goodsRsp);
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }

    @Override
    public void follow(int id) {
        if (isViewAttach()) {
            getView().showLoading();
            GoodsHelper.followGoods(id, new Callback<BaseResponse>() {
                @Override
                public void onSuccess(BaseResponse baseResponse) {
                    getView().followSuccess();
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }

    @Override
    public void unFollow(int id) {
        if (isViewAttach()) {
            getView().showLoading();
            GoodsHelper.unFollowGoods(id, new Callback<BaseResponse>() {
                @Override
                public void onSuccess(BaseResponse baseResponse) {
                    getView().unFollowSuccess();
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }
}
