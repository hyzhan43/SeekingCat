package zqx.rj.com.rx;

import java.util.List;

import io.reactivex.functions.Function;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.error.ErrorException;

/**
 * author：  HyZhan
 * created：2018/9/5 12:47
 * desc：    List 转化 单个 bean
 */

public class ListToBean<T> implements Function<BaseResponse<List<T>>, T> {

    @Override
    public T apply(BaseResponse<List<T>> listBaseResponse) throws Exception {
        if (listBaseResponse.getCode() != BaseResponse.REQUEST_SUC){
            throw new ErrorException(listBaseResponse.getCode(), listBaseResponse.getMessage());
        }

        return listBaseResponse.getData().get(0);
    }
}
