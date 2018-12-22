package zqx.rj.com.seekingcat.common.goods.ui.activity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;

/**
 * author:  HyZhan
 * create:  2018/12/22 12:00
 * desc:    封装 goods 编辑功能 抽象类
 */
public abstract class GoodsEditActivity<T extends BaseContract.Presenter> extends GoodsActivity<T> {

    // 是否编辑状态
    protected boolean isEdit = true;

    @BindView(R.id.ll_edit_bar)
    LinearLayout mLlEditBar;

    @BindView(R.id.rb_all_choose)
    RadioButton mRbAllChoose;

    // 底部 全选 按钮
    protected boolean isAllChoose = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit_goods;
    }

    @Override
    protected void initView() {
        super.initView();

        mGoodsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                // 选中 radioButton
                RadioButton radioButton = (RadioButton) view;

                GoodsRsp goodsRsp = mGoodsAdapter.getItem(position);
                if (goodsRsp != null) {
                    Boolean isChoose = goodsRsp.getChoose();
                    radioButton.setChecked(!isChoose);
                    goodsRsp.setChoose(!isChoose);
                }
            }
        });
    }

    /**
     * toolbar  右侧 添加 编辑 按钮
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(getMenuId(), menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 设置 edit 右边按钮
     */
    protected abstract int getMenuId();

    protected abstract void onItemSelected(MenuItem item);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void addData(PageRsp<GoodsRsp> pageRsp) {

        // 如果是编辑状态   就显示出  radioButton
        if (!isEdit) {
            mGoodsAdapter.isShowButton = true;
        }

        super.addData(pageRsp);
    }

    /**
     * 显示 或者 隐藏 radioButton
     */
    protected void showOrHideButton(MenuItem item) {
        if (isEdit) {
            isEdit = false;
            item.setTitle(getString(R.string.finish));
            mGoodsAdapter.isShowButton = true;
            mGoodsAdapter.notifyDataSetChanged();

            // 重置 未选中
            isAllChoose = false;

            // 显示 底部 编辑bar
            mLlEditBar.setVisibility(View.VISIBLE);
        } else {
            isEdit = true;
            item.setTitle(getString(R.string.edit));
            mGoodsAdapter.isShowButton = false;

            // 重置 未选中
            isAllChoose = false;

            // 重置 radioButton
            setRadioChoose(false);

            // 隐藏 底部 编辑bar
            mLlEditBar.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.rb_all_choose)
    void onClickAllChoose() {
        isAllChoose = !isAllChoose;
        setRadioChoose(isAllChoose);
    }

    private void setRadioChoose(Boolean isChoose) {
        for (GoodsRsp goodsRsp : mGoodsAdapter.getData()) {
            if (goodsRsp.getChoose() != isChoose) {
                goodsRsp.setChoose(isChoose);
            }
        }
        mRbAllChoose.setChecked(isChoose);

        mGoodsAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_delete)
    void onClickDelete() {
        toast("删除");
    }
}
