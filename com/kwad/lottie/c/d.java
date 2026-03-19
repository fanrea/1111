package com.kwad.lottie.c;

import android.util.JsonReader;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    public static com.kwad.lottie.model.a.b f(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        return a(jsonReader, dVar, true);
    }

    public static com.kwad.lottie.model.a.b a(JsonReader jsonReader, com.kwad.lottie.d dVar, boolean z) {
        return new com.kwad.lottie.model.a.b(a(jsonReader, z ? com.kwad.lottie.d.f.SI() : 1.0f, dVar, i.bpr));
    }

    static com.kwad.lottie.model.a.d g(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        return new com.kwad.lottie.model.a.d(a(jsonReader, dVar, o.bpt));
    }

    static com.kwad.lottie.model.a.f h(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        return new com.kwad.lottie.model.a.f(a(jsonReader, com.kwad.lottie.d.f.SI(), dVar, y.bpx));
    }

    static com.kwad.lottie.model.a.g i(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        return new com.kwad.lottie.model.a.g((List<com.kwad.lottie.e.a<com.kwad.lottie.e.d>>) a(jsonReader, dVar, ac.bpy));
    }

    static com.kwad.lottie.model.a.h j(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        return new com.kwad.lottie.model.a.h(a(jsonReader, com.kwad.lottie.d.f.SI(), dVar, ad.bpz));
    }

    static com.kwad.lottie.model.a.j k(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        return new com.kwad.lottie.model.a.j(a(jsonReader, dVar, h.bpq));
    }

    static com.kwad.lottie.model.a.a l(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        return new com.kwad.lottie.model.a.a(a(jsonReader, dVar, f.bpp));
    }

    static com.kwad.lottie.model.a.c a(JsonReader jsonReader, com.kwad.lottie.d dVar, int i) {
        return new com.kwad.lottie.model.a.c(a(jsonReader, dVar, new l(i)));
    }

    private static <T> List<com.kwad.lottie.e.a<T>> a(JsonReader jsonReader, com.kwad.lottie.d dVar, aj<T> ajVar) {
        return r.a(jsonReader, dVar, 1.0f, ajVar);
    }

    private static <T> List<com.kwad.lottie.e.a<T>> a(JsonReader jsonReader, float f, com.kwad.lottie.d dVar, aj<T> ajVar) {
        return r.a(jsonReader, dVar, f, ajVar);
    }
}
