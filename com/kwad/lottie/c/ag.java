package com.kwad.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class ag {
    static com.kwad.lottie.model.content.k y(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        String strNextString = null;
        int iNextInt = 0;
        com.kwad.lottie.model.a.h hVarJ = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "ks":
                    hVarJ = d.j(jsonReader, dVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.kwad.lottie.model.content.k(strNextString, iNextInt, hVarJ);
    }
}
