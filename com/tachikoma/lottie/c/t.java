package com.tachikoma.lottie.c;

import android.util.JsonReader;
import com.tachikoma.lottie.model.layer.Layer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class t {
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc A[PHI: r18
  0x00dc: PHI (r18v14 float) = 
  (r18v2 float)
  (r18v3 float)
  (r18v4 float)
  (r18v5 float)
  (r18v6 float)
  (r18v7 float)
  (r18v8 float)
  (r18v9 float)
  (r18v10 float)
  (r18v11 float)
  (r18v12 float)
  (r18v15 float)
 binds: [B:39:0x00d8, B:36:0x00cc, B:33:0x00c0, B:30:0x00b4, B:27:0x00a8, B:24:0x009c, B:21:0x0090, B:18:0x0084, B:15:0x0076, B:12:0x0068, B:9:0x005a, B:7:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tachikoma.lottie.e g(android.util.JsonReader r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.lottie.c.t.g(android.util.JsonReader):com.tachikoma.lottie.e");
    }

    private static void a(JsonReader jsonReader, com.tachikoma.lottie.e eVar, List<Layer> list, android.support.v4.d.e<Layer> eVar2) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer layerQ = s.q(jsonReader, eVar);
            if (layerQ.lH() == Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(layerQ);
            eVar2.put(layerQ.getId(), layerQ);
            if (i > 4) {
                com.tachikoma.lottie.c.R("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, com.tachikoma.lottie.e eVar, Map<String, List<Layer>> map, Map<String, com.tachikoma.lottie.h> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            android.support.v4.d.e eVar2 = new android.support.v4.d.e();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                char c = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -1109732030) {
                    if (iHashCode != 104) {
                        if (iHashCode != 112) {
                            if (iHashCode != 117) {
                                if (iHashCode != 119) {
                                    if (iHashCode == 3355 && strNextName.equals("id")) {
                                        c = 0;
                                    }
                                } else if (strNextName.equals("w")) {
                                    c = 2;
                                }
                            } else if (strNextName.equals(com.kuaishou.weapon.p0.t.i)) {
                                c = 5;
                            }
                        } else if (strNextName.equals("p")) {
                            c = 4;
                        }
                    } else if (strNextName.equals("h")) {
                        c = 3;
                    }
                } else if (strNextName.equals("layers")) {
                    c = 1;
                }
                if (c == 0) {
                    strNextString = jsonReader.nextString();
                } else if (c == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Layer layerQ = s.q(jsonReader, eVar);
                        eVar2.put(layerQ.getId(), layerQ);
                        arrayList.add(layerQ);
                    }
                    jsonReader.endArray();
                } else if (c == 2) {
                    iNextInt = jsonReader.nextInt();
                } else if (c == 3) {
                    iNextInt2 = jsonReader.nextInt();
                } else if (c == 4) {
                    strNextString2 = jsonReader.nextString();
                } else if (c == 5) {
                    strNextString3 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.tachikoma.lottie.h hVar = new com.tachikoma.lottie.h(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(hVar.getId(), hVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, Map<String, com.tachikoma.lottie.model.b> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c = 65535;
            if (strNextName.hashCode() == 3322014 && strNextName.equals("list")) {
                c = 0;
            }
            if (c == 0) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.tachikoma.lottie.model.b bVarC = k.c(jsonReader);
                    map.put(bVarC.getName(), bVarC);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void a(JsonReader jsonReader, com.tachikoma.lottie.e eVar, android.support.v4.d.m<com.tachikoma.lottie.model.c> mVar) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.tachikoma.lottie.model.c cVarN = j.n(jsonReader, eVar);
            mVar.put(cVarN.hashCode(), cVarN);
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, List<com.tachikoma.lottie.model.g> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String strNextString = null;
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                char c = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3178) {
                    if (iHashCode != 3214) {
                        if (iHashCode == 3705 && strNextName.equals("tm")) {
                            c = 1;
                        }
                    } else if (strNextName.equals("dr")) {
                        c = 2;
                    }
                } else if (strNextName.equals("cm")) {
                    c = 0;
                }
                if (c == 0) {
                    strNextString = jsonReader.nextString();
                } else if (c == 1) {
                    fNextDouble = (float) jsonReader.nextDouble();
                } else if (c == 2) {
                    fNextDouble2 = (float) jsonReader.nextDouble();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            list.add(new com.tachikoma.lottie.model.g(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
