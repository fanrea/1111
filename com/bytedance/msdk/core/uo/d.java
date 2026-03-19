package com.bytedance.msdk.core.uo;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.api.d.hc;
import com.bytedance.msdk.core.tc.an;
import com.bytedance.msdk.core.tc.gb;
import com.bytedance.msdk.core.tc.h;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.b;
import com.bytedance.msdk.gb.fs;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.uo;
import com.bytedance.msdk.gb.v;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.tt.hc.c;
import com.bytedance.sdk.component.tt.hc.u;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.kwad.sdk.api.model.AdnName;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;

    /* renamed from: com.bytedance.msdk.core.uo.d$d, reason: collision with other inner class name */
    public interface InterfaceC0247d {
        void d(com.bytedance.msdk.api.d dVar);

        void d(h hVar);
    }

    public static int d(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    private String d(Map<String, com.bytedance.msdk.b.d.d> map, Context context, hc hcVar, tc tcVar, Map<String, Object> map2) {
        if (hcVar == null || tcVar == null) {
            b.hc("serverBiddingRequest", "adSlot is null or waterFallConfig is null can not get server bidding token");
            return "";
        }
        if (TextUtils.equals(AdnName.BAIDU, tcVar.e())) {
            com.bytedance.msdk.b.an.hc.hc hcVarD = com.bytedance.msdk.b.an.hc.hc.d(tcVar, (com.bytedance.msdk.b.hc.hc.d) null);
            com.bytedance.msdk.b.d.d dVarD = com.bytedance.msdk.b.gb.b.d(hcVarD, hcVar, (com.bytedance.msdk.b.d.hc) null);
            if (dVarD == null) {
                return "";
            }
            try {
                map.put(String.format("%1$s_%2$s_%3$s", hcVar.d(), hcVar.v(), tcVar.yo()), dVarD);
                return dVarD.d(context, hcVarD, hcVar);
            } catch (Throwable unused) {
                return "";
            }
        }
        return com.bytedance.msdk.an.hc.d.d(map2, tcVar.e());
    }

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    public void d(Map<String, com.bytedance.msdk.b.d.d> map, Context context, hc hcVar, List<tc> list, List<com.bytedance.msdk.hc.b> list2, com.bytedance.msdk.core.tc.hc hcVar2, int i, boolean z, final InterfaceC0247d interfaceC0247d) {
        final JSONObject jSONObject = new JSONObject();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        u uVarHc = com.bytedance.msdk.c.hc.d().hc().hc();
        uVarHc.d(com.bytedance.msdk.core.b.b());
        String strGb = com.bytedance.msdk.core.d.mk().gb();
        if (!TextUtils.isEmpty(strGb)) {
            uVarHc.hc("X-Tt-Env", strGb);
            uVarHc.hc("x-use-ppe", "1");
        }
        uVarHc.hc("User-Agent", com.bytedance.msdk.hc.hc.d);
        final boolean z2 = !com.bytedance.msdk.core.hc.hc().u();
        if (z2) {
            uVarHc.hc("x-pglcypher", "4");
            uVarHc.d(MediaTypeUtils.APPLICATION_OCTET_STREAM, fs.hc(d(map, context, hcVar, list, list2, hcVar2, i, z, jSONObject, true)));
        } else {
            uVarHc.b(d(map, context, hcVar, list, list2, hcVar2, i, z, jSONObject, false));
        }
        uVarHc.d(new com.bytedance.sdk.component.tt.d.d() { // from class: com.bytedance.msdk.core.uo.d.1
            @Override // com.bytedance.sdk.component.tt.d.d
            public void d(c cVar, com.bytedance.sdk.component.tt.hc hcVar3) {
                JSONObject jSONObject2;
                if (hcVar3 != null) {
                    int iD = hcVar3.d();
                    if (fs.d(hcVar3)) {
                        String strD = fs.d(hcVar3.tc());
                        if (!TextUtils.isEmpty(strD)) {
                            try {
                                d.this.d(new JSONObject(strD), jSONObject, interfaceC0247d, z2, jCurrentTimeMillis);
                                return;
                            } catch (Throwable th) {
                                d.this.d(81014, th.getMessage(), interfaceC0247d, z2);
                                return;
                            }
                        }
                        b.c("ServerBiddingHelper", "Server Bidding Request onResponse...response v4 is empty");
                        d.this.d(iD, "response is empty", interfaceC0247d, z2);
                        return;
                    }
                    if (!TextUtils.isEmpty(hcVar3.c())) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(hcVar3.c());
                            JSONObject jSONObject4 = null;
                            int iOptInt = jSONObject3.optInt("cypher", -1);
                            String strOptString = jSONObject3.optString(cm.V);
                            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                                if (iOptInt == 2) {
                                    String strD2 = fs.d(strOptString);
                                    if (TextUtils.isEmpty(strD2)) {
                                        jSONObject2 = jSONObject4;
                                    } else {
                                        try {
                                            jSONObject2 = new JSONObject(strD2);
                                        } catch (Throwable th2) {
                                            b.d("ServerBiddingHelper", ">>>>> server bidding data error: " + th2.toString());
                                        }
                                    }
                                } else {
                                    if (iOptInt == 1) {
                                        String strHc = com.bytedance.msdk.gb.d.hc(strOptString, com.bytedance.msdk.gb.hc.d());
                                        if (!TextUtils.isEmpty(strHc)) {
                                            try {
                                                jSONObject2 = new JSONObject(strHc);
                                            } catch (Throwable th3) {
                                                b.d("ServerBiddingHelper", "server bidding data error: ", th3);
                                            }
                                        }
                                    } else if (iOptInt == 0) {
                                        jSONObject4 = new JSONObject(strOptString);
                                    }
                                    jSONObject2 = jSONObject4;
                                }
                                d.this.d(jSONObject2, jSONObject, interfaceC0247d, z2, jCurrentTimeMillis);
                                return;
                            }
                            int iOptInt2 = jSONObject3.optInt("status_code", -2);
                            int iOptInt3 = jSONObject3.optInt("reason", -2);
                            String strOptString2 = jSONObject3.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID);
                            b.c("ServerBiddingHelper", "Server Bidding onResponse error ");
                            d.this.d(iOptInt2, "reason is " + iOptInt3 + "，desc is " + strOptString2, interfaceC0247d, z2);
                            return;
                        } catch (Throwable th4) {
                            d.this.d(81006, th4.getMessage(), interfaceC0247d, z2);
                            return;
                        }
                    }
                    b.c("ServerBiddingHelper", "Server Bidding Request onResponse...response is empty");
                    d.this.d(iD, "response is empty", interfaceC0247d, z2);
                    return;
                }
                b.c("ServerBiddingHelper", "Server Bidding Request onResponse...response is null");
                d.this.d(-1, "response is null", interfaceC0247d, z2);
            }

            @Override // com.bytedance.sdk.component.tt.d.d
            public void d(c cVar, IOException iOException) {
                int i2 = iOException instanceof SocketTimeoutException ? 44405 : 44404;
                b.c("ServerBiddingHelper", "Server Bidding Request onError...errorCode=".concat(String.valueOf(i2)));
                d.this.d(i2, "request fail " + iOException.getMessage(), interfaceC0247d, z2);
            }
        });
    }

    private void d(boolean z, long j) {
        zw.d(z ? "v4Enc_exchange" : "v2Enc_exchange", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, InterfaceC0247d interfaceC0247d, boolean z) {
        zw.d(z ? "v4Enc_exchange" : "v2Enc_exchange", false, 0L, "code = " + i + "，msg = " + str);
        d(interfaceC0247d, new com.bytedance.msdk.api.d(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(JSONObject jSONObject, JSONObject jSONObject2, InterfaceC0247d interfaceC0247d, boolean z, long j) {
        String str;
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        gb gbVar;
        JSONObject jSONObjectOptJSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jSONObject != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                h hVar = new h();
                hVar.d(jSONObject2);
                hVar.b(jSONObject.optString("request_id"));
                hVar.u(jSONObject.optString("server_bidding_extra"));
                hVar.c(jSONObject.optString("server_request_id"));
                gb gbVar2 = new gb();
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("winner");
                String str5 = "price";
                if (jSONObjectOptJSONObject2 != null) {
                    gbVar2.hc(jSONObjectOptJSONObject2.optInt("req_bidding_type"));
                    gbVar2.b(jSONObjectOptJSONObject2.optString("price"));
                    gbVar2.c(jSONObjectOptJSONObject2.optString("load_price"));
                    gbVar2.tc(jSONObjectOptJSONObject2.optString("adm"));
                    gbVar2.u(jSONObjectOptJSONObject2.optString("name"));
                    gbVar2.h(jSONObjectOptJSONObject2.optString(com.alipay.sdk.m.k.b.D0));
                    gbVar2.an(jSONObjectOptJSONObject2.optString("slot_id"));
                    str = "ServerBiddingHelper";
                    gbVar2.gb(jSONObjectOptJSONObject2.optString("win_callback", null));
                    gbVar2.tt(jSONObjectOptJSONObject2.optString("fail_callback", null));
                    gbVar2.d(jSONObjectOptJSONObject2.optInt("pricing_type", 1));
                    hVar.d(gbVar2);
                } else {
                    str = "ServerBiddingHelper";
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("winners");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    str2 = str;
                } else {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < jSONArrayOptJSONArray.length()) {
                        try {
                            gbVar = new gb();
                            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                            jSONArray = jSONArrayOptJSONArray;
                        } catch (Throwable th) {
                            th = th;
                            jSONArray = jSONArrayOptJSONArray;
                        }
                        try {
                            gbVar.hc(jSONObjectOptJSONObject.optInt("req_bidding_type"));
                            gbVar.b(jSONObjectOptJSONObject.optString(str5));
                            gbVar.c(jSONObjectOptJSONObject.optString("load_price"));
                            gbVar.tc(jSONObjectOptJSONObject.optString("adm"));
                            gbVar.u(jSONObjectOptJSONObject.optString("name"));
                            gbVar.h(jSONObjectOptJSONObject.optString(com.alipay.sdk.m.k.b.D0));
                            gbVar.an(jSONObjectOptJSONObject.optString("slot_id"));
                            str3 = str5;
                            try {
                                gbVar.gb(jSONObjectOptJSONObject.optString("win_callback", null));
                                gbVar.tt(jSONObjectOptJSONObject.optString("fail_callback", null));
                                gbVar.d(jSONObjectOptJSONObject.optString("m_aid", null));
                                gbVar.hc(jSONObjectOptJSONObject.optString("ad_extra", null));
                            } catch (Throwable th2) {
                                th = th2;
                                str4 = str;
                                b.d(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                                i++;
                                str = str4;
                                str5 = str3;
                                jSONArrayOptJSONArray = jSONArray;
                            }
                            try {
                                gbVar.d(jSONObjectOptJSONObject.optInt("pricing_type", 1));
                                arrayList.add(gbVar);
                                str4 = str;
                            } catch (Throwable th3) {
                                th = th3;
                                str4 = str;
                                b.d(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                                i++;
                                str = str4;
                                str5 = str3;
                                jSONArrayOptJSONArray = jSONArray;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            str3 = str5;
                            str4 = str;
                            b.d(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                            i++;
                            str = str4;
                            str5 = str3;
                            jSONArrayOptJSONArray = jSONArray;
                        }
                        i++;
                        str = str4;
                        str5 = str3;
                        jSONArrayOptJSONArray = jSONArray;
                    }
                    str2 = str;
                    hVar.d(arrayList);
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("auto_detail");
                if (jSONObjectOptJSONObject3 != null) {
                    hVar.d(jSONObjectOptJSONObject3.optString("est_price"));
                    hVar.d(jSONObjectOptJSONObject3.optInt("est_price_source"));
                    hVar.hc(jSONObjectOptJSONObject3.optString("bidding_ecpm"));
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("waterfall");
                if (jSONObjectOptJSONObject4 != null) {
                    h.d dVar = new h.d();
                    dVar.d(jSONObjectOptJSONObject4.optString(Config.INPUT_DEF_VERSION));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("adn_rit_conf");
                    ArrayList arrayList2 = new ArrayList();
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            try {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                tc tcVar = new tc();
                                tcVar.b(jSONObjectOptJSONObject5.optString("adn_name"));
                                tcVar.u(jSONObjectOptJSONObject5.optString("adn_slot_id"));
                                arrayList2.add(tcVar);
                            } catch (Throwable th5) {
                                b.d(str2, "new waterfallListJson parse error: " + th5.toString());
                            }
                        }
                    }
                    dVar.d(arrayList2);
                    hVar.d(dVar);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("invalid_non_server_bidding_results");
                ArrayList arrayList3 = new ArrayList();
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        try {
                            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
                            an anVar = new an();
                            anVar.d(jSONObjectOptJSONObject6.optString("name"));
                            anVar.hc(jSONObjectOptJSONObject6.optString("slot_id"));
                            anVar.d(jSONObjectOptJSONObject6.optInt("req_bidding_type"));
                            anVar.hc(jSONObjectOptJSONObject6.optInt("error_code"));
                            anVar.b(jSONObjectOptJSONObject6.optString("error_msg"));
                            anVar.c(jSONObjectOptJSONObject6.optString("level_tag"));
                            arrayList3.add(anVar);
                        } catch (Throwable th6) {
                            b.d(str2, "new invalid_non_server_bidding_results parse error: " + th6.toString());
                        }
                    }
                    hVar.hc(arrayList3);
                }
                d(interfaceC0247d, hVar);
                d(z, jCurrentTimeMillis);
                return;
            }
            b.c("ServerBiddingHelper", "Server Bidding Request onResponse..data.string is null ");
            d(-1, "data.string is null", interfaceC0247d, z);
            return;
        }
        b.c("ServerBiddingHelper", "Server Bidding Request onResponse...data is null");
        d(-1, "data is null", interfaceC0247d, z);
    }

    private void d(h hVar, String str) {
        JSONObject jSONObject;
        if (hVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject jSONObject3 = null;
            int iOptInt = jSONObject2.optInt("cypher", -1);
            String strOptString = jSONObject2.optString(cm.V);
            if (iOptInt < 0 || TextUtils.isEmpty(strOptString)) {
                b.c("ServerBiddingHelper", "m_meta onResponse error ");
                return;
            }
            if (iOptInt == 2) {
                String strD = fs.d(strOptString);
                if (!TextUtils.isEmpty(strD)) {
                    try {
                        jSONObject = new JSONObject(strD);
                        jSONObject3 = jSONObject;
                    } catch (Throwable th) {
                        b.d("ServerBiddingHelper", ">>>>> m_meta data error: " + th.toString());
                    }
                }
            } else if (iOptInt == 1) {
                String strHc = com.bytedance.msdk.gb.d.hc(strOptString, com.bytedance.msdk.gb.hc.d());
                if (!TextUtils.isEmpty(strHc)) {
                    try {
                        jSONObject = new JSONObject(strHc);
                        jSONObject3 = jSONObject;
                    } catch (Throwable th2) {
                        b.d("ServerBiddingHelper", "m_meta data error: ", th2);
                    }
                }
            } else if (iOptInt == 0) {
                jSONObject3 = new JSONObject(strOptString);
            }
            if (jSONObject3 != null) {
                if (!TextUtils.isEmpty(jSONObject3.toString())) {
                    hVar.b(jSONObject3.optString("request_id"));
                    hVar.u(jSONObject3.optString("server_bidding_extra"));
                    hVar.c(jSONObject3.optString("server_request_id"));
                    return;
                }
                b.c("ServerBiddingHelper", "m_meta..data.string is null ");
                return;
            }
            b.c("ServerBiddingHelper", "m_meta...data is null");
        } catch (Throwable th3) {
            b.c("ServerBiddingHelper", "m_meta onResponse throwable ：".concat(String.valueOf(th3.toString())));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.core.tc.gb d(org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.uo.d.d(org.json.JSONObject):com.bytedance.msdk.core.tc.gb");
    }

    public void d(String str, InterfaceC0247d interfaceC0247d) {
        if (!TextUtils.isEmpty(str)) {
            try {
                h hVar = new h();
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
                String strOptString = jSONObject.optString("m_meta");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            gb gbVarD = d(jSONArrayOptJSONArray.optJSONObject(i));
                            if (gbVarD != null) {
                                arrayList.add(gbVarD);
                            }
                        } catch (Throwable th) {
                            b.d("ServerBiddingHelper", "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        }
                    }
                    hVar.d(arrayList);
                }
                d(hVar, strOptString);
                d(interfaceC0247d, hVar);
                return;
            } catch (Throwable th2) {
                String string = th2.toString();
                b.c("ServerBiddingHelper", "Server Bidding onResponse throwable ：".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    string = com.bytedance.msdk.api.d.d(-1);
                }
                d(interfaceC0247d, new com.bytedance.msdk.api.d(-1, string));
                return;
            }
        }
        b.c("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
        d(interfaceC0247d, new com.bytedance.msdk.api.d(-1, "response is invalid"));
    }

    private void d(final InterfaceC0247d interfaceC0247d, final com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.uo.d.2
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0247d interfaceC0247d2 = interfaceC0247d;
                if (interfaceC0247d2 != null) {
                    interfaceC0247d2.d(dVar);
                }
            }
        });
    }

    private void d(final InterfaceC0247d interfaceC0247d, final h hVar) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.uo.d.3
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0247d interfaceC0247d2 = interfaceC0247d;
                if (interfaceC0247d2 != null) {
                    interfaceC0247d2.d(hVar);
                }
            }
        });
    }

    private JSONObject hc() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.hc.hc().uo())) {
            return null;
        }
        try {
            return new JSONObject(com.bytedance.msdk.core.hc.hc().uo());
        } catch (Exception e) {
            mq.d(e);
            return null;
        }
    }

    private JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            mq.d(e);
            return null;
        }
    }

    public String d(Map<String, com.bytedance.msdk.b.d.d> map, Context context, hc hcVar, List<tc> list, com.bytedance.msdk.core.tc.hc hcVar2, int i, boolean z, JSONObject jSONObject) {
        return context == null ? "" : d(map, context, hcVar, list, null, hcVar2, i, z, jSONObject, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0592 A[Catch: Exception -> 0x0654, TryCatch #7 {Exception -> 0x0654, blocks: (B:149:0x04e0, B:151:0x04ec, B:155:0x0528, B:157:0x052e, B:159:0x0549, B:179:0x0592, B:181:0x0595, B:183:0x059f, B:184:0x05a4, B:186:0x05b4, B:187:0x05b8, B:189:0x05be, B:191:0x05c6, B:193:0x05d8, B:196:0x05eb, B:197:0x05f2, B:199:0x062a, B:200:0x0633, B:194:0x05e1, B:203:0x064a, B:176:0x058b), top: B:232:0x04e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x059f A[Catch: Exception -> 0x0654, TryCatch #7 {Exception -> 0x0654, blocks: (B:149:0x04e0, B:151:0x04ec, B:155:0x0528, B:157:0x052e, B:159:0x0549, B:179:0x0592, B:181:0x0595, B:183:0x059f, B:184:0x05a4, B:186:0x05b4, B:187:0x05b8, B:189:0x05be, B:191:0x05c6, B:193:0x05d8, B:196:0x05eb, B:197:0x05f2, B:199:0x062a, B:200:0x0633, B:194:0x05e1, B:203:0x064a, B:176:0x058b), top: B:232:0x04e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05b4 A[Catch: Exception -> 0x0654, TryCatch #7 {Exception -> 0x0654, blocks: (B:149:0x04e0, B:151:0x04ec, B:155:0x0528, B:157:0x052e, B:159:0x0549, B:179:0x0592, B:181:0x0595, B:183:0x059f, B:184:0x05a4, B:186:0x05b4, B:187:0x05b8, B:189:0x05be, B:191:0x05c6, B:193:0x05d8, B:196:0x05eb, B:197:0x05f2, B:199:0x062a, B:200:0x0633, B:194:0x05e1, B:203:0x064a, B:176:0x058b), top: B:232:0x04e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0253 A[Catch: all -> 0x0445, TRY_LEAVE, TryCatch #0 {all -> 0x0445, blocks: (B:59:0x01f8, B:61:0x0227, B:72:0x0253), top: B:219:0x01f8 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d(java.util.Map<java.lang.String, com.bytedance.msdk.b.d.d> r37, android.content.Context r38, com.bytedance.msdk.api.d.hc r39, java.util.List<com.bytedance.msdk.core.tc.tc> r40, java.util.List<com.bytedance.msdk.hc.b> r41, com.bytedance.msdk.core.tc.hc r42, int r43, boolean r44, org.json.JSONObject r45, boolean r46) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1674
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.uo.d.d(java.util.Map, android.content.Context, com.bytedance.msdk.api.d.hc, java.util.List, java.util.List, com.bytedance.msdk.core.tc.hc, int, boolean, org.json.JSONObject, boolean):java.lang.String");
    }

    private String d(hc hcVar, tc tcVar) {
        String strD = hcVar != null ? hcVar.d() : null;
        if (tcVar != null) {
            return (strD + Config.replace) + tcVar.yo();
        }
        return strD;
    }

    private String d(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        if (z2) {
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        JSONObject jSONObjectD = fs.d(jSONObject);
        if (jSONObjectD == null) {
            return null;
        }
        try {
            jSONObjectD.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
        } catch (Exception unused2) {
        }
        return jSONObjectD.toString();
    }

    private JSONObject d(hc hcVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", hcVar.d());
            jSONObject.put("ad_sdk_version", com.bytedance.msdk.hc.hc.hc());
            jSONObject.put(ILogConst.Keys.KEY_PLUGIN_VERSION, com.bytedance.msdk.hc.hc.c());
            jSONObject.put(n.s, PointCategory.APP);
            jSONObject.put(PointCategory.APP, b());
            JSONObject jSONObjectD = v.d(com.bytedance.msdk.core.hc.getContext());
            if (jSONObjectD != null && hcVar.fs() > 0) {
                jSONObjectD.put("orientation", hcVar.fs());
            }
            jSONObject.put("device", jSONObjectD);
            jSONObject.put("ua", com.bytedance.msdk.hc.hc.d);
            jSONObject.put("ip", np.de());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(hc(hcVar));
            jSONObject.put("adslots", jSONArray);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put(j.s, jCurrentTimeMillis);
            String strConcat = "";
            if (hcVar.v() != null && hcVar.d() != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(hcVar.v()).concat(hcVar.d());
            }
            jSONObject.put("req_sign", uo.d(strConcat));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject hc(hc hcVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            int iDe = hcVar.de();
            jSONObject.put("id", hcVar.v());
            jSONObject.put("adtype", iDe);
            jSONObject.put(g.af, d(iDe));
            d(jSONObject, "accepted_size", hcVar.yi(), hcVar.he());
            jSONObject.put("is_support_dpl", hcVar.zw());
            int iVv = hcVar.vv();
            int i = 1;
            if (iVv <= 0) {
                iVv = 1;
            }
            if (iVv > 3) {
                iVv = 3;
            }
            if (iDe != 7 && iDe != 8) {
                i = iVv;
            }
            jSONObject.put(PointParamKey.AD_COUNT, i);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void d(JSONObject jSONObject, String str, int i, int i2) throws JSONException {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void hc(JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.put(n.p, fs.d());
            jSONObject.put("version_code", fs.hc());
            jSONObject.put(Config.INPUT_DEF_VERSION, fs.b());
        } catch (Exception unused) {
        }
    }

    private void b(JSONObject jSONObject) throws JSONException {
        if (com.bytedance.msdk.gb.an.d(com.bytedance.msdk.core.hc.getContext()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", r0.d);
                jSONObject2.put("longitude", r0.hc);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private String hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.bytedance.msdk.api.c.d.hc.an.d dVarD = com.bytedance.msdk.an.hc.d.d(str);
            if (dVarD != null) {
                return dVarD.d();
            }
            com.bytedance.msdk.d.d.c cVarD = com.bytedance.msdk.an.hc.hc.d().d(str);
            if (cVarD == null) {
                return null;
            }
            return cVarD.hc();
        } catch (Throwable th) {
            mq.d(th);
            b.c("TTMediationSDK_SDK_Init", "GDT SDK 初始化失败。。 e=" + th.toString());
            return null;
        }
    }

    private JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.msdk.core.d.mk().mq());
            jSONObject.put("name", com.bytedance.msdk.core.d.mk().sy());
            hc(jSONObject);
            b(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
