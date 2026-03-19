package com.kwad.lottie.c;

import android.util.JsonReader;
import com.kwad.lottie.model.content.MergePaths;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class v {
    static MergePaths h(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        MergePaths.MergePathsMode mergePathsModeForId = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("mm")) {
                mergePathsModeForId = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new MergePaths(strNextString, mergePathsModeForId);
    }
}
