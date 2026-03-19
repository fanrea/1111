package com.baidu.mobads.container.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    private static final String a = "n_iad_deeplink_time_stamp";
    private static final String b = "n_deeplink_iad_result";
    private static final int c = 24;
    private static final String d = "0";
    private static f f;
    private String[] e;
    private String g;
    private long h;
    private long[] i;
    private String j;

    public static f a() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new f();
                    f.h = 1L;
                }
            }
        }
        return f;
    }

    public void a(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        this.j = str;
        com.baidu.mobads.container.d.b.a().a(new g(this, context, z), 2);
    }

    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        if (this.e == null || this.e.length == 0) {
            this.e = b.a().g(context);
        }
        this.i = new long[this.e.length];
        if (System.currentTimeMillis() - b.a().b(context, a) > TimeUnit.HOURS.toMillis(24L)) {
            b.a().b(context, b, "0");
            b.a().a(context, a, System.currentTimeMillis());
            return "0";
        }
        try {
            this.g = b.a().c(context, b);
            String[] strArrSplit = this.g.split(",");
            for (int i = 0; i < strArrSplit.length; i++) {
                if (this.i.length > i) {
                    this.i[i] = Long.parseLong(strArrSplit[i].trim());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j, int i) {
        return j | (1 << i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long b(long j, int i) {
        return j & ((1 << i) ^ (-1));
    }
}
