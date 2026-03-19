package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mv {
    public static Class a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.toString();
            return null;
        }
    }

    public static Field a(Class cls, String str, boolean z) throws NoSuchFieldException {
        Field declaredField;
        Field field = null;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (z) {
                declaredField = cls.getField(str);
            } else {
                declaredField = cls.getDeclaredField(str);
            }
            field = declaredField;
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return field;
        }
    }

    /* compiled from: A */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static Method a(Class cls, String str, boolean z, Class... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        Method method = null;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (z) {
                declaredMethod = cls.getMethod(str, clsArr);
            } else {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            }
            method = declaredMethod;
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return method;
        }
    }

    public static Object a(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Field a(Class cls, String str) {
        return a(cls, str, true);
    }

    public static Method a(Class cls, String str, Class... clsArr) {
        return a(cls, str, true, clsArr);
    }

    public static Object a(Object obj, Method method, boolean z, Object... objArr) throws SecurityException {
        if (obj == null || method == null) {
            return null;
        }
        if (!z) {
            try {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return method.invoke(obj, objArr);
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        return a(obj, method, true, objArr);
    }

    public static boolean a(Class cls, String str, Object obj, boolean z, Object obj2) throws NoSuchFieldException, a {
        Field fieldA = a(cls, str, z);
        if (fieldA != null) {
            if (a(fieldA, obj, z, obj2)) {
                return true;
            }
            throw new a("Set field failed");
        }
        throw new a("Field is null");
    }

    public static boolean a(Field field, Object obj, boolean z, Object obj2) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        if (field != null && obj != null) {
            if (!z) {
                try {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            field.set(obj, obj2);
            return true;
        }
        return false;
    }

    public static boolean a(Field field, Object obj, Object obj2) {
        return a(field, obj, true, obj2);
    }
}
