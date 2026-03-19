package com.qq.e.comm.dynamic;

import com.qq.e.comm.plugin.ey;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class QuickJS implements Closeable {
    private long a;

    private QuickJS(long j) {
        this.a = j;
    }

    public static synchronized QuickJS a() {
        long jCreateContext;
        jCreateContext = createContext();
        if (jCreateContext == 0) {
            throw new OutOfMemoryError("Cannot create QuickJS instance");
        }
        return new QuickJS(jCreateContext);
    }

    private native Object call(long j, long j2, Object obj, Object[] objArr);

    private native byte[] compile(long j, String str, String str2);

    private static native long createContext();

    private native void destroyContext(long j);

    private native Object evaluate(long j, String str, String str2);

    private native Object execute(long j, byte[] bArr);

    private native long get(long j, String str, Object[] objArr);

    private native void set(long j, String str, Object obj, Object[] objArr);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.a;
        if (j != 0) {
            this.a = 0L;
            synchronized (QuickJS.class) {
                destroyContext(j);
            }
        }
    }

    protected void finalize() {
        if (this.a != 0) {
            ey.b();
            Logger.getLogger(QuickJS.class.getName()).warning("QuickJS instance leaked!");
        }
    }

    public Object a(String str) {
        return evaluate(this.a, str, "?");
    }

    public <T> void a(String str, Class<T> cls, T t) throws SecurityException {
        if (cls.isInterface()) {
            if (cls.getInterfaces().length <= 0) {
                if (cls.isInstance(t)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Method method : cls.getMethods()) {
                        if (linkedHashMap.put(method.getName(), method) != null) {
                            throw new UnsupportedOperationException(method.getName() + " is overloaded in " + cls);
                        }
                    }
                    synchronized (QuickJS.class) {
                        set(this.a, str, t, linkedHashMap.values().toArray());
                    }
                    return;
                }
                throw new IllegalArgumentException(t.getClass() + " is not an instance of " + cls);
            }
            throw new UnsupportedOperationException(cls + " must not extend other interfaces");
        }
        throw new UnsupportedOperationException("Only interfaces can be bound. Received: " + cls);
    }

    public byte[] a(String str, String str2) {
        return compile(this.a, str, str2);
    }

    public Object a(byte[] bArr) {
        return execute(this.a, bArr);
    }
}
