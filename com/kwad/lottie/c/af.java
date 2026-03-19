package com.kwad.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class af {
    static com.kwad.lottie.model.content.j x(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("it")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.kwad.lottie.model.content.b bVarM = g.m(jsonReader, dVar);
                    if (bVarM != null) {
                        arrayList.add(bVarM);
                    }
                }
                jsonReader.endArray();
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.kwad.lottie.model.content.j(strNextString, arrayList);
    }
}
