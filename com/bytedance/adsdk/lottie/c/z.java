package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class z {
    static com.bytedance.adsdk.lottie.model.hc.uo d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "r":
                    hcVarD = c.d(jsonReader, anVar, true);
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
        if (zNextBoolean) {
            return null;
        }
        return new com.bytedance.adsdk.lottie.model.hc.uo(strNextString, hcVarD);
    }
}
