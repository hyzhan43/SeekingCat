package zqx.rj.com.seekingcat.mine.presenter;

import java.io.File;

import okhttp3.MultipartBody;
import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.mine.contract.MineContract;
import zqx.rj.com.seekingcat.mine.model.bean.UserInfoRsp;
import zqx.rj.com.seekingcat.mine.model.helper.MineHelper;
import zqx.rj.com.utils.UtilTools;

/**
 * author：  HyZhan
 * create：  2018/12/4 15:01
 * desc：    TODO
 */
public class MinePresenter extends BasePresenter<MineContract.View>
        implements MineContract.Presenter {

    public MinePresenter(MineContract.View view) {
        super(view);
    }

    @Override
    public void getUserInfo() {
        if (isViewAttach()) {
            MineHelper.getUserInfo(new Callback<UserInfoRsp>() {
                @Override
                public void onSuccess(UserInfoRsp userInfoRsp) {
                    getView().getUserInfoSuccess(userInfoRsp);
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }

    @Override
    public void updateNickName(String nickname) {
        if (isViewAttach()) {
            MineHelper.updateNickName(nickname, new Callback<BaseResponse>() {
                @Override
                public void onSuccess(BaseResponse baseResponse) {
                    getView().updateNickNameSuc();
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }

    @Override
    public void updatePortrait(File goodsFile) {
        // avatarFile 对应 服务器文件 名称 key
        MultipartBody.Part body = UtilTools.fileToMultipartBody(goodsFile, "avatarFile");

        if (isViewAttach()) {
            getView().showLoading();
            MineHelper.updatePortrait(body, new Callback<BaseResponse>() {
                @Override
                public void onSuccess(BaseResponse baseResponse) {
                    getView().updatePortraitSuc();
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }

}
