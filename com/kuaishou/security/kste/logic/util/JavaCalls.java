package com.kuaishou.security.kste.logic.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class JavaCalls {
    private static final Map PRIMITIVE_MAP;

    public class JavaParam {
        public final Class clazz;
        public final Object obj;

        public JavaParam(Class cls, Object obj) {
            this.clazz = cls;
            this.obj = obj;
        }
    }

    static {
        HashMap map = new HashMap();
        PRIMITIVE_MAP = map;
        Class cls = Boolean.TYPE;
        map.put(Boolean.class, cls);
        map.put(Byte.class, Byte.TYPE);
        map.put(Character.class, Character.TYPE);
        map.put(Short.class, Short.TYPE);
        Class cls2 = Integer.TYPE;
        map.put(Integer.class, cls2);
        Class cls3 = Float.TYPE;
        map.put(Float.class, cls3);
        Class cls4 = Long.TYPE;
        map.put(Long.class, cls4);
        map.put(Double.class, Double.TYPE);
        map.put(cls, cls);
        Class cls5 = Byte.TYPE;
        map.put(cls5, cls5);
        Class cls6 = Character.TYPE;
        map.put(cls6, cls6);
        Class cls7 = Short.TYPE;
        map.put(cls7, cls7);
        map.put(cls2, cls2);
        map.put(cls3, cls3);
        map.put(cls4, cls4);
        Class cls8 = Double.TYPE;
        map.put(cls8, cls8);
    }

    public static Object callMethod(Object obj, String str, Object... objArr) {
        try {
            return callMethodOrThrow(obj, str, objArr);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    private static Object callMethodOrThrow(Object obj, String str, Object... objArr) {
        return getDeclaredMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    public static Object callStaticMethod(String str, String str2, Object... objArr) {
        try {
            return callStaticMethodOrThrow(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    private static Object callStaticMethodOrThrow(Class cls, String str, Object... objArr) {
        return getDeclaredMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static Object callStaticMethodOrThrow(String str, String str2, Object... objArr) {
        return callStaticMethodOrThrow(Class.forName(str), str2, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean compareClassLists(Class[] clsArr, Class[] clsArr2) {
        if (clsArr == 0) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!clsArr[i].isAssignableFrom(clsArr2[i])) {
                Map map = PRIMITIVE_MAP;
                if (!map.containsKey(clsArr[i]) || !((Class) map.get(clsArr[i])).equals(map.get(clsArr2[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Method findMethodByName(Method[] methodArr, String str, Class[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && compareClassLists(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static Method getDeclaredMethod(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        while (true) {
            Method methodFindMethodByName = findMethodByName(cls.getDeclaredMethods(), str, clsArr);
            if (methodFindMethodByName != null) {
                methodFindMethodByName.setAccessible(true);
                return methodFindMethodByName;
            }
            if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            }
            cls = cls.getSuperclass();
        }
    }

    private static Object getDefaultValue(Class cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    public static Object getField(Object obj, String str) {
        try {
            return getFieldOrThrow(obj, str);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    private static Object getFieldOrThrow(Object obj, String str) throws NoSuchFieldException {
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
        return declaredField.get(obj);
    }

    private static Class[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof JavaParam)) {
                clsArr[i] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i] = ((JavaParam) obj).clazz;
            }
        }
        return clsArr;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof JavaParam)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((JavaParam) obj).obj;
            }
        }
        return objArr2;
    }

    public static Object getStaticField(Class cls, String str) {
        try {
            return getStaticFieldOrThrow(cls, str);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    public static Object getStaticField(String str, String str2) {
        try {
            return getStaticFieldOrThrow(str, str2);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    private static Object getStaticFieldOrThrow(Class cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(null);
    }

    private static Object getStaticFieldOrThrow(String str, String str2) {
        return getStaticFieldOrThrow(Class.forName(str), str2);
    }

    public static Object newEmptyInstance(Class cls) {
        try {
            return newEmptyInstanceOrThrow(cls);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    public static Object newEmptyInstanceOrThrow(Class cls) throws SecurityException {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = getDefaultValue(parameterTypes[i]);
        }
        return constructor.newInstance(objArr);
    }

    public static Object newInstance(Class cls, Object... objArr) {
        try {
            return newInstanceOrThrow(cls, objArr);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    public static Object newInstance(String str, Object... objArr) {
        try {
            return newInstanceOrThrow(str, objArr);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    public static Object newInstanceOrThrow(Class cls, Object... objArr) {
        return cls.getConstructor(getParameterTypes(objArr)).newInstance(getParameters(objArr));
    }

    public static Object newInstanceOrThrow(String str, Object... objArr) {
        return newInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    public static void setField(Object obj, String str, Object obj2) {
        try {
            setFieldOrThrow(obj, str, obj2);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    private static void setFieldOrThrow(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Class<?> superclass = obj.getClass();
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void setStaticField(Class cls, String str, Object obj) {
        try {
            setStaticFieldOrThrow(cls, str, obj);
        } catch (Throwable th) {
            throw wrapToRuntime(th);
        }
    }

    private static void setStaticFieldOrThrow(Class cls, String str, Object obj) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Class superclass = cls;
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        declaredField.set(null, obj);
    }

    private static RuntimeException wrapToRuntime(Throwable th) {
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }
}
