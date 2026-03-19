package com.baidu.mobads.cid.cesium.c.d;

import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private c a;

    private a() {
    }

    public static a a() throws NoSuchPaddingException {
        a aVar = new a();
        aVar.a = new c();
        aVar.a.a(com.baidu.ad.magic.flute.c.a.a.b.a);
        return aVar;
    }

    public void a(int i, d dVar) throws InvalidKeyException {
        this.a.a(i, dVar, b.a);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            return this.a.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
