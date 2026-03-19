package com.tachikoma.lottie.c;

import android.util.JsonReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i implements aj<Float> {
    public static final i Nh = new i();

    @Override // com.tachikoma.lottie.c.aj
    public final /* synthetic */ Float a(JsonReader jsonReader, float f) {
        return b(jsonReader, f);
    }

    private i() {
    }

    private static Float b(JsonReader jsonReader, float f) {
        return Float.valueOf(p.f(jsonReader) * f);
    }
}
