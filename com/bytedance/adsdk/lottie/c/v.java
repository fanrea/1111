package com.bytedance.adsdk.lottie.c;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.an;
import com.bytedance.adsdk.lottie.model.layer.gb;
import com.bytedance.adsdk.lottie.tt;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class v {
    public static com.bytedance.adsdk.lottie.an d(JsonReader jsonReader) throws JSONException, IOException {
        float f;
        ArrayList arrayList;
        an.c cVar;
        float fD = com.bytedance.adsdk.lottie.u.tt.d();
        LongSparseArray<com.bytedance.adsdk.lottie.model.layer.gb> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArray<com.bytedance.adsdk.lottie.model.c> sparseArray = new SparseArray<>();
        an.c cVar2 = new an.c();
        an.hc hcVar = new an.hc();
        an.b bVar = new an.b();
        an.d dVar = new an.d();
        com.bytedance.adsdk.lottie.an anVar = new com.bytedance.adsdk.lottie.an();
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        String strNextString = null;
        int iNextInt = 0;
        float fNextDouble3 = 0.0f;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            char c = 65535;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    f = fD;
                    if (strNextName.equals("assets")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1109732030:
                    f = fD;
                    if (strNextName.equals("layers")) {
                        c = 1;
                        break;
                    }
                    break;
                case -865448777:
                    f = fD;
                    if (strNextName.equals("globalEvent")) {
                        c = 2;
                        break;
                    }
                    break;
                case 104:
                    f = fD;
                    if (strNextName.equals("h")) {
                        c = 3;
                        break;
                    }
                    break;
                case 118:
                    f = fD;
                    if (strNextName.equals("v")) {
                        c = 4;
                        break;
                    }
                    break;
                case 119:
                    f = fD;
                    if (strNextName.equals("w")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3208:
                    f = fD;
                    if (strNextName.equals("dl")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3276:
                    f = fD;
                    if (strNextName.equals("fr")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3292:
                    f = fD;
                    if (strNextName.equals("gc")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3367:
                    f = fD;
                    if (strNextName.equals("ip")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3553:
                    f = fD;
                    if (strNextName.equals(Config.OPERATOR)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 3002509:
                    f = fD;
                    if (strNextName.equals("area")) {
                        c = 11;
                        break;
                    }
                    break;
                case 94623709:
                    f = fD;
                    if (strNextName.equals("chars")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 97615364:
                    f = fD;
                    if (strNextName.equals("fonts")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 110364485:
                    f = fD;
                    if (strNextName.equals("timer")) {
                        c = 14;
                        break;
                    }
                    break;
                case 839250809:
                    f = fD;
                    if (strNextName.equals("markers")) {
                        c = 15;
                        break;
                    }
                    break;
                default:
                    f = fD;
                    break;
            }
            switch (c) {
                case 0:
                    arrayList = arrayList3;
                    cVar = cVar2;
                    d(jsonReader, anVar, map, map2);
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case 1:
                    arrayList = arrayList3;
                    cVar = cVar2;
                    d(jsonReader, anVar, arrayList2, longSparseArray);
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case 2:
                    arrayList = arrayList3;
                    cVar = cVar2;
                    d(jsonReader, bVar);
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case 3:
                    iNextInt = jsonReader.nextInt();
                    arrayList3 = arrayList3;
                    break;
                case 4:
                    arrayList = arrayList3;
                    cVar = cVar2;
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.lottie.u.tt.d(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        anVar.d("Lottie only supports bodymovin >= 4.4.0");
                    }
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case 5:
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case 6:
                    strNextString = jsonReader.nextString();
                    break;
                case 7:
                    cVar = cVar2;
                    arrayList3 = arrayList3;
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    cVar2 = cVar;
                    break;
                case '\b':
                    arrayList = arrayList3;
                    cVar = cVar2;
                    d(jsonReader, hcVar);
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case '\t':
                    cVar = cVar2;
                    arrayList3 = arrayList3;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    cVar2 = cVar;
                    break;
                case '\n':
                    arrayList = arrayList3;
                    cVar = cVar2;
                    fNextDouble = ((float) jsonReader.nextDouble()) - 0.01f;
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case 11:
                    d(jsonReader, dVar);
                    arrayList = arrayList3;
                    cVar = cVar2;
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case '\f':
                    d(jsonReader, anVar, sparseArray);
                    arrayList = arrayList3;
                    cVar = cVar2;
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case '\r':
                    d(jsonReader, map3);
                    arrayList = arrayList3;
                    cVar = cVar2;
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case 14:
                    d(jsonReader, cVar2);
                    arrayList = arrayList3;
                    cVar = cVar2;
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                case 15:
                    d(jsonReader, arrayList3);
                    arrayList = arrayList3;
                    cVar = cVar2;
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
                default:
                    jsonReader.skipValue();
                    arrayList = arrayList3;
                    cVar = cVar2;
                    arrayList3 = arrayList;
                    cVar2 = cVar;
                    break;
            }
            fD = f;
        }
        float f2 = fD;
        jsonReader.endObject();
        anVar.d(new Rect(0, 0, (int) (iNextInt2 * f2), (int) (iNextInt * f2)), fNextDouble3, fNextDouble, fNextDouble2, arrayList2, longSparseArray, map, map2, sparseArray, map3, arrayList3, cVar2, strNextString, hcVar, bVar, dVar);
        return anVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void d(JsonReader jsonReader, an.d dVar) throws IOException {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                char c = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 104) {
                    switch (iHashCode) {
                        case 119:
                            if (strNextName.equals("w")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 120:
                            if (strNextName.equals("x")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 121:
                            if (strNextName.equals("y")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                } else if (strNextName.equals("h")) {
                    c = 3;
                }
                if (c == 0) {
                    dVar.d = jsonReader.nextString();
                } else if (c == 1) {
                    dVar.hc = jsonReader.nextString();
                } else if (c == 2) {
                    dVar.b = jsonReader.nextString();
                } else if (c == 3) {
                    dVar.c = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(android.util.JsonReader r7, com.bytedance.adsdk.lottie.an.b r8) throws java.io.IOException {
        /*
            r7.beginObject()     // Catch: java.lang.Exception -> L95
        L3:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L95
            if (r0 == 0) goto L91
            java.lang.String r0 = r7.nextName()     // Catch: java.lang.Exception -> L95
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L95
            r2 = 3239(0xca7, float:4.539E-42)
            r3 = -1
            r4 = 2
            r5 = 0
            r6 = 1
            if (r1 == r2) goto L38
            r2 = 107027(0x1a213, float:1.49977E-40)
            if (r1 == r2) goto L2e
            r2 = 3237004(0x31648c, float:4.536009E-39)
            if (r1 == r2) goto L24
            goto L42
        L24:
            java.lang.String r1 = "inel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L95
            if (r0 == 0) goto L42
            r0 = r5
            goto L43
        L2e:
            java.lang.String r1 = "lel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L95
            if (r0 == 0) goto L42
            r0 = r4
            goto L43
        L38:
            java.lang.String r1 = "el"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L95
            if (r0 == 0) goto L42
            r0 = r6
            goto L43
        L42:
            r0 = r3
        L43:
            if (r0 == 0) goto L5b
            if (r0 == r6) goto L54
            if (r0 == r4) goto L4d
            r7.skipValue()     // Catch: java.lang.Exception -> L95
            goto L3
        L4d:
            org.json.JSONArray r0 = b(r7)     // Catch: java.lang.Exception -> L95
            r8.b = r0     // Catch: java.lang.Exception -> L95
            goto L3
        L54:
            java.lang.String r0 = r7.nextString()     // Catch: java.lang.Exception -> L95
            r8.d = r0     // Catch: java.lang.Exception -> L95
            goto L3
        L5b:
            int[][] r0 = new int[r6][]     // Catch: java.lang.Exception -> L95
            int[] r1 = new int[r4]     // Catch: java.lang.Exception -> L95
            r1[r5] = r3     // Catch: java.lang.Exception -> L95
            r1[r6] = r3     // Catch: java.lang.Exception -> L95
            r0[r5] = r1     // Catch: java.lang.Exception -> L95
            r8.hc = r0     // Catch: java.lang.Exception -> L95
            r7.beginArray()     // Catch: java.lang.Exception -> L95
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L95
            if (r0 == 0) goto L8c
            r7.beginArray()     // Catch: java.lang.Exception -> L95
            r0 = r5
        L74:
            if (r0 >= r4) goto L89
            boolean r1 = r7.hasNext()     // Catch: java.lang.Exception -> L95
            if (r1 == 0) goto L86
            int[][] r1 = r8.hc     // Catch: java.lang.Exception -> L95
            r1 = r1[r5]     // Catch: java.lang.Exception -> L95
            int r2 = r7.nextInt()     // Catch: java.lang.Exception -> L95
            r1[r0] = r2     // Catch: java.lang.Exception -> L95
        L86:
            int r0 = r0 + 1
            goto L74
        L89:
            r7.endArray()     // Catch: java.lang.Exception -> L95
        L8c:
            r7.endArray()     // Catch: java.lang.Exception -> L95
            goto L3
        L91:
            r7.endObject()     // Catch: java.lang.Exception -> L95
            return
        L95:
            r7 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.c.v.d(android.util.JsonReader, com.bytedance.adsdk.lottie.an$b):void");
    }

    private static void d(JsonReader jsonReader, an.hc hcVar) throws IOException {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                char c = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3139) {
                    if (iHashCode != 3232) {
                        if (iHashCode != 3571) {
                            if (iHashCode != 3666) {
                                if (iHashCode == 98713 && strNextName.equals("cpf")) {
                                    c = 4;
                                }
                            } else if (strNextName.equals("se")) {
                                c = 0;
                            }
                        } else if (strNextName.equals("pc")) {
                            c = 3;
                        }
                    } else if (strNextName.equals("ee")) {
                        c = 2;
                    }
                } else if (strNextName.equals("be")) {
                    c = 1;
                }
                if (c == 0) {
                    hcVar.d = jsonReader.nextInt();
                } else if (c == 1) {
                    hcVar.hc = hc(jsonReader);
                } else if (c == 2) {
                    hcVar.b = hc(jsonReader);
                } else if (c == 3) {
                    hcVar.c = jsonReader.nextInt();
                } else if (c == 4) {
                    hc(jsonReader, hcVar);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    private static void hc(JsonReader jsonReader, an.hc hcVar) throws IOException {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                char c = 65535;
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 3276) {
                        if (iHashCode == 107027 && strNextName.equals("lel")) {
                            c = 2;
                        }
                    } else if (strNextName.equals("fr")) {
                        c = 0;
                    }
                } else if (strNextName.equals(t.n)) {
                    c = 1;
                }
                if (c == 0) {
                    hcVar.u = jsonReader.nextInt();
                } else if (c == 1) {
                    hcVar.an = jsonReader.nextString();
                } else if (c == 2) {
                    hcVar.h = b(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    private static Map<String, Object> hc(JsonReader jsonReader) throws JSONException, IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("lel")) {
                map.put("lel", b(jsonReader));
            } else if (strNextName.equals("lottie_back")) {
                JSONObject jSONObject = new JSONObject();
                map.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    if (strNextName2.equals(LiveConfigKey.HIGH)) {
                        try {
                            jSONObject.putOpt(LiveConfigKey.HIGH, Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt(PointParamKey.VID, "lottie_back");
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.mq.d(e);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(android.util.JsonReader r7, com.bytedance.adsdk.lottie.an.c r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.c.v.d(android.util.JsonReader, com.bytedance.adsdk.lottie.an$c):void");
    }

    private static void d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, List<com.bytedance.adsdk.lottie.model.layer.gb> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.gb> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.layer.gb gbVarD = de.d(jsonReader, anVar);
            if (gbVarD.mk() == gb.d.IMAGE) {
                i++;
            }
            list.add(gbVarD);
            longSparseArray.put(gbVarD.u(), gbVarD);
            if (i > 4) {
                com.bytedance.adsdk.lottie.u.u.hc("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(android.util.JsonReader r20, com.bytedance.adsdk.lottie.an r21, java.util.Map<java.lang.String, java.util.List<com.bytedance.adsdk.lottie.model.layer.gb>> r22, java.util.Map<java.lang.String, com.bytedance.adsdk.lottie.tt> r23) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.c.v.d(android.util.JsonReader, com.bytedance.adsdk.lottie.an, java.util.Map, java.util.Map):void");
    }

    private static JSONArray b(JsonReader jsonReader) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    char c = 65535;
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3324) {
                        if (iHashCode == 116753 && strNextName.equals(PointParamKey.VID)) {
                            c = 0;
                        }
                    } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                        c = 1;
                    }
                    if (c == 0) {
                        try {
                            jSONObject.put(PointParamKey.VID, jsonReader.nextString());
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.mq.d(e);
                        }
                    } else if (c == 1) {
                        try {
                            jSONObject.put(LiveConfigKey.HIGH, jsonReader.nextInt());
                        } catch (JSONException e2) {
                            com.bytedance.sdk.component.utils.mq.d(e2);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception e3) {
            com.bytedance.sdk.component.utils.mq.d(e3);
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(android.util.JsonReader r6, com.bytedance.adsdk.lottie.tt.d r7) throws java.io.IOException {
        /*
        L0:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L88
            java.lang.String r0 = r6.nextName()     // Catch: java.lang.Exception -> L89
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L89
            r2 = -2128704353(0xffffffff811e8c9f, float:-2.9120907E-38)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r1 == r2) goto L25
            r2 = 3308(0xcec, float:4.635E-42)
            if (r1 == r2) goto L1b
            goto L2f
        L1b:
            java.lang.String r1 = "gs"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L2f
            r0 = r4
            goto L30
        L25:
            java.lang.String r1 = "is_secondary"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L2f
            r0 = r3
            goto L30
        L2f:
            r0 = r5
        L30:
            if (r0 == 0) goto L80
            if (r0 == r4) goto L38
            r6.skipValue()     // Catch: java.lang.Exception -> L89
            goto L0
        L38:
            android.util.JsonToken r0 = r6.peek()     // Catch: java.lang.Exception -> L89
            android.util.JsonToken r1 = android.util.JsonToken.NULL     // Catch: java.lang.Exception -> L89
            if (r0 != r1) goto L44
            r6.nextNull()     // Catch: java.lang.Exception -> L89
            goto L0
        L44:
            com.bytedance.adsdk.lottie.tt$d$d r0 = new com.bytedance.adsdk.lottie.tt$d$d     // Catch: java.lang.Exception -> L89
            r0.<init>()     // Catch: java.lang.Exception -> L89
            r7.d = r0     // Catch: java.lang.Exception -> L89
            r6.beginObject()     // Catch: java.lang.Exception -> L89
        L4e:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L7c
            java.lang.String r0 = r6.nextName()     // Catch: java.lang.Exception -> L89
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L89
            r2 = 114(0x72, float:1.6E-43)
            if (r1 == r2) goto L61
            goto L6b
        L61:
            java.lang.String r1 = "r"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L6b
            r0 = r3
            goto L6c
        L6b:
            r0 = r5
        L6c:
            if (r0 == 0) goto L72
            r6.skipValue()     // Catch: java.lang.Exception -> L89
            goto L4e
        L72:
            com.bytedance.adsdk.lottie.tt$d$d r0 = r7.d     // Catch: java.lang.Exception -> L89
            double r1 = r6.nextDouble()     // Catch: java.lang.Exception -> L89
            float r1 = (float) r1     // Catch: java.lang.Exception -> L89
            r0.d = r1     // Catch: java.lang.Exception -> L89
            goto L4e
        L7c:
            r6.endObject()     // Catch: java.lang.Exception -> L89
            goto L0
        L80:
            boolean r0 = r6.nextBoolean()     // Catch: java.lang.Exception -> L89
            r7.hc = r0     // Catch: java.lang.Exception -> L89
            goto L0
        L88:
            return
        L89:
            r6 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.c.v.d(android.util.JsonReader, com.bytedance.adsdk.lottie.tt$d):void");
    }

    private static List<tt.hc> c(JsonReader jsonReader) throws IOException {
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                tt.hc hcVar = new tt.hc();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    char c = 65535;
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 99) {
                        if (iHashCode != 102) {
                            if (iHashCode != 108) {
                                if (iHashCode != 115) {
                                    if (iHashCode != 3153) {
                                        if (iHashCode != 3449) {
                                            if (iHashCode != 96670) {
                                                if (iHashCode != 101199) {
                                                    if (iHashCode == 3029637 && strNextName.equals("bold")) {
                                                        c = 5;
                                                    }
                                                } else if (strNextName.equals("fcl")) {
                                                    c = 4;
                                                }
                                            } else if (strNextName.equals("ali")) {
                                                c = '\b';
                                            }
                                        } else if (strNextName.equals("le")) {
                                            c = 1;
                                        }
                                    } else if (strNextName.equals("bs")) {
                                        c = 7;
                                    }
                                } else if (strNextName.equals("s")) {
                                    c = 2;
                                }
                            } else if (strNextName.equals("l")) {
                                c = 0;
                            }
                        } else if (strNextName.equals("f")) {
                            c = 6;
                        }
                    } else if (strNextName.equals("c")) {
                        c = 3;
                    }
                    switch (c) {
                        case 0:
                            hcVar.d = jsonReader.nextInt();
                            break;
                        case 1:
                            hcVar.hc = jsonReader.nextInt();
                            break;
                        case 2:
                            hcVar.an = jsonReader.nextInt();
                            break;
                        case 3:
                            hcVar.c = jsonReader.nextString();
                            break;
                        case 4:
                            hcVar.b = jsonReader.nextString();
                            break;
                        case 5:
                            hcVar.h = jsonReader.nextInt();
                            break;
                        case 6:
                            hcVar.u = jsonReader.nextString();
                            break;
                        case 7:
                            hcVar.gb = jsonReader.nextInt();
                            break;
                        case '\b':
                            hcVar.tt = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                arrayList.add(hcVar);
            }
            return arrayList;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    private static void d(JsonReader jsonReader, Map<String, com.bytedance.adsdk.lottie.model.b> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.b bVarD = k.d(jsonReader);
                    map.put(bVarD.hc(), bVarD);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void d(JsonReader jsonReader, com.bytedance.adsdk.lottie.an anVar, SparseArray<com.bytedance.adsdk.lottie.model.c> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.c cVarD = uo.d(jsonReader, anVar);
            sparseArray.put(cVarD.hashCode(), cVarD);
        }
        jsonReader.endArray();
    }

    private static void d(JsonReader jsonReader, List<com.bytedance.adsdk.lottie.model.an> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String strNextString = null;
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.lottie.model.an(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
