package com.android.gdt.qone.c;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b {
    public SharedPreferences a;
    public Context b;

    public final void a(String str, String str2) {
        if (a() == null) {
            return;
        }
        this.a.edit().putString(str, str2).apply();
    }

    public final String b() {
        long j;
        if (a() == null) {
            return "";
        }
        Context context = this.b;
        if (context == null) {
            j = 0;
        } else {
            try {
                j = this.b.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long j2 = a() == null ? 0L : this.a.getLong("qm_od_i_tm", 0L);
        if (j2 == 0) {
            if (a() != null) {
                this.a.edit().putLong("qm_od_i_tm", j).apply();
            }
        } else if (j > j2) {
            if (a() != null) {
                this.a.edit().clear().apply();
            }
            return "";
        }
        String string = this.a.getString("qm_ch_od", "");
        return string == null ? "" : string;
    }

    public final SharedPreferences a() {
        Context context;
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null && (context = this.b) != null) {
                    this.a = context.getSharedPreferences("qm_od_sp", 0);
                }
            }
        }
        return this.a;
    }
}
