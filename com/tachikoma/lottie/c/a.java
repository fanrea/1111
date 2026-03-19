package com.tachikoma.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    public static com.tachikoma.lottie.model.a.e a(JsonReader jsonReader, com.tachikoma.lottie.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.s(jsonReader, eVar));
            }
            jsonReader.endArray();
            r.i(arrayList);
        } else {
            arrayList.add(new com.tachikoma.lottie.e.a(p.e(jsonReader, com.tachikoma.lottie.d.f.mf())));
        }
        return new com.tachikoma.lottie.model.a.e(arrayList);
    }

    static com.tachikoma.lottie.model.a.m<PointF, PointF> b(JsonReader jsonReader, com.tachikoma.lottie.e eVar) {
        jsonReader.beginObject();
        com.tachikoma.lottie.model.a.e eVarA = null;
        com.tachikoma.lottie.model.a.b bVarF = null;
        com.tachikoma.lottie.model.a.b bVarF2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 107) {
                if (iHashCode != 120) {
                    if (iHashCode == 121 && strNextName.equals("y")) {
                        c = 2;
                    }
                } else if (strNextName.equals("x")) {
                    c = 1;
                }
            } else if (strNextName.equals("k")) {
                c = 0;
            }
            if (c == 0) {
                eVarA = a(jsonReader, eVar);
            } else {
                if (c != 1) {
                    if (c == 2) {
                        if (jsonReader.peek() == JsonToken.STRING) {
                            z = true;
                        } else {
                            bVarF2 = d.f(jsonReader, eVar);
                        }
                    }
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    z = true;
                } else {
                    bVarF = d.f(jsonReader, eVar);
                }
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (z) {
            eVar.T("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new com.tachikoma.lottie.model.a.i(bVarF, bVarF2);
    }
}
