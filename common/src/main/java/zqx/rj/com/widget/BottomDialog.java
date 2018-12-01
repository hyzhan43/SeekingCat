package zqx.rj.com.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;
import zqx.rj.com.common.R;

/**
 * author：  HyZhan
 * create：  2018/11/30 20:19
 * desc：    TODO
 */
public class BottomDialog extends Dialog {

    private View view;

    public BottomDialog(@NonNull Context context, View view, int style) {
        super(context, style);
        this.view = view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(view);

        Window window = getWindow();

        if (window == null)
            return;

        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
        window.setWindowAnimations(R.style.pop_anim_style);
    }
}
