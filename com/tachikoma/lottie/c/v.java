package com.tachikoma.lottie.c;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.tachikoma.lottie.model.content.MergePaths;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class v {
    static MergePaths h(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        MergePaths.MergePathsMode mergePathsModeForId = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3488) {
                    if (iHashCode == 3519 && strNextName.equals("nm")) {
                        c = 0;
                    }
                } else if (strNextName.equals("mm")) {
                    c = 1;
                }
            } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                c = 2;
            }
            if (c == 0) {
                strNextString = jsonReader.nextString();
            } else if (c == 1) {
                mergePathsModeForId = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (c == 2) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new MergePaths(strNextString, mergePathsModeForId, zNextBoolean);
    }
}
