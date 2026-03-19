package com.baidu.mobads.container.a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj.getClass(), obj, str, a(objArr), objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Class<?>[] a(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return clsArr;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (!a(cls, str, clsArr)) {
                return null;
            }
            return b(cls, str, clsArr).invoke(obj, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> clsA = a(str, classLoader);
            if (clsA == null || (declaredMethod = clsA.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class clsA = a(str);
            if (clsA == null || (declaredMethod = clsA.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader == null) {
            return null;
        }
        try {
            return classLoader.loadClass(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(Class<?> cls, String str, Object... objArr) {
        try {
            return a(cls, (Object) null, str, a(objArr), objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(Class<?> cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr).invoke(null, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(String str, InvocationHandler invocationHandler) {
        Class clsA = a(str);
        if (clsA != null) {
            return Proxy.newProxyInstance(clsA.getClassLoader(), new Class[]{clsA}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class clsA = a(str);
            if (clsA == null) {
                return null;
            }
            return clsA.getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(ClassLoader classLoader, String str, String str2) {
        try {
            return a(Class.forName(str, true, classLoader), str2);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(Class cls, String str) {
        Field fieldA = com.baidu.mobads.container.f.a(cls, str);
        if (fieldA == null) {
            return null;
        }
        fieldA.setAccessible(true);
        try {
            return fieldA.get(cls);
        } catch (Throwable th) {
            return null;
        }
    }
}
