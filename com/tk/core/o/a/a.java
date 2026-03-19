package com.tk.core.o.a;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private static final Map<Class<?>, Class<?>> ajJ;

    /* renamed from: com.tk.core.o.a.a$a, reason: collision with other inner class name */
    public static class C0827a<T> {
        public final Class<? extends T> ajK;
        public final T obj;
    }

    static {
        HashMap map = new HashMap();
        ajJ = map;
        map.put(Boolean.class, Boolean.TYPE);
        ajJ.put(Byte.class, Byte.TYPE);
        ajJ.put(Character.class, Character.TYPE);
        ajJ.put(Short.class, Short.TYPE);
        ajJ.put(Integer.class, Integer.TYPE);
        ajJ.put(Float.class, Float.TYPE);
        ajJ.put(Long.class, Long.TYPE);
        ajJ.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map2 = ajJ;
        Class<?> cls = Boolean.TYPE;
        map2.put(cls, cls);
        Map<Class<?>, Class<?>> map3 = ajJ;
        Class<?> cls2 = Byte.TYPE;
        map3.put(cls2, cls2);
        Map<Class<?>, Class<?>> map4 = ajJ;
        Class<?> cls3 = Character.TYPE;
        map4.put(cls3, cls3);
        Map<Class<?>, Class<?>> map5 = ajJ;
        Class<?> cls4 = Short.TYPE;
        map5.put(cls4, cls4);
        Map<Class<?>, Class<?>> map6 = ajJ;
        Class<?> cls5 = Integer.TYPE;
        map6.put(cls5, cls5);
        Map<Class<?>, Class<?>> map7 = ajJ;
        Class<?> cls6 = Float.TYPE;
        map7.put(cls6, cls6);
        Map<Class<?>, Class<?>> map8 = ajJ;
        Class<?> cls7 = Long.TYPE;
        map8.put(cls7, cls7);
        Map<Class<?>, Class<?>> map9 = ajJ;
        Class<?> cls8 = Double.TYPE;
        map9.put(cls8, cls8);
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) c(obj, str);
        } catch (Throwable th) {
            throw d(th);
        }
    }

    private static <T> T c(Object obj, String str) throws NoSuchFieldException {
        Class<?> superclass = obj.getClass();
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        return (T) declaredField.get(obj);
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) b(obj, str, objArr);
        } catch (Throwable th) {
            throw d(th);
        }
    }

    private static <T> T b(Object obj, String str, Object... objArr) {
        return (T) a(obj.getClass(), str, j(objArr)).invoke(obj, k(objArr));
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (true) {
            Method methodA = a(cls.getDeclaredMethods(), str, clsArr);
            if (methodA == null) {
                if (cls.getSuperclass() != null) {
                    cls = cls.getSuperclass();
                } else {
                    throw new NoSuchMethodException();
                }
            } else {
                methodA.setAccessible(true);
                return methodA;
            }
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!ajJ.containsKey(clsArr[i]) || !ajJ.get(clsArr[i]).equals(ajJ.get(clsArr2[i])))) {
                return false;
            }
        }
        return true;
    }

    private static Class<?>[] j(Object... objArr) {
        Class<?> cls;
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof C0827a)) {
                cls = ((C0827a) obj).ajK;
            } else {
                cls = obj == null ? null : obj.getClass();
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    private static Object[] k(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof C0827a)) {
                objArr2[i] = ((C0827a) obj).obj;
            } else {
                objArr2[i] = obj;
            }
        }
        return objArr2;
    }

    private static RuntimeException d(Throwable th) {
        if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        }
        return new RuntimeException(th);
    }
}
