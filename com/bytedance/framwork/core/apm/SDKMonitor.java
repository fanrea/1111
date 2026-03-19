package com.bytedance.framwork.core.apm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.apmplus.sdk.event.SDKEventIDynamicParams;
import com.baidu.mobads.container.util.cm;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.applog.encryptor.EncryptorUtil;
import com.bytedance.framwork.core.de.d;
import com.bytedance.framwork.core.de.de.b;
import com.bytedance.framwork.core.de.fg.c;
import com.bytedance.framwork.core.de.fg.e;
import com.bytedance.framwork.core.ef.c;
import com.bytedance.framwork.core.fg.f;
import com.bytedance.framwork.core.fg.g;
import com.bytedance.framwork.core.fg.h;
import com.bytedance.framwork.core.fg.i;
import com.bytedance.framwork.core.fg.j;
import com.bytedance.framwork.core.fg.k;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.n;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SDKMonitor implements b, c, com.bytedance.framwork.core.de.gh.b {
    public static final String TAG = "ApmInsight";
    private volatile boolean A;
    private volatile boolean C;
    private volatile long E;
    private String H;
    private String I;
    private boolean J;

    /* renamed from: K, reason: collision with root package name */
    private SDKEventIDynamicParams f754K;
    private Context a;
    private JSONObject b;
    private d c;
    private com.bytedance.framwork.core.de.b d;
    private volatile long g;
    private volatile int h;
    private volatile int i;
    private volatile int j;
    private volatile int k;
    private volatile JSONObject l;
    private volatile JSONObject m;
    private volatile com.bytedance.framwork.core.cd.b n;
    private volatile int o;
    private volatile int p;
    private volatile List<String> q;
    private volatile List<Pattern> r;
    private volatile List<String> s;
    private volatile List<Pattern> t;
    private volatile long v;
    private IGetExtendParams w;
    private Map<String, String> x;
    private volatile boolean z;
    private boolean e = false;
    private volatile long f = 0;
    private volatile int u = 1;
    private List<String> y = new LinkedList();
    private volatile boolean B = true;
    private List<String> F = new LinkedList();
    private volatile boolean D = false;
    private com.bytedance.framwork.core.fg.b G = new com.bytedance.framwork.core.fg.b();

    public interface ICallback {
        void callback(boolean z);
    }

    public interface IGetExtendParams {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    public interface a {
        String a();
    }

    protected SDKMonitor(String str) {
        this.H = str;
    }

    protected SDKMonitor(String str, String str2) {
        this.H = str;
        this.I = str2;
    }

    public void setToken(String str) {
        this.I = str;
    }

    public boolean init(Context context, JSONObject jSONObject, final a aVar) {
        if (aVar == null) {
            return init(context, jSONObject, new IGetExtendParams() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.1
                @Override // com.bytedance.framwork.core.apm.SDKMonitor.IGetExtendParams
                public Map<String, String> getCommonParams() {
                    return null;
                }

                @Override // com.bytedance.framwork.core.apm.SDKMonitor.IGetExtendParams
                public String getSessionId() {
                    return null;
                }
            });
        }
        return init(context, jSONObject, new IGetExtendParams() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.7
            @Override // com.bytedance.framwork.core.apm.SDKMonitor.IGetExtendParams
            public Map<String, String> getCommonParams() {
                return null;
            }

            @Override // com.bytedance.framwork.core.apm.SDKMonitor.IGetExtendParams
            public String getSessionId() {
                return aVar.a();
            }
        });
    }

    public void setDebug(boolean z) {
        this.e = z;
    }

    public void setDynamicParams(SDKEventIDynamicParams sDKEventIDynamicParams) {
        this.f754K = sDKEventIDynamicParams;
    }

    public boolean init(final Context context, final JSONObject jSONObject, final IGetExtendParams iGetExtendParams) {
        this.C = true;
        this.a = context.getApplicationContext();
        com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.8
            @Override // java.lang.Runnable
            public void run() throws JSONException, PackageManager.NameNotFoundException {
                SDKMonitor.this.a(context, jSONObject, iGetExtendParams);
                if (SDKMonitor.this.D) {
                    SDKMonitor.this.G.a(SDKMonitor.this);
                }
            }
        }, 5000L);
        return true;
    }

    protected boolean a() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject, IGetExtendParams iGetExtendParams) throws JSONException, PackageManager.NameNotFoundException {
        if (context == null || jSONObject == null) {
            return;
        }
        this.C = true;
        this.a = context.getApplicationContext();
        this.b = jSONObject;
        try {
            com.bytedance.framwork.core.de.ha.c.a(jSONObject, context);
            com.bytedance.framwork.core.de.ha.c.b(this.b, context);
        } catch (Exception unused) {
        }
        try {
            this.b.put("aid", this.H);
            this.b.put("os", "Android");
            this.b.put("device_platform", "android");
            this.b.put("os_version", Build.VERSION.RELEASE);
            this.b.put("os_api", Build.VERSION.SDK_INT);
            this.b.put("device_model", Build.MODEL);
            this.b.put("device_brand", Build.BRAND);
            this.b.put("device_manufacturer", Build.MANUFACTURER);
            this.b.put("sdkmonitor_version", "1.1.8");
            this.b.put("monitor_from", "sdk");
            if (TextUtils.isEmpty(this.b.optString(n.p))) {
                this.b.put(n.p, context.getPackageName());
            }
            PackageInfo packageInfo = null;
            if (TextUtils.isEmpty(this.b.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME))) {
                packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
                this.b.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
            }
            if (TextUtils.isEmpty(this.b.optString("version_code"))) {
                if (packageInfo == null) {
                    packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
                }
                this.b.put("version_code", packageInfo.versionCode);
            }
            this.w = iGetExtendParams;
            if (iGetExtendParams == null) {
                this.w = new IGetExtendParams() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.9
                    @Override // com.bytedance.framwork.core.apm.SDKMonitor.IGetExtendParams
                    public Map<String, String> getCommonParams() {
                        return null;
                    }

                    @Override // com.bytedance.framwork.core.apm.SDKMonitor.IGetExtendParams
                    public String getSessionId() {
                        return null;
                    }
                };
            }
            Map<String, String> commonParams = this.w.getCommonParams();
            this.x = commonParams;
            if (commonParams == null) {
                this.x = new HashMap();
            }
            this.J = TextUtils.equals(this.x.get("oversea"), "1");
            this.x.put("aid", this.H);
            this.x.put(com.baidu.mobads.upgrade.remote.gray.c.l, this.b.optString(com.baidu.mobads.upgrade.remote.gray.c.l));
            this.x.put("device_platform", "android");
            this.x.put(n.p, this.b.optString(n.p));
            this.x.put("channel", this.b.optString("channel"));
            this.x.put("app_version", this.b.optString("app_version"));
            this.x.put("sdkmonitor_version", "1.1.8");
            this.x.put("minor_version", "1");
            com.bytedance.framwork.core.de.de.c.a(this.H, this);
            com.bytedance.framwork.core.de.fg.d.a(this.H, this);
            h();
            d dVar = new d(this.a, this.H);
            this.c = dVar;
            dVar.a();
            c();
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.framwork.core.cd.b b() {
        return this.n;
    }

    void a(List<String> list) {
        if (list == null || g.a(list)) {
            return;
        }
        this.y.clear();
        this.y.addAll(list);
    }

    void b(List<String> list) {
        if (list == null || g.a(list)) {
            return;
        }
        this.F.clear();
        this.F.addAll(list);
    }

    public String getUrlDomainAndPort() {
        List<String> list = this.F;
        if (list == null || g.a(list)) {
            return null;
        }
        try {
            URL url = new URL(this.F.get(0));
            int port = url.getPort();
            if (port > -1) {
                return url.getHost() + ":" + port;
            }
            return url.getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isDebugMode() {
        return this.e;
    }

    private void c() {
        SharedPreferences sp = getSp();
        String string = sp.getString("monitor_net_config", null);
        this.f = sp.getLong("monitor_configure_refresh_time", 0L);
        boolean z = sp.getInt("monitor_config_update", 0) == 1;
        com.bytedance.framwork.core.de.gh.a.a().a(this);
        if (!TextUtils.isEmpty(string)) {
            try {
                this.D = true;
                JSONObject jSONObject = new JSONObject(string);
                if (!z) {
                    jSONObject.remove("report_host_new");
                }
                a(jSONObject);
            } catch (Exception unused) {
                Log.e("monitor_config", "config error");
            }
        }
        a(false);
    }

    public SharedPreferences getSp() {
        return this.a.getSharedPreferences("monitor_config" + this.H + i.a(this.a), 0);
    }

    void a(boolean z) {
        if (this.g < 600) {
            this.g = 600L;
        }
        if ((z || e()) && j.b(this.a)) {
            synchronized (SDKMonitor.class) {
                this.f = System.currentTimeMillis();
            }
            try {
                com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.10
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] bArrA;
                        try {
                            if (SDKMonitor.this.x != null) {
                                Iterator it = SDKMonitor.this.y.iterator();
                                while (it.hasNext()) {
                                    String string = SDKMonitor.this.a((String) it.next()).append("&encrypt=close").toString();
                                    try {
                                        if (SDKMonitor.this.b() != null) {
                                            bArrA = SDKMonitor.this.b().a(string, null).a();
                                        } else {
                                            bArrA = j.a(string, com.bytedance.framwork.core.ef.c.a(SDKMonitor.this.d()), j.a.GZIP, MediaTypeUtils.APPLICATION_JSON, false, null).a();
                                        }
                                        if (bArrA != null) {
                                            JSONObject jSONObject = new JSONObject(new String(bArrA));
                                            if (SDKMonitor.this.e) {
                                                com.bytedance.framwork.core.de.ha.g.a(SDKMonitor.TAG, "SDK origin settings:" + jSONObject.toString());
                                            }
                                            SDKMonitor.this.b(com.bytedance.framwork.core.de.cd.a.b(com.bytedance.framwork.core.de.cd.a.a(jSONObject, SDKMonitor.this.H), SDKMonitor.this.H));
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            if (!SDKMonitor.this.D) {
                                SDKMonitor.this.D = true;
                                SDKMonitor.this.G.a(SDKMonitor.this);
                            }
                            th2.printStackTrace();
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", this.H);
            jSONObject.put("os", "Android");
            jSONObject.put("app_version", this.b.optString("app_version"));
            jSONObject.put("update_version_code", this.b.optString("version_code"));
            jSONObject.put("channel", this.b.optString("channel"));
            jSONObject.put("os_version", this.b.optString("os_version"));
            jSONObject.put("device_model", this.b.optString("device_model"));
            if (!TextUtils.isEmpty(this.I)) {
                jSONObject.put("x-auth-token", this.I);
            }
            SDKEventIDynamicParams sDKEventIDynamicParams = this.f754K;
            if (sDKEventIDynamicParams != null && !TextUtils.isEmpty(sDKEventIDynamicParams.getUserId())) {
                jSONObject.put("user_id", this.f754K.getUserId());
            }
            if (!TextUtils.isEmpty(this.b.optString(com.baidu.mobads.upgrade.remote.gray.c.l))) {
                jSONObject.put(com.baidu.mobads.upgrade.remote.gray.c.l, this.b.optString(com.baidu.mobads.upgrade.remote.gray.c.l));
            } else {
                SDKEventIDynamicParams sDKEventIDynamicParams2 = this.f754K;
                if (sDKEventIDynamicParams2 != null && !TextUtils.isEmpty(sDKEventIDynamicParams2.getDid())) {
                    jSONObject.put(com.baidu.mobads.upgrade.remote.gray.c.l, this.f754K.getDid());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray.toString();
    }

    private boolean e() {
        return (System.currentTimeMillis() - this.f) / 1000 > this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            a(jSONObject.getJSONObject("ret"));
            SharedPreferences.Editor editorEdit = getSp().edit();
            editorEdit.putLong("monitor_configure_refresh_time", System.currentTimeMillis());
            editorEdit.putInt("monitor_config_update", 1);
            editorEdit.putString("monitor_net_config", jSONObject.getJSONObject("ret").toString());
            editorEdit.apply();
            if (this.D) {
                return;
            }
            this.D = true;
            this.G.a(this);
        } catch (Throwable unused) {
        }
    }

    synchronized void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.e) {
            com.bytedance.framwork.core.de.ha.g.a(TAG, "SDK settings:" + jSONObject.toString());
        }
        JSONObject jSONObjectA = f.a(jSONObject, h.a, h.d);
        if (jSONObjectA != null) {
            JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(h.h);
            if (jSONObjectOptJSONObject != null) {
                this.g = jSONObjectOptJSONObject.optLong(h.i, 1200L);
            }
            if (this.g < 600) {
                this.g = 600L;
            }
            if (e()) {
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectA.optJSONObject(h.j);
            if (jSONObjectOptJSONObject2 != null) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("hosts");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String string = jSONArrayOptJSONArray.getString(i);
                            if (this.J && (string.contains(".snssdk.") || string.contains(".toutiao."))) {
                                arrayList.clear();
                                break;
                            }
                            if (!TextUtils.isEmpty(string) && string.indexOf(46) > 0) {
                                arrayList.add(string);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                if (!arrayList.isEmpty()) {
                    this.F = SDKMonitorUtils.convertReportUrl(arrayList);
                }
                int i2 = 120;
                this.h = jSONObjectOptJSONObject2.optInt("uploading_interval", 120);
                if (this.h >= 0) {
                    i2 = this.h;
                }
                this.h = i2;
                int i3 = 100;
                this.i = jSONObjectOptJSONObject2.optInt("once_max_count", 100);
                if (this.i >= 0) {
                    i3 = this.i;
                }
                this.i = i3;
                this.j = jSONObjectOptJSONObject2.optInt("max_retry_count", 4);
                this.k = jSONObjectOptJSONObject2.optInt("report_fail_base_interval", 15);
                this.u = jSONObjectOptJSONObject2.optInt("log_send_switch", 1);
                this.v = jSONObjectOptJSONObject2.optLong("more_channel_stop_interval", 1800L);
                this.B = jSONObjectOptJSONObject2.optBoolean("enable_encrypt", true);
                this.E = jSONObjectOptJSONObject2.optLong("memory_store_cache_max_count", 2000L);
                this.z = jSONObjectOptJSONObject2.optBoolean("log_remove_switch", false);
            }
        }
        if (jSONObject.length() <= 0) {
            this.F = null;
            return;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(h.b);
        if (jSONObjectOptJSONObject3 != null) {
            this.l = jSONObjectOptJSONObject3.optJSONObject("allow_service_name");
            this.m = jSONObjectOptJSONObject3.optJSONObject("allow_log_type");
        }
        JSONObject jSONObjectA2 = f.a(jSONObject, h.c, h.e);
        if (jSONObjectA2 != null) {
            this.o = jSONObjectA2.optInt("enable_api_error_upload", 0);
            this.p = jSONObjectA2.optInt("enable_api_all_upload", 0);
            this.q = g.a(jSONObjectA2, "api_block_list");
            this.r = g.b(jSONObjectA2, "api_block_list");
            this.s = g.a(jSONObjectA2, "api_allow_list");
            this.t = g.b(jSONObjectA2, "api_allow_list");
        }
        if (this.d == null) {
            com.bytedance.framwork.core.de.b bVar = new com.bytedance.framwork.core.de.b(this.a, this.H);
            this.d = bVar;
            bVar.a();
        }
        this.d.d();
    }

    public boolean getServiceSwitch(String str) {
        return (this.l == null || TextUtils.isEmpty(str) || this.l.opt(str) == null) ? false : true;
    }

    public boolean getLogTypeSwitch(String str) {
        return (this.m == null || TextUtils.isEmpty(str) || this.m.opt(str) == null) ? false : true;
    }

    public int getNetWorkType() {
        return com.bytedance.framwork.core.de.ha.h.a(this.a).a();
    }

    @Override // com.bytedance.framwork.core.de.gh.b
    public void onTimeEvent(long j) {
        if (this.g <= 0) {
            return;
        }
        a(false);
    }

    public boolean isLogSendSwitch() {
        return this.u == 1;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public int reportInterval() {
        if (this.h <= 0) {
            return 120;
        }
        return this.h;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public int reportCount() {
        if (this.i <= 0) {
            return 100;
        }
        return this.i;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public List<String> reportUrl(String str) {
        return this.F;
    }

    public long getMonitorLogMaxSaveCount() {
        return getMonitorLogMaxSaveCount();
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public JSONObject reportJsonHeaderInfo() throws JSONException {
        f();
        return this.b;
    }

    private void f() throws JSONException {
        SDKEventIDynamicParams sDKEventIDynamicParams;
        SDKEventIDynamicParams sDKEventIDynamicParams2;
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            if (TextUtils.isEmpty(jSONObject.optString(com.baidu.mobads.upgrade.remote.gray.c.l)) && (sDKEventIDynamicParams2 = this.f754K) != null && !TextUtils.isEmpty(sDKEventIDynamicParams2.getDid())) {
                try {
                    this.b.put(com.baidu.mobads.upgrade.remote.gray.c.l, this.f754K.getDid());
                } catch (JSONException unused) {
                }
            }
            if (!TextUtils.isEmpty(this.b.optString("user_id")) || (sDKEventIDynamicParams = this.f754K) == null || TextUtils.isEmpty(sDKEventIDynamicParams.getUserId())) {
                return;
            }
            try {
                this.b.put("user_id", this.f754K.getUserId());
            } catch (JSONException unused2) {
            }
        }
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public int reportFailRepeatCount() {
        if (this.j <= 0) {
            return 4;
        }
        return this.j;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public int reportFailRepeatBaseTime() {
        if (this.k <= 0) {
            return 15;
        }
        return this.k;
    }

    public long stopMoreChannelInterval() {
        if (this.v == 0) {
            return 1800000L;
        }
        return this.v * 1000;
    }

    @Override // com.bytedance.framwork.core.de.de.b
    public boolean getRemoveSwitch() {
        return this.A ? this.A : this.z;
    }

    @Override // com.bytedance.framwork.core.de.fg.c
    public e sendLog(String str, byte[] bArr) {
        byte[] bArrA;
        Map<String, String> mapB;
        e eVar = new e();
        try {
            String string = a(str).toString();
            new HashMap();
            if (b() != null) {
                HashMap map = new HashMap();
                bArr = j.a(bArr, map);
                if (this.B) {
                    byte[] bArrEncrypt = EncryptorUtil.encrypt(bArr, bArr.length);
                    if (bArrEncrypt != null) {
                        string = string + "&tt_data=a";
                        map.put("Content-Type", "application/octet-stream;tt-data=a");
                    }
                    com.bytedance.framwork.core.cd.a aVarA = b().a(string, bArrEncrypt, map);
                    bArrA = aVarA.a();
                    mapB = aVarA.b();
                } else {
                    com.bytedance.framwork.core.cd.a aVarA2 = b().a(string, bArr, map);
                    bArrA = aVarA2.a();
                    mapB = aVarA2.b();
                }
            } else {
                HashMap map2 = new HashMap(2);
                if (!TextUtils.isEmpty(this.I)) {
                    map2.put("aid", this.H);
                    map2.put("x-auth-token", this.I);
                }
                com.bytedance.framwork.core.cd.a aVarA3 = j.a(string, bArr, j.a.GZIP, MediaTypeUtils.APPLICATION_JSON, this.B, map2);
                bArrA = aVarA3.a();
                mapB = aVarA3.b();
            }
            String str2 = null;
            if (mapB != null && !mapB.isEmpty()) {
                str2 = mapB.get("ran");
            }
            eVar.a = 200;
            JSONObject jSONObject = new JSONObject(new String(bArrA));
            try {
                String strOptString = jSONObject.optString("data");
                if (!strOptString.isEmpty()) {
                    String strA = com.bytedance.framwork.core.de.ha.a.a(strOptString.getBytes(), str2);
                    if (!TextUtils.isEmpty(strA)) {
                        jSONObject = new JSONObject(strA);
                    } else {
                        jSONObject.put(cm.V, "success");
                    }
                }
                eVar.b = jSONObject;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            eVar.b = jSONObject;
            if (this.e) {
                try {
                    com.bytedance.framwork.core.de.ha.g.a(TAG, "SDK Send:\nurl:" + str + " \nresponse:" + eVar.a + " \ndata:" + new String(bArr));
                } catch (Exception unused) {
                }
            }
            return eVar;
        } catch (Throwable th2) {
            if (th2 instanceof com.bytedance.framwork.core.fg.d) {
                eVar.a = th2.a();
            } else {
                eVar.a = -1;
            }
            if (this.e) {
                try {
                    com.bytedance.framwork.core.de.ha.g.a(TAG, "SDK Send:\nurl:" + str + " \nresponse:" + eVar.a + " \ndata:" + new String(bArr));
                } catch (Exception unused2) {
                }
            }
            return eVar;
        }
    }

    public void setCollectDelay(long j) {
        this.d.a(j);
    }

    public void restoreCollectDelay() {
        this.d.e();
    }

    public void dropAllData() {
        this.d.f();
        this.A = true;
    }

    public void setStopCollect(boolean z) {
        this.c.a(z);
    }

    public void deleteAllLogs() {
        try {
            this.c.b();
            this.d.b();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StringBuilder a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isDigitsOnly(str) && this.x != null) {
            if (!str.contains("?")) {
                sb.append("?");
            }
            a(sb, "sdk_version", String.valueOf(1010890));
            g();
            Map<String, String> map = this.x;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey() != null) {
                        a(sb, String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                    }
                }
            }
        }
        return sb;
    }

    private void g() {
        SDKEventIDynamicParams sDKEventIDynamicParams;
        SDKEventIDynamicParams sDKEventIDynamicParams2;
        if (TextUtils.isEmpty(this.x.get(com.baidu.mobads.upgrade.remote.gray.c.l)) && (sDKEventIDynamicParams2 = this.f754K) != null && !TextUtils.isEmpty(sDKEventIDynamicParams2.getDid())) {
            this.x.put(com.baidu.mobads.upgrade.remote.gray.c.l, this.f754K.getDid());
        }
        if (!TextUtils.isEmpty(this.x.get("user_id")) || (sDKEventIDynamicParams = this.f754K) == null || TextUtils.isEmpty(sDKEventIDynamicParams.getUserId())) {
            return;
        }
        this.x.put("user_id", this.f754K.getUserId());
    }

    private StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.charAt(sb.length() - 1) != '?') {
            sb.append(com.alipay.sdk.m.s.a.n);
        }
        sb.append(a(str, "UTF-8")).append(com.alipay.sdk.m.n.a.h).append(a(str2, "UTF-8"));
        return sb;
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void h() {
        com.bytedance.framwork.core.ef.c.a(new c.b() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.11
            @Override // com.bytedance.framwork.core.ef.c.b
            public boolean a(Context context) {
                return j.b(context);
            }
        });
    }

    private String i() {
        IGetExtendParams iGetExtendParams = this.w;
        if (iGetExtendParams != null) {
            return iGetExtendParams.getSessionId();
        }
        return null;
    }

    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (!this.D) {
                this.G.a(new k(str, i, jSONObject, null, null, jSONObject2, System.currentTimeMillis()));
            } else {
                a(str, i, jSONObject, (JSONObject) null, (JSONObject) null, jSONObject2, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorStatusRate(String str, int i, JSONObject jSONObject) {
        monitorStatusAndDuration(str, i, null, jSONObject);
    }

    public void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        monitorStatusAndDuration(str, 0, jSONObject, jSONObject2);
    }

    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        try {
            if (!this.D) {
                this.G.a(new k(str, 0, null, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis()));
            } else {
                a(str, 0, (JSONObject) null, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorStatusAndEvent(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        try {
            if (!this.D) {
                this.G.a(new k(str, i, null, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis()));
            } else {
                a(str, i, (JSONObject) null, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorEvent(String str, Map<String, String> map, Map<String, Double> map2) {
        try {
            if (!this.D) {
                this.G.a(new k(str, 0, null, new JSONObject(map), new JSONObject(map2), null, System.currentTimeMillis()));
            } else {
                a(str, 0, (JSONObject) null, new JSONObject(map), new JSONObject(map2), (JSONObject) null, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorEvent(String str, Map<String, String> map, Map<String, Double> map2, JSONObject jSONObject) {
        try {
            if (!this.D) {
                this.G.a(new k(str, 0, null, new JSONObject(map), new JSONObject(map2), jSONObject, System.currentTimeMillis()));
            } else {
                a(str, 0, (JSONObject) null, new JSONObject(map), new JSONObject(map2), jSONObject, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorSLA(final long j, final long j2, final String str, final String str2, final String str3, final int i, final JSONObject jSONObject) {
        try {
            if (!this.D) {
                this.G.a(new com.bytedance.framwork.core.fg.a("api_all", j, j2, str, str2, str3, i, jSONObject));
            } else {
                com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.12
                    @Override // java.lang.Runnable
                    public void run() throws JSONException {
                        SDKMonitor.this.a(j, j2, str, str2, str3, i, jSONObject);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorApiError(final long j, final long j2, final String str, final String str2, final String str3, final int i, final JSONObject jSONObject) {
        try {
            if (!this.D) {
                this.G.a(new com.bytedance.framwork.core.fg.a("api_all", j, j2, str, str2, str3, i, jSONObject));
            } else {
                com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.13
                    @Override // java.lang.Runnable
                    public void run() throws JSONException {
                        SDKMonitor.this.b(j, j2, str, str2, str3, i, jSONObject);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    void a(final String str, final int i, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3, final JSONObject jSONObject4, final long j) {
        com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.14
            @Override // java.lang.Runnable
            public void run() {
                SDKMonitor.this.monitorService(str, i, jSONObject, jSONObject2, jSONObject3, jSONObject4, j);
            }
        });
    }

    public void monitorService(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, long j) {
        try {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("log_type", "event_log");
            jSONObject5.put("service", str);
            jSONObject5.put("event_name", str);
            jSONObject5.put("status", i);
            jSONObject5.put("network_type", getNetWorkType());
            jSONObject5.put(com.alipay.sdk.m.p0.b.d, jSONObject);
            if (jSONObject2 != null) {
                jSONObject5.put(TypedValues.Custom.S_DIMENSION, jSONObject2);
            }
            if (jSONObject3 != null) {
                jSONObject5.put(MetricsSQLiteCacheKt.METRICS_TABLE_NAME, jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject5.put("extra", jSONObject4);
            }
            if (jSONObject5.isNull(com.alipay.sdk.m.t.a.k)) {
                jSONObject5.put(com.alipay.sdk.m.t.a.k, j);
            }
            if (!TextUtils.isEmpty(i())) {
                jSONObject5.put("session_id", i());
            }
            if (this.c != null && getServiceSwitch(str)) {
                this.c.a("event_log", "event_log", jSONObject5);
            }
            if (this.e) {
                com.bytedance.framwork.core.de.ha.g.a(TAG, "SDK event:" + str + " simple:" + getServiceSwitch(str));
            }
        } catch (Throwable unused) {
        }
    }

    public void monitorCommonLog(String str, JSONObject jSONObject) {
        try {
            if (!this.D) {
                this.G.a(new com.bytedance.framwork.core.fg.c(str, jSONObject, System.currentTimeMillis()));
            } else {
                a(str, jSONObject, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    public void flushBuffer() {
        com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                if (SDKMonitor.this.c != null) {
                    SDKMonitor.this.c.a(0L, true);
                }
            }
        });
    }

    public void flushBuffer(final ICallback iCallback) {
        com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean zA = SDKMonitor.this.c != null ? SDKMonitor.this.c.a(0L, true) : false;
                } finally {
                    iCallback.callback(false);
                }
            }
        });
    }

    public void flushReport() {
        com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.4
            @Override // java.lang.Runnable
            public void run() {
                if (SDKMonitor.this.c == null || SDKMonitor.this.d == null) {
                    return;
                }
                SDKMonitor.this.d.a(true);
            }
        });
    }

    public void flushReport(final ICallback iCallback) {
        com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.5
            @Override // java.lang.Runnable
            public void run() {
                boolean zA = false;
                try {
                    if (SDKMonitor.this.c != null && SDKMonitor.this.d != null) {
                        zA = SDKMonitor.this.d.a(true);
                    }
                } finally {
                    iCallback.callback(false);
                }
            }
        });
    }

    void a(final String str, final JSONObject jSONObject, final long j) {
        com.bytedance.framwork.core.de.gh.a.a().a(new Runnable() { // from class: com.bytedance.framwork.core.apm.SDKMonitor.6
            @Override // java.lang.Runnable
            public void run() {
                SDKMonitor.this.monitorCommonLogInternal(str, jSONObject, j);
            }
        });
    }

    public void monitorCommonLogInternal(String str, JSONObject jSONObject, long j) {
        try {
            jSONObject.put("log_type", str);
            jSONObject.put("network_type", getNetWorkType());
            if (!TextUtils.isEmpty(i())) {
                jSONObject.put("session_id", i());
            }
            if (jSONObject.isNull(com.alipay.sdk.m.t.a.k)) {
                jSONObject.put(com.alipay.sdk.m.t.a.k, j);
            }
            if (this.c == null || !getLogTypeSwitch(str)) {
                return;
            }
            this.c.a("common_log", "common_log", jSONObject);
        } catch (Throwable unused) {
        }
    }

    void a(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) throws JSONException {
        if (c(str) || !j.b(this.a)) {
            return;
        }
        JSONObject jSONObjectA = a("api_all", j, j2, str, str2, str3, i);
        a(jSONObjectA, jSONObject);
        if ((jSONObjectA == null || !b(str)) && this.p == 0) {
            return;
        }
        try {
            jSONObjectA.put("hit_rules", 1);
            this.c.a("api_all", "api_all", jSONObjectA);
        } catch (JSONException unused) {
        }
    }

    void b(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) throws JSONException {
        d dVar;
        if (this.o == 1 || c(str)) {
            return;
        }
        JSONObject jSONObjectA = a("api_error", j, j2, str, str2, str3, i);
        a(jSONObjectA, jSONObject);
        if (jSONObjectA == null || jSONObjectA.length() <= 0 || (dVar = this.c) == null) {
            return;
        }
        dVar.a("api_error", "api_error", jSONObjectA);
    }

    private boolean b(String str) {
        return a(str, this.s, this.t);
    }

    private boolean c(String str) {
        return a(str, this.q, this.r);
    }

    private boolean a(String str, List<String> list, List<Pattern> list2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!g.a(list)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        try {
            String path = new URI(str).getPath();
            if (!g.a(list2)) {
                Iterator<Pattern> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (it2.next().matcher(path).matches()) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject a(String str, long j, long j2, String str2, String str3, String str4, int i) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", str);
            jSONObject.put("duration", j);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(ContentProviderManager.PROVIDER_URI, Uri.parse(str2));
            }
            if (j2 > 0) {
                jSONObject.put(com.alipay.sdk.m.t.a.k, j2);
            }
            jSONObject.put("status", i);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("ip", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("trace_code", str4);
            } else {
                jSONObject.put("trace_code", "");
            }
            jSONObject.put("network_type", j.a(this.a).a());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
