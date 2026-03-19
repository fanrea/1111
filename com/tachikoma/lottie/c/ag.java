package com.tachikoma.lottie.c;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class ag {
    static com.tachikoma.lottie.model.content.k y(JsonReader jsonReader, com.tachikoma.lottie.e eVar) throws IOException {
        String strNextString = null;
        com.tachikoma.lottie.model.a.h hVarJ = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3432) {
                    if (iHashCode != 3519) {
                        if (iHashCode == 104415 && strNextName.equals("ind")) {
                            c = 1;
                        }
                    } else if (strNextName.equals("nm")) {
                        c = 0;
                    }
                } else if (strNextName.equals("ks")) {
                    c = 2;
                }
            } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                c = 3;
            }
            if (c == 0) {
                strNextString = jsonReader.nextString();
            } else if (c == 1) {
                iNextInt = jsonReader.nextInt();
            } else if (c == 2) {
                hVarJ = d.j(jsonReader, eVar);
            } else if (c == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.tachikoma.lottie.model.content.k(strNextString, iNextInt, hVarJ, zNextBoolean);
    }
}
