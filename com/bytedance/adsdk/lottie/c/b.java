package com.bytedance.adsdk.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public static com.bytedance.adsdk.lottie.model.d.mq d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.bytedance.adsdk.lottie.model.d.hc hcVar = null;
        com.bytedance.adsdk.lottie.model.d.u uVarD = null;
        com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVarHc = null;
        com.bytedance.adsdk.lottie.model.d.h hVarC = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD2 = null;
        com.bytedance.adsdk.lottie.model.d.c cVarHc = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD3 = null;
        com.bytedance.adsdk.lottie.model.d.hc hcVarD4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("k")) {
                            uVarD = d.d(jsonReader, anVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case "o":
                    cVarHc = c.hc(jsonReader, anVar);
                    continue;
                case "p":
                    uoVarHc = d.hc(jsonReader, anVar);
                    continue;
                case "r":
                    break;
                case "s":
                    hVarC = c.c(jsonReader, anVar);
                    continue;
                case "eo":
                    hcVarD4 = c.d(jsonReader, anVar, false);
                    continue;
                case "rz":
                    anVar.d("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    hcVarD2 = c.d(jsonReader, anVar, false);
                    continue;
                case "sk":
                    hcVarD = c.d(jsonReader, anVar, false);
                    continue;
                case "so":
                    hcVarD3 = c.d(jsonReader, anVar, false);
                    continue;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            com.bytedance.adsdk.lottie.model.d.hc hcVarD5 = c.d(jsonReader, anVar, false);
            if (hcVarD5.b().isEmpty()) {
                hcVarD5.b().add(new com.bytedance.adsdk.lottie.an.d(anVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(anVar.h())));
            } else if (((com.bytedance.adsdk.lottie.an.d) hcVarD5.b().get(0)).d == 0) {
                hcVarD5.b().set(0, new com.bytedance.adsdk.lottie.an.d(anVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(anVar.h())));
            }
            hcVar = hcVarD5;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (d(uVarD)) {
            uVarD = null;
        }
        return new com.bytedance.adsdk.lottie.model.d.mq(uVarD, d(uoVarHc) ? null : uoVarHc, d(hVarC) ? null : hVarC, d(hcVar) ? null : hcVar, cVarHc, hcVarD3, hcVarD4, hc(hcVarD) ? null : hcVarD, b(hcVarD2) ? null : hcVarD2);
    }

    private static boolean d(com.bytedance.adsdk.lottie.model.d.u uVar) {
        if (uVar != null) {
            return uVar.hc() && uVar.b().get(0).d.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean d(com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVar) {
        if (uoVar != null) {
            return !(uoVar instanceof com.bytedance.adsdk.lottie.model.d.tt) && uoVar.hc() && uoVar.b().get(0).d.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean d(com.bytedance.adsdk.lottie.model.d.hc hcVar) {
        if (hcVar != null) {
            return hcVar.hc() && ((Float) ((com.bytedance.adsdk.lottie.an.d) hcVar.b().get(0)).d).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean d(com.bytedance.adsdk.lottie.model.d.h hVar) {
        if (hVar != null) {
            return hVar.hc() && ((com.bytedance.adsdk.lottie.an.c) ((com.bytedance.adsdk.lottie.an.d) hVar.b().get(0)).d).hc(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean hc(com.bytedance.adsdk.lottie.model.d.hc hcVar) {
        if (hcVar != null) {
            return hcVar.hc() && ((Float) ((com.bytedance.adsdk.lottie.an.d) hcVar.b().get(0)).d).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean b(com.bytedance.adsdk.lottie.model.d.hc hcVar) {
        if (hcVar != null) {
            return hcVar.hc() && ((Float) ((com.bytedance.adsdk.lottie.an.d) hcVar.b().get(0)).d).floatValue() == 0.0f;
        }
        return true;
    }
}
