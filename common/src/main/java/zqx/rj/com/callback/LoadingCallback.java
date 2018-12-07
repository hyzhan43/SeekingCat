package zqx.rj.com.callback;

import com.kingja.loadsir.callback.Callback;

import zqx.rj.com.common.R;

/**
 * author：  HyZhan
 * create：  2018/12/7 13:47
 * desc：    TODO
 */
public class LoadingCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_loading;
    }
}
