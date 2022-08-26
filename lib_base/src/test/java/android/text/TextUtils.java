package android.text;

import java.util.Iterator;

/**
 * @auther: ChenHoudeng
 * @date: 2022-8-18
 * @describe: 由于junit运行在jvm上，而jdk没有android源码，所以TextUtils这些在android sdk中的类，
 *            运行junit时就引用不上了。所以需要在这边自行添加
 */
public class TextUtils {

    public static boolean isEmpty(CharSequence str){
        if (str == null || str.equals("")){
            return true;
        }
        return false;
    }

    public static String join(CharSequence delimiter, Iterable tokens) {
        final Iterator<?> it = tokens.iterator();
        if (!it.hasNext()) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(delimiter);
            sb.append(it.next());
        }
        return sb.toString();
    }
}
