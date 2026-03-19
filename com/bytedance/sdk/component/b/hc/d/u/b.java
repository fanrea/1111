package com.bytedance.sdk.component.b.hc.d.u;

import com.baidu.mobads.container.util.bu;
import okhttp3.internal.http2.Header;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b {
    public final com.bytedance.sdk.component.b.d.an gb;
    public final com.bytedance.sdk.component.b.d.an h;
    final int tt;
    public static final com.bytedance.sdk.component.b.d.an d = com.bytedance.sdk.component.b.d.an.d(":");
    public static final com.bytedance.sdk.component.b.d.an hc = com.bytedance.sdk.component.b.d.an.d(Header.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.component.b.d.an b = com.bytedance.sdk.component.b.d.an.d(Header.TARGET_METHOD_UTF8);
    public static final com.bytedance.sdk.component.b.d.an c = com.bytedance.sdk.component.b.d.an.d(Header.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.component.b.d.an u = com.bytedance.sdk.component.b.d.an.d(Header.TARGET_SCHEME_UTF8);
    public static final com.bytedance.sdk.component.b.d.an an = com.bytedance.sdk.component.b.d.an.d(Header.TARGET_AUTHORITY_UTF8);

    public b(String str, String str2) {
        this(com.bytedance.sdk.component.b.d.an.d(str), com.bytedance.sdk.component.b.d.an.d(str2));
    }

    public b(com.bytedance.sdk.component.b.d.an anVar, String str) {
        this(anVar, com.bytedance.sdk.component.b.d.an.d(str));
    }

    public b(com.bytedance.sdk.component.b.d.an anVar, com.bytedance.sdk.component.b.d.an anVar2) {
        this.h = anVar;
        this.gb = anVar2;
        this.tt = anVar.h() + 32 + anVar2.h();
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.h.equals(bVar.h) && this.gb.equals(bVar.gb)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.h.hashCode() + bu.g) * 31) + this.gb.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.component.b.hc.d.b.d("%s: %s", this.h.d(), this.gb.d());
    }
}
