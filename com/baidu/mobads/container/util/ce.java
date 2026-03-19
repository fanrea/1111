package com.baidu.mobads.container.util;

import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ce {
    private static final String a = "%25%25origin_time%25%25";
    private static final String b = "%25%25play_mode%25%25";
    private static final String c = "%25%25cur_time%25%25";
    private static final String d = "%25%25start_time%25%25";
    private static final String e = "%25%25reason_value%25%25";
    private static final String f = "%25%25area%25%25";
    private static final String g = "%25%25ready%25%25";
    private static final String h = "%25%25ready_ts%25%25";
    private static final String i = "%25%25show_ts%25%25";
    private static final String j = "%25%25media_render%25%25";
    private static final String k = "hot";
    private static final String l = "0";

    public static void a(View view, com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getImpressionUrls().iterator();
        while (it.hasNext()) {
            a(a(it.next(), i2, 0.0d, 0.0d, 0, k), tVar);
        }
        Iterator<String> it2 = com.baidu.mobads.container.o.c.a(jVar, view).iterator();
        while (it2.hasNext()) {
            a(a(it2.next(), i2, 0.0d, 0.0d, 0, k), tVar);
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2) {
        if (jVar == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(jVar.getClickThroughUrl())) {
                return;
            }
            a(a(jVar.getClickThroughUrl(), i2, 0.0d, 0.0d, 0, k), tVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getThirdClickTrackingUrls().iterator();
        while (it.hasNext()) {
            a(a(it.next(), i2, 0.0d, 0.0d, 0, k), tVar);
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, String str, int i2) {
        if (jVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = k;
        }
        Iterator<String> it = jVar.getThirdClickTrackingUrls().iterator();
        while (it.hasNext()) {
            a(a(it.next(), i2, 0.0d, 0.0d, 0, str), tVar);
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2, double d2) {
        if (jVar == null) {
            return;
        }
        try {
            Iterator<String> it = jVar.getStartTrackers().iterator();
            while (it.hasNext()) {
                a(a(it.next(), i2, d2, d2, 0, k), tVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2) {
        if (jVar == null) {
            return;
        }
        try {
            a(0.0d, 0.0d, a(jVar, "vreadyplay"), i2, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.j jVar, double d2, double d3, int i2, int i3) {
        if (jVar == null) {
            return;
        }
        try {
            a(d2, d3, a(jVar, "vmute"), i2, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.j jVar, List<String> list) {
        List<String> listA;
        if (list == null && jVar != null) {
            try {
                listA = a(jVar, com.component.feed.a.p);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            listA = list;
        }
        if (listA == null) {
            return;
        }
        a(0.0d, 0.0d, listA, 1, 7);
    }

    public static void b(com.baidu.mobads.container.adrequest.j jVar, List<String> list) {
        List<String> listA;
        if (list == null && jVar != null) {
            try {
                listA = a(jVar, com.component.feed.a.q);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            listA = list;
        }
        if (listA == null) {
            return;
        }
        a(0.0d, 0.0d, listA, 1, 7);
    }

    public static void a(com.baidu.mobads.container.adrequest.j jVar, double d2, double d3, int i2) {
        if (jVar == null) {
            return;
        }
        try {
            a(d2, d3, a(jVar, "vplayfail"), i2, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(com.baidu.mobads.container.adrequest.j jVar, double d2, double d3, int i2) {
        if (jVar == null) {
            return;
        }
        try {
            a(d2, d3, a(jVar, "vrepeatedplay"), i2, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(double d2, double d3, com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2, int i3) {
        if (jVar == null) {
            return;
        }
        try {
            Iterator<String> it = jVar.getCloseTrackers().iterator();
            while (it.hasNext()) {
                a(a(it.next(), i2, d2, d3, i3, k), tVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getCacheSuccTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), i2, 0.0d, 0.0d, 0, k), tVar);
        }
    }

    public static void e(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getCacheFailTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), i2, 0.0d, 0.0d, 0, k), tVar);
        }
    }

    public static void f(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, int i2) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getCacheExpireTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), i2, 0.0d, 0.0d, 0, k), tVar);
        }
    }

    public static void a(double d2, double d3, List<String> list, int i2, int i3) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                a(a(it.next(), i2, d2, d3, i3, k), (com.baidu.mobads.container.adrequest.t) null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(double d2, double d3, List<String> list, int i2, int i3) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String strA = a(it.next(), i2, d2, d3, i3, k);
                if (!TextUtils.isEmpty(strA)) {
                    a(strA.replaceAll(j, "1"), (com.baidu.mobads.container.adrequest.t) null);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String a(String str, int i2, double d2, double d3, int i3, String str2) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(a, "" + System.currentTimeMillis()).replaceAll(b, "" + i2).replaceAll(c, "" + d2).replaceAll(d, "" + d3).replaceAll(f, str2).replaceAll(e, "" + i3).replaceAll(g, "1").replaceAll(h, "" + System.currentTimeMillis()).replaceAll(i, "" + System.currentTimeMillis()) : "";
    }

    public static List<String> a(com.baidu.mobads.container.adrequest.j jVar, String str) {
        if (!TextUtils.isEmpty(str) && jVar != null && jVar.getOriginJsonObject() != null) {
            JSONObject jSONObjectOptJSONObject = jVar.getOriginJsonObject().optJSONObject("monitors");
            ArrayList arrayList = new ArrayList();
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next.equals(str)) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(next);
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                    }
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private static void a(String str, com.baidu.mobads.container.adrequest.t tVar) {
        by.a(str, null);
    }
}
