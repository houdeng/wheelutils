package com.desaysv.lib_base.utils

import android.text.TextUtils
import android.util.Log

/**
 * 项目名称：Common
 * 类描述：
 * 创建人：ZhangQunSHan
 * 创建时间：2022-8-8
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
object logger {
    private var tag: String? = null

    /**
     * TAG设置 调用此方法需要在每个类调用
     */
    fun setTag(tag: String) {
        this.tag = tag
    }

    fun v(msg: String) {
        val tagNew = if (!TextUtils.isEmpty(tag)) {
            this.tag
        } else {
            String.format("[%s]", AppUtils.getStackTraceInfo()?.className)
        }
        v(tagNew, msg)
    }

    fun d(msg: String) {
        val tagNew = if (!TextUtils.isEmpty(tag)) {
            this.tag
        } else {
            String.format("[%s]", AppUtils.getStackTraceInfo()?.className)
        }
        d(tagNew, msg)
    }

    fun i(msg: String) {
        val tagNew = if (!TextUtils.isEmpty(tag)) {
            this.tag
        } else {
            String.format("[%s]", AppUtils.getStackTraceInfo()?.className)
        }
        i(tagNew, msg)
    }

    fun w(msg: String) {
        val tagNew = if (!TextUtils.isEmpty(tag)) {
            this.tag
        } else {
            String.format("[%s]", AppUtils.getStackTraceInfo()?.className)
        }
        w(tagNew, msg)
    }

    fun e(msg: String) {
        val tagNew = if (!TextUtils.isEmpty(tag)) {
            this.tag
        } else {
            String.format("[%s]", AppUtils.getStackTraceInfo()?.className)
        }
        e(tagNew, msg)
    }

    fun a(msg: String) {
        val tagNew = if (!TextUtils.isEmpty(tag)) {
            this.tag
        } else {
            String.format("[%s]", AppUtils.getStackTraceInfo()?.className)
        }

        a(tagNew, msg)
    }

    fun v(tag: String?, msg: String) {
        Log.println(Log.VERBOSE, tag, msg)
    }

    fun d(tag: String?, msg: String) {
        Log.println(Log.DEBUG, tag, msg)
    }

    fun i(tag: String?, msg: String) {
        Log.println(Log.INFO, tag, msg)
    }

    fun w(tag: String?, msg: String) {
        Log.println(Log.WARN, tag, msg)
    }

    fun e(tag: String?, msg: String) {
        Log.println(Log.ERROR, tag, msg)
    }

    fun a(tag: String?, msg: String) {
        Log.println(Log.ASSERT, tag, msg)
    }
}