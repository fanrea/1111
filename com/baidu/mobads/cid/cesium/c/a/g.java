package com.baidu.mobads.cid.cesium.c.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    private static volatile byte[] a;

    public static byte[] a() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(com.baidu.mobads.cid.cesium.c.c.b.b(), 0, bArr, 0, 16);
                    c cVar = new c();
                    cVar.a(2, bArr, bArr);
                    a = cVar.a(new byte[]{-71, -100, -115, 26, 39, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, com.sigmob.sdk.archives.tar.e.f789K, 46, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, com.sigmob.sdk.archives.tar.e.J});
                }
            }
        }
        return a;
    }
}
