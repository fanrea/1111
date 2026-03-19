package com.bytedance.rpc;

import android.app.Application;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RpcContext.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private RpcConfig a;
    private final Application b;
    private final List<RpcInterceptor> c = new ArrayList(4);
    private final List<com.bytedance.sdk.djx.proguard3.d.g> d = new ArrayList(2);
    private final List<com.bytedance.sdk.djx.proguard3.d.j> e = new ArrayList(2);
    private final List<RpcInvokeInterceptor> f = new ArrayList(2);
    private final Map<String, Object> g = new HashMap(4);
    private final Map<String, Map<String, String>> h = new HashMap(2);
    private final Map<String, Map<String, String>> i = new HashMap(2);

    c(Application application, RpcConfig rpcConfig) {
        this.b = application;
        this.a = rpcConfig;
    }

    public Application a() {
        return this.b;
    }

    public void a(RpcInterceptor rpcInterceptor) {
        if (rpcInterceptor != null) {
            synchronized (this.c) {
                if (!this.c.contains(rpcInterceptor)) {
                    this.c.add(rpcInterceptor);
                }
            }
        }
    }

    public void b(RpcInterceptor rpcInterceptor) {
        if (rpcInterceptor != null) {
            synchronized (this.c) {
                this.c.remove(rpcInterceptor);
            }
        }
    }

    public void a(com.bytedance.sdk.djx.proguard3.d.j jVar) {
        if (jVar != null) {
            synchronized (this.e) {
                if (!this.e.contains(jVar)) {
                    this.e.add(jVar);
                }
            }
        }
    }

    public void a(RpcInvokeInterceptor rpcInvokeInterceptor) {
        if (rpcInvokeInterceptor == null || this.f.contains(rpcInvokeInterceptor)) {
            return;
        }
        this.f.add(rpcInvokeInterceptor);
    }

    public RpcConfig b() {
        return this.a;
    }

    List<RpcInterceptor> c() {
        return this.c;
    }

    List<com.bytedance.sdk.djx.proguard3.d.g> d() {
        return this.d;
    }

    List<com.bytedance.sdk.djx.proguard3.d.j> e() {
        return this.e;
    }

    List<RpcInvokeInterceptor> f() {
        return this.f;
    }

    boolean a(String str, Map<String, String> map, Map<String, String> map2) {
        Object objRemove;
        synchronized (this.g) {
            Map<String, String> map3 = this.h.get(str);
            Map<String, String> map4 = this.i.get(str);
            if ((map3 == null || map4 == null) && (objRemove = this.g.remove(str)) != null) {
                a(str, objRemove);
                map3 = this.h.get(str);
                map4 = this.i.get(str);
            }
            if (map3 == null || map4 == null) {
                return false;
            }
            map.putAll(map3);
            map2.putAll(map4);
            return true;
        }
    }

    private void a(String str, Object obj) {
        HashMap map = new HashMap(8);
        HashMap map2 = new HashMap(8);
        com.bytedance.rpc.serialize.h.a(obj, map, map2, null, null);
        this.h.put(str, map);
        this.i.put(str, map2);
    }
}
