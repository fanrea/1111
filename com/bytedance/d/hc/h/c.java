package com.bytedance.d.hc.h;

import android.content.Context;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.tt;
import com.bytedance.d.hc.u.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c implements Runnable {
    private Context d;

    private c(Context context) {
        this.d = context;
    }

    public static void d(Context context, int i) {
        try {
            if (!gb.d().c().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        h.hc().postDelayed(new c(context), i);
    }

    public static void d(Context context) {
        d(context, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new com.bytedance.d.hc.u.b(this.d).d(tt.hc(this.d));
        } finally {
            try {
            } finally {
            }
        }
    }
}
