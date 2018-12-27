package zqx.rj.com.seekingcat.mine.presenter;

import java.util.List;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.BaseResponse;
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

    @Override
    public void deleteMyFollow(List<Integer> goodsIdList) {
        GoodsHelper.deleteFollow(goodsIdList, new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                if (isViewAttach()) {
                    getView().deleteSuc();
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
