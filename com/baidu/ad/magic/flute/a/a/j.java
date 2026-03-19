package com.baidu.ad.magic.flute.a.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j {
    b a;
    private byte[] b;

    public j(byte[] bArr) {
        this.b = bArr;
        this.a = a.a(bArr);
    }

    static int a(byte b) {
        switch (b) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                throw new IllegalStateException();
        }
    }

    public static j a(byte[] bArr, int i) {
        return new j(a.a(bArr, i));
    }

    static byte b(int i) throws n {
        switch (i) {
            case 0:
                return (byte) 0;
            case 1:
                return (byte) 1;
            case 2:
                return (byte) 2;
            default:
                throw new n("unexpected value " + i);
        }
    }

    public int a() {
        return this.b.length;
    }

    public int a(int i) {
        if (i < 0 || i >= this.b.length) {
            throw new IllegalArgumentException("illegal index " + i + " with current length is " + this.b.length);
        }
        return a(this.b[i]);
    }

    public byte[] b() {
        return this.a.a();
    }

    public int c() {
        return this.a.b();
    }
}
