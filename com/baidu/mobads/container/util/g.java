package com.baidu.mobads.container.util;

import android.content.Context;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;
    final /* synthetic */ f c;

    g(f fVar, Context context, boolean z) {
        this.c = fVar;
        this.a = context;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (System.currentTimeMillis() - b.a().b(this.a, "n_iad_deeplink_time_stamp") > TimeUnit.HOURS.toMillis(24L)) {
                this.c.g = "0";
                this.c.i = new long[this.c.e.length];
                b.a().a(this.a, "n_iad_deeplink_time_stamp", System.currentTimeMillis());
            }
            for (int i = 0; i < this.c.e.length; i++) {
                String[] strArrA = b.a().a(this.c.e[i]);
                if (this.c.i.length <= i) {
                    this.c.h = 1L;
                } else {
                    this.c.h = this.c.i[i];
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= strArrA.length || i2 >= 64) {
                        break;
                    }
                    if (!strArrA[i2].equals(this.c.j)) {
                        i2++;
                    } else if (this.b) {
                        this.c.h = this.c.a(this.c.h, i2);
                    } else {
                        this.c.h = this.c.b(this.c.h, i2);
                    }
                }
                if (this.c.i.length > i) {
                    this.c.i[i] = this.c.h;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.c.i.length; i3++) {
                if (i3 > 0) {
                    sb.append(",");
                }
                sb.append(this.c.i[i3]);
            }
            this.c.g = sb.toString();
            b.a().b(this.a, "n_deeplink_iad_result", this.c.g);
        } catch (Throwable th) {
            bq.a().c(th);
        }
    }
}
