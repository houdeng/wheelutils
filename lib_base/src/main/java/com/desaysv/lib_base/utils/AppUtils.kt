package com.desaysv.lib_base.utils

import android.app.ActivityManager
import android.content.Context
import android.os.Process

/**
 * 项目名称：Common
 * 类描述：APP相关的一些工具
 * 创建人：ZhangQunSHan
 * 创建时间：2022-7-8
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
object AppUtils{
    /**
     * 包名判断是否为主进程
     *
     * @param
     * @return
     */
    fun isMainProcess(): Boolean {
        return getPackageName() == getCurrentProcessName()
    }

    /**
     * 获取当前应用包名
     * @param context
     * @return
     */
    fun getPackageName(): String? {
        return ApplicationUtils.getApplication().packageName
    }

    /**
     * 获取当前进程名
     */
    fun getCurrentProcessName(): String? {
        val pid = Process.myPid()
        val manager = ApplicationUtils.getApplication().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (process in manager.runningAppProcesses) {
            if (process.pid == pid) {
                return process.processName
            }
        }
        return null
    }
    /**
     * 拿到当前类名 方法名 和 调用的行数
     */
    fun getStackTraceInfo(): StackTraceInfo? {
        val stackTrace = Thread.currentThread().stackTrace
        for (stackTraceElement in stackTrace) {
            getPackageName()?.let { name ->
                if (stackTraceElement.className.startsWith(name)) {
                    val className = stackTraceElement.fileName
                    val methodName = stackTraceElement.methodName
                    val lineNun = stackTraceElement.lineNumber
                    val declaringClass = stackTraceElement.className
                    return StackTraceInfo(className, methodName, lineNun, declaringClass)
                }
            }
        }
        return null
    }
}
data class StackTraceInfo(
    val className: String,
    val methodName: String,
    val lineNum: Int,
    val declaringClass: String
) {
    override fun toString(): String {
        return "StackTraceInfo(className='$className', methodName='$methodName', lineNum=$lineNum, declaringClass='$declaringClass')"
    }
}