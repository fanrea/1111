package com.kwad.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ac implements aj<com.kwad.lottie.e.d> {
    public static final ac bpy = new ac();

    @Override // com.kwad.lottie.c.aj
    public final /* synthetic */ com.kwad.lottie.e.d a(JsonReader jsonReader, float f) {
        return j(jsonReader, f);
    }

    private ac() {
    }

    private static com.kwad.lottie.e.d j(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.kwad.lottie.e.d((fNextDouble / 100.0f) * f, (fNextDouble2 / 100.0f) * f);
    }
}
