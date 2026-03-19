package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidKeyException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d extends f {
    protected byte[] a;
    private byte[] e;
    private byte[] f;

    d(b bVar) {
        super(bVar);
        this.f = null;
        this.e = new byte[this.c];
        this.a = new byte[this.c];
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    void a() {
        System.arraycopy(this.d, 0, this.a, 0, this.c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    void a(boolean z, String str, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr == null || bArr2 == null || bArr2.length != this.c) {
            throw new InvalidKeyException("Internal error");
        }
        this.d = bArr2;
        a();
        this.b.a(z, str, bArr);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    void a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + i;
        while (i < i4) {
            for (int i5 = 0; i5 < this.c; i5++) {
                this.e[i5] = (byte) (bArr[i5 + i] ^ this.a[i5]);
            }
            this.b.a(this.e, 0, bArr2, i3);
            System.arraycopy(bArr2, i3, this.a, 0, this.c);
            i += this.c;
            i3 += this.c;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    void b() {
        if (this.f == null) {
            this.f = new byte[this.c];
        }
        System.arraycopy(this.a, 0, this.f, 0, this.c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + i;
        byte[] bArr3 = (bArr != bArr2 || i < i3 || i - i3 >= this.c) ? null : (byte[]) bArr.clone();
        while (i < i4) {
            this.b.b(bArr, i, this.e, 0);
            for (int i5 = 0; i5 < this.c; i5++) {
                bArr2[i5 + i3] = (byte) (this.e[i5] ^ this.a[i5]);
            }
            byte[] bArr4 = this.a;
            int i6 = this.c;
            if (bArr3 == null) {
                System.arraycopy(bArr, i, bArr4, 0, i6);
            } else {
                System.arraycopy(bArr3, i, bArr4, 0, i6);
            }
            i += this.c;
            i3 += this.c;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    void c() {
        System.arraycopy(this.f, 0, this.a, 0, this.c);
    }
}
