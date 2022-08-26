package com.desaysv.lib_base.utils

import android.content.Context
import android.util.TypedValue

/**
 * 项目名称：Common
 * 类描述：转换工具 DP、SP、PX之间转换
 * 创建人：ZhangQunSHan
 * 创建时间：2022-7-8
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
object DensityUtils {
    /**
     * dp转px
     *
     * @param cx
     * @param dpVal
     * @return
     */
    fun dp2px(cx: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpVal, cx.resources.displayMetrics
        ).toInt()
    }

    /**
     * sp转px
     *
     * @param cx
     * @param spVal
     * @return
     */
    fun sp2px(cx: Context, spVal: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            spVal, cx.resources.displayMetrics
        ).toInt()
    }

    /**
     * px转dp
     *
     * @param cx
     * @param pxVal
     * @return
     */
    fun px2dp(cx: Context, pxVal: Float): Float {
        val scale = cx.resources.displayMetrics.density
        return pxVal / scale
    }

    /**
     * px转sp
     *
     * @param cx
     * @param pxVal
     * @return
     */
    fun px2sp(cx: Context, pxVal: Float): Float {
        return pxVal / cx.resources.displayMetrics.scaledDensity
    }
}