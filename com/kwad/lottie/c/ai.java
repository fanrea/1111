package com.kwad.lottie.c;

import android.util.JsonReader;
import com.kwad.lottie.model.content.ShapeTrimPath;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class ai {
    static ShapeTrimPath A(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        String strNextString = null;
        ShapeTrimPath.Type typeForId = null;
        com.kwad.lottie.model.a.b bVarA = null;
        com.kwad.lottie.model.a.b bVarA2 = null;
        com.kwad.lottie.model.a.b bVarA3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    bVarA2 = d.a(jsonReader, dVar, false);
                    break;
                case "m":
                    typeForId = ShapeTrimPath.Type.forId(jsonReader.nextInt());
                    break;
                case "o":
                    bVarA3 = d.a(jsonReader, dVar, false);
                    break;
                case "s":
                    bVarA = d.a(jsonReader, dVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeTrimPath(strNextString, typeForId, bVarA, bVarA2, bVarA3);
    }
}
