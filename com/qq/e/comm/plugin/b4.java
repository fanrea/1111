package com.qq.e.comm.plugin;

import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b4 implements wj {
    private final wj a;
    private final ow b;
    private int d;
    private long c = -1;
    private String e = "";

    @Override // com.qq.e.comm.plugin.wj
    public Map<String, Object> e() {
        HashMap map = new HashMap();
        map.put("retryCount", Integer.valueOf(this.b.c()));
        map.put("retryInterval", Long.valueOf(this.b.a()));
        map.put("core", this.a.e());
        return map;
    }

    public b4(wj wjVar, ow owVar) {
        this.a = wjVar;
        this.b = owVar;
    }

    @Override // com.qq.e.comm.plugin.wj
    public int b() {
        return this.a.b() | this.d;
    }

    @Override // com.qq.e.comm.plugin.wj
    public boolean i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zI = false;
        do {
            try {
                zI = this.a.i();
                if (!this.b.a(b())) {
                    this.c = System.currentTimeMillis() - jCurrentTimeMillis;
                    return false;
                }
                try {
                    Thread.sleep(this.b.a());
                } catch (InterruptedException unused) {
                }
                if (this.b.b()) {
                    this.d = 67108864;
                    this.e = "NetworkChangedAndPauseDownloadTask";
                    this.c = System.currentTimeMillis() - jCurrentTimeMillis;
                    return false;
                }
            } catch (Throwable unused2) {
            }
        } while (!zI);
        this.c = System.currentTimeMillis() - jCurrentTimeMillis;
        return zI;
    }

    @Override // com.qq.e.comm.plugin.wj
    public void a(ll llVar) {
        this.a.a(llVar);
    }

    @Override // com.qq.e.comm.plugin.wj
    public String a() {
        return this.a.a() + "\t" + this.e;
    }

    @Override // com.qq.e.comm.plugin.wj
    public long f() {
        return this.a.f();
    }

    @Override // com.qq.e.comm.plugin.wj
    public long j() {
        return this.a.j();
    }

    @Override // com.qq.e.comm.plugin.wj
    public int h() {
        return this.a.h();
    }

    @Override // com.qq.e.comm.plugin.wj
    public long d() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.wj
    public Map<String, Object> c() {
        return this.a.c();
    }

    @Override // com.qq.e.comm.plugin.wj
    public String g() {
        return this.a.g();
    }

    @Override // com.qq.e.comm.plugin.wj
    public void pause() {
        this.d |= 128;
        this.a.pause();
    }

    @Override // com.qq.e.comm.plugin.wj
    public void cancel() {
        this.d |= 64;
        this.a.cancel();
    }
}
