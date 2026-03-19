package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class cp extends j {
    final /* synthetic */ co b;

    cp(co coVar) {
        this.b = coVar;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    protected Object i() {
        try {
            String strA = this.b.a("key_crash_trace");
            String strA2 = this.b.a("key_crash_ad");
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            cl clVarA = cl.a();
            clVarA.a(this.b.n);
            clVarA.a(this.b.a("key_crash_source"), strA, strA2);
            this.b.g();
            return null;
        } catch (Exception e) {
            bu.a().a(e);
            return null;
        }
    }
}
