package com.kwad.lottie.c;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class ae {
    static com.kwad.lottie.model.content.i w(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        com.kwad.lottie.model.a.a aVarL = null;
        com.kwad.lottie.model.a.d dVarG = null;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    aVarL = d.l(jsonReader, dVar);
                    break;
                case "o":
                    dVarG = d.g(jsonReader, dVar);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.kwad.lottie.model.content.i(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarL, dVarG);
    }
}
