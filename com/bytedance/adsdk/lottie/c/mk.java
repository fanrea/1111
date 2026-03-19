package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk {
    private com.bytedance.adsdk.lottie.model.d.hc b;
    private com.bytedance.adsdk.lottie.model.d.hc c;
    private com.bytedance.adsdk.lottie.model.d.d d;
    private com.bytedance.adsdk.lottie.model.d.hc hc;
    private com.bytedance.adsdk.lottie.model.d.hc u;

    tc d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    hc(jsonReader, anVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        if (this.d == null || this.hc == null || this.b == null || this.c == null || this.u == null) {
            return null;
        }
        return new tc(this.d, this.hc, this.b, this.c, this.u);
    }

    private void hc(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.c = c.d(jsonReader, anVar);
                        break;
                    case "Opacity":
                        this.hc = c.d(jsonReader, anVar, false);
                        break;
                    case "Direction":
                        this.b = c.d(jsonReader, anVar, false);
                        break;
                    case "Shadow Color":
                        this.d = c.h(jsonReader, anVar);
                        break;
                    case "Softness":
                        this.u = c.d(jsonReader, anVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
