package com.bytedance.bdtracker;

import com.bytedance.applog.event.AutoTrackEventType;
import com.bytedance.bdtracker.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u implements b.e {
    @Override // com.bytedance.bdtracker.b.e
    public boolean a(d dVar) {
        return dVar.isBavEnabled() && dVar.getInitConfig() != null && AutoTrackEventType.a(dVar.getInitConfig().getAutoTrackEventType(), 8);
    }
}
