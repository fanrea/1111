package com.qq.e.comm.plugin;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class q00 {
    private static final String a = UUID.randomUUID().toString();

    /* compiled from: A */
    private static final class b {
        private static final a a = new a();
    }

    static /* synthetic */ String a() {
        return (String) pro.getobjresult(676, 1, new Object[0]);
    }

    public static jn b() {
        return (jn) pro.getobjresult(677, 1, new Object[0]);
    }

    private static jn c() {
        return (jn) pro.getobjresult(678, 1, new Object[0]);
    }

    /* compiled from: A */
    private static final class a {
        private JSONObject a;

        jn a() throws JSONException {
            jn jnVar = new jn();
            jnVar.a(com.baidu.mobads.container.components.command.j.s, System.currentTimeMillis());
            jnVar.a(PointCategory.APP, r1.d().b().a());
            jnVar.a(Config.EXCEPTION_CRASH_TYPE, r1.d().c().p().b());
            String strC = as.c();
            if (!TextUtils.isEmpty(strC)) {
                jnVar.a("cell_native", strC);
            }
            jnVar.a("lg", Locale.getDefault().getLanguage());
            TimeZone timeZone = TimeZone.getDefault();
            jnVar.a("tz", timeZone.getID());
            try {
                jnVar.a("gmt_tz", timeZone.getDisplayName(false, 0));
            } catch (Throwable unused) {
            }
            jnVar.a("ca", r1.d().c().d().b());
            Iterator<String> itKeys = this.a.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jnVar.a(next, this.a.opt(next));
            }
            c20.a(jnVar, "/log or /event");
            return jnVar;
        }

        a() throws JSONException {
            jn jnVar = new jn();
            jnVar.a(Config.INPUT_DEF_PKG, r1.d().b().b());
            jnVar.a(com.alipay.sdk.m.s.a.w, r1.d().b().d());
            jnVar.a("sv", su.i());
            jnVar.a("plv", r1.d().e().b());
            jnVar.a("sdk_st", su.g());
            jnVar.a("sdk_cnl", su.d());
            jnVar.a("ov", Build.VERSION.RELEASE);
            jnVar.a("al", Build.VERSION.SDK_INT);
            jnVar.a("os", 2);
            String strA = ma.IMEI.a(r1.d().a());
            jnVar.a(com.baidu.mobads.container.adrequest.g.z, strA);
            jnVar.a(Config.STAT_SDK_TYPE, 2);
            jnVar.a("muid", strA);
            jnVar.a(LiveConfigKey.MEDIUM, r1.d().c().j);
            jnVar.a(Config.PROCESS_LABEL, Build.FINGERPRINT);
            jnVar.a("mn", Build.PRODUCT);
            Pair<Integer, Integer> pairB = pa.b();
            if (((Integer) pairB.first).intValue() > ((Integer) pairB.second).intValue()) {
                jnVar.a("w", pairB.second);
                jnVar.a("h", pairB.first);
            } else {
                jnVar.a("w", pairB.first);
                jnVar.a("h", pairB.second);
            }
            jnVar.a("lid", q00.a());
            String strE = su.e();
            if (!TextUtils.isEmpty(strE)) {
                jnVar.a("sdk_ex1", strE);
            }
            String strF = su.f();
            if (!TextUtils.isEmpty(strF)) {
                jnVar.a("sdk_ex2", strF);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("is_harmony_os", Boolean.valueOf(ni.c()));
                jSONObject.putOpt("os_version", ni.a());
                jSONObject.putOpt("harmony_pure_mode", Integer.valueOf(ni.b()));
                jnVar.a("harmony_sys_info", jSONObject);
            } catch (JSONException e) {
                e.getMessage();
            }
            this.a = jnVar.a();
        }
    }
}
