package com.mark.baselibrary.base;


import com.mark.baselibrary.utils.NetUtils.NetWorkImp;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public abstract class BaseModelImp<T> extends NetWorkImp<T> {

    private BasePresenterImp mPresenter;

    public BaseModelImp(BasePresenterImp listener) {
        this.mPresenter = listener;
    }

    @Override
    public void addQueue(int what, Request<T> request) {
        //设置缓存
        request.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
        request.setCancelSign(mPresenter.getView().getClass());
        super.addQueue(what, request);
    }

    @Override
    protected void onNetWorkStart(int what) {
        mPresenter.showDialog(what);
    }

    @Override
    protected void onNetWorkFinish(int what) {
        mPresenter.cancelDialog(what);
    }

    @Override
    protected void onSuccess(int what, Response<T> response) {
        mPresenter.Success(what, response.get());
//        mPresenter.Success(response.getTag(), response.get());
    }

    @Override
    protected void onFail(int what, Response<T> response) {
        mPresenter.Error(what, response.getException().getMessage());
    }
}
