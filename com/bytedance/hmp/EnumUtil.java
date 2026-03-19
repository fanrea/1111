package com.bytedance.hmp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EnumUtil {
    public static Object fromValue(Class cls, Object v) throws NoSuchMethodException, SecurityException {
        Object[] enumConstants = cls.getEnumConstants();
        int length = enumConstants.length;
        int i = 0;
        while (true) {
            Method method = null;
            if (i >= length) {
                return null;
            }
            Object obj = enumConstants[i];
            try {
                method = obj.getClass().getMethod("getValue", new Class[0]);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            try {
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            if (method.invoke(obj, new Object[0]).equals(v)) {
                return obj;
            }
            i++;
        }
    }
}
