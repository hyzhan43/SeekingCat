package zqx.rj.com.seekingcat.common.goods.model.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.publish.model.entity.request.GoodsModel;
import zqx.rj.com.utils.GlideUtil;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:27
 * desc:    TODO
 */
public class GoodsAdapter extends BaseQuickAdapter<GoodsRsp, BaseViewHolder> {

    public boolean isShowButton = false;

    public GoodsAdapter(int layoutResId, @Nullable List<GoodsRsp> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsRsp item) {
        if (item == null || helper == null)
            return;

        GlideUtil.loadImage(mContext, item.getOriginatorUrl(), (ImageView) helper.getView(R.id.civ_portrait));
        GlideUtil.loadImage(mContext, item.getGoodsUrl(), (ImageView) helper.getView(R.id.iv_goods));

        // 发布者
        helper.setText(R.id.tv_name, item.getOriginator())
                .setText(R.id.tv_goods_name, item.getName())
                .setText(R.id.tv_description, item.getDescription())
                .setText(R.id.tv_time, item.getPublishTime())
                .setChecked(R.id.rb_choose, item.getChoose())
                .addOnClickListener(R.id.rb_choose);     // 默认不选中

        setButtonStyle((Button) helper.getView(R.id.btn_type), item.getType());

        // 是否显示 radioButton
        if (isShowButton) {
            helper.getView(R.id.rb_choose).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.rb_choose).setVisibility(View.GONE);
        }
    }

    private void setButtonStyle(Button btn, int type) {
        if (type == GoodsModel.SEEK_GOODS) {
            btn.setText(mContext.getString(R.string.search_for_notices));
            btn.setBackgroundResource(R.drawable.green_round_bg);
        } else {
            btn.setText(mContext.getString(R.string.lost_and_found));
            btn.setBackgroundResource(R.drawable.red_round_bg);
        }
    }
}
