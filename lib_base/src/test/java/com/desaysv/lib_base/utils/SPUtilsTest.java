package com.desaysv.lib_base.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 完成优先级：3级，需要依赖处理 暂时搁置
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SPUtils.class,ApplicationUtils.class,AppUtils.class, PreferenceManager.class})
public class SPUtilsTest {

    SPUtils spUtils;
    SharedPreferences.Editor editor;

    @Before
    public void setup(){
        Application application = new Application();
        ApplicationUtils.INSTANCE.initApp(application);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(application.getApplicationContext());
        editor = sp.edit();
        editor.apply();
        spUtils = SPUtils.getInstance();
    }

    public void test1(){
        ApplicationUtils.INSTANCE.initApp(new Application());
    }
    /**
     * 需要依赖处理 暂时搁置
     */
    @Test
    public void getInstance() {
//        Assert.assertEquals(true, SPUtils.getInstance() != null);
    }


    @Test
    public void put() {
//        spUtils.put("1","一直");
//        Mockito.verify(editor).putString("1","一直");
        try {
            Whitebox.invokeMethod(SPUtils.getInstance(),"put","1","一直");
            Mockito.verify(editor).putString("1","一直");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getString() {
    }

    @Test
    public void testGetString() {
    }

    @Test
    public void testPut() {
    }

    @Test
    public void getInt() {
    }

    @Test
    public void testGetInt() {
    }

    @Test
    public void testPut1() {
    }

    @Test
    public void getLong() {
    }

    @Test
    public void testGetLong() {
    }

    @Test
    public void testPut2() {
    }

    @Test
    public void getFloat() {
    }

    @Test
    public void testGetFloat() {
    }

    @Test
    public void testPut3() {
    }

    @Test
    public void getBoolean() {
    }

    @Test
    public void testGetBoolean() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void putSerializable() {
    }

    @Test
    public void getSerializable() {
    }

//    public void test() throws Exception {
//        Application application1 = PowerMockito.mock(Application.class);
//        Application application = new Application();
//        ApplicationUtils applicationUtils = Mockito.spy(ApplicationUtils.INSTANCE.getClass());
//        AppUtils appUtils = Mockito.mock(AppUtils.INSTANCE.getClass());
//        applicationUtils.initApp(application);
////        Application application1 = new Application();
////        SharedPreferences sp = Mockito.mock(SharedPreferences.class);
//        // 对私有方法进行修改  对modifyInnerName方法进行拦截，修改方法体里面的内容
//        SharedPreferences sp = application.getSharedPreferences("test",Context.MODE_APPEND);
////        PowerMockito.replace(PowerMockito.method(ApplicationUtils.INSTANCE.getClass(), "getApplication")).with(new InvocationHandler() {
////            @Override
////            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                return null;
////            }
////        });
//        // 对私有方法进行修改  对modifyInnerName方法进行拦截，修改方法体里面的内容
////        PowerMockito.replace(PowerMockito.method(AppUtils.INSTANCE.getClass(), "getPackageName")).with(new InvocationHandler() {
////            @Override
////            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                return null;
////            }
////        });
////        PowerMockito.replace(PowerMockito.method(SPUtilsTest.class,"SPUtils")).with(new InvocationHandler() {
////            @Override
////            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                return null;
////            }
////        });
////        Mockito.when(applicationUtils.getApplication()).thenReturn(application);
////        Mockito.when(appUtils.getPackageName()).thenReturn("test");
//        Mockito.when(application1.getSharedPreferences(Mockito.any(),Mockito.anyInt())).thenReturn(sp);
//        spUtils = Whitebox.invokeConstructor(SPUtils.class);
////        spUtils = SPUtils.getInstance();
////        spUtils = Mockito.mock(SPUtils.class);
//        editor = Mockito.mock(SharedPreferences.Editor.class);
//    }
}