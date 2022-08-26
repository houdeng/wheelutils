package com.desaysv.lib_base;

import android.app.Activity;
import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.desaysv.lib_base.utils.NetworkUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @auther: ChenHoudeng
 * @date: 2022-8-18
 * @describe: NetworkUtils的测试类
 */

@RunWith(AndroidJUnit4.class)
public class NetworkUtilsTest {

    Context context;

    @Before
    public void setup(){
        context = InstrumentationRegistry.getInstrumentation().getContext();
    }

    @Test
    public void networkIsConnect() {
        //判断网络状态
        Boolean boo = NetworkUtils.networkIsConnect(context);
        Assert.assertEquals(true,boo);
    }

    @Test
    public void isNetworkIsWifi() {
        //关闭WiFi
        NetworkUtils.setWifiEnabled(context,false);

        //判断网络状态
        Boolean boo = NetworkUtils.isNetworkIsWifi(context);
        Assert.assertEquals(true,boo);
    }

    @Test
    public void setWifiEnabled() {
        //打开WiFi网络
        NetworkUtils.setWifiEnabled(context,true);
        //判断WiFi是否打开
        Boolean boo = NetworkUtils.isNetworkIsWifi(context);
        Assert.assertEquals(true,boo);
    }

    /**
     * 涉及到activity 暂时无法测试
     */
    @Test
    public void openSetting() {
        Activity activity = new Activity();
        NetworkUtils.openSetting(activity);
    }

    @Test
    public void getIPAddress() {
        String ip = NetworkUtils.getIPAddress(context);
        Assert.assertEquals("127.0.0.1",ip);
    }

    @Test
    public void getNetworkType() {
        String type = NetworkUtils.getNetworkType(context);
        Assert.assertEquals("WIFI",type);
    }
}