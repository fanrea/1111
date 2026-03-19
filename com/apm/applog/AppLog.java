package com.apm.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import ca.da.ca.ca.a;
import ca.da.ca.d;
import ca.da.ca.da.b;
import ca.da.ca.e;
import ca.da.ca.fa.g;
import ca.da.ca.fa.h;
import ca.da.ca.fa.j;
import ca.da.ca.i;
import ca.da.ca.ja.c;
import ca.da.ca.ja.q;
import ca.da.ca.ja.r;
import ca.da.da.f;
import com.apm.applog.network.INetworkClient;
import com.bytedance.apm.common.utility.ToolUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class AppLog {
    public static final String EVENT_V1_CATEGORY = "event_v1";
    public static boolean d = true;
    public static volatile a e = null;
    public static Application f = null;
    public static volatile boolean g = false;
    public static Integer h = null;
    public static INetworkClient k = null;
    public static volatile ca.da.ca.ea.a sEventFilterFromClient = null;
    public static int sLaunchFrom = 1;
    public volatile g a;
    public volatile h b;
    public Map<String, String> c;
    public b mEngine;
    public static ConcurrentHashMap<String, AppLog> i = new ConcurrentHashMap<>();
    public static INetworkClient j = new c();
    public static boolean l = true;
    public static boolean m = true;
    public static boolean n = true;

    public AppLog() {
        r.a((Throwable) null);
    }

    public static void addEventObserver(ca.da.ca.b bVar) {
        ca.da.ca.ja.h.a().a(bVar);
    }

    public static void addSessionHook(ca.da.ca.h hVar) {
        q.a().a(hVar);
    }

    public static ca.da.ca.a getAppContext() {
        return null;
    }

    public static Context getContext() {
        return f;
    }

    public static boolean getEncryptAndCompress() {
        return d;
    }

    public static d getHeaderCustomCallback() {
        return null;
    }

    public static AppLog getInstance(String str) {
        return i.get(str);
    }

    public static INetworkClient getNetClient() {
        INetworkClient iNetworkClient = k;
        return iNetworkClient != null ? iNetworkClient : j;
    }

    public static String getSdkVersion() {
        return "0.1.8";
    }

    public static ca.da.ca.g getSensitiveInfoProvider() {
        return null;
    }

    public static String getUserID() {
        return String.valueOf(ca.da.ca.da.g.n);
    }

    public static boolean hasStarted() {
        return g;
    }

    public static AppLog init(Context context, InitConfig initConfig) {
        return init(context, initConfig, null);
    }

    public static boolean isAndroidIdEnabled() {
        return l;
    }

    public static boolean isGAIdEnabled() {
        return n;
    }

    public static boolean isNewUserMode(Context context) {
        j.a(context);
        return false;
    }

    public static boolean isNewUserModeAvailable() {
        if (!hasStarted()) {
            return false;
        }
        j.a();
        return false;
    }

    public static boolean isOAIdEnabled() {
        return m;
    }

    public static void onActivityPause() {
        if (e != null) {
            e.onActivityPaused(null);
        }
    }

    public static void onActivityResumed(String str, int i2) {
        if (e != null) {
            e.a(str, i2);
        }
    }

    public static void onPause(Context context) {
        if (context instanceof Activity) {
            onActivityPause();
        }
    }

    public static void onResume(Context context) {
        if (context instanceof Activity) {
            onActivityResumed(context.getClass().getName(), context.hashCode());
        }
    }

    public static void receive(ca.da.ca.ia.b bVar) {
        ConcurrentHashMap<String, AppLog> concurrentHashMap = i;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return;
        }
        Iterator<AppLog> it = i.values().iterator();
        while (it.hasNext()) {
            b bVar2 = it.next().mEngine;
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
        }
    }

    public static void registerHeaderCustomCallback(d dVar) {
    }

    public static void removeEventObserver(ca.da.ca.b bVar) {
        ca.da.ca.ja.h.a().b(bVar);
    }

    public static void removeOaidObserver(e eVar) {
        f.a(eVar);
    }

    public static void removeSessionHook(ca.da.ca.h hVar) {
        q.a().b(hVar);
    }

    public static void setAndroidIdEnabled(boolean z) {
        l = z;
    }

    public static void setAppContext(ca.da.ca.a aVar) {
    }

    public static void setEncryptAndCompress(boolean z) {
        d = z;
    }

    public static void setEventFilterByClient(List<String> list, boolean z) {
        ca.da.ca.ea.a cVar = null;
        if (list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                cVar = z ? new ca.da.ca.ea.c(hashSet, null) : new ca.da.ca.ea.b(hashSet, null);
            }
        }
        sEventFilterFromClient = cVar;
    }

    public static void setExtraParams(ca.da.ca.c cVar) {
        ca.da.ca.ba.b.a = cVar;
    }

    public static void setGAIdEnabled(boolean z) {
        n = z;
    }

    public static void setHttpMonitorPort(int i2) {
        h = Integer.valueOf(i2);
    }

    public static void setLogger(Context context, ILogger iLogger) {
        r.a(context, iLogger);
    }

    public static void setNetworkClient(INetworkClient iNetworkClient) {
        k = iNetworkClient;
    }

    public static void setNewUserMode(Context context, boolean z) {
        j.a(context, z);
    }

    public static void setOAIdEnabled(boolean z) {
        m = z;
    }

    public static void setOaidObserver(e eVar) {
        f.b(eVar);
    }

    public static void setSensitiveInfoProvider(ca.da.ca.g gVar) {
    }

    public static void setUserID(long j2) {
        ca.da.ca.da.g.n = j2;
    }

    public void addDataObserver(IDataObserver iDataObserver) {
        ca.da.ca.ja.b.a(getAid()).a(iDataObserver);
    }

    public String addNetCommonParams(Context context, String str, boolean z, i iVar) {
        return ca.da.ca.ba.b.a(context, this.b != null ? this.b.d() : null, str, z, iVar);
    }

    public void flush() {
        b bVar = this.mEngine;
        if (bVar != null) {
            bVar.a((String[]) null, true);
        }
    }

    public <T> T getAbConfig(String str, T t) throws JSONException {
        if (this.b == null) {
            return null;
        }
        h hVar = this.b;
        JSONObject jSONObjectOptJSONObject = hVar.c.a().optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return t;
        }
        String strOptString = jSONObjectOptJSONObject.optString(PointParamKey.VID);
        Object objOpt = jSONObjectOptJSONObject.opt("val");
        hVar.a(strOptString);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ab_sdk_version", strOptString);
            getInstance(hVar.c.c()).onEventV3("abtest_exposure", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Object obj = objOpt != null ? objOpt : null;
        return obj == null ? t : (T) obj;
    }

    public String getAbSdkVersion() {
        if (this.b == null) {
            return null;
        }
        h hVar = this.b;
        if (hVar.a) {
            return hVar.d.optString("ab_sdk_version", "");
        }
        g gVar = hVar.c;
        return gVar != null ? gVar.b() : "";
    }

    public String getAid() {
        return this.b != null ? this.b.a() : "";
    }

    public JSONObject getAllAbTestConfigs() {
        b bVar = this.mEngine;
        return bVar == null ? new JSONObject() : bVar.c.a();
    }

    public String getClientUdid() {
        return this.b != null ? this.b.d.optString("clientudid", "") : "";
    }

    public String getDid() {
        return this.b != null ? this.b.b() : "";
    }

    public JSONObject getHeader() {
        if (this.b != null) {
            return this.b.d();
        }
        r.a(new RuntimeException("init come first"));
        return null;
    }

    public <T> T getHeaderValue(String str, T t, Class<T> cls) {
        if (this.b != null) {
            return (T) ca.da.ca.ba.b.a(this.b.d, str, t, cls);
        }
        return null;
    }

    public int getHttpMonitorPort() {
        Integer num = h;
        if (num != null) {
            return num.intValue();
        }
        if (this.a != null) {
            return this.a.e.getInt("http_monitor_port", 0);
        }
        return 0;
    }

    public String getIid() {
        return this.b != null ? this.b.d.optString("install_id", "") : "";
    }

    public InitConfig getInitConfig() {
        if (this.a != null) {
            return this.a.b;
        }
        return null;
    }

    public String getOpenUdid() {
        return this.b != null ? this.b.d.optString("openudid", "") : "";
    }

    public Map<String, String> getRequestHeader() {
        if (this.a == null) {
            return Collections.emptyMap();
        }
        String string = this.a.e.getString("device_token", "");
        HashMap map = new HashMap();
        map.put("x-tt-dt", string != null ? string : "");
        return map;
    }

    public String getSessionId() {
        ca.da.ca.da.g gVar = this.mEngine.j;
        if (gVar != null) {
            return gVar.e;
        }
        return null;
    }

    public Map<String, String> getSessionTags() {
        try {
            if (this.c == null) {
                this.c = new ConcurrentHashMap();
            }
            if (ToolUtils.isHarmonyOs()) {
                this.c.put("is_harmony_os", "1");
            } else {
                this.c.put("is_harmony_os", "0");
            }
        } catch (Throwable unused) {
        }
        return this.c;
    }

    public String getSsid() {
        return this.b != null ? this.b.f() : "";
    }

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

    public int getSuccRate() {
        if (this.a != null) {
            return this.a.e.getInt("bav_monitor_rate", 0);
        }
        return 0;
    }

    public String getUdid() {
        return this.b != null ? this.b.d.optString("udid", "") : "";
    }

    public String getUserUniqueID() {
        return this.b != null ? this.b.g() : "";
    }

    public AppLog initInner(Context context, InitConfig initConfig) {
        if (initConfig.getLogger() != null) {
            r.a(context, initConfig.getLogger());
        }
        r.a("Inited Begin", (Throwable) null);
        if (f == null) {
            f = (Application) context.getApplicationContext();
        }
        i.put(initConfig.getAid(), this);
        this.a = new g(f, initConfig);
        this.b = new h(f, this.a);
        this.mEngine = new b(f, this.a, this.b);
        initConfig.getPicker();
        e = new a();
        if (initConfig.a()) {
            f.registerActivityLifecycleCallbacks(e);
        }
        g = g || initConfig.autoStart();
        r.a(ca.ca.ca.ca.a.a("Inited Config Did:").append(initConfig.getDid()).append(" aid:").append(initConfig.getAid()).toString(), (Throwable) null);
        return this;
    }

    public boolean isH5BridgeEnable() {
        return getInitConfig() != null && getInitConfig().isH5BridgeEnable();
    }

    public boolean isH5CollectEnable() {
        return getInitConfig() != null && getInitConfig().isH5CollectEnable();
    }

    public boolean isNewUser() {
        if (this.b != null) {
            return this.b.i;
        }
        return false;
    }

    public boolean manualActivate() {
        b bVar = this.mEngine;
        if (bVar != null) {
            return bVar.a(false);
        }
        return false;
    }

    public void onEvent(String str, String str2, String str3, long j2, long j3, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            r.a("category or tag is empty", (Throwable) null);
        } else {
            this.mEngine.a(new ca.da.ca.ia.e(str, str2, str3, j2, j3, jSONObject != null ? jSONObject.toString() : null));
        }
    }

    public void onEventV3(String str) {
        onEventV3(str, (JSONObject) null);
    }

    public void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            r.a("both second appid and second app name is empty, return", (Throwable) null);
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str5 = "second_app_" + str;
        try {
            jSONObject.put("params_for_special", "second_app");
            jSONObject.put("second_appid", str2);
            jSONObject.put("second_appname", str3);
            jSONObject.put("product_type", str4);
        } catch (Throwable th) {
            r.a(th);
        }
        onEventV3(str5, jSONObject);
    }

    public void onLaunchEvent() {
        b bVar;
        Handler handler;
        if (this.mEngine == null || this.a == null || !this.a.q || (handler = (bVar = this.mEngine).l) == null) {
            return;
        }
        handler.post(new ca.da.ca.da.c(bVar));
    }

    public void onMiscEvent(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            r.a("call onEventData with invalid params, return", (Throwable) null);
            return;
        }
        try {
            this.mEngine.a(new ca.da.ca.ia.f(str, jSONObject));
        } catch (Exception e2) {
            r.a("call onEventData get exception: ", e2);
        }
    }

    public void profileAppend(JSONObject jSONObject) {
        if (this.mEngine == null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            if (!ca.da.ca.ha.b.a(jSONObject, new Class[]{String.class, Integer.class}, new Class[]{String.class})) {
                r.a("only support String、Int、String Array！", new Exception());
                return;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.mEngine.a(jSONObject);
    }

    public void profileIncrement(JSONObject jSONObject) {
        if (this.mEngine == null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            if (!ca.da.ca.ha.b.a(jSONObject, new Class[]{Integer.class}, null)) {
                r.a("only support Int", new Exception());
                return;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.mEngine.b(jSONObject);
    }

    public void profileSet(JSONObject jSONObject) {
        if (this.mEngine == null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.mEngine.c(jSONObject);
    }

    public void profileSetOnce(JSONObject jSONObject) {
        if (this.mEngine == null || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.mEngine.d(jSONObject);
    }

    public void profileUnset(String str) throws JSONException {
        if (this.mEngine == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.mEngine.e(jSONObject);
    }

    public void putCommonParams(Context context, Map<String, String> map, boolean z, i iVar) {
        ca.da.ca.ba.b.a(context, this.b != null ? this.b.d() : null, z, map, iVar);
    }

    public void removeAllDataObserver() {
        ca.da.ca.ja.b.a(getAid()).a.clear();
    }

    public void removeDataObserver(IDataObserver iDataObserver) {
        ca.da.ca.ja.b.a(getAid()).b(iDataObserver);
    }

    public void removeHeaderInfo(String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.c(str);
    }

    public void setAccount(Account account) {
        if (this.b != null) {
            r.a("setAccount " + account, (Throwable) null);
            this.b.a(account);
        }
    }

    public void setAppLanguageAndRegion(String str, String str2) {
        boolean z;
        b bVar = this.mEngine;
        if (bVar != null) {
            h hVar = bVar.f;
            boolean z2 = true;
            if (hVar.a("app_language", str)) {
                ca.ca.ca.ca.a.a(hVar.c.e, "app_language", str);
                z = true;
            } else {
                z = false;
            }
            h hVar2 = bVar.f;
            if (hVar2.a("app_region", str2)) {
                ca.ca.ca.ca.a.a(hVar2.c.e, "app_region", str2);
            } else {
                z2 = false;
            }
            if (z || z2) {
                bVar.a(bVar.h);
            }
        }
    }

    public void setAppTrack(JSONObject jSONObject) {
        if (jSONObject == null || this.b == null) {
            return;
        }
        h hVar = this.b;
        if (hVar.a("app_track", jSONObject)) {
            g gVar = hVar.c;
            ca.ca.ca.ca.a.a(gVar.c, "app_track", jSONObject.toString());
        }
    }

    public void setCustomLaunch(boolean z) {
        if (this.a != null) {
            this.a.q = z;
        }
    }

    public void setEventSenderEnable(boolean z, Context context) {
        b bVar = this.mEngine;
        if (bVar != null) {
            bVar.a(z, context);
        }
    }

    public void setExternalAbVersion(String str) {
        if (this.b != null) {
            this.b.e(str);
        }
    }

    public void setGoogleAid(String str) {
        if (this.b != null) {
            h hVar = this.b;
            if (hVar.a("google_aid", str)) {
                ca.ca.ca.ca.a.a(hVar.c.e, "google_aid", str);
            }
        }
    }

    public void setHeaderInfo(HashMap<String, Object> map) {
        if (this.b != null) {
            this.b.a(map);
        }
    }

    public void setRangersEventVerifyEnable(boolean z, String str) {
        b bVar = this.mEngine;
        if (bVar != null) {
            bVar.g.removeMessages(15);
            bVar.g.obtainMessage(15, new Object[]{Boolean.valueOf(z), str}).sendToTarget();
        }
    }

    public void setTouchPoint(String str) {
        setHeaderInfo("touch_point", str);
    }

    public void setTracerData(JSONObject jSONObject) {
        if (this.b != null) {
            this.b.a("tracer_data", jSONObject);
        }
    }

    public void setUriRuntime(UriConfig uriConfig) {
        if (this.mEngine != null) {
            r.a(ca.ca.ca.ca.a.a("setUriRuntime ").append(uriConfig.getRegisterUri()).toString(), (Throwable) null);
            b bVar = this.mEngine;
            bVar.k = uriConfig;
            bVar.a(bVar.h);
            if (bVar.c.b.isAutoActive()) {
                bVar.a(true);
            }
        }
    }

    public void setUserAgent(String str) {
        if (this.b != null) {
            h hVar = this.b;
            if (hVar.a(com.alipay.sdk.m.l.b.b, str)) {
                ca.ca.ca.ca.a.a(hVar.c.e, com.alipay.sdk.m.l.b.b, str);
            }
        }
    }

    public void setUserUniqueID(String str) {
        b bVar = this.mEngine;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void start() {
        if (g) {
            return;
        }
        g = true;
        b bVar = this.mEngine;
        if (bVar.n) {
            return;
        }
        bVar.n = true;
        bVar.l.sendEmptyMessage(1);
    }

    public void startSimulator(String str) throws NoSuchMethodException, SecurityException {
        b bVar = this.mEngine;
        if (bVar != null) {
            ca.da.ca.da.a aVar = bVar.o;
            if (aVar != null) {
                aVar.e = true;
            }
            try {
                Constructor<?> constructor = Class.forName("com.bytedance.applog.picker.DomSender").getConstructor(b.class, String.class);
                new HandlerThread("bd_tracker_d").start();
                bVar.o = (ca.da.ca.da.a) constructor.newInstance(bVar, str);
                bVar.g.sendMessage(bVar.g.obtainMessage(9, bVar.o));
            } catch (Exception e2) {
                r.a(e2);
            }
        }
    }

    public void userProfileSetOnce(JSONObject jSONObject, ca.da.ca.ab.a aVar) {
        b bVar = this.mEngine;
        if (bVar == null || bVar.g == null) {
            return;
        }
        ca.da.ca.ab.b.a(bVar, 0, jSONObject, aVar, bVar.g, false);
    }

    public void userProfileSync(JSONObject jSONObject, ca.da.ca.ab.a aVar) {
        b bVar = this.mEngine;
        if (bVar == null || bVar.g == null) {
            return;
        }
        ca.da.ca.ab.b.a(bVar, 1, jSONObject, aVar, bVar.g, false);
    }

    public static AppLog init(Context context, InitConfig initConfig, Map<String, String> map) {
        AppLog appLog = i.get(initConfig.getAid());
        if (appLog == null) {
            return new AppLog(context, initConfig, map);
        }
        Map<String, String> map2 = appLog.c;
        if (map2 == null) {
            appLog.c = map;
        } else if (map != null) {
            map2.putAll(map);
        }
        return appLog;
    }

    public void onEventV3(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            r.a("event name is empty", (Throwable) null);
        } else {
            this.mEngine.a(new ca.da.ca.ia.g(str, false, jSONObject != null ? jSONObject.toString() : null));
        }
    }

    public AppLog(Context context, InitConfig initConfig, Map<String, String> map) {
        this.c = map;
        initInner(context, initConfig);
    }

    public void setHeaderInfo(String str, Object obj) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put(str, obj);
        this.b.a(map);
    }

    public void onEventV3(String str, Bundle bundle) {
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
                        r.a(th);
                        onEventV3(str, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        onEventV3(str, jSONObject);
    }

    public void onEvent(String str, String str2, String str3, long j2, long j3) {
        onEvent(str, str2, str3, j2, j3, null);
    }

    public void onEvent(String str, String str2) {
        onEvent(EVENT_V1_CATEGORY, str, str2, 0L, 0L, null);
    }

    public void onEvent(String str) {
        onEvent(EVENT_V1_CATEGORY, str, null, 0L, 0L, null);
    }

    public void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            r.a("both second appid and second app name is empty, return", (Throwable) null);
            return;
        }
        String str5 = "second_app_" + str;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str6 : bundle.keySet()) {
                            jSONObject2.put(str6, bundle.get(str6));
                        }
                        jSONObject2.put("params_for_special", "second_app");
                        jSONObject2.put("second_appid", str2);
                        jSONObject2.put("second_appname", str3);
                        jSONObject2.put("product_type", str4);
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        r.a(th);
                        onEventV3(str5, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        onEventV3(str5, jSONObject);
    }
}
