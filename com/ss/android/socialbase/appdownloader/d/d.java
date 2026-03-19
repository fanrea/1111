package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d implements u {
    protected final String b;
    protected final Context d;
    protected final com.ss.android.socialbase.downloader.uo.d hc;

    public d(Context context, com.ss.android.socialbase.downloader.uo.d dVar, String str) {
        this.d = context;
        this.hc = dVar;
        this.b = str;
    }

    public boolean d() {
        if (this.d == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.an.d.d()) {
                com.bytedance.sdk.component.utils.mq.b("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return hc().resolveActivity(this.d.getPackageManager()) != null;
    }
}
