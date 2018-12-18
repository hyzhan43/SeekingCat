package zqx.rj.com.seekingcat.publish.ui.fragment;

import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.publish.model.entity.request.GoodsModel;

/**
 * author：  HyZhan
 * create：  2018/11/30 16:59
 * desc：    TODO
 */
public class LoseGoodsFragment extends BaseGoodsFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_seek;
    }

    @Override
    public void onPublish() {
        super.onPublish();

        GoodsModel model = new GoodsModel();

        model.setName(mTieName.getText().toString());
        model.setDescription(mTieDesc.getText().toString());
        model.setPhone(mTiePhone.getText().toString());
        model.setPlace(mTiePlace.getText().toString());
        model.setType(GoodsModel.LOSE_GOODS);
        model.setImageFile(goodsFile);

        mPresenter.publishGoods(model);
    }
}
