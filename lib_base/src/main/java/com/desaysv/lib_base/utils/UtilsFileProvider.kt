package com.desaysv.lib_base.utils

import android.app.Application
import android.util.Log
import androidx.core.content.FileProvider

/**
 * 项目名称：Common
 * 类描述：
 * 创建人：ZhangQunSHan
 * 创建时间：2022-7-8
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
class UtilsFileProvider: FileProvider() {
    override fun onCreate(): Boolean {
        Log.e("testSPUtils", "onCreate: 来到这里了吗")
        ApplicationUtils.initApp(context?.applicationContext as Application)
        SPUtils.getInstance(context)
        return true
    }
}