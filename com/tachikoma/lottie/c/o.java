package com.tachikoma.lottie.c;

import android.util.JsonReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class o implements aj<Integer> {
    public static final o Nj = new o();

    @Override // com.tachikoma.lottie.c.aj
    public final /* synthetic */ Integer a(JsonReader jsonReader, float f) {
        return c(jsonReader, f);
    }

    private o() {
    }

    private static Integer c(JsonReader jsonReader, float f) {
        return Integer.valueOf(Math.round(p.f(jsonReader) * f));
    }
}
