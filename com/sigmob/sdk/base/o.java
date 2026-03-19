package com.sigmob.sdk.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.t;
import com.sigmob.sdk.base.models.config.SigmobAndroid;
import com.sigmob.sdk.base.models.config.SigmobCommon;
import com.sigmob.sdk.base.models.config.SigmobCommonEndpointsConfig;
import com.sigmob.sdk.base.models.config.SigmobDialogSetting;
import com.sigmob.sdk.base.models.config.SigmobNativeConfig;
import com.sigmob.sdk.base.models.config.SigmobRvConfig;
import com.sigmob.sdk.base.models.config.SigmobSdkConfig;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigResponse;
import com.sigmob.sdk.base.models.config.SigmobSplashConfig;
import com.sigmob.sdk.base.network.f;
import com.sigmob.windad.WindAds;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class o {
    public static Boolean a = null;
    private static final String b = "sdkConfigVer";
    private static o c = null;
    private static boolean d = false;
    private static String m = null;
    private static boolean n = false;
    private a l;
    private final String g = n.k;
    private long i = 0;
    private SigmobSdkConfig j = null;
    private SigmobSdkConfig k = null;
    private final Handler e = new Handler(Looper.getMainLooper());
    private final Runnable f = new Runnable() { // from class: com.sigmob.sdk.base.o$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.al();
        }
    };
    private final boolean h = true;

    /* renamed from: com.sigmob.sdk.base.o$1, reason: invalid class name */
    class AnonymousClass1 implements f.a {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(SigmobSdkConfig sigmobSdkConfig) {
            o.this.a(sigmobSdkConfig, true);
        }

        @Override // com.sigmob.sdk.base.network.f.a
        public void a(SigmobSdkConfigResponse sdkConfigResponse) throws Throwable {
            boolean unused = o.n = false;
            SigmobLog.d(sdkConfigResponse.toString());
            final SigmobSdkConfig sigmobSdkConfig = sdkConfigResponse.config;
            if (sigmobSdkConfig == null) {
                SigmobLog.e(sdkConfigResponse.error_message);
            } else {
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.o$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(sigmobSdkConfig);
                    }
                });
                o.this.a(sigmobSdkConfig);
            }
            o.this.as();
        }

        public void onErrorResponse(VolleyError error) {
            String unused = o.m = o.this.ao();
            if (o.n) {
                o.this.as();
            } else {
                boolean unused2 = o.n = true;
                o.this.e.post(o.this.f);
            }
            SigmobLog.e(error.toString());
        }
    }

    public interface a {
        void onUpdate(boolean isOnline);
    }

    private o() {
        ak();
    }

    public static synchronized o a() {
        if (c == null) {
            c = new o();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0063 -> B:32:0x006a). Please report as a decompilation issue!!! */
    public void a(SigmobSdkConfig sigmobSdkConfig) throws Throwable {
        if (sigmobSdkConfig == null) {
            return;
        }
        File file = new File(com.sigmob.sdk.base.utils.i.a() + "/config");
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        ObjectOutputStream objectOutputStream = null;
        try {
        } catch (IOException e) {
            SigmobLog.e(e.getMessage());
        }
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
                try {
                    sigmobSdkConfig.encode(objectOutputStream2);
                    com.sigmob.sdk.base.utils.p.b(com.sigmob.sdk.b.e(), (String) null, b, n.k);
                    objectOutputStream2.close();
                } catch (IOException e2) {
                    e = e2;
                    objectOutputStream = objectOutputStream2;
                    SigmobLog.e(e.getMessage());
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e3) {
                            SigmobLog.e(e3.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SigmobSdkConfig config, boolean isOnline) {
        if (config == null || config.sigmobCommon_config == null) {
            return;
        }
        this.k = config;
        this.i = ((Integer) Wire.get(config.sigmobCommon_config.configRefresh, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_MASK_DELAY_LOADING))).intValue() * 1000;
        int iK = k();
        if (iK <= 0) {
            com.sigmob.sdk.manager.d.a().c();
        } else {
            com.sigmob.sdk.manager.d.a().a(iK);
        }
        SigmobLog.d("config: " + config);
        a aVar = this.l;
        if (aVar != null) {
            aVar.onUpdate(isOnline);
        }
        Config.sharedInstance().setEnable_okhttp3(ac());
        Config.sharedInstance().setNetworkTimeout(ap());
        Config.sharedInstance().update(d, af(), ab(), X(), r(), K(), J(), am());
        TrackManager.getInstance().setRetryInterval(I());
        TrackManager.getInstance().setRetryExpiredTime(H());
    }

    private void ak() {
        if (this.j == null) {
            SigmobSdkConfig.Builder builder = new SigmobSdkConfig.Builder();
            SigmobCommon.Builder builder2 = new SigmobCommon.Builder();
            SigmobAndroid.Builder builder3 = new SigmobAndroid.Builder();
            SigmobCommonEndpointsConfig.Builder builder4 = new SigmobCommonEndpointsConfig.Builder();
            builder4.native_ad(t());
            builder2.endpoints(builder4.build());
            SigmobRvConfig.Builder builder5 = new SigmobRvConfig.Builder();
            builder5.cacheTop(4);
            builder2.rv_config(builder5.build());
            builder2.configRefresh(1000);
            builder2.disable_up_location(false);
            builder2.is_gdpr_region(false);
            builder2.enable_debug_level(false);
            builder3.disable_boot_mark(true);
            builder3.disableUpAppInfo(true);
            builder3.oaid_api_is_disable(true);
            builder3.enable_permission(false);
            builder3.enable_report_crash(false);
            builder.common_config(builder2.build());
            builder.android_config(builder3.build());
            this.j = builder.build();
        }
        SigmobLog.d("Default config: " + this.j.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (com.sigmob.sdk.b.e() == null) {
            return;
        }
        if (ClientMetadata.getInstance().isNetworkConnected(c()) && i.a().i()) {
            an();
        } else {
            SigmobLog.d("Can't load an ad because there is no network connectivity.");
            as();
        }
    }

    private boolean am() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobCommonP.log_enc, false)).booleanValue();
    }

    private void an() {
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        com.sigmob.sdk.base.network.f fVar = new com.sigmob.sdk.base.network.f(c(), new AnonymousClass1());
        if (sigRequestQueue == null) {
            SigmobLog.e("queue is null");
            as();
        } else {
            sigRequestQueue.add(fVar);
            SigmobLog.i("update sdk config");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ao() {
        SigmobCommon sigmobCommonP = p();
        return (sigmobCommonP == null || sigmobCommonP.endpoints == null) ? "" : (String) Wire.get(sigmobCommonP.endpoints.config, "https://c.etoolads.cn/s/config");
    }

    private int ap() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return 0;
        }
        return ((Integer) Wire.get(sigmobCommonP.network_timeout, 0)).intValue();
    }

    private boolean aq() {
        if (!com.sigmob.sdk.base.utils.n.b((Object) a)) {
            SigmobCommon sigmobCommonP = p();
            if (sigmobCommonP == null) {
                return false;
            }
            a = (Boolean) Wire.get(sigmobCommonP.noncompliance_mark, false);
            SigmobLog.d("noncomplianceMark(config) = " + a);
        }
        return a.booleanValue();
    }

    private void ar() {
        this.e.removeCallbacks(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as() {
        ar();
        if (this.h) {
            this.e.postDelayed(this.f, Math.max(30000L, this.i));
        }
    }

    private SigmobSplashConfig at() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return null;
        }
        return sigmobCommonP.splash_config;
    }

    private SigmobNativeConfig au() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return null;
        }
        return sigmobCommonP.native_config;
    }

    public static String b() {
        return "appId=" + WindAds.sharedAds().getAppId() + com.alipay.sdk.m.s.a.n + "sdkVersion=4.24.0";
    }

    public static String c() {
        StringBuilder sb;
        String str = "?";
        if (TextUtils.isEmpty(m)) {
            if (TextUtils.isEmpty("https://adservice.sigmob.cn/s/config")) {
                sb = new StringBuilder();
                str = "https://adservice.sigmob.cn/s/config?";
            } else {
                sb = new StringBuilder().append("https://adservice.sigmob.cn/s/config");
            }
        } else if (m.indexOf(63) == -1) {
            sb = new StringBuilder().append(m);
        } else {
            sb = new StringBuilder().append(m);
            str = com.alipay.sdk.m.s.a.n;
        }
        return sb.append(str).append(b()).toString();
    }

    public static String d() {
        return "https://adservice.sigmob.cn/extconfig?" + b();
    }

    public static boolean n() {
        return d;
    }

    public long A() {
        SigmobSplashConfig sigmobSplashConfigAt = at();
        int iIntValue = sigmobSplashConfigAt != null ? ((Integer) Wire.get(sigmobSplashConfigAt.material_expired_time, 2)).intValue() : 2;
        return iIntValue < 0 ? iIntValue : iIntValue * 24 * 60 * 60 * 1000;
    }

    public int B() {
        SigmobNativeConfig sigmobNativeConfigAu = au();
        if (sigmobNativeConfigAu == null) {
            return 50;
        }
        return ((Integer) Wire.get(sigmobNativeConfigAu.cacheTop, 50)).intValue();
    }

    public long C() {
        SigmobNativeConfig sigmobNativeConfigAu = au();
        if (sigmobNativeConfigAu == null) {
            return 45000L;
        }
        int iIntValue = ((Integer) Wire.get(sigmobNativeConfigAu.ad_load_timeout, 45)).intValue();
        if (iIntValue < 10) {
            iIntValue = 10;
        }
        return iIntValue * 1000;
    }

    public boolean D() {
        SigmobCommon sigmobCommonP = p();
        return (sigmobCommonP == null || sigmobCommonP.anti_fraud_log == null || sigmobCommonP.anti_fraud_log.events == null) ? false : true;
    }

    public int E() {
        SigmobCommon sigmobCommonP = p();
        if (!D() || sigmobCommonP.anti_fraud_log.motion_config == null) {
            return 0;
        }
        return ((Integer) Wire.get(sigmobCommonP.anti_fraud_log.motion_config.interval, 0)).intValue();
    }

    public int F() {
        if (!D() || p().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return ((Integer) Wire.get(p().anti_fraud_log.motion_config.count, 0)).intValue();
    }

    public int G() {
        if (!D() || p().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return p().anti_fraud_log.motion_config.queue_max.intValue() + (-50) < p().anti_fraud_log.motion_config.count.intValue() * 2 ? (((Integer) Wire.get(p().anti_fraud_log.motion_config.count, 0)).intValue() * 2) + 50 : ((Integer) Wire.get(p().anti_fraud_log.motion_config.queue_max, 0)).intValue();
    }

    public long H() {
        long jIntValue = p() != null ? ((Integer) Wire.get(p().tracking_expiration_time, 86400)).intValue() : 86400L;
        if (jIntValue < 180) {
            return 180L;
        }
        return jIntValue;
    }

    public int I() {
        int iIntValue = p() != null ? ((Integer) Wire.get(p().tracking_retry_interval, 180)).intValue() : 180;
        if (iIntValue < 10) {
            return 10;
        }
        return iIntValue;
    }

    public int J() {
        int iIntValue = SigmobCommon.DEFAULT_MAX_SEND_LOG_RECORDS.intValue();
        if (p() != null) {
            iIntValue = ((Integer) Wire.get(p().max_send_log_records, SigmobCommon.DEFAULT_MAX_SEND_LOG_RECORDS)).intValue();
        }
        return iIntValue < 10 ? SigmobCommon.DEFAULT_MAX_SEND_LOG_RECORDS.intValue() : iIntValue;
    }

    public int K() {
        int iIntValue;
        if (p() == null || (iIntValue = ((Integer) Wire.get(p().send_log_interval, 3)).intValue()) < 3) {
            return 3;
        }
        return iIntValue;
    }

    public boolean L() {
        SigmobAndroid sigmobAndroidQ;
        if (j() || (sigmobAndroidQ = q()) == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.enable_open_pkg_list, false)).booleanValue();
    }

    public boolean M() {
        SigmobAndroid sigmobAndroidQ;
        if (j() || (sigmobAndroidQ = q()) == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.enable_open_pkg_dir_list, false)).booleanValue();
    }

    public Boolean N() {
        o oVarA = a();
        return Boolean.valueOf(oVarA.L() || oVarA.M());
    }

    public List<Integer> O() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return null;
        }
        return sigmobCommonP.dclog_blacklist;
    }

    public boolean P() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobCommonP.enable_debug_level, false)).booleanValue();
    }

    public long Q() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return 0L;
        }
        long jIntValue = ((Integer) Wire.get(sigmobCommonP.load_interval, 0)).intValue();
        if (jIntValue < 1) {
            return 0L;
        }
        return jIntValue * 1000;
    }

    public String R() {
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig;
        StringBuilder sbAppend;
        String str;
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null || (sigmobCommonEndpointsConfig = sigmobCommonP.endpoints) == null) {
            return "";
        }
        String str2 = (String) Wire.get(sigmobCommonEndpointsConfig.native_ad, "");
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (str2.indexOf(63) == -1) {
            sbAppend = new StringBuilder().append(str2);
            str = "?";
        } else {
            sbAppend = new StringBuilder().append(str2);
            str = com.alipay.sdk.m.s.a.n;
        }
        return sbAppend.append(str).append(b()).toString();
    }

    public boolean S() {
        SigmobCommon sigmobCommonP;
        if (j() || (sigmobCommonP = p()) == null) {
            return true;
        }
        return ((Boolean) Wire.get(sigmobCommonP.disable_up_location, false)).booleanValue();
    }

    public boolean T() {
        SigmobAndroid sigmobAndroidQ;
        if (j() || (sigmobAndroidQ = q()) == null) {
            return true;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.disableUpAppInfo, false)).booleanValue();
    }

    public int U() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return 0;
        }
        return ((Integer) Wire.get(sigmobAndroidQ.report_log, 0)).intValue();
    }

    public List<String> V() {
        SigmobAndroid sigmobAndroidQ = q();
        return sigmobAndroidQ == null ? Collections.emptyList() : sigmobAndroidQ.open_pkg_list;
    }

    public boolean W() {
        SigmobAndroid sigmobAndroidQ = q();
        return sigmobAndroidQ != null && ((Integer) Wire.get(sigmobAndroidQ.up_wifi_list_interval, 0)).intValue() >= 60;
    }

    public int X() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return 0;
        }
        return ((Integer) Wire.get(sigmobAndroidQ.disable_up_oaid, 0)).intValue();
    }

    public boolean Y() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.enable_permission, false)).booleanValue();
    }

    public int Z() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return 0;
        }
        return ((Integer) Wire.get(sigmobAndroidQ.apk_expired_time, 0)).intValue();
    }

    public o a(a onSDKUpdateListener) {
        this.l = onSDKUpdateListener;
        return c;
    }

    public boolean a(String key) {
        SigmobCommon sigmobCommonP = p();
        if (!D() || sigmobCommonP.anti_fraud_log.events == null) {
            return false;
        }
        return sigmobCommonP.anti_fraud_log.events.contains(key);
    }

    public boolean aa() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.enable_report_crash, false)).booleanValue();
    }

    public boolean ab() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return true;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.oaid_api_is_disable, false)).booleanValue();
    }

    public boolean ac() {
        return false;
    }

    public boolean ad() {
        SigmobAndroid sigmobAndroidQ;
        if (j() || (sigmobAndroidQ = q()) == null) {
            return true;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.disable_install_monitor, false)).booleanValue();
    }

    public int ae() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return 0;
        }
        return ((Integer) Wire.get(sigmobAndroidQ.enable_app_list, 0)).intValue();
    }

    public boolean af() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return true;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.disable_boot_mark, false)).booleanValue();
    }

    public boolean ag() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.use_web_source_cache, false)).booleanValue();
    }

    public boolean ah() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobCommonP.enable_extra_dclog, false)).booleanValue();
    }

    public int ai() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return 0;
        }
        return ((Integer) Wire.get(sigmobAndroidQ.web_source_cache_expiration_time, 0)).intValue();
    }

    public Boolean b(String packageName) {
        boolean zB;
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        Context contextE = com.sigmob.sdk.b.e();
        boolean zL = L();
        boolean zM = M();
        if (zL) {
            zB = t.a(contextE, packageName);
        } else {
            if (!zM) {
                return false;
            }
            zB = t.b(contextE, packageName);
        }
        return Boolean.valueOf(zB);
    }

    public void e() {
        Throwable th;
        ObjectInputStream objectInputStream;
        String strA = com.sigmob.sdk.base.utils.p.a(com.sigmob.sdk.b.e(), (String) null, b, (String) null);
        File file = new File(com.sigmob.sdk.base.utils.i.a() + "/config");
        if (n.k.equals(strA)) {
            try {
                if (file.exists()) {
                    try {
                        objectInputStream = new ObjectInputStream(new FileInputStream(file));
                        try {
                            a((SigmobSdkConfig) SigmobSdkConfig.ADAPTER.decode(objectInputStream), false);
                            objectInputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                a(this.j, false);
                                SigmobLog.e(th.getMessage());
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th3) {
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Throwable th4) {
                                        SigmobLog.e(th4.getMessage());
                                    }
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        objectInputStream = null;
                    }
                    return;
                }
            } catch (Throwable th6) {
                SigmobLog.e(th6.getMessage());
                return;
            }
        }
        a(this.j, false);
    }

    public void f() {
        ar();
        this.e.post(this.f);
    }

    public boolean g() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobCommonP.feedback_debug, false)).booleanValue();
    }

    public boolean h() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.lock_play, false)).booleanValue();
    }

    public boolean i() {
        SigmobAndroid sigmobAndroidQ = q();
        if (sigmobAndroidQ == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobAndroidQ.screen_keep, false)).booleanValue();
    }

    public boolean j() {
        return !aq();
    }

    public int k() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return 0;
        }
        int iIntValue = ((Integer) Wire.get(sigmobCommonP.expire_monitor_interval, 0)).intValue();
        SigmobLog.d("expireMonitorInterval = " + iIntValue);
        return iIntValue;
    }

    public boolean l() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return false;
        }
        return ((Boolean) Wire.get(sigmobCommonP.enable_active_expire, false)).booleanValue();
    }

    public int m() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return 0;
        }
        Integer num = (Integer) Wire.get(sigmobCommonP.sniffing_type, 0);
        SigmobLog.d("sniffingType = " + num);
        return num.intValue();
    }

    public SigmobSdkConfig o() {
        SigmobSdkConfig sigmobSdkConfig = this.k;
        return sigmobSdkConfig == null ? this.j : sigmobSdkConfig;
    }

    public SigmobCommon p() {
        SigmobSdkConfig sigmobSdkConfigO = o();
        if (sigmobSdkConfigO == null) {
            return null;
        }
        return sigmobSdkConfigO.sigmobCommon_config;
    }

    public SigmobAndroid q() {
        SigmobSdkConfig sigmobSdkConfigO = o();
        if (sigmobSdkConfigO == null) {
            return null;
        }
        return sigmobSdkConfigO.sigmobAndroid_config;
    }

    public String r() {
        StringBuilder sbAppend;
        String str;
        String str2 = p().endpoints.log;
        if (TextUtils.isEmpty(str2)) {
            str2 = "https://dc.sigmob.cn/log";
        }
        if (str2.indexOf(63) == -1) {
            sbAppend = new StringBuilder().append(str2);
            str = "?";
        } else {
            sbAppend = new StringBuilder().append(str2);
            str = com.alipay.sdk.m.s.a.n;
        }
        return sbAppend.append(str).append(b()).toString();
    }

    public String s() {
        StringBuilder sbAppend;
        String str;
        String str2 = (String) Wire.get(p().endpoints.feedback, "https://adxtool.sigmob.cn/debug/feedback");
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (str2.indexOf(63) == -1) {
            sbAppend = new StringBuilder().append(str2);
            str = "?";
        } else {
            sbAppend = new StringBuilder().append(str2);
            str = com.alipay.sdk.m.s.a.n;
        }
        return sbAppend.append(str).append(b()).toString();
    }

    public String t() {
        StringBuilder sbAppend;
        String str;
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig;
        SigmobCommon sigmobCommonP = p();
        String str2 = (sigmobCommonP == null || (sigmobCommonEndpointsConfig = sigmobCommonP.endpoints) == null) ? "" : sigmobCommonEndpointsConfig.ads;
        if (TextUtils.isEmpty(str2)) {
            str2 = "https://adservice.sigmob.cn/ad/v4";
        }
        if (str2.indexOf(63) == -1) {
            sbAppend = new StringBuilder().append(str2);
            str = "?";
        } else {
            sbAppend = new StringBuilder().append(str2);
            str = com.alipay.sdk.m.s.a.n;
        }
        return sbAppend.append(str).append(b()).toString();
    }

    public String u() {
        StringBuilder sbAppend;
        String str;
        String str2 = p().endpoints.hb_ads;
        if (TextUtils.isEmpty(str2)) {
            str2 = "https://adservice.sigmob.cn/hb/v2/ad";
        }
        if (str2.indexOf(63) == -1) {
            sbAppend = new StringBuilder().append(str2);
            str = "?";
        } else {
            sbAppend = new StringBuilder().append(str2);
            str = com.alipay.sdk.m.s.a.n;
        }
        return sbAppend.append(str).append(b()).toString();
    }

    public SigmobRvConfig v() {
        SigmobCommon sigmobCommonP = p();
        if (sigmobCommonP == null) {
            return null;
        }
        return sigmobCommonP.rv_config;
    }

    public int w() {
        SigmobRvConfig sigmobRvConfigV = v();
        if (sigmobRvConfigV == null) {
            return 5;
        }
        return ((Integer) Wire.get(sigmobRvConfigV.cacheTop, 5)).intValue();
    }

    public long x() {
        SigmobRvConfig sigmobRvConfigV = v();
        if (sigmobRvConfigV == null) {
            return 45000L;
        }
        int iIntValue = ((Integer) Wire.get(sigmobRvConfigV.ad_load_timeout, 45)).intValue();
        if (iIntValue < 10) {
            iIntValue = 10;
        }
        return iIntValue * 1000;
    }

    public SigmobDialogSetting y() {
        SigmobRvConfig sigmobRvConfigV = v();
        if (sigmobRvConfigV == null) {
            return null;
        }
        return sigmobRvConfigV.close_dialog_setting;
    }

    public int z() {
        SigmobSplashConfig sigmobSplashConfigAt = at();
        if (sigmobSplashConfigAt == null) {
            return 50;
        }
        return ((Integer) Wire.get(sigmobSplashConfigAt.cacheTop, 50)).intValue();
    }
}
