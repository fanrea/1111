package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Apricot {
    public static HashMap<String, Class<?>> a = new HashMap<>();
    public static HashMap<Class<?>, HashMap<String, Field>> b = new HashMap<>();
    public static HashMap<Class<?>, HashMap<String, Method>> c = new HashMap<>();

    public static Object a(String str, String str2) {
        Class<?> cls;
        try {
            try {
                cls = a.get(str);
                if (cls == null) {
                    cls = Class.forName(str);
                }
                a.put(str, cls);
            } catch (Throwable th) {
                th.printStackTrace();
                cls = null;
            }
            return a(cls, str2, (Object) null);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static Object a(Class<?> cls, String str, Object obj) {
        HashMap<String, Field> map;
        Field declaredField;
        try {
            if (cls == null) {
                declaredField = null;
            } else {
                try {
                    map = b.get(cls);
                    if (map == null) {
                        map = new HashMap<>();
                        b.put(cls, map);
                    }
                    declaredField = map.get(str);
                    if (declaredField == null) {
                        declaredField = cls.getDeclaredField(str);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (declaredField == null) {
                    declaredField = null;
                } else {
                    declaredField.setAccessible(true);
                    map.put(str, declaredField);
                }
            }
            if (declaredField == null) {
                return null;
            }
            return declaredField.get(obj);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer(str);
                    if (clsArr != null) {
                        for (Class<?> cls2 : clsArr) {
                            stringBuffer.append("+");
                            stringBuffer.append(cls2.getName());
                        }
                    }
                    String string = stringBuffer.toString();
                    HashMap<String, Method> map = c.get(cls);
                    if (map == null) {
                        map = new HashMap<>();
                        c.put(cls, map);
                    }
                    Method declaredMethod = map.get(string);
                    if (declaredMethod == null) {
                        declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    }
                    if (declaredMethod == null) {
                        return null;
                    }
                    declaredMethod.setAccessible(true);
                    map.put(string, declaredMethod);
                    return declaredMethod;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
