package com.tachikoma.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class r {
    static <T> List<com.tachikoma.lottie.e.a<T>> a(JsonReader jsonReader, com.tachikoma.lottie.e eVar, float f, aj<T> ajVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            eVar.T("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            if (strNextName.hashCode() == 107 && strNextName.equals("k")) {
                c = 0;
            }
            if (c == 0) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(q.a(jsonReader, eVar, f, ajVar, false));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(q.a(jsonReader, eVar, f, ajVar, true));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(q.a(jsonReader, eVar, f, ajVar, false));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        i(arrayList);
        return arrayList;
    }

    public static <T> void i(List<? extends com.tachikoma.lottie.e.a<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.tachikoma.lottie.e.a<T> aVar = list.get(i2);
            i2++;
            com.tachikoma.lottie.e.a<T> aVar2 = list.get(i2);
            aVar.NJ = Float.valueOf(aVar2.GT);
            if (aVar.NH == null && aVar2.NG != null) {
                aVar.NH = aVar2.NG;
                if (aVar instanceof com.tachikoma.lottie.a.b.h) {
                    ((com.tachikoma.lottie.a.b.h) aVar).kl();
                }
            }
        }
        com.tachikoma.lottie.e.a<T> aVar3 = list.get(i);
        if ((aVar3.NG == null || aVar3.NH == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
