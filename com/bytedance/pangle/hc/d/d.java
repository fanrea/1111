package com.bytedance.pangle.hc.d;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static Map<String, Field> d = new HashMap();
    private static Map<String, Method> hc = new HashMap();
    private static Map<String, Constructor> b = new HashMap();
    private static Map<String, Class> c = new HashMap();

    static {
        try {
            FieldUtils.writeField(hc.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    public static Field d(Class<?> cls, String str) {
        Field field;
        String strHc = hc(cls, str);
        synchronized (d) {
            field = d.get(strHc);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field fieldD = hc.d(cls, str);
            if (fieldD != null) {
                synchronized (d) {
                    d.put(strHc, fieldD);
                }
            }
            return fieldD;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Method d(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strHc = hc(cls, str, clsArr);
        synchronized (hc) {
            method = hc.get(strHc);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method methodD = hc.d(cls, str, clsArr);
            if (methodD != null) {
                synchronized (hc) {
                    hc.put(strHc, methodD);
                }
            }
            return methodD;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Constructor d(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strHc = hc(cls, "clinit", clsArr);
        synchronized (b) {
            constructor = b.get(strHc);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructorD = hc.d(cls, clsArr);
            if (constructorD != null) {
                synchronized (b) {
                    b.put(strHc, constructorD);
                }
            }
            return constructorD;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    private static String hc(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    private static String hc(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName()).append("#").append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName()).append("#");
            }
        } else {
            sb.append(Void.class.getName());
        }
        return sb.toString();
    }
}
