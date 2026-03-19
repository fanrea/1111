package com.kwad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import com.kwad.lottie.model.content.PolystarShape;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class z {
    static PolystarShape t(JsonReader jsonReader, com.kwad.lottie.d dVar) throws IOException {
        String strNextString = null;
        PolystarShape.Type typeForValue = null;
        com.kwad.lottie.model.a.b bVarA = null;
        com.kwad.lottie.model.a.m<PointF, PointF> mVarB = null;
        com.kwad.lottie.model.a.b bVarA2 = null;
        com.kwad.lottie.model.a.b bVarF = null;
        com.kwad.lottie.model.a.b bVarF2 = null;
        com.kwad.lottie.model.a.b bVarA3 = null;
        com.kwad.lottie.model.a.b bVarA4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    mVarB = a.b(jsonReader, dVar);
                    break;
                case "r":
                    bVarA2 = d.a(jsonReader, dVar, false);
                    break;
                case "ir":
                    bVarF = d.f(jsonReader, dVar);
                    break;
                case "is":
                    bVarA3 = d.a(jsonReader, dVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    bVarF2 = d.f(jsonReader, dVar);
                    break;
                case "os":
                    bVarA4 = d.a(jsonReader, dVar, false);
                    break;
                case "pt":
                    bVarA = d.a(jsonReader, dVar, false);
                    break;
                case "sy":
                    typeForValue = PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(strNextString, typeForValue, bVarA, mVarB, bVarA2, bVarF, bVarF2, bVarA3, bVarA4);
    }
}
