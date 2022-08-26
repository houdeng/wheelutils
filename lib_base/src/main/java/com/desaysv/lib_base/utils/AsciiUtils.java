package com.desaysv.lib_base.utils;

/**
 * 项目名称：Common
 * 类描述：进制转换类工具类
 * 创建人：ZhangQunSHan
 * 创建时间：2022-7-8
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
public class AsciiUtils {
    /**
     * 转换字节数组为16进制字串
     *
     * @param bytes     字节数组
     * @param separator 间隔符
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] bytes, String separator) {
        StringBuilder resultSb = new StringBuilder();
        String tmpStr;
        for (int i = 0; i < bytes.length; i++) {
            tmpStr = Integer.toHexString(0xFF & bytes[i]);
            resultSb.append(tmpStr.length() < 2 ? "0" + tmpStr.toUpperCase() : tmpStr.toUpperCase());
            // 间隔符的添加
            if (i < bytes.length - 1) {
                resultSb.append(separator);
            }
        }
        return resultSb.toString();
    }

}
