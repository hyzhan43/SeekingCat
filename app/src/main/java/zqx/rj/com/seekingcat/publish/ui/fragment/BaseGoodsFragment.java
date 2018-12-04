package zqx.rj.com.seekingcat.publish.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.constants.Constants;
import zqx.rj.com.seekingcat.MainActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.publish.contract.PublishContract;
import zqx.rj.com.seekingcat.publish.presenter.PublishPresenter;
import zqx.rj.com.utils.UtilTools;
import zqx.rj.com.widget.BottomDialog;

import static android.app.Activity.RESULT_OK;

/**
 * author：  HyZhan
 * create：  2018/11/30 16:59
 * desc：    TODO
 */
public abstract class BaseGoodsFragment extends MvpFragment<PublishContract.Presenter>
        implements PublishContract.View, View.OnClickListener {

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

    protected File goodsFile;
    private File tempFile;

    private Dialog dialog;

    @Override
    protected PublishContract.Presenter bindPresenter() {
        return new PublishPresenter(this);
    }

    @Override
    public void initView(View view) {
        super.initView(view);

        initDialog();
    }

    private void initDialog() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_view, null);

        dialog = new BottomDialog(getActivity(), view, R.style.Theme_Dialog);

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
     *  发布成功
     */
    @Override
    public void publishSuccess() {
        toast(getString(R.string.publish_success));

        Activity activity = getActivity();

        Intent intent = new Intent(activity, MainActivity.class);
        startActivity(intent);

        activity.finish();
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
        // 启动系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 传递路径
        File file = new File(Environment.getExternalStorageDirectory(),
                Constants.PHOTO_IMAGE_FILE_NAME);

        Uri uri = Uri.fromFile(file);
        // 更改系统默认拍照存储路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, Constants.CAMERA_REQUEST_CODE);

        dialog.dismiss();
    }

    // 跳转到相册
    private void goToAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        // 选择照片
        intent.setType("image/*");
        startActivityForResult(intent, Constants.IMAGE_REQUEST_CODE);

        dialog.dismiss();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                // 相机数据
                case Constants.CAMERA_REQUEST_CODE:
                    // 获取 拍照相片 原始文件
                    tempFile = new File(Environment.getExternalStorageDirectory(),
                            Constants.PHOTO_IMAGE_FILE_NAME);

                    // 进行缩放 裁剪
                    startPhotoZoom(Uri.fromFile(tempFile));
                    break;
                // 相册数据
                case Constants.IMAGE_REQUEST_CODE:
                    startPhotoZoom(data.getData());
                    break;
                case Constants.ZOOM_REQUEST_CODE:
                    // 有可能点 舍去
                    if (data != null) {
                        // 拿到图片
                        getZoomFile(data);

                        // 既然已经设置了 图片，就把原来图片删除。
                        if (tempFile != null) {
                            tempFile.delete();
                        }
                    }
                    break;
            }
        }
    }

    private void startPhotoZoom(Uri uri) {
        if (uri != null) {
            // 设置裁剪行为
            Intent intent = new Intent("com.android.camera.action.CROP");
            // 裁剪数据和类型
            intent.setDataAndType(uri, "image/*");
            // 设置裁剪
            intent.putExtra("crop", "true");
            // 裁剪宽高比例
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            // 裁剪图片的质量 (分辨率)
            intent.putExtra("outputX", 320);
            intent.putExtra("outputY", 320);
            // 发送数据 (固定写法 return-data)
            intent.putExtra("return-data", true);

            startActivityForResult(intent, Constants.ZOOM_REQUEST_CODE);
        }
    }

    private void getZoomFile(Intent data) {
        Bundle bundle = data.getExtras();
        if (bundle != null) {
            // 获取裁剪后的 bitmap
            Bitmap goodsBitmap = bundle.getParcelable("data");
            mIvAdd.setImageBitmap(goodsBitmap);

            // 转化为  file
            goodsFile = UtilTools.bitmapToFile(
                    goodsBitmap,
                    Environment.getExternalStorageDirectory().getPath(),
                    Constants.ZOOM_IMAGE_FILE_NAME);       // 转化后的文件名
        }
    }
}
