package com.baidu.mobads.container.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.container.util.by;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bj {
    private static final String a = "wtai://wp/mc;";
    private static String[] b = {"com.android.chrome", "com.UCMobile", "com.uc.browser", "com.uc.browser.hd", "com.tencent.mtt", "com.tencent.padbrowser", "com.baidu.browser.apps", "com.android.browser", "com.oupeng.mini.android", "com.oupeng.mobile", "com.oupeng.browser", "com.opera.mini.android", "com.opera.browser", "com.opera.browser.beta", "com.mediawoz.xbrowser", "com.mx.browser", "com.mx.browser.tablet", "org.mozilla.firefox", "com.tiantianmini.android.browser", "com.ijinshan.browser_fast", "sogou.mobile.explorer", "com.dolphin.browser.cn", "com.qihoo.browser", "com.baidu.searchbox"};

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b8 A[Catch: Exception -> 0x00d4, TryCatch #1 {Exception -> 0x00d4, blocks: (B:6:0x0029, B:8:0x003d, B:10:0x0049, B:12:0x0054, B:28:0x00b8, B:29:0x00bd, B:31:0x00c1, B:32:0x00c4, B:34:0x00d0, B:14:0x005f, B:16:0x0069, B:18:0x0077, B:20:0x0080, B:22:0x009b, B:26:0x00a9, B:25:0x00a5, B:19:0x007c), top: B:44:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1 A[Catch: Exception -> 0x00d4, TryCatch #1 {Exception -> 0x00d4, blocks: (B:6:0x0029, B:8:0x003d, B:10:0x0049, B:12:0x0054, B:28:0x00b8, B:29:0x00bd, B:31:0x00c1, B:32:0x00c4, B:34:0x00d0, B:14:0x005f, B:16:0x0069, B:18:0x0077, B:20:0x0080, B:22:0x009b, B:26:0x00a9, B:25:0x00a5, B:19:0x007c), top: B:44:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0 A[Catch: Exception -> 0x00d4, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d4, blocks: (B:6:0x0029, B:8:0x003d, B:10:0x0049, B:12:0x0054, B:28:0x00b8, B:29:0x00bd, B:31:0x00c1, B:32:0x00c4, B:34:0x00d0, B:14:0x005f, B:16:0x0069, B:18:0x0077, B:20:0x0080, B:22:0x009b, B:26:0x00a9, B:25:0x00a5, B:19:0x007c), top: B:44:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "body="
            java.lang.String r1 = "android.intent.action.VIEW"
            java.lang.String r2 = "wtai://wp/mc;"
            boolean r3 = r8.startsWith(r2)
            if (r3 == 0) goto L27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "tel:"
            java.lang.StringBuilder r3 = r3.append(r4)
            int r2 = r2.length()
            java.lang.String r8 = r8.substring(r2)
            java.lang.StringBuilder r8 = r3.append(r8)
            java.lang.String r8 = r8.toString()
        L27:
            r2 = 268435456(0x10000000, float:2.524355E-29)
            android.net.Uri r3 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> Ld4
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Exception -> Ld4
            r4.<init>(r1, r3)     // Catch: java.lang.Exception -> Ld4
            java.lang.Boolean r5 = com.baidu.mobads.container.util.o.c(r8)     // Catch: java.lang.Exception -> Ld4
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Exception -> Ld4
            if (r5 == 0) goto L5f
        L3d:
            java.lang.String r0 = a(r7)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r5 = ""
            boolean r5 = r0.equals(r5)     // Catch: java.lang.Exception -> Ld4
            if (r5 != 0) goto L5e
            com.component.c.d r4 = new com.component.c.d     // Catch: java.lang.Exception -> Ld4
            r4.<init>(r7)     // Catch: java.lang.Exception -> Ld4
            android.content.Intent r4 = r4.a(r0)     // Catch: java.lang.Exception -> Ld4
            if (r4 == 0) goto L5e
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> Ld4
            r4.setData(r0)     // Catch: java.lang.Exception -> Ld4
            r4.setAction(r1)     // Catch: java.lang.Exception -> Ld4
        L5e:
            goto Lb6
        L5f:
            java.lang.Boolean r5 = com.baidu.mobads.container.util.o.f(r8)     // Catch: java.lang.Exception -> Ld4
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Exception -> Ld4
            if (r5 == 0) goto L5e
            java.lang.String r5 = "vnd.android-dir/mms-sms"
            r4.setType(r5)     // Catch: java.lang.Exception -> Ld4
            r5 = 63
            int r6 = r8.indexOf(r5)     // Catch: java.lang.Exception -> Ld4
            if (r6 <= 0) goto L7c
            int r5 = r8.indexOf(r5)     // Catch: java.lang.Exception -> Ld4
            goto L80
        L7c:
            int r5 = r8.length()     // Catch: java.lang.Exception -> Ld4
        L80:
            r6 = 4
            java.lang.String r5 = r8.substring(r6, r5)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r6 = "address"
            r4.putExtra(r6, r5)     // Catch: java.lang.Exception -> Ld4
            int r5 = r8.indexOf(r0)     // Catch: java.lang.Exception -> Ld4
            int r6 = r0.length()     // Catch: java.lang.Exception -> Ld4
            int r5 = r5 + r6
            int r0 = r0.length()     // Catch: java.lang.Exception -> Ld4
            if (r5 <= r0) goto Lb6
            r0 = 38
            int r0 = r8.indexOf(r0, r5)     // Catch: java.lang.Exception -> Ld4
            if (r0 <= 0) goto La5
            goto La9
        La5:
            int r0 = r8.length()     // Catch: java.lang.Exception -> Ld4
        La9:
            java.lang.String r0 = r8.substring(r5, r0)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r5 = "sms_body"
            java.lang.String r0 = android.net.Uri.decode(r0)     // Catch: java.lang.Exception -> Ld4
            r4.putExtra(r5, r0)     // Catch: java.lang.Exception -> Ld4
        Lb6:
            if (r4 != 0) goto Lbd
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Exception -> Ld4
            r4.<init>(r1, r3)     // Catch: java.lang.Exception -> Ld4
        Lbd:
            boolean r0 = r7 instanceof android.app.Activity     // Catch: java.lang.Exception -> Ld4
            if (r0 != 0) goto Lc4
            r4.addFlags(r2)     // Catch: java.lang.Exception -> Ld4
        Lc4:
            android.content.pm.PackageManager r0 = r7.getPackageManager()     // Catch: java.lang.Exception -> Ld4
            r3 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r0 = r0.resolveActivity(r4, r3)     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto Ld3
            r7.startActivity(r4)     // Catch: java.lang.Exception -> Ld4
        Ld3:
            goto Lfb
        Ld4:
            r0 = move-exception
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> Le5
            android.net.Uri r3 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> Le5
            r0.<init>(r1, r3)     // Catch: java.lang.Exception -> Le5
            r0.addFlags(r2)     // Catch: java.lang.Exception -> Le5
            r7.startActivity(r0)     // Catch: java.lang.Exception -> Le5
            goto Lfb
        Le5:
            r7 = move-exception
            com.baidu.mobads.container.util.bq r0 = com.baidu.mobads.container.util.bq.a()
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "XAdCommonUtils.browserOutside 2"
            r3 = 0
            r1[r3] = r2
            r2 = 1
            r1[r2] = r8
            r8 = 2
            r1[r8] = r7
            r0.a(r1)
        Lfb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.util.bj.a(android.content.Context, java.lang.String):void");
    }

    private static String a(Context context) {
        int i;
        try {
            com.component.c.d dVar = new com.component.c.d(context);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            dVar.a(arrayList, arrayList2, null);
            Iterator<ComponentName> it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    try {
                        i = -1;
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : new com.component.c.a(context).a()) {
                            try {
                                if (dVar.a(runningAppProcessInfo.processName) != null && dVar.b(runningAppProcessInfo.processName, 128) != null) {
                                    for (int i2 = 0; i2 < b.length; i2++) {
                                        if (runningAppProcessInfo.processName.equals(b[i2]) && (i == -1 || i2 < i)) {
                                            i = i2;
                                        }
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        i = -1;
                    }
                    if (i != -1) {
                        return b[i];
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("http://m.baidu.com"));
                    List<ResolveInfo> listA = dVar.a(intent, 64);
                    if (listA != null) {
                        for (int i3 = 0; i3 < b.length; i3++) {
                            for (int i4 = 0; i4 < listA.size(); i4++) {
                                String str = listA.get(i4).activityInfo.packageName;
                                String str2 = b[i3];
                                if (str2.equals(str)) {
                                    return str2;
                                }
                            }
                        }
                    }
                    if (listA != null && listA.size() > 0) {
                        return listA.get(0).activityInfo.packageName;
                    }
                    return "";
                }
                ComponentName next = it.next();
                for (int i5 = 0; i5 < b.length; i5++) {
                    String str3 = b[i5];
                    if (str3.equals(next.getPackageName())) {
                        return str3;
                    }
                }
            }
        } catch (Exception e3) {
            return "";
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            boolean zEqualsIgnoreCase = "HUAWEI".equalsIgnoreCase(x.a(context).e());
            Intent intent = new Intent("com.huawei.appmarket.intent.action.AppDetail");
            intent.setPackage("com.huawei.appmarket");
            intent.putExtra("APP_PACKAGENAME", str2);
            List<ResolveInfo> listA = new com.component.c.d(context).a(intent, 65536);
            if (zEqualsIgnoreCase && (context instanceof Activity) && !TextUtils.isEmpty(str2) && listA.size() > 0) {
                context.startActivity(intent);
            } else {
                a(context, str);
            }
        } catch (Throwable th) {
            a(context, str);
            com.baidu.mobads.container.l.g.f(th.getMessage());
        }
    }

    public static void b(Context context, String str) {
        try {
            Intent intentA = new com.component.c.d(context).a(str);
            if (intentA != null) {
                intentA.addFlags(268435456);
                context.startActivity(intentA);
            }
        } catch (Exception e) {
        }
    }

    public static void a(Context context, com.baidu.mobads.container.components.command.j jVar) {
        boolean zA;
        String str;
        int i;
        String str2;
        if (context != null) {
            try {
                boolean z = !TextUtils.isEmpty(jVar.aw);
                if (com.baidu.mobads.container.components.c.a.a(context, jVar.av)) {
                    String str3 = z ? "coop_link_delayopen" : "appstore_link_delayopen";
                    str2 = jVar.au;
                    zA = com.baidu.mobads.container.components.c.a.a(context, str2);
                    str = str3;
                    i = 552;
                } else {
                    String str4 = "apo_page_delayopen";
                    if (jVar.as && !TextUtils.isEmpty(jVar.at)) {
                        String str5 = jVar.at;
                        zA = com.baidu.mobads.container.components.c.a.a(context, str5);
                        str = "apo_page_delayopen";
                        i = 381;
                        str2 = str5;
                    } else {
                        String str6 = jVar.au;
                        zA = com.baidu.mobads.container.components.c.a.a(context, str6);
                        if (!zA) {
                            str4 = "pk_delayopen";
                        }
                        str = str4;
                        i = 711;
                        str2 = str6;
                    }
                }
                a(context, i, str, str2, zA, jVar);
                if (zA) {
                    a(context, str2);
                    com.baidu.mobads.container.components.h.a.a.a().c(jVar.i(), jVar.h(), 402, true);
                    return;
                }
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(jVar.Z);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    com.baidu.mobads.container.components.h.a.a.a().c(jVar.i(), jVar.h(), 401, true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Context context, int i, String str, String str2, boolean z, com.baidu.mobads.container.components.command.j jVar) {
        by.a aVarA = by.a.a(context).a(i).a(jVar.l()).a("msg", str).a("adid", jVar.h()).a("qk", jVar.i()).a("pk", jVar.d()).a(com.baidu.mobads.container.components.command.j.f, jVar.j()).a("from", "receiver").a("dl_type", jVar.ay).a(com.baidu.mobads.container.components.command.j.F, jVar.az).a("clicktime", String.valueOf(jVar.c())).a("i_de_t", String.valueOf(jVar.aA)).a("i_dt_t", String.valueOf(jVar.aB)).a("appsize", String.valueOf(jVar.e()));
        if (!TextUtils.isEmpty(jVar.k())) {
            aVarA.c(jVar.k());
        }
        if (!TextUtils.isEmpty(jVar.ah)) {
            aVarA.b(jVar.ah);
        }
        if (com.baidu.mobads.container.components.c.a.a(context, jVar.av)) {
            aVarA.a("canopenapopage", z).a(com.baidu.mobads.container.components.command.j.A, str2).a(com.baidu.mobads.container.components.command.j.C, jVar.aw).a("isAuto", jVar.ax);
        } else {
            aVarA.a(FeedReqParams.REQ_TYPE_OPEN, z).a("schema", str2);
        }
        if (jVar.am != null) {
            aVarA.a(jVar.am);
        }
        aVarA.f();
    }

    public static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
