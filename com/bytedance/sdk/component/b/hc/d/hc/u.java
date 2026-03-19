package com.bytedance.sdk.component.b.hc.d.hc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u extends RuntimeException {
    private static final Method d;
    private IOException hc;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        d = declaredMethod;
    }

    public u(IOException iOException) {
        super(iOException);
        this.hc = iOException;
    }

    public IOException d() {
        return this.hc;
    }

    public void d(IOException iOException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        d(iOException, this.hc);
        this.hc = iOException;
    }

    private void d(IOException iOException, IOException iOException2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = d;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
