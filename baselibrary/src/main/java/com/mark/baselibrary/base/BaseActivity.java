package com.mark.baselibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mark.baselibrary.utils.ToastHelp;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity的基类
 * Created by Mark.Han on 2017/7/10.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = getPresenter();
        if (mPresenter != null) {
            if (this instanceof BaseView)
                mPresenter.attach((BaseView) this);
        }
        initView();
        initData();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        mUnbinder = ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }

    protected void showDialogTip(int id) {
        ToastHelp.show(this, "此时该弹第i个加载框");
    }

    protected void cancelDialogTip(int id) {
        ToastHelp.show(this, "此时该关闭第i个加载框");
    }

    protected void jumpToActivity(Class aClass) {
        Intent intent = new Intent(this, aClass);
        startActivity(intent);
    }

}
