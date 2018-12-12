package zqx.rj.com.seekingcat.common.search.presenter;

import java.util.List;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.common.search.contract.SearchContract;
import zqx.rj.com.seekingcat.common.search.model.helper.SearchHelper;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.utils.Log;

/**
 * author:  HyZhan
 * create:  2018/12/12 14:52
 * desc:    TODO
 */
public class SearchPresenter extends BasePresenter<SearchContract.View> implements
        SearchContract.Presenter, Callback<PageRsp<GoodsRsp>> {

    public SearchPresenter(SearchContract.View view) {
        super(view);
    }

    @Override
    public void searchGoods(int page, String keyword) {
        SearchHelper.search(page, keyword, this);
    }

    @Override
    public void onSuccess(PageRsp<GoodsRsp> pageRsp) {
        if (isViewAttach()){
            getView().searchSuccess(pageRsp.getDatas());
        }
    }

    @Override
    public void onFail(String msg) {

    }
}
