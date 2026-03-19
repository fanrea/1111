package com.bytedance.sdk.component.adexpress.d.hc;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.c.tc;
import com.bytedance.sdk.component.adexpress.d.b.d;
import com.bytedance.sdk.component.tc.tt;
import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    static Object d = new Object();

    public static void d() {
        u.hc();
    }

    public static void hc() {
        try {
            gb.c();
            File fileH = u.h();
            if (fileH == null || !fileH.exists()) {
                return;
            }
            if (fileH.getParentFile() != null) {
                com.bytedance.sdk.component.utils.an.b(fileH.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.an.b(fileH);
            }
        } catch (Throwable unused) {
        }
    }

    public static String b() {
        return an.b();
    }

    public static void d(com.bytedance.sdk.component.adexpress.d.b.c cVar) {
        h.d().d(cVar, cVar.an);
    }

    public static Set<com.bytedance.sdk.component.adexpress.d.b.hc> d(String str, boolean z) {
        final Set<com.bytedance.sdk.component.adexpress.d.b.hc> setHc = h.d().hc(str);
        if (setHc != null && setHc.size() > 0) {
            if (z) {
                com.bytedance.sdk.component.adexpress.c.u.d(new tt("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.d.hc.hc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hc.hc((Set<com.bytedance.sdk.component.adexpress.d.b.hc>) setHc);
                    }
                }, 5);
            } else {
                hc(setHc);
            }
        }
        return setHc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(Set<com.bytedance.sdk.component.adexpress.d.b.hc> set) {
        try {
            for (com.bytedance.sdk.component.adexpress.d.b.hc hcVar : set) {
                hcVar.d(Long.valueOf(System.currentTimeMillis()));
                an.d().d(hcVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.component.adexpress.d.b.hc d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.d.b.hc hcVarD = h.d().d(str);
        if (hcVarD != null) {
            hcVarD.d(Long.valueOf(System.currentTimeMillis()));
            d(hcVarD);
        }
        return hcVarD;
    }

    private static void d(final com.bytedance.sdk.component.adexpress.d.b.hc hcVar) {
        com.bytedance.sdk.component.adexpress.c.u.d(new tt("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.d.hc.hc.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (hc.d) {
                    an.d().d(hcVar, true);
                }
            }
        }, 10);
    }

    public static com.bytedance.sdk.component.adexpress.d.b.d c() {
        return u.hc().u();
    }

    @Deprecated
    private static String an() {
        com.bytedance.sdk.component.adexpress.d.b.d dVarC = c();
        if (dVarC == null) {
            return null;
        }
        return dVarC.c();
    }

    public static String hc(String str) {
        com.bytedance.sdk.component.adexpress.d.b.d dVar;
        com.bytedance.sdk.component.adexpress.d.b.d dVarC = c();
        if (dVarC == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.d.b.d> mapD = dVarC.d();
            if (mapD == null || mapD.size() <= 0 || (dVar = mapD.get(str)) == null) {
                return null;
            }
            return dVar.c();
        }
        return an();
    }

    public static boolean u() {
        return u.hc().c();
    }

    public static d d(String str, tc.d dVar, String str2, String str3) throws IOException {
        File fileC;
        d dVar2 = new d();
        if (TextUtils.isEmpty(str3)) {
            fileC = null;
        } else {
            fileC = hc(str3, str);
            if (fileC != null) {
                dVar2.d(1);
            }
        }
        if (fileC == null && (fileC = u(str)) != null) {
            dVar2.d(3);
        }
        if (fileC == null && (fileC = c(str)) != null) {
            dVar2.d(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!d(str, str3)) {
                dVar2.d(4);
            }
        } else if (!b(str)) {
            dVar2.d(6);
        }
        dVar2.getType();
        if (fileC != null) {
            try {
                dVar2.d(new WebResourceResponse(dVar.getType(), "utf-8", new FileInputStream(fileC)));
            } catch (Throwable th) {
                mq.b("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return dVar2;
    }

    private static boolean d(String str, String str2) {
        com.bytedance.sdk.component.adexpress.d.b.d dVarC;
        com.bytedance.sdk.component.adexpress.d.b.d dVar;
        if (!u() || (dVarC = c()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.d.b.d> mapD = dVarC.d();
        if (mapD.size() == 0 || (dVar = mapD.get(str2)) == null) {
            return false;
        }
        for (d.C0260d c0260d : dVar.getResources()) {
            if (c0260d != null && TextUtils.equals(str, c0260d.d())) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(String str) {
        com.bytedance.sdk.component.adexpress.d.b.d dVarC;
        List<d.C0260d> resources;
        if (!u() || (dVarC = c()) == null || (resources = dVarC.getResources()) == null) {
            return false;
        }
        for (d.C0260d c0260d : resources) {
            if (c0260d != null && TextUtils.equals(str, c0260d.d())) {
                return true;
            }
        }
        return false;
    }

    private static File c(String str) throws IOException {
        if (!u()) {
            return null;
        }
        for (d.C0260d c0260d : c().getResources()) {
            if (c0260d.d() != null && c0260d.d().equals(str)) {
                File file = new File(u.h(), com.bytedance.sdk.component.utils.u.hc(c0260d.d()));
                String strD = com.bytedance.sdk.component.utils.u.d(file);
                if (c0260d.hc() == null || !c0260d.hc().equals(strD)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static File u(String str) {
        List<Pair<String, String>> listHc;
        d.hc hcVarU = c().u();
        if (hcVarU == null || (listHc = hcVarU.hc()) == null || listHc.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listHc) {
            if (pair.second != null && ((String) pair.second).equals(str)) {
                return new File(u.h(), (String) pair.first);
            }
        }
        return null;
    }

    private static File hc(String str, String str2) throws IOException {
        com.bytedance.sdk.component.adexpress.d.b.d dVar;
        com.bytedance.sdk.component.adexpress.d.b.d dVarC = c();
        if (dVarC == null || !u()) {
            return null;
        }
        Map<String, com.bytedance.sdk.component.adexpress.d.b.d> mapD = dVarC.d();
        if (mapD.size() == 0 || (dVar = mapD.get(str)) == null) {
            return null;
        }
        for (d.C0260d c0260d : dVar.getResources()) {
            if (c0260d.d() != null && c0260d.d().equals(str2)) {
                File file = new File(u.h(), com.bytedance.sdk.component.utils.u.hc(c0260d.d()));
                String strD = com.bytedance.sdk.component.utils.u.d(file);
                if (c0260d.hc() == null || !c0260d.hc().equals(strD)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static boolean d(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean hc(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean b(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
