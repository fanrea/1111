package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Filbert extends Equuleus {
    public int a = 0;
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = 0.0f;
    public float e = 0.0f;

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Eridanus eridanus) {
        eridanus.a(this.a, 0);
        eridanus.a(this.b, 1);
        eridanus.a(this.c, 2);
        float f = this.d;
        if (f != 0.0f) {
            eridanus.a(f, 3);
        }
        float f2 = this.e;
        if (f2 != 0.0f) {
            eridanus.a(f2, 4);
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Draco draco) {
        this.a = draco.a(this.a, 0, true);
        this.b = draco.a(this.b, 1, true);
        this.c = draco.a(this.c, 2, true);
        this.d = draco.a(this.d, 3, false);
        this.e = draco.a(this.e, 4, false);
    }
}
