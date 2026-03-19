package com.baidu.mobads.container.components.g;

import android.text.TextUtils;
import com.baidu.mobads.container.components.g.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    private static volatile e a;
    private final b b = new b();

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    public d a(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new h(this, iVar);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            new h(this, new i.a().a(str).b()).a((a) null);
        }
    }

    public b b() {
        return this.b;
    }
}
