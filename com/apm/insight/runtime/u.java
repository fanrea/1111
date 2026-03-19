package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class u {
    private String a = null;
    private String b = null;
    private int c = -1;

    public u(Context context) {
    }

    public String a() {
        if (!TextUtils.isEmpty(this.a) && !"0".equals(this.a)) {
            return this.a;
        }
        if (!TextUtils.isEmpty(this.b) && !"0".equals(this.b)) {
            return this.b;
        }
        String strD = com.apm.insight.g.a().d();
        this.a = strD;
        if (!TextUtils.isEmpty(strD) && !"0".equals(this.a)) {
            return this.a;
        }
        String strB = t.a().b();
        this.b = strB;
        return strB;
    }

    public void a(String str) {
        this.a = str;
        t.a().b(str);
    }

    public boolean b() {
        return this.a != null;
    }
}
