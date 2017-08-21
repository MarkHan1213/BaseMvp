package com.mark.baselibrary.base;


import com.mark.baselibrary.utils.NetUtils.RequestListener;

import java.lang.ref.WeakReference;

/**
 * Presenter基类
 * Created by Mark.Han on 2017/7/13.
 */

public abstract class BasePresenterImp<M extends BaseModelImp> implements RequestListener {
    private WeakReference mView;
    protected M mModel;


    public <V extends BaseView> void attach(V view) {
        if (mView == null) {
            mView = new WeakReference(view);
        }
        initData();
    }

    public void setModel(M model) {
        this.mModel = model;
    }

    protected abstract void initData();

    public void detach() {
        if (mModel != null) {
            mModel.cancelBySign(mView.get().getClass());
        }

        if (mView != null) {
            mView.clear();
            mView = null;
        }
        // TODO: 2017/7/13 资源回收
//        mModel.onDetach();

    }

    public void showDialog(int what) {
        getView().showLoading();
    }

    public void cancelDialog(int what) {
        getView().hideLoading();
    }

    public <V extends BaseView> V getView() {
        if (mView != null) {
            return (V) mView.get();
        }
        return null;
    }

    public void Error(int what, String error) {
        cancelDialog(what);
        getView().showInfo(error);
    }
}
