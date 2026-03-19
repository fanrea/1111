package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwai.middleware.azeroth.utils.NetworkUtils;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.apkmanager.o;
import com.qq.e.comm.plugin.callback.biz.ApkCallback;
import com.qq.e.comm.plugin.vg;
import com.qq.e.comm.plugin.z50;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointType;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mf extends e30 {
    private static final String i = m10.a("YXV0b0luc3RhbGw=");
    private bm d;
    private h4 e;
    private f5 f;
    private AtomicBoolean a = new AtomicBoolean(false);
    private ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();
    private Map<Integer, String> c = new HashMap();
    private boolean g = true;
    private m h = new f();

    /* compiled from: A */
    static /* synthetic */ class g {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[zr.values().length];
            a = iArr;
            try {
                iArr[zr.NET_4G.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[zr.NET_3G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[zr.NET_2G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[zr.WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 4) {
            return 3;
        }
        if (i2 == 8) {
            return 4;
        }
        if (i2 == 16) {
            return 5;
        }
        if (i2 == 32) {
            return 6;
        }
        if (i2 != 64) {
            return i2 != 128 ? 0 : 10;
        }
        return 9;
    }

    public mf(h4 h4Var) {
        this.e = h4Var;
        this.f = f5.a(h4Var);
    }

    /* compiled from: A */
    class a implements DownloadConfirmCallBack {
        final /* synthetic */ ApkDownloadTask a;
        final /* synthetic */ String b;
        final /* synthetic */ bm c;
        final /* synthetic */ String d;

        a(ApkDownloadTask apkDownloadTask, String str, bm bmVar, String str2) {
            this.a = apkDownloadTask;
            this.b = str;
            this.c = bmVar;
            this.d = str2;
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onConfirm() throws JSONException {
            com.qq.e.comm.plugin.apkmanager.l.e().c(this.a);
            j3.a(4001026, 4, 104, mf.this.f);
            t3.a(this.b, 1100911, mf.this.f);
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onCancel() throws JSONException {
            mf.this.a(this.c, this.d, 20);
            j3.a(4001027, 4, 104, mf.this.f);
            t3.a(this.b, 1100912, mf.this.f);
        }
    }

    /* compiled from: A */
    class b implements rs {
        final /* synthetic */ bm a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ ApkDownloadTask d;

        @Override // com.qq.e.comm.plugin.rs
        public void a(boolean z) {
        }

        b(bm bmVar, String str, String str2, ApkDownloadTask apkDownloadTask) {
            this.a = bmVar;
            this.b = str;
            this.c = str2;
            this.d = apkDownloadTask;
        }

        @Override // com.qq.e.comm.plugin.rs
        public void onCancel() throws JSONException {
            mf.this.a(this.a, this.b, 20);
            j3.a(4001027, 4, 104, mf.this.f);
            t3.a(this.c, 1100912, mf.this.f);
        }

        @Override // com.qq.e.comm.plugin.rs
        public boolean a(JSONObject jSONObject) throws JSONException {
            com.qq.e.comm.plugin.apkmanager.l.e().c(this.d);
            j3.a(4001026, 4, 104, mf.this.f);
            t3.a(this.c, 1100911, mf.this.f);
            return true;
        }

        @Override // com.qq.e.comm.plugin.rs
        public void b(boolean z) throws JSONException {
            if (z) {
                return;
            }
            onCancel();
            t3.a(this.c, 1100922, mf.this.f);
        }
    }

    /* compiled from: A */
    public static class i implements z50.a {
        private final f5 a;

        public i(f5 f5Var) {
            this.a = f5Var;
        }

        @Override // com.qq.e.comm.plugin.z50.a
        public void b(int i) {
            b10.a(1100944, this.a, 3, Integer.valueOf(i), null);
        }

        @Override // com.qq.e.comm.plugin.z50.a
        public void a(int i) {
            b10.a(1100945, this.a, 3, Integer.valueOf(i), null);
        }
    }

    /* compiled from: A */
    class c implements DownloadConfirmCallBack {
        final /* synthetic */ Context a;
        final /* synthetic */ bm b;
        final /* synthetic */ JSONObject c;
        final /* synthetic */ String d;

        c(Context context, bm bmVar, JSONObject jSONObject, String str) {
            this.a = context;
            this.b = bmVar;
            this.c = jSONObject;
            this.d = str;
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onConfirm() throws JSONException {
            mf.this.a(this.a, this.b, this.c, this.d);
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onCancel() throws JSONException {
            mf.this.a(this.b, this.d, 20);
        }
    }

    public void c(bm bmVar, JSONObject jSONObject, String str) throws JSONException {
        String strOptString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(strOptString)) {
            a(bmVar, str, 10);
            return;
        }
        ApkDownloadTask apkDownloadTaskC = com.qq.e.comm.plugin.apkmanager.l.e().c(strOptString);
        if (apkDownloadTaskC != null) {
            apkDownloadTaskC.a(this.e);
            j3.a(strOptString).b = 4;
            j3.b(4001005, apkDownloadTaskC, 1, 102);
        }
        if (com.qq.e.comm.plugin.apkmanager.l.e().b(apkDownloadTaskC)) {
            a(bmVar, strOptString, str);
            a(bmVar);
        } else {
            a(bmVar, str, 15);
        }
    }

    /* compiled from: A */
    class d implements rs {
        final /* synthetic */ bm a;
        final /* synthetic */ String b;
        final /* synthetic */ Context c;
        final /* synthetic */ JSONObject d;

        @Override // com.qq.e.comm.plugin.rs
        public void a(boolean z) {
        }

        d(bm bmVar, String str, Context context, JSONObject jSONObject) {
            this.a = bmVar;
            this.b = str;
            this.c = context;
            this.d = jSONObject;
        }

        @Override // com.qq.e.comm.plugin.rs
        public void onCancel() throws JSONException {
            mf.this.a(this.a, this.b, 20);
        }

        @Override // com.qq.e.comm.plugin.rs
        public boolean a(JSONObject jSONObject) throws JSONException {
            mf.this.a(this.c, this.a, this.d, this.b);
            return true;
        }

        @Override // com.qq.e.comm.plugin.rs
        public void b(boolean z) throws JSONException {
            if (z) {
                return;
            }
            onCancel();
        }
    }

    /* compiled from: A */
    private static class h implements c.a {
        private final String a;
        private final String b;
        private final boolean c;
        private final h4 d;
        private final long e = System.currentTimeMillis();
        private final f5 f;

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            return false;
        }

        public h(String str, String str2, boolean z, h4 h4Var, f5 f5Var) {
            this.b = str;
            this.a = str2;
            this.c = z;
            this.d = h4Var;
            this.f = f5Var;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i, String str, boolean z) throws JSONException {
            String strG;
            ApkDownloadTask apkDownloadTask;
            if (i != 0 || z) {
                return;
            }
            zt.a(this.a);
            v20 v20VarA = j3.a(this.b);
            h4 h4Var = this.d;
            strG = "";
            if (h4Var != null) {
                l3 l3VarO = h4Var.o();
                String strA = l3VarO != null ? l3VarO.a() : "";
                strG = this.d.G();
                apkDownloadTask = new ApkDownloadTask(this.d, null, null, null, strA, this.b, 0);
            } else {
                apkDownloadTask = new ApkDownloadTask(this.b);
            }
            apkDownloadTask.a(strG, null, true);
            if (!this.c) {
                mf.b(4001011, false, this.e, this.f);
            } else {
                v20VarA.d = 9;
                t3.c(1100905, apkDownloadTask);
                mf.b(4001043, true, this.e, this.f);
            }
            v20VarA.i = 2;
            ct.a(apkDownloadTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2, boolean z, long j, f5 f5Var) throws JSONException {
        h3 h3Var = new h3(f5Var);
        if (z) {
            h3Var.g(3);
        } else {
            h3Var.d(1);
            h3Var.g(4);
        }
        if (j > 0) {
            h3Var.a(System.currentTimeMillis() - j);
        }
        j3.a(i2, h3Var);
    }

    /* compiled from: A */
    class e implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ rs b;
        final /* synthetic */ boolean c;

        e(Context context, rs rsVar, boolean z) {
            this.a = context;
            this.b = rsVar;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            vp.a(this.a, mf.this.e, this.b, this.c ? 8 : 0);
        }
    }

    /* compiled from: A */
    class f implements m {
        f() {
        }

        @Override // com.qq.e.comm.plugin.m
        public void a(String str, int i, int i2, long j) throws JSONException {
            if (i == 128 || TextUtils.isEmpty(str) || !mf.this.b.containsKey(str)) {
                return;
            }
            String str2 = (String) mf.this.b.get(str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", mf.this.a(i));
                jSONObject2.put("progress", i2);
                jSONObject2.put(Config.EXCEPTION_MEMORY_TOTAL, j);
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e) {
                e.getMessage();
            }
            mf.this.d.a(new vg(new ug(str2), vg.a.OK, jSONObject, 1));
        }
    }

    private JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Integer, String> entry : this.c.entrySet()) {
            try {
                jSONObject.put(entry.getKey() + "", entry.getValue());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    private String b() {
        h4 h4Var = this.e;
        return h4Var == null ? "" : h4Var.k0();
    }

    public int c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 21;
        }
        int iOptInt = jSONObject.optInt("type");
        this.c.put(Integer.valueOf(iOptInt), jSONObject.optString("reportUrl"));
        return 0;
    }

    public void c(Context context, bm bmVar, JSONObject jSONObject, String str) throws JSONException {
        String strOptString;
        String str2;
        long j;
        boolean zA;
        String str3;
        String str4;
        boolean z;
        ApkDownloadTask apkDownloadTask;
        Context context2;
        jSONObject.toString();
        String strOptString2 = jSONObject.optString("packageName");
        String strOptString3 = jSONObject.optString("url");
        boolean z2 = jSONObject.optInt(i, 1) == 1;
        if (TextUtils.isEmpty(strOptString2)) {
            a(bmVar, str, 10);
            return;
        }
        if (TextUtils.isEmpty(strOptString3)) {
            a(bmVar, str, 16);
            return;
        }
        String strOptString4 = jSONObject.optString("launchUrl");
        String strOptString5 = jSONObject.optString("appName");
        String strOptString6 = jSONObject.optString("appIcon", "unknown");
        String strOptString7 = jSONObject.optString("adInfo");
        JSONObject jSONObject2 = null;
        if (TextUtils.isEmpty(strOptString7)) {
            strOptString = "unknown";
        } else {
            try {
                JSONObject jSONObject3 = new JSONObject(strOptString7);
                try {
                    strOptString = jSONObject3.optString("clickId", "unknown");
                } catch (JSONException unused) {
                    strOptString = null;
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
                strOptString = null;
            }
        }
        h4 h4Var = this.e;
        if (h4Var != null) {
            String strP = h4Var.p();
            long jM0 = this.e.M0();
            if (TextUtils.isEmpty(strOptString4)) {
                strOptString4 = this.e.G();
            }
            zA = n6.a(this.e, com.qq.e.comm.plugin.apkmanager.l.e().b(strOptString2));
            str2 = strP;
            j = jM0;
        } else {
            str2 = "";
            j = 0;
            zA = false;
        }
        ApkDownloadTask apkDownloadTask2 = new ApkDownloadTask(sn.a(this.e, jSONObject2), strOptString, strOptString6, strOptString3, strOptString5, strOptString2, 0);
        apkDownloadTask2.a(strOptString4, a(), z2);
        if (jSONObject.optLong("supportMarket") > 0) {
            str3 = str2;
            z = false;
            str4 = strOptString2;
            if (a(context, bmVar, str, apkDownloadTask2, j)) {
                return;
            }
        } else {
            str3 = str2;
            str4 = strOptString2;
            z = false;
        }
        v20 v20VarA = j3.a(str4);
        v20VarA.b = 4;
        v20VarA.h = 2;
        v20VarA.e = 3;
        a(bmVar, str4, str);
        a(bmVar);
        DownloadConfirmListener downloadConfirmListenerA = d3.b().a(b());
        qm$h$$ExternalSyntheticBackport0.m(downloadConfirmListenerA);
        j3.a(4001024, 4, this.f);
        if (!zA || downloadConfirmListenerA == null) {
            apkDownloadTask = apkDownloadTask2;
            context2 = context;
        } else {
            apkDownloadTask = apkDownloadTask2;
            context2 = context;
            if (context2 instanceof Activity) {
                v20VarA.g = 5;
                j3.a(4001025, 4, 104, this.f);
                t3.a(str4, 1100910, this.f);
                downloadConfirmListenerA.onDownloadConfirm((Activity) context2, 2, str3, new a(apkDownloadTask, str4, bmVar, str));
                return;
            }
        }
        if (zA) {
            v20VarA.g = 6;
            j3.a(4001025, 4, 104, this.f);
            t3.a(str4, 1100910, this.f);
            a(context2, new b(bmVar, str, str4, apkDownloadTask), str3, z);
            return;
        }
        v20VarA.g = 1;
        t3.a(str4, 1100911, this.f);
        com.qq.e.comm.plugin.apkmanager.l.e().c(apkDownloadTask);
    }

    public String c() {
        if (!as.i()) {
            return "none";
        }
        int i2 = g.a[r1.d().c().p().ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : com.baidu.mobads.container.util.e.a.a : NetworkUtils.MOBILE_NETWORK_2G : NetworkUtils.MOBILE_NETWORK_3G : NetworkUtils.MOBILE_NETWORK_4G;
    }

    public void b(Context context, bm bmVar, JSONObject jSONObject, String str) throws JSONException {
        h4 h4Var = this.e;
        String strP = h4Var != null ? h4Var.p() : "";
        h4 h4Var2 = this.e;
        boolean z = h4Var2 != null && n6.c(h4Var2, 8);
        DownloadConfirmListener downloadConfirmListenerA = d3.b().a(b());
        qm$h$$ExternalSyntheticBackport0.m(downloadConfirmListenerA);
        if (z && downloadConfirmListenerA != null && (context instanceof Activity)) {
            downloadConfirmListenerA.onDownloadConfirm((Activity) context, 258, strP, new c(context, bmVar, jSONObject, str));
        } else if (z) {
            a(context, (rs) new d(bmVar, str, context, jSONObject), strP, true);
        } else {
            a(context, bmVar, jSONObject, str);
        }
    }

    @Override // com.qq.e.comm.plugin.e30
    public ih<String> a(jm jmVar, ug ugVar) throws JSONException {
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD == null) {
            return new ih<>(PointType.SIGMOB_REPORT_TRACKING);
        }
        if (jmVar.a() == null) {
            return new ih<>(null);
        }
        bm bmVarB = jmVar.b();
        Context context = jmVar.getContext();
        String strA = ugVar.a();
        String strB = ugVar.b();
        if ("openApp".equals(strA)) {
            return new ih<>(b(context, jSONObjectD) + "");
        }
        if ("isAppInstall".equals(strA)) {
            return new ih<>(a(context, jSONObjectD) + "");
        }
        if ("getDownloadStatus".equals(strA)) {
            return new ih<>(b(jSONObjectD) + "");
        }
        if ("pauseDownload".equals(strA)) {
            return new ih<>(a(jSONObjectD) + "");
        }
        if ("startDownload".equals(strA)) {
            c(context, bmVarB, jSONObjectD, strB);
            return new ih<>(null);
        }
        if ("resumeDownload".equals(strA)) {
            c(bmVarB, jSONObjectD, strB);
            return new ih<>(null);
        }
        if ("removeDownload".equals(strA)) {
            b(bmVarB, jSONObjectD, strB);
            return new ih<>(null);
        }
        if ("registerListener".equals(strA)) {
            a(bmVarB, jSONObjectD, strB);
            return new ih<>(null);
        }
        if ("installApp".equals(strA)) {
            b(context, bmVarB, jSONObjectD, strB);
            return new ih<>(null);
        }
        if ("type".equals(strA)) {
            return new ih<>(c());
        }
        if ("reportMsgByUrl".equals(strA)) {
            return new ih<>(c(jSONObjectD) + "");
        }
        if (PointCategory.NETWORK.equals(ugVar.e())) {
            return new xr().a(jmVar, ugVar);
        }
        return new ih<>(null);
    }

    public int b(Context context, JSONObject jSONObject) {
        boolean z;
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("packageName");
        Intent intent = new Intent();
        try {
            if (!TextUtils.isEmpty(strOptString)) {
                Uri uri = Uri.parse(strOptString);
                if (com.alipay.sdk.m.l.a.r.equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme())) {
                    return 11;
                }
                intent.setData(uri);
                intent.setAction("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(strOptString2)) {
                    intent.setPackage(strOptString2);
                }
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    intent = context.getPackageManager().getLaunchIntentForPackage(strOptString2);
                    if (intent == null) {
                        return 12;
                    }
                    intent.addFlags(268435456);
                    if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                        return 12;
                    }
                } else {
                    z = true;
                    ct.a(intent, strOptString2, strOptString, z);
                    context.startActivity(intent);
                    v20 v20VarA = j3.a(strOptString2);
                    v20VarA.e = 3;
                    v20VarA.i = 1;
                    t3.a(strOptString2, this.f, true);
                    return 0;
                }
            } else {
                intent = context.getPackageManager().getLaunchIntentForPackage(strOptString2);
                if (intent == null) {
                    return 12;
                }
                intent.addFlags(268435456);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    return 12;
                }
            }
            ct.a(intent, strOptString2, strOptString, z);
            context.startActivity(intent);
            v20 v20VarA2 = j3.a(strOptString2);
            v20VarA2.e = 3;
            v20VarA2.i = 1;
            t3.a(strOptString2, this.f, true);
            return 0;
        } catch (Exception unused) {
            t3.a(strOptString2, this.f, false);
            return 1000;
        }
        z = false;
    }

    public int b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(strOptString)) {
            return 0;
        }
        return a(com.qq.e.comm.plugin.apkmanager.l.e().b(strOptString));
    }

    public void a(Context context, bm bmVar, JSONObject jSONObject, String str) throws JSONException {
        String strOptString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(strOptString)) {
            a(bmVar, str, 10);
            return;
        }
        int iB = com.qq.e.comm.plugin.apkmanager.l.e().b(strOptString);
        if (!h10.d(iB)) {
            String.format("install call failed(%s,%s)", Integer.valueOf(iB), strOptString);
            a(bmVar, str, 17);
            return;
        }
        File fileB = gu.b(strOptString + ".apk");
        if (fileB != null && fileB.exists()) {
            b(4001010, false, 0L, this.f);
            ApkDownloadTask apkDownloadTask = new ApkDownloadTask(strOptString, this.e);
            if (!new com.qq.e.comm.plugin.apkmanager.o(context, apkDownloadTask).b(fileB)) {
                a(bmVar, str, 19);
                return;
            }
            v20 v20VarA = j3.a(strOptString);
            v20VarA.e = 3;
            v20VarA.h = 2;
            v20VarA.d = 8;
            v20VarA.f = 1;
            t3.c(1100905, apkDownloadTask);
            a(bmVar, strOptString, str);
            a(bmVar);
            a(strOptString, false, this.c.get(2));
            ((ApkCallback) x5.b(strOptString, ApkCallback.class)).b0().b(2);
            return;
        }
        a(bmVar, str, 18);
    }

    public void b(bm bmVar, JSONObject jSONObject, String str) throws JSONException {
        String strOptString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(strOptString)) {
            a(bmVar, str, 10);
            return;
        }
        ApkDownloadTask apkDownloadTaskC = com.qq.e.comm.plugin.apkmanager.l.e().c(strOptString);
        if (apkDownloadTaskC != null) {
            j3.a(strOptString).b = 4;
            j3.a(4001074, apkDownloadTaskC, 1);
            if (com.qq.e.comm.plugin.apkmanager.l.e().a(apkDownloadTaskC, true)) {
                j3.a(4001075, apkDownloadTaskC, 1);
            } else {
                a(bmVar, str, 22);
            }
        }
    }

    public int a(Context context, JSONObject jSONObject) {
        return q.b(context, jSONObject.optString("packageName")) ? 1 : 0;
    }

    private void a(bm bmVar, String str) {
        bmVar.a(new vg(new ug(str), vg.a.OK, "", 2));
    }

    public int a(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(strOptString)) {
            return 10;
        }
        ApkDownloadTask apkDownloadTaskC = com.qq.e.comm.plugin.apkmanager.l.e().c(strOptString);
        if (apkDownloadTaskC != null) {
            j3.b(4001004, apkDownloadTaskC, 1, 102);
            if (com.qq.e.comm.plugin.apkmanager.l.e().a(apkDownloadTaskC)) {
                return 0;
            }
        }
        return 15;
    }

    private void a(bm bmVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String strRemove = this.b.remove(str);
        if (!TextUtils.isEmpty(strRemove)) {
            a(bmVar, strRemove);
        }
        this.b.put(str, str2);
    }

    private void a(bm bmVar) {
        this.d = bmVar;
        if (this.a.compareAndSet(false, true)) {
            com.qq.e.comm.plugin.apkmanager.l.e().a(this.h);
        }
    }

    public void a(bm bmVar, JSONObject jSONObject, String str) throws JSONException {
        String strOptString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(strOptString)) {
            a(bmVar, str, 10);
        } else {
            a(bmVar, strOptString, str);
            a(bmVar);
        }
    }

    private void a(bm bmVar, String str, int i2, String str2, int i3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        boolean z = i2 == 0;
        try {
            jSONObject.put("marketResult", z);
            if (!z) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", i2);
                jSONObject2.put("scheme", str2);
                jSONObject.put("errorMessage", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.getMessage();
        }
        bmVar.a(new vg(new ug(str), vg.a.OK, jSONObject, i3));
    }

    private boolean a(Context context, bm bmVar, String str, ApkDownloadTask apkDownloadTask, long j) throws JSONException {
        String strR = apkDownloadTask.r();
        b10.a(1100418, this.f, 2);
        if (context != null && !TextUtils.isEmpty(strR)) {
            h4 h4Var = this.e;
            bp bpVarM0 = h4Var == null ? null : h4Var.m0();
            if (!ap.a(bpVarM0, j)) {
                b10.a(1100420, this.f, 2, 314, null);
                a(bmVar, str, 314, (String) null, 1);
                return false;
            }
            j3.a(strR).h = 1;
            Intent intentA = ap.a(context, bpVarM0, strR, j);
            if (intentA == null) {
                b10.a(1100420, this.f, 2, 315, null);
                a(bmVar, str, 315, ap.a(bpVarM0, strR), 1);
                return false;
            }
            boolean zA = ap.a(bpVarM0);
            if (zA) {
                try {
                    z50.a().a(strR, new i(this.f));
                } catch (Throwable unused) {
                    if (zA) {
                        z50.a().a(strR);
                    }
                    b10.a(1100420, this.f, 2, 317, null);
                    a(bmVar, str, 317, intentA.getDataString(), 1);
                    return false;
                }
            }
            context.startActivity(intentA);
            a(bmVar, str, 0, (String) null, 0);
            ((ApkCallback) x5.b(strR, ApkCallback.class)).g().b(2);
            o.b(apkDownloadTask, null);
            b10.a(1100419, this.f, 2);
            a(strR, true, o.b(apkDownloadTask));
            return true;
        }
        b10.a(1100420, this.f, 2, 206, null);
        a(bmVar, str, 206, (String) null, 1);
        return false;
    }

    private void a(String str, boolean z, String str2) {
        h hVar = new h(str, str2, z, this.e, this.f);
        ApkDownloadTask apkDownloadTask = new ApkDownloadTask(str, this.e);
        apkDownloadTask.a("appStore", z ? 1 : 0);
        o.h.c.a(hVar, apkDownloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bm bmVar, String str, int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i2);
        } catch (JSONException e2) {
            e2.getMessage();
        }
        bmVar.a(new vg(new ug(str), vg.a.OK, jSONObject));
    }

    private void a(Context context, rs rsVar, String str, boolean z) {
        xo.a((Runnable) new e(context, rsVar, z));
    }
}
