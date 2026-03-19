package com.kwad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class aa {
    static com.kwad.lottie.model.content.f u(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.kwad.lottie.model.a.m<PointF, PointF> mVarB = null;
        com.kwad.lottie.model.a.f fVarH = null;
        com.kwad.lottie.model.a.b bVarF = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    mVarB = a.b(jsonReader, dVar);
                    break;
                case "r":
                    bVarF = d.f(jsonReader, dVar);
                    break;
                case "s":
                    fVarH = d.h(jsonReader, dVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.kwad.lottie.model.content.f(strNextString, mVarB, fVarH, bVarF);
    }
}
