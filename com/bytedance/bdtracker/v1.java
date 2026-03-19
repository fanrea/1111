package com.bytedance.bdtracker;

import android.accounts.Account;
import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class v1 {
    public volatile q4 a;
    public Account b;
    public s3 c;

    public q4 a(d dVar, Context context, q1 q1Var) {
        if (this.a == null) {
            synchronized (v1.class) {
                if (this.a == null) {
                    if (context == null) {
                        throw new IllegalArgumentException("context == null");
                    }
                    if (this.c == null) {
                        this.c = new s3(dVar, context);
                    }
                    if (this.a == null) {
                        this.a = new m4(dVar, context, q1Var, this.c);
                        if (this.b != null) {
                            ((m4) this.a).a(this.b);
                        }
                    }
                }
            }
        }
        return this.a;
    }
}
