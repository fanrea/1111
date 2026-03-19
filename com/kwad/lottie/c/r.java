package com.kwad.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class r {
    static <T> List<com.kwad.lottie.e.a<T>> a(JsonReader jsonReader, com.kwad.lottie.d dVar, float f, aj<T> ajVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            dVar.dh("Lottie doesn't support expressions.");
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
                        arrayList.add(q.a(jsonReader, dVar, f, ajVar, false));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(q.a(jsonReader, dVar, f, ajVar, true));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(q.a(jsonReader, dVar, f, ajVar, false));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        ab(arrayList);
        return arrayList;
    }

    public static void ab(List<? extends com.kwad.lottie.e.a<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.kwad.lottie.e.a<?> aVar = list.get(i2);
            i2++;
            aVar.bpQ = Float.valueOf(list.get(i2).bjS);
        }
        com.kwad.lottie.e.a<?> aVar2 = list.get(i);
        if (aVar2.bpN == 0) {
            list.remove(aVar2);
        }
    }
}
