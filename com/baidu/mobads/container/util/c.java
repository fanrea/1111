package com.baidu.mobads.container.util;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements Runnable {
    final /* synthetic */ String[] a;
    final /* synthetic */ Context b;
    final /* synthetic */ b c;

    c(b bVar, String[] strArr, Context context) {
        this.c = bVar;
        this.a = strArr;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (int i = 0; i < this.a.length; i++) {
                    this.c.a(this.a, this.b, i);
                    Thread.sleep(this.c.d);
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < this.c.B.length; i2++) {
                    if (i2 > 0) {
                        stringBuffer.append(",");
                    }
                    stringBuffer.append(this.c.B[i2]);
                }
                String string = stringBuffer.toString();
                String str = "false";
                if (TextUtils.isEmpty(this.c.z)) {
                    str = "true";
                }
                this.c.a(this.b, ((System.currentTimeMillis() - jCurrentTimeMillis) - (this.c.d * this.a.length)) + "", string, str);
                this.c.z = string;
                this.c.b(this.b, "n_iad_sniff_result", string);
                this.c.a(this.b, "n_iad_time_stamp", System.currentTimeMillis());
                this.c.D = false;
                if (com.baidu.mobads.container.h.a.a().A()) {
                    this.c.a(this.b);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                bq.a().c(th);
            }
        } finally {
            this.c.D = false;
        }
    }
}
