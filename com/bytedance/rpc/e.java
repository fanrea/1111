package com.bytedance.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: RpcInvocationHandler.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e implements InvocationHandler {
    private Class<?> a;
    private g b;
    private f c;
    private final Map<Method, h> d = new LinkedHashMap();

    public e(Class<?> cls, g gVar, f fVar) {
        this.a = cls;
        this.b = gVar;
        this.c = fVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        return this.b.a(a(this.c, method, objArr));
    }

    public f a() {
        return this.c;
    }

    private j a(f fVar, Method method, Object[] objArr) {
        return a(method).a(fVar, objArr);
    }

    private h a(Method method) {
        h hVar;
        synchronized (this.d) {
            hVar = this.d.get(method);
            if (hVar == null) {
                hVar = new h(this.a, method);
                this.d.put(method, hVar);
            }
        }
        return hVar;
    }
}
