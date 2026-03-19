package com.tachikoma.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class e {
    static com.tachikoma.lottie.model.content.a b(JsonReader jsonReader, com.tachikoma.lottie.e eVar, int i) throws IOException {
        boolean z = i == 3;
        String strNextString = null;
        com.tachikoma.lottie.model.a.m<PointF, PointF> mVarB = null;
        com.tachikoma.lottie.model.a.f fVarH = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 100) {
                if (iHashCode != 112) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3324) {
                            if (iHashCode == 3519 && strNextName.equals("nm")) {
                                c = 0;
                            }
                        } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                            c = 3;
                        }
                    } else if (strNextName.equals("s")) {
                        c = 2;
                    }
                } else if (strNextName.equals("p")) {
                    c = 1;
                }
            } else if (strNextName.equals("d")) {
                c = 4;
            }
            if (c == 0) {
                strNextString = jsonReader.nextString();
            } else if (c == 1) {
                mVarB = a.b(jsonReader, eVar);
            } else if (c == 2) {
                fVarH = d.h(jsonReader, eVar);
            } else if (c == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c == 4) {
                z = jsonReader.nextInt() == 3;
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.tachikoma.lottie.model.content.a(strNextString, mVarB, fVarH, z, zNextBoolean);
    }
}
