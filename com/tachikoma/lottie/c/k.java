package com.tachikoma.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class k {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static com.tachikoma.lottie.model.b c(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        String strNextString3 = null;
        float fNextDouble = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            switch (strNextName.hashCode()) {
                case -1866931350:
                    if (strNextName.equals("fFamily")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1408684838:
                    if (strNextName.equals("ascent")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1294566165:
                    if (strNextName.equals("fStyle")) {
                        c = 2;
                        break;
                    }
                    break;
                case 96619537:
                    if (strNextName.equals("fName")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                strNextString = jsonReader.nextString();
            } else if (c == 1) {
                strNextString2 = jsonReader.nextString();
            } else if (c == 2) {
                strNextString3 = jsonReader.nextString();
            } else if (c == 3) {
                fNextDouble = (float) jsonReader.nextDouble();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new com.tachikoma.lottie.model.b(strNextString, strNextString2, strNextString3, fNextDouble);
    }
}
