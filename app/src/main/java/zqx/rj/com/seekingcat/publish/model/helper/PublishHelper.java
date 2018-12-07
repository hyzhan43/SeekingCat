package zqx.rj.com.seekingcat.publish.model.helper;

import java.io.File;

import okhttp3.MultipartBody;
import zqx.rj.com.constants.Constants;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.seekingcat.publish.model.entity.request.GoodsModel;
import zqx.rj.com.utils.Log;
import zqx.rj.com.utils.RxScheduler;
import zqx.rj.com.utils.UtilTools;

/**
 * author：  HyZhan
 * create：  2018/12/1 11:19
 * desc：    TODO
 */
public class PublishHelper extends BaseHelper {

    public static void publish(GoodsModel goodsModel, final Callback<BaseResponse> callback) {

        File file = goodsModel.getImageFile();
        // imageFile 对应 服务器文件 名称 key
        MultipartBody.Part body = UtilTools.fileToMultipartBody(file, "imageFile");

        Log.d(goodsModel.getPhone());

        apiHelper().publishGoods(
                goodsModel.getName(),
                goodsModel.getDescription(),
                goodsModel.getPhone(),
                goodsModel.getPlace(),
                goodsModel.getType(),
                goodsModel.getReward(),
                body)
                .compose(RxScheduler.<BaseResponse>ioToMain())
                .subscribe(new BaseObserver<BaseResponse>(callback));
    }
}
