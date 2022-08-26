package com.desaysv.app_test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.desaysv.lib_base.utils.AppUtils;
import com.desaysv.lib_base.utils.ApplicationUtils;
import com.desaysv.lib_base.utils.SPUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//@RunWith(RobolectricTestRunner.class)
@RunWith(PowerMockRunner.class)
@Config(application = Application.class)
@PowerMockIgnore({ "org.mockito.*", "org.robolectric.*", "android.*" })
@PrepareForTest({ApplicationUtils.class})
public class SPUtilsActivityTest{

    @Test
    public void clickingButton_shouldChangeResultsViewText() {
//        Activity activity = Robolectric.setupActivity(SPUtilsActivity.class);
//
//        TextView results = (TextView) activity.findViewById(R.id.results_text_view);
//
//        assertThat(results.getText().toString(), equalTo("Testing Android Rocks!"));
    }

    @Test
    public void put(){
    }

    @Test
    public void setup() throws Exception {
        Application application = PowerMockito.mock(Application.class);
        ApplicationUtils applicationUtils = Mockito.mock(ApplicationUtils.INSTANCE.getClass());
        AppUtils appUtils = Mockito.mock(AppUtils.INSTANCE.getClass());
//        SharedPreferences sp = Mockito.mock(SharedPreferences.class);
//        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(new Application());
        // 对私有方法进行修改  对modifyInnerName方法进行拦截，修改方法体里面的内容
        PowerMockito.replace(PowerMockito.method(ApplicationUtils.INSTANCE.getClass(), "getApplication")).with(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        // 对私有方法进行修改  对modifyInnerName方法进行拦截，修改方法体里面的内容
        PowerMockito.replace(PowerMockito.method(AppUtils.INSTANCE.getClass(), "getPackageName")).with(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        Mockito.when(applicationUtils.getApplication()).thenReturn(new Application());
        Mockito.when(appUtils.getPackageName()).thenReturn("test");
//        Mockito.when(application.getSharedPreferences(Mockito.any(),Mockito.anyInt())).thenReturn(sp);
        SPUtils spUtils = Whitebox.invokeConstructor(SPUtils.class);
        SharedPreferences.Editor editor = Mockito.mock(SharedPreferences.Editor.class);
    }

}