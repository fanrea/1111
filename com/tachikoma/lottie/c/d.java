package com.tachikoma.lottie.c;

import android.util.JsonReader;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    public static com.tachikoma.lottie.model.a.b f(JsonReader jsonReader, com.tachikoma.lottie.e eVar) {
        return a(jsonReader, eVar, true);
    }

    public static com.tachikoma.lottie.model.a.b a(JsonReader jsonReader, com.tachikoma.lottie.e eVar, boolean z) {
        return new com.tachikoma.lottie.model.a.b(a(jsonReader, z ? com.tachikoma.lottie.d.f.mf() : 1.0f, eVar, i.Nh));
    }

    static com.tachikoma.lottie.model.a.d g(JsonReader jsonReader, com.tachikoma.lottie.e eVar) {
        return new com.tachikoma.lottie.model.a.d(a(jsonReader, eVar, o.Nj));
    }

    static com.tachikoma.lottie.model.a.f h(JsonReader jsonReader, com.tachikoma.lottie.e eVar) {
        return new com.tachikoma.lottie.model.a.f(a(jsonReader, com.tachikoma.lottie.d.f.mf(), eVar, y.No));
    }

    static com.tachikoma.lottie.model.a.g i(JsonReader jsonReader, com.tachikoma.lottie.e eVar) {
        return new com.tachikoma.lottie.model.a.g((List<com.tachikoma.lottie.e.a<com.tachikoma.lottie.e.d>>) a(jsonReader, eVar, ac.Np));
    }

    static com.tachikoma.lottie.model.a.h j(JsonReader jsonReader, com.tachikoma.lottie.e eVar) {
        return new com.tachikoma.lottie.model.a.h(a(jsonReader, com.tachikoma.lottie.d.f.mf(), eVar, ad.Nq));
    }

    static com.tachikoma.lottie.model.a.j k(JsonReader jsonReader, com.tachikoma.lottie.e eVar) {
        return new com.tachikoma.lottie.model.a.j(a(jsonReader, eVar, h.Ng));
    }

    static com.tachikoma.lottie.model.a.a l(JsonReader jsonReader, com.tachikoma.lottie.e eVar) {
        return new com.tachikoma.lottie.model.a.a(a(jsonReader, eVar, f.Nf));
    }

    static com.tachikoma.lottie.model.a.c a(JsonReader jsonReader, com.tachikoma.lottie.e eVar, int i) {
        return new com.tachikoma.lottie.model.a.c(a(jsonReader, eVar, new l(i)));
    }

    private static <T> List<com.tachikoma.lottie.e.a<T>> a(JsonReader jsonReader, com.tachikoma.lottie.e eVar, aj<T> ajVar) {
        return r.a(jsonReader, eVar, 1.0f, ajVar);
    }

    private static <T> List<com.tachikoma.lottie.e.a<T>> a(JsonReader jsonReader, float f, com.tachikoma.lottie.e eVar, aj<T> ajVar) {
        return r.a(jsonReader, eVar, f, ajVar);
    }
}
