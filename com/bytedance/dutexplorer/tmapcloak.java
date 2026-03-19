package com.bytedance.dutexplorer;

import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.zw.an;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tmapcloak {
    static int DexNum = 0;
    public static boolean loadLibSuccess = false;

    public static native byte bob_bytedance_call(int i, int i2, Object... objArr);

    public static native char cob_bytedance_call(int i, int i2, Object... objArr);

    public static native double dob_bytedance_call(int i, int i2, Object... objArr);

    public static native float fob_bytedance_call(int i, int i2, Object... objArr);

    public static native int iob_bytedance_call(int i, int i2, Object... objArr);

    public static native long job_bytedance_call(int i, int i2, Object... objArr);

    public static native Object obj_bytedance_call(int i, int i2, Object... objArr);

    public static native short sob_bytedance_call(int i, int i2, Object... objArr);

    public static native void voi_bytedance_call(int i, int i2, Object... objArr);

    public static native boolean zob_bytedance_call(int i, int i2, Object... objArr);

    static {
        try {
            if (DexNum > 0) {
                an.d("maparmor");
            }
            loadLibSuccess = true;
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public static void setaccessible(Constructor constructor) {
        constructor.setAccessible(true);
    }

    public static void setaccessible(Method method) {
        method.setAccessible(true);
    }

    public static void setaccessible(Field field) {
        field.setAccessible(true);
    }

    public static Object setaccessibleobj(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, InvocationTargetException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }
}
