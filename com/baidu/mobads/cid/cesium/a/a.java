package com.baidu.mobads.cid.cesium.a;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    g[] a = {new h(8, 0), new i(0, 1), new i(1, 1), new h(7, 1)};

    public byte[] a(byte[] bArr) {
        f fVar = new f();
        byte[] bArrA = c.a(bArr, bArr.length + ((this.a.length + 1) * f.a));
        c.a(bArrA, fVar.a(), bArr.length);
        int i = 0;
        while (i < this.a.length) {
            g gVar = this.a[i];
            i++;
            int length = bArr.length + (f.a * i);
            fVar.a(gVar.a(bArrA, 0, length), gVar.a(), gVar.b(), gVar.c());
            c.a(bArrA, fVar.a(), length);
        }
        return Arrays.copyOf(fVar.a(), f.a);
    }
}
