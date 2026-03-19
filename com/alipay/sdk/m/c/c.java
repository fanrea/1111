package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.r0.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements com.alipay.sdk.m.b.b {
    public static final int d = 1;
    public com.alipay.sdk.m.r0.b a;
    public boolean b = false;
    public boolean c = false;

    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.b) {
            com.alipay.sdk.m.r0.b bVar = new com.alipay.sdk.m.r0.b();
            this.a = bVar;
            this.c = bVar.a(context, (b.InterfaceC0058b<String>) null) == 1;
            this.b = true;
        }
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", Boolean.valueOf(this.c));
        if (this.c && this.a.e()) {
            return this.a.b();
        }
        return null;
    }
}
