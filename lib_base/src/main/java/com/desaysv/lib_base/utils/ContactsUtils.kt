package com.desaysv.lib_base.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract

/**
 * 项目名称：Common
 * 类描述：联系人工具类
 * 创建人：ZhangQunSHan
 * 创建时间：2022-7-8
 * 修改人：ZhangQunSHan
 * 修改备注：
 */
class ContactsUtils {
    /**
     * 拨打电话（直接拨打电话）
     * @param phone 电话号码
     */
    fun callPhone(context: Context, phone: String) {
        val intent = Intent(Intent.ACTION_CALL)
        val data = Uri.parse("tel:$phone")
        intent.data = data
        context.startActivity(intent)
    }


    /**
     * 拨打电话（跳转到拨号界面，用户手动点击拨打）
     * @param phone 电话号码
     */
    fun dialPhone(context: Context, phone: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        val data = Uri.parse("tel:$phone")
        intent.data = data
        context.startActivity(intent)
    }

    /**
     * 跳转通讯录
     * @param activity
     * @param requestCode
     */
    fun skipContact(activity: Activity, requestCode: Int) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
        activity.startActivityForResult(intent, requestCode)
    }

    /**
     *
     */
    @SuppressLint("Range")
    fun getContact(context: Context, data: Uri) {
        val cursor: Cursor? = context.contentResolver.query(
            data, arrayOf(
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.Contacts.DISPLAY_NAME
            ),
            null, null, null
        )
        if (cursor != null) {
            try {
                while (cursor!!.moveToNext()) {
                    //取出该条数据的联系人姓名
                    var name =
                        cursor!!.getString(cursor!!.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    //适配有些手机会有空格
                    name = name.replace(" ", "")
                    //取出该条数据的联系人的手机号
                    var phone =
                        cursor!!.getString(cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    //适配有些手机有空格
                    phone = phone.replace(" ", "")
                    //适配有些手机-
                    phone = phone.replace("-", "")
                    //有些手机会填写超过11位的手机号码，在此截取掉
                    val phoneSize = phone.length
                    if (phoneSize > 11) {
                        phone = phone.substring(0, 11)
                    }
                }
            } finally {
                cursor!!.close()
            }
        }
    }
}