package com.tachikoma.lottie.c;

import android.util.JsonReader;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class ab {
    static com.tachikoma.lottie.model.content.g v(JsonReader jsonReader, com.tachikoma.lottie.e eVar) throws IOException {
        String strNextString = null;
        com.tachikoma.lottie.model.a.b bVarA = null;
        com.tachikoma.lottie.model.a.b bVarA2 = null;
        com.tachikoma.lottie.model.a.l lVarE = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 99) {
                if (iHashCode != 111) {
                    if (iHashCode != 3324) {
                        if (iHashCode != 3519) {
                            if (iHashCode == 3710 && strNextName.equals("tr")) {
                                c = 3;
                            }
                        } else if (strNextName.equals("nm")) {
                            c = 0;
                        }
                    } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                        c = 4;
                    }
                } else if (strNextName.equals(Config.OS)) {
                    c = 2;
                }
            } else if (strNextName.equals("c")) {
                c = 1;
            }
            if (c == 0) {
                strNextString = jsonReader.nextString();
            } else if (c == 1) {
                bVarA = d.a(jsonReader, eVar, false);
            } else if (c == 2) {
                bVarA2 = d.a(jsonReader, eVar, false);
            } else if (c == 3) {
                lVarE = c.e(jsonReader, eVar);
            } else if (c == 4) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.tachikoma.lottie.model.content.g(strNextString, bVarA, bVarA2, lVarE, zNextBoolean);
    }
}
