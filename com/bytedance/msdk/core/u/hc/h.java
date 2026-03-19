package com.bytedance.msdk.core.u.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h implements Comparable<h> {
    private boolean b = false;
    private com.bytedance.msdk.api.d.hc c;
    public com.bytedance.msdk.hc.b d;
    private long hc;

    public h(com.bytedance.msdk.hc.b bVar, long j, com.bytedance.msdk.api.d.hc hcVar) {
        this.d = bVar;
        this.hc = j;
        this.c = hcVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        return this.d.compareTo(hVar.d);
    }

    public long d() {
        return this.hc;
    }

    public String hc() {
        com.bytedance.msdk.hc.b bVar = this.d;
        if (bVar == null) {
            return null;
        }
        return bVar.ph();
    }

    public boolean b() {
        return this.b;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public com.bytedance.msdk.api.d.hc c() {
        return this.c;
    }

    public boolean u() {
        com.bytedance.msdk.hc.b bVar = this.d;
        return (bVar == null || this.c == null || bVar.xp() || !this.d.ba(this.c.v())) ? false : true;
    }

    public String an() {
        com.bytedance.msdk.api.d.hc hcVar = this.c;
        if (hcVar == null) {
            return null;
        }
        return hcVar.v();
    }

    public void hc(boolean z) {
        com.bytedance.msdk.hc.b bVar = this.d;
        if (bVar == null) {
            return;
        }
        bVar.d(z);
    }

    public boolean h() {
        com.bytedance.msdk.hc.b bVar = this.d;
        if (bVar == null) {
            return false;
        }
        return bVar.de();
    }
}
