package okhttp3.internal.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class d<T> {
    private final Class<?> DH;
    private final String DI;
    private final Class[] DJ;

    public d(Class<?> cls, String str, Class... clsArr) {
        this.DH = cls;
        this.DI = str;
        this.DJ = clsArr;
    }

    public final boolean s(T t) {
        return h(t.getClass()) != null;
    }

    private Object a(T t, Object... objArr) throws NoSuchMethodException, SecurityException {
        Method methodH = h(t.getClass());
        if (methodH == null) {
            return null;
        }
        try {
            return methodH.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public final Object b(T t, Object... objArr) {
        try {
            return a(t, objArr);
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

    private Object invoke(T t, Object... objArr) throws NoSuchMethodException, SecurityException {
        Method methodH = h(t.getClass());
        if (methodH == null) {
            throw new AssertionError("Method " + this.DI + " not supported for object " + t);
        }
        try {
            return methodH.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodH);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public final Object c(T t, Object... objArr) {
        try {
            return invoke(t, objArr);
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

    private Method h(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Class<?> cls2;
        String str = this.DI;
        if (str == null) {
            return null;
        }
        Method methodA = a(cls, str, this.DJ);
        if (methodA == null || (cls2 = this.DH) == null || cls2.isAssignableFrom(methodA.getReturnType())) {
            return methodA;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) throws NoSuchMethodException, SecurityException {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) != 0) {
                    return method;
                }
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
        }
        return null;
    }
}
