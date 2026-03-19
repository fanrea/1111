package com.baidu.ad.magic.flute.c.a.a;

import java.math.BigInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c implements com.baidu.ad.magic.flute.b.b.a.a {
    private BigInteger a;
    private BigInteger b;

    public c(BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = bigInteger;
        this.b = bigInteger2;
    }

    public c(byte[] bArr, byte[] bArr2) {
        this.a = new BigInteger(bArr);
        this.b = new BigInteger(bArr2);
    }

    @Override // com.baidu.ad.magic.flute.b.b.a.a
    public BigInteger a() {
        return this.a;
    }

    @Override // com.baidu.ad.magic.flute.b.b.a.a
    public BigInteger b() {
        return this.b;
    }
}
