package zqx.rj.com.seekingcat.publish.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.seekingcat.MainActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.publish.contract.PublishContract;
import zqx.rj.com.seekingcat.publish.presenter.PublishPresenter;
import zqx.rj.com.utils.GlideUtil;
import zqx.rj.com.utils.Log;
import zqx.rj.com.utils.UtilTools;
import zqx.rj.com.widget.CustomDialog;

/**
 * author：  HyZhan
 * create：  2018/11/30 16:59
 * desc：    TODO
 */
public abstract class BaseGoodsFragment extends MvpFragment<PublishContract.Presenter>
        implements PublishContract.View, View.OnClickListener,
        TakePhoto.TakeResultListener, InvokeListener {

    @BindView(R.id.tie_name)
    TextInputEditText mTieName;

    @BindView(R.id.tie_description)
    TextInputEditText mTieDesc;

    @BindView(R.id.tie_phone)
    TextInputEditText mTiePhone;

    @BindView(R.id.tie_place)
    TextInputEditText mTiePlace;

    @BindView(R.id.iv_add)
    ImageView mIvAdd;

    private Dialog dialog;
    private Dialog mLoading;

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    protected File goodsFile;

    @Override
    protected PublishContract.Presenter bindPresenter() {
        return new PublishPresenter(this);
    }

    @Override
    public void initView(View view) {
        super.initView(view);

        initDialog();
        initLoading();
        getTakePhoto();
    }

    private void initLoading() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_loading, null);
        mLoading = new CustomDialog(getActivity(),
                view,
                R.style.Theme_Dialog,
                Gravity.CENTER);

        mLoading.setCancelable(false);
    }

    private void initDialog() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_view, null);

        dialog = new CustomDialog(getActivity(), view, R.style.Theme_Dialog);

        // TODO ButterKnife ??
        Button mBtnCamera = view.findViewById(R.id.btn_camera);
        mBtnCamera.setOnClickListener(this);

        Button mBtnAlbum = view.findViewById(R.id.btn_album);
        mBtnAlbum.setOnClickListener(this);

        Button mBtnCancel = view.findViewById(R.id.btn_cancel);
        mBtnCancel.setOnClickListener(this);
    }

    @OnClick(R.id.iv_add)
    void onAddClick() {
        dialog.show();
    }

    /**
     * 发布成功
     */
    @Override
    public void publishSuccess() {
        mLoading.dismiss();

        toast(getString(R.string.publish_success));

        Activity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, MainActivity.class);
            startActivity(intent);

            activity.finish();
        }
    }

    @Override
    public void onPublish() {
        mLoading.show();
    }

    @Override
    public void showError(String str) {
        super.showError(str);
        mLoading.dismiss();
    }

    @Override
    public void showError(int str) {
        super.showError(str);
        mLoading.dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_camera:
                goToCamera();
                break;
            case R.id.btn_album:
                goToAlbum();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
        }
    }

    // 跳转到相机
    private void goToCamera() {

        // 创建相机 剪切后的目录
        File cameraFile = UtilTools.createFile("cameraTemp");
        Uri uri = Uri.fromFile(cameraFile);

        // 启动相机, 并剪切图片
        takePhoto.onPickFromCaptureWithCrop(uri, UtilTools.getCropOptions());

        dialog.dismiss();
    }

    // 跳转到相册
    private void goToAlbum() {

        File cropFile = UtilTools.createFile("album");
        Uri uri = Uri.fromFile(cropFile);

        TakePhoto takePhoto = getTakePhoto();
        // 跳转到相册 并剪切图片
        takePhoto.onPickFromGalleryWithCrop(uri, UtilTools.getCropOptions());

        dialog.dismiss();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTakePhoto().onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getTakePhoto().onSaveInstanceState(outState);
    }

    @Override
    public void takeFail(TResult result, String msg) {
        toast("失败：" + msg);
        Log.d("图片失败 ：" + msg);
    }

    @Override
    public void takeSuccess(TResult result) {

        String path = result.getImage().getOriginalPath();
        goodsFile = new File(path);

        // 加载显示图片
        GlideUtil.loadImage(getActivity(), path, mIvAdd);
    }

    @Override
    public void takeCancel() {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //以下代码为处理Android6.0、7.0动态权限所需
        PermissionManager.TPermissionType type = PermissionManager
                .onRequestPermissionsResult(requestCode, permissions, grantResults);

        PermissionManager.handlePermissionsResult(getActivity(), type,
                invokeParam, this);
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this),
                invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
    }

    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this)
                    .bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }
}
