package com.desaysv.lib_base.utils;

import android.content.Context;
import android.os.Vibrator;



/**震动工具类
 * Created by zqs on 2020/5/13
 */
public class VibratorUtils {
    /**
     * long milliseconds ：震动的时长，单位是毫秒
     * long[] pattern  ：自定义震动模式 。数组中数字的含义依次是[静止时长，震动时长，静止时长，震动时长。。。]时长的单位是毫秒
     * boolean isRepeat ： 是否反复震动，如果是true，反复震动，如果是false，只震动一次
     */

    public static void vibrator(){
        long milliseconds=100;
        Vibrator vibrator = (Vibrator) ApplicationUtils.INSTANCE.getApplication().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(milliseconds);
    }
    public static void vibrator(long milliseconds){
        Vibrator vibrator = (Vibrator) ApplicationUtils.INSTANCE.getApplication().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(milliseconds);
    }

    public static void vibrator(long[] pattern,boolean isRepeat){
        Vibrator vibrator = (Vibrator) ApplicationUtils.INSTANCE.getApplication().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(pattern,isRepeat? 1:-1);
    }
}
