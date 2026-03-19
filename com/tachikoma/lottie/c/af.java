package com.tachikoma.lottie.c;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class af {
    static com.tachikoma.lottie.model.content.j x(JsonReader jsonReader, com.tachikoma.lottie.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3371) {
                    if (iHashCode == 3519 && strNextName.equals("nm")) {
                        c = 0;
                    }
                } else if (strNextName.equals("it")) {
                    c = 2;
                }
            } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                c = 1;
            }
            if (c == 0) {
                strNextString = jsonReader.nextString();
            } else if (c == 1) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c == 2) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.tachikoma.lottie.model.content.b bVarM = g.m(jsonReader, eVar);
                    if (bVarM != null) {
                        arrayList.add(bVarM);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.tachikoma.lottie.model.content.j(strNextString, arrayList, zNextBoolean);
    }
}
