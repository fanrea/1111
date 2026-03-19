package com.bytedance.sdk.component.gb.hc.b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.gb.d.c;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final LinkedList<String> d = new LinkedList<>();
    private static final LinkedList<String> hc = new LinkedList<>();
    private static final LinkedList<String> b = new LinkedList<>();
    private static final LinkedList<String> c = new LinkedList<>();
    private static final Map<String, Integer> u = new HashMap();
    private static String an = "upload_init";
    private static int h = 0;
    private static int gb = 0;
    private static AtomicLong tt = new AtomicLong();

    public static boolean b(String str) {
        return false;
    }

    public static boolean d(int i) {
        return i == 72 || i == 71;
    }

    public static String hc(int i) {
        switch (i) {
            case 71:
                return "flush once";
            case 72:
                return "flush memory db";
            case 73:
                return "flush memory";
            case 74:
                return "new event";
            case 75:
            default:
                return ILogConst.PLAY_SOURCE_DEFAULT;
            case 76:
                return "empty message";
            case 77:
                return "net error";
        }
    }

    public static synchronized int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<String, Integer> map = u;
        Integer num = map.get(str);
        if (num == null) {
            map.put(str, 1);
            return 1;
        }
        int iIntValue = num.intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    public static synchronized String hc(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = d;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized String c(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = hc;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized String u(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = b;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized String hc() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized void an(String str) {
        LinkedList<String> linkedList = c;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
    }

    public static String d(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        if (hcVar == null || hcVar.h() == null || hc(uVar) || c(uVar)) {
            return null;
        }
        if (hcVar.hc() == 3) {
            return hcVar.h().optString(NotificationCompat.CATEGORY_EVENT);
        }
        return hcVar.h().optString("label");
    }

    public static String hc(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        if (hcVar == null || hcVar.h() == null || hc(uVar) || c(uVar)) {
            return null;
        }
        return hcVar.h().optString("type");
    }

    public static String b(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        if (uVar == null || uVar.c() == null || !uVar.c().d()) {
            return "";
        }
        String strD = d(hcVar, uVar);
        if (TextUtils.isEmpty(strD)) {
            if (TextUtils.isEmpty(hc(hcVar, uVar))) {
                return null;
            }
            return "type:" + hc(hcVar, uVar);
        }
        return "label:" + strD;
    }

    public static int c(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        if (hcVar != null && hcVar.h() != null && hcVar.c() == 1) {
            try {
                return new JSONObject(hcVar.h().optString("event_extra")).optInt("stats_index");
            } catch (JSONException e) {
                mq.d(e);
            }
        }
        return -1;
    }

    public static void d(List<com.bytedance.sdk.component.gb.d.hc> list, String str, com.bytedance.sdk.component.gb.hc.d.hc hcVar) {
        JSONObject jSONObjectH;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.bytedance.sdk.component.gb.d.hc hcVar2 = list.get(0);
                    if (hcVar2 == null || hcVar2.c() == 0) {
                        long jIncrementAndGet = tt.incrementAndGet();
                        for (com.bytedance.sdk.component.gb.d.hc hcVar3 : list) {
                            if (hcVar3 != null && (jSONObjectH = hcVar3.h()) != null) {
                                String strOptString = jSONObjectH.optString("ad_extra_data");
                                if (!TextUtils.isEmpty(strOptString)) {
                                    JSONObject jSONObject = new JSONObject(strOptString);
                                    jSONObject.put("upload_count", jIncrementAndGet);
                                    jSONObject.put("upload_ts", System.currentTimeMillis());
                                    if (hcVar != null) {
                                        String strHc = hcVar.hc();
                                        boolean zD = hcVar.d();
                                        if (!TextUtils.isEmpty(strHc)) {
                                            jSONObject.put("delete_msg", strHc + " success:" + zD);
                                        }
                                    }
                                    jSONObjectH.put("ad_extra_data", jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                mq.d(th);
            }
        }
    }

    public static synchronized int u(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        if (hcVar != null) {
            if (hcVar.h() != null) {
                try {
                    return new JSONObject(hcVar.h().optString("ad_extra_data")).optInt("sdk_event_self_count");
                } catch (Exception e) {
                    mq.d(e);
                    return 0;
                }
            }
        }
        return 0;
    }

    public static String d(JSONObject jSONObject, u uVar) {
        if (jSONObject != null && !hc(uVar) && !c(uVar)) {
            String strOptString = jSONObject.optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("rit");
                } catch (JSONException e) {
                    mq.d(e);
                }
            }
        }
        return "";
    }

    public static String an(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        if (hcVar != null && hcVar.h() != null && !hc(uVar) && !c(uVar)) {
            String strOptString = hcVar.h().optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString(g.o);
                } catch (JSONException e) {
                    mq.d(e);
                }
            }
        }
        return null;
    }

    public static void d(List<com.bytedance.sdk.component.gb.d.hc> list, u uVar) {
        try {
            if (uVar.c().b()) {
                for (com.bytedance.sdk.component.gb.d.hc hcVar : list) {
                    if (hcVar != null && hcVar.tt() != 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - hcVar.tt();
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.gb().incrementAndGet();
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.uo().getAndAdd(jCurrentTimeMillis);
                        hcVar.b(System.currentTimeMillis());
                    }
                    if (hcVar != null) {
                        h(hcVar, uVar);
                    }
                }
                com.bytedance.sdk.component.gb.hc.hc.hc.d.tc().getAndAdd(list.size());
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public static void h(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) throws JSONException {
        try {
            if (hcVar.c() == 0 && uVar.c() != null && uVar.c().k()) {
                JSONObject jSONObjectH = hcVar.h();
                String strD = d(hcVar, uVar);
                if (b(strD)) {
                    return;
                }
                String strOptString = jSONObjectH.optString("ad_extra_data");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("will_send_labels"))) {
                        jSONObject.put("will_send_labels", u(strD));
                        jSONObject.put("send_success_valid_labels", hc());
                    }
                    jSONObjectH.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("will_send_labels", u(strD));
                jSONObject2.put("send_success_valid_labels", hc());
                jSONObjectH.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public static void gb(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) throws JSONException {
        if (uVar == null || uVar.c() == null || !uVar.c().b()) {
            return;
        }
        try {
            com.bytedance.sdk.component.gb.hc.hc.hc.d.d(System.currentTimeMillis() - hcVar.gb());
            hcVar.hc(System.currentTimeMillis());
            if (hcVar.c() == 0 && uVar.c() != null && uVar.c().k()) {
                String strD = d(hcVar, uVar);
                if (b(strD)) {
                    return;
                }
                JSONObject jSONObjectH = hcVar.h();
                String strOptString = hcVar.h().optString("ad_extra_data");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("save_success_labels"))) {
                        jSONObject.put("save_success_labels", c(strD));
                    }
                    jSONObjectH.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("save_success_labels", c(strD));
                jSONObjectH.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
    }

    public static boolean d(u uVar) {
        return uVar != null && TextUtils.equals(uVar.u(), "csj");
    }

    public static boolean hc(u uVar) {
        return uVar != null && TextUtils.equals(uVar.u(), "csj_mediation");
    }

    public static boolean b(u uVar) {
        return uVar != null && TextUtils.equals(uVar.u(), "pangle");
    }

    public static boolean c(u uVar) {
        return uVar != null && TextUtils.equals(uVar.u(), "pgl_mediation");
    }

    public static boolean u(u uVar) {
        return d(uVar) || b(uVar);
    }

    public static void d(JSONObject jSONObject, com.bytedance.sdk.component.gb.hc.c.d.d dVar, u uVar, int i) {
        c cVarC;
        if (uVar != null && (cVarC = uVar.c()) != null && cVarC.d() && u(uVar)) {
            jSONObject.optString("label");
        }
    }

    public static void d(List<com.bytedance.sdk.component.gb.d.hc> list, int i, String str, u uVar) {
        c cVarC;
        if (uVar == null || (cVarC = uVar.c()) == null || !cVarC.d() || list == null || hc(uVar) || c(uVar)) {
            return;
        }
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        for (com.bytedance.sdk.component.gb.d.hc hcVar : list) {
            if (hcVar.c() == 0) {
                JSONObject jSONObjectH = hcVar.h();
                String strD = d(hcVar, uVar);
                if (hcVar.hc() == 3) {
                    if (jSONObjectH != null) {
                        strD = jSONObjectH.optString(NotificationCompat.CATEGORY_EVENT);
                    }
                    sb.append(" [v3:").append(strD).append("] ");
                } else {
                    long jD = d(uVar, hcVar);
                    int iU = u(hcVar, uVar);
                    sb.append(" [").append(jD).append(Config.replace).append(strD);
                    if (iU == 0) {
                        sb.append("] ");
                    } else {
                        sb.append(Config.replace).append(iU).append("] ");
                    }
                }
                z = true;
            } else if (hcVar.c() == 1) {
                sb.append(" [").append(c(hcVar, uVar)).append(Config.replace).append(hc(hcVar, uVar)).append("] ");
            }
        }
        if (z) {
            b.hc("_upload", "ads:" + ((Object) sb) + hc(i) + "," + str + ",total:" + list.size(), uVar);
        } else {
            b.hc("_upload", "stats:" + ((Object) sb) + hc(i) + "," + str + ",total:" + list.size(), uVar);
        }
    }

    public static boolean d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return hcVar != null && hcVar.c() == 0 && hcVar.u() == 1;
    }

    public static boolean hc(List<com.bytedance.sdk.component.gb.d.hc> list, u uVar) {
        com.bytedance.sdk.component.gb.d.hc hcVar;
        return (list == null || list.size() == 0 || (hcVar = list.get(0)) == null || hcVar.c() != 0 || !d(uVar)) ? false : true;
    }

    public static boolean tt(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        return hcVar != null && hcVar.c() == 0 && d(uVar);
    }

    public static boolean hc(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return hcVar != null && hcVar.c() == 3 && hcVar.u() == 2;
    }

    public static boolean b(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return hcVar != null && hcVar.c() == 0 && hcVar.u() == 2;
    }

    public static boolean c(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return hcVar != null && hcVar.c() == 1 && hcVar.u() == 2;
    }

    public static boolean u(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return hcVar != null && hcVar.c() == 1 && hcVar.u() == 3;
    }

    public static boolean an(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return hcVar != null && hcVar.c() == 2 && hcVar.u() == 3;
    }

    private static void d(com.bytedance.sdk.component.gb.d.hc hcVar, String str, c cVar, u uVar) {
        String strD = d(hcVar, uVar);
        if (b(strD)) {
            return;
        }
        String strAn = an(hcVar, uVar);
        if (hcVar.c() == 0 && cVar.k()) {
            an(strD + Config.replace + strAn + Config.replace + str);
        }
    }

    public static long d(u uVar, com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (hcVar != null && hcVar.h() != null) {
            try {
                return new JSONObject(hcVar.h().optString("ad_extra_data")).optLong("sdk_event_index");
            } catch (Exception e) {
                b.b(e.getMessage(), uVar);
            }
        }
        return 0L;
    }

    public static void d(boolean z, int i, String str, String str2, int i2, String str3) throws JSONException {
        h++;
        if (z) {
            gb++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z);
            jSONObject.put("scnt", gb);
            jSONObject.put("acnt", h);
            jSONObject.put("code", i);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i2);
            jSONObject.put("rit", str3);
            jSONObject.put("msg", str);
            c cVarU = com.bytedance.sdk.component.gb.hc.d.b("csj").u();
            if (cVarU != null) {
                jSONObject.put("url", cVarU.mq().an());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            an = jSONObject.toString();
        } catch (Exception unused) {
            an = "unknown_json";
        }
    }

    public static String d() {
        return an;
    }

    public static void d(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar, String str) {
        c cVarU;
        if (hc(uVar) || uVar == null || c(uVar) || (cVarU = com.bytedance.sdk.component.gb.hc.d.b(uVar.u()).u()) == null || !cVarU.d()) {
            return;
        }
        if (!TextUtils.isEmpty(hc(hcVar, uVar))) {
            c(hcVar, uVar);
        }
        if (TextUtils.isEmpty(d(hcVar, uVar))) {
            return;
        }
        d(uVar, hcVar);
    }

    public static void d(List<com.bytedance.sdk.component.gb.d.hc> list, u uVar, String str) {
        if (uVar == null) {
            return;
        }
        try {
            c cVarC = uVar.c();
            if (cVarC == null || !cVarC.d()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (com.bytedance.sdk.component.gb.d.hc hcVar : list) {
                if (hcVar.c() == 1) {
                    sb.append(hc(hcVar, uVar)).append(Config.replace).append(c(hcVar, uVar)).append("; ");
                } else if (hcVar.c() == 0) {
                    if (hcVar.hc() == 3) {
                        if (hcVar.h() != null) {
                            sb.append(hcVar.h().optString(NotificationCompat.CATEGORY_EVENT));
                            long jD = d(uVar, hcVar);
                            if (jD != 0) {
                                sb.append(Config.replace).append(jD);
                            }
                            sb.append("; ");
                        } else {
                            b.hc("_delete", "v3_error", uVar);
                        }
                    } else {
                        sb.append(d(hcVar, uVar));
                        long jD2 = d(uVar, hcVar);
                        if (jD2 != 0) {
                            sb.append(Config.replace).append(jD2);
                        }
                        sb.append("; ");
                    }
                }
            }
            sb.append("]").append(" total:" + list.size()).append(" table:" + str);
            b.hc("_remove", sb.toString(), uVar);
        } catch (Exception e) {
            b.b("_delete error", e.getMessage(), uVar);
        }
    }

    public static void d(int i, List<com.bytedance.sdk.component.gb.d.hc> list, long j, u uVar, com.bytedance.sdk.component.gb.hc.hc.b.hc hcVar) {
        com.bytedance.sdk.component.gb.d.hc hcVar2;
        if (uVar != null) {
            try {
                if (uVar.c().b()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - j;
                    if (i == 200) {
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.v().getAndAdd(jCurrentTimeMillis);
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.sy().incrementAndGet();
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.yo().getAndAdd(list.size());
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.u().getAndAdd(list.size());
                        return;
                    }
                    b.b("-------AdThread code is " + i + " error  ------------", uVar);
                    byte bC = -1;
                    if (i == -1) {
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.rf().getAndAdd(list.size());
                    } else {
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.h().getAndAdd(list.size());
                    }
                    com.bytedance.sdk.component.gb.hc.hc.hc.d.np().getAndAdd(jCurrentTimeMillis);
                    com.bytedance.sdk.component.gb.hc.hc.hc.d.de().incrementAndGet();
                    if (!list.isEmpty() && (hcVar2 = list.get(0)) != null) {
                        bC = hcVar2.c();
                    }
                    if (hcVar != null) {
                        com.bytedance.sdk.component.gb.hc.hc.hc.d.yi().append((int) bC).append(Config.replace).append(hcVar.c).append(Config.replace).append(hcVar.hc).append(Config.replace).append(hcVar.b).append(" ");
                        return;
                    }
                    com.bytedance.sdk.component.gb.hc.hc.hc.d.yi().append((int) bC).append(Config.replace).append(i).append(" ");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static int b(List<com.bytedance.sdk.component.gb.d.hc> list, u uVar) {
        JSONObject jSONObjectH;
        String strOptString;
        if (list != null && list.size() == 1) {
            try {
                com.bytedance.sdk.component.gb.d.hc hcVar = list.get(0);
                if (hcVar != null && hcVar.u() == 1 && (jSONObjectH = hcVar.h()) != null && hcVar.c() == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectH.optJSONObject("params");
                    if (jSONObjectOptJSONObject == null) {
                        strOptString = jSONObjectH.optString("ad_extra_data");
                    } else {
                        strOptString = jSONObjectOptJSONObject.optString("ad_extra_data");
                    }
                    JSONObject jSONObject = new JSONObject(strOptString);
                    int iOptInt = jSONObject.optInt("inner_appid", 0);
                    if (iOptInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectH.put("ad_extra_data", jSONObject.toString());
                        } else {
                            jSONObjectOptJSONObject.put("ad_extra_data", jSONObject.toString());
                            jSONObjectH.put("params", jSONObjectOptJSONObject);
                        }
                        return iOptInt;
                    }
                }
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        return 0;
    }

    public static void d(List<com.bytedance.sdk.component.gb.d.hc> list, String str, u uVar) {
        try {
            c cVarC = uVar.c();
            if (cVarC != null && cVarC.b() && list != null && cVarC.k()) {
                for (com.bytedance.sdk.component.gb.d.hc hcVar : list) {
                    if (hcVar != null) {
                        d(hcVar, str, cVarC, uVar);
                    }
                }
            }
        } catch (Exception e) {
            b.b(e.getMessage(), uVar);
        }
    }
}
