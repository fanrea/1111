package com.ss.android.downloadlib.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.d.d.hc.sy;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb {
    private static final String d = "gb";

    public static com.ss.android.downloadlib.addownload.hc.h d(Context context, Uri uri) {
        Intent intent;
        if (!com.ss.android.socialbase.appdownloader.an.u.b() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.hc.h(6, 12);
        }
        try {
            String strTc = com.ss.android.socialbase.appdownloader.an.u.tc();
            if (com.ss.android.socialbase.appdownloader.an.u.w() && (TextUtils.isEmpty(strTc) || !uo.u(context, strTc))) {
                strTc = "com.huawei.appmarket";
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.scheme("market");
                intent = new Intent("android.intent.action.VIEW", builderBuildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!uo.d(context, intent)) {
                return new com.ss.android.downloadlib.addownload.hc.h(6, 13);
            }
            if (uo.u(context, strTc) && !com.ss.android.socialbase.appdownloader.an.u.h()) {
                intent.setPackage(strTc);
            }
            if (com.ss.android.socialbase.downloader.uo.d.b().d("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.u.b.d().d(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.hc.h(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hc.h(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.hc.h(6, 14);
        }
    }

    public static com.ss.android.downloadlib.addownload.hc.h d(final Context context, Uri uri, com.ss.android.downloadlib.addownload.hc.u uVar) {
        if (context == null || !com.ss.android.downloadlib.hc.tc.d(uri)) {
            return new com.ss.android.downloadlib.addownload.hc.h(6, 12);
        }
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!uo.d(context, intent)) {
                return new com.ss.android.downloadlib.addownload.hc.h(6, 13);
            }
            String strTc = com.ss.android.socialbase.appdownloader.an.u.tc();
            if (uo.u(context, strTc)) {
                intent.setPackage(strTc);
            }
            intent.addFlags(335544320);
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.mq.tc().b)) {
                com.ss.android.downloadlib.u.b.d().d(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.hc.h(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            long jOptLong = com.ss.android.downloadlib.addownload.mq.tt().optLong("market_jump_delay", 1000L);
            if (jOptLong > 0 && uVar != null && uVar.u != null && !uVar.u.i()) {
                com.ss.android.downloadlib.gb.d().hc().post(new Runnable() { // from class: com.ss.android.downloadlib.h.gb.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.mq.b().d(8, com.ss.android.downloadlib.addownload.mq.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.h.gb.2
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            return new com.ss.android.downloadlib.addownload.hc.h(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.hc.h(6, 14);
        }
    }

    public static com.ss.android.downloadlib.addownload.hc.h d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.hc.h(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.an.u.h() && uo.u(context, "com.sec.android.app.samsungapps")) {
            return c(context, str);
        }
        return d(context, com.ss.android.d.d.an.d.d(context, str));
    }

    public static com.ss.android.downloadlib.addownload.hc.h d(Context context, com.ss.android.downloadlib.addownload.hc.u uVar, String str) throws JSONException {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.hc.h(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.an.u.h() && uo.u(context, "com.sec.android.app.samsungapps")) {
            return c(context, str);
        }
        if (!uVar.hc.np() || !uVar.c.cb()) {
            return d(context, Uri.parse("market://details?id=" + str));
        }
        JSONArray jSONArrayOptJSONArray = com.ss.android.downloadlib.addownload.mq.tt().optJSONArray("am_plans");
        if (com.ss.android.socialbase.appdownloader.an.u.u() && com.ss.android.socialbase.appdownloader.an.d.d(jSONArrayOptJSONArray, "am_3")) {
            return hc(context, uVar, str);
        }
        if (com.ss.android.socialbase.appdownloader.an.u.an() && com.ss.android.socialbase.appdownloader.an.d.d(jSONArrayOptJSONArray, "am_2")) {
            u(context, uVar, str);
            return new com.ss.android.downloadlib.addownload.hc.h(7, "am_m2");
        }
        if (com.ss.android.socialbase.appdownloader.an.u.c() && com.ss.android.socialbase.appdownloader.an.d.d(jSONArrayOptJSONArray, "am_5")) {
            gb(context, uVar, str);
            return new com.ss.android.downloadlib.addownload.hc.h(7, "am_v1");
        }
        if (com.ss.android.socialbase.appdownloader.an.u.u() && com.ss.android.socialbase.appdownloader.an.d.d(jSONArrayOptJSONArray, "am_7") && (uVar.c instanceof com.ss.android.hc.d.d.d) && ((com.ss.android.hc.d.d.d) uVar.c).w()) {
            return c(context, uVar, str);
        }
        if (com.ss.android.socialbase.appdownloader.an.u.c() && com.ss.android.socialbase.appdownloader.an.d.d(jSONArrayOptJSONArray, "am_8") && uo.d(uo.b(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
            tt(context, uVar, str);
            return new com.ss.android.downloadlib.addownload.hc.h(7, "am_v2");
        }
        if ((com.ss.android.socialbase.appdownloader.an.u.d() || com.ss.android.socialbase.appdownloader.an.u.hc()) && com.ss.android.socialbase.appdownloader.an.d.d(jSONArrayOptJSONArray, "am_9")) {
            an(context, uVar, str);
            return new com.ss.android.downloadlib.addownload.hc.h(7, "am_hr");
        }
        if ((com.ss.android.socialbase.appdownloader.an.u.d() || com.ss.android.socialbase.appdownloader.an.u.hc()) && com.ss.android.socialbase.appdownloader.an.d.d(jSONArrayOptJSONArray, "am_10")) {
            h(context, uVar, str);
            return new com.ss.android.downloadlib.addownload.hc.h(7, "am_hr2");
        }
        if ((uVar.c instanceof com.ss.android.hc.d.d.d) && ((com.ss.android.hc.d.d.d) uVar.c).w() && ((com.ss.android.hc.d.d.d) uVar.c).yo() != null && uVar.hc.yo().optInt("is_use_obm_convert", 0) == 1) {
            b(context, uVar, str);
            return new com.ss.android.downloadlib.addownload.hc.h(7, "am_kllk4");
        }
        return d(context, com.ss.android.d.d.an.d.d(context, str));
    }

    private static com.ss.android.downloadlib.addownload.hc.h c(Context context, String str) {
        try {
            Uri uri = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hc.h(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.hc.h(6, 14);
        }
    }

    public static boolean d(Context context, com.ss.android.downloadlib.addownload.hc.u uVar, String str, JSONObject jSONObject, boolean z, int i) throws JSONException {
        uo.d(jSONObject, "download_scene", Integer.valueOf(uVar.jh()));
        com.ss.android.downloadlib.c.d.d().hc("market_click_open", jSONObject, uVar);
        com.ss.android.downloadlib.addownload.hc.h hVarD = d(context, Uri.parse(str));
        String strD = uo.d(hVarD.hc(), PointCategory.OPEN_MARKET);
        int type = hVarD.getType();
        if (type == 5) {
            com.ss.android.downloadlib.hc.d.d(strD, jSONObject, uVar, true);
        } else {
            if (type == 6) {
                uo.d(jSONObject, "error_code", Integer.valueOf(hVarD.d()));
                uo.d(jSONObject, "download_scene", Integer.valueOf(uVar.jh()));
                com.ss.android.downloadlib.c.d.d().hc("market_open_failed", jSONObject, uVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        if (z) {
            com.ss.android.downloadlib.c.d.d().d(uVar.d, i);
        }
        return true;
    }

    private static com.ss.android.downloadlib.addownload.hc.h hc(Context context, com.ss.android.downloadlib.addownload.hc.u uVar, String str) throws JSONException {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", uVar.d);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hc.h(7, "am_kllk2");
        } catch (Throwable unused) {
            hc(uVar, jSONObject, 1, 3, "market://details?id=" + str);
            return d(context, Uri.parse("market://details?id=" + str));
        }
    }

    private static void b(Context context, com.ss.android.downloadlib.addownload.hc.u uVar, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.d(context, str, uVar.d);
        } catch (Exception unused) {
            com.ss.android.downloadlib.hc.d.d(d(context, Uri.parse("market://details?id=" + str)), uVar, true);
            hc(uVar, jSONObject, 14, 11, "market://details?id=" + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.hc.h c(Context context, com.ss.android.downloadlib.addownload.hc.u uVar, String str) throws JSONException {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra("p", str);
        intent.putExtra("id", uVar.d);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (uo.u(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else if (uo.u(context, "com.coloros.browser")) {
            intent.putExtra("bk", "com.coloros.browser");
        } else {
            return d(context, Uri.parse("market://details?id=" + str));
        }
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hc.h(7, "am_kllk3");
        } catch (Throwable unused) {
            hc(uVar, jSONObject, 1, 3, "market://details?id=" + str);
            return d(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static void d(Context context, String str, long j, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        try {
            JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
            String strOptString = jSONObjectTt.optString("s");
            String strD = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("aa"), strOptString);
            String strD2 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("ac"), strOptString);
            String strD3 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("af"), strOptString);
            boolean zD = com.ss.android.socialbase.appdownloader.an.d.d(jSONObjectTt, context, strD2);
            StringBuilder sb = new StringBuilder(String.format(strD, str, strD3, strD2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strTc = com.ss.android.socialbase.appdownloader.an.u.tc();
            if (uo.u(context, strTc)) {
                intent.setPackage(strTc);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            uo.d(jSONObject, "mf", Boolean.valueOf(zD));
            uo.d(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            com.ss.android.downloadlib.hc.d.d("am_kllk2", jSONObject, uVarU, true);
            if (zD) {
                hc(uVarU, jSONObject, -1, 3, sb.toString());
            } else {
                hc(uVarU, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.hc.d.d(d(com.ss.android.downloadlib.addownload.mq.getContext(), Uri.parse("market://details?id=" + str)), uVarU, true);
            hc(uVarU, jSONObject, 2, 3, "market://details?id=" + str);
        }
    }

    public static void d(final Context context, String str, long j, String str2, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        try {
            JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
            String strOptString = jSONObjectTt.optString("s");
            String strD = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("br"), strOptString);
            String strD2 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bs_1"), strOptString);
            String strD3 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bs_2"), strOptString);
            String strD4 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bs_3"), strOptString);
            String strD5 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bt"), strOptString);
            String strD6 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bu"), strOptString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(strD).append(strD2).append(strD3).append(strD4).append(strD5).append(strD6);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            uo.d(jSONObject, "dl", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            long jOptLong = com.ss.android.downloadlib.addownload.mq.tt().optLong("oppo_browser_jump_delay", 1000L);
            if (jOptLong > 0) {
                com.ss.android.downloadlib.gb.d().hc().post(new Runnable() { // from class: com.ss.android.downloadlib.h.gb.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.mq.b().d(12, com.ss.android.downloadlib.addownload.mq.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.h.gb.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            if (uVarU.u != null) {
                uVarU.u.de(true);
            }
            com.ss.android.downloadlib.hc.d.d("am_kllk3", jSONObject, uVarU, true);
            hc(uVarU, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            if (uVarU.u != null) {
                uVarU.u.de(false);
            }
            com.ss.android.downloadlib.hc.d.d(d(com.ss.android.downloadlib.addownload.mq.getContext(), Uri.parse("market://details?id=" + str), uVarU), uVarU, true);
            hc(uVarU, jSONObject, 2, 7, "market://details?id=" + str);
        }
    }

    private static boolean d(Activity activity, String str, HashMap<String, String> map) throws JSONException {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra("param", map);
        String strTc = com.ss.android.socialbase.appdownloader.an.u.tc();
        if (uo.u(com.ss.android.downloadlib.addownload.mq.getContext(), strTc)) {
            intent.setPackage(strTc);
        }
        if (!uo.d(com.ss.android.downloadlib.addownload.mq.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "start v1");
            return false;
        }
    }

    private static void u(final Context context, final com.ss.android.downloadlib.addownload.hc.u uVar, final String str) {
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.h.gb.5
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                com.ss.android.downloadlib.hc.d.d(gb.d(context, Uri.parse("market://details?id=" + str)), uVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
                    Thread.sleep(jSONObjectTt.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.d.d.d.d().d(context, true);
                    com.ss.android.downloadlib.d.d.hc hcVar = new com.ss.android.downloadlib.d.d.hc();
                    hcVar.d = 1;
                    hcVar.hc = 0;
                    String strD = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("v"), jSONObjectTt.optString("s"));
                    hcVar.b = String.format(strD, str);
                    com.ss.android.downloadlib.d.d.d.d().d(hcVar, (com.ss.android.downloadlib.d.d.c) null);
                    com.ss.android.downloadlib.d.d.d.d().hc();
                    gb.hc(uVar, jSONObject, -1, 2, String.format(strD, str));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                    gb.hc(uVar, jSONObject, 1, 2, "market://details?id=" + str);
                }
            }
        });
    }

    private static void an(final Context context, final com.ss.android.downloadlib.addownload.hc.u uVar, final String str) {
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.h.gb.6
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String strOptString = jSONObjectTt.optString("s");
                    String strD = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bw"), strOptString);
                    String strD2 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bx"), strOptString);
                    String strD3 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("by"), strOptString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(strD).appendPath(strD2).appendQueryParameter(strD3, str);
                    com.ss.android.downloadlib.addownload.mq.c().d("GET", builder.build().toString(), null, new sy() { // from class: com.ss.android.downloadlib.h.gb.6.1
                        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
                        @Override // com.ss.android.d.d.hc.sy
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void d(java.lang.String r6) throws org.json.JSONException {
                            /*
                                r5 = this;
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                r1 = 1
                                if (r0 != 0) goto L2c
                                java.lang.String r6 = com.ss.android.downloadlib.h.gb.d(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L2c
                                java.lang.String r6 = com.ss.android.downloadlib.h.gb.hc(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L2c
                                com.ss.android.downloadlib.h.gb$6 r0 = com.ss.android.downloadlib.h.gb.AnonymousClass6.this
                                android.content.Context r0 = r2
                                com.ss.android.downloadlib.h.gb$6 r2 = com.ss.android.downloadlib.h.gb.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.hc.u r2 = r3
                                com.ss.android.downloadlib.h.gb$6 r3 = com.ss.android.downloadlib.h.gb.AnonymousClass6.this
                                java.lang.String r3 = r1
                                com.ss.android.downloadlib.h.gb.d(r0, r2, r3, r6)
                                r6 = r1
                                goto L2d
                            L2c:
                                r6 = 0
                            L2d:
                                if (r6 != 0) goto L73
                                com.ss.android.downloadlib.h.gb$6 r6 = com.ss.android.downloadlib.h.gb.AnonymousClass6.this
                                android.content.Context r6 = r2
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                java.lang.String r2 = "market://details?id="
                                r0.<init>(r2)
                                com.ss.android.downloadlib.h.gb$6 r3 = com.ss.android.downloadlib.h.gb.AnonymousClass6.this
                                java.lang.String r3 = r1
                                java.lang.StringBuilder r0 = r0.append(r3)
                                java.lang.String r0 = r0.toString()
                                android.net.Uri r0 = android.net.Uri.parse(r0)
                                com.ss.android.downloadlib.addownload.hc.h r6 = com.ss.android.downloadlib.h.gb.d(r6, r0)
                                com.ss.android.downloadlib.h.gb$6 r0 = com.ss.android.downloadlib.h.gb.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.hc.u r0 = r3
                                com.ss.android.downloadlib.hc.d.d(r6, r0, r1)
                                com.ss.android.downloadlib.h.gb$6 r6 = com.ss.android.downloadlib.h.gb.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.hc.u r6 = r3
                                org.json.JSONObject r0 = r2
                                r1 = 10
                                r3 = 9
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                r4.<init>(r2)
                                com.ss.android.downloadlib.h.gb$6 r2 = com.ss.android.downloadlib.h.gb.AnonymousClass6.this
                                java.lang.String r2 = r1
                                java.lang.StringBuilder r2 = r4.append(r2)
                                java.lang.String r2 = r2.toString()
                                com.ss.android.downloadlib.h.gb.d(r6, r0, r1, r3, r2)
                            L73:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.h.gb.AnonymousClass6.AnonymousClass1.d(java.lang.String):void");
                        }

                        @Override // com.ss.android.d.d.hc.sy
                        public void d(Throwable th) throws JSONException {
                            com.ss.android.downloadlib.hc.d.d(gb.d(context, Uri.parse("market://details?id=" + str)), uVar, true);
                            uo.d(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : ILogConst.CACHE_PLAY_REASON_NULL);
                            gb.hc(uVar, jSONObject, 11, 9, "market://details?id=" + str);
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                    gb.hc(uVar, jSONObject, 4, 9, "market://details?id=" + str);
                }
            }
        });
    }

    private static void h(Context context, com.ss.android.downloadlib.addownload.hc.u uVar, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.d(str, uVar.d);
        } catch (Exception unused) {
            com.ss.android.downloadlib.hc.d.d(d(context, Uri.parse("market://details?id=" + str)), uVar, true);
            hc(uVar, jSONObject, 13, 10, "market://details?id=" + str);
        }
    }

    private static void gb(final Context context, final com.ss.android.downloadlib.addownload.hc.u uVar, final String str) {
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.h.gb.7
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
                String strOptString = jSONObjectTt.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String strD = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                uo.d(jSONObject2, "t", "v");
                uo.d(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.mq.c().d(strD, com.ss.android.downloadlib.addownload.mq.yo().d(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new sy() { // from class: com.ss.android.downloadlib.h.gb.7.1
                    @Override // com.ss.android.d.d.hc.sy
                    public void d(String str2) throws JSONException {
                        gb.hc(context, str, str2, uVar, jSONObject);
                    }

                    @Override // com.ss.android.d.d.hc.sy
                    public void d(Throwable th) throws JSONException {
                        com.ss.android.downloadlib.hc.d.d(gb.d(context, Uri.parse("market://details?id=" + str)), uVar, true);
                        uo.d(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : ILogConst.CACHE_PLAY_REASON_NULL);
                        gb.hc(uVar, jSONObject, 7, 5, "market://details?id=" + str);
                    }
                });
            }
        });
    }

    private static void tt(Context context, com.ss.android.downloadlib.addownload.hc.u uVar, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.d(str, uVar.d, "need_comment");
        } catch (Exception unused) {
            com.ss.android.downloadlib.hc.d.d(d(context, Uri.parse("market://details?id=" + str)), uVar, true);
            hc(uVar, jSONObject, 9, 8, "market://details?id=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(Context context, String str, String str2, com.ss.android.downloadlib.addownload.hc.u uVar, JSONObject jSONObject) throws JSONException {
        uo.d(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String strD = com.ss.android.socialbase.appdownloader.an.b.d(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(strD)) {
                TTDelegateActivity.d(str, uVar.d, strD, jSONObject);
            } else {
                com.ss.android.downloadlib.hc.d.d(d(context, Uri.parse("market://details?id=" + str)), uVar, true);
                hc(uVar, jSONObject, 5, 5, "market://details?id=" + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.hc.d.d(d(context, Uri.parse("market://details?id=" + str)), uVar, true);
            hc(uVar, jSONObject, 6, 5, "market://details?id=" + str);
        }
    }

    public static void d(Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        try {
            JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
            boolean zD = com.ss.android.socialbase.appdownloader.an.d.d(jSONObjectTt, activity, com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bg"), jSONObjectTt.optString("s")));
            HashMap<String, String> mapHc = uo.hc(new JSONObject(str2));
            if (zD && !mapHc.isEmpty() && d(activity, str, mapHc)) {
                hc(uVarU, jSONObject, -1, 5, "market://details?id=" + str);
                com.ss.android.downloadlib.hc.d.d("am_v1", jSONObject, uVarU, true);
                return;
            }
            if (zD) {
                i = mapHc.isEmpty() ? 1 : 2;
            } else {
                i = 3;
            }
            hc(uVarU, jSONObject, i, 5, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d(d((Context) activity, Uri.parse("market://details?id=" + str)), uVarU, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.hc.d.d(d(com.ss.android.downloadlib.addownload.mq.getContext(), Uri.parse("market://details?id=" + str)), uVarU, true);
            hc(uVarU, jSONObject, 4, 5, "market://details?id=" + str);
        }
    }

    public static void d(Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
        String strD = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bv"), jSONObjectTt.optString("s"));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority("details").appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(strD)) {
            builder.appendQueryParameter(strD, str2);
        }
        if (d(activity, builder.build())) {
            hc(uVarU, jSONObject, -1, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d("am_v2", jSONObject, uVarU, true);
        } else {
            hc(uVarU, jSONObject, 2, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d(d((Context) activity, Uri.parse("market://details?id=" + str)), uVarU, true);
        }
    }

    public static boolean d(Activity activity, Uri uri) throws JSONException {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strTc = com.ss.android.socialbase.appdownloader.an.u.tc();
        if (uo.u(com.ss.android.downloadlib.addownload.mq.getContext(), strTc)) {
            intent.setPackage(strTc);
        }
        if (!uo.d(com.ss.android.downloadlib.addownload.mq.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "start v2");
            return false;
        }
    }

    public static boolean hc(Activity activity, Uri uri) throws JSONException {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strTc = com.ss.android.socialbase.appdownloader.an.u.tc();
        if (uo.u(com.ss.android.downloadlib.addownload.mq.getContext(), strTc)) {
            intent.setPackage(strTc);
        }
        if (!uo.d(com.ss.android.downloadlib.addownload.mq.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "start HM1");
            return false;
        }
    }

    public static boolean b(Activity activity, Uri uri) throws JSONException {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strTc = com.ss.android.socialbase.appdownloader.an.u.tc();
        if (uo.u(com.ss.android.downloadlib.addownload.mq.getContext(), strTc)) {
            intent.setPackage(strTc);
        }
        if (!uo.d(com.ss.android.downloadlib.addownload.mq.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "start HM2");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(com.ss.android.downloadlib.addownload.hc.u uVar, JSONObject jSONObject, int i, int i2, String str) throws JSONException {
        uo.d(jSONObject, "error_code", Integer.valueOf(i));
        uo.d(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        uo.d(jSONObject, "rmu", str);
        uo.d(jSONObject, com.ss.android.socialbase.appdownloader.an.u.tc(), Integer.valueOf(uo.hc(com.ss.android.downloadlib.addownload.mq.getContext(), com.ss.android.socialbase.appdownloader.an.u.tc())));
        com.ss.android.downloadlib.c.d.d().hc("am_result", jSONObject, uVar);
    }

    static com.ss.android.downloadlib.addownload.hc.h hc(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.hc.h(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.mq.getContext();
        }
        Intent intentH = uo.h(context, str);
        if (intentH == null) {
            return new com.ss.android.downloadlib.addownload.hc.h(4, 22);
        }
        intentH.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intentH);
            return new com.ss.android.downloadlib.addownload.hc.h(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.hc.h(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.hc.h d(Context context, String str, com.ss.android.hc.d.hc.d dVar) {
        Intent intentD = d(context, dVar, str, 1, (String) null);
        if (intentD != null) {
            mq.d().d(d, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.ss.android.downloadlib.addownload.hc.h hVarD = d(intentD, true, context, str, dVar);
            if (hVarD.getType() == 3) {
                return hVarD;
            }
        }
        Intent intentH = uo.h(context, str);
        if (intentH == null) {
            return new com.ss.android.downloadlib.addownload.hc.h(4, 22);
        }
        return d(intentH, false, context, str, dVar);
    }

    private static com.ss.android.downloadlib.addownload.hc.h d(Intent intent, boolean z, Context context, String str, com.ss.android.hc.d.hc.d dVar) {
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.mq.tt().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.mq.mq() != null && com.ss.android.downloadlib.addownload.mq.mq().d() && dVar.w() && !z) {
            TTDelegateActivity.hc(str, dVar);
            return new com.ss.android.downloadlib.addownload.hc.h(3);
        }
        intent.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hc.h(3);
        } catch (Exception e) {
            if (z) {
                mq.d().hc(d, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.hc.h(8, 23);
            }
            mq.d().hc(d, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e.getMessage());
            return new com.ss.android.downloadlib.addownload.hc.h(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.hc.h d(String str, com.ss.android.hc.d.hc.d dVar) {
        return d(com.ss.android.downloadlib.addownload.mq.getContext(), str, dVar);
    }

    static com.ss.android.downloadlib.addownload.hc.h hc(String str, com.ss.android.hc.d.hc.d dVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.hc.h(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.mq.getContext();
        String strHe = dVar.sy().he();
        if (!TextUtils.isEmpty(strHe)) {
            mq.d().d(d, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            Intent intentD = d(context, dVar, strHe, 2, str);
            if (intentD != null) {
                com.ss.android.downloadlib.addownload.hc.h hVarD = d(context, intentD, dVar, true, str);
                if (hVarD.getType() == 1) {
                    return hVarD;
                }
            }
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra("start_only_for_android", true);
        if (com.ss.android.socialbase.downloader.uo.d.b().d("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        return d(context, intent, dVar, false, str);
    }

    private static com.ss.android.downloadlib.addownload.hc.h d(Context context, Intent intent, com.ss.android.hc.d.hc.d dVar, boolean z, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.mq.getContext();
        }
        if (uo.hc(context, intent)) {
            if (com.ss.android.downloadlib.addownload.mq.tt().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.mq.mq() != null && com.ss.android.downloadlib.addownload.mq.mq().d() && Build.VERSION.SDK_INT >= 26 && dVar.w() && !z) {
                TTDelegateActivity.d(str, dVar);
                return new com.ss.android.downloadlib.addownload.hc.h(1);
            }
            try {
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.hc.h(1);
            } catch (Exception e) {
                if (z) {
                    mq.d().hc(d, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e.getMessage());
                    return new com.ss.android.downloadlib.addownload.hc.h(9);
                }
                mq.d().hc(d, "realTryOpenByUrl", "url调起失败了，抛出异常" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.hc.h(2);
            }
        }
        return new com.ss.android.downloadlib.addownload.hc.h(2, 24);
    }

    static com.ss.android.downloadlib.addownload.hc.h d(com.ss.android.hc.d.hc.hc hcVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.hc.h hVarHc = hc(str, hcVar);
        return (com.ss.android.downloadlib.hc.an.d(hcVar) && hVarHc.getType() == 2) ? d(str2, hcVar) : hVarHc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(Context context, com.ss.android.downloadlib.addownload.hc.u uVar, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.hc(str, uVar.d, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.hc.d.d(d(context, Uri.parse("market://details?id=" + str)), uVar, true);
            hc(uVar, jSONObject, 12, 9, "market://details?id=" + str);
        }
    }

    public static void hc(Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
        String strOptString = jSONObjectTt.optString("s");
        String strD = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("bz"), strOptString);
        String strD2 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("ca"), strOptString);
        String strD3 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("cb"), strOptString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("hiapplink").authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(strD)) {
            builder.appendQueryParameter(strD, str2);
        }
        if (!TextUtils.isEmpty(strD2) && !TextUtils.isEmpty(strD3)) {
            builder.appendQueryParameter(strD2, strD3);
        }
        if (hc(activity, builder.build())) {
            hc(uVarU, jSONObject, -1, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d("am_hr", jSONObject, uVarU, true);
        } else {
            hc(uVarU, jSONObject, 2, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d(d((Context) activity, Uri.parse("market://details?id=" + str)), uVarU, true);
        }
    }

    public static void d(Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectTt = com.ss.android.downloadlib.addownload.mq.tt();
        String strOptString = jSONObjectTt.optString("s");
        String strD = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("ca"), strOptString);
        String strD2 = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("cc"), strOptString);
        StringBuilder sb = new StringBuilder("market://details?id=");
        if (!TextUtils.isEmpty(strD) && !TextUtils.isEmpty(strD2)) {
            sb.append(str).append(a.n).append(strD).append("=").append(strD2);
        }
        if (b(activity, Uri.parse(sb.toString()))) {
            hc(uVarU, jSONObject, -1, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d("am_hr2", jSONObject, uVarU, true);
        } else {
            hc(uVarU, jSONObject, 2, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d(d((Context) activity, Uri.parse("market://details?id=" + str)), uVarU, true);
        }
    }

    public static void hc(Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        JSONObject jSONObject = new JSONObject();
        boolean zW = ((com.ss.android.hc.d.d.d) uVarU.c).w();
        HashMap map = new HashMap();
        map.put("is_button", Boolean.valueOf(zW));
        uo.d(jSONObject, "is_button", Boolean.valueOf(zW));
        Map<String, Object> mapD = ((com.ss.android.hc.d.d.d) uVarU.c).yo().d(map);
        if (mapD != null && mapD.get("convert_result") != null && Boolean.parseBoolean(mapD.get("convert_result").toString())) {
            hc(uVarU, jSONObject, -1, 11, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d("am_kllk4", jSONObject, uVarU, true);
        } else {
            hc(uVarU, jSONObject, 15, 11, "market://details?id=" + str);
            com.ss.android.downloadlib.hc.d.d(d((Context) activity, Uri.parse("market://details?id=" + str)), uVarU, true);
        }
    }

    static boolean b(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String strGroup = matcher.find() ? matcher.group() : "";
        if (!strGroup.equals(null) && strGroup.length() > 0) {
            for (String str2 : strGroup.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith(com.alipay.sdk.m.p0.b.d)) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    private static Intent d(Context context, com.ss.android.hc.d.hc.d dVar, String str, int i, String str2) {
        if (!dVar.b() || dVar.v() == null || dVar.v().hc() != 2 || dVar.sy() == null || u.d(dVar).d("app_link_market_open_add_info", 0) != 1) {
            return null;
        }
        String strB = com.ss.android.downloadlib.addownload.tt.b(dVar.sy());
        String strC = com.ss.android.downloadlib.addownload.tt.c(dVar.sy());
        Intent intent = new Intent();
        intent.setClassName(str, "com.bytedance.ads.convert.BDBridgeActivity");
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (TextUtils.isEmpty(strB) || resolveInfoResolveActivity == null) {
            return null;
        }
        intent.putExtra("click_id", strB);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        if (!TextUtils.isEmpty(strC)) {
            intent.putExtra("intent_extra", strC);
        }
        if (i == 2 && !TextUtils.isEmpty(str2)) {
            intent.putExtra("open_url", str2);
        }
        return intent;
    }
}
