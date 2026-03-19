package com.kwad.lottie.c;

import android.util.JsonReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i implements aj<Float> {
    public static final i bpr = new i();

    @Override // com.kwad.lottie.c.aj
    public final /* synthetic */ Float a(JsonReader jsonReader, float f) {
        return b(jsonReader, f);
    }

    private i() {
    }

    private static Float b(JsonReader jsonReader, float f) {
        return Float.valueOf(p.f(jsonReader) * f);
    }
}
