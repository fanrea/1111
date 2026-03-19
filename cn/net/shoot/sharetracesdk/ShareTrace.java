package cn.net.shoot.sharetracesdk;

import android.app.Application;
import android.content.ClipboardManager;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import cn.net.shoot.sharetracesdk.c.d;
import cn.net.shoot.sharetracesdk.f.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ShareTrace {
    public static volatile boolean a = false;

    public class a implements Runnable {
        public final /* synthetic */ Application a;
        public final /* synthetic */ String b;

        public a(Application application, String str) {
            this.a = application;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Application application = this.a;
            String str = this.b;
            if (ShareTrace.a) {
                return;
            }
            ShareTrace.a = true;
            cn.net.shoot.sharetracesdk.f.a.c().a = application;
            cn.net.shoot.sharetracesdk.f.a.c().c = str;
            cn.net.shoot.sharetracesdk.c.a aVarA = cn.net.shoot.sharetracesdk.c.a.a();
            aVarA.d = application;
            application.registerActivityLifecycleCallbacks(aVarA.a);
            cn.net.shoot.sharetracesdk.b.a aVarD = cn.net.shoot.sharetracesdk.b.a.d();
            aVarD.getClass();
            if (cn.net.shoot.sharetracesdk.f.a.c().h) {
                try {
                    aVarD.a = (ClipboardManager) application.getApplicationContext().getSystemService("clipboard");
                } catch (Throwable unused) {
                    Log.e("ShareTrace", "ClipboardManager init error");
                }
            } else {
                Log.e("ShareTrace", "disable read clipboard.");
            }
            String.format("sharetrace init ok.", new Object[0]);
        }
    }

    public static void disableClipboard() {
        cn.net.shoot.sharetracesdk.f.a.c().h = false;
    }

    public static void getInstallTrace(ShareTraceInstallListener shareTraceInstallListener) {
        getInstallTrace(shareTraceInstallListener, 10000, 1500);
    }

    public static void getInstallTrace(ShareTraceInstallListener shareTraceInstallListener, int i) {
        getInstallTrace(shareTraceInstallListener, i, 1500);
    }

    public static void getInstallTrace(ShareTraceInstallListener shareTraceInstallListener, int i, int i2) {
        if (cn.net.shoot.sharetracesdk.f.a.c().a == null) {
            Log.e("ShareTrace", "context is null, please invoke ShareTrace.init(context) first.");
            return;
        }
        if (shareTraceInstallListener == null) {
            Log.e("ShareTrace", "ShareTraceInstallListener can't be null.");
            return;
        }
        if (i > 0) {
            cn.net.shoot.sharetracesdk.f.a.c().e = i;
        }
        if (i2 > 0) {
            cn.net.shoot.sharetracesdk.f.a.c().f = i2;
        }
        d.b().a(shareTraceInstallListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean getWakeUpTrace(android.content.Intent r9, cn.net.shoot.sharetracesdk.ShareTraceWakeUpListener r10) {
        /*
            java.lang.String r0 = "ch"
            java.lang.String r1 = "pr"
            java.lang.String r2 = "UTF-8"
            cn.net.shoot.sharetracesdk.f.a r3 = cn.net.shoot.sharetracesdk.f.a.c()
            android.app.Application r3 = r3.a
            java.lang.String r4 = "ShareTrace"
            r5 = 0
            if (r3 != 0) goto L18
            java.lang.String r9 = "context is null, please invoke ShareTrace.init(context) first."
            android.util.Log.e(r4, r9)
            return r5
        L18:
            if (r10 != 0) goto L1b
            return r5
        L1b:
            r3 = 1
            if (r9 != 0) goto L1f
            goto L5b
        L1f:
            android.net.Uri r6 = r9.getData()
            if (r6 != 0) goto L26
            goto L5b
        L26:
            java.lang.String r7 = r6.getPath()
            if (r7 == 0) goto L5b
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L5b
            java.lang.String r8 = "/c"
            boolean r7 = r7.contains(r8)
            if (r7 != 0) goto L3b
            goto L5b
        L3b:
            cn.net.shoot.sharetracesdk.f.a r7 = cn.net.shoot.sharetracesdk.f.a.c()
            java.lang.String r7 = r7.c
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L48
            goto L5b
        L48:
            java.lang.String r6 = r6.toString()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L5b
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L59
            goto L5b
        L59:
            r6 = r3
            goto L5c
        L5b:
            r6 = r5
        L5c:
            if (r6 != 0) goto L5f
            return r5
        L5f:
            android.net.Uri r9 = r9.getData()
            r6 = 0
            if (r9 != 0) goto L67
            goto Lb9
        L67:
            java.lang.String r7 = "d"
            java.lang.String r9 = r9.getQueryParameter(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r9)
            if (r7 == 0) goto L74
            goto Lb9
        L74:
            byte[] r9 = android.util.Base64.decode(r9, r5)     // Catch: java.lang.Throwable -> Lb1
            if (r9 == 0) goto Lb9
            int r5 = r9.length     // Catch: java.lang.Throwable -> Lb1
            if (r5 > 0) goto L7e
            goto Lb9
        L7e:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> Lb1
            r5.<init>(r9, r2)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r9 = java.net.URLDecoder.decode(r5, r2)     // Catch: java.lang.Throwable -> Lb1
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lb1
            r2.<init>(r9)     // Catch: java.lang.Throwable -> Lb1
            boolean r9 = r2.has(r1)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r5 = ""
            if (r9 == 0) goto L99
            java.lang.String r9 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lb1
            goto L9a
        L99:
            r9 = r5
        L9a:
            boolean r1 = r2.has(r0)     // Catch: java.lang.Throwable -> Lb1
            if (r1 == 0) goto La4
            java.lang.String r5 = r2.getString(r0)     // Catch: java.lang.Throwable -> Lb1
        La4:
            cn.net.shoot.sharetracesdk.AppData r0 = new cn.net.shoot.sharetracesdk.AppData     // Catch: java.lang.Throwable -> Lb1
            r0.<init>()     // Catch: java.lang.Throwable -> Lb1
            r0.setParamsData(r9)     // Catch: java.lang.Throwable -> Lb1
            r0.setChannel(r5)     // Catch: java.lang.Throwable -> Lb1
            r6 = r0
            goto Lb9
        Lb1:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            android.util.Log.e(r4, r9)
        Lb9:
            r10.onWakeUp(r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.net.shoot.sharetracesdk.ShareTrace.getWakeUpTrace(android.content.Intent, cn.net.shoot.sharetracesdk.ShareTraceWakeUpListener):boolean");
    }

    public static void init(Application application) {
        Bundle bundle;
        if (application == null) {
            Log.e("ShareTrace", "context must be not null, sharetrace init error.");
            return;
        }
        try {
            bundle = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String strValueOf = (bundle == null || !bundle.containsKey("com.sharetrace.APP_KEY")) ? "" : String.valueOf(bundle.get("com.sharetrace.APP_KEY"));
        if (TextUtils.isEmpty(strValueOf)) {
            Log.e("ShareTrace", application.getString(R.string.app_key_manifest_not_found));
        } else {
            init(application, strValueOf);
        }
    }

    public static boolean isFirstOpen() {
        if (cn.net.shoot.sharetracesdk.f.a.c().a != null) {
            return cn.net.shoot.sharetracesdk.f.a.c().b();
        }
        Log.e("ShareTrace", "Please invoke 'ShareTrace.init()' first! ");
        throw new RuntimeException("Please invoke 'ShareTrace.init()' first!");
    }

    public static Map<String, String> parseUrlParams(String str) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        if (str.contains("?")) {
            str = str.substring(str.lastIndexOf("?") + 1);
        }
        String[] strArrSplit = str.split(com.alipay.sdk.m.s.a.n);
        if (strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    String[] strArrSplit2 = str2.split("=");
                    if (strArrSplit2.length == 2) {
                        map.put(strArrSplit2[0], strArrSplit2[1]);
                    } else if (strArrSplit2.length == 1) {
                        map.put(strArrSplit2[0], "");
                    }
                }
            }
        }
        return map;
    }

    public static void setServerDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("domain must be not NULL.");
        }
        cn.net.shoot.sharetracesdk.f.a.c().g = str;
    }

    @Deprecated
    public static void td() {
        cn.net.shoot.sharetracesdk.f.a.c().d = true;
    }

    public static void init(Application application, String str) {
        Bundle bundle;
        if (application == null) {
            Log.e("ShareTrace", "context must be not null, sharetrace init error.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("ShareTrace", application.getString(R.string.app_key_not_found));
            return;
        }
        if (TextUtils.isEmpty(cn.net.shoot.sharetracesdk.f.a.c().g)) {
            try {
                bundle = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            String strValueOf = (bundle == null || !bundle.containsKey("com.sharetrace.SERVER_DOMAIN")) ? "" : String.valueOf(bundle.get("com.sharetrace.SERVER_DOMAIN"));
            if (TextUtils.isEmpty(strValueOf) && !cn.net.shoot.sharetracesdk.f.a.c().d) {
                strValueOf = String.format("https://%s.sharetrace.com", "clb-" + str);
            }
            cn.net.shoot.sharetracesdk.f.a.c().g = strValueOf;
        }
        a aVar = new a(application, str);
        if (b.a().getLooper() == Looper.myLooper()) {
            aVar.run();
        } else {
            b.a().post(aVar);
        }
    }
}
