package zqx.rj.com.base.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import zqx.rj.com.utils.DialogBuilder;
import zqx.rj.com.utils.ToastUtil;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.base.activity
 * 文件名：  BaseActivity
 * 创建者：  ZQX
 * 创建时间：2018/6/27 14:42
 * 描述：    基类 Activity
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity context;
    private Unbinder unbinder;

    protected Dialog mLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        initBefore();

        unbinder = ButterKnife.bind(this);
        context = this;

        ActivityManager.addActivity(this);

        // 初始化 loading
        mLoading = new DialogBuilder(this).build();

        // 初始化控件
        initView();
        // 初始化数据
        initData();
    }

    protected void initBefore() {

    }

    protected void initView() {
    }


    protected void initData() {
    }

    protected abstract int getLayoutId();

    protected void setToolBarTitle(Toolbar toolbar, String title) {
        toolbar.setTitle(title);

        this.setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
    }

    // toast 显示
    public void toast(String str) {
        ToastUtil.show(this, str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ActivityManager.removeActivity(this);
    }
}
