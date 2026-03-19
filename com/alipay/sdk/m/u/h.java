package com.alipay.sdk.m.u;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.n;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h {
    public static final String i = "failed";
    public static final String j = "scheme_failed";
    public Activity a;
    public volatile IAlixPay b;
    public boolean d;
    public f e;
    public final com.alipay.sdk.m.s.a f;
    public final Object c = IAlixPay.class;
    public boolean g = false;
    public String h = null;

    public class a implements APayEntranceActivity.a {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            h.this.h = str;
            synchronized (this.a) {
                try {
                    this.a.notify();
                } finally {
                }
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ APayEntranceActivity.a a;

        public b(APayEntranceActivity.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f == null || h.this.f.d()) {
                return;
            }
            com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.e0, "");
            if (com.alipay.sdk.m.m.a.z().t()) {
                h.this.f.b(true);
                this.a.a(com.alipay.sdk.m.j.b.a());
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Object b;

        public c(Intent intent, Object obj) {
            this.a = intent;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.this.a != null) {
                    h.this.a.startActivity(this.a);
                } else {
                    com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.c0, "");
                    Context contextA = h.this.f.a();
                    if (contextA != null) {
                        contextA.startActivity(this.a);
                    }
                }
            } finally {
            }
        }
    }

    public class d extends IRemoteServiceCallback.Stub {
        public d() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.p, str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (h.this.e != null) {
                    h.this.e.a();
                }
                if (h.this.f != null) {
                    h.this.f.c(true);
                }
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e) {
                com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Z, e);
            }
            intent.setClassName(str, str2);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
                }
            } catch (Throwable unused) {
            }
            try {
                if (h.this.a != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    h.this.a.startActivity(intent);
                    com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "stAct2", "" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                    return;
                }
                com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                Context contextA = h.this.f.a();
                if (contextA != null) {
                    contextA.startActivity(intent);
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th);
                throw th;
            }
        }

        public /* synthetic */ d(h hVar, a aVar) {
            this();
        }
    }

    public class e implements ServiceConnection {
        public e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "srvCon");
            synchronized (h.this.c) {
                h.this.b = IAlixPay.Stub.asInterface(iBinder);
                h.this.c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "srvDis");
            h.this.b = null;
        }

        public /* synthetic */ e(h hVar, a aVar) {
            this();
        }
    }

    public interface f {
        void a();

        void b();
    }

    public h(Activity activity, com.alipay.sdk.m.s.a aVar, f fVar) {
        this.a = activity;
        this.f = aVar;
        this.e = fVar;
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "alipaySdk");
    }

    public String a(String str, boolean z) {
        n.c cVarA;
        String strB = "";
        try {
            List<a.b> listJ = com.alipay.sdk.m.m.a.z().j();
            if (!com.alipay.sdk.m.m.a.z().g || listJ == null) {
                listJ = com.alipay.sdk.m.j.a.d;
            }
            cVarA = n.a(this.f, this.a, listJ);
        } catch (Throwable th) {
            th = th;
            cVarA = null;
        }
        if (cVarA != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.N, th);
                boolean zB = n.b(this.f);
                return z ? a(str, strB, packageInfo) : a(str, strB, packageInfo);
                return a(str, strB, packageInfo, cVarA);
            }
            if (cVarA.a(this.f) || cVarA.a() || n.a(cVarA.a)) {
                return i;
            }
            if (cVarA.a != null && !n.b.equals(cVarA.a.packageName)) {
                strB = cVarA.a.packageName;
            } else {
                strB = n.b();
            }
            packageInfo = cVarA.a != null ? cVarA.a : null;
            String strC = com.alipay.sdk.m.m.a.z().c();
            if (strC != null) {
                if (strC.length() > 0) {
                    try {
                        JSONObject jSONObjectOptJSONObject = new JSONObject(strC).optJSONObject(strB);
                        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                int i2 = Integer.parseInt(next);
                                if (packageInfo != null && packageInfo.versionCode >= i2) {
                                    try {
                                        boolean zA = com.alipay.sdk.m.m.a.z().a(this.a, Integer.parseInt(jSONObjectOptJSONObject.getString(next)));
                                        this.g = zA;
                                        if (zA) {
                                            break;
                                        }
                                    } catch (Exception unused) {
                                        continue;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
            boolean zB2 = n.b(this.f);
            if ((z && !this.g) || zB2 || !a(strB, this.a, this.f)) {
                return a(str, strB, packageInfo, cVarA);
            }
        }
        return i;
    }

    private void a(n.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar == null || (packageInfo = cVar.a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.a.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.g0, th);
        }
        Thread.sleep(200L);
    }

    private String a(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "pay payInvokeAct");
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, str2 + "|" + str3);
        Activity activity = this.a;
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(activity, aVar, str, aVar.d);
        return a(str, str2);
    }

    private String a(String str, String str2, PackageInfo packageInfo, n.c cVar) {
        String str3;
        Activity activity;
        boolean zContains = false;
        int i2 = packageInfo != null ? packageInfo.versionCode : 0;
        if (packageInfo != null) {
            String str4 = packageInfo.versionName;
        }
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "pay bind or scheme");
        com.alipay.sdk.m.s.a aVar = this.f;
        if (aVar != null && !TextUtils.isEmpty(aVar.g)) {
            zContains = this.f.g.toLowerCase().contains(com.alipay.sdk.m.k.b.n);
        }
        if (!zContains && n.d(this.f, str2)) {
            if (cVar != null) {
                try {
                    if (com.alipay.sdk.m.m.a.z().x()) {
                        a(cVar);
                    }
                } catch (Throwable unused) {
                }
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindSkipByL");
            str3 = i;
        } else {
            if (cVar != null) {
                try {
                    if (!com.alipay.sdk.m.m.a.z().n()) {
                        a(cVar);
                    }
                } catch (Throwable unused2) {
                }
            }
            Pair<String, Boolean> pairA = a(str, str2, this.f);
            str3 = (String) pairA.first;
            try {
                if (i.equals(str3) && ((Boolean) pairA.second).booleanValue() && com.alipay.sdk.m.m.a.z().l()) {
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindRetry");
                    str3 = (String) a(str, str2, this.f).first;
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindRetryEx", th);
            }
        }
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "pay bind result: " + str3);
        Activity activity2 = this.a;
        com.alipay.sdk.m.s.a aVar2 = this.f;
        com.alipay.sdk.m.k.a.a(activity2, aVar2, str, aVar2.d);
        if (i.equals(str3)) {
            if (!n.b.equals(str2)) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPNotStartByAlipay", str2 + "|" + i2);
                return str3;
            }
            if (i2 >= 460 && !zContains && (activity = this.a) != null && a(str2, activity, this.f)) {
                return a(str, str2, packageInfo);
            }
        }
        return str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x02f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.String, java.lang.Boolean> a(java.lang.String r19, java.lang.String r20, com.alipay.sdk.m.s.a r21) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.h.a(java.lang.String, java.lang.String, com.alipay.sdk.m.s.a):android.util.Pair");
    }

    private String a(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String strA = n.a(32);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAStart", strA + "|" + jElapsedRealtime);
        a.C0059a.a(this.f, strA);
        a aVar = new a(obj);
        APayEntranceActivity.h.put(strA, aVar);
        try {
            try {
                HashMap<String, String> mapA = com.alipay.sdk.m.s.a.a(this.f);
                mapA.put("ts_intent", String.valueOf(jElapsedRealtime));
                jSONObject = new JSONObject(mapA);
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSALocEx", th);
                jSONObject = null;
            }
            Intent intent = new Intent(this.a, (Class<?>) APayEntranceActivity.class);
            intent.putExtra(APayEntranceActivity.d, str);
            intent.putExtra(APayEntranceActivity.e, str2);
            intent.putExtra(APayEntranceActivity.f, strA);
            if (jSONObject != null) {
                intent.putExtra(APayEntranceActivity.g, jSONObject.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new b(aVar), com.alipay.sdk.m.m.a.z().i());
            Activity activity = this.a;
            com.alipay.sdk.m.s.a aVar2 = this.f;
            com.alipay.sdk.m.k.a.a(activity, aVar2, str, aVar2.d);
            if (com.alipay.sdk.m.m.a.z().w()) {
                new Handler(Looper.getMainLooper()).post(new c(intent, obj));
            } else {
                try {
                    Activity activity2 = this.a;
                    if (activity2 != null) {
                        activity2.startActivity(intent);
                    } else {
                        com.alipay.sdk.m.k.a.b(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                        Context contextA = this.f.a();
                        if (contextA != null) {
                            contextA.startActivity(intent);
                        }
                    }
                } catch (Throwable th2) {
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th2);
                    throw th2;
                }
            }
            synchronized (obj) {
                obj.wait();
            }
            String str3 = this.h;
            String str4 = "unknown";
            try {
                String str5 = l.a(this.f, str3).get(l.a);
                str4 = str5 == null ? ILogConst.CACHE_PLAY_REASON_NULL : str5;
            } catch (Throwable th3) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAStatEx", th3);
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSADone-" + str4);
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEmpty");
            return j;
        } catch (InterruptedException e2) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAWaiting", e2);
            return com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.c.PAY_WAITTING.b(), com.alipay.sdk.m.j.c.PAY_WAITTING.a(), "");
        } catch (Throwable th4) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEx", th4);
            n.a("alipaySdk", com.alipay.sdk.m.l.b.q, this.a, this.f);
            return j;
        }
    }

    public void a() {
        this.a = null;
        this.e = null;
    }

    public static boolean a(String str, Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail", th);
            return false;
        }
    }
}
