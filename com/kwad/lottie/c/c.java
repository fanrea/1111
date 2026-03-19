package com.kwad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    public static com.kwad.lottie.model.a.l e(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.kwad.lottie.model.a.e eVar = null;
        com.kwad.lottie.model.a.g gVar = null;
        com.kwad.lottie.model.a.d dVar2 = null;
        com.kwad.lottie.model.a.m<PointF, PointF> mVarB = null;
        com.kwad.lottie.model.a.b bVarA = null;
        com.kwad.lottie.model.a.b bVarA2 = null;
        com.kwad.lottie.model.a.b bVarA3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            eVar = a.a(jsonReader, dVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case "o":
                    dVar2 = d.g(jsonReader, dVar);
                    continue;
                case "p":
                    mVarB = a.b(jsonReader, dVar);
                    continue;
                case "r":
                    break;
                case "s":
                    gVar = d.i(jsonReader, dVar);
                    continue;
                case "eo":
                    bVarA3 = d.a(jsonReader, dVar, false);
                    continue;
                case "rz":
                    dVar.dh("Lottie doesn't support 3D layers.");
                    break;
                case "so":
                    bVarA2 = d.a(jsonReader, dVar, false);
                    continue;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            bVarA = d.a(jsonReader, dVar, false);
        }
        if (z) {
            jsonReader.endObject();
        }
        if (eVar == null) {
            Log.w(com.component.lottie.c.b, "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            eVar = new com.kwad.lottie.model.a.e();
        }
        com.kwad.lottie.model.a.e eVar2 = eVar;
        if (gVar == null) {
            gVar = new com.kwad.lottie.model.a.g(new com.kwad.lottie.e.d(1.0f, 1.0f));
        }
        com.kwad.lottie.model.a.g gVar2 = gVar;
        if (dVar2 == null) {
            dVar2 = new com.kwad.lottie.model.a.d();
        }
        return new com.kwad.lottie.model.a.l(eVar2, mVarB, gVar2, bVarA, dVar2, bVarA2, bVarA3);
    }
}
