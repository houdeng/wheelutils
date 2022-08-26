package com.desaysv.lib_base.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.desaysv.lib_base.utils.manager.AppManager

/**
 * 项目名称：Common
 * 类描述：初始化得到   Application Context
 * 创建人：ZhangQunSHan
 * 创建时间：2022-7-8
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
object ApplicationUtils {
    private var mApplication: Application?=null
    fun initApp(application: Application){
        if (application==null){
            Log.e("Utils", "app is null.")
            return
        }
        mApplication=application
        if (mApplication!=null){
            setApplication(application)
        }
    }
    fun getApplication(): Application {
        if (mApplication==null){
            return  throw NullPointerException("Application is null")
        }
       return mApplication as Application
    }

    //监听每个Activity的生命周期
    private fun setApplication(application: Application) {
        var foregroundActivities:Int = 0
        var isChangingConfiguration:Boolean = false
        //注册监听每个activity的生命周期,便于堆栈式管理
        application.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                AppManager.instance.addActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                foregroundActivities++
                isChangingConfiguration = false
            }
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {
                foregroundActivities--
                isChangingConfiguration = activity.isChangingConfigurations
            }
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {
                AppManager.instance.removeActivity(activity)
            }
        })
    }
}