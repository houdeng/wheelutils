package com.desaysv.lib_base.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @auther: ChenHoudeng
 * @date: 2022-8-18
 * @describe: AsciiUtils的测试类
 */
public class AsciiUtilsTest {

    @Test
    public void byteArrayToHexString() {

        byte[] bytes = {10,20,30,50};//测试数组

        String s = AsciiUtils.byteArrayToHexString(bytes,"/");//调用方法返回结果

        Assert.assertEquals("0A/14/1E/32",s);//断言返回结果跟预期结果是否一致

    }
}