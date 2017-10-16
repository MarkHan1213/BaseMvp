package com.mark.legalhelper.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;

import com.mark.baselibrary.base.BaseActivity;
import com.mark.baselibrary.utils.L;
import com.mark.baselibrary.widget.TitleBar;
import com.mark.legalhelper.R;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

//    @BindView(R.id.rc_list)
//    RecyclerView mRcList;
//    @BindView(R.id.btn_click)
//    Button mBtnClick;

    //    @Titles
    private static final String[] mTitles = {"页面一", "页面二", "页面三", "页面四"};

    //    @SeleIcons
    private static final int[] mSeleIcons = {R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round};

    //    @NorIcons
    private static final int[] mNormalIcons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    @BindView(R.id.id_content)
    FrameLayout mIdContent;
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator mAlphaIndicator;
    @BindView(R.id.titlebar)
    TitleBar mTitlebar;
//    @BindView(R.id.tabbar)
//    JPTabBar mTabbar;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAlphaIndicator.getTabView(1).showNumber(20);
        mAlphaIndicator.setOnTabChangedListner(tabNum -> mAlphaIndicator.getTabView(tabNum).removeShow());
        mTitlebar.setTitleText("app的标题");
//        mRcList.setLayoutManager(layoutManager);

//        mTabbar.setTitles(mTitles)
//                .setNormalIcons(mNormalIcons)
//                .setSelectedIcons(mSeleIcons)
//                .generate();
//
//        mTabbar.setTabListener(index -> L.e("点击了第" + index + "个"));
//        mTabbar.showBadge(2, 20, true);
    }

    @Override
    protected void initData() {
        L.a("aaa");
        L.d("ddd");
        L.e("eee");
        L.i("iii");
        L.w("www");
        L.v("vvv");
        L.json("aaa:bbbb,ccc:ddd");
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showLoading() {
        showDialogTip(11);
    }

    @Override
    public void hideLoading() {
        cancelDialogTip(11);
    }

    @Override
    public void showInfo(String s) {
    }


    public void show(View view) {
        mPresenter.showTips();
    }


}
