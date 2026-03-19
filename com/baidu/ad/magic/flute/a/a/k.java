package com.baidu.ad.magic.flute.a.a;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k {
    private int a = d.j;
    private byte[] b = new byte[this.a];
    private int c;

    private void a(int i) {
        if (i - this.b.length > 0) {
            int length = this.b.length;
            int i2 = length + (length >> 1);
            if (i2 - i >= 0) {
                i = i2;
            }
            this.b = Arrays.copyOf(this.b, i);
        }
    }

    public j a() {
        return new j(Arrays.copyOf(this.b, this.c));
    }

    public k a(byte b) {
        a(this.c + 1);
        byte[] bArr = this.b;
        int i = this.c;
        this.c = i + 1;
        bArr[i] = b;
        return this;
    }
}
