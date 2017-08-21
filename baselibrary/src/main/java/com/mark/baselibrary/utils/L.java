package com.mark.baselibrary.utils;

import android.util.Log;

import com.mark.baselibrary.BuildConfig;

/**
 * 日志工具类
 * Created by Mark.Han on 2017/7/27.
 */

public class L {
    private static final String TAG = "--Main--";

    private static boolean DEBUG = BuildConfig.DEBUG;


    /**
     * 测试是否执行的打印
     */
    public static void e() {
        if (!DEBUG) {
            return;
        }
        Log.e(TAG, "--------------执行了----------------");
    }

    public static void i(Object o) {
        if (!DEBUG) {
            return;
        }
        if (o != null) {
            if (o instanceof String) {
                Log.i(TAG, (String) o);
            } else {
                Log.i(TAG, o.toString());
            }
        }
    }

    public static void d(Object o) {
        if (!DEBUG) {
            return;
        }
        if (o != null) {
            if (o instanceof String) {
                Log.d(TAG, (String) o);
            } else {
                Log.d(TAG, o.toString());
            }
        }
    }

    public static void e(Object o) {
        if (!DEBUG) {
            return;
        }
        if (o != null) {
            if (o instanceof String) {
                Log.e(TAG, (String) o);
            } else {
                Log.e(TAG, o.toString());
            }
        }
    }

    public static void w(Object o) {
        if (!DEBUG) {
            return;
        }
        if (o != null) {
            if (o instanceof String) {
                Log.w(TAG, (String) o);
            } else {
                Log.w(TAG, o.toString());
            }
        }
    }

    public static void v(Object o) {
        if (!DEBUG) {
            return;
        }
        if (o != null) {
            if (o instanceof String) {
                Log.v(TAG, (String) o);
            } else {
                Log.v(TAG, o.toString());
            }
        }
    }


}
