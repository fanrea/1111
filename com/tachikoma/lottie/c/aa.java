package com.tachikoma.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class aa {
    static com.tachikoma.lottie.model.content.f u(JsonReader jsonReader, com.tachikoma.lottie.e eVar) throws IOException {
        String strNextString = null;
        com.tachikoma.lottie.model.a.m<PointF, PointF> mVarB = null;
        com.tachikoma.lottie.model.a.f fVarH = null;
        com.tachikoma.lottie.model.a.b bVarF = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 112) {
                if (iHashCode != 3324) {
                    if (iHashCode != 3519) {
                        if (iHashCode != 114) {
                            if (iHashCode == 115 && strNextName.equals("s")) {
                                c = 2;
                            }
                        } else if (strNextName.equals(com.kuaishou.weapon.p0.t.k)) {
                            c = 3;
                        }
                    } else if (strNextName.equals("nm")) {
                        c = 0;
                    }
                } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                    c = 4;
                }
            } else if (strNextName.equals("p")) {
                c = 1;
            }
            if (c == 0) {
                strNextString = jsonReader.nextString();
            } else if (c == 1) {
                mVarB = a.b(jsonReader, eVar);
            } else if (c == 2) {
                fVarH = d.h(jsonReader, eVar);
            } else if (c == 3) {
                bVarF = d.f(jsonReader, eVar);
            } else if (c == 4) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.tachikoma.lottie.model.content.f(strNextString, mVarB, fVarH, bVarF, zNextBoolean);
    }
}
