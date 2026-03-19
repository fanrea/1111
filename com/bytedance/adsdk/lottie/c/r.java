package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class r {
    static com.bytedance.adsdk.lottie.model.hc.cb d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.hc.b bVarD = gb.d(jsonReader, anVar);
                        if (bVarD != null) {
                            arrayList.add(bVarD);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hc.cb(strNextString, arrayList, zNextBoolean);
    }
}
