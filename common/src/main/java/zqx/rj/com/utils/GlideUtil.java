package zqx.rj.com.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import zqx.rj.com.common.R;

/**
 * author：  HyZhan
 * create：  2018/12/4 17:36
 * desc：    TODO
 */
public class GlideUtil {

    public static void loadImage(Context context, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_image_loading);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }
}
