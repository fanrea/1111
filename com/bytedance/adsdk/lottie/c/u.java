package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class u {
    static com.bytedance.adsdk.lottie.model.hc.d d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        com.bytedance.adsdk.lottie.model.hc.d dVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.hc.d dVarHc = hc(jsonReader, anVar);
                    if (dVarHc != null) {
                        dVar = dVarHc;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return dVar;
    }

    private static com.bytedance.adsdk.lottie.model.hc.d hc(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.hc.d dVar = null;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("v")) {
                    if (z) {
                        dVar = new com.bytedance.adsdk.lottie.model.hc.d(c.d(jsonReader, anVar));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (strNextName.equals("ty")) {
                    if (jsonReader.nextInt() == 0) {
                        z = true;
                    }
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return dVar;
        }
    }
}
