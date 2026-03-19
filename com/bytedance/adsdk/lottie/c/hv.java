package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class hv {
    static com.bytedance.adsdk.lottie.model.hc.w d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.d.gb gbVarU = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ks":
                    gbVarU = c.u(jsonReader, anVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hc.w(strNextString, iNextInt, gbVarU, zNextBoolean);
    }
}
