package com.baidu.enan.e.a.e;

import android.content.Context;
import com.baidu.enan.f.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            return b(context);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.enan.e.a.e.a.b(android.content.Context):java.lang.String");
    }

    private static String a(String str, String str2, Class... clsArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            if (declaredMethod != null) {
                if (Modifier.isNative(declaredMethod.getModifiers())) {
                    return "1";
                }
            }
        } catch (Throwable th) {
            b.a(th);
        }
        try {
            Field declaredField = Class.forName(b.a("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5YcG9zZWRIZWxwZXJz"), true, ClassLoader.getSystemClassLoader()).getDeclaredField(b.a("bG9hZENsYXNz"));
            declaredField.setAccessible(true);
            HashMap map = (HashMap) declaredField.get(null);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("#");
            stringBuffer.append(str2);
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                if (((String) it.next()).contains(stringBuffer.toString())) {
                    return "1";
                }
            }
            return "0";
        } catch (Throwable th2) {
            b.a(th2);
            return "0";
        }
    }
}
