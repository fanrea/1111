package com.bytedance.adsdk.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class sy {
    static <T> List<com.bytedance.adsdk.lottie.an.d<T>> d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, float f, tr<T> trVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            anVar.d("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("k")) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(jh.d(jsonReader, anVar, f, trVar, false, z));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(jh.d(jsonReader, anVar, f, trVar, true, z));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(jh.d(jsonReader, anVar, f, trVar, false, z));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        d(arrayList);
        return arrayList;
    }

    public static <T> void d(List<? extends com.bytedance.adsdk.lottie.an.d<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.bytedance.adsdk.lottie.an.d<T> dVar = list.get(i2);
            i2++;
            com.bytedance.adsdk.lottie.an.d<T> dVar2 = list.get(i2);
            dVar.h = Float.valueOf(dVar2.an);
            if (dVar.hc == null && dVar2.d != null) {
                dVar.hc = dVar2.d;
                if (dVar instanceof com.bytedance.adsdk.lottie.d.hc.tt) {
                    ((com.bytedance.adsdk.lottie.d.hc.tt) dVar).d();
                }
            }
        }
        com.bytedance.adsdk.lottie.an.d<T> dVar3 = list.get(i);
        if ((dVar3.d == null || dVar3.hc == null) && list.size() > 1) {
            list.remove(dVar3);
        }
    }
}
