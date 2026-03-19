package com.kwad.sdk.api.loader;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ApiReflect {
    private final Object aBm;
    private final Class<?> brU;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException() {
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    static class a {
        private static final Method brV;
        private static final Method brW;
        private static final Method brX;
        private static final Method brY;
        private static final Method brZ;
        private static final Method bsa;
        private static final Method bsb;
        private static final Method bsc;
        private static final Method bsd;
        private static final Method bse;
        private static final Method bsf;
        private static final Method bsg;
        private static final Method bsh;
        private static final Method bsi;

        static {
            try {
                brV = Class.class.getDeclaredMethod("forName", String.class);
                brW = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                brX = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                brY = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                brZ = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                bsa = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                bsb = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                bsc = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                bsd = Class.class.getDeclaredMethod("getField", String.class);
                bse = Class.class.getDeclaredMethod("getFields", new Class[0]);
                bsf = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                bsg = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                bsh = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                bsi = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }

        static Class forName(String str) throws ClassNotFoundException {
            try {
                return (Class) brV.invoke(null, str);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }

        static Field a(Class cls, String str) throws NoSuchFieldException {
            try {
                return (Field) brX.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        static Field b(Class cls, String str) throws NoSuchFieldException {
            try {
                return (Field) bsd.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        static Method c(Class cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Method) brZ.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Method d(Class cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Method) bsf.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Method[] d(Class cls) {
            try {
                return (Method[]) bsa.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Method[] e(Class cls) {
            try {
                return (Method[]) bsg.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Constructor a(Class cls, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Constructor) bsb.invoke(cls, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Constructor[] f(Class cls) {
            try {
                return (Constructor[]) bsc.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }
    }

    public static ApiReflect dE(String str) {
        return b(forName(str));
    }

    public static ApiReflect b(Class<?> cls) {
        return new ApiReflect(cls);
    }

    public static ApiReflect m(Object obj) {
        return new ApiReflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static ApiReflect a(Class<?> cls, Object obj) {
        return new ApiReflect(cls, obj);
    }

    private static <T extends AccessibleObject> T a(T t) throws SecurityException {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private ApiReflect(Class<?> cls) {
        this(cls, cls);
    }

    private ApiReflect(Class<?> cls, Object obj) {
        this.brU = cls;
        this.aBm = obj;
    }

    public final <T> T get() {
        return (T) this.aBm;
    }

    public final ApiReflect b(String str, Object obj) throws IllegalAccessException, IllegalArgumentException {
        try {
            Field fieldDG = dG(str);
            if ((fieldDG.getModifiers() & 16) == 16) {
                try {
                    Field fieldA = a.a(Field.class, "modifiers");
                    fieldA.setAccessible(true);
                    fieldA.setInt(fieldDG, fieldDG.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            fieldDG.set(this.aBm, n(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public final <T> T get(String str) {
        return (T) dF(str).get();
    }

    private ApiReflect dF(String str) {
        try {
            Field fieldDG = dG(str);
            return a(fieldDG.getType(), fieldDG.get(this.aBm));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field dG(String str) {
        Class<?> clsType = type();
        try {
            return (Field) a(a.b(clsType, str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) a(a.a(clsType, str));
                } catch (NoSuchFieldException unused) {
                    clsType = clsType.getSuperclass();
                    if (clsType == null) {
                        throw new ReflectException(e);
                    }
                }
            } while (clsType == null);
            throw new ReflectException(e);
        }
    }

    public final ApiReflect dH(String str) {
        return h(str, new Object[0]);
    }

    private ApiReflect h(String str, Object... objArr) {
        return a(str, c(objArr), objArr);
    }

    public final ApiReflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return a(a(str, clsArr), this.aBm, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        } catch (NoSuchMethodException unused) {
            return a(b(str, clsArr), this.aBm, objArr);
        }
    }

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsType = type();
        try {
            return a.d(clsType, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return a.c(clsType, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    clsType = clsType.getSuperclass();
                }
            } while (clsType != null);
            throw new NoSuchMethodException();
        }
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsType = type();
        for (Method method : a.e(clsType)) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : a.d(clsType)) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    public final ApiReflect VR() {
        return b(new Object[0]);
    }

    private ApiReflect b(Object... objArr) {
        return a(c(objArr), objArr);
    }

    public final ApiReflect a(Class<?>[] clsArr, Object... objArr) {
        try {
            return a((Constructor<?>) a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : a.f(type())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a((Constructor<?>) constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != b.class && !c(clsArr[i]).isAssignableFrom(c(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.aBm.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ApiReflect) {
            return this.aBm.equals(((ApiReflect) obj).get());
        }
        return false;
    }

    public final String toString() {
        return String.valueOf(this.aBm);
    }

    private static ApiReflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static ApiReflect a(Method method, Object obj, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return m(obj);
            }
            return m(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Object n(Object obj) {
        return obj instanceof ApiReflect ? ((ApiReflect) obj).get() : obj;
    }

    private static Class<?>[] c(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    private static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Class<?> type() {
        return this.brU;
    }

    private static Class<?> c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    static class b {
        private b() {
        }
    }
}
