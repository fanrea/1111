package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static com.bytedance.adsdk.lottie.model.d.mk d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.d.mk mkVarHc = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                mkVarHc = hc(jsonReader, anVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return mkVarHc == null ? new com.bytedance.adsdk.lottie.model.d.mk(null, null, null, null) : mkVarHc;
    }

    private static com.bytedance.adsdk.lottie.model.d.mk hc(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.d.d dVarH = null;
        com.bytedance.adsdk.lottie.model.d.d dVarH2 = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    hcVarD2 = c.d(jsonReader, anVar);
                    break;
                case "fc":
                    dVarH = c.h(jsonReader, anVar);
                    break;
                case "sc":
                    dVarH2 = c.h(jsonReader, anVar);
                    break;
                case "sw":
                    hcVarD = c.d(jsonReader, anVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.d.mk(dVarH, dVarH2, hcVarD, hcVarD2);
    }
}
