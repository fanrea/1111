package com.bytedance.rpc;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RpcRecorder.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class i {
    List<RpcException> a;
    long b;
    long c;
    private j d;
    private com.bytedance.sdk.djx.proguard3.d.f e;
    private com.bytedance.sdk.djx.proguard3.c.e f;
    private long g;
    private long h;
    private RpcException i;

    i(j jVar) {
        this.d = jVar;
    }

    void a(j jVar) {
        this.d = jVar;
    }

    public boolean a() {
        return this.f == null && this.g > 0;
    }

    public long b() {
        return this.g;
    }

    public long c() {
        return this.h;
    }

    public long d() {
        return this.b;
    }

    public long e() {
        return this.c;
    }

    public j f() {
        return this.d;
    }

    public com.bytedance.sdk.djx.proguard3.d.f g() {
        return this.e;
    }

    public void a(RpcException rpcException) {
        if (rpcException != null) {
            this.i = rpcException;
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = new ArrayList();
                    }
                }
            }
            this.a.add(rpcException);
        }
    }

    public RpcException h() {
        return this.i;
    }

    com.bytedance.sdk.djx.proguard3.d.f a(com.bytedance.sdk.djx.proguard3.d.f fVar) {
        this.e = fVar;
        this.h = System.currentTimeMillis();
        return fVar;
    }

    void i() {
        j();
        this.f = null;
    }

    void j() {
        com.bytedance.sdk.djx.proguard3.c.e eVar = this.f;
        if (eVar != null) {
            eVar.b();
        }
    }

    void a(Handler handler, int i) {
        int iA = this.d.a();
        long jG = this.d.f().g();
        j();
        this.g = System.currentTimeMillis();
        com.bytedance.sdk.djx.proguard3.c.e eVar = new com.bytedance.sdk.djx.proguard3.c.e(handler, jG, i, iA, false);
        this.f = eVar;
        eVar.a();
    }

    void k() {
        this.d = null;
        List<RpcException> list = this.a;
        if (list != null) {
            list.clear();
            this.a = null;
        }
        if (this.e != null) {
            this.e = null;
        }
        com.bytedance.sdk.djx.proguard3.c.e eVar = this.f;
        if (eVar != null) {
            eVar.b();
            this.f = null;
        }
    }
}
