package com.mark.baselibrary.utils.NetUtils;

/**
 * Created by Mark.Han on 2017/8/15.
 */

public interface RequestListener<T> {

    void Success(int what, T result);

    void Error(int what, String error);
}
