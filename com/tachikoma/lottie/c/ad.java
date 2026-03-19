package com.tachikoma.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.forbes.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class ad implements aj<com.tachikoma.lottie.model.content.h> {
    public static final ad Nq = new ad();

    @Override // com.tachikoma.lottie.c.aj
    public final /* synthetic */ com.tachikoma.lottie.model.content.h a(JsonReader jsonReader, float f) {
        return k(jsonReader, f);
    }

    private ad() {
    }

    private static com.tachikoma.lottie.model.content.h k(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listD = null;
        List<PointF> listD2 = null;
        List<PointF> listD3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 99) {
                if (iHashCode != 105) {
                    if (iHashCode != 111) {
                        if (iHashCode == 118 && strNextName.equals("v")) {
                            c = 1;
                        }
                    } else if (strNextName.equals(Config.OS)) {
                        c = 3;
                    }
                } else if (strNextName.equals("i")) {
                    c = 2;
                }
            } else if (strNextName.equals("c")) {
                c = 0;
            }
            if (c == 0) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c == 1) {
                listD = p.d(jsonReader, f);
            } else if (c == 2) {
                listD2 = p.d(jsonReader, f);
            } else if (c == 3) {
                listD3 = p.d(jsonReader, f);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (listD == null || listD2 == null || listD3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listD.isEmpty()) {
            return new com.tachikoma.lottie.model.content.h(new PointF(), false, Collections.emptyList());
        }
        int size = listD.size();
        PointF pointF = listD.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listD.get(i);
            int i2 = i - 1;
            arrayList.add(new com.tachikoma.lottie.model.a(com.tachikoma.lottie.d.e.a(listD.get(i2), listD3.get(i2)), com.tachikoma.lottie.d.e.a(pointF2, listD2.get(i)), pointF2));
        }
        if (zNextBoolean) {
            PointF pointF3 = listD.get(0);
            int i3 = size - 1;
            arrayList.add(new com.tachikoma.lottie.model.a(com.tachikoma.lottie.d.e.a(listD.get(i3), listD3.get(i3)), com.tachikoma.lottie.d.e.a(pointF3, listD2.get(0)), pointF3));
        }
        return new com.tachikoma.lottie.model.content.h(pointF, zNextBoolean, arrayList);
    }
}
