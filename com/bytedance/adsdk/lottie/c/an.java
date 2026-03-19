package com.bytedance.adsdk.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class an {
    static com.bytedance.adsdk.lottie.model.hc.hc d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, int i) throws IOException {
        boolean z = i == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVarHc = null;
        com.bytedance.adsdk.lottie.model.d.an anVarB = null;
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
        return new com.bytedance.adsdk.lottie.model.hc.hc(strNextString, uoVarHc, anVarB, z, zNextBoolean);
    }
}
