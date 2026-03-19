package com.baidu.mobads.container.rewardvideo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.components.j.c;
import com.baidu.mobads.container.util.cc;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class dp {
    private static final String a = "%25%25origin_time%25%25";
    private static final String b = "%25%25play_mode%25%25";
    private static final String c = "%25%25cur_time%25%25";
    private static final String d = "%25%25start_time%25%25";
    private static final String e = "%25%25area%25%25";
    private static final String f = "hot";
    private static final String g = "0";

    public static void a(View view, com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        if (jVar == null) {
            return;
        }
        com.baidu.mobads.container.util.cd.a(jVar, tVar);
        int i = 0;
        for (String strB : jVar.getImpressionUrls()) {
            if (tVar != null) {
                strB = com.baidu.mobads.container.util.cd.b(jVar, strB, tVar.z(), tVar.l());
            }
            a(a(strB, 0, 0), tVar, jVar, c.d.a, i);
            i++;
        }
        Iterator<String> it = com.baidu.mobads.container.o.c.a(jVar, view).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String strA = a(it.next(), 0, 0);
            a(strA, tVar, jVar, c.d.c, i2);
            com.baidu.mobads.container.util.cc.a(view.getContext(), strA, cc.a.THIRDSHOW);
            i2++;
        }
        com.baidu.mobads.container.components.h.c.f.a((Context) null).a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_SUCCESS);
    }

    public static void a(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        if (jVar == null || TextUtils.isEmpty(jVar.getClickThroughUrl())) {
            return;
        }
        a(a(jVar.getClickThroughUrl(), 0, 0), tVar);
    }

    public static void a(View view, com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.o.b bVar) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = com.baidu.mobads.container.o.c.a(jVar, view, bVar).iterator();
        int i = 0;
        while (it.hasNext()) {
            String strA = a(it.next(), 0, 0);
            a(strA, tVar, jVar, c.d.d, i);
            com.baidu.mobads.container.util.cc.a(view.getContext(), strA, cc.a.THIRDCLICK);
            i++;
        }
    }

    public static void b(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getStartTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), 0, 0), tVar);
        }
    }

    public static void c(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getSkipTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), 0, 0), tVar);
        }
    }

    public static void a(int i, int i2, com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getCloseTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), i, i2), tVar);
        }
    }

    public static void d(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getCacheSuccTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), 0, 0), tVar);
        }
    }

    public static void e(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getCacheFailTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), 0, 0), tVar);
        }
    }

    public static void f(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.t tVar) {
        if (jVar == null) {
            return;
        }
        Iterator<String> it = jVar.getCacheExpireTrackers().iterator();
        while (it.hasNext()) {
            a(a(it.next(), 0, 0), tVar);
        }
    }

    public static void a(int i, int i2, List<String> list) {
        if (list == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            a(a(it.next(), i, i2), (com.baidu.mobads.container.adrequest.t) null);
        }
    }

    private static String a(String str, int i, int i2) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(a, "" + System.currentTimeMillis()).replaceAll(b, "0").replaceAll(c, "" + i).replaceAll(d, "" + i2).replaceAll(e, f) : "";
    }

    public static Set<String> a(com.baidu.mobads.container.adrequest.j jVar, View view, com.baidu.mobads.container.o.b bVar) {
        String strOptString;
        HashSet hashSet = new HashSet();
        if (jVar == null) {
            return hashSet;
        }
        try {
            JSONObject originJsonObject = jVar.getOriginJsonObject();
            String str = f;
            if (originJsonObject == null) {
                strOptString = f;
            } else {
                strOptString = originJsonObject.optString("da_area");
            }
            if (!TextUtils.isEmpty(strOptString)) {
                str = strOptString;
            }
            Iterator<String> it = com.baidu.mobads.container.o.c.a(jVar, view, bVar).iterator();
            while (it.hasNext()) {
                hashSet.add(a(it.next(), 0, 0, str));
            }
        } catch (Exception e2) {
        }
        return hashSet;
    }

    private static String a(String str, int i, int i2, String str2) {
        return str.replaceAll(a, "" + System.currentTimeMillis()).replaceAll(b, "0").replaceAll(c, "" + i).replaceAll(d, "" + i2).replaceAll(e, str2);
    }

    private static void a(String str, com.baidu.mobads.container.adrequest.t tVar) {
        com.baidu.mobads.container.util.by.a(str, null);
    }

    private static void a(String str, com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.adrequest.j jVar, String str2, int i) {
        String str3;
        String strK;
        String str4;
        if (tVar == null) {
            str3 = "";
            strK = str3;
            str4 = strK;
        } else {
            String strZ = tVar.z();
            String strL = tVar.l();
            strK = tVar.k();
            str3 = strZ;
            str4 = strL;
        }
        com.baidu.mobads.container.components.j.c.a().a(str3, strK, str4, jVar, str2, "", "", i, str);
    }
}
