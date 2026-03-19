package com.tachikoma.lottie.c;

import android.util.JsonReader;
import com.baidu.mobstat.forbes.Config;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    public static com.tachikoma.lottie.model.a.k c(JsonReader jsonReader, com.tachikoma.lottie.e eVar) throws IOException {
        jsonReader.beginObject();
        com.tachikoma.lottie.model.a.k kVarD = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            if (strNextName.hashCode() == 97 && strNextName.equals("a")) {
                c = 0;
            }
            if (c == 0) {
                kVarD = d(jsonReader, eVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return kVarD == null ? new com.tachikoma.lottie.model.a.k(null, null, null, null) : kVarD;
    }

    private static com.tachikoma.lottie.model.a.k d(JsonReader jsonReader, com.tachikoma.lottie.e eVar) throws IOException {
        jsonReader.beginObject();
        com.tachikoma.lottie.model.a.a aVarL = null;
        com.tachikoma.lottie.model.a.a aVarL2 = null;
        com.tachikoma.lottie.model.a.b bVarF = null;
        com.tachikoma.lottie.model.a.b bVarF2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 116) {
                if (iHashCode != 3261) {
                    if (iHashCode != 3664) {
                        if (iHashCode == 3684 && strNextName.equals(com.baidu.mobads.container.adrequest.g.f719K)) {
                            c = 2;
                        }
                    } else if (strNextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c = 1;
                    }
                } else if (strNextName.equals("fc")) {
                    c = 0;
                }
            } else if (strNextName.equals("t")) {
                c = 3;
            }
            if (c == 0) {
                aVarL = d.l(jsonReader, eVar);
            } else if (c == 1) {
                aVarL2 = d.l(jsonReader, eVar);
            } else if (c == 2) {
                bVarF = d.f(jsonReader, eVar);
            } else if (c == 3) {
                bVarF2 = d.f(jsonReader, eVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new com.tachikoma.lottie.model.a.k(aVarL, aVarL2, bVarF, bVarF2);
    }
}
