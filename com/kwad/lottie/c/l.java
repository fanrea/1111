package com.kwad.lottie.c;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l implements aj<com.kwad.lottie.model.content.c> {
    private int bps;

    @Override // com.kwad.lottie.c.aj
    public final /* synthetic */ com.kwad.lottie.model.content.c a(JsonReader jsonReader, float f) {
        return d(jsonReader);
    }

    public l(int i) {
        this.bps = i;
    }

    private com.kwad.lottie.model.content.c d(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.bps == -1) {
            this.bps = arrayList.size() / 4;
        }
        int i = this.bps;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.bps * 4; i4++) {
            int i5 = i4 / 4;
            double dFloatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) dFloatValue;
            } else if (i6 == 1) {
                i2 = (int) (dFloatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (dFloatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (dFloatValue * 255.0d));
            }
        }
        com.kwad.lottie.model.content.c cVar = new com.kwad.lottie.model.content.c(fArr, iArr);
        a(cVar, arrayList);
        return cVar;
    }

    private void a(com.kwad.lottie.model.content.c cVar, List<Float> list) {
        int i = this.bps * 4;
        if (list.size() <= i) {
            return;
        }
        int size = (list.size() - i) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                dArr[i2] = list.get(i).floatValue();
            } else {
                dArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        for (int i3 = 0; i3 < cVar.getSize(); i3++) {
            int i4 = cVar.getColors()[i3];
            cVar.getColors()[i3] = Color.argb(a(cVar.Rv()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    private static int a(double d, double[] dArr, double[] dArr2) {
        double dB;
        int i = 1;
        while (true) {
            if (i < dArr.length) {
                int i2 = i - 1;
                double d2 = dArr[i2];
                double d3 = dArr[i];
                if (d3 >= d) {
                    dB = com.kwad.lottie.d.e.b(dArr2[i2], dArr2[i], (d - d2) / (d3 - d2));
                    break;
                }
                i++;
            } else {
                dB = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (dB * 255.0d);
    }
}
