package com.tachikoma.lottie.c;

import android.graphics.Path;
import android.util.JsonReader;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class ae {
    static com.tachikoma.lottie.model.content.i w(JsonReader jsonReader, com.tachikoma.lottie.e eVar) throws IOException {
        String strNextString = null;
        com.tachikoma.lottie.model.a.a aVarL = null;
        com.tachikoma.lottie.model.a.d dVarG = null;
        int iNextInt = 1;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != -396065730) {
                if (iHashCode != 99) {
                    if (iHashCode != 111) {
                        if (iHashCode != 114) {
                            if (iHashCode != 3324) {
                                if (iHashCode == 3519 && strNextName.equals("nm")) {
                                    c = 0;
                                }
                            } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                                c = 5;
                            }
                        } else if (strNextName.equals(com.kuaishou.weapon.p0.t.k)) {
                            c = 4;
                        }
                    } else if (strNextName.equals(Config.OS)) {
                        c = 2;
                    }
                } else if (strNextName.equals("c")) {
                    c = 1;
                }
            } else if (strNextName.equals("fillEnabled")) {
                c = 3;
            }
            if (c == 0) {
                strNextString = jsonReader.nextString();
            } else if (c == 1) {
                aVarL = d.l(jsonReader, eVar);
            } else if (c == 2) {
                dVarG = d.g(jsonReader, eVar);
            } else if (c == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c == 4) {
                iNextInt = jsonReader.nextInt();
            } else if (c == 5) {
                zNextBoolean2 = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.tachikoma.lottie.model.content.i(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarL, dVarG, zNextBoolean2);
    }
}
