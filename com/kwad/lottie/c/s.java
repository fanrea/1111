package com.kwad.lottie.c;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.baidu.mobstat.forbes.Config;
import com.kwad.lottie.model.layer.Layer;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class s {
    public static Layer c(com.kwad.lottie.d dVar) {
        Rect bounds = dVar.getBounds();
        return new Layer(Collections.emptyList(), dVar, "__container", -1L, Layer.LayerType.PreComp, -1L, null, Collections.emptyList(), new com.kwad.lottie.model.a.l(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), Layer.MatteType.None, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Layer q(JsonReader jsonReader, com.kwad.lottie.d dVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f;
        Layer.MatteType matteType = Layer.MatteType.None;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        float fNextDouble = 1.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        int iNextInt3 = 0;
        int iNextInt4 = 0;
        Layer.LayerType layerType = null;
        String strNextString = null;
        com.kwad.lottie.model.a.l lVarE = null;
        com.kwad.lottie.model.a.j jVarK = null;
        com.kwad.lottie.model.a.k kVarC = null;
        com.kwad.lottie.model.a.b bVarA = null;
        long jNextInt = 0;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        long jNextInt2 = -1;
        String strNextString2 = null;
        String strNextString3 = "UNSET";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            char c = 65535;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        c = 0;
                        break;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        c = 1;
                        break;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        c = 2;
                        break;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        c = 3;
                        break;
                    }
                    break;
                case 119:
                    if (strNextName.equals("w")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3432:
                    if (strNextName.equals("ks")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3553:
                    if (strNextName.equals(Config.OPERATOR)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 3664:
                    if (strNextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c = 11;
                        break;
                    }
                    break;
                case 3669:
                    if (strNextName.equals("sh")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 3681:
                    if (strNextName.equals(Config.STAT_SDK_TYPE)) {
                        c = 14;
                        break;
                    }
                    break;
                case 3684:
                    if (strNextName.equals(com.baidu.mobads.container.adrequest.g.f719K)) {
                        c = 15;
                        break;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        c = 16;
                        break;
                    }
                    break;
                case 3712:
                    if (strNextName.equals("tt")) {
                        c = 17;
                        break;
                    }
                    break;
                case 3717:
                    if (strNextName.equals("ty")) {
                        c = 18;
                        break;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        c = 19;
                        break;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        c = 21;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    continue;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.kwad.lottie.model.content.b bVarM = g.m(jsonReader, dVar);
                        if (bVarM != null) {
                            arrayList4.add(bVarM);
                        }
                    }
                    jsonReader.endArray();
                    continue;
                case 2:
                    iNextInt4 = (int) (jsonReader.nextInt() * com.kwad.lottie.d.f.SI());
                    continue;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                kVarC = b.c(jsonReader, dVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals("d")) {
                            jVarK = d.k(jsonReader, dVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case 4:
                    iNextInt3 = (int) (jsonReader.nextInt() * com.kwad.lottie.d.f.SI());
                    continue;
                case 5:
                    strNextString2 = jsonReader.nextString();
                    continue;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList5.add(jsonReader.nextString());
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    dVar.dh("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    continue;
                case 7:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                case '\b':
                    lVarE = c.e(jsonReader, dVar);
                    continue;
                case '\t':
                    strNextString3 = jsonReader.nextString();
                    continue;
                case '\n':
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                case 11:
                    color = Color.parseColor(jsonReader.nextString());
                    continue;
                case '\f':
                    iNextInt2 = (int) (jsonReader.nextInt() * com.kwad.lottie.d.f.SI());
                    continue;
                case '\r':
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                case 14:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    continue;
                case 15:
                    iNextInt = (int) (jsonReader.nextInt() * com.kwad.lottie.d.f.SI());
                    continue;
                case 16:
                    bVarA = d.a(jsonReader, dVar, false);
                    continue;
                case 17:
                    matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                    continue;
                case 18:
                    int iNextInt5 = jsonReader.nextInt();
                    if (iNextInt5 < Layer.LayerType.Unknown.ordinal()) {
                        layerType = Layer.LayerType.values()[iNextInt5];
                    } else {
                        layerType = Layer.LayerType.Unknown;
                        continue;
                    }
                case 19:
                    jNextInt = jsonReader.nextInt();
                    continue;
                case 20:
                    strNextString = jsonReader.nextString();
                    continue;
                case 21:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList3.add(u.r(jsonReader, dVar));
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        float f2 = fNextDouble2 / fNextDouble;
        float fQf = fNextDouble3 / fNextDouble;
        ArrayList arrayList6 = new ArrayList();
        if (f2 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new com.kwad.lottie.e.a(dVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f2)));
            f = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f = 0.0f;
        }
        if (fQf <= f) {
            fQf = dVar.Qf();
        }
        arrayList2.add(new com.kwad.lottie.e.a(dVar, fValueOf, fValueOf, null, f2, Float.valueOf(fQf)));
        arrayList2.add(new com.kwad.lottie.e.a(dVar, fValueOf2, fValueOf2, null, fQf, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString3.endsWith(".ai") || "ai".equals(strNextString2)) {
            dVar.dh("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, dVar, strNextString3, jNextInt, layerType, jNextInt2, strNextString, arrayList, lVarE, iNextInt, iNextInt2, color, fNextDouble, fNextDouble4, iNextInt3, iNextInt4, jVarK, kVarC, arrayList2, matteType2, bVarA);
    }
}
