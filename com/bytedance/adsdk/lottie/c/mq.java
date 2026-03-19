package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq implements tr<Float> {
    public static final mq d = new mq();

    private mq() {
    }

    @Override // com.bytedance.adsdk.lottie.c.tr
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float hc(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(rf.hc(jsonReader) * f);
    }
}
