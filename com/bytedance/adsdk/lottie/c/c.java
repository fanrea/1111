package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static com.bytedance.adsdk.lottie.model.d.hc d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        return d(jsonReader, anVar, true);
    }

    public static com.bytedance.adsdk.lottie.model.d.hc d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, boolean z) throws IOException {
        return new com.bytedance.adsdk.lottie.model.d.hc(d(jsonReader, z ? com.bytedance.adsdk.lottie.u.tt.d() : 1.0f, anVar, mq.d));
    }

    static com.bytedance.adsdk.lottie.model.d.c hc(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.d.c(d(jsonReader, anVar, yo.d));
    }

    static com.bytedance.adsdk.lottie.model.d.an b(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.d.an(sy.d(jsonReader, anVar, com.bytedance.adsdk.lottie.u.tt.d(), zw.d, true));
    }

    static com.bytedance.adsdk.lottie.model.d.h c(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.d.h(d(jsonReader, anVar, fs.d));
    }

    static com.bytedance.adsdk.lottie.model.d.gb u(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.d.gb(d(jsonReader, com.bytedance.adsdk.lottie.u.tt.d(), anVar, ba.d));
    }

    static com.bytedance.adsdk.lottie.model.d.tc an(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.d.tc(d(jsonReader, com.bytedance.adsdk.lottie.u.tt.d(), anVar, tt.d));
    }

    static com.bytedance.adsdk.lottie.model.d.d h(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.d.d(d(jsonReader, anVar, h.d));
    }

    static com.bytedance.adsdk.lottie.model.d.b d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, int i) throws IOException {
        return new com.bytedance.adsdk.lottie.model.d.b(d(jsonReader, anVar, new e(i)));
    }

    private static <T> List<com.bytedance.adsdk.lottie.an.d<T>> d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, tr<T> trVar) throws IOException {
        return sy.d(jsonReader, anVar, 1.0f, trVar, false);
    }

    private static <T> List<com.bytedance.adsdk.lottie.an.d<T>> d(JsonReader jsonReader, float f, com.bytedance.adsdk.lottie.an anVar, tr<T> trVar) throws IOException {
        return sy.d(jsonReader, anVar, f, trVar, false);
    }
}
