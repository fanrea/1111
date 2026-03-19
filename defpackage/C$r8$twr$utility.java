package defpackage;

import java.lang.reflect.InvocationTargetException;

/* renamed from: $r8$twr$utility, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public /* synthetic */ class C$r8$twr$utility {
    public static /* synthetic */ void $closeResource(Throwable th, Object obj) {
        try {
            if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
                return;
            }
            try {
                obj.getClass().getMethod("close", new Class[0]).invoke(obj, new Object[0]);
            } catch (ExceptionInInitializerError e) {
                e = e;
                throw new AssertionError("Fail to call close() on " + obj.getClass(), e);
            } catch (IllegalAccessException e2) {
                e = e2;
                throw new AssertionError("Fail to call close() on " + obj.getClass(), e);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new AssertionError("Fail to call close() on " + obj.getClass(), e);
            } catch (NoSuchMethodException e4) {
                e = e4;
                throw new AssertionError(obj.getClass() + " does not have a close() method.", e);
            } catch (SecurityException e5) {
                e = e5;
                throw new AssertionError(obj.getClass() + " does not have a close() method.", e);
            } catch (InvocationTargetException e6) {
                throw e6.getCause();
            }
        } finally {
        }
    }
}
