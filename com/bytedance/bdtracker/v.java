package com.bytedance.bdtracker;

import com.bytedance.bdtracker.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class v implements b.e {
    public final /* synthetic */ d4 a;

    public v(d4 d4Var) {
        this.a = d4Var;
    }

    @Override // com.bytedance.bdtracker.b.e
    public boolean a(d dVar) {
        if (!b.b.a(dVar) || dVar.isAutoTrackPageIgnored(this.a.E)) {
            return false;
        }
        if (this.a.D) {
            return dVar.getInitConfig() == null || dVar.getInitConfig().isAutoTrackFragmentEnabled();
        }
        return true;
    }
}
