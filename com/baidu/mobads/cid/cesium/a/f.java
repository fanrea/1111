package com.baidu.mobads.cid.cesium.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f {
    public static int a = 5;
    public static int b = 40;
    private b c = new b(b);

    public f() {
        this.c.a(0, b, true);
    }

    public void a(b bVar, int i, int i2, int i3) {
        b bVarC = this.c.c(i, i + i2);
        switch (i3) {
            case 0:
                bVarC.a(bVar);
                break;
            case 1:
            default:
                bVarC.c(bVar);
                break;
            case 2:
                bVarC.d(bVar);
                break;
            case 3:
                bVarC.b(bVar);
                break;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.c.a(i + i4, bVarC.c(i4));
        }
    }

    public byte[] a() {
        return this.c.a();
    }
}
