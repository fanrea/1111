package com.bytedance.bdtracker;

import android.accounts.Account;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.applog.IActiveCustomParamsCallback;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.IEventObserver;
import com.bytedance.applog.IExtraParams;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.applog.IPresetEventObserver;
import com.bytedance.applog.IPullAbTestConfigCallback;
import com.bytedance.applog.ISessionObserver;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.Level;
import com.bytedance.applog.R;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.alink.IALinkListener;
import com.bytedance.applog.event.EventBuilder;
import com.bytedance.applog.event.IEventHandler;
import com.bytedance.applog.exception.AppCrashType;
import com.bytedance.applog.exposure.ViewExposureManager;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.ILogProcessor;
import com.bytedance.applog.log.LogProcessorHolder;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.applog.oneid.IDBindCallback;
import com.bytedance.applog.profile.UserProfileCallback;
import com.bytedance.applog.simulate.SimulateLaunchActivity;
import com.bytedance.bdtracker.l0;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d implements IAppLogInstance {
    public static final List<d> J = new CopyOnWriteArrayList();

    /* renamed from: K, reason: collision with root package name */
    public static final AtomicInteger f752K = new AtomicInteger(0);
    public IActiveCustomParamsCallback A;
    public volatile s B;
    public IEventHandler C;
    public final IAppLogLogger D;
    public final q3 j;
    public final o3 k;
    public volatile q1 o;
    public volatile s1 p;
    public volatile e0 q;
    public volatile w r;
    public volatile ViewExposureManager s;
    public volatile INetworkClient t;
    public volatile IHeaderCustomTimelyCallback v;
    public volatile b1 w;
    public e1 y;
    public IALinkListener z;
    public final ConcurrentHashMap<String, JSONObject> a = new ConcurrentHashMap<>();
    public final g1 b = new g1();
    public final f1 c = new f1();
    public final v1 d = new v1();
    public final k1 e = new k1();
    public final Set<Integer> f = new HashSet();
    public final Set<String> g = new HashSet();
    public final Set<Class<?>> h = new HashSet();
    public final Map<String, k0> i = new ConcurrentHashMap();
    public int l = 0;
    public String m = "";
    public volatile Application n = null;
    public volatile boolean u = false;
    public volatile boolean x = false;
    public volatile boolean E = true;
    public long F = 0;
    public volatile boolean G = false;
    public final r4<String> H = new r4<>();
    public final r4<String> I = new r4<>();

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", d.this.m);
                jSONObject2.put("接口加密开关", this.a);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class b implements EventBus.DataFetcher {
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            this.a = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", d.this.m);
                jSONObject2.put("禁止采集详细信息开关", this.a);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class c implements EventBus.DataFetcher {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", d.this.m);
                jSONObject2.put("剪切板开关", this.a);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.bdtracker.d$d, reason: collision with other inner class name */
    public class C0185d implements EventBus.DataFetcher {
        public final /* synthetic */ boolean a;

        public C0185d(boolean z) {
            this.a = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", d.this.m);
                jSONObject2.put("隐私模式开关", this.a);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public d() {
        f752K.incrementAndGet();
        this.D = new LoggerImpl();
        this.j = new q3(this);
        this.k = new o3(this);
        J.add(this);
    }

    public v1 a() {
        return this.d;
    }

    public final void a(Object obj, JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean z2;
        if (this.r == null || obj == null) {
            return;
        }
        a4 a4Var = new a4("bav2b_page", true);
        JSONObject jSONObject2 = new JSONObject();
        String name = obj.getClass().getName();
        Iterator<Class<?>> it = u4.d.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                z2 = false;
                break;
            } else if (it.next().isInstance(obj)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            Activity activity = null;
            try {
                activity = (Activity) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
            } catch (Throwable unused) {
            }
            if (activity != null) {
                name = activity.getClass().getName() + ":" + name;
            }
            z = true;
        }
        try {
            jSONObject2.put("page_key", name);
            jSONObject2.put("is_fragment", z);
            jSONObject2.put("duration", 1000L);
            jSONObject2.put(ArticleInfo.PAGE_TITLE, u4.c(obj));
            jSONObject2.put("page_path", u4.b(obj));
            jSONObject2.put("is_custom", true);
            l0.b.b(jSONObject, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a4Var.o = jSONObject2;
        receive(a4Var);
    }

    public final boolean a(String str) {
        return l0.b.a((Object) this.p, "Call " + str + " before please initialize first");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void activateALink(Uri uri) {
        JSONObject jSONObject;
        if (b("activateALink")) {
            return;
        }
        j jVar = this.q.B;
        jVar.c();
        if (uri != null) {
            jVar.h = uri.toString();
        }
        jVar.b().debug(3, "Activate deep link with url: {}...", jVar.h);
        Handler handlerA = jVar.a();
        try {
            jSONObject = new JSONObject();
            if (uri != null) {
                String scheme = uri.getScheme();
                if (Intrinsics.areEqual(scheme, com.alipay.sdk.m.l.a.r) || Intrinsics.areEqual(scheme, "https")) {
                    jSONObject.put("tr_token", uri.getLastPathSegment());
                }
                for (String str : uri.getQueryParameterNames()) {
                    jSONObject.put(str, uri.getQueryParameter(str));
                }
            }
        } catch (Throwable unused) {
            jSONObject = null;
        }
        l lVar = (l) p.a.a(jSONObject, l.class);
        String strD = lVar != null ? lVar.d() : null;
        if (strD == null || strD.length() == 0) {
            return;
        }
        jVar.e = 0;
        handlerA.sendMessage(handlerA.obtainMessage(1, lVar));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public synchronized void addDataObserver(IDataObserver iDataObserver) {
        if (this.y == null) {
            this.y = new e1();
        }
        this.y.a(iDataObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addEventObserver(IEventObserver iEventObserver) {
        this.c.a(l0.b.a(iEventObserver, (IPresetEventObserver) null));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        this.c.a(l0.b.a(iEventObserver, iPresetEventObserver));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return this.j.a(this.p != null ? this.p.e() : null, str, z, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addSessionHook(ISessionObserver iSessionObserver) {
        this.b.a(iSessionObserver);
    }

    public boolean b() {
        return this.G;
    }

    public final boolean b(String str) {
        return l0.b.a((Object) this.q, "Call " + str + " before please initialize first");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void bind(Map<String, String> map, IDBindCallback iDBindCallback) {
        if (b("bind")) {
            return;
        }
        e0 e0Var = this.q;
        if (map == null) {
            e0Var.d.D.warn("BindID identities is null", new Object[0]);
        } else {
            e0Var.F.a(map, iDBindCallback);
        }
    }

    public final void c() {
        r4<String> r4Var = this.H;
        if (r4Var.b && !l0.b.b(r4Var, this.o.f())) {
            this.p.h(this.H.a);
            this.p.g("");
        }
        r4<String> r4Var2 = this.I;
        if (!r4Var2.b || l0.b.b(r4Var2, this.o.d.getString("user_unique_id_type", null))) {
            return;
        }
        this.p.i(this.I.a);
        this.p.g("");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void clearAbTestConfigsCache() {
        if (this.p == null) {
            new m0().initCause(new AssertionError("Please initialize first")).printStackTrace();
        } else {
            s1 s1Var = this.p;
            s1Var.e(null);
            s1Var.f("");
            s1Var.a((JSONObject) null);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void clearDb() {
        if (this.q == null) {
            new m0().initCause(new AssertionError("clearDb before init")).printStackTrace();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.D.debug("Start to clear db data...", new Object[0]);
        this.q.c().a();
        this.D.debug("Db data cleared", new Object[0]);
        l2.a(getMonitor(), "api_usage", "clearDb", jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void flush() {
        if (b("flush")) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.q.a((String[]) null, true);
        l2.a(getMonitor(), "api_usage", "flush", jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IALinkListener getALinkListener() {
        return this.z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.IAppLogInstance
    public <T> T getAbConfig(String str, T t) {
        if (a("getAbConfig")) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        s1 s1Var = this.p;
        JSONObject jSONObjectOptJSONObject = s1Var.c.a().optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString(PointParamKey.VID);
            Object objOpt = jSONObjectOptJSONObject.opt("val");
            s1Var.a(strOptString);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ab_sdk_version", strOptString);
                s1Var.i.onEventV3("abtest_exposure", jSONObject, 0);
            } catch (Throwable th) {
                s1Var.i.D.error(Collections.singletonList("DeviceManager"), "JSON handle failed", th, new Object[0]);
            }
            T t2 = objOpt != 0 ? objOpt : null;
            if (t2 != null) {
                t = t2;
            }
        }
        l2.a(getMonitor(), "api_usage", "getAbConfig", jElapsedRealtime);
        return t;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAbSdkVersion() {
        return a("getAbSdkVersion") ? "" : this.p.a();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IActiveCustomParamsCallback getActiveCustomParams() {
        return this.A;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public String getAid() {
        return this.m;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getAllAbTestConfigs() {
        return this.q == null ? new JSONObject() : this.q.e.a();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public f getAppContext() {
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAppId() {
        return this.m;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getClientUdid() {
        return a("getClientUdid") ? "" : this.p.d.optString("clientudid", "");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public Context getContext() {
        return this.n;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getDeepLinkUrl() {
        if (this.q != null) {
            return this.q.B.h;
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getDid() {
        if (a("getDid")) {
            return "";
        }
        String strC = this.p.c();
        return !TextUtils.isEmpty(strC) ? strC : this.p.d.optString(com.baidu.mobads.upgrade.remote.gray.c.l, "");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean getEncryptAndCompress() {
        return this.E;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public b1 getEventFilterByClient() {
        return this.w;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IEventHandler getEventHandler() {
        return this.C;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getHeader() {
        if (a("getHeader")) {
            return null;
        }
        return this.p.e();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return this.v;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public <T> T getHeaderValue(String str, T t, Class<T> cls) {
        if (a("getHeaderValue")) {
            return null;
        }
        return (T) this.p.a(str, (String) t, (Class<String>) cls);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getIid() {
        return a("getIid") ? "" : this.p.f();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public InitConfig getInitConfig() {
        if (this.o != null) {
            return this.o.c;
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public int getLaunchFrom() {
        return this.l;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public i2 getMonitor() {
        if (b("getMonitor")) {
            return null;
        }
        return this.q.q;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public INetworkClient getNetClient() {
        if (this.t != null) {
            return this.t;
        }
        if (getInitConfig() != null && getInitConfig().getNetworkClient() != null) {
            return getInitConfig().getNetworkClient();
        }
        synchronized (this) {
            if (this.t == null) {
                this.t = new d3(this.k);
            }
        }
        return this.t;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getOpenUdid() {
        return a("getOpenUdid") ? "" : this.p.g();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public Map<String, String> getRequestHeader() {
        if (this.o == null) {
            return Collections.emptyMap();
        }
        String string = this.o.f.getString("device_token", "");
        HashMap map = new HashMap();
        map.put("x-tt-dt", string != null ? string : "");
        return map;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSdkVersion() {
        return "6.15.5";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSessionId() {
        return this.q != null ? this.q.d() : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSsid() {
        return a("getSsid") ? "" : this.p.i();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void getSsidGroup(Map<String, String> map) {
        String did = getDid();
        if (!TextUtils.isEmpty(did)) {
            map.put(com.baidu.mobads.upgrade.remote.gray.c.l, did);
        }
        String iid = getIid();
        if (!TextUtils.isEmpty(iid)) {
            map.put("install_id", iid);
        }
        String openUdid = getOpenUdid();
        if (!TextUtils.isEmpty(openUdid)) {
            map.put("openudid", openUdid);
        }
        String clientUdid = getClientUdid();
        if (TextUtils.isEmpty(clientUdid)) {
            return;
        }
        map.put("clientudid", clientUdid);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUdid() {
        return a("getUdid") ? "" : this.p.j();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public UriConfig getUriRuntime() {
        if (b("getUriRuntime")) {
            return null;
        }
        return this.q.e();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUserID() {
        if (b("getUserID")) {
            return null;
        }
        return String.valueOf(this.q.n.a);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUserUniqueID() {
        return a("getUserUniqueID") ? "" : this.p.k();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public ViewExposureManager getViewExposureManager() {
        return this.s;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getViewProperties(View view) {
        if (view != null) {
            return this.a.get(l0.b.b(view));
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean hasStarted() {
        return this.u;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void ignoreAutoTrackClick(View view) {
        if (view == null) {
            return;
        }
        this.g.add(l0.b.b(view));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void ignoreAutoTrackClickByViewType(Class<?>... clsArr) {
        if (clsArr == null) {
            return;
        }
        this.h.addAll(Arrays.asList(clsArr));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void ignoreAutoTrackPage(Class<?>... clsArr) {
        boolean z;
        if (clsArr == null) {
            return;
        }
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                Iterator<Class<?>> it = u4.c.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().isAssignableFrom(cls)) {
                            break;
                        }
                    } else {
                        Iterator<Class<?>> it2 = u4.d.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().isAssignableFrom(cls)) {
                            }
                        }
                        z = false;
                    }
                }
                z = true;
                if (z) {
                    String canonicalName = cls.getCanonicalName();
                    if (!TextUtils.isEmpty(canonicalName)) {
                        this.f.add(Integer.valueOf(canonicalName.hashCode()));
                    }
                } else {
                    this.D.warn("{} is not a page class", cls);
                }
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig) {
        String str;
        ILogProcessor h1Var;
        synchronized (d.class) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (l0.b.c(initConfig.getAid())) {
                Log.e("AppLog", "Init failed. App id must not be empty!");
                return;
            }
            if (l0.b.c(initConfig.getChannel())) {
                Log.e("AppLog", "Channel must not be empty!");
                return;
            }
            if (com.bytedance.bdtracker.b.b(initConfig.getAid())) {
                Log.e("AppLog", "The app id: " + initConfig.getAid() + " has initialized already");
                return;
            }
            this.D.setAppId(initConfig.getAid());
            this.m = initConfig.getAid();
            this.n = (Application) context.getApplicationContext();
            if (initConfig.isLogEnable()) {
                if (initConfig.getLogger() != null) {
                    str = this.m;
                    h1Var = new i1(initConfig.getLogger());
                } else {
                    str = this.m;
                    h1Var = new h1(this);
                }
                LogProcessorHolder.setProcessor(str, h1Var);
            }
            this.D.info("AppLog init begin...", new Object[0]);
            if (!initConfig.isMonitorEnabled() && !k2.a(initConfig) && initConfig.getUriConfig() == null) {
                initConfig.setMonitorEnabled(true);
            }
            initMetaSec(context);
            if (TextUtils.isEmpty(initConfig.getSpName())) {
                initConfig.setSpName(com.bytedance.bdtracker.b.a(this, "applog_stats"));
            }
            this.o = new q1(this, this.n, initConfig);
            this.p = new s1(this, this.n, this.o);
            c();
            this.q = new e0(this, this.o, this.p, this.e);
            LogUtils.sendJsonFetcher("init_begin", new e(this, initConfig));
            this.r = w.a(this.n);
            this.s = new ViewExposureManager(this);
            if (AppCrashType.hasJavaCrashType(initConfig.getTrackCrashType()) || initConfig.isMonitorEnabled()) {
                n0.a();
            }
            this.l = 1;
            this.u = initConfig.autoStart();
            LogUtils.sendString("init_end", this.m);
            this.D.info("AppLog init end", new Object[0]);
            if (l0.b.a(SimulateLaunchActivity.entryAppId, this.m)) {
                r3.a(this);
            }
            this.o.k();
            i2 monitor = getMonitor();
            Intrinsics.checkParameterIsNotNull("sdk_init", "metricsName");
            l2.a(monitor, "sdk_init", (String) null, jElapsedRealtime);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig, Activity activity) {
        init(context, initConfig);
        if (this.r == null || activity == null) {
            return;
        }
        this.r.onActivityCreated(activity, null);
        this.r.onActivityResumed(activity);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void initH5Bridge(View view, String str) {
        Class<?> clsB = l0.b.b("com.bytedance.applog.tracker.WebViewUtil");
        if (clsB == null) {
            this.D.warn("No WebViewUtil class, and will not initialize h5 bridge", new Object[0]);
            return;
        }
        try {
            Method declaredMethod = clsB.getDeclaredMethod("injectWebViewBridges", View.class, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, view, str);
        } catch (Throwable th) {
            this.D.error("Initialize h5 bridge failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void initMetaSec(Context context) {
        if (getInitConfig() == null || getInitConfig().isMetaSecEnabled()) {
            Class<?> clsB = l0.b.b("com.bytedance.applog.metasec.AppLogSecHelper");
            if (clsB == null) {
                this.D.debug("No AppLogSecHelper class, and will not init", new Object[0]);
                return;
            }
            try {
                Method declaredMethod = clsB.getDeclaredMethod(PointCategory.INIT, IAppLogInstance.class, Context.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, this, context);
            } catch (Throwable th) {
                this.D.error("Initialize AppLogSecHelper failed", th, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void initWebViewBridge(View view, String str) {
        Class<?> clsB = l0.b.b("com.bytedance.applog.tracker.WebViewUtil");
        if (clsB != null) {
            try {
                clsB.getMethod("injectWebViewBridges", View.class, String.class).invoke(null, view, str);
            } catch (Throwable th) {
                this.D.error("Init webview bridge failed", th, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isAutoTrackClickIgnored(View view) {
        if (view == null) {
            return false;
        }
        if (this.g.contains(l0.b.b(view))) {
            return true;
        }
        Iterator<Class<?>> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isAutoTrackPageIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        String canonicalName = cls.getCanonicalName();
        if (TextUtils.isEmpty(canonicalName)) {
            return false;
        }
        return this.f.contains(Integer.valueOf(canonicalName.hashCode()));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isBavEnabled() {
        return this.q != null && this.q.g();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isH5BridgeEnable() {
        return getInitConfig() != null && getInitConfig().isH5BridgeEnable();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isH5CollectEnable() {
        return getInitConfig() != null && getInitConfig().isH5CollectEnable();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isNewUser() {
        if (a("isNewUser")) {
            return false;
        }
        return this.p.e;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isPrivacyMode() {
        return this.x;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean manualActivate() {
        if (b("manualActivate")) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zA = this.q.a(false);
        l2.a(getMonitor(), "api_usage", "manualActivate", jElapsedRealtime);
        return zA;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public EventBuilder newEvent(String str) {
        return new EventBuilder(this).setEvent(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityPause() {
        if (this.r != null) {
            this.r.onActivityPaused(null);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityResumed(Activity activity, int i) {
        if (this.r != null) {
            this.r.a(activity, i);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str) {
        onEventV3(str, (JSONObject) null, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle) {
        onEventV3(str, bundle, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject) {
        onEventV3(str, jSONObject, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onMiscEvent(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            this.D.warn("call onMiscEvent with invalid params", new Object[0]);
            return;
        }
        this.D.debug(Arrays.asList("customEvent", "miscEvent"), "logType:{} params:{} ", str, jSONObject.toString());
        try {
            jSONObject.put("log_type", str);
            receive(new w3("log_data", jSONObject));
        } catch (Throwable th) {
            this.D.error("call onMiscEvent error", th, new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onPause(Context context) {
        if (context instanceof Activity) {
            onActivityPause();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onResume(Context context) {
        if (context instanceof Activity) {
            onActivityResumed((Activity) context, context.hashCode());
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void pauseDurationEvent(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (l0.b.a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        k0 k0Var = this.i.get(str);
        if (l0.b.a((Object) k0Var, "No duration event with name: " + str)) {
            return;
        }
        k0Var.a(jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileAppend(JSONObject jSONObject) {
        if (b("profileAppend") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            if (!l0.b.a(jSONObject, (Class<?>[]) new Class[]{String.class, Integer.class}, (Class<?>[]) new Class[]{String.class})) {
                this.D.warn("only support String、Int、String Array！", new Object[0]);
                return;
            }
        } catch (Throwable th) {
            this.D.error("JSON handle failed", th, new Object[0]);
        }
        c5.a(this.D, jSONObject);
        this.q.b(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileIncrement(JSONObject jSONObject) {
        if (b("profileIncrement") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            if (!l0.b.a(jSONObject, (Class<?>[]) new Class[]{Integer.class}, (Class<?>[]) null)) {
                this.D.warn("only support Int param", new Object[0]);
                return;
            }
        } catch (Throwable th) {
            this.D.error("JSON handle failed", th, new Object[0]);
        }
        c5.a(this.D, jSONObject);
        this.q.c(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileSet(JSONObject jSONObject) {
        if (b("profileSet") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        c5.a(this.D, jSONObject);
        this.q.d(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileSetOnce(JSONObject jSONObject) {
        if (b("profileSetOnce") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        c5.a(this.D, jSONObject);
        this.q.e(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileUnset(String str) {
        if (b("profileUnset")) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, "");
        } catch (Throwable th) {
            this.D.error("JSON handle failed", th, new Object[0]);
        }
        c5.a(this.D, jSONObject);
        this.q.f(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void pullAbTestConfigs() {
        pullAbTestConfigs(-1, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void pullAbTestConfigs(int i, IPullAbTestConfigCallback iPullAbTestConfigCallback) {
        if (this.q == null) {
            new m0().initCause(new AssertionError("Please initialize first")).printStackTrace();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAbs = this.q.a - Math.abs(jCurrentTimeMillis - this.F);
        if (jAbs < 0) {
            this.F = jCurrentTimeMillis;
            Handler handler = this.q.p;
            handler.sendMessage(handler.obtainMessage(18, i, -1, iPullAbTestConfigCallback));
        } else if (iPullAbTestConfigCallback != null) {
            iPullAbTestConfigCallback.onThrottle(jAbs);
        } else {
            this.D.warn("Pull ABTest config too frequently", new Object[0]);
        }
        l2.a(getMonitor(), "api_usage", "pullAbTestConfigs", jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        this.j.a(this.p != null ? this.p.e() : null, z, map, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void receive(t3 t3Var) {
        if (t3Var == null) {
            return;
        }
        t3Var.m = this.m;
        if (this.q == null) {
            this.e.a(t3Var);
        } else {
            this.q.a(t3Var);
        }
        LogUtils.sendObject("event_receive", t3Var);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        this.v = iHeaderCustomTimelyCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeAllDataObserver() {
        e1 e1Var = this.y;
        if (e1Var != null) {
            e1Var.a.clear();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeDataObserver(IDataObserver iDataObserver) {
        e1 e1Var = this.y;
        if (e1Var != null) {
            e1Var.b(iDataObserver);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeEventObserver(IEventObserver iEventObserver) {
        this.c.b(l0.b.a(iEventObserver, (IPresetEventObserver) null));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        this.c.b(l0.b.a(iEventObserver, iPresetEventObserver));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeHeaderInfo(String str) {
        if (a("removeHeaderInfo")) {
            return;
        }
        this.p.d(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeOaidObserver(IOaidObserver iOaidObserver) {
        h5.b(iOaidObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeSessionHook(ISessionObserver iSessionObserver) {
        this.b.b(iSessionObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean reportPhoneDetailInfo() {
        return this.p != null && this.p.r();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void resumeDurationEvent(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (l0.b.a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        k0 k0Var = this.i.get(str);
        if (l0.b.a((Object) k0Var, "No duration event with name: " + str)) {
            return;
        }
        k0Var.b(jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setALinkListener(IALinkListener iALinkListener) {
        this.z = iALinkListener;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAccount(Account account) {
        if (a("setAccount")) {
            return;
        }
        v1 v1VarA = this.p.i.a();
        if (!(v1VarA.a instanceof m4)) {
            v1VarA.b = account;
            return;
        }
        s3 s3Var = ((m4) v1VarA.a).c;
        if (s3Var != null) {
            s3Var.a(account);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback) {
        this.A = iActiveCustomParamsCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppContext(f fVar) {
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppLanguageAndRegion(String str, String str2) {
        boolean z;
        if (b("setAppLanguageAndRegion")) {
            return;
        }
        e0 e0Var = this.q;
        s1 s1Var = e0Var.i;
        boolean z2 = true;
        if (s1Var.a("app_language", (Object) str)) {
            com.bytedance.bdtracker.a.a(s1Var.c.f, "app_language", str);
            z = true;
        } else {
            z = false;
        }
        s1 s1Var2 = e0Var.i;
        if (s1Var2.a("app_region", (Object) str2)) {
            com.bytedance.bdtracker.a.a(s1Var2.c.f, "app_region", str2);
        } else {
            z2 = false;
        }
        if (z || z2) {
            e0Var.a(e0Var.k);
            e0Var.a(e0Var.f);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppTrack(JSONObject jSONObject) {
        if (jSONObject == null || a("setAppTrack")) {
            return;
        }
        s1 s1Var = this.p;
        if (s1Var.a("app_track", jSONObject)) {
            q1 q1Var = s1Var.c;
            com.bytedance.bdtracker.a.a(q1Var.d, "app_track", jSONObject.toString());
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setClipboardEnabled(boolean z) {
        if (b("setClipboardEnabled")) {
            return;
        }
        this.q.B.a = z;
        LogUtils.sendJsonFetcher("update_config", new c(z));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEncryptAndCompress(boolean z) {
        this.E = z;
        if (l0.b.d(this.m)) {
            LogUtils.sendJsonFetcher("update_config", new a(z));
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventFilterByClient(List<String> list, boolean z) {
        b1 d1Var = null;
        if (list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                d1Var = z ? new d1(hashSet, null) : new c1(hashSet, null);
            }
        }
        this.w = d1Var;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventHandler(IEventHandler iEventHandler) {
        this.C = iEventHandler;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setExternalAbVersion(String str) {
        if (a("setExternalAbVersion")) {
            return;
        }
        this.p.f(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setExtraParams(IExtraParams iExtraParams) {
        this.j.a = iExtraParams;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setForbidReportPhoneDetailInfo(boolean z) {
        if (a("setForbidReportPhoneDetailInfo")) {
            return;
        }
        s1 s1Var = this.p;
        s1Var.k = z;
        if (!s1Var.r()) {
            s1Var.a("sim_serial_number", (Object) null);
        }
        LogUtils.sendJsonFetcher("update_config", new b(z));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setGPSLocation(float f, float f2, String str) {
        if (this.p == null) {
            this.D.warn("Please initialize first", new Object[0]);
        } else {
            this.B = new s(f, f2, str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setGoogleAid(String str) {
        if (a("setGoogleAid")) {
            return;
        }
        s1 s1Var = this.p;
        if (s1Var.a("google_aid", (Object) str)) {
            com.bytedance.bdtracker.a.a(s1Var.c.f, "google_aid", str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHeaderInfo(String str, Object obj) {
        if (a("setHeaderInfo") || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put(str, obj);
        c5.a(this.D, map);
        this.p.a(map);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setLaunchFrom(int i) {
        this.l = i;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setOaidObserver(IOaidObserver iOaidObserver) {
        h5.a(iOaidObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPrivacyMode(boolean z) {
        this.x = z;
        if (l0.b.d(this.m)) {
            LogUtils.sendJsonFetcher("update_config", new C0185d(z));
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPullAbTestConfigsThrottleMills(Long l) {
        if (this.q != null) {
            this.q.a(l);
        } else {
            new m0().initCause(new AssertionError("Please initialize first")).printStackTrace();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setRangersEventVerifyEnable(boolean z, String str) {
        if (b("setRangersEventVerifyEnable")) {
            return;
        }
        e0 e0Var = this.q;
        e0Var.j.removeMessages(15);
        e0Var.j.obtainMessage(15, new Object[]{Boolean.valueOf(z), str}).sendToTarget();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTouchPoint(String str) {
        setHeaderInfo("touch_point", str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTracerData(JSONObject jSONObject) {
        if (a("setTracerData")) {
            return;
        }
        this.p.a("tracer_data", jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUriRuntime(UriConfig uriConfig) {
        if (b("setUriRuntime")) {
            return;
        }
        e0 e0Var = this.q;
        e0Var.o = uriConfig;
        e0Var.a(e0Var.k);
        if (e0Var.e.c.isAutoActive()) {
            e0Var.a(true);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserAgent(String str) {
        if (a("setUserAgent")) {
            return;
        }
        s1 s1Var = this.p;
        if (s1Var.a(com.alipay.sdk.m.l.b.b, (Object) str)) {
            com.bytedance.bdtracker.a.a(s1Var.c.f, com.alipay.sdk.m.l.b.b, str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserID(long j) {
        if (b("setUserID")) {
            return;
        }
        this.q.n.a = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserUniqueID(String str) {
        if (this.p != null) {
            setUserUniqueID(str, this.p.l());
            return;
        }
        r4<String> r4Var = this.H;
        r4Var.a = str;
        r4Var.b = true;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(Dialog dialog, String str) {
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setTag(R.id.applog_tag_view_id, str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(View view, String str) {
        if (view == null) {
            return;
        }
        view.setTag(R.id.applog_tag_view_id, str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(Object obj, String str) {
        if (obj == null) {
            return;
        }
        if (!l0.b.a(obj, "android.support.v7.app.AlertDialog", "androidx.appcompat.app.AlertDialog")) {
            this.D.warn("Only support AlertDialog view", new Object[0]);
            return;
        }
        try {
            Window window = (Window) obj.getClass().getMethod("getWindow", new Class[0]).invoke(obj, new Object[0]);
            if (window != null) {
                window.getDecorView().setTag(R.id.applog_tag_view_id, str);
            }
        } catch (NoSuchMethodException e) {
            this.D.error("Not found getWindow method in alertDialog", e, new Object[0]);
        } catch (Throwable th) {
            this.D.error("Cannot set viewId for alertDialog", th, new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewProperties(View view, JSONObject jSONObject) {
        if (view == null || jSONObject == null) {
            return;
        }
        this.a.put(l0.b.b(view), jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void start() {
        if (b("start") || this.u) {
            return;
        }
        this.u = true;
        e0 e0Var = this.q;
        if (e0Var.r) {
            return;
        }
        e0Var.i();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void startDurationEvent(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (l0.b.a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        k0 k0Var = this.i.get(str);
        if (k0Var == null) {
            k0Var = new k0(this.D, str);
            this.i.put(str, k0Var);
        }
        k0Var.c(jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void startSimulator(String str) {
        if (b("startSimulator")) {
            return;
        }
        e0 e0Var = this.q;
        c0 c0Var = e0Var.s;
        if (c0Var != null) {
            c0Var.d = true;
        }
        Class<?> clsB = l0.b.b("com.bytedance.applog.picker.DomSender");
        if (clsB != null) {
            try {
                e0Var.s = (c0) clsB.getConstructor(e0.class, String.class).newInstance(e0Var, str);
                e0Var.j.sendMessage(e0Var.j.obtainMessage(9, e0Var.s));
            } catch (Throwable th) {
                e0Var.d.D.error("Start simulator failed.", th, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void stopDurationEvent(String str, JSONObject jSONObject) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (l0.b.a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        k0 k0Var = this.i.get(str);
        if (l0.b.a((Object) k0Var, "No duration event with name: " + str)) {
            return;
        }
        long j = 0;
        if (jElapsedRealtime <= 0) {
            IAppLogLogger iAppLogLogger = k0Var.a;
            if (iAppLogLogger != null) {
                iAppLogLogger.warn(4, "End at illegal time: " + jElapsedRealtime, new Object[0]);
            }
        } else {
            k0Var.a(jElapsedRealtime);
            IAppLogLogger iAppLogLogger2 = k0Var.a;
            if (iAppLogLogger2 != null) {
                iAppLogLogger2.debug(4, "[DurationEvent:{}] End[ at:{} and duration is {}ms", k0Var.b, Long.valueOf(jElapsedRealtime), Long.valueOf(k0Var.d));
            }
            j = k0Var.d;
        }
        JSONObject jSONObject2 = new JSONObject();
        l0.b.b(jSONObject, jSONObject2);
        try {
            jSONObject2.put("$event_duration", j);
        } catch (Throwable th) {
            this.D.error("JSON handle failed", th, new Object[0]);
        }
        receive(new a4(str, jSONObject2));
        this.i.remove(str);
    }

    public String toString() {
        return com.bytedance.bdtracker.a.a("AppLogInstance{id:").append(f752K.get()).append(";appId:").append(this.m).append("}@").append(hashCode()).toString();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackClick(View view) {
        trackClick(view, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackClick(View view, JSONObject jSONObject) {
        v3 v3VarA = l0.b.a(view, false);
        if (v3VarA != null && jSONObject != null) {
            v3VarA.o = jSONObject;
        }
        receive(v3VarA);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Activity activity) throws JSONException {
        trackPage(activity, (JSONObject) null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Activity activity, JSONObject jSONObject) throws JSONException {
        a(activity, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Object obj) throws JSONException {
        trackPage(obj, (JSONObject) null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Object obj, JSONObject jSONObject) throws JSONException {
        a(obj, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        if (b("userProfileSetOnce")) {
            return;
        }
        e0 e0Var = this.q;
        if (e0Var.j != null) {
            k3.a(e0Var, 0, jSONObject, userProfileCallback, e0Var.j, false);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        if (b("userProfileSync")) {
            return;
        }
        e0 e0Var = this.q;
        if (e0Var.j != null) {
            k3.a(e0Var, 1, jSONObject, userProfileCallback, e0Var.j, false);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        this.D.error("Parse event params failed", th, new Object[0]);
                        onEventV3(str, jSONObject, i);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        onEventV3(str, jSONObject, i);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHeaderInfo(HashMap<String, Object> map) {
        if (a("setHeaderInfo")) {
            return;
        }
        c5.a(this.D, map);
        this.p.a(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserUniqueID(String str, String str2) {
        if (this.p == null) {
            r4<String> r4Var = this.H;
            r4Var.a = str;
            r4Var.b = true;
            r4<String> r4Var2 = this.I;
            r4Var2.a = str2;
            r4Var2.b = true;
            return;
        }
        if (b("setUserUniqueID")) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        e0 e0Var = this.q;
        String strK = e0Var.i.k();
        String strL = e0Var.i.l();
        if (!l0.b.a(str, strK) || !l0.b.a(str2, strL)) {
            boolean z = false;
            e0Var.a((String[]) null, false);
            ArrayList arrayList = new ArrayList();
            long jCurrentTimeMillis = System.currentTimeMillis();
            d4 d4VarA = w.a();
            boolean zD = l0.b.d(e0Var.n.a());
            if (zD && d4VarA != null) {
                d4VarA = (d4) d4VarA.m347clone();
                d4VarA.m = e0Var.d.m;
                long j = jCurrentTimeMillis - d4VarA.c;
                d4VarA.a(jCurrentTimeMillis);
                if (j < 0) {
                    j = 0;
                }
                d4VarA.s = j;
                d4VarA.B = e0Var.n.b();
                e0Var.n.a(e0Var.d, d4VarA);
                arrayList.add(d4VarA);
            }
            e0Var.a(str, str2);
            if (d4VarA == null) {
                d4VarA = w.l;
            } else {
                z = true;
            }
            if (zD && d4VarA != null) {
                d4 d4Var = (d4) d4VarA.m347clone();
                d4Var.a(jCurrentTimeMillis + 1);
                d4Var.s = -1L;
                e0Var.n.a(e0Var.d, d4Var, arrayList, true).v = e0Var.n.b();
                if (z) {
                    e0Var.n.a(e0Var.d, d4Var);
                    arrayList.add(d4Var);
                }
            }
            if (!arrayList.isEmpty()) {
                e0Var.c().c.b(arrayList);
            }
            e0Var.a(e0Var.l);
        }
        l2.a(getMonitor(), "api_usage", "setUserUniqueID", jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject, int i) {
        if (TextUtils.isEmpty(str)) {
            this.D.error("event name is empty", new Object[0]);
            return;
        }
        IAppLogLogger iAppLogLogger = this.D;
        List<String> listAsList = Arrays.asList("customEvent", "eventV3");
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = jSONObject != null ? jSONObject.toString() : null;
        iAppLogLogger.debug(listAsList, "event:{} type:{} params:{} ", objArr);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c5.a(this.D, str, jSONObject);
        receive(new a4(this.m, str, false, jSONObject != null ? jSONObject.toString() : null, i));
        i2 monitor = getMonitor();
        String sessionId = getSessionId();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        w2 w2Var = new w2();
        w2Var.a = "onEventV3";
        w2Var.b = jElapsedRealtime2 - jElapsedRealtime;
        if (monitor != null) {
            ((n2) monitor).a(w2Var);
        }
        if (monitor != null) {
            if (sessionId == null) {
                sessionId = "";
            }
            ((n2) monitor).a(new u2(0L, sessionId, 1L));
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void receive(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(",");
        }
        if (this.q == null) {
            this.e.a(strArr);
            return;
        }
        e0 e0Var = this.q;
        e0Var.p.removeMessages(4);
        e0Var.p.obtainMessage(4, strArr).sendToTarget();
    }
}
