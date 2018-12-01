package zqx.rj.com.seekingcat.publish.ui.fragment;

import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.publish.contract.PublishContract;
import zqx.rj.com.seekingcat.publish.presenter.PublishPresenter;

/**
 * author：  HyZhan
 * create：  2018/11/30 16:59
 * desc：    TODO
 */
public class SeekGoodsFragment extends MvpFragment<PublishContract.Presenter>
        implements PublishContract.View {

    @Override
    protected PublishContract.Presenter bindPresenter() {
        return new PublishPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_seek;
    }

    @Override
    public void onPublish() {

    }

    @Override
    public void publishSuccess() {

    }
}
