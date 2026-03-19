package com.kwad.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static com.kwad.lottie.model.a.k c(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.kwad.lottie.model.a.k kVarD = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                kVarD = d(jsonReader, dVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return kVarD == null ? new com.kwad.lottie.model.a.k(null, null, null, null) : kVarD;
    }

    private static com.kwad.lottie.model.a.k d(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.kwad.lottie.model.a.a aVarL = null;
        com.kwad.lottie.model.a.a aVarL2 = null;
        com.kwad.lottie.model.a.b bVarF = null;
        com.kwad.lottie.model.a.b bVarF2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    bVarF2 = d.f(jsonReader, dVar);
                    break;
                case "fc":
                    aVarL = d.l(jsonReader, dVar);
                    break;
                case "sc":
                    aVarL2 = d.l(jsonReader, dVar);
                    break;
                case "sw":
                    bVarF = d.f(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.kwad.lottie.model.a.k(aVarL, aVarL2, bVarF, bVarF2);
    }
}
