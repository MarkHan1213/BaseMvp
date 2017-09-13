package com.mark.legalhelper.main;

import com.mark.baselibrary.base.BaseModelImp;
import com.mark.baselibrary.base.BasePresenterImp;
import com.mark.baselibrary.utils.L;
import com.mark.legalhelper.Api;
import com.yanzhenjie.nohttp.rest.JsonObjectRequest;

/**
 * 首页的请求
 * Created by Mark.Han on 2017/8/22.
 */

public class MainModel extends BaseModelImp {

    public MainModel(BasePresenterImp listener) {
        super(listener);
    }

    public void getMainData() {
//        JsonArrayRequest request = new JsonArrayRequest(Api.MAIN_URL);
        JsonObjectRequest request = new JsonObjectRequest(Api.MAIN_URL);
//        StringRequest request = new StringRequest(Api.MAIN_URL, RequestMethod.GET);
        addQueue(Api.MAIN_URL_WHAT, request);
    }


    @Override
    protected void onSuccess(int what, Object response) {
        if (what == Api.MAIN_URL_WHAT) {
            L.e();
//            List<MainData> mainDatas = JSON.parseArray(((JSONArray) response).toJSONString(), MainData.class);
//            Logger.d(mainDatas.toString());
//            mPresenter.Success(1, mainDatas);
        }
    }
}
