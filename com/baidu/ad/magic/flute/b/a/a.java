package com.baidu.ad.magic.flute.b.a;

import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private com.baidu.ad.magic.flute.c.a.a.b a;

    private a() {
    }

    public static a a() throws NoSuchPaddingException {
        a aVar = new a();
        aVar.a = new com.baidu.ad.magic.flute.c.a.a.b();
        aVar.a.b(com.baidu.ad.magic.flute.c.a.a.b.a);
        return aVar;
    }

    public void a(int i, com.baidu.ad.magic.flute.b.b.a.a aVar) throws InvalidKeyException {
        this.a.a(i, aVar, com.baidu.ad.magic.flute.c.a.a.a.a);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            return this.a.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
