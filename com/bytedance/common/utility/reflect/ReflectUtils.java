package com.bytedance.common.utility.reflect;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    private ReflectUtils() {
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        if (cls == null || StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            Logger.d(TAG, "thread id : " + Thread.currentThread().getName());
            return cls.getMethod(str, clsArr);
        } catch (Throwable th) {
            Logger.e(TAG, "exception in getMethod, pkg : " + cls.getName() + ", function : " + str + ", " + th.toString());
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static Object invokeMethod(Class<?> cls, String str, Object... objArr) {
        return invokeMethod(cls, str, null, null, objArr);
    }

    public static Object invokeMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr, Object... objArr2) {
        if (cls != null && !StringUtils.isEmpty(str)) {
            if (clsArr == null) {
                clsArr = new Class[0];
            }
            if (objArr == null) {
                objArr = new Object[0];
            }
            try {
                Method method = getMethod(cls, str, clsArr);
                if (method == null) {
                    return null;
                }
                method.setAccessible(true);
                if (objArr2 != null && objArr2.length > 0) {
                    return method.invoke(objArr2[0], objArr);
                }
                return method.invoke(null, objArr);
            } catch (Throwable th) {
                Logger.e(TAG, "exception in invokeMethod, pkg : " + cls.getName() + ", function : " + str + ", " + th.toString());
            }
        }
        return null;
    }

    public static Object getFiledValue(Object obj, Class<?> cls) {
        if (obj != null && cls != null) {
            try {
                Field[] declaredFields = obj.getClass().getDeclaredFields();
                for (int i = 0; i < declaredFields.length; i++) {
                    declaredFields[i].setAccessible(true);
                    if (declaredFields[i].getType().getName().equals(cls.getName())) {
                        return declaredFields[i].get(obj);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
