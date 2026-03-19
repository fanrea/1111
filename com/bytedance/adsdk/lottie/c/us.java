package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class us {
    static com.bytedance.adsdk.lottie.model.hc.mq d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD2 = null;
        com.bytedance.adsdk.lottie.model.d.mq mqVarD = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    hcVarD = c.d(jsonReader, anVar, false);
                    break;
                case "o":
                    hcVarD2 = c.d(jsonReader, anVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    mqVarD = b.d(jsonReader, anVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hc.mq(strNextString, hcVarD, hcVarD2, mqVarD, zNextBoolean);
    }
}
