package com.apm.insight;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.apm.applog.AppLog;
import com.apm.applog.InitConfig;
import com.apm.applog.UriConfig;
import com.apm.applog.network.INetworkClient;
import com.apm.insight.n.o;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.n;
import com.apm.insight.runtime.p;
import com.apm.insight.runtime.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class MonitorCrash {
    private static final String TAG = "MonitorCrash";
    private static volatile boolean sAppMonitorCrashInit = false;
    static String sDefaultApplogUrl;
    private volatile boolean isAppLogInit;
    volatile InitConfig mApmApplogConfig;
    Config mConfig;
    private Context mContext;
    AttachUserData mCustomData;
    AttachUserData mCustomLongData;
    private boolean mIsApp;
    HeaderParams mParams;
    private AtomicBoolean mStarted;
    Map<String, String> mTagMap;

    public static class Config {
        private static boolean v = false;
        String a;
        String b;
        String c;
        long d;
        String e;
        String[] f;
        String[] g;
        AttachUserData h;
        boolean i;
        Map<String, String> j;
        private String k;
        private String l;
        private String m;
        private InitConfig n;
        private String o;
        private IDynamicParams p;
        private boolean q;
        private boolean r;
        private boolean s;
        private boolean t;
        private boolean u;

        public static class Builder {
            private Config a;

            private Builder(String str) {
                Config config = new Config();
                this.a = config;
                config.a = str;
            }

            private Builder a() {
                this.a.q = false;
                return this;
            }

            public Builder autoStart(boolean z) {
                this.a.u = z;
                return this;
            }

            public Config build() {
                return this.a;
            }

            public Builder channel(String str) {
                this.a.c = str;
                return this;
            }

            public Builder crashProtect(boolean z) {
                g.g(z);
                return this;
            }

            public Builder customData(AttachUserData attachUserData) {
                this.a.h = attachUserData;
                return this;
            }

            public Builder customFile(CrashInfoCallback crashInfoCallback) {
                p.a(crashInfoCallback);
                return this;
            }

            public Builder customPageView(boolean z) {
                this.a.r = z;
                return this;
            }

            public Builder debugMode(boolean z) {
                Npth.getConfigManager().setDebugMode(z);
                return this;
            }

            public Builder dynamicParams(IDynamicParams iDynamicParams) {
                this.a.p = iDynamicParams;
                return this;
            }

            public Builder enableAnrInfo(boolean z) {
                g.c(z);
                return this;
            }

            public Builder enableApmPlusLog(boolean z) {
                Npth.getConfigManager().setApmPLusLogEnable(z);
                return this;
            }

            public Builder enableOptimizer(boolean z) {
                g.f(z);
                return this;
            }

            public Builder exitType(ExitType exitType) {
                g.b(exitType.type);
                return this;
            }

            public Builder fixPageView(boolean z) {
                this.a.t = z;
                return this;
            }

            public Builder looperMonitor(boolean z) {
                g.b(z);
                return this;
            }

            public Builder networkClient(INetworkClient iNetworkClient) {
                if (iNetworkClient != null) {
                    g.a(iNetworkClient);
                    AppLog.setNetworkClient(iNetworkClient);
                }
                return a();
            }

            public Builder pageViewTags(Map<String, String> map) {
                this.a.j = map;
                return this;
            }

            public Builder token(String str) {
                this.a.b = str;
                return this;
            }

            public Builder traceDump(boolean z) {
                g.h(z);
                return this;
            }

            public Builder url(String str) {
                this.a.o = str;
                return a();
            }

            public Builder versionCode(long j) {
                this.a.d = j;
                return this;
            }

            public Builder versionName(String str) {
                this.a.e = str;
                return this;
            }
        }

        public interface IDynamicParams {
            String getDid();

            String getUserId();
        }

        public static class SdkBuilder {
            private Config a;

            private SdkBuilder(String str) {
                Config config = new Config();
                this.a = config;
                config.a = str;
            }

            public SdkBuilder acceptWithActivity(boolean z) {
                this.a.i = z;
                return this;
            }

            public SdkBuilder autoStart(boolean z) {
                this.a.u = z;
                return this;
            }

            public Config build() {
                return this.a;
            }

            public SdkBuilder channel(String str) {
                this.a.c = str;
                return this;
            }

            public SdkBuilder customData(AttachUserData attachUserData) {
                this.a.h = attachUserData;
                return this;
            }

            public SdkBuilder customPageView(boolean z) {
                this.a.r = z;
                return this;
            }

            public SdkBuilder debugMode(boolean z) {
                Npth.getConfigManager().setDebugMode(z);
                return this;
            }

            public SdkBuilder disablePageView() {
                this.a.s = false;
                return this;
            }

            public SdkBuilder disableSelfMonitor() {
                this.a.q = false;
                return this;
            }

            public SdkBuilder dynamicParams(IDynamicParams iDynamicParams) {
                this.a.p = iDynamicParams;
                return this;
            }

            public SdkBuilder enableAnrMonitor(boolean z) {
                Npth.getConfigManager().setAnrEnable(z);
                return this;
            }

            public SdkBuilder enableJavaCrash(boolean z) {
                Npth.getConfigManager().setJavaCrashEnable(z);
                return this;
            }

            public SdkBuilder enableNativeCrash(boolean z) {
                Npth.getConfigManager().setNativeCrashEnable(z);
                return this;
            }

            public SdkBuilder enableRegisterJavaCrash(boolean z) {
                Npth.getConfigManager().setRegisterJavaCrashEnable(z);
                return this;
            }

            public SdkBuilder keyWords(String... strArr) {
                this.a.f = strArr;
                return this;
            }

            public SdkBuilder pageViewTags(Map<String, String> map) {
                this.a.j = map;
                return this;
            }

            public SdkBuilder soList(String... strArr) {
                this.a.g = strArr;
                return this;
            }

            public SdkBuilder token(String str) {
                this.a.b = str;
                return this;
            }

            public SdkBuilder url(String str) {
                this.a.o = str;
                return disableSelfMonitor();
            }

            public SdkBuilder versionCode(long j) {
                this.a.d = j;
                return this;
            }

            public SdkBuilder versionName(String str) {
                this.a.e = str;
                return this;
            }
        }

        private Config() {
            this.d = -1L;
            this.i = false;
            this.j = null;
            this.q = true;
            this.r = false;
            this.s = true;
            this.t = false;
            this.u = true;
        }

        public static Builder app(String str) {
            return new Builder(str);
        }

        public static void disableConfigUrl() {
            v = true;
        }

        public static SdkBuilder sdk(String str) {
            return new SdkBuilder(str);
        }

        public String getDeviceId() {
            IDynamicParams iDynamicParams = this.p;
            String did = iDynamicParams == null ? "" : iDynamicParams.getDid();
            return TextUtils.isEmpty(did) ? this.k : did;
        }

        public String getSSID() {
            return this.m;
        }

        public String getUID() {
            IDynamicParams iDynamicParams = this.p;
            return iDynamicParams == null ? this.l : iDynamicParams.getUserId();
        }

        public Config setChannel(String str) {
            this.c = str;
            InitConfig initConfig = this.n;
            if (initConfig != null) {
                initConfig.setChannel(str);
            }
            com.apm.insight.m.b.d();
            return this;
        }

        @Deprecated
        public Config setDeviceId(String str) {
            return setDeviceId(str, true);
        }

        @Deprecated
        public Config setDeviceId(String str, boolean z) {
            this.k = str;
            InitConfig initConfig = this.n;
            if (initConfig != null) {
                initConfig.setDid(str);
            }
            if (z) {
                com.apm.insight.m.b.d();
            }
            return this;
        }

        public Config setPackageName(String str) {
            return setPackageName(str);
        }

        public Config setPackageName(String... strArr) {
            this.f = strArr;
            com.apm.insight.m.b.d();
            return this;
        }

        @Deprecated
        public Config setSSID(String str) {
            this.m = str;
            com.apm.insight.m.b.d();
            return this;
        }

        public Config setSoList(String[] strArr) {
            this.g = strArr;
            com.apm.insight.m.b.d();
            return this;
        }

        @Deprecated
        public Config setUID(String str) {
            this.l = str;
            com.apm.insight.m.b.d();
            return this;
        }
    }

    @Deprecated
    public interface HeaderParams {
        Map<String, Object> getCommonParams();
    }

    private MonitorCrash(Context context, Config config) {
        this.mTagMap = new ConcurrentHashMap();
        this.isAppLogInit = false;
        this.mStarted = new AtomicBoolean(false);
        this.mContext = context;
        this.mConfig = config;
        this.mCustomData = config.h;
    }

    private MonitorCrash(Config config, Context context, String str, long j, String str2) {
        this.mTagMap = new ConcurrentHashMap();
        this.isAppLogInit = false;
        this.mStarted = new AtomicBoolean(false);
        config = config == null ? new Config() : config;
        this.mConfig = config;
        config.a = str;
        this.mConfig.d = j;
        this.mConfig.e = str2;
        f.a(context, this);
        initAppLog(context, true);
    }

    private MonitorCrash(Config config, String str, long j, String str2, String... strArr) {
        this.mTagMap = new ConcurrentHashMap();
        this.isAppLogInit = false;
        this.mStarted = new AtomicBoolean(false);
        config = config == null ? new Config() : config;
        this.mConfig = config;
        config.a = str;
        this.mConfig.d = j;
        this.mConfig.e = str2;
        this.mConfig.f = strArr;
        f.a(this);
        initAppLog(g.f(), false);
    }

    private MonitorCrash(String str, long j, String str2, String... strArr) {
        this((Config) null, str, j, str2, strArr);
    }

    private static void checkInit(String str) {
        if (f.b == null || f.b.mConfig == null || TextUtils.equals(f.b.mConfig.a, str)) {
            return;
        }
        if (g.h().isDebugMode()) {
            throw new RuntimeException("Duplicate init App MonitorCrash with different aids.");
        }
        Log.e(TAG, "Duplicate init App MonitorCrash with different aids.");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004f A[Catch: all -> 0x0087, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:9:0x0016, B:15:0x0031, B:22:0x0045, B:24:0x004f, B:25:0x005c, B:27:0x0062, B:28:0x0065, B:30:0x0069, B:31:0x0070, B:33:0x0076, B:35:0x007c, B:34:0x007a, B:21:0x0042, B:14:0x002e, B:36:0x007e, B:18:0x0039, B:11:0x0026), top: B:44:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[Catch: all -> 0x0087, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:9:0x0016, B:15:0x0031, B:22:0x0045, B:24:0x004f, B:25:0x005c, B:27:0x0062, B:28:0x0065, B:30:0x0069, B:31:0x0070, B:33:0x0076, B:35:0x007c, B:34:0x007a, B:21:0x0042, B:14:0x002e, B:36:0x007e, B:18:0x0039, B:11:0x0026), top: B:44:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[Catch: all -> 0x0087, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:9:0x0016, B:15:0x0031, B:22:0x0045, B:24:0x004f, B:25:0x005c, B:27:0x0062, B:28:0x0065, B:30:0x0069, B:31:0x0070, B:33:0x0076, B:35:0x007c, B:34:0x007a, B:21:0x0042, B:14:0x002e, B:36:0x007e, B:18:0x0039, B:11:0x0026), top: B:44:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076 A[Catch: all -> 0x0087, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:9:0x0016, B:15:0x0031, B:22:0x0045, B:24:0x004f, B:25:0x005c, B:27:0x0062, B:28:0x0065, B:30:0x0069, B:31:0x0070, B:33:0x0076, B:35:0x007c, B:34:0x007a, B:21:0x0042, B:14:0x002e, B:36:0x007e, B:18:0x0039, B:11:0x0026), top: B:44:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a A[Catch: all -> 0x0087, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:9:0x0016, B:15:0x0031, B:22:0x0045, B:24:0x004f, B:25:0x005c, B:27:0x0062, B:28:0x0065, B:30:0x0069, B:31:0x0070, B:33:0x0076, B:35:0x007c, B:34:0x007a, B:21:0x0042, B:14:0x002e, B:36:0x007e, B:18:0x0039, B:11:0x0026), top: B:44:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.apm.insight.MonitorCrash init(android.content.Context r7, com.apm.insight.MonitorCrash.Config r8) {
        /*
            java.lang.Class<com.apm.insight.MonitorCrash> r0 = com.apm.insight.MonitorCrash.class
            monitor-enter(r0)
            boolean r1 = com.apm.insight.MonitorCrash.sAppMonitorCrashInit     // Catch: java.lang.Throwable -> L87
            if (r1 != 0) goto L7e
            java.lang.String r1 = r8.b     // Catch: java.lang.Throwable -> L87
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L16
            java.lang.String r1 = "MonitorCrash"
            java.lang.String r2 = "MonitorCrash init without token."
            android.util.Log.e(r1, r2)     // Catch: java.lang.Throwable -> L87
        L16:
            com.apm.insight.MonitorCrash r1 = new com.apm.insight.MonitorCrash     // Catch: java.lang.Throwable -> L87
            r1.<init>(r7, r8)     // Catch: java.lang.Throwable -> L87
            r2 = 1
            r1.mIsApp = r2     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = r8.e     // Catch: java.lang.Throwable -> L87
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L87
            if (r3 == 0) goto L31
            java.lang.String r3 = com.bytedance.apm.common.utility.PackageUtils.getVersionName(r7)     // Catch: java.lang.Throwable -> L2d
            r8.e = r3     // Catch: java.lang.Throwable -> L2d
            goto L31
        L2d:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L87
        L31:
            long r3 = r8.d     // Catch: java.lang.Throwable -> L87
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L45
            int r7 = com.bytedance.apm.common.utility.PackageUtils.getVersionCode(r7)     // Catch: java.lang.Throwable -> L41
            long r3 = (long) r7     // Catch: java.lang.Throwable -> L41
            r8.d = r3     // Catch: java.lang.Throwable -> L41
            goto L45
        L41:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L87
        L45:
            java.lang.String r7 = com.apm.insight.MonitorCrash.Config.c(r8)     // Catch: java.lang.Throwable -> L87
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L87
            if (r7 != 0) goto L5c
            java.lang.String r7 = com.apm.insight.MonitorCrash.Config.c(r8)     // Catch: java.lang.Throwable -> L87
            com.apm.insight.MonitorCrash.sDefaultApplogUrl = r7     // Catch: java.lang.Throwable -> L87
            java.lang.String r7 = com.apm.insight.MonitorCrash.Config.c(r8)     // Catch: java.lang.Throwable -> L87
            r1.setReportUrl(r7)     // Catch: java.lang.Throwable -> L87
        L5c:
            boolean r7 = com.apm.insight.MonitorCrash.Config.d(r8)     // Catch: java.lang.Throwable -> L87
            if (r7 != 0) goto L65
            com.apm.insight.runtime.n.b()     // Catch: java.lang.Throwable -> L87
        L65:
            java.util.Map<java.lang.String, java.lang.String> r7 = r8.j     // Catch: java.lang.Throwable -> L87
            if (r7 == 0) goto L70
            java.util.Map<java.lang.String, java.lang.String> r7 = r1.mTagMap     // Catch: java.lang.Throwable -> L87
            java.util.Map<java.lang.String, java.lang.String> r3 = r8.j     // Catch: java.lang.Throwable -> L87
            r7.putAll(r3)     // Catch: java.lang.Throwable -> L87
        L70:
            boolean r7 = com.apm.insight.MonitorCrash.Config.e(r8)     // Catch: java.lang.Throwable -> L87
            if (r7 == 0) goto L7a
            r1.start()     // Catch: java.lang.Throwable -> L87
            goto L7c
        L7a:
            com.apm.insight.f.b = r1     // Catch: java.lang.Throwable -> L87
        L7c:
            com.apm.insight.MonitorCrash.sAppMonitorCrashInit = r2     // Catch: java.lang.Throwable -> L87
        L7e:
            java.lang.String r7 = r8.a     // Catch: java.lang.Throwable -> L87
            checkInit(r7)     // Catch: java.lang.Throwable -> L87
            com.apm.insight.MonitorCrash r7 = com.apm.insight.f.b     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)
            return r7
        L87:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.MonitorCrash.init(android.content.Context, com.apm.insight.MonitorCrash$Config):com.apm.insight.MonitorCrash");
    }

    @Deprecated
    public static MonitorCrash init(Context context, String str, long j, String str2) {
        if (!sAppMonitorCrashInit) {
            synchronized (MonitorCrash.class) {
                if (!sAppMonitorCrashInit) {
                    p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
                    MonitorCrash monitorCrash = new MonitorCrash((Config) null, context, str, j, str2);
                    sAppMonitorCrashInit = true;
                    return monitorCrash;
                }
            }
        }
        checkInit(str);
        return f.b;
    }

    private void initAppLog(Context context, boolean z) {
        synchronized (this) {
            if (this.mApmApplogConfig == null) {
                this.mApmApplogConfig = new InitConfig(this.mConfig.a, this.mConfig.b, "empty");
                this.mConfig.n = this.mApmApplogConfig;
            }
        }
        initAppLogAsync(context, z);
    }

    private void initAppLogAsync(final Context context, final boolean z) {
        q.b().a(new Runnable() { // from class: com.apm.insight.MonitorCrash.1
            @Override // java.lang.Runnable
            public void run() {
                if (MonitorCrash.this.isAppLogInit) {
                    return;
                }
                if (!o.b()) {
                    o.c();
                }
                if (com.apm.insight.runtime.e.j(MonitorCrash.this.mConfig.a)) {
                    MonitorCrash.this.isAppLogInit = true;
                    if (MonitorCrash.sDefaultApplogUrl != null) {
                        MonitorCrash.this.mApmApplogConfig.setUriConfig(new UriConfig.Builder().setRegisterUri(MonitorCrash.sDefaultApplogUrl + UriConfig.PATH_REGISTER).setSendUris(new String[]{MonitorCrash.sDefaultApplogUrl + UriConfig.PATH_SEND}).build());
                    }
                    if (z) {
                        MonitorCrash.this.mApmApplogConfig.setUpdateVersionCode((int) MonitorCrash.this.mConfig.d);
                        MonitorCrash.this.mApmApplogConfig.setVersionCode((int) MonitorCrash.this.mConfig.d);
                        MonitorCrash.this.mApmApplogConfig.setVersionMinor(MonitorCrash.this.mConfig.e);
                        MonitorCrash.this.mApmApplogConfig.setManifestVersion(MonitorCrash.this.mConfig.e);
                        MonitorCrash.this.mApmApplogConfig.setVersion(MonitorCrash.this.mConfig.e);
                    } else {
                        String strB = com.apm.insight.entity.b.b(f.a());
                        HashMap map = new HashMap();
                        map.put("host_app_id", strB);
                        map.put("sdk_version", MonitorCrash.this.mConfig.e);
                        MonitorCrash.this.mApmApplogConfig.putCommonHeader(map);
                    }
                    if (!TextUtils.isEmpty(MonitorCrash.this.mConfig.getDeviceId())) {
                        MonitorCrash.this.mApmApplogConfig.setDid(MonitorCrash.this.mConfig.getDeviceId());
                    }
                    if (!TextUtils.isEmpty(MonitorCrash.this.mConfig.c)) {
                        MonitorCrash.this.mApmApplogConfig.setChannel(MonitorCrash.this.mConfig.c);
                    }
                    MonitorCrash.this.mApmApplogConfig.setCustomLaunch(MonitorCrash.this.mConfig.r);
                    MonitorCrash.this.mApmApplogConfig.setFixPageView(MonitorCrash.this.mConfig.t);
                    if (MonitorCrash.this.mConfig.j == null) {
                        AppLog.init(context, MonitorCrash.this.mApmApplogConfig);
                    } else {
                        AppLog.init(context, MonitorCrash.this.mApmApplogConfig, MonitorCrash.this.mConfig.j);
                    }
                }
            }
        }, 5L);
    }

    public static synchronized MonitorCrash initSDK(Context context, Config config) {
        if (TextUtils.isEmpty(config.b)) {
            Log.e(TAG, config.a + " MonitorCrash init without token.");
        }
        MonitorCrash monitorCrashA = f.a(config.a);
        if (monitorCrashA != null) {
            Log.e(TAG, "Duplicate init MonitorCrash with same aid.");
            return monitorCrashA;
        }
        MonitorCrash monitorCrash = new MonitorCrash(context, config);
        monitorCrash.mIsApp = false;
        if (sDefaultApplogUrl == null && !TextUtils.isEmpty(config.o)) {
            sDefaultApplogUrl = config.o;
            monitorCrash.setReportUrl(config.o);
        }
        if (!config.q) {
            n.b();
        }
        if (config.j != null) {
            monitorCrash.mTagMap.putAll(config.j);
        }
        if (config.u) {
            monitorCrash.start();
        }
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String str3) {
        p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        MonitorCrash monitorCrash = new MonitorCrash(str, j, str2, str3);
        monitorCrash.config().setPackageName(str3);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String str3, String[] strArr) {
        p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        MonitorCrash monitorCrash = new MonitorCrash(str, j, str2, str3);
        monitorCrash.config().setPackageName(str3).setSoList(strArr);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String... strArr) {
        p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        MonitorCrash monitorCrash = new MonitorCrash(str, j, str2, strArr);
        monitorCrash.config().setPackageName(strArr);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String[] strArr, String[] strArr2) {
        p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        MonitorCrash monitorCrash = new MonitorCrash(str, j, str2, strArr);
        monitorCrash.config().setPackageName(strArr).setSoList(strArr2);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDKWithConfig(Context context, Config config, String str, long j, String str2, String str3, String[] strArr) {
        p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        MonitorCrash monitorCrash = new MonitorCrash(config, str, j, str2, str3);
        monitorCrash.config().setPackageName(str3).setSoList(strArr);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDKWithConfig(Context context, Config config, String str, long j, String str2, String... strArr) {
        p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        MonitorCrash monitorCrash = new MonitorCrash(config, str, j, str2, strArr);
        monitorCrash.config().setPackageName(strArr);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDKWithConfig(Context context, Config config, String str, long j, String str2, String[] strArr, String[] strArr2) {
        p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        MonitorCrash monitorCrash = new MonitorCrash(config, str, j, str2, strArr);
        monitorCrash.config().setPackageName(strArr).setSoList(strArr2);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initWithConfig(Context context, Config config, String str, long j, String str2) {
        if (!sAppMonitorCrashInit) {
            synchronized (MonitorCrash.class) {
                if (!sAppMonitorCrashInit) {
                    p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
                    MonitorCrash monitorCrash = new MonitorCrash(config, context, str, j, str2);
                    sAppMonitorCrashInit = true;
                    return monitorCrash;
                }
            }
        }
        checkInit(str);
        return f.b;
    }

    public static void reInitAppLog(String str) {
        MonitorCrash monitorCrashA;
        try {
            if (!TextUtils.isEmpty(str) && AppLog.getInstance(str) == null) {
                boolean z = false;
                if (f.b == null || !TextUtils.equals(str, f.b.mConfig.a)) {
                    monitorCrashA = f.a(str);
                } else {
                    monitorCrashA = f.b;
                    z = true;
                }
                if (monitorCrashA != null && !monitorCrashA.isAppLogInit) {
                    Application applicationG = g.g();
                    if (monitorCrashA.mApmApplogConfig == null) {
                        monitorCrashA.initAppLog(applicationG, z);
                    } else {
                        monitorCrashA.initAppLogAsync(applicationG, z);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public static void setDefaultReportUrlPrefix(String str) {
        if (Config.v) {
            return;
        }
        g.h().setLaunchCrashUrl(str + ConfigManager.EXCEPTION_URL_SUFFIX);
        g.h().setLaunchCrashUrl2(str + ConfigManager.LAUNCH_URL_SUFFIX);
        g.h().setJavaCrashUploadUrl(str + ConfigManager.JAVA_URL_SUFFIX);
        g.h().setNativeCrashUrl(str + ConfigManager.NATIVE_URL_SUFFIX);
        g.h().setConfigUrl(str + ConfigManager.CONFIG_URL_SUFFIX);
        g.h().setAlogUploadUrl(str + ConfigManager.ALOG_URL_SUFFIX);
        g.h().setFileUploadUrl(str + ConfigManager.FILE_UPLOAD_URL_SUFFIX);
        g.h().setCrashPortraitUrl(str + ConfigManager.PORTRAIT_UPLOAD_URL_SUFFIX);
        sDefaultApplogUrl = str;
    }

    public MonitorCrash addTags(String str, String str2) {
        this.mTagMap.put(str, str2);
        return this;
    }

    public Config config() {
        return this.mConfig;
    }

    public Map<String, String> getPvTags() {
        Config config = this.mConfig;
        if (config == null) {
            return null;
        }
        return config.j;
    }

    public Map<String, String> getTags() {
        return this.mTagMap;
    }

    public void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        p.a(iCrashCallback, crashType);
    }

    public void registerOOMCallback(IOOMCallback iOOMCallback) {
        p.a(iOOMCallback);
    }

    public void reportCustomErr(String str, String str2, Throwable th) {
        reportCustomErr(str, str2, th, null);
    }

    public void reportCustomErr(String str, String str2, Throwable th, Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "EnsureNotReachHere";
        }
        com.apm.insight.f.b.a(this, th, str, true, map, str2, "core_exception_monitor");
    }

    public void reportCustomErr(StackTraceElement[] stackTraceElementArr, int i, String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "EnsureNotReachHere";
        }
        com.apm.insight.f.b.a(stackTraceElementArr, i, str, str2, map);
    }

    @Deprecated
    public MonitorCrash setCustomDataCallback(AttachUserData attachUserData) {
        this.mCustomData = attachUserData;
        return this;
    }

    @Deprecated
    public MonitorCrash setReportUrl(String str) {
        if (Config.v || TextUtils.isEmpty(str)) {
            return this;
        }
        if (str.indexOf("://") < 0) {
            str = "https://" + str;
        }
        com.apm.insight.o.q.a((Object) ("set url " + str));
        g.h().setLaunchCrashUrl(str + ConfigManager.EXCEPTION_URL_SUFFIX);
        g.h().setLaunchCrashUrl2(str + ConfigManager.LAUNCH_URL_SUFFIX);
        g.h().setJavaCrashUploadUrl(str + ConfigManager.JAVA_URL_SUFFIX);
        g.h().setNativeCrashUrl(str + ConfigManager.NATIVE_URL_SUFFIX);
        g.h().setConfigUrl(str + ConfigManager.CONFIG_URL_SUFFIX);
        g.h().setAlogUploadUrl(str + ConfigManager.ALOG_URL_SUFFIX);
        g.h().setFileUploadUrl(str + ConfigManager.FILE_UPLOAD_URL_SUFFIX);
        g.h().setFileUploadUrl(str + ConfigManager.PORTRAIT_UPLOAD_URL_SUFFIX);
        sDefaultApplogUrl = str;
        return this;
    }

    public void start() {
        Context context;
        if (!this.mStarted.compareAndSet(false, true) || this.mConfig == null || (context = this.mContext) == null) {
            return;
        }
        p.a(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        if (this.mConfig.s) {
            initAppLog(this.mContext, this.mIsApp);
        }
        if (this.mIsApp) {
            f.a(this.mContext, this);
        } else {
            f.a(this);
        }
    }

    public void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        p.b(iCrashCallback, crashType);
    }

    public void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        p.a(iOOMCallback, crashType);
    }

    @Deprecated
    public MonitorCrash withOtherHeaders(HeaderParams headerParams) {
        this.mParams = headerParams;
        return this;
    }
}
