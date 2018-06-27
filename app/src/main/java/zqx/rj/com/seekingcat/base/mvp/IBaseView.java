package zqx.rj.com.seekingcat.base.mvp;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.base
 * 文件名：  IBaseView
 * 创建者：  ZQX
 * 创建时间：2018/6/27 13:21
 * 描述：    TODO
 */

public interface IBaseView<T> {

    /**
     *   显示 loading
     */
    void showLoading();

    /**
     *   隐藏 loading
     */
    void hideLoading();

    /**
     *  显示错误
     */
    void showError(int code, String msg);

    /**
     *  设置 presenter
     */
    void setPresenter(T presenter);
}
