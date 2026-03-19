package com.bytedance.sdk.component.b.hc;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class s implements Closeable {
    public abstract com.bytedance.sdk.component.b.d.u b();

    public abstract sy d();

    public abstract long hc();

    public final InputStream c() {
        return b().an();
    }

    public final byte[] u() throws IOException {
        long jHc = hc();
        if (jHc > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jHc)));
        }
        com.bytedance.sdk.component.b.d.u uVarB = b();
        try {
            byte[] bArrW = uVarB.w();
            com.bytedance.sdk.component.b.hc.d.b.d(uVarB);
            if (jHc == -1 || jHc == bArrW.length) {
                return bArrW;
            }
            throw new IOException("Content-Length (" + jHc + ") and stream length (" + bArrW.length + ") disagree");
        } catch (Throwable th) {
            com.bytedance.sdk.component.b.hc.d.b.d(uVarB);
            throw th;
        }
    }

    public final String an() throws IOException {
        com.bytedance.sdk.component.b.d.u uVarB = b();
        try {
            String strD = uVarB.d(com.bytedance.sdk.component.b.hc.d.b.d(uVarB, h()));
            com.bytedance.sdk.component.b.hc.d.b.d(uVarB);
            return strD;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.b.hc.d.b.d(uVarB);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.b.hc.d.b.d(uVarB);
            throw th;
        }
    }

    private Charset h() {
        sy syVarD = d();
        return syVarD != null ? syVarD.d(com.bytedance.sdk.component.b.hc.d.b.u) : com.bytedance.sdk.component.b.hc.d.b.u;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.component.b.hc.d.b.d(b());
    }

    public static s d(sy syVar, byte[] bArr) {
        return d(syVar, bArr.length, new com.bytedance.sdk.component.b.d.b().b(bArr));
    }

    public static s d(final sy syVar, final long j, final com.bytedance.sdk.component.b.d.u uVar) {
        if (uVar == null) {
            throw new NullPointerException("source == null");
        }
        return new s() { // from class: com.bytedance.sdk.component.b.hc.s.1
            @Override // com.bytedance.sdk.component.b.hc.s
            public sy d() {
                return syVar;
            }

            @Override // com.bytedance.sdk.component.b.hc.s
            public long hc() {
                return j;
            }

            @Override // com.bytedance.sdk.component.b.hc.s
            public com.bytedance.sdk.component.b.d.u b() {
                return uVar;
            }
        };
    }
}
