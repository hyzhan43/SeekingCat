package zqx.rj.com.seekingcat.common.search.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.common.search.contract.SearchContract;
import zqx.rj.com.seekingcat.common.search.model.helper.SearchHelper;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;

/**
 * author:  HyZhan
 * create:  2018/12/12 14:52
 * desc:    TODO
 */
public class SearchPresenter extends BasePresenter<SearchContract.View> implements
        SearchContract.Presenter {

    public SearchPresenter(SearchContract.View view) {
        super(view);
    }

    @Override
    public void searchGoods(int page, String keyword) {
        if (isViewAttach()) {
            getView().showLoading();
            SearchHelper.search(page, keyword, new Callback<PageRsp<GoodsRsp>>() {
                @Override
                public void onSuccess(PageRsp<GoodsRsp> pageRsp) {
                    getView().searchSuccess(pageRsp.getDatas());
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }
}
