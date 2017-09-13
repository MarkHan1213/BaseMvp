package com.mark.legalhelper.main;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.mark.baselibrary.base.BasePresenterImp;
import com.yanzhenjie.nohttp.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark.Han on 2017/8/22.
 */

public class MainPresenter extends BasePresenterImp<MainView, MainModel> {

    private List<MainData> mMainDatas;
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();


    @Override
    public void Success(int what, Object result) {
        if (what == 1) {
            mMainDatas = (List<MainData>) result;

            for (int i = 0; i < mMainDatas.size(); i++) {//遍历省份
                ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
                ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

                for (int c = 0; c < mMainDatas.get(i).getCity().size(); c++) {//遍历该省份的所有城市
                    String CityName = mMainDatas.get(i).getCity().get(c).getName();
                    CityList.add(CityName);//添加城市

                    ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                    //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                    if (mMainDatas.get(i).getCity().get(c).getArea() == null
                            || mMainDatas.get(i).getCity().get(c).getArea().size() == 0) {
                        City_AreaList.add("");
                    } else {

                        for (int d = 0; d < mMainDatas.get(i).getCity().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                            String AreaName = mMainDatas.get(i).getCity().get(c).getArea().get(d);

                            City_AreaList.add(AreaName);//添加该城市所有地区数据
                        }
                    }
                    Province_AreaList.add(City_AreaList);//添加该省所有地区数据
                }

                /**
                 * 添加城市数据
                 */
                options2Items.add(CityList);

                /**
                 * 添加地区数据
                 */
                options3Items.add(Province_AreaList);
            }

        }

        AlertDialog dialog = new AlertDialog.Builder(getContext()).setMessage("这是个对话框")
                .setNegativeButton("取消", null).show();

        Logger.e("what:" + what + ",result=" + result);
    }

    @Override
    protected void initData() {
        setModel(new MainModel(this));
        mModel.getMainData();
    }


    public void showTips() {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(getContext(), (options1, options2, options3, v) -> {
            //返回的分别是三个级别的选中位置
            String tx = mMainDatas.get(options1).getPickerViewText() +
                    options2Items.get(options1).get(options2) +
                    options3Items.get(options1).get(options2).get(options3);

            Toast.makeText(getContext(), tx, Toast.LENGTH_SHORT).show();
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(mMainDatas, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }
}
