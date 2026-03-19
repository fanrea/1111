package com.qq.e.comm.plugin;

import io.netty.util.internal.StringUtil;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j5 {
    private final int a;
    private final byte[] b;

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.a; i++) {
            sb.append(c(i) ? "1" : "0");
            if (i < this.a - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public j5(int i) {
        this.a = i;
        int i2 = 1;
        if (i > 8) {
            if (i % 8 == 0) {
                i2 = i / 8;
            } else {
                i2 = 1 + (i / 8);
            }
        }
        this.b = new byte[i2];
    }

    public boolean c(int i) {
        if (i < 0 || i >= this.a) {
            return false;
        }
        return ((1 << a(i)) & this.b[b(i)]) != 0;
    }

    public int a() {
        int i = 0;
        for (byte b : this.b) {
            while (b != 0) {
                b = (byte) (b & (b - 1));
                i++;
            }
        }
        return i;
    }

    public int b() {
        return this.a;
    }

    private int a(int i) {
        return i % 8;
    }

    private int b(int i) {
        return i / 8;
    }

    public void a(int i, boolean z) {
        if (i < 0 || i >= this.a) {
            return;
        }
        if (z) {
            byte[] bArr = this.b;
            int iB = b(i);
            bArr[iB] = (byte) ((1 << a(i)) | bArr[iB]);
            return;
        }
        byte[] bArr2 = this.b;
        int iB2 = b(i);
        bArr2[iB2] = (byte) (((1 << a(i)) ^ (-1)) & bArr2[iB2]);
    }
}
