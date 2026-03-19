package com.bytedance.adsdk.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.hc.tc;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class j {
    static com.bytedance.adsdk.lottie.model.hc.tc d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, int i) throws IOException {
        boolean zNextBoolean = false;
        boolean z = i == 3;
        String strNextString = null;
        tc.d dVarD = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD = null;
        com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVarHc = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD2 = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD3 = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD4 = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD5 = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD6 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "p":
                    uoVarHc = d.hc(jsonReader, anVar);
                    break;
                case "r":
                    hcVarD2 = c.d(jsonReader, anVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ir":
                    hcVarD3 = c.d(jsonReader, anVar);
                    break;
                case "is":
                    hcVarD5 = c.d(jsonReader, anVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    hcVarD4 = c.d(jsonReader, anVar);
                    break;
                case "os":
                    hcVarD6 = c.d(jsonReader, anVar, false);
                    break;
                case "pt":
                    hcVarD = c.d(jsonReader, anVar, false);
                    break;
                case "sy":
                    dVarD = tc.d.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hc.tc(strNextString, dVarD, hcVarD, uoVarHc, hcVarD2, hcVarD3, hcVarD4, hcVarD5, hcVarD6, zNextBoolean, z);
    }
}
