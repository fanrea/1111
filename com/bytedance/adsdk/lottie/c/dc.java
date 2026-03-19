package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.hc.rf;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class dc {
    static com.bytedance.adsdk.lottie.model.hc.rf d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        rf.d dVarD = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD2 = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    hcVarD2 = c.d(jsonReader, anVar, false);
                    break;
                case "m":
                    dVarD = rf.d.d(jsonReader.nextInt());
                    break;
                case "o":
                    hcVarD3 = c.d(jsonReader, anVar, false);
                    break;
                case "s":
                    hcVarD = c.d(jsonReader, anVar, false);
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
        return new com.bytedance.adsdk.lottie.model.hc.rf(strNextString, dVarD, hcVarD, hcVarD2, hcVarD3, zNextBoolean);
    }
}
