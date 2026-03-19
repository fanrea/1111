package com.bytedance.bdtracker;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a0 extends c0 {
    public long g;
    public JSONObject h;

    public a0(e0 e0Var) {
        super(e0Var);
        this.g = 0L;
        this.h = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8 A[Catch: all -> 0x0116, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x000e, B:7:0x0014, B:9:0x001c, B:14:0x002a, B:20:0x005a, B:22:0x0096, B:24:0x00a9, B:29:0x00be, B:35:0x00d8, B:37:0x00e0, B:39:0x00f1, B:41:0x010c, B:38:0x00ed, B:31:0x00c6, B:44:0x0111, B:45:0x0113, B:19:0x004f, B:21:0x0092, B:16:0x0035), top: B:53:0x0001, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized org.json.JSONObject a(int r14) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.a0.a(int):org.json.JSONObject");
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean c() {
        try {
            return a(60000) != null;
        } catch (Throwable th) {
            this.f.D.error(2, "Do fetch config failed", th, new Object[0]);
            return false;
        }
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "AbConfigure";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        return h0.h;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long g() {
        long j = this.e.e.f.getLong("abtest_fetch_interval", 0L);
        if (j < 600000) {
            return 600000L;
        }
        return j;
    }
}
