package com.tk.core.o;

import com.tkruntime.v8.V8JSONProxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    public static Object b(Object[] objArr, int i) {
        if (objArr == null || i >= objArr.length) {
            return null;
        }
        Object obj = objArr[i];
        return obj instanceof V8JSONProxy ? ((V8JSONProxy) obj).getNativeObject() : obj;
    }

    public static Object c(Object[] objArr, int i) {
        if (objArr == null || i >= objArr.length) {
            return 0;
        }
        return objArr[i];
    }

    public static Object d(Object[] objArr, int i) {
        if (objArr == null) {
            return Boolean.FALSE;
        }
        if (i >= objArr.length) {
            return Boolean.FALSE;
        }
        return objArr[i];
    }
}
