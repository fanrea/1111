package com.kwad.lottie.c;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h implements aj<com.kwad.lottie.model.b> {
    public static final h bpq = new h();

    @Override // com.kwad.lottie.c.aj
    public final /* synthetic */ com.kwad.lottie.model.b a(JsonReader jsonReader, float f) {
        return b(jsonReader);
    }

    private h() {
    }

    private static com.kwad.lottie.model.b b(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        boolean zNextBoolean = true;
        String strNextString = null;
        String strNextString2 = null;
        double dNextDouble = 0.0d;
        double dNextDouble2 = 0.0d;
        double dNextDouble3 = 0.0d;
        double dNextDouble4 = 0.0d;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int iE = 0;
        int iE2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "f":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "j":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "s":
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case "t":
                    strNextString = jsonReader.nextString();
                    break;
                case "fc":
                    iE = p.e(jsonReader);
                    break;
                case "lh":
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case "ls":
                    dNextDouble3 = jsonReader.nextDouble();
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "sc":
                    iE2 = p.e(jsonReader);
                    break;
                case "sw":
                    dNextDouble4 = jsonReader.nextDouble();
                    break;
                case "tr":
                    iNextInt2 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.kwad.lottie.model.b(strNextString, strNextString2, dNextDouble, iNextInt, iNextInt2, dNextDouble2, dNextDouble3, iE, iE2, dNextDouble4, zNextBoolean);
    }
}
