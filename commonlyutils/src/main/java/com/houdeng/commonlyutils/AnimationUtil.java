package com.houdeng.commonlyutils;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * 加载动画工具类
 */
public class AnimationUtil {

    /**
     * @param context 上下文
     * @param iv 对应image view
     * @param action 序列帧图片名称
     * @param length 动画帧数
     * @param duration 加载时间
     * @param oneShot 是否只显示一次
     */
    public static AnimationDrawable addAnimation(Context context,  ImageView iv, String action, int length, int duration, boolean oneShot) {
        //创建一个AnimationDrawable
        AnimationDrawable animationDrawable1 = new AnimationDrawable();
        //通过for循环添加每一帧动画
        for (int i = 0; i <length; i++) {
            Drawable frame =context. getResources().getDrawable(getDrawableResByReflect(action + i));
            //设定时长
            animationDrawable1.addFrame(frame, duration);
        }
        animationDrawable1.setOneShot(oneShot);
        //将动画设置到背景上
       // iv.setBackground(animationDrawable1);
        iv.setImageDrawable(animationDrawable1);

        //开启帧动画
        animationDrawable1.start();
        return animationDrawable1;
    }

    /**
     * 获取序列帧图片
     */
    public static int getDrawableResByReflect(String imgName) {
        Class drawable = R.drawable.class;
        Field field;
        int r_id;
        try {
            field = drawable.getField(imgName);
            r_id = field.getInt(field.getName());
        } catch (Exception e) {
            //替换为简单的默认图片
            r_id = R.drawable.circle_background;
        }
        return r_id;
    }



}
