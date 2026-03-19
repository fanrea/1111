package com.kwad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static com.kwad.lottie.model.a.e a(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.s(jsonReader, dVar));
            }
            jsonReader.endArray();
            r.ab(arrayList);
        } else {
            arrayList.add(new com.kwad.lottie.e.a(p.e(jsonReader, com.kwad.lottie.d.f.SI())));
        }
        return new com.kwad.lottie.model.a.e(arrayList);
    }

    static com.kwad.lottie.model.a.m<PointF, PointF> b(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        jsonReader.beginObject();
        com.kwad.lottie.model.a.e eVarA = null;
        boolean z = false;
        com.kwad.lottie.model.a.b bVarF = null;
        com.kwad.lottie.model.a.b bVarF2 = null;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    eVarA = a(jsonReader, dVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        bVarF = d.f(jsonReader, dVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        bVarF2 = d.f(jsonReader, dVar);
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
            dVar.dh("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new com.kwad.lottie.model.a.i(bVarF, bVarF2);
    }
}
