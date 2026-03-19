package com.bytedance.bdtracker;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class g0 extends c0 {
    public static final long[] i = {1000};
    public final String g;
    public int h;

    public g0(e0 e0Var, String str) {
        super(e0Var);
        this.h = 0;
        this.g = str;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean c() {
        int i2 = this.f.k.a((JSONObject) null, this.g) ? 0 : this.h + 1;
        this.h = i2;
        if (i2 > 3) {
            this.f.setRangersEventVerifyEnable(false, this.g);
        }
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "RangersEventVerify";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        return i;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long g() {
        return 1000L;
    }
}
