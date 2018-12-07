package zqx.rj.com.seekingcat.home.model.adapter;

import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.utils.GlideUtil;

/**
 * author：  HyZhan
 * create：  2018/11/28 19:08
 * desc：    TODO
 */
public class GoodsAdapter extends BaseQuickAdapter<GoodsRsp, BaseViewHolder> {

    public GoodsAdapter(int layoutResId, @Nullable List<GoodsRsp> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsRsp item) {

        if (item == null || helper == null)
            return;

        // 发布者
        helper.setText(R.id.tv_name, item.getOriginator());

        GlideUtil.loadImage(mContext, item.getOriginatorUrl(), (ImageView) helper.getView(R.id.civ_portrait));
        GlideUtil.loadImage(mContext, item.getGoodsUrl(), (ImageView) helper.getView(R.id.iv_goods));

        helper.setText(R.id.tv_goods_name, item.getName());
        helper.setText(R.id.tv_description, item.getDescription());
        helper.setText(R.id.tv_time, item.getPublishTime());

        setButtonStyle((Button) helper.getView(R.id.btn_type), item.getType());
    }

    private void setButtonStyle(Button btn, int type) {
        if (type == GoodsRsp.SEARCH_GOODS) {
            btn.setText(mContext.getString(R.string.search_for_notices));
        } else {
            btn.setText(mContext.getString(R.string.lost_and_found));
        }
    }
}
