package com.bytedance.adsdk.lottie.c;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class mt {
    static com.bytedance.adsdk.lottie.model.hc.e d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        com.bytedance.adsdk.lottie.model.d.c cVar = null;
        int iNextInt = 1;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.d.d dVarH = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    dVarH = c.h(jsonReader, anVar);
                    break;
                case "o":
                    cVar = c.hc(jsonReader, anVar);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (cVar == null) {
            cVar = new com.bytedance.adsdk.lottie.model.d.c(Collections.singletonList(new com.bytedance.adsdk.lottie.an.d(100)));
        }
        return new com.bytedance.adsdk.lottie.model.hc.e(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, dVarH, cVar, zNextBoolean2);
    }
}
