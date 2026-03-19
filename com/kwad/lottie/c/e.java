package com.kwad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class e {
    static com.kwad.lottie.model.content.a b(JsonReader jsonReader, com.kwad.lottie.d dVar, int i) throws IOException {
        boolean z = i == 3;
        String strNextString = null;
        com.kwad.lottie.model.a.m<PointF, PointF> mVarB = null;
        com.kwad.lottie.model.a.f fVarH = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "p":
                    mVarB = a.b(jsonReader, dVar);
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
        return new com.kwad.lottie.model.content.a(strNextString, mVarB, fVarH, z);
    }
}
