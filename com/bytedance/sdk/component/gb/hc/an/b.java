package com.bytedance.sdk.component.gb.hc.an;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.utils.mq;
import com.kwai.video.player.KsMediaMeta;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements hc {
    private com.bytedance.sdk.component.gb.d.u b;
    private final Context d;
    private final u hc;

    public b(u uVar, com.bytedance.sdk.component.gb.d.u uVar2) {
        this.d = uVar2.getContext();
        this.hc = uVar;
        this.b = uVar2;
    }

    public Context getContext() {
        Context context = this.d;
        return context == null ? this.b.getContext() : context;
    }

    @Override // com.bytedance.sdk.component.gb.hc.an.hc
    public void d(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        com.bytedance.sdk.component.gb.d.c cVarC = this.b.c();
        if (cVarC == null || this.b.getContext() == null || cVarC.gb() == null || !cVarC.c() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            cVarC.gb().execute(new d(new c(UUID.randomUUID().toString() + Config.replace + System.currentTimeMillis(), it.next(), z, 5, jSONObject, 1), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.an.hc
    public void d(final String str) {
        com.bytedance.sdk.component.gb.d.c cVarC = this.b.c();
        if (cVarC == null || this.b.getContext() == null || !cVarC.c()) {
            return;
        }
        com.bytedance.sdk.component.gb.hc.u.hc hcVar = new com.bytedance.sdk.component.gb.hc.u.hc("trackFailedUrls") { // from class: com.bytedance.sdk.component.gb.hc.an.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.d(b.this.hc.d(), str);
            }
        };
        hcVar.d(1);
        if (cVarC.gb() != null) {
            cVarC.gb().execute(hcVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<c> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.gb.d.c cVarC = this.b.c();
        for (c cVar : list) {
            if (cVarC != null && cVarC.gb() != null) {
                cVarC.gb().execute(new d(cVar, str, null));
            }
        }
    }

    private class d extends com.bytedance.sdk.component.gb.hc.u.hc {
        private final String b;
        private final Map<String, String> c;
        private final c hc;

        private d(c cVar, String str, Map<String, String> map) {
            super("AdsStats");
            this.hc = cVar;
            this.b = str;
            this.c = map;
        }

        private String b(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.b)) ? str.replace("{UID}", this.b).replace("__UID__", this.b) : str;
        }

        boolean d(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        String hc(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(b.hc().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                mq.d(e);
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.gb.d.d.u uVarD;
            com.bytedance.sdk.component.gb.d.c cVarC = b.this.b.c();
            if (cVarC == null || b.this.b.getContext() == null || !cVarC.c()) {
                return;
            }
            if (!d(this.hc.b())) {
                c cVar = this.hc;
                d(null, cVarC, cVar, cVar.b(), "not http url");
                return;
            }
            if (this.hc.u() == 0) {
                b.this.hc.delete(this.hc);
                c cVar2 = this.hc;
                d(null, cVarC, cVar2, cVar2.b(), "retry max");
                return;
            }
            try {
                if (this.hc.u() == 5) {
                    b.this.hc.insert(this.hc);
                }
                if (!cVarC.d(b.this.getContext())) {
                    c cVar3 = this.hc;
                    d(null, cVarC, cVar3, cVar3.b(), "no net");
                    return;
                }
                System.currentTimeMillis();
                String strB = this.hc.b();
                if (cVarC.tc() == 0) {
                    strB = b(this.hc.b());
                    if (this.hc.c()) {
                        strB = hc(strB);
                    }
                }
                String str = strB;
                com.bytedance.sdk.component.gb.d.d.hc hcVarH = cVarC.h();
                if (hcVarH == null) {
                    d(null, this.hc, str, "no executor");
                    return;
                }
                hcVarH.d("User-Agent", cVarC.u());
                hcVarH.d("csj_client_source_from", "1");
                if (this.c != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.c.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    hcVarH.d("csj_extra_info", jSONObject.toString());
                }
                hcVarH.d(str);
                try {
                    uVarD = hcVarH.d();
                } catch (Throwable unused) {
                    uVarD = null;
                }
                if (uVarD != null && uVarD.d()) {
                    b.this.hc.delete(this.hc);
                    com.bytedance.sdk.component.gb.d.u unused2 = b.this.b;
                    System.currentTimeMillis();
                } else {
                    if (uVarD != null && uVarD.b() == 8848) {
                        uVarD.c();
                        b.this.hc.delete(this.hc);
                    }
                    com.bytedance.sdk.component.gb.d.u unused3 = b.this.b;
                    this.hc.d(r0.u() - 1);
                    if (this.hc.u() == 0) {
                        b.this.hc.delete(this.hc);
                        com.bytedance.sdk.component.gb.d.u unused4 = b.this.b;
                    } else {
                        b.this.hc.update(this.hc);
                    }
                    if (uVarD != null) {
                        uVarD.c();
                        System.currentTimeMillis();
                    } else {
                        System.currentTimeMillis();
                    }
                }
                d(uVarD, cVarC, this.hc, str, null);
            } catch (Throwable unused5) {
            }
        }

        private void d(com.bytedance.sdk.component.gb.d.d.u uVar, com.bytedance.sdk.component.gb.d.c cVar, c cVar2, String str, String str2) {
            try {
                cVar.d(this.hc.d(), d(uVar, cVar2, str, str2));
            } catch (Exception e) {
                mq.d(e);
            }
        }

        private JSONObject d(com.bytedance.sdk.component.gb.d.d.u uVar, c cVar, String str, String str2) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (cVar == null) {
                return jSONObject;
            }
            try {
                jSONObject.put("retry_count", 5 - cVar.u());
                JSONObject jSONObjectD = cVar.d();
                if (jSONObjectD != null) {
                    jSONObject.put("track_type", jSONObjectD.optString("track_type", ""));
                }
                jSONObject.put("url", str);
                jSONObject.put("current", System.currentTimeMillis());
                jSONObject.put("error_msg", str2);
                if (uVar != null) {
                    jSONObject.put(KsMediaMeta.KSM_KEY_HTTP_CODE, uVar.b());
                    String strHc = uVar.hc();
                    if (!TextUtils.isEmpty(strHc)) {
                        if (strHc.length() > 5000) {
                            strHc = strHc.substring(0, 5000);
                        }
                        jSONObject.put("http_response", strHc);
                    }
                    jSONObject.put("success", uVar.d() ? 1 : 0);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random hc() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
