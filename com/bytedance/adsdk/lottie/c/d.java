package com.bytedance.adsdk.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static com.bytedance.adsdk.lottie.model.d.u d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(he.d(jsonReader, anVar));
            }
            jsonReader.endArray();
            sy.d(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.lottie.an.d(rf.hc(jsonReader, com.bytedance.adsdk.lottie.u.tt.d())));
        }
        return new com.bytedance.adsdk.lottie.model.d.u(arrayList);
    }

    static com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> hc(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.d.u uVarD = null;
        boolean z = false;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD2 = null;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    uVarD = d(jsonReader, anVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        hcVarD = c.d(jsonReader, anVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        hcVarD2 = c.d(jsonReader, anVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            anVar.d("Lottie doesn't support expressions.");
        }
        return uVarD != null ? uVarD : new com.bytedance.adsdk.lottie.model.d.tt(hcVarD, hcVarD2);
    }
}
