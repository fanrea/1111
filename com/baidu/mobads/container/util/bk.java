package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.container.components.j.c;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.t;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bk {
    public static final String a = "install_sent";
    public static final long b = 86400000;
    public static final int c = 3000;
    public static final String d = "PackageUtils";
    public static int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static final int o = 8;
    public static final int p = 9;
    public static final int q = 10;
    public static final int r = 11;
    public static final int s = 12;
    public static final int t = 13;
    public static final int u = 14;
    public static final int v = 15;
    public static final int w = 16;
    public static final int x = 17;
    public static final int y = 18;
    public static JSONArray z;
    public static JSONArray e = null;
    public static int f = 3000;
    public static HashMap<String, String> A = new HashMap<>();
    public static int B = 1;
    public static int C = 2;
    public static int D = 3;
    public static int E = 4;
    public static int F = 5;
    public static int G = 6;
    public static int H = 7;
    public static int I = 8;
    public static int J = 9;

    /* renamed from: K, reason: collision with root package name */
    public static int f741K = 10;
    public static int L = 414;
    public static int M = 418;

    public static synchronized JSONArray a(Context context) {
        if (!bl.a("permission_app_list")) {
            return new JSONArray();
        }
        if (e == null) {
            g(context);
        }
        return e;
    }

    private static synchronized void g(Context context) {
    }

    public static synchronized JSONArray b(Context context) {
        if (!bl.a("permission_app_list")) {
            return new JSONArray();
        }
        if (z == null) {
            g(context);
        }
        return z;
    }

    public static PackageInfo a(Context context, String str, int i2) {
        try {
            if (com.baidu.mobads.container.h.a.a().j()) {
                return context.getPackageManager().getPackageInfo(str, i2);
            }
            return null;
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.c(th);
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3, com.baidu.mobads.container.adrequest.j jVar, String str4, int i2, int i3, int i4, HashMap<String, String> map) throws Throwable {
        StringBuilder sb;
        boolean z2;
        List<ResolveInfo> list;
        StringBuilder sb2;
        String str5;
        try {
            com.component.c.d dVar = new com.component.c.d(context);
            String strB = o.b(str4);
            String appPackageName = jVar.getAppPackageName();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str4));
            intent.addFlags(268435456);
            List<ResolveInfo> listA = dVar.a(intent, 65536);
            HashMap<String, String> map2 = new HashMap<>();
            StringBuilder sb3 = new StringBuilder();
            if (listA.isEmpty()) {
                sb = sb3;
                map2.put(FeedReqParams.REQ_TYPE_OPEN, "false");
                z2 = false;
            } else {
                map2.put(FeedReqParams.REQ_TYPE_OPEN, "true");
                map2.put("n", String.valueOf(listA.size()));
                int i5 = 0;
                z2 = true;
                while (i5 < listA.size()) {
                    ResolveInfo resolveInfo = listA.get(i5);
                    if (i5 == 0) {
                        list = listA;
                        sb3.append(resolveInfo.activityInfo.packageName);
                        sb2 = sb3;
                    } else {
                        list = listA;
                        sb2 = sb3;
                        sb3.append(",").append(resolveInfo.activityInfo.packageName);
                    }
                    if (appPackageName.equals(resolveInfo.activityInfo.packageName)) {
                        int i6 = -1;
                        try {
                            PackageInfo packageInfoA = a(context, resolveInfo.activityInfo.packageName, 0);
                            if (packageInfoA != null) {
                                i6 = packageInfoA.versionCode;
                                str5 = packageInfoA.versionName;
                            } else {
                                str5 = "";
                            }
                            if (i6 < i4) {
                                z2 = false;
                            }
                            map2.put("installedVersionCode", String.valueOf(i6));
                            map2.put("requiredVersion", String.valueOf(i4));
                            map2.put("realopen", String.valueOf(z2));
                            map2.put("installedVersionName", str5);
                        } catch (Exception e2) {
                            try {
                                map2.put("exception", "true");
                                map2.put("installedVersionCode", String.valueOf(-1));
                                map2.put("requiredVersion", String.valueOf(i4));
                                map2.put("realopen", String.valueOf(z2));
                                map2.put("installedVersionName", "");
                            } catch (Throwable th) {
                                th = th;
                                map2.put("installedVersionCode", String.valueOf(-1));
                                map2.put("requiredVersion", String.valueOf(i4));
                                map2.put("realopen", String.valueOf(z2));
                                map2.put("installedVersionName", "");
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            map2.put("installedVersionCode", String.valueOf(-1));
                            map2.put("requiredVersion", String.valueOf(i4));
                            map2.put("realopen", String.valueOf(z2));
                            map2.put("installedVersionName", "");
                            throw th;
                        }
                    }
                    i5++;
                    listA = list;
                    sb3 = sb2;
                }
                sb = sb3;
            }
            by.a aVarA = by.a.a(context).a(i2).a("fb_act", i3).a("pk", appPackageName).a("targetscheme", strB).b(str2).a(str).c(str3).a(com.baidu.mobads.container.adrequest.g.w, "").a("targetVer", ab.a(context)).a(map).a(map2).a(FeedReqParams.REQ_TYPE_OPEN, z2);
            if (jVar != null) {
                aVarA.a(jVar);
            }
            if (sb.length() > 0) {
                aVarA.a("p", sb.toString());
            }
            aVarA.g();
        } catch (Exception e3) {
            bq.a().a("PackageUtils", e3.getMessage());
        }
    }

    public static boolean a(Context context, JSONObject jSONObject, HashMap<String, String> map) {
        int i2;
        Field declaredField;
        boolean z2 = false;
        try {
            if (a(context, "com.tencent.mm")) {
                String strOptString = jSONObject.optString("app_hostid", "");
                String strOptString2 = jSONObject.optString("path", "");
                String strOptString3 = jSONObject.optString("media_appid", "");
                String strOptString4 = jSONObject.optString("apo_env", "");
                String strG = com.baidu.mobads.container.config.a.a().g();
                map.put("wx_appid", strG);
                if (!TextUtils.isEmpty(strOptString3)) {
                    strG = strOptString3;
                }
                map.put("app_hostid", strOptString);
                map.put("path", strOptString2);
                map.put("apo_env", strOptString4);
                map.put("wx_media_appid", strOptString3);
                map.put("iswx", "true");
                map.put("is_wx_install", "true");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strG)) {
                    try {
                        Class<?> clsA = bo.a("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                        if (clsA != null) {
                            Object objA = bo.a(clsA, new Object[]{clsA}, "createWXAPI", (Class<?>[]) new Class[]{Context.class, String.class}, new Object[]{context, strG});
                            Class<?> clsA2 = bo.a("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                            Object objA2 = bo.a("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req", (Class<?>[]) new Class[0], new Object[0]);
                            if (clsA2 != null && objA2 != null && objA != null) {
                                Field declaredField2 = clsA2.getDeclaredField("userName");
                                if (declaredField2 != null) {
                                    declaredField2.setAccessible(true);
                                    declaredField2.set(objA2, strOptString);
                                }
                                if (!TextUtils.isEmpty(strOptString2) && (declaredField = clsA2.getDeclaredField("path")) != null) {
                                    declaredField.setAccessible(true);
                                    declaredField.set(objA2, strOptString2);
                                }
                                if (TextUtils.isEmpty(strOptString4)) {
                                    i2 = 0;
                                } else {
                                    i2 = Integer.parseInt(strOptString4);
                                }
                                Field declaredField3 = clsA2.getDeclaredField("miniprogramType");
                                if (declaredField3 != null) {
                                    declaredField3.setAccessible(true);
                                    declaredField3.set(objA2, Integer.valueOf(i2));
                                }
                                boolean z3 = false;
                                for (Method method : objA.getClass().getMethods()) {
                                    try {
                                        if (method.getName().equals("sendReq")) {
                                            method.invoke(objA, objA2);
                                            z3 = true;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        z2 = z3;
                                        th.printStackTrace();
                                        return z2;
                                    }
                                }
                                z2 = z3;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } else {
                map.put("is_wx_install", "false");
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.baidu.mobads.container.adrequest.t r31, java.lang.String r32, com.baidu.mobads.container.adrequest.j r33, int r34, org.json.JSONObject r35, com.baidu.mobads.container.components.k.a r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1012
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.util.bk.a(com.baidu.mobads.container.adrequest.t, java.lang.String, com.baidu.mobads.container.adrequest.j, int, org.json.JSONObject, com.baidu.mobads.container.components.k.a):void");
    }

    public static void a(com.baidu.mobads.container.adrequest.t tVar, String str, com.baidu.mobads.container.adrequest.j jVar) {
        if (tVar == null) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put(FeedReqParams.REQ_TYPE_OPEN, "0");
            map.put("dia_select", "2");
            map.put("leavetime", "0");
            map.put("opentimec", "0");
            map.put("pk", str);
            map.put("appsid", tVar.z());
            map.put("prod", tVar.k());
            map.put("apid", tVar.l());
            map.put(com.baidu.mobads.container.components.command.j.C, a(jVar));
            map.put(com.baidu.mobads.container.components.command.j.f, jVar.getBuyer());
            map.put("qk", jVar.getQueryKey());
            map.put("adid", jVar.getAdId());
            cd.a(tVar.t(), 2, (HashMap<String, String>) map, false);
        } catch (Throwable th) {
            bq.a().a(th.getMessage());
        }
    }

    private static void a(com.baidu.mobads.container.adrequest.t tVar, StringBuilder sb, com.baidu.mobads.container.adrequest.j jVar, HashMap<String, String> map, int i2, boolean z2) {
        if (tVar == null) {
            return;
        }
        try {
            by.a aVarA = by.a.a(tVar.t());
            aVarA.a(i2).a(map).a("subType", 0L).a(FeedReqParams.REQ_TYPE_OPEN, z2).a("dp_fl_tp", g).a(com.baidu.mobads.container.components.command.j.C, a(jVar));
            aVarA.a(jVar);
            if (sb != null && sb.length() > 0) {
                aVarA.a("p", sb.toString());
            }
            aVarA.c(tVar.k());
            aVarA.a(tVar.z());
            aVarA.b(tVar.l());
            aVarA.f();
        } catch (Throwable th) {
            bq.a().a(th.getMessage());
        }
    }

    public static boolean a(Context context, String str) {
        try {
            new com.component.c.d(context).b(str, 0);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            return !new com.component.c.d(context).a(intent, 65536).isEmpty();
        } catch (Exception e2) {
            bq.a().a(e2.getMessage());
            return false;
        }
    }

    public static void a(Context context, com.baidu.mobads.container.adrequest.t tVar, String str, String str2, int i2) {
        try {
            by.a.a(context).a(389).c(tVar.k()).a(tVar.z()).b(tVar.l()).a(com.baidu.mobads.container.adrequest.g.w, "").a("schema", o.b(str2)).a("pk", str).a(com.sigmob.sdk.base.n.l, i2).g();
        } catch (Exception e2) {
            bq.a().a("PackageUtils", e2.getMessage());
        }
    }

    public static void a(Context context, com.baidu.mobads.container.adrequest.t tVar, int i2, int i3) {
        a(context, tVar, i2, i3, (HashMap<String, String>) null);
    }

    public static void a(Context context, com.baidu.mobads.container.adrequest.t tVar, int i2, int i3, HashMap<String, String> map) {
        try {
            by.a aVarA = by.a.a(context).a(i2).c(tVar.k()).a(tVar.z()).b(tVar.l()).a(tVar.q()).a(com.baidu.mobads.container.adrequest.g.w, "").a("logtime", System.currentTimeMillis() + "").a("subtype", i3).a(map);
            aVarA.a("adSrc", tVar.w() != null ? r4.optInt("adSrc", 0) : 0);
            com.baidu.mobads.container.components.j.c.a().a(tVar.z(), tVar.k(), tVar.l(), tVar.q(), c.d.e, "" + i2, "" + i3, 0, aVarA.e());
        } catch (Exception e2) {
            bq.a().a("PackageUtils", e2.getMessage());
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.t tVar, int i2, String str) {
        String strK = tVar.k();
        if ("rvideo".equals(strK)) {
            a(tVar, i2, 601, null, null, -1, str);
        } else if ("fvideo".equals(strK)) {
            a(tVar, i2, 603, null, null, -1, str);
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.t tVar, int i2, boolean z2, int i3, String str) {
        String strK = tVar.k();
        if ("rvideo".equals(strK)) {
            a(tVar, i2, 601, null, null, i3, str);
        } else if ("fvideo".equals(strK)) {
            a(tVar, i2, 603, null, null, i3, str);
        }
    }

    public static void a(com.baidu.mobads.container.adrequest.t tVar, int i2, int i3, HashMap<String, String> map, HashMap<String, String> map2, int i4, String str) {
        String strEncode;
        try {
            Context contextT = tVar.t();
            try {
                strEncode = URLEncoder.encode(tVar.q().getClickThroughUrl(), "UTF-8");
            } catch (Exception e2) {
                strEncode = "";
            }
            by.a aVarA = by.a.a(contextT).a(i3).c(tVar.k()).a(tVar.z()).b(tVar.l()).a(tVar.q()).a("subtype", i2).a("show_ad_type", str).a(com.baidu.mobads.container.adrequest.g.w, "").a(com.baidu.mobads.container.adrequest.n.D, b(tVar.q())).a("logtime", System.currentTimeMillis() + "").a(map2).a(map).a("page_index", i4).a("curl", strEncode);
            aVarA.a(com.baidu.mobads.container.components.command.j.C, a(tVar.q()));
            aVarA.a("adSrc", tVar.w() != null ? r4.optInt("adSrc", 0) : 0);
            if (i2 != 5) {
                if (i2 != 6) {
                    if (i2 == 11) {
                        aVarA.a("reason", com.component.feed.a.i);
                    }
                } else {
                    aVarA.a("reason", com.component.feed.a.g);
                }
            } else {
                aVarA.a("reason", com.component.feed.a.f);
            }
            com.baidu.mobads.container.components.j.c.a().a(tVar.z(), tVar.k(), tVar.l(), tVar.q(), c.d.e, "" + i3, "" + i2, 0, aVarA.e());
        } catch (Throwable th) {
            bq.a().a("PackageUtils", th.getMessage());
        }
    }

    public static String a(com.baidu.mobads.container.adrequest.j jVar) {
        JSONObject originJsonObject;
        JSONObject jSONObjectOptJSONObject;
        if (jVar == null || (originJsonObject = jVar.getOriginJsonObject()) == null || (jSONObjectOptJSONObject = originJsonObject.optJSONObject("media_ad_info")) == null) {
            return "";
        }
        if (jSONObjectOptJSONObject.has("hw_agd_manual") || jSONObjectOptJSONObject.has("hw_agd_auto")) {
            return "hw_agd";
        }
        if (!jSONObjectOptJSONObject.has("link_manual") && !jSONObjectOptJSONObject.has("link_auto")) {
            return "";
        }
        return "xiaomi";
    }

    public static long c(Context context) {
        return context.getSharedPreferences(a, 0).getLong("install_sent_time", 0L);
    }

    public static synchronized void a(Context context, long j2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(a, 0).edit();
            editorEdit.putLong("install_sent_time", j2);
            editorEdit.apply();
        } catch (Exception e2) {
        }
    }

    public static void c(Context context, String str) {
        boolean z2;
        try {
            JSONArray jSONArray = new JSONArray(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            if (bt.a()) {
                z2 = false;
            } else {
                jSONArray = a(context);
                z2 = true;
            }
            by.a aVarA = by.a.a(context).a(3).a(str).a("t", jSONArray.length()).a("spbaiduid", ab.i(context)).a("safenv", z2);
            if (jSONArray.length() > 0) {
                aVarA.a("p", a(jSONArray));
            }
            aVarA.f();
        } catch (Exception e2) {
            bq.a().a("PackageUtils", e2.getMessage());
        }
    }

    private static String a(JSONArray jSONArray) {
        String str = "";
        try {
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(length);
                String hexString = Long.toHexString(a(jSONObject.getString("p")));
                if (jSONObject.optString("v") != null) {
                    hexString = hexString + '_' + u.a(jSONObject.optString("v"));
                    if (jSONObject.getString("c") != null) {
                        hexString = hexString + '_' + jSONObject.getString("c");
                    }
                }
                String str2 = hexString + StringUtil.COMMA;
                if (str.length() + str2.length() > 3000) {
                    break;
                }
                str = str + str2;
            }
            if (o.m(str)) {
                return str.substring(0, str.length() - 1);
            }
            return str;
        } catch (Exception e2) {
            bq.a().c(e2);
            return "";
        }
    }

    public static long a(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, bytes.length);
    }

    public static long a(byte[] bArr, int i2) {
        return a(bArr, i2, 428279572);
    }

    public static long a(byte[] bArr, int i2, int i3) {
        int i4 = i3 ^ i2;
        int i5 = 0;
        int i6 = 0;
        while (i2 >= 8) {
            int i7 = bArr[i5] & 255;
            int i8 = i5 + 1;
            int i9 = i7 + ((bArr[i8] & 255) << 8);
            int i10 = i8 + 1;
            int i11 = i9 + ((bArr[i10] & 255) << 16);
            int i12 = (int) ((i11 + ((bArr[r0] & 255) << 24)) * 1540483477);
            i4 = ((int) (i4 * 1540483477)) ^ ((int) (((i12 >>> 24) ^ i12) * 1540483477));
            int i13 = i10 + 1 + 1;
            int i14 = bArr[i13] & 255;
            int i15 = i13 + 1;
            int i16 = i14 + ((bArr[i15] & 255) << 8);
            int i17 = i15 + 1;
            int i18 = i16 + ((bArr[i17] & 255) << 16);
            int i19 = (int) ((i18 + ((bArr[r0] & 255) << 24)) * 1540483477);
            i6 = ((int) (i6 * 1540483477)) ^ ((int) ((i19 ^ (i19 >>> 24)) * 1540483477));
            i2 = (i2 - 4) - 4;
            i5 = i17 + 1 + 1;
        }
        if (i2 >= 4) {
            int i20 = bArr[i5] & 255;
            int i21 = i5 + 1;
            int i22 = i20 + ((bArr[i21] & 255) << 8);
            int i23 = i21 + 1;
            int i24 = i22 + ((bArr[i23] & 255) << 16);
            int i25 = (int) ((i24 + ((bArr[r0] & 255) << 24)) * 1540483477);
            i4 = ((int) (i4 * 1540483477)) ^ ((int) (((i25 >>> 24) ^ i25) * 1540483477));
            i2 -= 4;
            i5 = i23 + 1 + 1;
        }
        if (i2 == 3) {
            i6 = (int) ((((i6 ^ ((bArr[i5 + 2] & 255) << 16)) ^ ((bArr[i5 + 1] & 255) << 8)) ^ (bArr[i5] & 255)) * 1540483477);
        }
        if (i2 == 2) {
            i6 = (int) (((i6 ^ ((bArr[i5 + 1] & 255) << 8)) ^ (bArr[i5] & 255)) * 1540483477);
        }
        if (i2 == 1) {
            i6 = (int) (((bArr[i5] & 255) ^ i6) * 1540483477);
        }
        int i26 = (int) (((i6 >>> 18) ^ i4) * 1540483477);
        int i27 = (int) (((i26 >>> 22) ^ i6) * 1540483477);
        return (((int) ((i27 ^ (r12 >>> 19)) * 1540483477)) & C00oOOo.f362O8oO888) | (((int) ((i26 ^ (i27 >>> 17)) * 1540483477)) << 32);
    }

    public static JSONArray d(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (bl.a(context, com.kuaishou.weapon.p0.g.e)) {
            try {
                List<ActivityManager.RecentTaskInfo> listA = new com.component.c.a(context).a(64, 0);
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    PackageInfo packageInfoA = a(context, listA.get(i2).baseIntent.getComponent().getPackageName(), 0);
                    if ((packageInfoA == null || (!packageInfoA.packageName.startsWith("com.android") && !packageInfoA.packageName.startsWith("com.sec"))) && packageInfoA != null) {
                        jSONArray.put(new t.a(packageInfoA).b());
                    }
                }
            } catch (Exception e2) {
            }
        }
        return jSONArray;
    }

    public static JSONArray e(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (bl.a(context, com.kuaishou.weapon.p0.g.e)) {
            ArrayList arrayList = new ArrayList();
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("__sdk_ral", 0).edit();
            editorEdit.clear().apply();
            try {
                List<ActivityManager.RecentTaskInfo> listA = new com.component.c.a(context).a(64, 0);
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    PackageInfo packageInfoA = a(context, listA.get(i2).baseIntent.getComponent().getPackageName(), 0);
                    if (packageInfoA == null || (!packageInfoA.packageName.startsWith("com.android") && !packageInfoA.packageName.startsWith("com.sec") && !arrayList.contains(packageInfoA.packageName))) {
                        arrayList.add(packageInfoA.packageName);
                        jSONArray.put(new t.a(packageInfoA).b());
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                if (arrayList.size() > 0) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (arrayList.get(i3) != null && arrayList.get(i3) != "") {
                            stringBuffer.append((String) arrayList.get(i3));
                            stringBuffer.append("#");
                        }
                    }
                }
                String string = stringBuffer.toString();
                if (string != null) {
                    editorEdit.putString("ral", u.a(string));
                    editorEdit.apply();
                }
            } catch (Exception e2) {
            }
        }
        return jSONArray;
    }

    public static JSONArray f(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (bl.a(context, com.kuaishou.weapon.p0.g.e)) {
            ArrayList arrayList = new ArrayList();
            SharedPreferences sharedPreferences = context.getSharedPreferences("__sdk_ral", 0);
            String string = sharedPreferences.getString("ral", null);
            if (string != null) {
                String strB = u.b(string);
                if (!TextUtils.isEmpty(strB)) {
                    arrayList.addAll(Arrays.asList(strB.split("#")));
                }
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            try {
                List<ActivityManager.RecentTaskInfo> listA = new com.component.c.a(context).a(64, 0);
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    PackageInfo packageInfoA = a(context, listA.get(i2).baseIntent.getComponent().getPackageName(), 0);
                    if (packageInfoA == null || (!packageInfoA.packageName.startsWith("com.android") && !packageInfoA.packageName.startsWith("com.sec") && !arrayList.contains(packageInfoA.packageName))) {
                        arrayList.add(packageInfoA.packageName);
                        jSONArray.put(new t.a(packageInfoA).b());
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                if (arrayList.size() > 0) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (arrayList.get(i3) != null && arrayList.get(i3) != "") {
                            stringBuffer.append((String) arrayList.get(i3));
                            stringBuffer.append("#");
                        }
                    }
                }
                String string2 = stringBuffer.toString();
                if (string2 != null) {
                    editorEdit.putString("ral", u.a(string2));
                    editorEdit.apply();
                }
            } catch (Exception e2) {
            }
        }
        return jSONArray;
    }

    public static String b(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar == null) {
            return "";
        }
        try {
            JSONObject jSONObjectOptJSONObject = jVar.getOriginJsonObject().optJSONObject("st_op");
            return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(com.baidu.mobads.container.adrequest.n.D, "") : "";
        } catch (Throwable th) {
            return "";
        }
    }
}
