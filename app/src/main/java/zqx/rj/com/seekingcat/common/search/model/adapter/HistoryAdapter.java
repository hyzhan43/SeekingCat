package zqx.rj.com.seekingcat.common.search.model.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.search.model.db.Record;

/**
 * author:  HyZhan
 * create:  2018/12/12 15:25
 * desc:    TODO
 */
public class HistoryAdapter extends BaseQuickAdapter<Record, BaseViewHolder> {

    public HistoryAdapter(int layoutResId, @Nullable List<Record> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Record item) {
        if (item != null) {
            helper.setText(R.id.tv_record, item.getRecord())
                    .addOnClickListener(R.id.iv_close);
        }

    }
}
