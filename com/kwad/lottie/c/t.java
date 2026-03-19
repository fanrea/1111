package com.kwad.lottie.c;

import android.graphics.Rect;
import android.util.JsonReader;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.kwad.lottie.model.layer.Layer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class t {
    public static com.kwad.lottie.d g(JsonReader jsonReader) {
        SparseArrayCompat<com.kwad.lottie.model.d> sparseArrayCompat;
        HashMap map;
        float fSI = com.kwad.lottie.d.f.SI();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        SparseArrayCompat<com.kwad.lottie.model.d> sparseArrayCompat2 = new SparseArrayCompat<>();
        com.kwad.lottie.d dVar = new com.kwad.lottie.d();
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "assets":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    a(jsonReader, dVar, map2, map3);
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "layers":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    a(jsonReader, dVar, arrayList, longSparseArray);
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "h":
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case "v":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.kwad.lottie.d.f.a(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        dVar.dh("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "w":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "fr":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "ip":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "op":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "chars":
                    a(jsonReader, dVar, sparseArrayCompat2);
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "fonts":
                    a(jsonReader, map4);
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                default:
                    jsonReader.skipValue();
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
            }
        }
        jsonReader.endObject();
        dVar.a(new Rect(0, 0, (int) (iNextInt * fSI), (int) (iNextInt2 * fSI)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map2, map3, sparseArrayCompat2, map4);
        return dVar;
    }

    private static void a(JsonReader jsonReader, com.kwad.lottie.d dVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer layerQ = s.q(jsonReader, dVar);
            if (layerQ.Sk() == Layer.LayerType.Image) {
                i++;
            }
            list.add(layerQ);
            longSparseArray.put(layerQ.getId(), layerQ);
            if (i > 4) {
                com.kwad.lottie.c.df("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, com.kwad.lottie.d dVar, Map<String, List<Layer>> map, Map<String, com.kwad.lottie.g> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Layer layerQ = s.q(jsonReader, dVar);
                            longSparseArray.put(layerQ.getId(), layerQ);
                            arrayList.add(layerQ);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.kwad.lottie.g gVar = new com.kwad.lottie.g(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(gVar.getId(), gVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, Map<String, com.kwad.lottie.model.c> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.kwad.lottie.model.c cVarC = k.c(jsonReader);
                    map.put(cVarC.getName(), cVarC);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void a(JsonReader jsonReader, com.kwad.lottie.d dVar, SparseArrayCompat<com.kwad.lottie.model.d> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.kwad.lottie.model.d dVarN = j.n(jsonReader, dVar);
            sparseArrayCompat.put(dVarN.hashCode(), dVarN);
        }
        jsonReader.endArray();
    }
}
