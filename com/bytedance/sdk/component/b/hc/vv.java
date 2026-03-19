package com.bytedance.sdk.component.b.hc;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class vv {
    public abstract sy d();

    public abstract void d(com.bytedance.sdk.component.b.d.c cVar) throws IOException;

    public long hc() throws IOException {
        return -1L;
    }

    public static vv d(sy syVar, String str) {
        Charset charsetB = com.bytedance.sdk.component.b.hc.d.b.u;
        if (syVar != null && (charsetB = syVar.b()) == null) {
            charsetB = com.bytedance.sdk.component.b.hc.d.b.u;
            syVar = sy.d(syVar + "; charset=utf-8");
        }
        return d(syVar, str.getBytes(charsetB));
    }

    public static vv d(sy syVar, byte[] bArr) {
        return d(syVar, bArr, 0, bArr.length);
    }

    public static vv d(final sy syVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.bytedance.sdk.component.b.hc.d.b.d(bArr.length, i, i2);
        return new vv() { // from class: com.bytedance.sdk.component.b.hc.vv.1
            @Override // com.bytedance.sdk.component.b.hc.vv
            public sy d() {
                return syVar;
            }

            @Override // com.bytedance.sdk.component.b.hc.vv
            public long hc() {
                return i2;
            }

            @Override // com.bytedance.sdk.component.b.hc.vv
            public void d(com.bytedance.sdk.component.b.d.c cVar) throws IOException {
                cVar.b(bArr, i, i2);
            }
        };
    }
}
