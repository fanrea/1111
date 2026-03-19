package com.bytedance.bdtracker;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class w4 implements Runnable {
    public final /* synthetic */ Context a;

    public w4(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        v4.b.b(this.a).edit().putBoolean("_install_started_v2", true).apply();
    }
}
