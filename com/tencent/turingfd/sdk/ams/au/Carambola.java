package com.tencent.turingfd.sdk.ams.au;

import java.io.UnsupportedEncodingException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Carambola extends Equuleus implements Cloneable {
    public int a = 0;
    public String b = "";
    public int c = 0;
    public int d = 0;
    public String e = "";
    public long f = 0;

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Eridanus eridanus) throws UnsupportedEncodingException {
        eridanus.a(this.a, 0);
        eridanus.a(this.b, 1);
        int i = this.c;
        if (i != 0) {
            eridanus.a(i, 3);
        }
        int i2 = this.d;
        if (i2 != 0) {
            eridanus.a(i2, 4);
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Draco draco) {
        this.a = draco.a(this.a, 0, true);
        this.b = draco.b(1, true);
        this.c = draco.a(this.c, 3, false);
        this.d = draco.a(this.d, 4, false);
        this.e = draco.b(5, false);
        this.f = draco.a(this.f, 6, false);
    }
}
