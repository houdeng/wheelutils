package com.desaysv.lib_base.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: ChenHoudeng
 * @date: 2022-8-19
 * @describe: ListUtils的测试类
 */
public class ListUtilsTest {

    List<String> list;

    @Before
    public void setup(){
        list = new ArrayList<>();
        list.add("我是第一个");
    }

    @Test
    public void getSize() {
        Assert.assertEquals(1,ListUtils.getSize(list));
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(false,ListUtils.isEmpty(list));
//        Assert.assertEquals(false,ListUtils.isEmpty(null));
    }

    @Test
    public void join() {
        Assert.assertEquals("我是第一个",ListUtils.join(list));
    }

    @Test
    public void testJoin() {
        list.add("我是第二个");
        Assert.assertEquals("我是第一个;我是第二个",ListUtils.join(list,';'));
    }

    @Test
    public void testJoin1() {
        list.add("我是第二个");
        Assert.assertEquals("我是第一个$#我是第二个",ListUtils.join(list,"$#"));
    }

    @Test
    public void addDistinctEntry() {
        Assert.assertEquals(true,ListUtils.addDistinctEntry(list,"test"));
    }

    @Test
    public void addDistinctList() {
        List<String> entryList = new ArrayList<>();
        entryList.add("test");
        Assert.assertEquals(1,ListUtils.addDistinctList(list,entryList));
    }

    /**
     * 删除相同元素，并返回删除个数
     */
    @Test
    public void distinctList() {
        list.add("我是第一个");
        list.add("我是第一个");
//        ListUtils.addDistinctEntry(list,"我是第二个");
        Assert.assertEquals(2,ListUtils.distinctList(list));
    }

    @Test
    public void addListNotNullValue() {
        Assert.assertEquals(true,ListUtils.addListNotNullValue(list,"我是第二个"));
    }

    @Test
    public void invertList() {
        list.add("我是第二个");
        list =  ListUtils.invertList(list);
        Assert.assertEquals("[我是第二个, 我是第一个]",list.toString());
    }
}