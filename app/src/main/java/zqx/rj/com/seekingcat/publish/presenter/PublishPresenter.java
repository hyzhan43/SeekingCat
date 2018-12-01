package zqx.rj.com.seekingcat.publish.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.publish.contract.PublishContract;
import zqx.rj.com.seekingcat.publish.model.entity.request.GoodsModel;
import zqx.rj.com.seekingcat.publish.model.helper.PublishHelper;

/**
 * author：  HyZhan
 * create：  2018/11/30 15:31
 * desc：    TODO
 */
public class PublishPresenter extends BasePresenter<PublishContract.View>
        implements PublishContract.Presenter, Callback<BaseResponse> {

    public PublishPresenter(PublishContract.View view) {
        super(view);
    }

    @Override
    public void publishGoods(GoodsModel goodsModel) {

        check(goodsModel.getName());
        check(goodsModel.getDescription());
        check(goodsModel.getPhone());
        check(goodsModel.getPlace());

        if (goodsModel.getImageFile() == null){
            getView().showError(R.string.goods_file_empty);
            return;
        }

        PublishHelper.publish(goodsModel, this);
    }

    private void check(String str){
        if (str == null || str.length() == 0)
            getView().showError(R.string.goods_tips);
    }

    @Override
    public void onSuccess(BaseResponse baseResponse) {
        if (isViewAttach()){
            getView().publishSuccess();
        }
    }

    @Override
    public void onFail(String msg) {
        if (isViewAttach()){
            getView().showError(msg);
        }
    }
}
