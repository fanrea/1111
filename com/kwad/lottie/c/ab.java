package com.kwad.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class ab {
    static com.kwad.lottie.model.content.g v(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.kwad.lottie.model.a.b bVarA = null;
        com.kwad.lottie.model.a.b bVarA2 = null;
        com.kwad.lottie.model.a.l lVarE = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    bVarA = d.a(jsonReader, dVar, false);
                    break;
                case "o":
                    bVarA2 = d.a(jsonReader, dVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    lVarE = c.e(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.kwad.lottie.model.content.g(strNextString, bVarA, bVarA2, lVarE);
    }
}
