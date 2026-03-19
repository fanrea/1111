package com.sigmob.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.location.Location;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.AdLifecycleManager;
import com.czhj.sdk.common.utils.RomUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.common.t;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityActive;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.i;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static WeakReference<Activity> a = null;
    private static Context b = null;
    private static a c = null;
    private static WeakReference<Activity> d = null;
    private static boolean e = false;
    private static DeviceContext f;
    private static Handler g;
    private static C0728b h;

    /* JADX INFO: Access modifiers changed from: private */
    static class a implements AdLifecycleManager.LifecycleListener {
        private String a;
        private long b;
        private String d;
        private int e;
        private boolean i;
        private final BroadcastReceiver k;
        private final Map<String, String> c = new HashMap();
        private boolean f = true;
        private boolean g = false;
        private boolean h = false;
        private int j = 0;

        a() {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.sigmob.sdk.b.a.1
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
                @Override // android.content.BroadcastReceiver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onReceive(android.content.Context r5, android.content.Intent r6) {
                    /*
                        r4 = this;
                        java.lang.String r5 = r6.getAction()
                        boolean r6 = com.sigmob.sdk.base.utils.m.a(r5)
                        if (r6 == 0) goto Lb
                        return
                    Lb:
                        byte[] r5 = r5.getBytes()
                        r6 = 2
                        java.lang.String r5 = android.util.Base64.encodeToString(r5, r6)
                        r5.hashCode()
                        r0 = -1
                        int r1 = r5.hashCode()
                        r2 = 1
                        r3 = 0
                        switch(r1) {
                            case -252353173: goto L37;
                            case 1349729289: goto L2c;
                            case 1349784159: goto L23;
                            default: goto L21;
                        }
                    L21:
                        r6 = r0
                        goto L41
                    L23:
                        java.lang.String r1 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PTg=="
                        boolean r5 = r5.equals(r1)
                        if (r5 != 0) goto L41
                        goto L21
                    L2c:
                        java.lang.String r6 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PRkY="
                        boolean r5 = r5.equals(r6)
                        if (r5 != 0) goto L35
                        goto L21
                    L35:
                        r6 = r2
                        goto L41
                    L37:
                        java.lang.String r6 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlVTRVJfUFJFU0VOVA=="
                        boolean r5 = r5.equals(r6)
                        if (r5 != 0) goto L40
                        goto L21
                    L40:
                        r6 = r3
                    L41:
                        r5 = 0
                        switch(r6) {
                            case 0: goto L60;
                            case 1: goto L51;
                            case 2: goto L46;
                            default: goto L45;
                        }
                    L45:
                        goto L70
                    L46:
                        java.lang.String r6 = "screen on"
                        com.czhj.sdk.logger.SigmobLog.d(r6)
                        java.lang.String r6 = "screen_on"
                    L4d:
                        com.sigmob.sdk.base.common.ac.b(r6, r5, r5)
                        goto L70
                    L51:
                        java.lang.String r6 = "screen off"
                        com.czhj.sdk.logger.SigmobLog.d(r6)
                        com.sigmob.sdk.manager.d r6 = com.sigmob.sdk.manager.d.a()
                        r6.a(r2)
                        java.lang.String r6 = "locked"
                        goto L4d
                    L60:
                        java.lang.String r6 = "screen user present"
                        com.czhj.sdk.logger.SigmobLog.d(r6)
                        com.sigmob.sdk.manager.d r6 = com.sigmob.sdk.manager.d.a()
                        r6.a(r3)
                        java.lang.String r6 = "unlock"
                        goto L4d
                    L70:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.b.a.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
                }
            };
            this.k = broadcastReceiver;
            AdLifecycleManager.getInstance().initialize(b.h());
            this.b = System.currentTimeMillis();
            this.a = UUID.randomUUID().toString();
            SigmobLog.i("session_start: " + this.b + ":" + this.a);
            PointEntityActive.ActiveTracking(PointCategory.SESSION_START, this.a, "0", String.valueOf(this.b));
            AdLifecycleManager.getInstance().addLifecycleListener(this);
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(new String(Base64.decode(n.M, 2)));
                intentFilter.addAction(new String(Base64.decode(n.N, 2)));
                intentFilter.addAction(new String(Base64.decode(n.O, 2)));
                t.a(b.b, broadcastReceiver, intentFilter);
            } catch (Throwable th) {
                SigmobLog.e("register screen status receiver error" + th.getMessage());
            }
        }

        public int a() {
            return this.e;
        }

        public void a(Activity activity) {
        }

        public void a(Activity activity, int reqCode, int resCode, Intent data) {
        }

        public void b(Activity activity) {
        }

        public void onCreate(Activity activity) {
            String simpleName = activity.getClass().getSimpleName();
            this.d = simpleName;
            this.c.put(simpleName, simpleName);
            this.f = true;
            this.g = false;
        }

        public void onDestroy(Activity activity) {
            if (activity instanceof AdActivity) {
                this.i = false;
            }
            this.c.remove(activity.getClass().getSimpleName());
            if (this.c.isEmpty() && this.f) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = (jCurrentTimeMillis - this.b) / 1000;
                SigmobLog.i("onActivityDestroyed session_end: " + jCurrentTimeMillis + ":" + this.a + ":" + j);
                PointEntityActive.ActiveTracking(PointCategory.SESSION_END, this.a, String.valueOf(j), String.valueOf(jCurrentTimeMillis));
                this.b = System.currentTimeMillis();
                this.f = false;
            }
            if (this.c.isEmpty()) {
                this.h = true;
            }
        }

        public void onPause(Activity activity) {
            int i;
            if (RomUtils.isHuawei()) {
                int i2 = this.j;
                if (i2 == 0) {
                    i = 1;
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        b.g.removeCallbacksAndMessages(null);
                        return;
                    }
                    i = 0;
                }
                this.j = i;
                return;
            }
            this.j = 3;
        }

        public void onResume(final Activity activity) {
            if (activity instanceof AdActivity) {
                this.i = true;
            } else if (!this.i) {
                WeakReference unused = b.d = new WeakReference(activity);
            }
            if (RomUtils.isHuawei()) {
                int i = this.j;
                if (i == 1) {
                    this.j = 2;
                } else if (i == 3) {
                    b.g.postDelayed(new Runnable() { // from class: com.sigmob.sdk.b$a$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.b(activity);
                        }
                    }, 500L);
                }
            } else {
                b.c(activity);
            }
            this.g = !activity.getClass().getSimpleName().equals(this.d);
            this.d = activity.getClass().getSimpleName();
            if (this.g) {
                WeakReference unused2 = b.a = new WeakReference(activity);
            }
            if (!this.f || this.h) {
                this.h = false;
                this.a = UUID.randomUUID().toString();
                this.b = System.currentTimeMillis();
                this.f = true;
                SigmobLog.i("onActivityResumed session_start: " + this.b + ":" + this.a);
                PointEntityActive.ActiveTracking(PointCategory.SESSION_START, this.a, "0", String.valueOf(this.b));
            }
        }

        public void onStart(Activity activity) {
            this.j = 0;
            this.e++;
        }

        public void onStop(Activity activity) {
            this.e--;
            b.g.removeCallbacksAndMessages(null);
            Activity activityI = b.i();
            String simpleName = activity.getClass().getSimpleName();
            if (simpleName.equals(this.d) || (com.sigmob.sdk.base.utils.n.b(activityI) && simpleName.equals(activityI.getClass().getSimpleName()))) {
                b.j();
                if (!this.g || this.c.size() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = (jCurrentTimeMillis - this.b) / 1000;
                    SigmobLog.i("onActivityStopped session_end: " + jCurrentTimeMillis + ":" + this.a + ":" + j);
                    PointEntityActive.ActiveTracking(PointCategory.SESSION_END, this.a, String.valueOf(j), String.valueOf(jCurrentTimeMillis));
                    this.b = System.currentTimeMillis();
                    this.f = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.sigmob.sdk.b$b, reason: collision with other inner class name */
    static class C0728b implements SensorEventListener {
        private static final int a = 1000;
        private volatile Boolean b = null;

        C0728b() {
            b();
            c();
        }

        private void b() {
            if (b.b == null) {
                return;
            }
            ae.a(b.b).a(this);
        }

        private void c() {
            ThreadPoolFactory.BackgroundThreadPool.getInstance().getIOHandler().postDelayed(new Runnable() { // from class: com.sigmob.sdk.b$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e();
                }
            }, 1000L);
        }

        private void d() {
            if (b.b == null) {
                return;
            }
            ae.a(b.b).b(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (this.b == null) {
                this.b = false;
            }
        }

        public Boolean a() {
            if (this.b == null) {
                return true;
            }
            return this.b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            this.b = true;
            d();
        }
    }

    public static String a() {
        return "";
    }

    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        a = new WeakReference<>(activity);
    }

    public static synchronized void a(Context context) {
        if (b == null) {
            Context applicationContext = context.getApplicationContext();
            b = applicationContext;
            i.a(applicationContext, n.o);
            o.a().e();
            b(b);
            com.sigmob.sdk.base.db.a.a(b);
            ClientMetadata.getInstance().initialize(b);
            n();
            g = new Handler(Looper.getMainLooper());
        }
    }

    public static void a(boolean hasAdLoaded) {
        e = hasAdLoaded;
    }

    public static DeviceContext b() {
        DeviceContext deviceContext = f;
        if (deviceContext != null || b == null) {
            return deviceContext;
        }
        DeviceContext deviceContext2 = new DeviceContext() { // from class: com.sigmob.sdk.b.1
            private WindCustomController a() {
                return WindAds.sharedAds().getOptions().getCustomController();
            }

            public String getAndroidId() {
                WindCustomController windCustomControllerA = a();
                if ((windCustomControllerA == null || windCustomControllerA.isCanUseAndroidId()) && b.e && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                    return ClientMetadata.getInstance().getAndroidId();
                }
                if (windCustomControllerA == null || windCustomControllerA.isCanUseAndroidId()) {
                    return null;
                }
                return windCustomControllerA.getAndroidId();
            }

            public String getCarrier() {
                if (o.a().j()) {
                    return null;
                }
                WindCustomController windCustomControllerA = a();
                if (windCustomControllerA != null && !windCustomControllerA.isCanUseSimOperator()) {
                    return windCustomControllerA.getDevSimOperatorCode();
                }
                String networkOperatorForUrl = ClientMetadata.getInstance().getNetworkOperatorForUrl();
                SigmobLog.d(String.format("SDKContext: simOperator = %s", networkOperatorForUrl));
                return networkOperatorForUrl;
            }

            public String getCarrierName() {
                if (o.a().j()) {
                    return null;
                }
                WindCustomController windCustomControllerA = a();
                if (windCustomControllerA != null && !windCustomControllerA.isCanUseSimOperator()) {
                    return windCustomControllerA.getDevSimOperatorName();
                }
                String networkOperatorName = ClientMetadata.getInstance().getNetworkOperatorName();
                SigmobLog.d(String.format("SDKContext: carrierName = %s", networkOperatorName));
                return networkOperatorName;
            }

            public String getImei() {
                WindCustomController windCustomControllerA = a();
                if (((windCustomControllerA == null || windCustomControllerA.isCanUsePhoneState()) && b.e && WindAds.sharedAds().isPersonalizedAdvertisingOn()) || windCustomControllerA == null || windCustomControllerA.isCanUsePhoneState()) {
                    return null;
                }
                return windCustomControllerA.getDevImei();
            }

            public String getImei1() {
                WindCustomController windCustomControllerA = a();
                if (((windCustomControllerA == null || windCustomControllerA.isCanUsePhoneState()) && b.e && WindAds.sharedAds().isPersonalizedAdvertisingOn()) || windCustomControllerA == null || windCustomControllerA.isCanUsePhoneState()) {
                    return null;
                }
                return windCustomControllerA.getDevImei();
            }

            public String getImei2() {
                WindCustomController windCustomControllerA = a();
                if (((windCustomControllerA == null || windCustomControllerA.isCanUsePhoneState()) && b.e && WindAds.sharedAds().isPersonalizedAdvertisingOn()) || windCustomControllerA == null || windCustomControllerA.isCanUsePhoneState()) {
                    return null;
                }
                return windCustomControllerA.getDevImei();
            }

            public Location getLocation() {
                if (o.a().S()) {
                    return null;
                }
                WindCustomController windCustomControllerA = a();
                return (windCustomControllerA == null || windCustomControllerA.isCanUseLocation()) ? ClientMetadata.getInstance().getLocation() : windCustomControllerA.getLocation();
            }

            public String getOaid() {
                WindCustomController windCustomControllerA = a();
                return (windCustomControllerA == null || windCustomControllerA.isCanUseOaid()) ? ClientMetadata.getInstance().getOAID() : windCustomControllerA.getDevOaid();
            }

            public boolean isCustomAndroidId() {
                WindCustomController windCustomControllerA = a();
                return windCustomControllerA == null || windCustomControllerA.isCanUseAndroidId();
            }

            public boolean isCustomOaId() {
                WindCustomController windCustomControllerA = a();
                return (windCustomControllerA == null || windCustomControllerA.isCanUseOaid()) ? false : true;
            }

            public boolean isCustomOperatorCode() {
                WindCustomController windCustomControllerA = a();
                return (windCustomControllerA == null || windCustomControllerA.isCanUseSimOperator() || m.a((CharSequence) windCustomControllerA.getDevSimOperatorCode())) ? false : true;
            }

            public boolean isCustomOperatorName() {
                WindCustomController windCustomControllerA = a();
                return (windCustomControllerA == null || windCustomControllerA.isCanUseSimOperator() || m.a((CharSequence) windCustomControllerA.getDevSimOperatorName())) ? false : true;
            }

            public boolean isCustomPhoneState() {
                WindCustomController windCustomControllerA = a();
                return windCustomControllerA == null || windCustomControllerA.isCanUsePhoneState();
            }
        };
        f = deviceContext2;
        return deviceContext2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(Activity activity) {
        c(activity);
    }

    private static void b(Context context) {
        Networking.AddSigmobServerURL(o.c());
        Networking.AddSigmobServerURL(o.a().t());
        Networking.AddSigmobServerURL(o.a().u());
        Networking.AddSigmobServerURL(o.a().r());
        Networking.initializeV2(context);
        Networking.initializeSigRequestQueue(context);
    }

    public static Activity c() {
        WeakReference<Activity> weakReference = d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Activity activity) {
        q();
        d(activity);
    }

    public static void d() {
        if (c == null) {
            c = new a();
        }
    }

    private static void d(Activity activity) {
        Uri uri;
        BaseAdUnit baseAdUnitM = g.m();
        if (baseAdUnitM == null || activity == null) {
            return;
        }
        g.d((BaseAdUnit) null);
        baseAdUnitM.getClickCommon().isDeeplink = "0";
        com.sigmob.sdk.manager.b.b(baseAdUnitM, "open_deeplink_failed", null);
        String landing_page = baseAdUnitM.getLanding_page();
        if (m.a((CharSequence) landing_page) || (uri = Uri.parse(landing_page)) == null) {
            return;
        }
        if (!baseAdUnitM.isSkipSigmobBrowser()) {
            g.a(baseAdUnitM);
            AdActivity.a(activity, (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnitM.getUuid());
        } else {
            try {
                t.a(activity, uri);
            } catch (Throwable th) {
                SigmobLog.e("can't open load ", th);
            }
        }
    }

    public static Context e() {
        return b;
    }

    public static boolean f() {
        if (h == null) {
            h = new C0728b();
        }
        return h.a().booleanValue();
    }

    public static boolean g() {
        AudioManager audioManager;
        return (b == null || (audioManager = (AudioManager) e().getSystemService("audio")) == null || audioManager.getStreamVolume(3) != 0) ? false : true;
    }

    public static Application h() {
        Context context = b;
        if (context instanceof Application) {
            return (Application) context;
        }
        return null;
    }

    public static Activity i() {
        WeakReference<Activity> weakReference = a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static void j() {
        o();
        p();
    }

    private static void n() {
        WindAdOptions options;
        WindCustomController customController;
        List<PackageInfo> installPackageInfoList;
        if (o.a().T() || (options = WindAds.sharedAds().getOptions()) == null || (customController = options.getCustomController()) == null || customController.isCanUseAppList() || (installPackageInfoList = customController.getInstallPackageInfoList()) == null || installPackageInfoList.isEmpty()) {
            return;
        }
        Iterator<PackageInfo> it = installPackageInfoList.iterator();
        while (it.hasNext()) {
            ac.a(it.next(), 2);
        }
    }

    private static void o() {
        BaseAdUnit baseAdUnitF = g.f();
        if (baseAdUnitF == null) {
            return;
        }
        g.c((BaseAdUnit) null);
        com.sigmob.sdk.base.network.g.a(baseAdUnitF, "open_pkg");
        ac.a("open_pkg", "1", baseAdUnitF);
    }

    private static void p() {
        BaseAdUnit baseAdUnitM = g.m();
        if (baseAdUnitM == null) {
            return;
        }
        g.d((BaseAdUnit) null);
        baseAdUnitM.getClickCommon().isDeeplink = "1";
        Uri deeplinkUri = baseAdUnitM.getDeeplinkUri();
        com.sigmob.sdk.manager.b.b(baseAdUnitM, "open_deeplink", deeplinkUri == null ? baseAdUnitM.getDeeplinkUrl() : deeplinkUri.toString());
    }

    private static void q() {
        BaseAdUnit baseAdUnitF = g.f();
        if (baseAdUnitF == null) {
            return;
        }
        g.c((BaseAdUnit) null);
        ac.a("open_pkg", "0", baseAdUnitF);
    }
}
