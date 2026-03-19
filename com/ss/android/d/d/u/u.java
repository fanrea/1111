package com.ss.android.d.d.u;

import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u {
    public boolean h;
    public String u;
    public long d = -1;
    public int hc = -1;
    public long b = -1;
    public long c = -1;
    public int an = 0;

    public boolean equals(Object obj) {
        if ((obj instanceof u) && obj != null) {
            u uVar = (u) obj;
            return ((this.d > uVar.d ? 1 : (this.d == uVar.d ? 0 : -1)) == 0) && (this.hc == uVar.hc) && ((this.b > uVar.b ? 1 : (this.b == uVar.b ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.u) && TextUtils.isEmpty(uVar.u)) || (!TextUtils.isEmpty(this.u) && !TextUtils.isEmpty(uVar.u) && this.u.equals(uVar.u)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.d), Integer.valueOf(this.hc), Long.valueOf(this.b), this.u});
    }

    public void d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return;
        }
        this.d = bVar.h();
        this.hc = bVar.w();
        this.c = bVar.js();
        this.b = bVar.mb();
        this.u = bVar.k();
        com.ss.android.socialbase.downloader.u.d dVarLt = bVar.lt();
        if (dVarLt != null) {
            this.an = dVarLt.d();
        } else {
            this.an = 0;
        }
        this.h = bVar.np();
    }
}
