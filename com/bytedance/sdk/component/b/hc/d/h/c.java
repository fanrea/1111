package com.bytedance.sdk.component.b.hc.d.h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class c<T> {
    private final Class[] b;
    private final Class<?> d;
    private final String hc;

    c(Class<?> cls, String str, Class... clsArr) {
        this.d = cls;
        this.hc = str;
        this.b = clsArr;
    }

    public boolean d(T t) {
        return d(t.getClass()) != null;
    }

    public Object d(T t, Object... objArr) throws NoSuchMethodException, SecurityException, InvocationTargetException {
        Method methodD = d(t.getClass());
        if (methodD == null) {
            return null;
        }
        try {
            return methodD.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object hc(T t, Object... objArr) {
        try {
            return d(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object b(T t, Object... objArr) throws NoSuchMethodException, SecurityException, InvocationTargetException {
        Method methodD = d(t.getClass());
        if (methodD == null) {
            throw new AssertionError("Method " + this.hc + " not supported for object " + t);
        }
        try {
            return methodD.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(methodD)));
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) {
        try {
            return b(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method d(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Class<?> cls2;
        String str = this.hc;
        if (str == null) {
            return null;
        }
        Method methodD = d(cls, str, this.b);
        if (methodD == null || (cls2 = this.d) == null || cls2.isAssignableFrom(methodD.getReturnType())) {
            return methodD;
        }
        return null;
    }

    private static Method d(Class<?> cls, String str, Class[] clsArr) throws NoSuchMethodException, SecurityException {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
