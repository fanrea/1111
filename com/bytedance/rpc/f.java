package com.bytedance.rpc;

import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: RpcInvokeContext.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class f {
    private c a;
    private RpcRequestModifier b;
    private final List<RpcInterceptor> c = new ArrayList(4);

    f(c cVar) {
        this.a = cVar;
        this.b = new RpcRequestModifier(cVar);
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

    boolean a(String str, Map<String, String> map, Map<String, String> map2) {
        RpcConfig rpcConfigA = a();
        map.putAll(rpcConfigA.getHeaders());
        map2.putAll(rpcConfigA.getQueries());
        if (str == null) {
            return true;
        }
        return this.a.a(str, map, map2);
    }

    RpcConfig a() {
        return this.a.b();
    }

    RpcRequestModifier b() {
        return this.b;
    }

    RpcInterceptor[] c() {
        List<RpcInterceptor> listC = this.a.c();
        List<RpcInterceptor> list = this.c;
        int size = listC == null ? 0 : listC.size();
        int size2 = list == null ? 0 : list.size();
        RpcInterceptor[] rpcInterceptorArr = new RpcInterceptor[size + size2];
        if (size > 0) {
            listC.toArray(rpcInterceptorArr);
        }
        if (size2 > 0) {
            if (size == 0) {
                list.toArray(rpcInterceptorArr);
            } else {
                for (int i = 0; i < size2; i++) {
                    rpcInterceptorArr[size + i] = list.get(i);
                }
            }
        }
        return rpcInterceptorArr;
    }

    com.bytedance.sdk.djx.proguard3.d.g[] d() {
        List<com.bytedance.sdk.djx.proguard3.d.g> listD = this.a.d();
        int size = listD == null ? 0 : listD.size();
        com.bytedance.sdk.djx.proguard3.d.g[] gVarArr = new com.bytedance.sdk.djx.proguard3.d.g[size];
        if (size > 0) {
            listD.toArray(gVarArr);
        }
        return gVarArr;
    }

    com.bytedance.sdk.djx.proguard3.d.j[] e() {
        List<com.bytedance.sdk.djx.proguard3.d.j> listE = this.a.e();
        int size = listE == null ? 0 : listE.size();
        com.bytedance.sdk.djx.proguard3.d.j[] jVarArr = new com.bytedance.sdk.djx.proguard3.d.j[size];
        if (size > 0) {
            listE.toArray(jVarArr);
        }
        return jVarArr;
    }

    RpcInvokeInterceptor[] f() {
        List<RpcInvokeInterceptor> listF = this.a.f();
        int size = listF == null ? 0 : listF.size();
        RpcInvokeInterceptor[] rpcInvokeInterceptorArr = new RpcInvokeInterceptor[size];
        if (size > 0) {
            listF.toArray(rpcInvokeInterceptorArr);
        }
        return rpcInvokeInterceptorArr;
    }

    public long g() {
        long connectTimeout = this.b.getConnectTimeout();
        long readTimeout = this.b.getReadTimeout();
        long writeTimeout = this.b.getWriteTimeout();
        if (connectTimeout <= 0 || readTimeout <= 0 || writeTimeout <= 0) {
            return 0L;
        }
        return connectTimeout + readTimeout + writeTimeout + 100;
    }
}
