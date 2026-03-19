package com.kwad.sdk.core.local;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.pandora.common.utils.Times;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private static volatile a bCi;
    public static ThreadLocal<SimpleDateFormat> bCj = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.local.a.1
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ SimpleDateFormat initialValue() {
            return aam();
        }

        private static SimpleDateFormat aam() {
            return new SimpleDateFormat(Times.YYYY_MM_DD);
        }
    };

    public static a aah() {
        if (bCi == null) {
            synchronized (a.class) {
                if (bCi == null) {
                    bCi = new a();
                }
            }
        }
        return bCi;
    }

    public static boolean aai() throws JSONException {
        List<f> listFi = fi(15);
        if (listFi.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (f fVar : listFi) {
            i += fVar.count;
            if (fVar.bGP > j) {
                j = fVar.bGP;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > aak()) {
            return false;
        }
        return j + (aal() * 1000) <= System.currentTimeMillis();
    }

    public static void cy(AdTemplate adTemplate) throws JSONException {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            cz(adTemplate);
        }
    }

    public static List<f> aaj() throws JSONException {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static List<f> fi(int i) throws JSONException {
        ArrayList arrayList = new ArrayList();
        List<f> listAaj = aaj();
        if (listAaj != null && listAaj.size() != 0) {
            for (f fVar : listAaj) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void i(int i, long j) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    private static int aak() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long aal() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static boolean a(f fVar) {
        long j = fVar.bGP;
        if (j <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = bCj.get();
        return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date()));
    }

    private static void cz(AdTemplate adTemplate) throws JSONException {
        int iET = e.eT(adTemplate);
        int iEJ = e.eJ(adTemplate);
        List listAaj = aaj();
        if (listAaj == null || listAaj.size() == 0) {
            listAaj = new ArrayList();
            listAaj.add(new f(iEJ, iET, 1, System.currentTimeMillis()));
        } else {
            boolean z = false;
            Iterator it = listAaj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar = (f) it.next();
                if (fVar.adStyle == iEJ && fVar.taskType == iET) {
                    fVar.count++;
                    if (!a(fVar)) {
                        fVar.count = 1;
                        fVar.bf(System.currentTimeMillis());
                    }
                    z = true;
                }
            }
            if (!z) {
                listAaj.add(new f(iEJ, iET, 1, System.currentTimeMillis()));
            }
        }
        X("ksadsdk_local_ad_task_info_adstyle_data", aa.aL(listAaj).toString());
        adTemplate.watched = true;
    }

    private static void X(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
        } catch (Throwable th) {
            c.printStackTrace(th);
            return null;
        }
    }
}
