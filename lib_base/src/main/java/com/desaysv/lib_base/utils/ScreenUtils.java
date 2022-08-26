package com.desaysv.lib_base.utils;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目名称：Common
 * 类描述：屏幕相关工具类
 * 创建人：ZhangQunSHan
 * 创建时间：2022-7-8
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
public class ScreenUtils {

    private ScreenUtils() {
        /** cannot be instantiated **/
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获得WindowManger
     * @param cx
     * @return
     */
    public static WindowManager getWindowManger(Context cx){
        WindowManager wm = (WindowManager) cx.getSystemService(Context.WINDOW_SERVICE);
        return wm;
    }

    // 获取屏幕的真实高宽（横屏时包括导航栏的宽度）
    public static int getScreenWidth(Context context){
        int width = 0;
        WindowManager manager = getWindowManger(context);
        Display display = manager.getDefaultDisplay();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            DisplayMetrics metrics = new DisplayMetrics();
            display.getRealMetrics(metrics);
            width = metrics.widthPixels;
        } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2){
            try {
                Class clazz = Display.class;
                Method method = clazz.getMethod("getRawWidth");
                width = (int) method.invoke(display);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            // display.getWidth() 该api是在sdk-15开始弃用的
            width = display.getWidth();
        }
        return width;
    }

    // 获取屏幕的高（包括状态栏和导航栏的高度）
    public static int getScreenHeight(Context context){
        int height = 0;
        WindowManager manager = getWindowManger(context);
        Display display = manager.getDefaultDisplay();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            DisplayMetrics metrics = new DisplayMetrics();
            display.getRealMetrics(metrics);
            height = metrics.heightPixels;
        } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            try {
                Class clazz = Display.class;
                Method method = clazz.getMethod("getRawHeight");
                height = (int) method.invoke(display);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            // display.getHeight() 该api是在sdk-15开始弃用的
            height = display.getHeight();
        }
        return height;
    }

    /**
     * @param context
     * 获取状态栏高度
     */
    public static int getStatusBarHeight(Context context){
       /* try {
            Class clazz = Class.forName("com.android.internal.R$dimen");
            Object obj = clazz.newInstance();
            Field field = clazz.getField("status_bar_height");
            int resId = (int) field.get(obj);
            return context.getResources().getDimensionPixelOffset(resId);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        int resourceId = context.getResources().getIdentifier("status_bar_height"
                , "dimen"
                , "android");
        if (resourceId>0){
            return context.getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }



    /**
     * @param context
     * 获取导航栏高度
     */
    public static int getNavigationBarHeight(Context context) {
        if(checkDeviceHasNavigationBar(context)) {
            try {
                Class clazz = Class.forName("com.android.internal.R$dimen");
                Object obj = clazz.newInstance();
                boolean isPortrait = context.getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT;
                String fieldName = "navigation_bar_height";
                if(!isPortrait){
                    fieldName = "navigation_bar_height_landscape";
                }
                Field field = clazz.getField(fieldName);
                int resId = (int) field.get(obj);
                return context.getResources().getDimensionPixelOffset(resId);
            } catch (Exception e) {

            }
        }
        return 0;
    }

    /**
     * @param context
     * 判断是否显示了导航栏
     */
    public static boolean isNavigationBarShow(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            WindowManager manager = getWindowManger(context);
            Display display = manager.getDefaultDisplay();
            Point size = new Point();
            Point realSize = new Point();
            display.getSize(size);
            display.getRealSize(realSize);
            return realSize.y!=size.y;
        }else {
            boolean menu = ViewConfiguration.get(context).hasPermanentMenuKey();
            boolean back = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
            if(menu || back) {
                return false;
            }else {
                return true;
            }
        }
    }

    /**
     * @param context
     * 判断该手机是否有导航栏
     */
    public static boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources resources = context.getResources();
        try {
            String name = "config_showNavigationBar";
            String defType = "bool";
            String defPackage = "android";
            int resId = resources.getIdentifier(name, defType, defPackage);
            if (resId > 0) {
                hasNavigationBar = resources.getBoolean(resId);
            }
            Class clazz = Class.forName("android.os.SystemProperties");
            Method method = clazz.getMethod("get", String.class);
            String args = "qemu.hw.mainkeys";
            String hasNavBar = (String) method.invoke(clazz, args);
            if ("1".equals(hasNavBar)) {
                hasNavigationBar = false;
            } else if ("0".equals(hasNavBar)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;
    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return bp;
    }

    //兼容全屏播放，4.4以下
    public static void fullScreen(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            View view = activity.getWindow().getDecorView();
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public static void resetScreen(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            View view = activity.getWindow().getDecorView();
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    /**
     * 隐藏状态栏和导航栏
     */
    public static void hideBar(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            View view = activity.getWindow().getDecorView();
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
