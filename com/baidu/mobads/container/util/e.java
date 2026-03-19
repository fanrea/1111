package com.baidu.mobads.container.util;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements Runnable {
    final /* synthetic */ String[] a;
    final /* synthetic */ Context b;
    final /* synthetic */ b c;

    e(b bVar, String[] strArr, Context context) {
        this.c = bVar;
        this.a = strArr;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.a.length; i++) {
            try {
                this.c.b(this.b, "n_origin_pkg_encode_" + i, this.a[i]);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.c.b(this.b, "n_iad_index_array", this.a.length - 1);
        String str = this.a[this.a.length - 1];
        int length = this.a.length - 1;
        if (this.c.a(str).length < 61) {
            length--;
        }
        this.c.b(this.b, "n_index_full_array", length);
    }
}
