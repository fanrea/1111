package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.sigmob.sdk.base.n;
import com.ss.android.d.d.hc.sy;
import com.ss.android.downloadlib.addownload.mq;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private final AtomicInteger d;

    private static class d {
        private static an d = new an();
    }

    public static an d() {
        return d.d;
    }

    private an() {
        this.d = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hc() {
        return (this.d.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com") + "/customer/api/app/deep_link";
    }

    public void d(final com.ss.android.downloadlib.addownload.hc.u uVar, final gb gbVar) {
        if (mq.c() == null) {
            com.ss.android.downloadlib.u.b.d().d("getDownloadNetworkFactory == NULL");
            d(401, uVar);
        } else {
            com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.an.1
                @Override // java.lang.Runnable
                public void run() {
                    an anVar = an.this;
                    anVar.hc(uVar, anVar.hc(), an.this.d(uVar, true, 4), gbVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.ss.android.downloadlib.addownload.hc.u uVar, String str, byte[] bArr, gb gbVar) throws JSONException {
        if (this.d.get() < 6) {
            this.d.incrementAndGet();
            hc(uVar, str, bArr, gbVar);
        } else {
            d("当前网络不佳，请稍后再试");
            this.d.set(0);
            d(402, uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(final com.ss.android.downloadlib.addownload.hc.u uVar, final String str, final byte[] bArr, final gb gbVar) {
        mq.c().d(str, bArr, MediaTypeUtils.APPLICATION_JSON, 0, new sy() { // from class: com.ss.android.downloadlib.addownload.compliance.an.2
            @Override // com.ss.android.d.d.hc.sy
            public void d(String str2) throws JSONException {
                an.this.d(uVar, str2, gbVar);
            }

            @Override // com.ss.android.d.d.hc.sy
            public void d(Throwable th) throws JSONException {
                an.this.d(uVar, str, bArr, gbVar);
            }
        });
    }

    private void d(final String str) {
        com.ss.android.downloadlib.gb.d().hc().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.an.3
            @Override // java.lang.Runnable
            public void run() {
                mq.b().d(6, mq.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] d(com.ss.android.downloadlib.addownload.hc.u uVar, boolean z, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", uVar.d());
            jSONObject.put(n.p, uVar.u());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", mq.getContext().getPackageName());
                jSONObject.put("sender_version", mq.tc().u);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(uVar.hc()));
                if (uVar.sy().zw() != null) {
                    if (TextUtils.isEmpty(uVar.sy().zw().d())) {
                        com.ss.android.downloadlib.u.b.d().d("web_url is null");
                    }
                    jSONObject.put("web_url", uVar.sy().zw().d());
                } else {
                    com.ss.android.downloadlib.u.b.d().d("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.u.b.d().d("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.ss.android.downloadlib.addownload.hc.u uVar, String str, gb gbVar) throws JSONException {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.u.b.d().d("response content is null");
                d(404, uVar);
                gbVar.d();
                return;
            }
            this.d.set(0);
            u uVarH = u.h(str);
            if (uVarH.d() != 0) {
                d(403, uVar);
                gbVar.d();
            } else if (TextUtils.isEmpty(uVarH.hc())) {
                d(405, uVar);
                gbVar.d();
            } else {
                gbVar.d(uVarH.hc());
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void d(int i, com.ss.android.downloadlib.addownload.hc.u uVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("get_miui_market_compliance_error", jSONObject, uVar);
    }

    public void d(int i, com.ss.android.downloadlib.addownload.hc.u uVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().d("get_miui_market_compliance_success", jSONObject, uVar);
    }
}
