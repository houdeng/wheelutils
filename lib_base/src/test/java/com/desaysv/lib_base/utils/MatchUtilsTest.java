package com.desaysv.lib_base.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @auther: ChenHoudeng
 * @date: 2022-8-18
 * @describe: MatchUtils的测试类
 */
public class MatchUtilsTest {

    @Test
    public void isPhone() {
        String test = "12345678901";//模拟手机号
//        Assert.assertTrue(MatchUtils.isPhone(test));//断言返回值
        Assert.assertEquals(true,MatchUtils.isPhone(test));//控制台报告信息相对直观
    }

    @Test
    public void isMobileAndTelephone() {
//        String test = "13619191049";//模拟手机号
        String test = "0759-4485924";//模拟电话
//        Assert.assertTrue(MatchUtils.isMobileAndTelephone(test));//断言返回值
        Assert.assertEquals(true,MatchUtils.isMobileAndTelephone(test));//控制台报告信息相对直观
    }

    @Test
    public void isEmails() {
        String test = "Houdeng.Chen@desaysv.com";//模拟邮箱
        Assert.assertEquals(true,MatchUtils.isEmails(test));
    }

    @Test
    public void isPassWord() {
        String string = "123456qq";
//        String string = "中文";
        Assert.assertEquals(true,MatchUtils.isPassWord(string));
    }

    @Test
    public void isLoginName() {
        String s = "snjvnsvn";
        Assert.assertEquals(true,MatchUtils.isLoginName(s));
    }

    @Test
    public void place() {
        String test = "13619191049";//模拟手机号
        Assert.assertEquals("136****1049",MatchUtils.place(test));
    }

    /**
     * 模糊判断身份证
     */
    @Test
    public void is18ByteIdCard1() {
        String s = "15042919840709121x";//测试身份证是百度获取的真实身份证
        Assert.assertEquals(true,MatchUtils.is18ByteIdCard1(s));
    }

    /**
     * 精准判断身份证
     */
    @Test
    public void is18ByteIdCardComplex() {
        String s = "15042919840709121x";
        Assert.assertEquals(true,MatchUtils.is18ByteIdCardComplex(s));
    }

    @Test
    public void isChineseStr() {
        String s = "我全是中文";
        String s1 = "我们不全是Chinese";
        Assert.assertEquals(true,MatchUtils.isChineseStr(s));
    }

    /**
     * 精准判断身份证
     */
    @Test
    public void is18ByteIdCard() {
        String s = "15042919840709121X";
        Assert.assertEquals(true,MatchUtils.is18ByteIdCard(s));
    }

    @Test
    public void getPlateNumber() {
        String s = "鲁NE23A1";
        Assert.assertEquals("鲁N*23A1",MatchUtils.getPlateNumber(s));
    }

    @Test
    public void getIdCard() {
//        String s = "150429198407091210";
        String s = "15042919840709121X";
        Assert.assertEquals("1504****121X",MatchUtils.getIdCard(s));
    }
}