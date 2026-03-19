package com.bytedance.sdk.component.tt;

import com.bytedance.sdk.component.hc.d.mk;
import java.io.File;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    final long an;
    final Map<String, String> b;
    final String c;
    final int d;
    mk h;
    final String hc;
    private final boolean tt;
    final long u;
    private File gb = null;
    private byte[] tc = null;

    public hc(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.tt = z;
        this.d = i;
        this.hc = str;
        this.b = map;
        this.c = str2;
        this.u = j;
        this.an = j2;
    }

    public int d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    public Map<String, String> b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public long u() {
        return this.u;
    }

    public long an() {
        return this.an;
    }

    public File h() {
        return this.gb;
    }

    public void d(File file) {
        this.gb = file;
    }

    public boolean gb() {
        return this.tt;
    }

    public long tt() {
        return this.u - this.an;
    }

    public byte[] tc() {
        return this.tc;
    }

    public void d(byte[] bArr) {
        this.tc = bArr;
    }

    public mk mk() {
        return this.h;
    }

    public void d(mk mkVar) {
        this.h = mkVar;
    }
}
