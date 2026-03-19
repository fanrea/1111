package com.android.gdt.qone.ad;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c {
    public SharedPreferences a;
    public Context b;

    public final SharedPreferences a() {
        Context context;
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null && (context = this.b) != null) {
                    this.a = context.getSharedPreferences("qm_global_sp", 0);
                }
            }
        }
        return this.a;
    }

    public final void a(boolean z) {
        if (a() == null) {
            return;
        }
        this.a.edit().putBoolean("sp_need_report", z).apply();
    }

    public final void a(long j) {
        if (a() == null) {
            return;
        }
        this.a.edit().putLong("l_u_time", j).apply();
    }

    public final void a(String str, String str2) {
        if (a() == null) {
            return;
        }
        this.a.edit().putString(str, str2).apply();
    }
}
