package com.bytedance.sdk.component.adexpress.d.hc;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.tc.tt;
import com.bytedance.sdk.component.utils.mq;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private static volatile h d;
    private AtomicBoolean hc = new AtomicBoolean(false);

    public interface d {
        void d();

        void hc();
    }

    public static h d() {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    d = new h();
                }
            }
        }
        return d;
    }

    private h() {
    }

    public com.bytedance.sdk.component.adexpress.d.b.hc d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return an.d().d(str);
    }

    public Set<com.bytedance.sdk.component.adexpress.d.b.hc> hc(String str) {
        return an.d().hc(str);
    }

    private void hc() {
        if (com.bytedance.sdk.component.adexpress.d.d.d.d().b() == null) {
            return;
        }
        int iD = com.bytedance.sdk.component.adexpress.d.d.d.d().b().d();
        if (iD <= 0) {
            iD = 100;
        }
        List<com.bytedance.sdk.component.adexpress.d.b.hc> listHc = an.d().hc();
        if (listHc == null || listHc.isEmpty() || iD >= listHc.size()) {
            if (listHc != null) {
                listHc.size();
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.d.b.hc hcVar : listHc) {
            treeMap.put(hcVar.h(), hcVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listHc.size() - (iD * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                com.bytedance.sdk.component.adexpress.d.b.hc hcVar2 = (com.bytedance.sdk.component.adexpress.d.b.hc) entry.getValue();
                if (hcVar2 != null) {
                    hashSet.add(hcVar2.hc());
                }
            }
        }
        d(hashSet);
        this.hc.set(false);
    }

    private JSONObject d(String str, d dVar) {
        if (com.bytedance.sdk.component.adexpress.d.d.d.d().b() == null) {
            dVar.hc();
            return null;
        }
        com.bytedance.sdk.component.tt.hc.b bVarU = com.bytedance.sdk.component.adexpress.d.d.d.d().b().u();
        bVarU.d(str);
        com.bytedance.sdk.component.tt.hc hcVarD = bVarU.d();
        if (hcVarD != null) {
            try {
                if (hcVarD.gb() && hcVarD.c() != null) {
                    return new JSONObject(hcVarD.c());
                }
            } catch (Exception e) {
                mq.d(e);
            }
        }
        dVar.hc();
        return null;
    }

    private JSONObject b(String str) {
        com.bytedance.sdk.component.adexpress.d.d.b bVarB = com.bytedance.sdk.component.adexpress.d.d.d.d().b();
        if (bVarB == null) {
            return null;
        }
        com.bytedance.sdk.component.tt.hc.b bVarU = bVarB.u();
        bVarU.d(str);
        com.bytedance.sdk.component.tt.hc hcVarD = bVarU.d();
        if (hcVarD != null) {
            try {
                if (hcVarD.gb() && hcVarD.c() != null) {
                    return new JSONObject(hcVarD.c());
                }
            } catch (Exception e) {
                mq.d(e);
            }
        }
        return null;
    }

    public void d(com.bytedance.sdk.component.adexpress.d.b.c cVar, String str) {
        if (cVar == null) {
            mq.c("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = cVar.d;
        final String str3 = cVar.b;
        final String str4 = cVar.hc;
        final String str5 = cVar.c;
        final String str6 = cVar.u;
        final String strAn = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.d.d.d.d().b() != null ? com.bytedance.sdk.component.adexpress.d.d.d.d().b().an() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            mq.c("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.c.u.d(new tt("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.d.hc.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.d(str2, str3, str4, str5, str6, strAn);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(String str, String str2, String str3, String str4, String str5, String str6) {
        if (d(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                hc(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            d(str2, str6, str);
        } else {
            hc(str6, str, str3, str2, str4, str5);
        }
        boolean zD = gb.d(str5);
        if (!hc.u() || zD) {
            u.hc().d(true);
        }
    }

    private void d(String str, String str2, String str3) {
        JSONObject jSONObjectB;
        if (TextUtils.isEmpty(str) || (jSONObjectB = b(str)) == null) {
            return;
        }
        String strOptString = jSONObjectB.optString(TKDownloadReason.KSAD_TK_MD5);
        String strOptString2 = jSONObjectB.optString(Config.INPUT_DEF_VERSION);
        String strOptString3 = jSONObjectB.optString("data");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.d.b.hc hcVarD = new com.bytedance.sdk.component.adexpress.d.b.hc().d(str2).hc(str3).b(strOptString).c(str).u(strOptString3).an(strOptString2).d(Long.valueOf(System.currentTimeMillis()));
        an.d().d(hcVarD, false);
        hc();
        if (gb.d(strOptString2)) {
            hcVarD.an(strOptString2);
            u.hc().d(true);
        }
    }

    public synchronized void d(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        if (d(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                hc(str6, str, str3, str2, str4, str5);
                dVar.d();
            }
            dVar.d();
            return;
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            d(str2, str6, str, dVar);
        } else {
            hc(str6, str, str3, str2, str4, str5);
            dVar.d();
        }
        boolean zD = gb.d(str5);
        if (!hc.u() || zD) {
            u.hc().d(true);
        }
    }

    private void hc(String str, String str2, String str3, String str4, String str5, String str6) {
        an.d().d(new com.bytedance.sdk.component.adexpress.d.b.hc().d(str).hc(str2).b(str3).c(str4).u(str5).an(str6).d(Long.valueOf(System.currentTimeMillis())), false);
        hc();
    }

    private void d(String str, String str2, String str3, d dVar) {
        if (TextUtils.isEmpty(str)) {
            dVar.hc();
            return;
        }
        JSONObject jSONObjectD = d(str, dVar);
        if (jSONObjectD != null) {
            String strOptString = jSONObjectD.optString(TKDownloadReason.KSAD_TK_MD5);
            String strOptString2 = jSONObjectD.optString(Config.INPUT_DEF_VERSION);
            String strOptString3 = jSONObjectD.optString("data");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
                dVar.hc();
                return;
            }
            com.bytedance.sdk.component.adexpress.d.b.hc hcVarD = new com.bytedance.sdk.component.adexpress.d.b.hc().d(str2).hc(str3).b(strOptString).c(str).u(strOptString3).an(strOptString2).d(Long.valueOf(System.currentTimeMillis()));
            if (hcVarD == null || com.bytedance.sdk.component.adexpress.d.d.d.d().hc() == null) {
                dVar.hc();
                return;
            }
            if (TextUtils.isEmpty(hcVarD.hc())) {
                dVar.hc();
                return;
            }
            an.d().d(hcVarD, false);
            hc();
            if (gb.d(strOptString2)) {
                hcVarD.an(strOptString2);
                u.hc().d(true);
            }
            dVar.d();
        }
    }

    public void d(Set<String> set) {
        try {
            an.d().d(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
