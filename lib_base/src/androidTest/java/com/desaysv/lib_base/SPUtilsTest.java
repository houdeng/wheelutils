package com.desaysv.lib_base;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.desaysv.lib_base.utils.SPUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * 完成优先级：3级，需要依赖处理 暂时搁置
 */
@RunWith(AndroidJUnit4.class)
public class SPUtilsTest {

    SPUtils spUtils;

    @Before
    public void setup(){
        spUtils = SPUtils.getInstance(InstrumentationRegistry.getInstrumentation().getContext());
    }
    @After
    public void end(){
        spUtils.clear();
    }

    @Test
    public void putSerializableAndGetSerializable() {
        List<String> temp = new ArrayList<>();
        temp.add("第一串");
        temp.add("第二串");
        //转化保存
        spUtils.putSerializable("testSPUtils",temp);
        //取出判断
        List<String> temp1 = spUtils.getSerializable("testSPUtils");
        Assert.assertEquals(temp,temp1);
    }

    @Test
    public void getSerializable() {
    }
}