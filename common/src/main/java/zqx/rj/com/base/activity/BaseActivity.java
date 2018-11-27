package zqx.rj.com.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        unbinder = ButterKnife.bind(this);
        context = this;

        ActivityManager.addActivity(this);

        ToastUtil.init(this);

        // 初始化控件
        initView();
        // 初始化数据
        initData();
    }

    protected void initView() {
    }


    protected void initData() {
    }


    protected abstract int getLayoutId();


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




    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ActivityManager.removeActivity(this);
    }
}
