package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.m.s.a;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.n;
import com.ss.android.d.d.hc.sy;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.b;
import com.ss.android.downloadlib.h.uo;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    private SoftReference<Activity> d;

    private static class d {
        private static hc d = new hc();
    }

    public static hc d() {
        return d.d;
    }

    private hc() {
    }

    public void d(long j) {
        TTDelegateActivity.d(j);
    }

    public boolean d(com.ss.android.d.d.b.b bVar) {
        if (!bVar.np() || mq.tt().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String strD = bVar.zw() == null ? null : bVar.zw().d();
        return (TextUtils.isEmpty(strD) || Pattern.compile(mq.tt().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(strD).matches()) ? false : true;
    }

    public boolean d(com.ss.android.downloadlib.addownload.hc.u uVar) throws JSONException {
        long jD;
        long j;
        if (!TextUtils.isEmpty(uVar.hc.yi())) {
            try {
                jD = uo.d(new JSONObject(uVar.hc.yi()), "convert_id");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
                jD = 0;
            }
            if (jD <= 0) {
                h.d(3, uVar);
            }
            j = jD;
        } else {
            h.d(9, uVar);
            com.ss.android.downloadlib.u.b.d().d("requestAppInfo getLogExtra null");
            j = 0;
        }
        final long j2 = uVar.d;
        com.ss.android.downloadlib.addownload.hc.hc hcVarD = b.d().d(j, j2);
        if (hcVarD != null) {
            c.d().d(hcVarD.d(), j2, hcVarD.c);
            d(hcVarD.d());
            h.d("lp_app_dialog_try_show", uVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=").append(j);
        }
        if (!TextUtils.isEmpty(uVar.hc.he())) {
            if (sb.length() > 0) {
                sb.append(a.n);
            }
            sb.append("package_name=").append(uVar.hc.he());
        }
        if (sb.length() <= 0) {
            h.d(6, uVar);
            return false;
        }
        final long j3 = j;
        com.ss.android.downloadlib.h.b.d((b.d<String, R>) new b.d<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.hc.2
            @Override // com.ss.android.downloadlib.h.b.d
            public Boolean d(String str) {
                final boolean[] zArr = {false};
                mq.c().d("GET", str, new HashMap(), new sy() { // from class: com.ss.android.downloadlib.addownload.compliance.hc.2.1
                    @Override // com.ss.android.d.d.hc.sy
                    public void d(String str2) {
                        zArr[0] = hc.this.d(j3, j2, str2);
                    }

                    @Override // com.ss.android.d.d.hc.sy
                    public void d(Throwable th) throws JSONException {
                        h.d(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).d(new b.d<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.hc.1
            @Override // com.ss.android.downloadlib.h.b.d
            public Object d(Boolean bool) {
                if (bool.booleanValue()) {
                    hc.this.d(com.ss.android.downloadlib.addownload.hc.hc.d(j3, j2));
                    h.hc("lp_app_dialog_try_show", j2);
                    return null;
                }
                hc.this.hc(j2);
                return null;
            }
        }).d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(long j, long j2, String str) throws JSONException {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("package");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.hc.hc hcVar = new com.ss.android.downloadlib.addownload.hc.hc();
                hcVar.d = j;
                hcVar.hc = j2;
                hcVar.c = jSONObjectOptJSONObject.optString("icon_url");
                hcVar.u = jSONObjectOptJSONObject.optString("app_name");
                hcVar.b = jSONObjectOptJSONObject.optString(n.p);
                hcVar.an = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                hcVar.h = jSONObjectOptJSONObject.optString("developer_name");
                hcVar.tt = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i);
                        hcVar.gb.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                b.d().d(hcVar);
                c.d().d(hcVar.d(), j2, hcVar.c);
                return true;
            }
            h.d(7, j2);
            return false;
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "AdLpComplianceManager parseResponse");
            h.d(7, j2);
            return false;
        }
    }

    public void hc(long j) {
        com.ss.android.downloadlib.addownload.u uVarD = com.ss.android.downloadlib.gb.d().d(com.ss.android.downloadlib.addownload.hc.an.d().u(j).hc.d());
        if (uVarD != null) {
            uVarD.d(true, true);
        } else {
            h.d(11, j);
            com.ss.android.downloadlib.u.b.d().hc("startDownload handler null");
        }
    }

    public void d(Activity activity) {
        this.d = new SoftReference<>(activity);
    }

    public Activity hc() {
        Activity activity = this.d.get();
        this.d = null;
        return activity;
    }
}
