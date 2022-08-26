package com.desaysv.lib_base.utils;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LoggerTest {

    logger loggerSpy;

    @Before
    public void setup(){
        loggerSpy = Mockito.spy(logger.INSTANCE.getClass());
        loggerSpy.setTag("testTag");
    }

    @Test
    public void v(){
        loggerSpy.v("test");
        //确认是否调用成功调用了里面的方法
        Mockito.verify(loggerSpy).v(Mockito.any(),Mockito.any());
    }

    @Test
    public void d(){
        loggerSpy.d("test");
        //确认是否调用成功调用了里面的方法
        Mockito.verify(loggerSpy).d(Mockito.any(),Mockito.any());
    }

    @Test
    public void i(){
        loggerSpy.i("test");
        //确认是否调用成功调用了里面的方法
        Mockito.verify(loggerSpy).i(Mockito.any(),Mockito.any());
    }

    @Test
    public void e(){
        loggerSpy.e("test");
        //确认是否调用成功调用了里面的方法
        Mockito.verify(loggerSpy).e(Mockito.any(),Mockito.any());
    }

    @Test
    public void a(){
        loggerSpy.a("test");
        //确认是否调用成功调用了里面的方法
        Mockito.verify(loggerSpy).a(Mockito.any(),Mockito.any());
    }

}
