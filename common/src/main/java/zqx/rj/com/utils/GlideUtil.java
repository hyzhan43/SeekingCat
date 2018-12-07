package zqx.rj.com.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

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

    public static void loadImage(Context context, Uri uri, ImageView imageView) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_image_loading);

        Glide.with(context)
                .load(uri)
                .apply(options)
                .into(imageView);
    }

}
