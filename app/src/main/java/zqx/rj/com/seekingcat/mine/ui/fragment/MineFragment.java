package zqx.rj.com.seekingcat.mine.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.model.TResult;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import zqx.rj.com.base.mvp.MvpFragment;
import zqx.rj.com.constants.Constants;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.mine.contract.MineContract;
import zqx.rj.com.seekingcat.mine.model.bean.UserInfoRsp;
import zqx.rj.com.seekingcat.mine.presenter.MinePresenter;
import zqx.rj.com.seekingcat.mine.ui.activity.AboutActivity;
import zqx.rj.com.seekingcat.mine.ui.activity.FollowActivity;
import zqx.rj.com.seekingcat.mine.ui.activity.MyPublishActivity;
import zqx.rj.com.utils.DialogBuilder;
import zqx.rj.com.utils.GlideUtil;
import zqx.rj.com.utils.Log;
import zqx.rj.com.utils.Preferences;
import zqx.rj.com.utils.UtilTools;

/**
 * author：  HyZhan
 * create：  2018/11/28 18:22
 * desc：    TODO
 */

public class MineFragment extends MvpFragment<MineContract.Presenter>
        implements MineContract.View, View.OnClickListener,
        TakePhoto.TakeResultListener{

    @BindView(R.id.civ_portrait)
    CircleImageView mCivPortrait;

    @BindView(R.id.tv_name)
    TextView mTvName;

    @BindView(R.id.tv_publish_count)
    TextView mTvPublishCount;

    @BindView(R.id.tv_follow_count)
    TextView mTvFollowCount;

    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mRefreshLayout;

    private Dialog mPortraitDialog;

    // 昵称 dialog
    private AlertDialog mNameDialog;

    // 更新后的 用户名
    private String newName;

    // 更新后的 头像文件
    private File goodsFile;

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MineContract.Presenter bindPresenter() {
        return new MinePresenter(this);
    }

    @Override
    public void initView(View view) {
        super.initView(view);

        // 设置 刷新进度条颜色。
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getUserInfo();
            }
        });
    }

    @Override
    public void initData() {
        super.initData();

        mPresenter.getUserInfo();
    }

    @Override
    public void getUserInfoSuccess(UserInfoRsp userInfoRsp) {

        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }

        if (userInfoRsp == null)
            return;

        String nickName = userInfoRsp.getNickName();
        if (nickName == null) {
            nickName = "未设置";
        }

        // 存储个人信息
        Preferences.putString(Constants.NICK_NAME, nickName);
        Preferences.putString(Constants.AVATAR_URL, userInfoRsp.getAvatarUrl());

        mTvName.setText(nickName);
        // 显示头像
        GlideUtil.loadImage(getContext(), userInfoRsp.getAvatarUrl(), mCivPortrait);
        mTvPublishCount.setText(String.valueOf(userInfoRsp.getPublishCount()));
        mTvFollowCount.setText(String.valueOf(userInfoRsp.getFollowCount()));
    }


    /**
     * 点击头像, 更换头像
     */
    @OnClick(R.id.civ_portrait)
    void onClickPortrait() {
        getPortraitDialog().show();
    }

    private Dialog getPortraitDialog() {

        if (mPortraitDialog == null) {
            mPortraitDialog = new DialogBuilder(getActivity())
                    .setLayoutId(R.layout.dialog_photoview)
                    .setGravity(Gravity.BOTTOM)
                    .setAnimation(R.style.pop_anim_style)
                    .setCancelable(true)
                    .build();

            Button mBtnCamera = mPortraitDialog.findViewById(R.id.btn_camera);
            mBtnCamera.setOnClickListener(this);

            Button mBtnAlbum = mPortraitDialog.findViewById(R.id.btn_album);
            mBtnAlbum.setOnClickListener(this);

            Button mBtnCancel = mPortraitDialog.findViewById(R.id.btn_cancel);
            mBtnCancel.setOnClickListener(this);
        }

        return mPortraitDialog;
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
                mPortraitDialog.dismiss();
                break;
        }
    }

    // 跳转到相机
    private void goToCamera() {

        // 创建相机 剪切后的目录
        File cameraFile = UtilTools.createFile("cameraTemp");
        Uri uri = Uri.fromFile(cameraFile);

        // 启动相机, 并剪切图片
        getTakePhoto().onPickFromCaptureWithCrop(uri, UtilTools.getCropOptions());

        mPortraitDialog.dismiss();
    }

    // 跳转到相册
    private void goToAlbum() {

        File cropFile = UtilTools.createFile("album");
        Uri uri = Uri.fromFile(cropFile);

        TakePhoto takePhoto = getTakePhoto();
        // 跳转到相册 并剪切图片
        takePhoto.onPickFromGalleryWithCrop(uri, UtilTools.getCropOptions());

        mPortraitDialog.dismiss();
    }

    /**
     * 点击 用户名
     */
    @OnClick(R.id.tv_name)
    void onClickName() {

        getNameDialog().show();

        // 设置 dialog 字体颜色
        mNameDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(
                getResources().getColor(R.color.colorPrimary));

        mNameDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(
                getResources().getColor(R.color.colorPrimary));
    }

    /**
     * 更新用户信息 成功
     */
    @Override
    public void updateNickNameSuccess() {
        hideLoading();

        mTvName.setText(newName);
    }

    private AlertDialog getNameDialog() {

        if (mNameDialog == null) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_edit_view, null);

            final EditText mEtNewName = view.findViewById(R.id.et_name);
            mEtNewName.setText(mTvName.getText().toString());

            mNameDialog = new AlertDialog.Builder(getActivity())
                    .setMessage("昵称")
                    .setView(view)
                    .setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            // 如果 昵称一样 就不修改
                            if (mEtNewName.getText().toString().equals(mTvName.getText().toString()))
                                return;

                            showLoading();
                            // 更新 nickname
                            newName = mEtNewName.getText().toString();
                            mPresenter.updateNickName(newName);
                        }
                    })
                    .create();
        }

        return mNameDialog;
    }

    @OnClick({R.id.tv_publish, R.id.tv_publish_count})
    void onClickPublish() {
        Intent intent = new Intent(getActivity(), MyPublishActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.tv_follow, R.id.tv_follow_count})
    void onClickFollow() {
        Intent intent = new Intent(getActivity(), FollowActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_about)
    void onClickAbout() {
        Intent intent = new Intent(getActivity(), AboutActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_setting)
    void onClickSetting() {
        toast("设置");
    }

    @OnClick(R.id.tv_logout)
    void onClickLogout() {
        toast("退出登录");
    }

    /**
     *  头像 选择成功回调
     */
    @Override
    public void takeSuccess(TResult result) {
        String path = result.getImage().getOriginalPath();
        goodsFile = new File(path);

        // 加载显示 更新后的头像
        GlideUtil.loadImage(getActivity(), path, mCivPortrait);

        toast("修改为：" + newName);
        // TODO 上传头像 到 服务器
    }

    @Override
    public void takeFail(TResult result, String msg) {
        toast("失败：" + msg);
        Log.d("图片失败 ：" + msg);
    }

    @Override
    public void takeCancel() {

    }
}
