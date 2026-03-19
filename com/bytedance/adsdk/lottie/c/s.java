package com.bytedance.adsdk.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class s {
    static com.bytedance.adsdk.lottie.model.hc.mk d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVarHc = null;
        com.bytedance.adsdk.lottie.model.d.an anVarB = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    uoVarHc = d.hc(jsonReader, anVar);
                    break;
                case "r":
                    hcVarD = c.d(jsonReader, anVar);
                    break;
                case "s":
                    anVarB = c.b(jsonReader, anVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hc.mk(strNextString, uoVarHc, anVarB, hcVarD, zNextBoolean);
    }
}
