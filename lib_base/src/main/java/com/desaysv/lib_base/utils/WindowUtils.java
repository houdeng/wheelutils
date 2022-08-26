package com.desaysv.lib_base.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.view.Surface;

/**
 * 项目名称：Common
 * 类描述：窗口工具工具类
 * 创建人：ZhangQunSHan
 * 创建时间：2022-7-11
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
public class WindowUtils {
    /**
     * Don't let anyone instantiate this class.
     */
    private WindowUtils() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 获取当前窗口的旋转角度
     *
     * @param activity
     * @return
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static int getDisplayRotation(Activity activity) {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case Surface.ROTATION_0:
                return 0;
            case Surface.ROTATION_90:
                return 90;
            case Surface.ROTATION_180:
                return 180;
            case Surface.ROTATION_270:
                return 270;
            default:
                return 0;
        }
    }

    /**
     * 当前是否是横屏
     * @return
     */
    public static boolean isLandscape() {
        return ApplicationUtils.INSTANCE.getApplication().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * 当前是否是竖屏
     * @return
     */
    public static boolean isPortrait() {
        return ApplicationUtils.INSTANCE.getApplication().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
