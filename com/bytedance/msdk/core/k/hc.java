package com.bytedance.msdk.core.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.an.c;
import com.bytedance.msdk.api.c.u;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.d.u.gb;
import com.bytedance.msdk.gb.de;
import com.bytedance.msdk.gb.e;
import com.bytedance.msdk.gb.fs;
import com.bytedance.msdk.gb.he;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.util.FeedSurveyManager;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.openadsdk.core.tc;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements gb.d {
    private static volatile hc c = null;
    private static volatile boolean d = false;
    private final Context b;
    private final gb gb;
    private final com.bytedance.msdk.core.k.d hc;
    private final AtomicInteger u = new AtomicInteger(0);
    private final AtomicBoolean an = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean tt = new AtomicBoolean(false);
    private int tc = -1;

    interface d {
        public static final String d = fs.d() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static hc d(com.bytedance.msdk.core.k.d dVar) {
        if (c == null) {
            synchronized (hc.class) {
                if (c == null) {
                    c = new hc(dVar);
                }
            }
        }
        return c;
    }

    private hc(com.bytedance.msdk.core.k.d dVar) {
        this.hc = dVar == null ? com.bytedance.msdk.core.hc.hc() : dVar;
        Context context = com.bytedance.msdk.core.hc.getContext();
        this.b = context;
        this.gb = new gb(Looper.getMainLooper(), this);
        if (com.bytedance.msdk.core.d.mk().uo()) {
            try {
                context.registerReceiver(new b(), new IntentFilter("com.bytedance.msdk.core.setting.SettingsReceiver"), d.d, null);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
    }

    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || tc.w().us()) {
                return;
            }
            com.bytedance.msdk.d.u.b.d("SdkSettingsHelper", "--==-- settings receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (!TextUtils.equals(intent.getStringExtra("b_msg_process_name"), he.hc(hc.this.b))) {
                        if (hc.this.hc != null) {
                            com.bytedance.msdk.d.u.b.d("SdkSettingsHelper", "--==-- settings receiver loadData");
                            hc.this.hc.d(false);
                            com.bytedance.msdk.h.d.b.d().hc();
                            com.bytedance.msdk.d.u.b.d("SdkSettingsHelper", "--==-- settings receiver loadData end");
                            return;
                        }
                        return;
                    }
                    com.bytedance.msdk.d.u.b.d("SdkSettingsHelper", "--==-- settings receiver, same process, return");
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        }
    }

    private static void u() {
        if (tc.w().us() || com.bytedance.msdk.core.hc.getContext() == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(fs.d());
            intent.setAction("com.bytedance.msdk.core.setting.SettingsReceiver");
            intent.putExtra("b_msg_id", 1);
            intent.putExtra("b_msg_process_name", he.hc(com.bytedance.msdk.core.hc.getContext()));
            com.bytedance.msdk.core.hc.getContext().sendBroadcast(intent, d.d);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public hc d() {
        com.bytedance.msdk.d.u.b.c("SdkSettingsHelper", "setting resetRetryCount...");
        this.u.set(0);
        this.tt.set(false);
        gb gbVar = this.gb;
        if (gbVar != null) {
            gbVar.removeCallbacksAndMessages(null);
        }
        return this;
    }

    public void d(int i) {
        try {
            if (this.an.get()) {
                this.tc = i;
                com.bytedance.msdk.d.u.b.hc("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                an.c(new RunnableC0244hc(null, i));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.d.u.b.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void hc(int i) {
        if (this.tt.get()) {
            com.bytedance.msdk.d.u.b.c("SdkSettingsHelper", "setting 正在尝试拉取配置中...");
            return;
        }
        com.bytedance.msdk.d.u.b.c("SdkSettingsHelper", "setting 尝试拉取配置...");
        d();
        b(i);
    }

    public void b(int i) {
        np.d();
        try {
            if (!an()) {
                com.bytedance.msdk.d.u.b.hc("SdkSettingsHelper", "setting 缓存未过期，无需再次发起请求...");
            } else if (this.an.get()) {
                com.bytedance.msdk.d.u.b.hc("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                an.c(new RunnableC0244hc(null, i));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.d.u.b.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private boolean an() {
        long jHc = com.bytedance.msdk.h.d.d().hc("max_expire_time", 0L);
        if (this.h.get() && System.currentTimeMillis() > jHc) {
            com.bytedance.msdk.d.u.b.hc("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.h.set(false);
            d();
        }
        return System.currentTimeMillis() > jHc;
    }

    private void d(u uVar, com.bytedance.msdk.api.d dVar, int i) throws Throwable {
        long j;
        com.bytedance.msdk.h.d.d().an("server_dist_host");
        d(uVar, dVar);
        com.bytedance.msdk.an.b.u();
        com.bytedance.msdk.d.u.b.c("SdkSettingsHelper", "setting 配置拉取失败，尝试再次拉取... mLoadingSuccess:" + this.h.get() + " mRetryCount:" + (this.u.get() + 1));
        this.an.set(false);
        if (this.h.get()) {
            this.tt.set(false);
            this.gb.removeCallbacksAndMessages(null);
            return;
        }
        if (this.u.get() > 3) {
            com.bytedance.msdk.d.u.b.c("SdkSettingsHelper", "setting 最多尝试四次拉取... ");
            return;
        }
        this.tt.set(true);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = this.u.get();
        messageObtain.arg2 = i;
        int i2 = this.u.get();
        if (i2 < 3) {
            long j2 = 1;
            for (int i3 = 0; i3 <= i2; i3++) {
                j2 *= 3;
            }
            j = j2 * 1000;
        } else {
            j = 120000;
        }
        this.u.incrementAndGet();
        this.gb.removeCallbacksAndMessages(null);
        this.gb.sendMessageDelayed(messageObtain, j);
        com.bytedance.msdk.d.u.b.hc("SdkSettingsHelper", "setting 重试次数:" + (i2 + 1) + "  重试间隔：" + j);
    }

    private Map<String, String> d(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                map2.put(str.toLowerCase(), map.get(str));
            }
        }
        return map2;
    }

    /* renamed from: com.bytedance.msdk.core.k.hc$hc, reason: collision with other inner class name */
    private class RunnableC0244hc implements Runnable {
        private int b;
        private final u hc;

        RunnableC0244hc(u uVar, int i) {
            this.hc = uVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            if (!np.d(hc.this.b)) {
                try {
                    hc.this.hc.d(false);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            hc.this.an.set(true);
            boolean zZw = com.bytedance.msdk.core.hc.hc().zw();
            if (!hc.d) {
                boolean unused2 = hc.d = true;
                c.d(zZw);
            }
            if (com.bytedance.msdk.gb.c.d.d()) {
                return;
            }
            hc.this.d(zZw, this.hc, this.b);
        }
    }

    private void d(final u uVar, final com.bytedance.msdk.api.d dVar) {
        an.b(new Runnable() { // from class: com.bytedance.msdk.core.k.hc.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void d(final u uVar) {
        int i = this.tc;
        if (i == 2 || i == 3) {
            this.tc = -1;
            d(i);
        }
        if (uVar != null) {
            final List<String> listFs = com.bytedance.msdk.core.d.mk().fs();
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.k.hc.2
                @Override // java.lang.Runnable
                public void run() {
                    uVar.d(com.bytedance.msdk.core.hc.hc().d(listFs));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final boolean z, final u uVar, final int i) throws JSONException {
        final int[] iArr = {0};
        final int[] iArr2 = new int[1];
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, JSONObject> mapHc = com.bytedance.msdk.core.tt.u.c().hc(i);
        final JSONObject jSONObject = mapHc.get("event_label_value_root");
        JSONObject jSONObject2 = mapHc.get("config_req_label_value_root");
        com.bytedance.sdk.component.tt.hc.u uVarHc = com.bytedance.msdk.c.hc.d().hc().hc();
        uVarHc.d(com.bytedance.msdk.core.b.d());
        String strGb = com.bytedance.msdk.core.d.mk().gb();
        if (!TextUtils.isEmpty(strGb)) {
            uVarHc.hc("X-Tt-Env", strGb);
            uVarHc.hc("x-use-ppe", "1");
        }
        uVarHc.hc("User-Agent", com.bytedance.msdk.hc.hc.d);
        try {
            JSONObject jSONObjectHc = hc(jSONObject2);
            final boolean z2 = !com.bytedance.msdk.core.hc.hc().c();
            if (z2) {
                uVarHc.hc("x-pglcypher", "4");
                uVarHc.d(MediaTypeUtils.APPLICATION_OCTET_STREAM, fs.hc(jSONObjectHc.toString()));
            } else {
                uVarHc.b(b(jSONObjectHc));
            }
            uVarHc.d(new com.bytedance.sdk.component.tt.d.d() { // from class: com.bytedance.msdk.core.k.hc.3
                @Override // com.bytedance.sdk.component.tt.d.d
                public void d(com.bytedance.sdk.component.tt.hc.c cVar, final com.bytedance.sdk.component.tt.hc hcVar) {
                    an.d(new Runnable() { // from class: com.bytedance.msdk.core.k.hc.3.1
                        /* JADX WARN: Removed duplicated region for block: B:64:0x0248  */
                        /* JADX WARN: Removed duplicated region for block: B:65:0x024a  */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void run() throws org.json.JSONException {
                            /*
                                Method dump skipped, instructions count: 601
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.k.hc.AnonymousClass3.AnonymousClass1.run():void");
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.tt.d.d
                public void d(com.bytedance.sdk.component.tt.hc.c cVar, final IOException iOException) {
                    an.d(new Runnable() { // from class: com.bytedance.msdk.core.k.hc.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.msdk.d.u.b.c("SdkSettingsHelper", "----网络错误，服务器无响应，稍后会尝试重新拉取配置----，setting request failed..." + iOException.getMessage());
                            hc.this.an.set(false);
                            iArr[0] = 0;
                            iArr2[0] = -2;
                            hc.this.d(uVar, i, iArr2[0], "request fail：" + iOException.getMessage(), z2);
                            c.d(iArr[0], iArr2[0], System.currentTimeMillis() - jCurrentTimeMillis, z, i == 0, jSONObject, -1L, null);
                        }
                    });
                }
            });
        } catch (UnsatisfiedLinkError e) {
            mq.d(e);
            com.bytedance.msdk.core.mk.d.d().d(81017, "GM接口请求异常");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int[] iArr, int[] iArr2, com.bytedance.sdk.component.tt.hc hcVar, JSONObject jSONObject, String str, int[] iArr3, u uVar, JSONObject jSONObject2, int i, boolean z, long j) throws Throwable {
        String str2;
        String str3;
        String str4;
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        Map<String, String> mapD = d(hcVar.b());
        if (mapD != null) {
            str3 = mapD.get("active-control");
            str4 = mapD.get(j.s);
            str2 = mapD.get(t.s);
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        String strD = de.d(str + str3 + str4);
        if (!TextUtils.isEmpty(strD) && strD.equalsIgnoreCase(str2)) {
            com.bytedance.msdk.core.hc.hc().c(str3);
        }
        d(jSONObject);
        int iOptInt = jSONObject.optInt("state_code", -80000);
        String strOptString = jSONObject.optString(cm.V);
        if (iOptInt == 20000) {
            iArr[0] = 20000;
        }
        if (iOptInt == 30004) {
            iArr[0] = 30004;
            this.an.set(false);
            this.tt.set(false);
            this.gb.removeCallbacksAndMessages(null);
            this.hc.d(jSONObject);
            d(uVar);
            com.bytedance.msdk.an.b.c();
            d(z, jCurrentTimeMillis);
            return;
        }
        if (iOptInt == 20000 && jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            iArr2[0] = 1;
            iArr[0] = 20000;
            String strC = hcVar.c();
            if (strC != null) {
                iArr3[0] = strC.length();
            }
            this.tt.set(false);
            this.gb.removeCallbacksAndMessages(null);
            this.h.set(true);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.hc.d(jSONObject, false);
            jSONObject2.put("parse_save_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.an.set(false);
            d(uVar);
            com.bytedance.msdk.an.b.c();
            if (com.bytedance.msdk.core.d.mk().uo()) {
                u();
            }
            d(z, jCurrentTimeMillis);
            return;
        }
        if (iOptInt != -80000) {
            iArr[0] = iOptInt;
        }
        if (TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(jSONObject.optString("msg"))) {
            strOptString = jSONObject.optString("msg");
        }
        d(uVar, i, iArr[0], strOptString, z);
    }

    private void d(boolean z, long j) {
        zw.d(z ? "v4Enc_config" : "v2Enc_config", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(u uVar, int i, int i2, String str, boolean z) {
        if (z) {
            try {
                com.bytedance.msdk.core.hc.hc().hc(true);
            } catch (Throwable th) {
                mq.d(th);
                return;
            }
        }
        zw.d(z ? "v4Enc_config" : "v2Enc_config", false, 0L, "code = " + i2 + "，msg = " + str);
        com.bytedance.msdk.d.u.b.c("SdkSettingsHelper", "----拉取配置失败: " + i2 + " msg = " + str);
        d(uVar, new com.bytedance.msdk.api.d(i2, str), i);
        if (com.bytedance.msdk.core.hc.hc().zw()) {
            return;
        }
        com.bytedance.msdk.core.mk.d.d().d(i2, "聚合config请求失败 code = " + i2 + " msg = " + str);
    }

    public static String d(Throwable th) throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                String string = stringWriter.toString();
                try {
                    stringWriter.close();
                } catch (IOException unused) {
                }
                printWriter.close();
                return string;
            } catch (Exception unused2) {
                stringWriter.close();
                printWriter.close();
                return null;
            } catch (Throwable th2) {
                try {
                    stringWriter.close();
                } catch (IOException unused3) {
                }
                printWriter.close();
                throw th2;
            }
        } catch (IOException unused4) {
            printWriter.close();
            return null;
        }
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                com.bytedance.msdk.d.u.b.d();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject hc(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(j.s, System.currentTimeMillis());
            jSONObject2.put("media_sdk_version", com.bytedance.msdk.hc.hc.hc());
            jSONObject2.put(ILogConst.Keys.KEY_PLUGIN_VERSION, com.bytedance.msdk.hc.hc.c());
            jSONObject2.put("is_fusion", 1);
            jSONObject2.put(com.alipay.sdk.m.k.b.D0, com.bytedance.msdk.core.d.mk().mq());
            jSONObject2.put(n.p, fs.d());
            jSONObject2.put("app_version", fs.b());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("android_id", np.c());
            jSONObject3.put(g.z, np.sy());
            jSONObject3.put("imei_md5", de.d(np.sy()));
            jSONObject3.put("oaid", np.hc());
            jSONObject3.put(Config.GAID, com.bytedance.msdk.gb.gb.d().hc());
            jSONObject3.put("applog_did", np.d());
            jSONObject3.put("publisher_did", com.bytedance.msdk.core.d.mk().yo());
            jSONObject3.put("conn_type", np.u());
            jSONObject3.put("os", np.uo());
            jSONObject3.put("os_version", np.k());
            jSONObject3.put("vendor", np.w());
            jSONObject3.put("device_model", np.h());
            jSONObject3.put("mcc", np.mk());
            jSONObject3.put("mnc", np.mq());
            jSONObject3.put("time_zone", np.yo());
            jSONObject3.put("ip", np.de());
            jSONObject3.put("locale_language", np.tc());
            jSONObject3.put("total_space", np.cb());
            jSONObject3.put("carrier_name", np.jh());
            jSONObject3.put(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME, np.gb());
            jSONObject3.put("pb", "");
            jSONObject3.put("boot", np.rf());
            jSONObject3.put("country_code", com.bytedance.msdk.core.hc.hc().gb());
            jSONObject3.put("total_mem", np.e());
            jSONObject3.put("device_type", np.h());
            jSONObject3.put("language", np.tt());
            jSONObject3.put("android_os_version_int", Build.VERSION.SDK_INT);
            jSONObject2.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("init_time", com.bytedance.msdk.core.d.mk().b());
            jSONObject2.put(PointCategory.APP, jSONObject4);
            jSONObject2.put("grouping_params", hc());
            JSONObject jSONObjectB = b();
            if (jSONObjectB != null) {
                jSONObject2.put("user_defined_grouping_params", jSONObjectB);
            }
            if (!com.bytedance.msdk.core.d.mk().h()) {
                jSONObject2.put("etag", com.bytedance.msdk.core.hc.hc().tc());
            }
            if (com.bytedance.msdk.gb.an.d(this.b) != null) {
                jSONObject2.put("latitude", r1.d);
                jSONObject2.put("longitude", r1.hc);
            }
            jSONObject2.put("adn_version_list", h());
            com.bytedance.msdk.core.tt.u.c().d(jSONObject2, jSONObject);
            com.bytedance.msdk.core.tt.u.c().d(jSONObject2);
            List<String> listFs = com.bytedance.msdk.core.d.mk().fs();
            if (listFs != null && listFs.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = listFs.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("primerit_list", jSONArray);
            }
            if (!e.d()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("err_type", 1);
                jSONObject5.put("err_msg", "applog so加载失败");
                jSONObject2.put("monitor_alarm", jSONObject5);
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return jSONObject2;
    }

    public static JSONObject hc() throws JSONException {
        String strHc;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.c.an anVarZw = com.bytedance.msdk.core.d.mk().zw();
        if (anVarZw != null) {
            try {
                strHc = anVarZw.hc();
            } catch (JSONException e) {
                mq.d(e);
            }
        } else {
            strHc = "";
        }
        jSONObject.put("user_id", strHc);
        jSONObject.put("channel", anVarZw != null ? anVarZw.b() : "");
        jSONObject.put("sub_channel", anVarZw != null ? anVarZw.c() : "");
        jSONObject.put(FeedSurveyManager.KEY_AGE, anVarZw != null ? anVarZw.u() : 0);
        jSONObject.put(FeedSurveyManager.KEY_GENDER, anVarZw != null ? anVarZw.an() : "");
        jSONObject.put("user_value_group", anVarZw != null ? anVarZw.h() : "");
        return jSONObject;
    }

    public static JSONObject b() {
        Map<String, String> mapD;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.c.an anVarZw = com.bytedance.msdk.core.d.mk().zw();
        if (anVarZw != null && (mapD = anVarZw.d()) != null) {
            try {
                for (String str : mapD.keySet()) {
                    jSONObject.put(str, mapD.get(str));
                }
                return jSONObject;
            } catch (Exception e) {
                mq.d(e);
            }
        }
        return null;
    }

    private JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.an.hc.hc.d();
        List<String> listGb = gb();
        if (listGb != null) {
            for (String str : listGb) {
                com.bytedance.msdk.d.d.c cVarD = com.bytedance.msdk.an.hc.hc.d().d(str);
                if (cVarD != null) {
                    try {
                        jSONObject.put(str, cVarD.hc());
                    } catch (JSONException e) {
                        mq.d(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    private static List<String> gb() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("pangle");
        arrayList.add("gdt");
        arrayList.add("admob");
        arrayList.add("unity");
        arrayList.add(AdnName.BAIDU);
        arrayList.add("sigmob");
        arrayList.add("mintegral");
        arrayList.add("ks");
        arrayList.add("klevin");
        arrayList.add("xiaomi");
        return arrayList;
    }

    private String b(JSONObject jSONObject) {
        JSONObject jSONObjectD = fs.d(jSONObject);
        if (jSONObjectD != null) {
            return jSONObjectD.toString();
        }
        return null;
    }

    @Override // com.bytedance.msdk.d.u.gb.d
    public void d(Message message) {
        if (message.what != 1) {
            return;
        }
        int i = message.arg1;
        int i2 = message.arg2;
        if (i == 3) {
            this.tt.set(false);
        }
        com.bytedance.msdk.d.u.b.c("SdkSettingsHelper", "setting 发起尝试拉取配置请求... mLoadingSuccess:" + this.h.get() + "tryCount:" + (i + 1));
        try {
            if (this.h.get()) {
                return;
            }
            b(i2);
        } catch (Throwable unused) {
        }
    }
}
