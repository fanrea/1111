package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yo implements tr<Integer> {
    public static final yo d = new yo();

    private yo() {
    }

    @Override // com.bytedance.adsdk.lottie.c.tr
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Integer hc(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(rf.hc(jsonReader) * f));
    }
}
