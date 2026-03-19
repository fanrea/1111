package com.baidu.enan.c;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    protected Context a;
    private b b;

    public a(Context context) {
        try {
            this.a = context;
            this.b = new b(context);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }

    protected String a(String str, byte[] bArr) {
        if (str != null) {
            return this.b.a(str, "", bArr);
        }
        throw new IllegalArgumentException("ptf req null");
    }
}
